package com.zinghttp.handler;


import android.os.Message;

/**
 * Created by zing on 15/12/2.
 */
public class HttpHandleMessage {

    public static Message buildMessage(int what, Object obj) {
        Message message = new Message();
        message.what = what;
        message.obj = obj;
        return message;
    }
}
