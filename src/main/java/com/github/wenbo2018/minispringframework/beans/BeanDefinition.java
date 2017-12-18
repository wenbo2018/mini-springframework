package com.github.wenbo2018.minispringframework.beans;

/**
 * Created by wenbo.shen on 2017/12/10.
 */
public class BeanDefinition {

    private String name;

    private String className;

    private volatile Class beanClass;

    private String initMethodName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public String getClassName() {
        return className;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }
}
