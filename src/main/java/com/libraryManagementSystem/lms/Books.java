package com.libraryManagementSystem.lms;

public class Books {
    private static Long count = 0L;
    private Long id;
    private String title;
    private String author;
    private Boolean isAvailable;

    public Books() {
    }

    public Books(String title, String author) {
        this.id = ++count;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id='" + id + '\''+
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
