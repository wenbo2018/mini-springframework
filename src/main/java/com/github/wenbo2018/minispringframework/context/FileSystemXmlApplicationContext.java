package com.github.wenbo2018.minispringframework.context;

import com.github.wenbo2018.minispringframework.except.BeansException;

/**
 * Created by wenbo.shen on 2017/12/16.
 */
public class FileSystemXmlApplicationContext extends AbstractApplicationContext {

    public FileSystemXmlApplicationContext() {

    }

    public FileSystemXmlApplicationContext(ApplicationContext parent) {
        super(parent);
    }

    public FileSystemXmlApplicationContext(String configLocation) throws BeansException {
        this(new String[]{configLocation}, true, null);
    }

    public FileSystemXmlApplicationContext(String... configLocations) throws BeansException {
        this(configLocations, true, null);
    }

    public FileSystemXmlApplicationContext(String[] configLocations, boolean refresh, ApplicationContext parent)
            throws BeansException {
        super(parent);
        setConfigLocations(configLocations);
        if (refresh) {
            refresh();
        }
    }


}
