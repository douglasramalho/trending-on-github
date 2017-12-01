package br.com.douglasmotta.githubdagger2.di;

import br.com.douglasmotta.githubdagger2.data.network.ApiEndPoint;
import br.com.douglasmotta.githubdagger2.data.network.ApiRepository;
import br.com.douglasmotta.githubdagger2.data.network.ApiService;
import br.com.douglasmotta.githubdagger2.ui.repository.RepositoryActivity;
import br.com.douglasmotta.githubdagger2.ui.repository.RepositoryContract;
import br.com.douglasmotta.githubdagger2.ui.repository.RepositoryPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class GibhubModule {

    @Binds
    public abstract RepositoryContract.View view(RepositoryActivity repositoryActivity);

    @Provides
    static ApiEndPoint providesApiEndpoint() {
        return ApiService.getApiService();
    }

    @Provides
    static ApiRepository providesApiRepository(ApiEndPoint apiEndPoint) {
        return new ApiRepository(apiEndPoint);
    }

    @Provides
    static RepositoryContract.Presenter providesRepositoryContract(RepositoryContract.View view, ApiRepository apiRepository) {
        return new RepositoryPresenter(view, apiRepository);
    }
}
