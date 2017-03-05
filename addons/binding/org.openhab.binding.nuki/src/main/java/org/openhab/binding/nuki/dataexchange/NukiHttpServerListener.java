/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nuki.dataexchange;

import org.openhab.binding.nuki.dto.BridgeApiLockStateRequestDto;

/**
 * The {@link NukiHttpServerListener} class defines the listener methods for the NukiHttpServer.
 *
 * @author Markus Katter - Initial contribution
 */
public interface NukiHttpServerListener {

    public void handleBridgeLockStateChange(BridgeApiLockStateRequestDto bridgeApiLockStateRequestDto);

}
