/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.vfs2.provider.res;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.VFS;
import org.junit.jupiter.api.Test;

public class ResSchemeTest {

    @Test
    public void testResolveFileString() throws FileSystemException {
        assertTrue(VFS.getManager().resolveFile("res:test.properties").exists());
    }

    @Test
    public void testResolveFileStringS() throws FileSystemException {
        assertTrue(VFS.getManager().resolveFile("res:/test.properties").exists());
    }

    @Test
    public void testResolveFileStringSS() throws FileSystemException {
        assertTrue(VFS.getManager().resolveFile("res://test.properties").exists());
    }

    @Test
    public void testResolveFileStringSSS() throws FileSystemException {
        assertTrue(VFS.getManager().resolveFile("res://test.properties").exists());
    }

    @Test
    public void testResolveFileStringSSSnull() {
        // Resulting path is empty
        assertThrows(FileSystemException.class, () -> VFS.getManager().resolveFile("res:///").exists());
    }

    @Test
    public void testResolveFileURI() throws FileSystemException, URISyntaxException {
        assertTrue(VFS.getManager().resolveFile(new URI("res:test.properties")).exists());
    }

    @Test
    public void testResolveFileURIS() throws FileSystemException, URISyntaxException {
        assertTrue(VFS.getManager().resolveFile(new URI("res:/test.properties")).exists());
    }

    @Test
    public void testResolveFileURISS() throws FileSystemException, URISyntaxException {
        assertTrue(VFS.getManager().resolveFile(new URI("res://test.properties")).exists());
    }

    @Test
    public void testResolveFileURISSS() throws FileSystemException, URISyntaxException {
        assertTrue(VFS.getManager().resolveFile(new URI("res://test.properties")).exists());
    }

    @Test
    public void testResolveURIString() throws FileSystemException {
        assertTrue(VFS.getManager().resolveURI("res:test.properties").isFile());
    }

    @Test
    public void testResolveURIStringS() throws FileSystemException {
        assertTrue(VFS.getManager().resolveURI("res:/test.properties").isFile());
    }

    @Test
    public void testResolveURIStringSS() throws FileSystemException {
        assertTrue(VFS.getManager().resolveURI("res://test.properties").isFile());
    }

    @Test
    public void testResolveURIStringSSS() throws FileSystemException {
        assertTrue(VFS.getManager().resolveURI("res:///test.properties").isFile());
    }

    @Test
    public void testResolveURIStringSSSnull() {
        // Resulting path is empty
        assertThrows(FileSystemException.class, () -> VFS.getManager().resolveURI("res:///").isFile());
    }

}
