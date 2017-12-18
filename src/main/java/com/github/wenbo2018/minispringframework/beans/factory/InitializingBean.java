package com.github.wenbo2018.minispringframework.beans.factory;

/**
 * Created by wenbo.shen on 2017/12/18.
 */
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;

}
