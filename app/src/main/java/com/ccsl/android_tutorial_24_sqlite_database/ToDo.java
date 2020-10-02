package com.ccsl.android_tutorial_24_sqlite_database;

public class ToDo {
    private int id;
    private String title, venue, description;
    private long started, finished;

    public ToDo(){

    }

    public ToDo(int id, String title, String venue, String description, long started, long finished) {
        this.id = id;
        this.title = title;
        this.venue = venue;
        this.description = description;
        this.started = started;
        this.finished = finished;
    }

    public ToDo(String title, String venue, String description, long started, long finished) {
        this.title = title;
        this.venue = venue;
        this.description = description;
        this.started = started;
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getStarted() {
        return started;
    }

    public void setStarted(long started) {
        this.started = started;
    }

    public long getFinished() {
        return finished;
    }

    public void setFinished(long finished) {
        this.finished = finished;
    }
}
