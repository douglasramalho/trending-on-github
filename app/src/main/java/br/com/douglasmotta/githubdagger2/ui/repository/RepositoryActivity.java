package br.com.douglasmotta.githubdagger2.ui.repository;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.douglasmotta.githubdagger2.R;
import br.com.douglasmotta.githubdagger2.data.model.Repository;
import br.com.douglasmotta.githubdagger2.ui.base.BaseAcitivty;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RepositoryActivity extends BaseAcitivty implements RepositoryContract.View,
        RepositoryAdapter.OnClickRepositoryItemListener, RepositoryAdapter.LoadMoreRepositoryListener {

    @Inject
    RepositoryContract.Presenter presenter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private List<Repository> repositoryList = new ArrayList<>();
    private RepositoryAdapter repositoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository);
        ButterKnife.bind(this);

        repositoryAdapter = new RepositoryAdapter(repositoryList, recyclerView, this, this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(repositoryAdapter);

        getGitHubRepositorires();
    }

    @Override
    public void displayRepositories(List<Repository> repositories) {
        this.repositoryList.addAll(repositories);
        this.repositoryAdapter.notifyItemRangeChanged(repositories.size()-1, repositories.size());
        this.repositoryAdapter.setLoadingFalse();
    }

    @Override
    public void showLoadingMoreCards() {
        repositoryList.add(null);
        repositoryAdapter.notifyItemInserted(repositoryList.size() -1);
    }

    @Override
    public void hideLoadingMoreCards() {
        repositoryList.remove(repositoryList.size() -1);
        repositoryAdapter.notifyItemRemoved(repositoryList.size());
    }

    @Override
    public void onClick(Repository repository) {
        navigator.toPullRequestsActivity(this, repository);
    }

    @Override
    public void onLoadMoreRepositories() {
        getGitHubRepositorires();
    }

    private void getGitHubRepositorires() {
        presenter.getGitHubRepositories("Java", "star", 1);
    }
}
