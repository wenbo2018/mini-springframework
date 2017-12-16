package com.github.wenbo2018.minispringframework.beans.factory;

/**
 * Created by wenbo.shen on 2017/12/10.
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;

}
