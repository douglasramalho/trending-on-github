package br.com.douglasmotta.githubdagger2.ui.repository;

import java.util.List;

import br.com.douglasmotta.githubdagger2.data.network.response.RepositoryResponse;

public interface RepositoryContract {
    interface View {

        void displayRepositories(List<RepositoryResponse> repositories);
    }

    interface Presenter {

        void getGitHubRepositories(String language, String order, int page);
    }
}
