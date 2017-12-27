package br.com.douglasmotta.githubdagger2.ui.repository;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import br.com.douglasmotta.githubdagger2.R;
import br.com.douglasmotta.githubdagger2.data.model.Repository;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder> {

    private List<Repository> repositoryList;

    public RepositoryAdapter(List<Repository> repositoryList) {
        this.repositoryList = repositoryList;
    }

    @Override
    public RepositoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repository, parent, false);
        return new RepositoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RepositoryViewHolder holder, int position) {
        holder.bindItemsToAdapter(repositoryList.get(position));
    }

    @Override
    public int getItemCount() {
        return repositoryList.size();
    }

    class RepositoryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.repository_image_view_repository_image)
        ImageView repositoryImage;

        @BindView(R.id.repository_text_view_repository_name)
        TextView repositoryName;

        @BindView(R.id.repository_text_view_repository_description)
        TextView repositoryDescription;

        @BindView(R.id.repository_text_view_star_count)
        TextView repositoryStarCount;

        @BindView(R.id.repository_text_view_fork_count)
        TextView repositoryForkCount;

        public RepositoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindItemsToAdapter(Repository repository) {
            repositoryName.setText(repository.getOwner().getLogin());
            repositoryDescription.setText(repository.getDescription());

            Glide.with(repositoryImage.getContext()).load(repository.getOwner().getAvatarUrl()).apply(RequestOptions.circleCropTransform()).into(repositoryImage);

            repositoryForkCount.setText(String.valueOf(repository.getForksCount()));
            repositoryStarCount.setText(String.valueOf(repository.getStarsCount()));
        }
    }
}
