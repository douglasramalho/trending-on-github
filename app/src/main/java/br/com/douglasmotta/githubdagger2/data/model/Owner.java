package br.com.douglasmotta.githubdagger2.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Owner implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.avatarUrl);
        dest.writeString(this.login);
    }

    protected Owner(Parcel in) {
        this.avatarUrl = in.readString();
        this.login = in.readString();
    }

    public static final Creator<Owner> CREATOR = new Creator<Owner>() {
        @Override
        public Owner createFromParcel(Parcel source) {
            return new Owner(source);
        }

        @Override
        public Owner[] newArray(int size) {
            return new Owner[size];
        }
    };
}
