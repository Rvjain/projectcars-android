package com.triloucoazar.projectcars.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.triloucoazar.projectcars.R;
import com.triloucoazar.projectcars.models.Post;
import com.triloucoazar.projectcars.viewholders.PostViewHolder;

import java.util.List;

public class PostAdapter extends ArrayAdapter<Post> {

    private final LayoutInflater inflater;

    public PostAdapter(Context context, List<Post> posts) {
        super(context, 0, posts);
        inflater = LayoutInflater.from(getContext());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PostViewHolder viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.cell_post, parent, false);
            viewHolder = new PostViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        viewHolder = (PostViewHolder) convertView.getTag();
        viewHolder.render(getItem(position));

        return convertView;
    }
}
