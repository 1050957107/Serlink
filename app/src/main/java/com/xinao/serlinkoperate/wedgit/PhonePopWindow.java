package com.xinao.serlinkoperate.wedgit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.xinao.serlinkoperate.R;

/**
 * @date：2020/11/27
 * @describe：
 * @author：DanDan
 */
public class PhonePopWindow extends MvpCommonPopView {
    private PhoneListener mListener;

    public PhonePopWindow(Context context) {
        super(context);
    }

    public PhonePopWindow setmListener(PhoneListener mListener) {
        this.mListener = mListener;
        return this;
    }

    @Override
    protected void setView(Context context) {
        super.setView(context);
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.phone, null);
        TextView cannle = view.findViewById(R.id.phone_cannle);
        TextView phone_person = view.findViewById(R.id.phone_person);
        TextView phone_set = view.findViewById(R.id.phone_set);
        setFocusable(false);
        phone_person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.callPerson();
            }
        });
        phone_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.callSet();
            }
        });
        cannle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    mListener.canle();
                }
            }
        });
        setContentView(view);
//        setOnBackKeyDismiss(false);
    }

    public interface PhoneListener {
        void callPerson();

        void callSet();

        void canle();
    }
}
