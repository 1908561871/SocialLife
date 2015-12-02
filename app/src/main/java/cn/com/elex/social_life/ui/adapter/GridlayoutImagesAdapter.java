package cn.com.elex.social_life.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.com.elex.social_life.R;

/**
 * Created by zhangweibo on 2015/12/2.
 */
public class GridlayoutImagesAdapter extends BaseAdapter {

    private Context context;

    private ArrayList<String> imagePaths;

    public GridlayoutImagesAdapter(Context context, ArrayList<String> imagePaths) {
        this.context = context;
        this.imagePaths = imagePaths;
    }

    @Override
    public int getCount() {
        return imagePaths.size();
    }

    @Override
    public Object getItem(int position) {
        return imagePaths.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder=null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_image_item, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        holder= (ViewHolder) convertView.getTag();
        //Picasso.with(context).load(new File(imagePaths.get(position))).fit().into(holder.ivIcons);
        return convertView;
    }

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'adapter_image_item.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */


    class ViewHolder {
        @Bind(R.id.iv_icons)
        ImageView ivIcons;
        @Bind(R.id.iv_delete)
        ImageView ivDelete;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
