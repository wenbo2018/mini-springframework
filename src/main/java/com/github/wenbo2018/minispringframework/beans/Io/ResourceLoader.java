package com.github.wenbo2018.minispringframework.beans.Io;

import java.net.MalformedURLException;

/**
 * Created by wenbo.shen on 2017/12/16.
 */
public interface ResourceLoader {

    Resource getResource(String location) throws MalformedURLException;

}
