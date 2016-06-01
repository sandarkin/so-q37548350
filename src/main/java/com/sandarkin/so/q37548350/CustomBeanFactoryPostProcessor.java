package com.sandarkin.so.q37548350;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * A processor that creates beans at runtime.
 */
@Component
public class CustomBeanFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor {
  @Override
  public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
    Reflections reflections = new Reflections("com.sandarkin.so.q37548350.shapes", new SubTypesScanner(false));
    Set<Class<?>> allClasses = reflections.getSubTypesOf(Object.class);
    for (Class clazz : allClasses) {
      GenericBeanDefinition gbd = new GenericBeanDefinition();
      gbd.setBeanClass(clazz);
      gbd.setAttribute("attributeName", "attributeValue");
      registry.registerBeanDefinition(clazz.getSimpleName() + "_Bean", gbd);
    }
  }

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    // Custom post process the existing bean definitions
  }
}
