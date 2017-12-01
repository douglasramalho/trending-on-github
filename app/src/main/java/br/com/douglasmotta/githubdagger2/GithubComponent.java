package br.com.douglasmotta.githubdagger2;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

@Component(modules = {GibhubModule.class})
public interface GithubComponent extends AndroidInjector<DaggerApplication> {

    @Override
    void inject(DaggerApplication instance);

    @Component.Builder
    interface Builder {

        @BindsInstance
        GithubComponent.Builder application(Application application);

        GithubComponent build();
    }
}
