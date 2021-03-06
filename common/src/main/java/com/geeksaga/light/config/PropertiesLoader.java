/*
 * Copyright 2015 GeekSaga.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.geeksaga.light.config;

import com.geeksaga.light.logger.CommonLogger;
import com.geeksaga.light.logger.LightLogger;

import java.io.*;
import java.util.Properties;

/**
 * @author geeksaga
 */
public class PropertiesLoader
{
    private static final LightLogger logger = CommonLogger.getLogger(PropertiesLoader.class.getName());

    private static final String DEFAULT_ENCODING = "UTF-8";

    public Properties load(String name) throws IOException
    {
        return load(null, name);
    }

    public Properties load(ClassLoader classLoader, String name) throws IOException
    {
        if (classLoader != null)
        {
            return load(new Properties(), classLoader.getResourceAsStream(name), DEFAULT_ENCODING);
        }

        return load(new Properties(), name, DEFAULT_ENCODING);
    }

    public Properties load(Properties properties, String path, String encoding) throws IOException
    {
        return load(properties, new FileInputStream(path), encoding);
    }

    public Properties load(Properties properties, InputStream inputStream, String encoding) throws IOException
    {
        if (inputStream == null)
        {
            return properties;
        }

        Reader reader = null;
        try
        {
            reader = new InputStreamReader(inputStream, encoding);
            properties.load(reader);
        }
        finally
        {
            close(reader);
            close(inputStream);
        }

        return properties;
    }

    private void close(Closeable closeable)
    {
        if (closeable != null)
        {
            try
            {
                closeable.close();
            }
            catch (IOException ioException)
            {
                logger.info(ioException);
            }
        }
    }
}
