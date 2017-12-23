package com.github.wenbo2018.minispringframework.beans.factory;

import com.github.wenbo2018.minispringframework.beans.BeanDefinition;
import com.github.wenbo2018.minispringframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

/**
 * Created by wenbo.shen on 2017/12/16.
 */
public class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws Exception {
//        //调用BeanPostProcessor的初始化前方法
//        Object bean = resolveBeforeInstantiation(beanName, BeanDefinition beanDefinition);
//        if (bean != null) {
//            return bean;
//        }
//        return null;
        return doCreateBean(beanName, beanDefinition);
    }

    private Object doCreateBean(String beanName, BeanDefinition beanDefinition) throws Exception {
        Object beanInstance = createBeanInstance(beanName, beanDefinition);
        beanInstance = initializeBean(beanName, beanInstance, beanDefinition);
        return beanInstance;
    }


    protected Object initializeBean(final String beanName, final Object bean, BeanDefinition beanDefinition) throws Exception {

        Object exposedObject = bean;
        //调用BeanPostProcessor的初始化前方法
        exposedObject = applyBeanPostProcessorsBeforeInitialization(beanName, exposedObject);
        //调用afterPropertiesSet方法
        invokeInitMethods(beanName, exposedObject, beanDefinition);
        //调用自定义init方法
        //调用BeanPostProcessor的初始化后方法
        exposedObject = applyBeanPostProcessorsAfterInitialization(beanName, exposedObject);
        return exposedObject;
    }

    private void invokeInitMethods(String beanName, Object bean, BeanDefinition beanDefinition) throws Exception {

        boolean isInitializingBean = (bean instanceof InitializingBean);

        if (isInitializingBean) {
            ((InitializingBean) bean).afterPropertiesSet();
        }
        if (beanDefinition.getInitMethodName() != null) {
            invokeCustomInitMethod(beanName, bean, beanDefinition);
        }
    }


    private void invokeCustomInitMethod(String beanName, Object bean, BeanDefinition beanDefinition) throws Exception {
        String initMethodName = beanDefinition.getInitMethodName();
        Class clazz = bean.getClass();
        Method initMethod = clazz.getDeclaredMethod(initMethodName);
        initMethod.invoke(bean);
    }

    /****
     * 默认调用反射创建
     * @param beanName
     * @param beanDefinition
     * @return
     */
    private Object createBeanInstance(String beanName, BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException {
        return beanDefinition.getBeanClass().newInstance();
    }

    private Object applyBeanPostProcessorsBeforeInitialization(String beanName, final Object existingBean) {
        Object result = existingBean;
        for (BeanPostProcessor beanProcessor : getBeanPostProcessors()) {
            result = beanProcessor.postProcessBeforeInitialization(result, beanName);
            if (result == null) {
                return result;
            }
        }
        return result;
    }

    private Object applyBeanPostProcessorsAfterInitialization(String beanName, final Object existingBean) {
        Object result = existingBean;
        for (BeanPostProcessor beanProcessor : getBeanPostProcessors()) {
            result = beanProcessor.postProcessAfterInitialization(result, beanName);
            if (result == null) {
                return result;
            }
        }
        return result;
    }

}
