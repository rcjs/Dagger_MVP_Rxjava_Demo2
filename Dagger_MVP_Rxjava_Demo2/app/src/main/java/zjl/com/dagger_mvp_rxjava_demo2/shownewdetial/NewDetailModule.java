package zjl.com.dagger_mvp_rxjava_demo2.shownewdetial;

import dagger.Module;
import dagger.Provides;
import zjl.com.dagger_mvp_rxjava_demo2.shownewslist.ShowNewsListContract;

/**
 * Created by dell on 2016/8/31.
 */
@Module
public class NewDetailModule {
    private final NewDetailContract.View view;
    private int id;
    public NewDetailModule(NewDetailContract.View view,int id){
        this.view = view;
        this.id = id;
    }

    @Provides
    public int provideid(){
        return id;
    }
}
