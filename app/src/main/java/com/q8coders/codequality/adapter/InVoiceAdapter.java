package com.q8coders.codequality.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jakewharton.rxbinding.view.RxView;
import com.q8coders.codequality.R;
import com.q8coders.codequality.model.InVoiceModel;
import com.q8coders.codequality.utility.MyConstant;
import com.q8coders.codequality.utility.helper.MyRecylerClickListner;
import java.util.List;

/**
 * Created by shahid on 8/30/2017.
 */


public class InVoiceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<InVoiceModel> list;
    private MyRecylerClickListner clickListner;

    public InVoiceAdapter(List<InVoiceModel> list) {
        this.list = list;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.invoice_item, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        InVoiceModel inVoiceModel = list.get(position);

        String invoiceNumber = inVoiceModel.invoice_no;
        String orderNumber = inVoiceModel.order.serial_no;
        String employeeName = inVoiceModel.employee.username;


        if(!TextUtils.isEmpty(invoiceNumber)){
            myViewHolder.invoice_number.setText(invoiceNumber);
        }

        if(!TextUtils.isEmpty(orderNumber)){
            myViewHolder.order_number.setText(orderNumber);
        }

        if(!TextUtils.isEmpty(employeeName)){
            myViewHolder.employee_name.setText(employeeName);
        }

        RxView.clicks(myViewHolder.container).subscribe(aVoid -> clickListner.click(position, MyConstant.ITEM_CLICKED));
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView invoice_number, order_number, employee_name;
        private LinearLayout container;

        private MyViewHolder(View itemView) {
            super(itemView);
            invoice_number = (TextView) itemView.findViewById(R.id.invoice_number);
            order_number = (TextView) itemView.findViewById(R.id.order_number);
            employee_name = (TextView) itemView.findViewById(R.id.employee_name);
            container = (LinearLayout) itemView.findViewById(R.id.container);

        }
    }

    public void setClickListner(MyRecylerClickListner clickListner) {
        this.clickListner = clickListner;
    }


}

