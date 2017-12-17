package com.github.wenbo2018.minispringframework.context;

import com.github.wenbo2018.minispringframework.beans.factory.DefaultListableBeanFactory;
import com.github.wenbo2018.minispringframework.except.BeansException;
import com.github.wenbo2018.minispringframework.util.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by wenbo.shen on 2017/12/16.
 */
public abstract class AbstractApplicationContext implements ApplicationContext {


    private static final Logger logger = LoggerFactory.getLogger(AbstractApplicationContext.class);


    private ApplicationContext parent;

    protected String[] configLocations;


    public AbstractApplicationContext() {

    }

    public AbstractApplicationContext(ApplicationContext parent) {
        this.parent = parent;
    }

    @Override
    public Object getBean(String name) throws Exception {

        return null;
    }

    protected void refresh() throws BeansException, IOException, ParserConfigurationException, SAXException {
        DefaultListableBeanFactory beanFactory = obtainFreshBeanFactory();
        loadBeanDefinitions(beanFactory);
    }


    protected DefaultListableBeanFactory obtainFreshBeanFactory() {
        DefaultListableBeanFactory beanFactory = getBeanFactory();
        if (logger.isDebugEnabled()) {
            logger.debug("Bean factory for is{}", beanFactory);
        }
        return beanFactory;
    }

    /***
     * 设置Spring配置文件路径
     * @param locations
     */
    public void setConfigLocations(String... locations) {
        if (locations != null) {
            Assert.noNullElements(locations, "Config locations must not be null");
            this.configLocations = new String[locations.length];
            for (int i = 0; i < locations.length; i++) {
                this.configLocations[i] = locations[i].trim();
            }
        } else {
            this.configLocations = null;
        }
    }


    public DefaultListableBeanFactory getBeanFactory() throws IllegalStateException {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory)
            throws BeansException, IOException, ParserConfigurationException, SAXException;


    public String[] getConfigLocations() {
        return configLocations;
    }
}
