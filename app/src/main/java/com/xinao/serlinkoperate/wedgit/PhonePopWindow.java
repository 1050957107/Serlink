package com.xinao.serlinkoperate.wedgit;



import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.xinao.serlinkoperate.R;

import razerdp.basepopup.BasePopupWindow;

/**
 * @date：2020/11/27
 * @describe：
 * @author：DanDan
 */
public class PhonePopWindow extends BasePopupWindow {
    private TextView tvPhonePerspn,tvPhoneSet,tvCanCle;
    private OnPhoneListener mOnPhoneListener;

    public PhonePopWindow setmOnPhoneListener(OnPhoneListener mOnPhoneListener) {
        this.mOnPhoneListener = mOnPhoneListener;
        return this;
    }

    public PhonePopWindow(Context context) {
        super(context);
        tvPhonePerspn = findViewById(R.id.phone_person);
        tvPhoneSet = findViewById(R.id.phone_set);
        tvCanCle = findViewById(R.id.phone_cannle);
        tvPhonePerspn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnPhoneListener!=null){
                    mOnPhoneListener.setPhonePerson();
                }
            }
        });
        tvPhoneSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnPhoneListener!=null){
                    mOnPhoneListener.setPhoneSet();
                }
            }
        });
        tvCanCle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnPhoneListener!=null){
                    mOnPhoneListener.Cancle();
                }
            }
        });
    }


    @Override
    public View onCreateContentView() {
        return createPopupById(R.layout.phone);
    }

    public interface OnPhoneListener{
        void setPhonePerson();
        void setPhoneSet();
        void Cancle();
    }
}
