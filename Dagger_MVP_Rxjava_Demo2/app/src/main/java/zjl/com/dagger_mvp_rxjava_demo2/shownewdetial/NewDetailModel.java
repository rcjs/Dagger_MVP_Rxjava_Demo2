package zjl.com.dagger_mvp_rxjava_demo2.shownewdetial;

import javax.inject.Inject;

import rx.Observable;
import zjl.com.dagger_mvp_rxjava_demo2.api.ApiManager;
import zjl.com.dagger_mvp_rxjava_demo2.bean.NewsDetail;

/**
 * Created by dell on 2016/8/26.
 */
public class NewDetailModel {

    @Inject
    public NewDetailModel() {

    }

    Observable<NewsDetail> getNewsDetail(int id) {
        return ApiManager.getNewsDetail(id);
    }
}
