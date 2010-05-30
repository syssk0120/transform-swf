/*
 *  DecoderRegistry.java
 *  Transform Utilities
 *
 * Copyright (c) 2009-2010 Flagstone Software Ltd. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *  * Neither the name of Flagstone Software Ltd. nor the names of its
 *    contributors may be used to endorse or promote products derived from this
 *    software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package com.flagstone.transform.coder;

import com.flagstone.transform.MovieDecoder;
import com.flagstone.transform.action.Action;
import com.flagstone.transform.action.ActionDecoder;
import com.flagstone.transform.fillstyle.FillStyle;
import com.flagstone.transform.fillstyle.FillStyleDecoder;
import com.flagstone.transform.fillstyle.MorphFillStyleDecoder;
import com.flagstone.transform.filter.Filter;
import com.flagstone.transform.filter.FilterDecoder;
import com.flagstone.transform.shape.ShapeDecoder;
import com.flagstone.transform.shape.ShapeRecord;


/**
 */
//TODO(class)
public final class DecoderRegistry {
    private static DecoderRegistry defaultRegistry;

    static {
        defaultRegistry = new DecoderRegistry();
        defaultRegistry.setFilterDecoder(new FilterDecoder());
        defaultRegistry.setFillStyleDecoder(new FillStyleDecoder());
        defaultRegistry.setMorphFillStyleDecoder(new MorphFillStyleDecoder());
        defaultRegistry.setShapeDecoder(new ShapeDecoder());
        defaultRegistry.setActionDecoder(new ActionDecoder());
        defaultRegistry.setMovieDecoder(new MovieDecoder());
    }


    public static DecoderRegistry getDefault() {
        return new DecoderRegistry(defaultRegistry);
    }


    public static void setDefault(final DecoderRegistry registry) {
        defaultRegistry = new DecoderRegistry(registry);
    }

    private transient SWFFactory<Filter> filterDecoder;
    private transient SWFFactory<FillStyle> fillStyleDecoder;
    private transient SWFFactory<FillStyle> morphStyleDecoder;
    private transient SWFFactory<ShapeRecord> shapeDecoder;
    private transient SWFFactory<Action> actionDecoder;
    private transient SWFFactory<MovieTag> movieDecoder;

    /**
     * Creates a DecoderRegistry with no decoders yet registered.
     */
    public DecoderRegistry() {
        // All decoders default to null
    }


    public DecoderRegistry(final DecoderRegistry registry) {
        filterDecoder = registry.filterDecoder;
        fillStyleDecoder = registry.fillStyleDecoder;
        morphStyleDecoder = registry.morphStyleDecoder;
        shapeDecoder = registry.shapeDecoder;
        actionDecoder = registry.actionDecoder;
        movieDecoder = registry.movieDecoder;
    }

    /** {@inheritDoc} */
    public DecoderRegistry copy() {
        return new DecoderRegistry(this);
    }


    public SWFFactory<Filter> getFilterDecoder() {
        return filterDecoder;
    }


    public void setFilterDecoder(final SWFFactory<Filter> factory) {
        filterDecoder = factory;
    }


    public SWFFactory<FillStyle> getFillStyleDecoder() {
        return fillStyleDecoder;
    }


    public void setFillStyleDecoder(final SWFFactory<FillStyle> factory) {
        fillStyleDecoder = factory;
    }


    public SWFFactory<FillStyle> getMorphFillStyleDecoder() {
        return morphStyleDecoder;
    }


    public void setMorphFillStyleDecoder(final SWFFactory<FillStyle> factory) {
        morphStyleDecoder = factory;
    }


    public SWFFactory<ShapeRecord> getShapeDecoder() {
        return shapeDecoder;
    }


    public void setShapeDecoder(final SWFFactory<ShapeRecord> factory) {
        shapeDecoder = factory;
    }


    public SWFFactory<Action> getActionDecoder() {
        return actionDecoder;
    }


    public void setActionDecoder(final SWFFactory<Action> factory) {
        actionDecoder = factory;
    }


    public SWFFactory<MovieTag> getMovieDecoder() {
        return movieDecoder;
    }


    public void setMovieDecoder(final SWFFactory<MovieTag> factory) {
        movieDecoder = factory;
    }
}
