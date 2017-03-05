/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nuki.dataexchange;

import org.openhab.binding.nuki.dto.BridgeApiInfoDto;

/**
 * The {@link BridgeInfoResponse} class wraps {@link BridgeApiInfoDto} class.
 *
 * @author Markus Katter - Initial contribution
 */
public class BridgeInfoResponse extends NukiBaseResponse {

    public BridgeInfoResponse(int status, String message) {
        super(status, message);
    }

    private BridgeApiInfoDto bridgeInfo;

    public BridgeApiInfoDto getBridgeInfo() {
        return bridgeInfo;
    }

    public void setBridgeInfo(BridgeApiInfoDto bridgeInfo) {
        this.bridgeInfo = bridgeInfo;
    }

}
