package com.triloucoazar.projectcars.analytics;

public enum AnalyticsEvent {
    CreatePost("Create post");

    private final String event;

    AnalyticsEvent(String eventName) {
        this.event = eventName;
    }

    public String toString() {
        return this.event;
    }
}
