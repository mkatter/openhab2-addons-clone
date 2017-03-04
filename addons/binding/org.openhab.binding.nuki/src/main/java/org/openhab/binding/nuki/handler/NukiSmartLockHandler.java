/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nuki.handler;

import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandler;
import org.eclipse.smarthome.core.types.Command;
import org.openhab.binding.nuki.NukiBindingConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link NukiSmartLockHandler} is responsible for handling commands, which are
 * sent to one of the channels.
 *
 * @author Markus Katter - Initial contribution
 */
public class NukiSmartLockHandler extends BaseThingHandler {

    private Logger logger = LoggerFactory.getLogger(NukiSmartLockHandler.class);

    public NukiSmartLockHandler(Thing thing) {
        super(thing);
    }

    @Override
    public void initialize() {
        logger.debug("NukiSmartLockHandler:initialize");
        updateStatus(ThingStatus.ONLINE);
    }

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {
        logger.debug("NukiSmartLockHandler:handleCommand({}, {})", channelUID, command);
        if (channelUID.getId().equals(NukiBindingConstants.CHANNEL_SMARTLOCKOPENCLOSE)) {
            logger.warn("Smart Lock Open/Close not yet implemented!");
        }
    }

}
