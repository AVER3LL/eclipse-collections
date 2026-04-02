/*
 * Copyright (c) 2026 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.set.mutable.primitive;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.iterator.MutableBooleanIterator;

public class EmptyBooleanIterator implements MutableBooleanIterator
{

    // NOTE: The parent variable is never used, but I just kept it to
    // keep consistency with the constructors of TrueBooleanIterator
    // and FalseBooleanIterator
    private final BooleanHashSet parent;

    public EmptyBooleanIterator(BooleanHashSet parent) {
        this.parent = parent;
    }

    @Override
    public boolean next()
    {
        throw new NoSuchElementException();
    }

    @Override
    public boolean hasNext()
    {
        return false;
    }

    @Override
    public void remove()
    {
        throw new IllegalStateException();
    }
}
