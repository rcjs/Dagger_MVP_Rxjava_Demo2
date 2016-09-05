package zjl.com.dagger_mvp_rxjava_demo2.shownewslist;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dell on 2016/8/30.
 */
@Module
public class ShowNewsListModule {

    private final ShowNewsListContract.View view;
    public ShowNewsListModule(ShowNewsListContract.View view){
        this.view = view;
    }
}
