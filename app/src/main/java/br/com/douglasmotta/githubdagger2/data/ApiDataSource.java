package br.com.douglasmotta.githubdagger2.data;

import br.com.douglasmotta.githubdagger2.data.network.response.RepositoryListResponse;

public interface ApiDataSource {
    interface GetRepositoriesCallback {
        void onSuccess(RepositoryListResponse repositoryListResponse);

        void onError();

        void onFailure(Throwable t);
    }

    void getRepositories(String language, String sort, int page, GetRepositoriesCallback getRepositoriesCallback);
}
