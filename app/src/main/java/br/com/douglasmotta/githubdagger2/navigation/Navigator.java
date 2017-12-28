package br.com.douglasmotta.githubdagger2.navigation;

import android.content.Context;
import android.content.Intent;

import javax.inject.Inject;
import javax.inject.Singleton;

import br.com.douglasmotta.githubdagger2.data.model.Repository;
import br.com.douglasmotta.githubdagger2.ui.pullrequests.PullRequestsActivity;

@Singleton
public final class Navigator {

    private static final String EXTRA_REPOSITORY = "EXTRA_REPOSITORY";

    @Inject
    public Navigator() {

    }

    public void toPullRequestsActivity(Context context, Repository repository) {
        context.startActivity(new Intent(context, PullRequestsActivity.class)
                .putExtra(EXTRA_REPOSITORY, repository));
    }
}
