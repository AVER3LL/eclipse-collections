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

public class FalseTrueBooleanIterator implements MutableBooleanIterator
{
    private int currentIndex;
    private final BooleanHashSet parent;

    public FalseTrueBooleanIterator(BooleanHashSet parent) {
        this.parent = parent;
    }

    @Override
    public boolean hasNext()
    {
        return this.currentIndex < 2;
    }

    @Override
    public boolean next()
    {
        switch (this.currentIndex)
        {
            case 0:
                this.currentIndex++;
                return false;
            case 1:
                this.currentIndex++;
                return true;
            default:
                throw new NoSuchElementException();
        }
    }

    @Override
    public void remove()
    {
        switch (this.currentIndex)
        {
            case 0:
                throw new IllegalStateException();
            case 1:
                if (!this.parent.remove(false))
                {
                    throw new IllegalStateException();
                }
                return;
            case 2:
                if (!this.parent.remove(true))
                {
                    throw new IllegalStateException();
                }
                return;
            default:
                throw new AssertionError();
        }
    }
}
