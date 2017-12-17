package com.github.wenbo2018.minispringframework.beans.factory;

import java.util.List;

/**
 * Created by wenbo.shen on 2017/12/17.
 */
public interface ListableBeanFactory extends BeanFactory {

    List<Object> getBeansForType(Class<?> type) throws Exception;

}
