package cn.com.elex.social_life.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.com.elex.social_life.R;
import cn.com.elex.social_life.support.view.imageview.CircleImageView;
import cn.com.elex.social_life.ui.base.BaseFragment;

/**
 * Created by zhangweibo on 2015/11/17.
 */
public class GuideIntroduceFragment extends BaseFragment {


    @Bind(R.id.icon)
    CircleImageView icon;
    @Bind(R.id.tag)
    TextView tag;
    @Bind(R.id.introduce)
    TextView introduce;
    public  static List<Introduce> introduces;
    public  Introduce introdu;
    public int pager;
    static {
        introduces=new ArrayList<>();
        introduces.add(new Introduce(R.drawable.introduce_bg2,"听说","随时随刻聊天"));
        introduces.add(new Introduce(R.drawable.introduce_bg2,"发现","只听声音找到本命"));
        introduces.add(new Introduce(R.drawable.introduce_bg2,"知音","聊得来才是真朋友"));
    }



    @Override
    protected int getResourceLyoutID() {
        return R.layout.fragment_guide_introduce;
    }

    @Override
    protected void onViewFirstLoading() {

    }

    @Override
    protected void onViewReloading() {
    }

    @Override
    protected void setViewData() {
        icon.setImageResource(introdu.icon);
        tag.setText(introdu.tag);
        introduce.setText(introdu.introduce);
    }

    @Override
    protected void preloadDataInit() {
        pager=getArguments().getInt("pager");
        introdu=introduces.get(pager);
    }


    public static  GuideIntroduceFragment newInstance(int pager){
        GuideIntroduceFragment fragment=new GuideIntroduceFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("pager", pager);
        fragment.setArguments(bundle);
        return fragment;
    }

   static class Introduce  {

        public int icon;

        public String tag;

        public String introduce;

        public Introduce(int icon, String tag, String introduce) {
            this.icon = icon;
            this.tag = tag;
            this.introduce = introduce;
        }
    }

}
