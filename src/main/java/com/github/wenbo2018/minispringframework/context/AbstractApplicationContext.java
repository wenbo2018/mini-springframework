package com.github.wenbo2018.minispringframework.context;

import com.github.wenbo2018.minispringframework.beans.factory.DefaultListableBeanFactory;
import com.github.wenbo2018.minispringframework.beans.factory.ListableBeanFactory;
import com.github.wenbo2018.minispringframework.beans.factory.config.BeanPostProcessor;
import com.github.wenbo2018.minispringframework.exception.BeansException;
import com.github.wenbo2018.minispringframework.util.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

/**
 * Created by wenbo.shen on 2017/12/16.
 */
public abstract class AbstractApplicationContext implements ApplicationContext, ListableBeanFactory {


    private static final Logger logger = LoggerFactory.getLogger(AbstractApplicationContext.class);


    private ApplicationContext parent;

    protected String[] configLocations;

    protected DefaultListableBeanFactory beanFactory;


    public AbstractApplicationContext() {

    }

    public AbstractApplicationContext(ApplicationContext parent) {
        this.parent = parent;
    }

    @Override
    public Object getBean(String name) throws Exception {
        return this.beanFactory.getBean(name);
    }

    protected void refresh() throws Exception {
        DefaultListableBeanFactory beanFactory = obtainFreshBeanFactory();
        loadBeanDefinitions(beanFactory);
        registerBeanPostProcessors(beanFactory);
    }


    protected DefaultListableBeanFactory obtainFreshBeanFactory() {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        if (logger.isDebugEnabled()) {
            logger.debug("Bean factory for is{}", beanFactory);
        }
        this.beanFactory = beanFactory;
        return this.beanFactory;
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

    protected void registerBeanPostProcessors(DefaultListableBeanFactory beanFactory) throws Exception {

        List beanPostProcessors = this.getBeansForType(BeanPostProcessor.class);
        for (Object beanPostProcessor : beanPostProcessors) {
            beanFactory.addBeanPostProcessor((BeanPostProcessor) beanPostProcessor);
        }
    }

    @Override
    public List<Object> getBeansForType(Class<?> type) throws Exception {
        return this.getBeanFactory().getBeansForType(type);
    }

    public DefaultListableBeanFactory createBeanFactory() throws IllegalStateException {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory)
            throws BeansException, IOException, ParserConfigurationException, SAXException, ClassNotFoundException;


    public String[] getConfigLocations() {
        return configLocations;
    }

    public DefaultListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(DefaultListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
}
