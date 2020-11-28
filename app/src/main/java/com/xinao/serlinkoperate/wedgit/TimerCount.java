package com.xinao.serlinkoperate.wedgit;

import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

/**
 * 获取验证码60秒倒计时
 */
public class TimerCount extends CountDownTimer {
    private TextView tv_code;
    private String txt;

    public TimerCount(long millisInFuture, long countDownInterval, View bnt) {
        super(millisInFuture, countDownInterval);
        this.tv_code = (TextView) bnt;
    }

    public TimerCount(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onFinish() {
        // TODO Auto-generated method stub
        tv_code.setClickable(true);
        if (!TextUtils.isEmpty(txt)) {
            tv_code.setText(txt);
        }
    }

    @Override
    public void onTick(long arg0) {
        // TODO Auto-generated method stub
        tv_code.setClickable(false);
        tv_code.setText(arg0 / 1000 + "S");
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}