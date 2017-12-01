package br.com.douglasmotta.githubdagger2;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class GithubApplication extends DaggerApplication {

    private static GithubComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {

    }

    private void initDagger() {
        component = DaggerGithubComponent
                .builder()
                .build();
    }

    public static GithubComponent getComponent() {
        return component;
    }
}
