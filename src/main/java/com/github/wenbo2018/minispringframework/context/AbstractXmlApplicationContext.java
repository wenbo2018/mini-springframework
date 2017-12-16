package com.github.wenbo2018.minispringframework.context;

import com.github.wenbo2018.minispringframework.beans.factory.ConfigurableListableBeanFactory;
import com.github.wenbo2018.minispringframework.except.BeansException;
import com.github.wenbo2018.minispringframework.support.XmlBeanDefinitionReader;

import java.io.IOException;

/**
 * Created by wenbo.shen on 2017/12/16.
 */
public abstract class AbstractXmlApplicationContext extends AbstractApplicationContext {

    public AbstractXmlApplicationContext() {
    }

    public AbstractXmlApplicationContext(ApplicationContext parent) {
        super(parent);
    }

    @Override
    protected void loadBeanDefinitions(ConfigurableListableBeanFactory beanFactory) throws BeansException, IOException {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
    }
}
