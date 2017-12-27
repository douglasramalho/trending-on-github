package br.com.douglasmotta.githubdagger2.data.network.response;

import com.squareup.moshi.Json;

public class OwnerReponse {

    @Json(name = "avatar_url")
    private final String avatarUrl;

    @Json(name = "login")
    private final String login;

    public OwnerReponse(String avatarUrl, String login) {
        this.avatarUrl = avatarUrl;
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getLogin() {
        return login;
    }
}
