package com.junrdev.kchat.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.junrdev.kchat.R;
import com.junrdev.kchat.adapter.viewholders.LeftChatBubbleViewHolder;
import com.junrdev.kchat.adapter.viewholders.RightChatBubbleViewHolder;
import com.junrdev.kchat.commons.ChatItemPosition;
import com.junrdev.kchat.commons.DemoBubble;
import com.junrdev.kchat.model.Message;

import java.util.List;

public class SingleChatItemRecyclerAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<DemoBubble> bubbles;

    public SingleChatItemRecyclerAdapter(Context context, List<DemoBubble> bubbles) {
        this.context = context;
        this.bubbles = bubbles;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rview = LayoutInflater.from(parent.getContext()).inflate(R.layout.rightchatitem, parent, false);
        View lview = LayoutInflater.from(parent.getContext()).inflate(R.layout.leftchatitem, parent, false);

        return viewType == ChatItemPosition.RIGHT.getValue() ? new RightChatBubbleViewHolder(rview) : new LeftChatBubbleViewHolder(lview);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof LeftChatBubbleViewHolder)
            ((LeftChatBubbleViewHolder) holder).chatContent.setText(bubbles.get(position).getMessage().getContent());
        else
            ((RightChatBubbleViewHolder) holder).chatContent.setText(bubbles.get(position).getMessage().getContent());
    }

    @Override
    public int getItemCount() {
        return bubbles.size();
    }

    @Override
    public int getItemViewType(int position) {
        DemoBubble bubble = bubbles.get(position);
        return bubble.getPosition() == ChatItemPosition.RIGHT ? ChatItemPosition.RIGHT.getValue() : ChatItemPosition.LEFT.getValue();
    }
}

