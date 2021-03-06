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
package com.geeksaga.light.agent.config;

import org.junit.Test;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author geeksaga
 */
public class ConfigDefTest {
    @Test
    public void testConfigField() {
        Collection<String> values = ConfigDef.names.values();

        assertThat(ConfigDef.names.size(), is(values.size()));

        for (String key : ConfigDef.names.keySet()) {
            assertThat(ConfigDef.names.hasName(key), is(true));
        }
    }
}
