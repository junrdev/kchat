package com.junrdev.kchat.adapter.viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.junrdev.kchat.R;
import com.junrdev.kchat.model.Message;

public class LeftChatBubbleViewHolder extends RecyclerView.ViewHolder {

    public TextView chatContent;

    public CardView chatCard;


    public LeftChatBubbleViewHolder(@NonNull View itemView) {
        super(itemView);

        chatCard = itemView.findViewById(R.id.leftChatBubbleCard);
        chatContent = itemView.findViewById(R.id.leftChatTextContent);
    }

    public void bindCard(Message message){
        chatContent.setText(message.getContent());
    }
}
