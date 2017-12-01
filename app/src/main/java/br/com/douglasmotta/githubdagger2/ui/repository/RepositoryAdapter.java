package br.com.douglasmotta.githubdagger2.ui.repository;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.douglasmotta.githubdagger2.data.network.response.RepositoryResponse;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder> {

    private List<RepositoryResponse> repositoryResponseList;

    public RepositoryAdapter(List<RepositoryResponse> repositoryResponseList) {
        this.repositoryResponseList = repositoryResponseList;
    }

    @Override
    public RepositoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new RepositoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RepositoryViewHolder holder, int position) {
        holder.bind(repositoryResponseList.get(position));
    }

    @Override
    public int getItemCount() {
        return repositoryResponseList.size();
    }

    class RepositoryViewHolder extends RecyclerView.ViewHolder {

        TextView text;

        public RepositoryViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(android.R.id.text1);
        }

        void bind(RepositoryResponse repositoryResponse) {
            text.setText(repositoryResponse.getName());
        }
    }
}
