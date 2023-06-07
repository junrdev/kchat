package com.junrdev.kchat.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.junrdev.kchat.R;
import com.junrdev.kchat.adapter.SingleChatItemRecyclerAdapter;
import com.junrdev.kchat.adapter.TestChatItemsAdapter;
import com.junrdev.kchat.commons.ChatItemPosition;
import com.junrdev.kchat.commons.DemoBubble;
import com.junrdev.kchat.databinding.FragmentConversationactivityBinding;
import com.junrdev.kchat.model.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link conversationactivity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class conversationactivity extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public conversationactivity() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment conversationactivity.
     */
    // TODO: Rename and change types and number of parameters
    public static conversationactivity newInstance(String param1, String param2) {
        conversationactivity fragment = new conversationactivity();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private FragmentConversationactivityBinding binding;


    private RecyclerView chatsRecycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentConversationactivityBinding.inflate(inflater);
        Context context = binding.getRoot().getContext();

        //custom toolbar
        Toolbar toolbar = requireActivity().findViewById(R.id.singleChatToolBar);
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);

        List<DemoBubble> demoBubbles = new ArrayList<>();
        demoBubbles.add(new DemoBubble(ChatItemPosition.RIGHT, new Message("Hello world")));
        demoBubbles.add(new DemoBubble(ChatItemPosition.LEFT, new Message("Hello world this is a long text of a huge size length")));
        demoBubbles.add(new DemoBubble(ChatItemPosition.RIGHT, new Message("Hello world")));
        demoBubbles.add(new DemoBubble(ChatItemPosition.LEFT, new Message("Hello world")));
        demoBubbles.add(new DemoBubble(ChatItemPosition.RIGHT, new Message("Hello world this is a long text of a huge size length")));
        demoBubbles.add(new DemoBubble(ChatItemPosition.LEFT, new Message("Hello world")));

        //chat view adapter
        chatsRecycler = binding.singleChatListRecycler;
        chatsRecycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
//        chatsRecycler.setAdapter(new SingleChatItemRecyclerAdapter(demoBubbles, context));
        chatsRecycler.setAdapter(new TestChatItemsAdapter(context, demoBubbles));

        Log.d("TAG", "onCreateView: "+ demoBubbles.get(0).getMessage().getContent());

        return binding.getRoot();
    }
}