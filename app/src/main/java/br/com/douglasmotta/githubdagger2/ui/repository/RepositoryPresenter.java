package br.com.douglasmotta.githubdagger2.ui.repository;

import br.com.douglasmotta.githubdagger2.data.ApiDataSource;
import br.com.douglasmotta.githubdagger2.data.network.ApiRepository;
import br.com.douglasmotta.githubdagger2.data.network.response.RepositoryListResponse;

public class RepositoryPresenter implements RepositoryContract.Presenter {

    private RepositoryContract.View view;
    private ApiRepository apiRepository;

    public RepositoryPresenter(RepositoryContract.View view, ApiRepository apiRepository) {
        this.view = view;
        this.apiRepository = apiRepository;
    }

    @Override
    public void getGitHubRepositories(String language, String order, int page) {
        apiRepository.getRepositories(language, order, page, new ApiDataSource.GetRepositoriesCallback() {
            @Override
            public void onSuccess(RepositoryListResponse repositoryListResponse) {
                view.displayRepositories(repositoryListResponse.getRepositories());
            }

            @Override
            public void onError() {

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
