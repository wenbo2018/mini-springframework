package com.github.wenbo2018.minispringframework.beans.Io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by wenbo.shen on 2017/12/16.
 */
public class UrlResource implements Resource {

    private URL url;

    public UrlResource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection urlConnection = this.url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }
}
