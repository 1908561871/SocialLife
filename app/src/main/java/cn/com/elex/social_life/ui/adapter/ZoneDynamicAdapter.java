package cn.com.elex.social_life.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.com.elex.social_life.R;
import cn.com.elex.social_life.model.bean.PublishLogBean;
import cn.com.elex.social_life.model.bean.UserInfo;
import cn.com.elex.social_life.support.util.TimeUtils;

/**
 * Created by zhangweibo on 2015/12/4.
 */
public class ZoneDynamicAdapter extends RecyclerView.Adapter<ZoneDynamicAdapter.ViewHolder> {


    private List<PublishLogBean> logs;

    private Context context;

    public ZoneDynamicAdapter(Context context,List<PublishLogBean> logs ) {
        this.logs = logs;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_zone_dynamic_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PublishLogBean data=logs.get(position);
        UserInfo info= (UserInfo) data.getPublishUser();
        holder.userIcon.setImageURI(Uri.parse(info.getHeadIconUrl().getUrl()));
        holder.nicker.setText(info.getNickName());
        holder.postingTime.setText(TimeUtils.getTime(data.getCreatedAt().getTime()));
        holder.location.setText(data.getAddr());
        holder.logTitle.setText(data.getTitle());
        holder.logContent.setText(data.getContent());
    }



    @Override
    public int getItemCount() {
        return logs.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.user_icon)
        SimpleDraweeView userIcon;
        @Bind(R.id.nicker)
        TextView nicker;
        @Bind(R.id.posting_time)
        TextView postingTime;
        @Bind(R.id.location)
        TextView location;
        @Bind(R.id.log_title)
        TextView logTitle;
        @Bind(R.id.log_content)
        TextView logContent;
        @Bind(R.id.log_images)
        GridView logImages;
        @Bind(R.id.log_comments)
        TextView logComments;
        @Bind(R.id.log_praise)
        ImageView logPraise;
        @Bind(R.id.log_comment)
        ImageView logComment;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
