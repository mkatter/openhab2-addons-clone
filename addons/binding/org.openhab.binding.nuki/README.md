# Nuki Binding

This is the binding for the [Nuki Smart Lock](https://nuki.io).  
This binding allows you to integrate, view, control and configure the Nuki Bridge and Nuki Smart Locks in the OpenHAB2 environment.  
**Please note:** A [Nuki Bridge](https://nuki.io/en/bridge/) and a [Nuki Smart Lock](https://nuki.io/en/smart-lock/) or the [Nuki Combo](https://nuki.io/en/shop/nuki-combo/) is needed for this binding to work correctly.

## Supported Bridges

This binding was tested with the [Nuki Bridge](https://nuki.io/en/bridge/).  
It might also work with the [Nuki Software Bridge](https://play.google.com/store/apps/details?id=io.nuki.bridge&hl=en) - Feedback is really appreciated!  

## Supported Things

Nuki Smart Lock(s) which is/are paired via Bluetooth with the Nuki Bridge.

## Discovery

There is no automatic discovery yet implemented.

## Configuration

### Bridge Configuration

There are several configuration parameters for a bridge:
- **IP Address** (required)  
The static IP address of the Nuki Bridge.

- **Port** (required)  
The Port on which the Nuki Bridge REST API runs.

- **API Token** (required)  
The API Token configured via the Nuki App when enabling the API/IFTTT.

- **Callback Port** (required)  
The port on the OpenHAB server to which the Nuki Bridge sends Lock State changes.

The syntax for a bridge is:
```
Bridge nuki:bridge:<UNIQUENAME> [ <CONFIGURATION_PARAMETERS> ]
```

### Thing Configuration
There is just one configuration parameter for a thing:  
- **Nuki ID** (required)  
Nuki ID
The ID of the Nuki Smart Lock.

The syntax for a thing is:
```
Thing smartLock <UNIQUENAME> "<DISPLAYNAME>" @ "<LOCATION>" [ <CONFIGURATION_PARAMETER> ]
```

### Manual configuration of Bridge and Thing (.things file)
To manually configure a Nuki Bridge and a Nuki Smart Lock in your .items file you can do the following:
```
Bridge nuki:bridge:NB1 [ IP="192.168.0.50", PORT=8080, APITOKEN="1a2b3c4d5e", CALLBACK_PORT=8081 ] {
  Thing smartLock SL1 [ NUKIID="123456789" ]
}
```

### Items Configuration (.items file)
In the .items file you can define e.g. a Switch.  
Following the Manual configuration example from above you can do the following:
```
Switch Frontdoor "Frontdoor" <switch> { channel="nuki:smartLock:NB1:SL1:smartLockOpenClose" }
```

## Troubleshooting, Debugging and Tracing

Switch the loglevel in the Karaf console to see what's going on.  
```
log:set DEBUG org.openhab.binding.nuki
```

To see also the request/response data and more, use:
```
log:set TRACE org.openhab.binding.nuki
```

Set the logging back to standard:
```
log:set INFO org.openhab.binding.nuki
```

If you open an issue, please post a full startup TRACE log.
```
stop org.openhab.binding.nuki
log:set TRACE org.openhab.binding.nuki
start org.openhab.binding.nuki
```

Have fun & Feedback is really appreciated! :)
