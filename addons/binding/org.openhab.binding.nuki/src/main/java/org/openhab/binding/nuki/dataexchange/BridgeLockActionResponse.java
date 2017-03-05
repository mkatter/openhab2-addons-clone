/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nuki.dataexchange;

import org.openhab.binding.nuki.dto.BridgeApiLockActionDto;

/**
 * The {@link BridgeLockActionResponse} class wraps {@link BridgeApiLockActionDto} class.
 *
 * @author Markus Katter - Initial contribution
 */
public class BridgeLockActionResponse extends NukiBaseResponse {

    public BridgeLockActionResponse(int status, String message) {
        super(status, message);
    }

    private BridgeApiLockActionDto bridgeLockAction;

    public BridgeApiLockActionDto getBridgeLockAction() {
        return bridgeLockAction;
    }

    public void setBridgeLockAction(BridgeApiLockActionDto bridgeLockAction) {
        this.bridgeLockAction = bridgeLockAction;
    }

}
