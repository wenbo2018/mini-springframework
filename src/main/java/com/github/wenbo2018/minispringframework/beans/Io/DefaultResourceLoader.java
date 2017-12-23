package com.github.wenbo2018.minispringframework.beans.Io;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by wenbo.shen on 2017/12/16.
 */
public class DefaultResourceLoader implements ResourceLoader {
    @Override
    public Resource getResource(String location) throws MalformedURLException {
        URL url = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(url);
    }
}
