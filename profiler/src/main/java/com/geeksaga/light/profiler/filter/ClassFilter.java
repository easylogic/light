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
package com.geeksaga.light.profiler.filter;

/**
 * @author geeksaga
 */
public class ClassFilter implements Filter
{
    @Override
    public boolean allow(ClassLoader classLoader, String className)
    {
        if (classLoader == null)
        {
            return true;
        }

        if (className.startsWith("java") || className.startsWith("sun"))
        {
            return false;
        }

        return true;
    }

    @Override
    public boolean allow(ClassLoader classLoader, String className, byte[] classfileBuffer)
    {
        if(classfileBuffer == null) // || classfileBuffer.length) FIXME is max size
        {
            return false;
        }

        return allow(classLoader, className);
    }
}
