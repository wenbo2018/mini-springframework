package com.github.wenbo2018.minispringframework.beans;

/**
 * Created by wenbo.shen on 2017/12/16.
 */
public class BeanDefinitionHolder {



    private final BeanDefinition beanDefinition;

    private final String beanName;


    public BeanDefinitionHolder(BeanDefinition beanDefinition, String beanName) {
        this.beanDefinition = beanDefinition;
        this.beanName = beanName;
    }

    public BeanDefinition getBeanDefinition() {
        return beanDefinition;
    }

    public String getBeanName() {
        return beanName;
    }
}
