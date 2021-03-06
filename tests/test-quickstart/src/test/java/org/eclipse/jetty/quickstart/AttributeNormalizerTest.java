//
//  ========================================================================
//  Copyright (c) 1995-2016 Mort Bay Consulting Pty. Ltd.
//  ------------------------------------------------------------------------
//  All rights reserved. This program and the accompanying materials
//  are made available under the terms of the Eclipse Public License v1.0
//  and Apache License v2.0 which accompanies this distribution.
//
//      The Eclipse Public License is available at
//      http://www.eclipse.org/legal/epl-v10.html
//
//      The Apache License v2.0 is available at
//      http://www.opensource.org/licenses/apache2.0.php
//
//  You may elect to redistribute this code under either of these licenses.
//  ========================================================================
//

package org.eclipse.jetty.quickstart;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.net.MalformedURLException;
import java.net.URI;

import org.eclipse.jetty.util.resource.Resource;
import org.junit.Test;

public class AttributeNormalizerTest
{
    @Test
    public void testNormalizeWAR() throws MalformedURLException
    {
        String webref = "http://localhost/resource/webapps/root";
        Resource webresource = Resource.newResource(webref);
        AttributeNormalizer normalizer = new AttributeNormalizer(webresource);
        String result = null;
        
        result = normalizer.normalize(URI.create(webref));
        assertThat(result, is("${WAR}"));
        
        result = normalizer.normalize(URI.create(webref + "/deep/ref"));
        assertThat(result, is("${WAR}/deep/ref"));
    }
}
