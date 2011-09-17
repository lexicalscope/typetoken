package com.lexicalscope.typetoken;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/*
 * Copyright 2011 Tim Wood
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */

public class TestTypetoken {
    @Rule public final ExpectedException exception = ExpectedException.none();

    @Test public void parameterizedTypeCanBeIdentified() throws Exception {
        assertThat(new _<List<String>>() {}.getRawParameter(0), equalTo((Object) String.class));
    }

    @Test public void parametersOfParameterizedTypeCanBeIdentified() throws Exception {
        assertThat(new _<List<List<String>>>() {}.getParameter(0).getRawParameter(0), equalTo((Object) String.class));
    }

    @Test public void classTypeCanBeIdentified() throws Exception {
        exception.expect(IllegalStateException.class);
        new _<String>() {}.getRawParameter(0);
    }
}
