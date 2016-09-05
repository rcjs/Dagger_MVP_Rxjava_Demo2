package zjl.com.dagger_mvp_rxjava_demo2.shownewslist;


import android.support.annotation.NonNull;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import zjl.com.dagger_mvp_rxjava_demo2.BaseView;
import zjl.com.dagger_mvp_rxjava_demo2.api.ApiManager;
import zjl.com.dagger_mvp_rxjava_demo2.bean.News;
import zjl.com.dagger_mvp_rxjava_demo2.bean.NewsList;

/**
 * Created by dell on 2016/8/26.
 */
public class ShowNewsListPresenter implements ShowNewsListContract.Presenter {

    private ShowNewsListContract.View view;
    private Subscription mSubscription;
    private ArrayList<News> listdata = new ArrayList<>();
    @Inject
    ShowNewsListModel showNewsListModel;
    @Inject
    public ShowNewsListPresenter() {

    }


    @Override
    public void getBeforeNewsListData(String date) {
        mSubscription = showNewsListModel.getBeforeNews(date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<NewsList>() {
                    @Override
                    public void call(NewsList newsList) {
                        for (int z = 0; z < newsList.getStories().size(); z++) {
                            listdata.add(newsList.getStories().get(z));
                        }
                        view.load(listdata);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        System.out.println("-------onFailure" + throwable.getMessage());
                    }
                });
    }

    @Override
    public void getNewsListData() {
        mSubscription =showNewsListModel.getLatestNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<NewsList>() {
                    @Override
                    public void call(NewsList newsList) {
                        listdata.clear();
                        for (int z = 0; z < newsList.getStories().size(); z++) {
                            listdata.add(newsList.getStories().get(z));
                        }
                        view.refresh(listdata);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        System.out.println("-------onFailure" + throwable.getMessage());
                    }
                });
    }

    @Override
    public void getRefreshNewsListData() {
        mSubscription = showNewsListModel.getLatestNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<NewsList>() {
                    @Override
                    public void call(NewsList newsList) {
                        listdata.clear();
                        for (int z = 0; z < newsList.getStories().size(); z++) {
                            listdata.add(newsList.getStories().get(z));
                        }
                        view.refresh(listdata);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        System.out.println("-------onFailure" + throwable.getMessage());
                    }
                });
    }

    @Override
    public void attachView(@NonNull ShowNewsListContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {

        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
        view = null;
    }

}
