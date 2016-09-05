package zjl.com.dagger_mvp_rxjava_demo2.shownewdetial;


import zjl.com.dagger_mvp_rxjava_demo2.BasePresenter;
import zjl.com.dagger_mvp_rxjava_demo2.BaseView;
import zjl.com.dagger_mvp_rxjava_demo2.shownewslist.ShowNewsListContract;

/**
 * Created by dell on 2016/8/26.
 */
public interface NewDetailContract {
    interface View extends BaseView{
        void showData(String image,String title,String image_source,StringBuffer body);
    }

    interface Presenter extends BasePresenter<View>{
       // void getNewsDetailData(int id);
       void getNewsDetailData();
    }
}
