package br.com.douglasmotta.githubdagger2.ui.repository;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import br.com.douglasmotta.githubdagger2.R;
import br.com.douglasmotta.githubdagger2.data.network.response.RepositoryResponse;
import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class RepositoryActivity extends AppCompatActivity implements RepositoryContract.View {

    @Inject
    RepositoryContract.Presenter presenter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository);
        ButterKnife.bind(this);

        AndroidInjection.inject(this);

        presenter.getGitHubRepositories("Java", "star", 1);
    }

    @Override
    public void displayRepositories(List<RepositoryResponse> repositories) {
        RepositoryAdapter adapter = new RepositoryAdapter(repositories);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
