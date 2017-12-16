package com.github.wenbo2018.minispringframework.support;

import com.github.wenbo2018.minispringframework.beans.BeanDefinition;

/**
 * Created by wenbo.shen on 2017/12/16.
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
