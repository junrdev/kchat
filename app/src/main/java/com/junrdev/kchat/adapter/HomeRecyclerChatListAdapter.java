package com.junrdev.kchat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.junrdev.kchat.R;
import com.junrdev.kchat.adapter.viewholders.HomeRecyclerChatListAdapterViewHolder;
import com.junrdev.kchat.commons.ChatItemClickHandler;
import com.junrdev.kchat.model.User;

import java.util.List;

public class HomeRecyclerChatListAdapter extends RecyclerView.Adapter<HomeRecyclerChatListAdapterViewHolder> {

    private Context context;
    private ChatItemClickHandler clickHandler;

    private List<User> userList;

    private HomeRecyclerChatListAdapter() {
    }

    public HomeRecyclerChatListAdapter(Context context, List<User> userList, ChatItemClickHandler clickHandler) {
        this.context = context;
        this.clickHandler = clickHandler;
        this.userList = userList;
    }

    @NonNull
    @Override
    public HomeRecyclerChatListAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chatitem, parent, false);
        return new HomeRecyclerChatListAdapterViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRecyclerChatListAdapterViewHolder holder, int position) {

        //set fields
        holder.setChatUserName(userList.get(position).getUserName());
        holder.setChatUserDescription(userList.get(position).getDescription());
        holder.setChatUserIcon(userList.get(position).getProfilePicLink());

        holder.chatItemCard.setOnClickListener(v -> {
            clickHandler.handleItemClicked(userList.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
