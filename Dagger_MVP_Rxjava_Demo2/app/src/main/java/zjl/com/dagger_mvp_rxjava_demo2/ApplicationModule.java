package zjl.com.dagger_mvp_rxjava_demo2;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dell on 2016/8/31.
 */
@Module
public class ApplicationModule {
    private Context context;
    public ApplicationModule(Context context){
        this.context = context;
    }

    @Provides
    public Context provideContext(){
        return context;
    }
}
