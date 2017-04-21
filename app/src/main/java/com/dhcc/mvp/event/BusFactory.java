package com.dhcc.mvp.event;

/**
 * Created by Lituo on 2017/4/10 0010. 10:08 .
 * Mail：tony1994_vip@163.com
 */

public class BusFactory {

    private static IBus bus;

    public static IBus getBus() {
        if (bus == null) {
            synchronized (BusFactory.class) {
                if (bus == null) {
                    bus = new EventBusImpl();
                }
            }
        }
        return bus;
    }
}
