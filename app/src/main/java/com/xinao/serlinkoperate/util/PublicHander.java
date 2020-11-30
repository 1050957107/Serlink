package com.xinao.serlinkoperate.util;

import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

public class PublicHander extends Handler {

    private IHandlerListener handlerListener;

    @Override
    public void handleMessage(@NonNull Message msg) {
        switch (msg.what) {
            case IHelper.HANDLER_LOGIN_CODE_SUCCESS:
                if (null != handlerListener) {
                    handlerListener.handlerSendMsg(IHelper.HANDLER_LOGIN_CODE_SUCCESS, msg.obj);
                }
                break;
            case IHelper.HANDLER_LOGIN_CODE_ERROR:
                if (null != handlerListener) {
                    handlerListener.handlerSendMsg(IHelper.HANDLER_LOGIN_CODE_ERROR, msg.obj);
                }
                break;
            case IHelper.HANDLER_MAIN_FIND_USER:
                if (null != handlerListener) {
                    handlerListener.handlerSendMsg(IHelper.HANDLER_MAIN_FIND_USER, msg.obj);
                }
                break;
        }
    }

    public void setHandlerListener(IHandlerListener handlerListener) {
        this.handlerListener = handlerListener;
    }
}
