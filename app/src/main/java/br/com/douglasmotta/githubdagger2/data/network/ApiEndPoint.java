package br.com.douglasmotta.githubdagger2.data.network;


import br.com.douglasmotta.githubdagger2.data.network.response.RepositoryListResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiEndPoint {
    @GET("search/repositories")
    Call<RepositoryListResponse> repositories(
            @Query("q") String query,
            @Query("sort") String sort,
            @Query("page") int page);
}
