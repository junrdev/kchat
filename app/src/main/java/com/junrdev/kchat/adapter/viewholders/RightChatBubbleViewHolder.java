package com.junrdev.kchat.adapter.viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.junrdev.kchat.R;
import com.junrdev.kchat.model.Message;

public class RightChatBubbleViewHolder extends RecyclerView.ViewHolder {

    private TextView chatContent;

    public CardView chatCard;


    public RightChatBubbleViewHolder(@NonNull View itemView) {
        super(itemView);

        chatCard = itemView.findViewById(R.id.rightChatBubbleCard);
        chatContent = itemView.findViewById(R.id.rightChatTextContent);
    }

    public void bindCard(Message message){
        chatContent.setText(message.getContent());
    }
}
