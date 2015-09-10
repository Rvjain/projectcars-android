package com.triloucoazar.projectcars.analytics;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.CustomEvent;
import com.triloucoazar.projectcars.models.Post;

public class Analytics {

    public static void trackPostCreation(Post post) {
        CustomEvent customEvent = new CustomEvent(AnalyticsEvent.CreatePost.toString());
        customEvent.putCustomAttribute("plate", post.getCarPlate());
        Answers.getInstance().logCustom(customEvent);
    }
}