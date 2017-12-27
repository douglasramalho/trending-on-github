package br.com.douglasmotta.githubdagger2.ui.repository;

import java.util.List;

import br.com.douglasmotta.githubdagger2.data.model.Repository;

public interface RepositoryContract {
    interface View {

        void displayRepositories(List<Repository> repositories);
    }

    interface Presenter {

        void getGitHubRepositories(String language, String order, int page);
    }
}
