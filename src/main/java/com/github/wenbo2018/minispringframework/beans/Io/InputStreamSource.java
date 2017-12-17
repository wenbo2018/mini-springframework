package com.github.wenbo2018.minispringframework.beans.Io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wenbo.shen on 2017/12/16.
 */
public interface InputStreamSource {

    InputStream getInputStream() throws IOException;

}
