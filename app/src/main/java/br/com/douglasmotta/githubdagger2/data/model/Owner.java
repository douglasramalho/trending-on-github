package br.com.douglasmotta.githubdagger2.data.model;

public class Owner {

    private String avatarUrl;

    private String login;

    public Owner(String avatarUrl, String login) {
        this.avatarUrl = avatarUrl;
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
