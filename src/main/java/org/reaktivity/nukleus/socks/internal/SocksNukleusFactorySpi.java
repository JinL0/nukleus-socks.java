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

import org.reaktivity.nukleus.Configuration;
import org.reaktivity.nukleus.NukleusFactorySpi;

public final class SocksNukleusFactorySpi implements NukleusFactorySpi
{
    @Override
    public String name()
    {
        return SocksNukleus.NAME;
    }

    @Override
    public SocksNukleus create(
        Configuration config)
    {
        return new SocksNukleus(new SocksConfiguration(config));
    }
}
