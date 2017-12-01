package br.com.douglasmotta.githubdagger2.data.network;

import br.com.douglasmotta.githubdagger2.data.ApiDataSource;
import br.com.douglasmotta.githubdagger2.data.network.response.RepositoryListResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRepository implements ApiDataSource {

    private ApiEndPoint apiEndPoint;

    public ApiRepository(ApiEndPoint apiEndPoint) {
        this.apiEndPoint = apiEndPoint;
    }

    @Override
    public void getRepositories(String language, String sort, int page, final GetRepositoriesCallback getRepositoriesCallback) {
        apiEndPoint.repositories(language, sort, page).enqueue(new Callback<RepositoryListResponse>() {
            @Override
            public void onResponse(Call<RepositoryListResponse> call, Response<RepositoryListResponse> response) {
                if (response.isSuccessful()) {
                    getRepositoriesCallback.onSuccess(response.body());
                } else {
                    getRepositoriesCallback.onError();
                }
            }

            @Override
            public void onFailure(Call<RepositoryListResponse> call, Throwable t) {
                getRepositoriesCallback.onFailure(t);
            }
        });
    }
}
