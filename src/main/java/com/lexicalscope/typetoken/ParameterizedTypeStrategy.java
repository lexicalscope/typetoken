package com.lexicalscope.typetoken;

import java.lang.reflect.ParameterizedType;

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

class ParameterizedTypeStrategy implements TypeStrategy {
    private final ParameterizedType type;

    public ParameterizedTypeStrategy(final ParameterizedType type) {
        this.type = type;
    }

    public Class<?> getRawParameter(final int i) {
        return getParameter(i).getRawType();
    }

    public _<?> getParameter(final int i) {
        return _.createTypeToken(type.getActualTypeArguments()[i]);
    }

    public Class<?> getRawType() {
        return (Class<?>) type.getRawType();
    }
}
