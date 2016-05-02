package com.fujitsu.fs.javalab.poll.webapp.entity;

import java.io.Serializable;

public class Poll implements Serializable {

    private Long id;

    private String title;

    public Poll() {
    }

    public Poll(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Poll{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
