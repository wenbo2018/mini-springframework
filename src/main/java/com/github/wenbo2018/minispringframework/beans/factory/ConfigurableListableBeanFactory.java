package com.github.wenbo2018.minispringframework.beans.factory;

import com.github.wenbo2018.minispringframework.beans.BeanDefinition;
import com.github.wenbo2018.minispringframework.except.BeanDefinitionStoreException;
import com.github.wenbo2018.minispringframework.support.BeanDefinitionRegistry;

/**
 * Created by wenbo.shen on 2017/12/16.
 */
public class ConfigurableListableBeanFactory extends AbstractBeanFactory implements BeanDefinitionRegistry {

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        BeanDefinition oldBeanDefinition = beanDefinitionMap.get(beanName);

        if (oldBeanDefinition != null) {
            throw new BeanDefinitionStoreException(beanName + "is exist");
        }
        if (beanDefinitionMap.containsKey(beanName)) {
            beanDefinitionMap.remove(beanName);
        }
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
