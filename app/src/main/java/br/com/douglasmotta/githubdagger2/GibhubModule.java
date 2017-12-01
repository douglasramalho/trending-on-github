package br.com.douglasmotta.githubdagger2;

import br.com.douglasmotta.githubdagger2.data.network.ApiEndPoint;
import br.com.douglasmotta.githubdagger2.data.network.ApiRepository;
import br.com.douglasmotta.githubdagger2.data.network.ApiService;
import br.com.douglasmotta.githubdagger2.ui.repository.RepositoryContract;
import br.com.douglasmotta.githubdagger2.ui.repository.RepositoryPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class GibhubModule {

    private final RepositoryContract.View view;

    public GibhubModule(RepositoryContract.View view) {
        this.view = view;
    }

    @Provides
    public RepositoryContract.View providesView() {
        return view;
    }

    @Provides
    public ApiEndPoint providesApiEndpoint() {
        return ApiService.getApiService();
    }

    @Provides
    public ApiRepository providesApiRepository(ApiEndPoint apiEndPoint) {
        return new ApiRepository(apiEndPoint);
    }

    @Provides
    public RepositoryContract.Presenter providesRepositoryContract(RepositoryContract.View view, ApiRepository apiRepository) {
        return new RepositoryPresenter(view, apiRepository);
    }
}
