package com.junrdev.kchat.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.junrdev.kchat.R;
import com.junrdev.kchat.databinding.FragmentChatlistBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link chatlist#newInstance} factory method to
 * create an instance of this fragment.
 */
public class chatlist extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public chatlist() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment chatlist.
     */
    // TODO: Rename and change types and number of parameters
    public static chatlist newInstance(String param1, String param2) {
        chatlist fragment = new chatlist();
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

    private FragmentChatlistBinding binding;

    private FirebaseAuth auth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentChatlistBinding.inflate(inflater);
        auth = FirebaseAuth.getInstance();

        binding.LogoutButton.setOnClickListener(v ->{
            auth.signOut();
            Navigation.findNavController(requireView()).popBackStack();
        });

        return binding.getRoot();
    }
}