package com.dhcc.mvp.ui.home;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhcc.mvp.R;
import com.dhcc.mvp.model.bean.BeautyBean;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lituo on 2017/4/20 0020. 19:08 .
 * Mail：tony1994_vip@163.com
 */

public class BeautyAdapter extends RecyclerView.Adapter<BeautyAdapter.MyViewHolder> {

    private Context mContext;
    private List<BeautyBean> mList;

    public BeautyAdapter(Context context, List<BeautyBean> list) {
        this.mContext = context;
        this.mList = list;
    }

    public void addData(List<BeautyBean> list) {
        mList.addAll(list);
        notifyDataSetChanged();

    }

    public void clear() {
        mList.clear();
        notifyDataSetChanged();
    }

    public void update(List<BeautyBean> list) {
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_beauty, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        BeautyBean bean = mList.get(position);
        Picasso.with(mContext).load(bean.getImgsrc())
                .placeholder(new ColorDrawable(Color.parseColor("#FFFF7A")))
                .error(R.mipmap.lolita)
                .into(holder.mImgBeauty);
        holder.mTvInfo.setText(bean.getTitle());
        if (null != onItemClickLisenter) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickLisenter.onItemClick(v, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_beauty)
        ImageView mImgBeauty;
        @BindView(R.id.tv_info)
        TextView mTvInfo;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    private OnItemClickLisenter onItemClickLisenter;

    public interface OnItemClickLisenter {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickLisenter(OnItemClickLisenter onItemClickLisenter) {
        this.onItemClickLisenter = onItemClickLisenter;
    }
}
