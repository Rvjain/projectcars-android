package com.triloucoazar.projectcars.viewholders;

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

    public PostViewHolder(View convertView) {
        ButterKnife.bind(this, convertView);
    }

    public void render(Post post) {
        plate.setText(post.getCarPlate());
        message.setText(post.getMessage());
    }
}
