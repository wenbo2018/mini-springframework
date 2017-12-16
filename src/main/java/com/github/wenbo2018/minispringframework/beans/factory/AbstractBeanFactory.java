package com.github.wenbo2018.minispringframework.beans.factory;

import com.github.wenbo2018.minispringframework.beans.BeanDefinition;
import com.github.wenbo2018.minispringframework.beans.BeanPostProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wenbo.shen on 2017/12/10.
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    private final List<String> beanDefinitionNames = new ArrayList<String>();

    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();


    @Override
    public Object getBean(String name) throws Exception {
        return doGetBean(name);
    }

    public Object doGetBean(String name) {
        return null;
    }

    protected abstract Object initializeBean(Object bean, String name);

    protected abstract Object doCreateBean(BeanDefinition beanDefinition);

}
