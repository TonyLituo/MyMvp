package com.dhcc.mvp.event;

/**
 * Created by Lituo on 2017/4/10 0010. 10:06 .
 * Mail：tony1994_vip@163.com
 */

public interface IBus {
    void register(Object object);

    void unregister(Object object);

    void post(IEvent event);

    void postSticky(IEvent event);


    public interface IEvent {
        int getTag();
    }
}
