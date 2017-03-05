/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nuki.dataexchange;

import org.openhab.binding.nuki.dto.BridgeApiLockStateDto;

/**
 * The {@link BridgeLockStateResponse} class wraps {@link BridgeApiLockStateDto} class.
 *
 * @author Markus Katter - Initial contribution
 */
public class BridgeLockStateResponse extends NukiBaseResponse {

    public BridgeLockStateResponse(int status, String message) {
        super(status, message);
    }

    private BridgeApiLockStateDto bridgeLockState;

    public BridgeApiLockStateDto getBridgeLockState() {
        return bridgeLockState;
    }

    public void setBridgeLockState(BridgeApiLockStateDto bridgeLockState) {
        this.bridgeLockState = bridgeLockState;
    }

}
