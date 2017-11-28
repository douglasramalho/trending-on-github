package br.com.douglasmotta.githubdagger2.data.network.response;

import com.squareup.moshi.Json;

import java.util.List;

public class RepositoryListResponse {

    @Json(name = "items")
    private final List<RepositoryResponse> repositories;

    public RepositoryListResponse(List<RepositoryResponse> repositories) {
        this.repositories = repositories;
    }

    public List<RepositoryResponse> getRepositories() {
        return repositories;
    }
}
