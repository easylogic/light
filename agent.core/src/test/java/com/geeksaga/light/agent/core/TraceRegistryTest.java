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
package com.geeksaga.light.agent.core;

import com.geeksaga.light.agent.trace.Trace;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author geeksaga
 */
public class TraceRegistryTest
{
    private TraceRegistryAdaptor mockTraceRegistryAdaptor;

    @Before
    public void setUp()
    {
        mockTraceRegistryAdaptor = mock(TraceRegistryAdaptor.class);

        TraceRegistry.bind(mockTraceRegistryAdaptor);
    }

    @Test //(expected=AssertionError.class)
    public void testBindIfNull()
    {
        TraceRegistry.bind(null);

        Trace mockTrace = mock(Trace.class);

        TraceRegistryAdaptor mockTraceRegistryAdaptor = mock(TraceRegistryAdaptor.class);
        int id = mockTraceRegistryAdaptor.add(mockTrace);

        assertThat(TraceRegistry.get(id), not(mockTrace));
        assertThat(TraceRegistry.get(id), is(Trace.NULL));
    }

    @Test
    public void testBindAndUnbind()
    {
        TraceRegistryAdaptor mockTraceRegistryAdaptor = mock(TraceRegistryAdaptor.class);

        TraceRegistry.bind(mockTraceRegistryAdaptor);

        assertThat(TraceRegistry.getTraceRegistryAdaptor(), sameInstance(mockTraceRegistryAdaptor));

        TraceRegistry.unbind();

        assertThat(TraceRegistry.getTraceRegistryAdaptor(), sameInstance(TraceRegistryAdaptor.NULL));
    }

    @Test
    public void testGetTrace()
    {
        Trace trace = mock(Trace.class);
        when(mockTraceRegistryAdaptor.get(0)).thenReturn(trace);

        int id = mockTraceRegistryAdaptor.add(trace);
        assertThat(id, is(0));
        assertThat(TraceRegistry.get(id), sameInstance(trace));
    }
}
