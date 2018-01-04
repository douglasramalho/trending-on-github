package br.com.douglasmotta.githubdagger2.ui.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.douglasmotta.githubdagger2.data.ApiDataSource;
import br.com.douglasmotta.githubdagger2.data.model.Owner;
import br.com.douglasmotta.githubdagger2.data.model.Repository;
import br.com.douglasmotta.githubdagger2.data.network.ApiRepository;
import br.com.douglasmotta.githubdagger2.data.network.response.RepositoryListResponse;
import br.com.douglasmotta.githubdagger2.data.network.response.RepositoryResponse;

public class RepositoryPresenter implements RepositoryContract.Presenter {

    private RepositoryContract.View view;
    private ApiRepository apiRepository;

    public RepositoryPresenter(RepositoryContract.View view, ApiRepository apiRepository) {
        this.view = view;
        this.apiRepository = apiRepository;
    }

    @Override
    public void getGitHubRepositories(String language, String order, int page) {
        view.showLoadingMoreCards();
        apiRepository.getRepositories(language, order, page, new ApiDataSource.GetRepositoriesCallback() {
            @Override
            public void onSuccess(RepositoryListResponse repositoryListResponse) {
                view.hideLoadingMoreCards();

                List<Repository> repositoryList = new ArrayList<>();
                for (RepositoryResponse repositoryResponse : repositoryListResponse.getRepositories()) {
                    Repository repository = new Repository(
                            repositoryResponse.getName(),
                            repositoryResponse.getDescription(),
                            new Owner(repositoryResponse.getOwnerReponse().getAvatarUrl(), repositoryResponse.getOwnerReponse().getLogin()),
                            repositoryResponse.getStartCount(),
                            repositoryResponse.getForksCount()
                    );

                    repositoryList.add(repository);
                }

                view.displayRepositories(repositoryList);
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
