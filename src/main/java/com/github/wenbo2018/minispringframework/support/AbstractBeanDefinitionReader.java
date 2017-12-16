package com.github.wenbo2018.minispringframework.support;

/**
 * Created by wenbo.shen on 2017/12/16.
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    protected final BeanDefinitionRegistry registry;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }
}
