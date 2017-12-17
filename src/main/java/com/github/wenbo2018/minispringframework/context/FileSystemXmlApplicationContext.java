package com.github.wenbo2018.minispringframework.context;

import com.github.wenbo2018.minispringframework.beans.factory.DefaultListableBeanFactory;
import com.github.wenbo2018.minispringframework.except.BeansException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
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


    public FileSystemXmlApplicationContext(String configLocation) throws BeansException, IOException, ParserConfigurationException, SAXException {
        this(new String[]{configLocation}, true, null);
    }

    public FileSystemXmlApplicationContext(String... configLocations) throws BeansException, IOException, ParserConfigurationException, SAXException {
        this(configLocations, true, null);
    }

    public FileSystemXmlApplicationContext(String[] configLocations, boolean refresh, ApplicationContext parent)
            throws BeansException, IOException, ParserConfigurationException, SAXException {
        super(parent);
        setConfigLocations(configLocations);
        if (refresh) {
            refresh();
        }
    }

    @Override
    public DefaultListableBeanFactory getBeanFactory() throws IllegalStateException {
        return null;
    }


}
