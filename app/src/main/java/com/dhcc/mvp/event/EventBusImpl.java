package com.dhcc.mvp.event;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Lituo on 2017/4/10 0010. 10:10 .
 * Mail：tony1994_vip@163.com
 */

public class EventBusImpl implements IBus {

    @Override
    public void register(Object object) {
        if (!EventBus.getDefault().isRegistered(object)) {
            EventBus.getDefault().register(object);
        }
    }


    @Override
    public void unregister(Object object) {
        if (EventBus.getDefault().isRegistered(object)) {
            EventBus.getDefault().unregister(object);
        }
    }

    @Override
    public void post(IEvent event) {
        EventBus.getDefault().post(event);
    }

    @Override
    public void postSticky(IEvent event) {
        EventBus.getDefault().postSticky(event);
    }
}
