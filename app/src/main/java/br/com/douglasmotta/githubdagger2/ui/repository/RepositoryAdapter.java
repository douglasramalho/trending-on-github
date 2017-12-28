package br.com.douglasmotta.githubdagger2.ui.repository;

import android.support.v7.widget.LinearLayoutManager;
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

    private static final int VIEW_TYPE_ITEM = 0;
    private static final int VIEW_TYPE_LOADING = 1;

    private List<Repository> repositoryList;
    private OnClickRepositoryItemListener onClickRepositoryItemListener;
    private int lastVisibleItem, totalItemCount;
    private boolean isLoading;

    public RepositoryAdapter(List<Repository> repositoryList, RecyclerView recyclerView, OnClickRepositoryItemListener onClickRepositoryItemListener, final LoadMoreRepositoryListener loadMoreRepositoryListener) {
        this.repositoryList = repositoryList;
        this.onClickRepositoryItemListener = onClickRepositoryItemListener;

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();

                if (dy > 0 && !isLoading && lastVisibleItem == totalItemCount - 1) {
                    if (loadMoreRepositoryListener != null) {
                        loadMoreRepositoryListener.onLoadMoreRepositories();
                    }

                    isLoading = true;
                }
            }
        });
    }

    @Override
    public RepositoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RepositoryViewHolder holder = null;

        if (viewType == VIEW_TYPE_ITEM) {
            holder = new RepositoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repository, parent, false));
        } else if (viewType == VIEW_TYPE_LOADING) {
            holder = new RepositoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repository_loading, parent, false));
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(RepositoryViewHolder holder, int position) {
        holder.bindItemsToAdapter(repositoryList.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return repositoryList.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }

    public void setLoadingFalse() {
        isLoading = false;
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

        private Repository repository;

        public RepositoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onClickRepositoryItemListener != null) {
                        onClickRepositoryItemListener.onClick(repository);
                    }
                }
            });
        }

        void bindItemsToAdapter(Repository repository) {
            this.repository = repository;

            repositoryName.setText(repository.getOwner().getLogin());
            repositoryDescription.setText(repository.getDescription());

            Glide.with(repositoryImage.getContext()).load(repository.getOwner().getAvatarUrl()).apply(RequestOptions.circleCropTransform()).into(repositoryImage);

            repositoryForkCount.setText(String.valueOf(repository.getForksCount()));
            repositoryStarCount.setText(String.valueOf(repository.getStarsCount()));
        }
    }

    interface OnClickRepositoryItemListener {
        void onClick(Repository repository);
    }

    interface LoadMoreRepositoryListener {
        void onLoadMoreRepositories();
    }
}
