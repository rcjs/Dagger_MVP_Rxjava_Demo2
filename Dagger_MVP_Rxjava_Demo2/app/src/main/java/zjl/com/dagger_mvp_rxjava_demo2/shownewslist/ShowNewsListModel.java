package zjl.com.dagger_mvp_rxjava_demo2.shownewslist;


import javax.inject.Inject;

import rx.Observable;
import zjl.com.dagger_mvp_rxjava_demo2.api.ApiManager;
import zjl.com.dagger_mvp_rxjava_demo2.bean.NewsList;

/**
 * Created by dell on 2016/8/26.
 */

public class ShowNewsListModel {

    @Inject
    public ShowNewsListModel(){}

    Observable<NewsList> getLatestNews(){
        return ApiManager.getLatestNews();
    }

   Observable<NewsList> getBeforeNews(String date){
        return ApiManager.getBeforeNews(date);
    }
}













