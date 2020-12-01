package com.xinao.serlinkoperate.fragment.messageinfo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.bean.AlarmBean;

import java.util.ArrayList;

/**
 * @date：2020/12/1
 * @describe：
 * @author：DanDan
 */
public class AlarmAdapter extends RecyclerView.Adapter<AlarmAdapter.ViewHolder> {
    private Context context;
    private ArrayList<AlarmBean> list;

    public void setAlarmBeans(ArrayList<AlarmBean> alarmBeans){
        this.list=alarmBeans;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_alarm, null, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AlarmBean alarmBean = list.get(position);
        holder.title.setText(alarmBean.getTitle());
        holder.unwinding.setText(alarmBean.getUnwinding());
        holder.unsure.setText(alarmBean.getUnsure());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView unwinding;
        private TextView unsure;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            unwinding = itemView.findViewById(R.id.unwinding);
            unsure = itemView.findViewById(R.id.unsure);
        }
    }
}
