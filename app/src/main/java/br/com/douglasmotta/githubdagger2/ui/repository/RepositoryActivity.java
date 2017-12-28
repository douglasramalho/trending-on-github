package br.com.douglasmotta.githubdagger2.ui.repository;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository);
        ButterKnife.bind(this);

        presenter.getGitHubRepositories("Java", "star", 1);
    }

    @Override
    public void displayRepositories(List<Repository> repositories) {
        RepositoryAdapter adapter = new RepositoryAdapter(repositories, recyclerView, this, this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    @Override
    public void onClick(Repository repository) {
        navigator.toPullRequestsActivity(this, repository);
    }

    @Override
    public void onLoadMoreRepositories() {

    }
}
