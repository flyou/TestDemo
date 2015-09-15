package com.flyou.simplebaseadapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * ============================================================
 * 项目名称：OrmListeDemo
 * 包名称：com.flyou.simplebaseadapter
 * 文件名：ListAdapter
 * 类描述：
 * 创建人：flyou
 * 邮箱：fangjaylong@gmail.com
 * 创建时间：2015/9/15 9:25
 * 修改备注：
 * 版本：@version  V1.0
 * ============================================================
 */
public class ListAdapter extends SimpleBaseAdapter<String> {
    public ListAdapter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    public int getItemResource() {
        return R.layout.item_list;
    }

    @Override
    public View getItemView(int position, View convertView, ViewHolder holder) {
        TextView textView=holder.getView(R.id.text_info);
        ImageView imageView=holder.getView(R.id.image);
        textView.setText(data.get(position));
        return convertView;
    }
}
