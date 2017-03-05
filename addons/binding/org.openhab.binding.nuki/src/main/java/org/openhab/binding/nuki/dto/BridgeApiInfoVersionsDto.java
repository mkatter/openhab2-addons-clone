/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nuki.dto;

/**
 * The {@link BridgeApiInfoVersionsDto} class defines the Data Transfer Object (POJO) for the Nuki Bridge API /list
 * endpoint.
 * It is a nested JSON object (subclass) of {@link BridgeApiInfoDto}.
 *
 * @author Markus Katter - Initial contribution
 */
public class BridgeApiInfoVersionsDto {

    private String firmwareVersion;
    private String wifiFirmwareVersion;

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public String getWifiFirmwareVersion() {
        return wifiFirmwareVersion;
    }

    public void setWifiFirmwareVersion(String wifiFirmwareVersion) {
        this.wifiFirmwareVersion = wifiFirmwareVersion;
    }

}
