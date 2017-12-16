package com.github.wenbo2018.minispringframework.beans;

/**
 * Created by wenbo.shen on 2017/12/10.
 */
public class BeanDefinition {

    private String name;

    private String className;

    private volatile Object beanClass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Object beanClass) {
        this.beanClass = beanClass;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
