package zjl.com.dagger_mvp_rxjava_demo2.shownewslist;


import java.util.ArrayList;

import zjl.com.dagger_mvp_rxjava_demo2.BasePresenter;
import zjl.com.dagger_mvp_rxjava_demo2.BaseView;
import zjl.com.dagger_mvp_rxjava_demo2.bean.News;

/**
 * Created by dell on 2016/8/26.
 */
public interface ShowNewsListContract {

    interface View extends BaseView{
        void load(ArrayList<News> list);
        void refresh(ArrayList<News> list);
    }

    interface Presenter extends BasePresenter<View>{
        void getBeforeNewsListData(String date);
        void getNewsListData();
        void getRefreshNewsListData();
    }

}
















