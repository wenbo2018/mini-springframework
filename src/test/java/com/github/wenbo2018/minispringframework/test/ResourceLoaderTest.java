package com.github.wenbo2018.minispringframework.test;

import com.github.wenbo2018.minispringframework.beans.Io.DefaultResourceLoader;
import com.github.wenbo2018.minispringframework.beans.Io.Resource;
import com.github.wenbo2018.minispringframework.beans.Io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wenbo.shen on 2017/12/18.
 */
public class ResourceLoaderTest {
    public static void main(String[] args) throws IOException {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("minispringframework.xml");
        InputStream inputStream = resource.getInputStream();
        System.out.println();
    }
}
