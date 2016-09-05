package zjl.com.dagger_mvp_rxjava_demo2.shownewdetial;


import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import zjl.com.dagger_mvp_rxjava_demo2.ApplicationComponent;
import zjl.com.dagger_mvp_rxjava_demo2.BaseActivity;
import zjl.com.dagger_mvp_rxjava_demo2.R;

/**
 * Created by dell on 2016/8/26.
 */
public class NewDetailActivity extends BaseActivity implements NewDetailContract.View {

    @Bind(R.id.iv_header)
    ImageView mIvHeader;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.tv_source)
    TextView mTvSource;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @Bind(R.id.wv_news)
    WebView mWvNews;
    @Bind(R.id.nested_view)
    NestedScrollView mNestedView;
    @Bind(R.id.share)
    TextView share;
    private String title;

    @Inject
    NewDetailPresenter newDetailPresenter;

    @Override
    protected void initUi() {

    }

    @Override
    protected void initDatas() {
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        mCollapsingToolbarLayout.setTitleEnabled(true);
        newDetailPresenter.attachView(this);
        newDetailPresenter.getNewsDetailData();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void onclick() {
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();
            }
        });
    }

    private void share() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
        intent.putExtra(Intent.EXTRA_TEXT, "来自「纯净日报」的分享：" + title + "，http://daily.zhihu.com/story/" + getIntent().getIntExtra("new", 0));
        startActivity(Intent.createChooser(intent, title));
    }

    ;

    @Override
    protected void setupComponent(ApplicationComponent component) {
        DaggerNewDetailPresenterComponent.builder().applicationComponent(component).newDetailModule(new NewDetailModule(this, getIntent().getIntExtra("new", 0))).build().inject(this);
    }

    @Override
    public int initContentView() {
        return R.layout.activity_news_detail;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        newDetailPresenter.detachView();
    }

    @Override
    public void showData(String image, String title, String image_source, StringBuffer body) {
        Glide.with(this).load(image).into(mIvHeader);
        this.title = title;
        mTvTitle.setText(title);
        mTvSource.setText(image_source);
        mWvNews.setDrawingCacheEnabled(true);
        mWvNews.loadDataWithBaseURL("file:///android_asset/", body.toString(), "text/html", "utf-8", null);
    }
}
