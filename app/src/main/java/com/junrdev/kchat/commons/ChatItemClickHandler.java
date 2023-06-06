package com.junrdev.kchat.commons;

import android.view.View;

import com.junrdev.kchat.model.User;

public interface ChatItemClickHandler extends View.OnClickListener {

    void handleItemClicked(User user);

}
