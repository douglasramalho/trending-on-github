package br.com.douglasmotta.githubdagger2.di;

import br.com.douglasmotta.githubdagger2.di.scope.PerActivity;
import br.com.douglasmotta.githubdagger2.ui.repository.RepositoryActivity;
import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;

@Module(includes = AndroidInjectionModule.class)
abstract class BuildersModule {

    @PerActivity
    @ContributesAndroidInjector(modules = GibhubModule.class)
    abstract RepositoryActivity repositoryActivityInjector();
}
