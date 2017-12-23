package com.github.wenbo2018.minispringframework.beans.factory;

import com.github.wenbo2018.minispringframework.beans.BeanDefinition;
import com.github.wenbo2018.minispringframework.beans.factory.config.BeanPostProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wenbo.shen on 2017/12/10.
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    protected final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(256);

    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>(256);

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();


    @Override
    public Object getBean(String name) throws Exception {
        return doGetBean(name);
    }

    public Object doGetBean(String beanName) throws Exception {
        Object bean;
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("Bean named " + beanName + " is not defined");
        }
        Object sharedInstance = singletonObjects.get(beanName);
        if (sharedInstance != null) {
            bean = getObjectForBeanInstance();
            return bean;
        }
        sharedInstance = createBean(beanName, beanDefinition);
        return sharedInstance;
    }

    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) throws Exception {
        this.beanPostProcessors.add(beanPostProcessor);
    }


    private Object getObjectForBeanInstance() {
        return null;
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws Exception;

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return beanPostProcessors;
    }
}
