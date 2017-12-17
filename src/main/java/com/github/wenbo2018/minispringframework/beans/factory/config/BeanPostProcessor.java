package com.github.wenbo2018.minispringframework.beans.factory.config;

/**
 * Created by wenbo.shen on 2017/12/16.
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName);

    Object postProcessAfterInitialization(Object bean, String beanName);

}
