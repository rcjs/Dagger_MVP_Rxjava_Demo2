package zjl.com.dagger_mvp_rxjava_demo2;

import dagger.Component;

/**
 * Created by dell on 2016/8/31.
 */
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(MyApplication myApplication);
}
