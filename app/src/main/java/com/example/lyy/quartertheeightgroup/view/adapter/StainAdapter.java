package com.example.lyy.quartertheeightgroup.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lyy.quartertheeightgroup.R;
import com.example.lyy.quartertheeightgroup.model.bean.StainBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LYY on 2018/1/25.
 */

public class StainAdapter extends RecyclerView.Adapter<StainAdapter.IViewHolder> {

    private Context context;

    private List<StainBean.DataEntity> list;

    public StainAdapter(Context context) {
        this.context = context;
    }

    public void add(StainBean stainBean) {
        if (stainBean != null) {
            list = new ArrayList<StainBean.DataEntity>();
            list.addAll(stainBean.data);
        }
        //notifyDataSetChanged();
    }

    @Override
    public IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.stain_adapter, parent, false);

        return new IViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IViewHolder holder, final int position) {
        holder.dtext.setText(list.get(position).user.nickname);
        holder.dtext1.setText(list.get(position).createTime);
        holder.dtext3.setText(list.get(position).content);
        Object icon = list.get(position).user.icon;
        String url = (String) icon;
        holder.dsimp.setImageURI(url);
//图片的点击事件
        holder.dimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(v,position);

            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mOnItemClickListener1.onItemClick1(v,position);
            }
        });



    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    public class IViewHolder extends RecyclerView.ViewHolder {

        private TextView dtext;
        private TextView dtext1;
        private TextView dtext2;
        private TextView dtext3;
        private SimpleDraweeView dsimp;
        private ImageView dimage;

        public IViewHolder(View itemView) {
            super(itemView);
            dsimp = itemView.findViewById(R.id.d_simp);
            dtext = itemView.findViewById(R.id.d_text);
            dtext1 = itemView.findViewById(R.id.d_text1);
            dtext2 = itemView.findViewById(R.id.d_text2);
            dtext3 = itemView.findViewById(R.id.d_text3);
            dimage = itemView.findViewById(R.id.d_image);

        }


    }


//定义一个接口

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }


    //定义一个接口

    private OnItemClickListener1 mOnItemClickListener1;

    public void setOnItemClickListener1(OnItemClickListener1 onItemClickListener1) {
        mOnItemClickListener1 = onItemClickListener1;
    }

    public interface OnItemClickListener1 {
        void onItemClick1(View view, int position);
    }
}
