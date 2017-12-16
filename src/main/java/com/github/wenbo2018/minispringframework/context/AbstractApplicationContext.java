package com.github.wenbo2018.minispringframework.context;

import com.github.wenbo2018.minispringframework.except.BeansException;
import com.github.wenbo2018.minispringframework.util.Assert;

/**
 * Created by wenbo.shen on 2017/12/16.
 */
public abstract class AbstractApplicationContext implements ApplicationContext {


    private ApplicationContext parent;

    private String[] configLocations;


    public AbstractApplicationContext() {

    }

    public AbstractApplicationContext(ApplicationContext parent) {
        this.parent = parent;
    }

    @Override
    public Object getBean(String name) throws Exception {

        return null;
    }

    protected void refresh() throws BeansException {

    }

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

}
