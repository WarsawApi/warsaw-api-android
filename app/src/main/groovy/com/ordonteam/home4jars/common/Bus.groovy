package com.ordonteam.home4jars.common

import de.greenrobot.event.EventBus
import groovy.transform.CompileStatic

@CompileStatic
final class Bus {

    static void post(Event event) {
        EventBus.default.post(event)
    }

    static void register(Listener eventListener) {
        EventBus.default.register(eventListener)
    }

    static void unregister(Listener eventListener) {
        EventBus.default.unregister(eventListener)
    }

    interface Event {

    }

    interface Listener {

    }
}