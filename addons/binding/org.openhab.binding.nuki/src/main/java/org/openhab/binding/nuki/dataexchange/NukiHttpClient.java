/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nuki.dataexchange;

import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.HttpResponseException;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.smarthome.config.core.Configuration;
import org.openhab.binding.nuki.NukiBindingConstants;
import org.openhab.binding.nuki.dto.BridgeApiInfoDto;
import org.openhab.binding.nuki.dto.BridgeApiLockActionDto;
import org.openhab.binding.nuki.dto.BridgeApiLockStateDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

/**
 * The {@link NukiHttpClient} class is responsible for getting data from the Nuki Bridge.
 *
 * @author Markus Katter - Initial contribution
 */
public class NukiHttpClient {

    private final static Logger logger = LoggerFactory.getLogger(NukiHttpClient.class);

    private HttpClient httpClient;
    private Configuration configuration;

    public NukiHttpClient(Configuration configuration) {
        logger.trace("Instantiating NukiHttpClient({})", configuration);
        this.configuration = configuration;
        this.httpClient = new HttpClient();
        long connectTimeout = NukiBindingConstants.CLIENT_CONNECTTIMEOUT;
        httpClient.setConnectTimeout(connectTimeout);
        try {
            httpClient.start();
            logger.debug("Started httpClient[{}]", httpClient);
        } catch (Exception e) {
            logger.error("Could not start NukiHttpClient! ERROR: {}", e.getMessage());
            e.printStackTrace();
        }
    }

    public void stopClient() {
        try {
            if (httpClient.isStarted()) {
                httpClient.stop();
                logger.trace("Stopped NukiHttpClient");
            }
        } catch (Exception e) {
            logger.error("Could not stop NukiHttpClient! ERROR: {}", e.getMessage());
            e.printStackTrace();
        }
    }

    public BridgeInfoResponse getBridgeInfo() {
        logger.debug("NukiHttpClient:getBridgeInfo");
        String configIp = (String) configuration.get(NukiBindingConstants.CONFIG_IP);
        BigDecimal configPort = (BigDecimal) configuration.get(NukiBindingConstants.CONFIG_PORT);
        String configApiToken = (String) configuration.get(NukiBindingConstants.CONFIG_APITOKEN);
        String uri = String.format(NukiBindingConstants.URI_INFO, configIp, configPort, configApiToken);
        logger.trace("uri[{}]", uri);
        try {
            ContentResponse contentResponse = httpClient.GET(uri);
            String contentResponseAsString = contentResponse.getContentAsString();
            logger.trace("contentResponseAsString[{}]", contentResponseAsString);
            BridgeApiInfoDto bridgeApiInfoDto = new Gson().fromJson(contentResponseAsString, BridgeApiInfoDto.class);
            BridgeInfoResponse bridgeInfoResponse = new BridgeInfoResponse(contentResponse.getStatus(), "");
            bridgeInfoResponse.setBridgeInfo(bridgeApiInfoDto);
            return bridgeInfoResponse;
        } catch (Exception e) {
            logger.error("Could not get Bridge Info! ERROR: {}", e.getMessage());
            if (e instanceof ExecutionException && e.getCause() instanceof HttpResponseException) {
                return new BridgeInfoResponse(((HttpResponseException) e.getCause()).getResponse().getStatus(),
                        ((HttpResponseException) e.getCause()).getResponse().getReason());
            } else {
                return new BridgeInfoResponse(500, e.getMessage());
            }
        }
    }

    public BridgeLockStateResponse getBridgeLockState(String nukiId) {
        logger.debug("NukiHttpClient:getBridgeLockState({})", nukiId);
        String configIp = (String) configuration.get(NukiBindingConstants.CONFIG_IP);
        BigDecimal configPort = (BigDecimal) configuration.get(NukiBindingConstants.CONFIG_PORT);
        String configApiToken = (String) configuration.get(NukiBindingConstants.CONFIG_APITOKEN);
        String uri = String.format(NukiBindingConstants.URI_LOCKSTATE, configIp, configPort, configApiToken, nukiId);
        logger.trace("uri[{}]", uri);
        try {
            ContentResponse contentResponse = httpClient.GET(uri);
            String contentResponseAsString = contentResponse.getContentAsString();
            logger.trace("contentResponseAsString[{}]", contentResponseAsString);
            int status = contentResponse.getStatus();
            if (status == 200) {
                BridgeApiLockStateDto bridgeApiLockStateDto = new Gson().fromJson(contentResponseAsString,
                        BridgeApiLockStateDto.class);
                BridgeLockStateResponse bridgeLockStateResponse = new BridgeLockStateResponse(status, "");
                bridgeLockStateResponse.setBridgeLockState(bridgeApiLockStateDto);
                return bridgeLockStateResponse;
            } else {
                logger.error("Nuki Smart Lock with NukiID[{}] not found!", nukiId);
                return new BridgeLockStateResponse(status, "Nuki Smart Lock with NukiID[" + nukiId + "] not found!");
            }
        } catch (Exception e) {
            logger.error("Could not get Bridge Lock State! ERROR: {}", e.getMessage());
            if (e instanceof ExecutionException && e.getCause() instanceof HttpResponseException) {
                return new BridgeLockStateResponse(((HttpResponseException) e.getCause()).getResponse().getStatus(),
                        ((HttpResponseException) e.getCause()).getResponse().getReason());
            } else {
                return new BridgeLockStateResponse(500, e.getMessage());
            }
        }
    }

    public BridgeLockActionResponse getBridgeLockAction(String nukiId, int lockAction) {
        logger.debug("NukiHttpClient:getBridgeLockAction({}, {})", nukiId, lockAction);
        String configIp = (String) configuration.get(NukiBindingConstants.CONFIG_IP);
        BigDecimal configPort = (BigDecimal) configuration.get(NukiBindingConstants.CONFIG_PORT);
        String configApiToken = (String) configuration.get(NukiBindingConstants.CONFIG_APITOKEN);
        String uri = String.format(NukiBindingConstants.URI_LOCKACTION, configIp, configPort, configApiToken, nukiId,
                lockAction);
        logger.trace("uri[{}]", uri);
        try {
            ContentResponse contentResponse = httpClient.GET(uri);
            String contentResponseAsString = contentResponse.getContentAsString();
            logger.trace("contentResponseAsString[{}]", contentResponseAsString);
            int status = contentResponse.getStatus();
            if (status == 200) {
                BridgeApiLockActionDto bridgeApiLockActionDto = new Gson().fromJson(contentResponseAsString,
                        BridgeApiLockActionDto.class);
                BridgeLockActionResponse bridgeLockActionResponse = new BridgeLockActionResponse(status, "");
                bridgeLockActionResponse.setBridgeLockAction(bridgeApiLockActionDto);
                return bridgeLockActionResponse;
            } else {
                logger.error("Nuki Smart Lock with NukiID[{}] not found!", nukiId);
                return new BridgeLockActionResponse(status, "Nuki Smart Lock with NukiID[" + nukiId + "] not found!");
            }
        } catch (Exception e) {
            logger.error("Could not execute lockAction[{}] on NukiID[{}]! ERROR: {}", lockAction, nukiId,
                    e.getMessage());
            if (e instanceof ExecutionException && e.getCause() instanceof HttpResponseException) {
                return new BridgeLockActionResponse(((HttpResponseException) e.getCause()).getResponse().getStatus(),
                        ((HttpResponseException) e.getCause()).getResponse().getReason());
            } else {
                return new BridgeLockActionResponse(500, e.getMessage());
            }
        }
    }

}
