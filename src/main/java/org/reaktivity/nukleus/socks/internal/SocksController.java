/**
 * Copyright 2016-2019 The Reaktivity Project
 *
 * The Reaktivity Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.reaktivity.nukleus.socks.internal;

import com.google.gson.Gson;
import org.agrona.MutableDirectBuffer;
import org.agrona.concurrent.UnsafeBuffer;
import org.reaktivity.nukleus.Controller;
import org.reaktivity.nukleus.ControllerSpi;

import static java.nio.ByteBuffer.allocateDirect;
import static java.nio.ByteOrder.nativeOrder;

public final class SocksController implements Controller
{
    private static final int MAX_SEND_LENGTH = 1024;
    private final ControllerSpi controllerSpi;
    private final MutableDirectBuffer commandBuffer;
    private final MutableDirectBuffer extensionBuffer;
    private final Gson gson;

    public SocksController(
            ControllerSpi controllerSpi)
    {
        this.controllerSpi = controllerSpi;
        this.commandBuffer = new UnsafeBuffer(allocateDirect(MAX_SEND_LENGTH).order(nativeOrder()));
        this.extensionBuffer = new UnsafeBuffer(allocateDirect(MAX_SEND_LENGTH).order(nativeOrder()));
        this.gson = new Gson();
    }
    @Override
    public String name()
    {
        return SocksNukleus.NAME;
    }
    @Override
    public int process()
    {
        return controllerSpi.doProcess();
    }

}
