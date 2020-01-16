package com.leichu.spring.learn.mybatis.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;
import java.util.stream.Collectors;

public class MyMapperScannerRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// 获取到 自定义的 MyMapperScan 注解信息
		AnnotationAttributes mapperScanAttrs = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(MyMapperScan.class.getName()));
		if (mapperScanAttrs == null) {
			return;
		}
		// 获取要扫描的包名
		List<String> basePackages = Arrays.stream(mapperScanAttrs.getStringArray("value")).filter(StringUtils::hasText).collect(Collectors.toList());
		if (CollectionUtils.isEmpty(basePackages)) {
			return;
		}
		// 通过包名，获取到 .class 文件以及 生成对应的类信息
		String packageName = basePackages.get(0);
		List<Object> mappers = new ArrayList<>();// 假设已经获取到包下所有的mapper类
		Map<String, Object> map = null;
		try {
			map = resolveClazz(packageName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Map.Entry<String, Object> entry : map.entrySet()) {

			BeanDefinition definition = new RootBeanDefinition(entry.getValue().getClass());
			registry.registerBeanDefinition(entry.getKey(), definition);

		}
//		if (!registry.containsBeanDefinition("student")) {
//			BeanDefinition definition = new RootBeanDefinition(Student.class);
//			registry.registerBeanDefinition("student", definition);
//		}
	}

	private Map<String, Object> resolveClazz(String packageName) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
		String packagePath = packageName.replaceAll("\\.", "/");
		Enumeration<URL>  enumeration = Thread.currentThread().getContextClassLoader().getResources(packagePath);
		Map<String, Object> map = new HashMap<>();
		while (enumeration.hasMoreElements()) {
			URL url = enumeration.nextElement();
			String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
			File[] files = new File(filePath).listFiles();
			for (File file : files) {
				System.out.println(file.getAbsolutePath());
				String clazzName = file.getName().replace(".class", "");
				String fullName = packageName + "." + clazzName;
				Class<?> clazz = Class.forName(fullName); // 此处获取的接口，要通过动态代理将此接口实例化
//				map.put(clazzName, clazz.newInstance());
				Object obj = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new MyMapperInvocationHandler(clazz));
				map.put(clazzName, obj);
			}
		}
		return map;
	}
}
