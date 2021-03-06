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

import com.geeksaga.light.agent.util.FieldNameMap;

/**
 * @author geeksaga
 */
public class ConfigDef
{
    public static final String entry_point = "entry_point";
    public static final String class_max_size = "class_max_size";
    public static final String method_min_size = "method_min_size";
    public static final String method_max_size = "method_max_size";

    public static final String ignore_bci_pattern = "ignore_bci_pattern";

    public static FieldNameMap names = FieldNameMap.toMap(ConfigDef.class);
}
