package com.lexicalscope.typetoken;

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

class ClassTypeStrategy implements TypeStrategy {
    private final Class<?> klass;

    public ClassTypeStrategy(final Class<?> klass) {
        this.klass = klass;
    }

    public Class<?> getRawParameter(final int i) {
        throw genericParametersRequestedException();
    }

    public _<?> getParameter(final int i) {
        throw genericParametersRequestedException();
    }

    public Class<?> getRawType() {
        return klass;
    }

    private IllegalStateException genericParametersRequestedException() {
        return new IllegalStateException("cannot ask for generic parameters of a non generic type " + klass);
    }
}
