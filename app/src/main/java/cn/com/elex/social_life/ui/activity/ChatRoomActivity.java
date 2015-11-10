package cn.com.elex.social_life.ui.activity;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.com.elex.social_life.R;
import cn.com.elex.social_life.model.bean.ChatMessage;
import cn.com.elex.social_life.ui.adapter.ChatRoomMsgAdapter;
import cn.com.elex.social_life.ui.adapter.EmoticonsGridAdapter;
import cn.com.elex.social_life.ui.adapter.EmoticonsPagerAdapter;
import cn.com.elex.social_life.ui.base.BaseActivity;

/**
 * Created by zhangweibo on 2015/11/9.
 */
public class ChatRoomActivity extends BaseActivity implements EmoticonsGridAdapter.KeyClickListener {

    private static final int NO_OF_EMOTICONS = 54;
    @Bind(R.id.et_content)
    EditText content;
    @Bind(R.id.recycle_view)
    RecyclerView recycleView;
    @Bind(R.id.refresh_layout)
    MaterialRefreshLayout refreshLayout;
    @Bind(R.id.iv_face)
    ImageView ivFace;
    @Bind(R.id.iv_keyboard)
    ImageView ivKeyboard;
    @Bind(R.id.bt_send_msg)
    Button btSendMsg;
    /*   @Bind(R.id.footer_for_emoticons)
       LinearLayout emoticonsCover;*/
    @Bind(R.id.footer_input)
    LinearLayout footerInput;
    @Bind(R.id.bottom_layout)
    LinearLayout emoticonsCover;
    @Bind(R.id.parent_layout)
    RelativeLayout parentLayout;
    private ChatRoomMsgAdapter chatRoomMsgAdapter;
    private List<ChatMessage> messages;
    private Bitmap[] emoticons;
    private PopupWindow popupWindow;
    //表情
    private View popUpView;

    private boolean isKeyBoardVisible;

    private int keyboardHeight;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);
        ButterKnife.bind(this);
        init();
    }


    public void init() {
        initData();
        readEmoticons();
        enablePopUpView();
        checkKeyboardHeight(parentLayout);
        enableFooterView();
    }

    public void initData() {
        messages = new ArrayList<>();
        popUpView = getLayoutInflater().inflate(R.layout.emoticons_popup, null);
        chatRoomMsgAdapter = new ChatRoomMsgAdapter(this, messages);
        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {

            }

        });
    }

    @OnClick(R.id.iv_face)
    public void click(View v) {

        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        } else {
            popupWindow.setHeight(keyboardHeight);
            if (isKeyBoardVisible) {
                emoticonsCover.setVisibility(LinearLayout.GONE);
            } else {
                emoticonsCover.setVisibility(LinearLayout.VISIBLE);
            }
            popupWindow.showAtLocation(parentLayout, Gravity.BOTTOM, 0, 0);
        }

    }


    /**
     * Reading all emoticons in local cache
     */
    private void readEmoticons() {

        emoticons = new Bitmap[NO_OF_EMOTICONS];
        for (short i = 0; i < NO_OF_EMOTICONS; i++) {
            emoticons[i] = getImage((i + 1) + ".png");
        }

    }

    /**
     * Defining all components of emoticons keyboard
     */
    private void enablePopUpView() {
        ViewPager pager = (ViewPager) popUpView.findViewById(R.id.emoticons_pager);
        pager.setOffscreenPageLimit(3);

        ArrayList<String> paths = new ArrayList<String>();

        for (short i = 1; i <= NO_OF_EMOTICONS; i++) {
            paths.add(i + ".png");
        }

        EmoticonsPagerAdapter adapter = new EmoticonsPagerAdapter(this, paths, this);
        pager.setAdapter(adapter);

        // Creating a pop window for emoticons keyboard
        popupWindow = new PopupWindow(popUpView, ViewGroup.LayoutParams.MATCH_PARENT,
                (int) keyboardHeight, false);
        TextView backSpace = (TextView) popUpView.findViewById(R.id.back);
        backSpace.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                KeyEvent event = new KeyEvent(0, 0, 0, KeyEvent.KEYCODE_DEL, 0, 0, 0, 0, KeyEvent.KEYCODE_ENDCALL);
                content.dispatchKeyEvent(event);
            }
        });

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                 emoticonsCover.setVisibility(LinearLayout.GONE);
            }
        });
    }

    /**
     * For loading smileys from assets
     */
    private Bitmap getImage(String path) {
        AssetManager mngr = getAssets();
        InputStream in = null;
        try {
            in = mngr.open("emoticons/" + path);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Bitmap temp = BitmapFactory.decodeStream(in, null, null);
        return temp;
    }

    @Override
    public void keyClickedIndex(final String index) {

        Html.ImageGetter imageGetter = new Html.ImageGetter() {
            public Drawable getDrawable(String source) {
                StringTokenizer st = new StringTokenizer(index, ".");
                Drawable d = new BitmapDrawable(getResources(), emoticons[Integer.parseInt(st.nextToken()) - 1]);
                d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
                return d;
            }
        };
        Spanned cs = Html.fromHtml("<img src ='" + index + "'/>", imageGetter, null);
        int cursorPosition = content.getSelectionStart();
        content.getText().insert(cursorPosition, cs);
    }


    /**
     * Overriding onKeyDown for dismissing keyboard on key down
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }


    /**
     * Checking keyboard height and keyboard visibility
     */
    int previousHeightDiffrence = 0;

    private void checkKeyboardHeight(final View parentLayout) {

        parentLayout.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {

                    @Override
                    public void onGlobalLayout() {

                        Rect r = new Rect();
                        parentLayout.getWindowVisibleDisplayFrame(r);

                        int screenHeight = parentLayout.getRootView()
                                .getHeight();
                        int heightDifference = screenHeight - (r.bottom);

                        if (previousHeightDiffrence - heightDifference > 50) {
                            popupWindow.dismiss();
                        }

                        previousHeightDiffrence = heightDifference;
                        if (heightDifference > 100) {

                            isKeyBoardVisible = true;
                            changeKeyboardHeight(heightDifference);

                        } else {

                            isKeyBoardVisible = false;

                        }

                    }
                });

    }

    /**
     * change height of emoticons keyboard according to height of actual
     * keyboard
     *
     * @param height minimum height by which we can make sure actual keyboard is
     *               open or not
     */
    private void changeKeyboardHeight(int height) {

        if (height > 100) {
            keyboardHeight = height;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, keyboardHeight);
             emoticonsCover.setLayoutParams(params);
        }

    }

    /**
     * Enabling all content in footer i.e. post window
     */
    private void enableFooterView() {

        content.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (popupWindow.isShowing()) {

                    popupWindow.dismiss();
                }

            }
        });

        btSendMsg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (content.getText().toString().length() > 0) {
                    /*Spanned sp = content.getText();
                    chats.add(sp);
                    content.setText("");
                    mAdapter.notifyDataSetChanged();*/
                }
            }
        });
    }



}
