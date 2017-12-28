package br.com.douglasmotta.githubdagger2.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Repository implements Parcelable {

    private String name;
    private String description;
    private Owner owner;
    private int starsCount;
    private int forksCount;

    public Repository(String name, String description, Owner owner, int starsCount, int forksCount) {
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.starsCount = starsCount;
        this.forksCount = forksCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public int getStarsCount() {
        return starsCount;
    }

    public void setStarsCount(int starsCount) {
        this.starsCount = starsCount;
    }

    public int getForksCount() {
        return forksCount;
    }

    public void setForksCount(int forksCount) {
        this.forksCount = forksCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeParcelable(this.owner, flags);
        dest.writeInt(this.starsCount);
        dest.writeInt(this.forksCount);
    }

    protected Repository(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.owner = in.readParcelable(Owner.class.getClassLoader());
        this.starsCount = in.readInt();
        this.forksCount = in.readInt();
    }

    public static final Creator<Repository> CREATOR = new Creator<Repository>() {
        @Override
        public Repository createFromParcel(Parcel source) {
            return new Repository(source);
        }

        @Override
        public Repository[] newArray(int size) {
            return new Repository[size];
        }
    };
}
