/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nuki.dto;

/**
 * The {@link BridgeApiInfoScanResultsDto} class defines the Data Transfer Object (POJO) for the Nuki Bridge API /info
 * endpoint.
 * It is a nested JSON object (subclass) of {@link BridgeApiInfoDto}.
 *
 * @author Markus Katter - Initial contribution
 */
public class BridgeApiInfoScanResultsDto {

    private int nukiId;
    private String name;
    private int rssi;
    private boolean paired;

    public int getNukiId() {
        return nukiId;
    }

    public void setNukiId(int nukiId) {
        this.nukiId = nukiId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public boolean isPaired() {
        return paired;
    }

    public void setPaired(boolean paired) {
        this.paired = paired;
    }

}
