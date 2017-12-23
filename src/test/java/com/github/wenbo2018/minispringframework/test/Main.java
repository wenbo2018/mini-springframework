package com.github.wenbo2018.minispringframework.test;

import com.github.wenbo2018.minispringframework.beans.factory.BeanFactory;
import com.github.wenbo2018.minispringframework.context.FileSystemXmlApplicationContext;

/**
 * Created by wenbo.shen on 2017/12/18.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BeanFactory beanFactory = new FileSystemXmlApplicationContext("minispringframework.xml");
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.hello();
    }

}
