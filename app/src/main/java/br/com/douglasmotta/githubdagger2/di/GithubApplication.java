package br.com.douglasmotta.githubdagger2.di;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class GithubApplication extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerGithubComponent.builder().application(this).build();
    }
}
