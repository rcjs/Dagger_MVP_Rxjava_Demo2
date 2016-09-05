package zjl.com.dagger_mvp_rxjava_demo2.shownewdetial;


import android.support.annotation.NonNull;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import zjl.com.dagger_mvp_rxjava_demo2.bean.NewsDetail;
import zjl.com.dagger_mvp_rxjava_demo2.utils.HtmlUtil;

/**
 * Created by dell on 2016/8/26.
 */
public class NewDetailPresenter implements NewDetailContract.Presenter {
    private int id;
    private NewDetailContract.View view;
    private Subscription mSubscription;
    @Inject
    NewDetailModel newDetailModel;

    @Inject
    public NewDetailPresenter(int id) {
        this.id = id;
    }

    @Override
    public void getNewsDetailData() {
        mSubscription = newDetailModel.getNewsDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<NewsDetail>() {
                    @Override
                    public void call(NewsDetail newsDetail) {
                        StringBuffer stringBuffer = HtmlUtil.handleHtml(newsDetail.getBody());
                        view.showData(newsDetail.getImage(), newsDetail.getTitle(), newsDetail.getImage_source(), stringBuffer);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        System.out.println("-------onFailure" + throwable.getMessage());
                    }
                });
    }

    @Override
    public void attachView(@NonNull NewDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        if (mSubscription != null && mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
        view = null;
    }
}
