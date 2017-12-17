package com.github.wenbo2018.minispringframework.beans.factory;

import com.github.wenbo2018.minispringframework.beans.BeanDefinition;

/**
 * Created by wenbo.shen on 2017/12/16.
 */
public class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
//        //调用BeanPostProcessor的初始化前方法
//        Object bean = resolveBeforeInstantiation(beanName, BeanDefinition beanDefinition);
//        if (bean != null) {
//            return bean;
//        }
//        return null;
        return doCreateBean(beanName, beanDefinition);
    }

    private Object doCreateBean(String beanName, BeanDefinition beanDefinition) {
        Object beanInstance = createBeanInstance(String beanName, BeanDefinition beanDefinition);
        initializeBean(beanName, beanInstance, beanDefinition)
        return null;
    }


    protected Object initializeBean(final String beanName, final Object bean, BeanDefinition beanDefinition) {

        //调用BeanPostProcessor的初始化前方法
        applyBeanPostProcessorsBeforeInitialization();
        //调用afterPropertiesSet方法
        invokeAfterPropertiesSetMethod();
        //调用自定义init方法
        invokeInitMethods(beanName, wrappedBean, mbd);
        //调用BeanPostProcessor的初始化后方法
        applyBeanPostProcessorsAfterInitialization();
    }

    /****
     * 默认调用反射创建
     * @param beanName
     * @param beanDefinition
     * @return
     */
    private Object createBeanInstance(String beanName, BeanDefinition beanDefinition) {

    }

    private Object applyBeanPostProcessorsBeforeInitialization(String beanName, BeanDefinition beanDefinition) {

    }

    private Object applyBeanPostProcessorsAfterInitialization(String beanName, BeanDefinition beanDefinition) {

    }

}
