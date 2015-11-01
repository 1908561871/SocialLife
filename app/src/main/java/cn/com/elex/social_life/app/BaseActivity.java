/**
 * 
 */
package cn.com.elex.social_life.app;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import java.lang.ref.WeakReference;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;


/**
 * @author Tony Shen
 *
 */
public class BaseActivity extends FragmentActivity{

	public static cn.com.elex.social_life.exception.CrashApplication app;
	public int networkType;
	public String networkName;
	public static boolean isNetAvailabe;
	private boolean isShowNet;
    protected Handler mHandler = new SafeHandler(this);
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		app = (cn.com.elex.social_life.exception.CrashApplication) this.getApplication();
		addActivityToManager(this);
		EventBus.getDefault().register(this);

	}
	
	protected  void addActivityToManager(Activity act) {
        if (!app.activityManager.contains(act)) {
        	 app.activityManager.add(act);
	    }
	}
	
	protected void closeAllActivities() {
		for (final Activity act : app.activityManager) {
			if (act != null) {
				act.finish();
			}
		}
	}
	
	protected  void delActivityFromManager(Activity act) {
        if (app.activityManager.contains(act)) {
        	app.activityManager.remove(act);
        }
	}
	

	protected String getCurrentActivityName() {
		int size = app.activityManager.size();
		if (size > 0) {
			return app.activityManager.get(size-1).getClass().getName();
		}
		return null;
	}
	
	@Override
	public void onLowMemory() {
		super.onLowMemory();
	}


	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		delActivityFromManager(this);
		mHandler.removeCallbacksAndMessages(null);
		EventBus.getDefault().unregister(this);
    }
	


    public static class SafeHandler extends Handler{
	    private final WeakReference<Activity> mActivity;
	    public SafeHandler(Activity activity) {
	        mActivity = new WeakReference<Activity>(activity);
	    }
	    @Override
	    public void handleMessage(Message msg) {
	        if(mActivity.get() == null) {
	            return;
	        }
	    }
	}


  /*  *//**
     * 设置标题
     *//*
    public void setHeadTitle(String titleName,boolean isBack,boolean isShowNet){
        TextView title= (TextView) findViewById(R.id.tv_title);
        title.setText(titleName);
		if (isBack){
			ImageView iv_back= (ImageView) findViewById(R.id.iv_back);
			iv_back.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					finish();
				}
			});
		}
        this.isShowNet=isShowNet;
		if (isShowNet && !isNetAvailabe){
			findViewById(R.id.rl_set_net).setVisibility(View.VISIBLE);
			findViewById(R.id.rl_set_net).setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					//todo
				}
			});
		}
    }
*/
	@Subscribe
  public void netChange(cn.com.elex.social_life.event.NetChangeEvent event){
		/*isNetAvailabe=event.isNetAvailable();
		RelativeLayout rl_set_net= (RelativeLayout) findViewById(R.id.rl_set_net);
		if (rl_set_net==null)
		{
			return;
		}
      if (isShowNet && !isNetAvailabe){
		  rl_set_net.setVisibility(View.VISIBLE);
		  rl_set_net.setOnClickListener(new View.OnClickListener() {
			  @Override
			  public void onClick(View v) {
				  //todo
			  }
		  });
      }else{
		  rl_set_net.setVisibility(View.GONE);
	  }*/
  }







}
