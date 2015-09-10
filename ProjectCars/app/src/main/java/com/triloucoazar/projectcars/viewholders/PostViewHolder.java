package com.triloucoazar.projectcars.viewholders;

import android.text.format.DateUtils;
import android.view.View;
import android.widget.TextView;

import com.triloucoazar.projectcars.R;
import com.triloucoazar.projectcars.models.Post;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PostViewHolder {

    @Bind(R.id.cell_post_plate)
    TextView plate;

    @Bind(R.id.cell_post_message)   
    TextView message;

    @Bind(R.id.cell_post_info)
    TextView info;

    public PostViewHolder(View convertView) {
        ButterKnife.bind(this, convertView);
    }

    public void render(Post post) {
        plate.setText(post.getCarPlate());
        message.setText(post.getMessage());
        info.setText(formattedInfo(post));
    }

    private String formattedInfo(Post post) {
        long now = System.currentTimeMillis();
        String date = DateUtils.getRelativeTimeSpanString(post.getCreatedAt().getTime(), now, DateUtils.SECOND_IN_MILLIS).toString();

        return post.getUserName() + ", " + date;
    }
}
