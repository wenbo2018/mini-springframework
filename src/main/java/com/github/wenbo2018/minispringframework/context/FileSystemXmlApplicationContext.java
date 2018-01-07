package com.github.wenbo2018.minispringframework.context;

/**
 * Created by wenbo.shen on 2017/12/16.
 */
public class FileSystemXmlApplicationContext extends AbstractXmlApplicationContext {


    public FileSystemXmlApplicationContext() {

    }

    public FileSystemXmlApplicationContext(ApplicationContext parent) {
        super(parent);
    }


    public FileSystemXmlApplicationContext(String configLocation) throws Exception {
        this(new String[]{configLocation}, true, null);
    }

    public FileSystemXmlApplicationContext(String... configLocations) throws Exception {
        this(configLocations, true, null);
    }

    public FileSystemXmlApplicationContext(String[] configLocations, boolean refresh, ApplicationContext parent)
            throws Exception {
        super(parent);
        setConfigLocations(configLocations);
        if (refresh) {
            refresh();
        }
    }
}
