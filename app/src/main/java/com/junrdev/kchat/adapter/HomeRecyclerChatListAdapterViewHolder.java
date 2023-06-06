package com.junrdev.kchat.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.junrdev.kchat.R;

public class HomeRecyclerChatListAdapterViewHolder extends RecyclerView.ViewHolder {

    private ImageView chatUserIcon;
    private TextView chatUserName;
    private TextView chatUserDescription;

    private Context context;

    public CardView chatItemCard;
    public HomeRecyclerChatListAdapterViewHolder(@NonNull View itemView, @NonNull Context context) {
        super(itemView);

        chatUserIcon = itemView.findViewById(R.id.chatItemImage);
        chatUserName = itemView.findViewById(R.id.chatItemUserName);
        chatUserDescription = itemView.findViewById(R.id.chatItemUserDescription);
        this.context = context;
        chatItemCard = itemView.findViewById(R.id.chatItemCard);
    }

    public ImageView getChatUserIcon() {
        return chatUserIcon;
    }

    public void setChatUserIcon(int chatUserIcon) {
        Drawable drawable = ContextCompat.getDrawable(context, chatUserIcon);
        this.chatUserIcon.setImageDrawable(drawable);
    }

    public TextView getChatUserName() {
        return chatUserName;
    }

    public void setChatUserName(String  chatUserName) {
        this.chatUserName.setText(chatUserName);
    }

    public TextView getChatUserDescription() {
        return chatUserDescription;
    }

    public void setChatUserDescription(String chatUserDescription) {
        this.chatUserDescription.setText(chatUserDescription);
    }
}
