package com.lexicalscope.typetoken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

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

public class _<T> {
    private final Type type;
    private final TypeStrategy strategy;

    public _() {
        type = type(getClass());
        this.strategy = typeStrategy(type);
    }

    _(final Type type) {
        this.type = type;
        this.strategy = typeStrategy(type);
    }

    public Class<?> getRawParameter(final int i) {
        return strategy.getRawParameter(i);
    }

    public _<?> getParameter(final int i) {
        return strategy.getParameter(i);
    }

    public Class<?> getRawType() {
        return strategy.getRawType();
    }

    private static Type type(final Class<?> typetokenClass) {
        final Type superclassType = typetokenClass.getGenericSuperclass();
        if (!(superclassType instanceof ParameterizedType)) {
            throw new RuntimeException("Missing type parameter " + typetokenClass + " (raw type found)");
        }

        return ((ParameterizedType) superclassType).getActualTypeArguments()[0];
    }

    private static TypeStrategy typeStrategy(final Type type) {
        TypeStrategy strategy;
        if (type instanceof ParameterizedType) {
            strategy = new ParameterizedTypeStrategy((ParameterizedType) type);
        } else {
            strategy = new ClassTypeStrategy((Class<?>) type);
        }
        return strategy;
    }

    static _<?> createTypeToken(final Type type) {
        return new _<Object>(type);
    }
}
