package com.junrdev.kchat.adapter;

import android.content.Context;
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

    private List<DemoBubble> bubbles;
    private Context context;


    private SingleChatItemRecyclerAdapter() {
    }


    public SingleChatItemRecyclerAdapter(List<DemoBubble> bubbles, Context context) {
        this.bubbles = bubbles;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View leftView = LayoutInflater.from(parent.getContext()).inflate(R.layout.leftchatitem, parent, false);
        View rightView = LayoutInflater.from(parent.getContext()).inflate(R.layout.leftchatitem, parent, false);

        if (viewType == ChatItemPosition.RIGHT.getValue())
            return new RightChatBubbleViewHolder(rightView);
        else if (viewType == ChatItemPosition.LEFT.getValue())
            return new LeftChatBubbleViewHolder(leftView);

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Message message = bubbles.get(position).getMessage();

        if (holder instanceof LeftChatBubbleViewHolder)
            ((LeftChatBubbleViewHolder) holder).bindCard(message);
        else if (holder instanceof RightChatBubbleViewHolder)
            ((RightChatBubbleViewHolder) holder).bindCard(message);

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
