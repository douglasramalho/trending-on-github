package br.com.douglasmotta.githubdagger2.data.model;

public class Repository {

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
}
