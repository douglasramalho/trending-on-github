package br.com.douglasmotta.githubdagger2.data.network.response;

import com.squareup.moshi.Json;

public class RepositoryResponse {

    @Json(name = "name")
    private final String name;

    @Json(name = "description")
    private final String description;

    @Json(name = "owner")
    private final OwnerReponse ownerReponse;

    @Json(name = "stargazers_count")
    private final int startCount;

    @Json(name = "forks_count")
    private final int forksCount;

    public RepositoryResponse(String name, String description, OwnerReponse ownerReponse, int startCount, int forksCount) {
        this.name = name;
        this.description = description;
        this.ownerReponse = ownerReponse;
        this.startCount = startCount;
        this.forksCount = forksCount;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public OwnerReponse getOwnerReponse() {
        return ownerReponse;
    }

    public int getStartCount() {
        return startCount;
    }

    public int getForksCount() {
        return forksCount;
    }
}
