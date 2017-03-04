/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nuki;

import java.util.Collections;
import java.util.Set;

import org.eclipse.smarthome.core.thing.ThingTypeUID;

/**
 * The {@link NukiBinding} class defines common constants, which are
 * used across the whole binding.
 *
 * @author Markus Katter - Initial contribution
 */
public class NukiBindingConstants {

    public static final String BINDING_ID = "nuki";

    // List of all Thing Type UIDs
    public final static ThingTypeUID THING_TYPE_BRIDGE = new ThingTypeUID(BINDING_ID, "bridge");
    public final static ThingTypeUID THING_TYPE_SMARTLOCK = new ThingTypeUID(BINDING_ID, "smartLock");

    public final static Set<ThingTypeUID> THING_TYPE_BRIDGE_UIDS = Collections.singleton(THING_TYPE_BRIDGE);
    public final static Set<ThingTypeUID> THING_TYPE_SMARTLOCK_UIDS = Collections.singleton(THING_TYPE_SMARTLOCK);

    // List of all Channel ids
    public final static String CHANNEL_SMARTLOCKOPENCLOSE = "smartLockOpenClose";

    // List of all config-description parameters
    public final static String CONFIG_IP = "IP";
    public final static String CONFIG_PORT = "PORT";
    public final static String CONFIG_APITOKEN = "APITOKEN";
    public final static String CONFIG_NUKIID = "NUKIID";

    public final static int LOCKACTIONS_UNLOCK = 1;
    public final static int LOCKACTIONS_LOCK = 2;

}
