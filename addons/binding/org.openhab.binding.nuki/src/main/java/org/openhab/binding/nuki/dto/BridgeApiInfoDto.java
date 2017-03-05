/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nuki.dto;

import java.util.List;

/**
 * The {@link BridgeApiInfoDto} class defines the Data Transfer Object (POJO) for the Nuki Bridge API /info endpoint.
 *
 * @author Markus Katter - Initial contribution
 */
public class BridgeApiInfoDto {

    private int bridgeType;
    private BridgeApiInfoIdsDto ids;
    private BridgeApiInfoVersionsDto versions;
    private int uptime;
    private String currentTime;
    private boolean serverConnected;
    private List<BridgeApiInfoScanResultsDto> scanResults;

    public int getBridgeType() {
        return bridgeType;
    }

    public void setBridgeType(int bridgeType) {
        this.bridgeType = bridgeType;
    }

    public BridgeApiInfoIdsDto getIds() {
        return ids;
    }

    public void setIds(BridgeApiInfoIdsDto ids) {
        this.ids = ids;
    }

    public BridgeApiInfoVersionsDto getVersions() {
        return versions;
    }

    public void setVersions(BridgeApiInfoVersionsDto versions) {
        this.versions = versions;
    }

    public int getUptime() {
        return uptime;
    }

    public void setUptime(int uptime) {
        this.uptime = uptime;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public boolean isServerConnected() {
        return serverConnected;
    }

    public void setServerConnected(boolean serverConnected) {
        this.serverConnected = serverConnected;
    }

    public List<BridgeApiInfoScanResultsDto> getScanResults() {
        return scanResults;
    }

    public void setScanResults(List<BridgeApiInfoScanResultsDto> scanResults) {
        this.scanResults = scanResults;
    }

}
