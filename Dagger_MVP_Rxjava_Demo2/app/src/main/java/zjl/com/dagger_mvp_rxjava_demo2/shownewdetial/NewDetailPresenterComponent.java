package zjl.com.dagger_mvp_rxjava_demo2.shownewdetial;


import dagger.Component;
import zjl.com.dagger_mvp_rxjava_demo2.ApplicationComponent;

/**
 * Created by dell on 2016/9/1.
 */
@Component(dependencies = ApplicationComponent.class,
        modules = NewDetailModule.class)
public interface NewDetailPresenterComponent {
    void inject(NewDetailActivity newDetailActivity);
}
