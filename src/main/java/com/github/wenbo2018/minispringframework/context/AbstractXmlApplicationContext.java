package com.github.wenbo2018.minispringframework.context;

import com.github.wenbo2018.minispringframework.beans.factory.DefaultListableBeanFactory;
import com.github.wenbo2018.minispringframework.exception.BeansException;
import com.github.wenbo2018.minispringframework.support.XmlBeanDefinitionReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
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
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException, IOException, ParserConfigurationException, SAXException, ClassNotFoundException {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions(getConfigLocations());
    }
}


