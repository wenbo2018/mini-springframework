package com.github.wenbo2018.minispringframework.context;

import com.github.wenbo2018.minispringframework.beans.factory.ConfigurableListableBeanFactory;
import com.github.wenbo2018.minispringframework.except.BeansException;

import java.io.IOException;

/**
 * Created by wenbo.shen on 2017/12/16.
 */
public class FileSystemXmlApplicationContext extends AbstractXmlApplicationContext {


    public FileSystemXmlApplicationContext() {

    }

    public FileSystemXmlApplicationContext(ApplicationContext parent) {
        super(parent);
    }


    public FileSystemXmlApplicationContext(String configLocation) throws BeansException, IOException {
        this(new String[]{configLocation}, true, null);
    }

    public FileSystemXmlApplicationContext(String... configLocations) throws BeansException, IOException {
        this(configLocations, true, null);
    }

    public FileSystemXmlApplicationContext(String[] configLocations, boolean refresh, ApplicationContext parent)
            throws BeansException, IOException {
        super(parent);
        setConfigLocations(configLocations);
        if (refresh) {
            refresh();
        }
    }

    @Override
    public ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException {
        return null;
    }


}
