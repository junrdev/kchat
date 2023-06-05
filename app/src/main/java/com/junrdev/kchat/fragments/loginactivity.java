package com.junrdev.kchat.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.junrdev.kchat.R;
import com.junrdev.kchat.databinding.FragmentLoginactivityBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link loginactivity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class loginactivity extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private FragmentLoginactivityBinding binding;

    private LinearLayout loginLoading;

    public loginactivity() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment loginactivity.
     */
    // TODO: Rename and change types and number of parameters
    public static loginactivity newInstance(String param1, String param2) {
        loginactivity fragment = new loginactivity();
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


    private EditText email, password;

    private FirebaseAuth firebaseAuth;

    private FirebaseUser currentUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginactivityBinding.inflate(inflater);

        firebaseAuth = FirebaseAuth.getInstance();

        email = binding.loginEmail;
        password = binding.loginPassword;
        loginLoading = binding.loadinglayout.loginLoading;

        loginLoading.setVisibility(View.GONE);

        if (currentUser != null) {
            loadHome();
        }

        binding.loginButton.setOnClickListener(v -> {

            if (TextUtils.isEmpty(email.getText()) || TextUtils.isEmpty(password.getText()))
                Toast.makeText(binding.getRoot().getContext(), "Provide all fields", Toast.LENGTH_SHORT).show();
            else {

                loginLoading.setVisibility(View.VISIBLE);
                firebaseAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            currentUser = task.getResult().getUser();
                            loginLoading.setVisibility(View.GONE);
                            Navigation.findNavController(requireView()).navigate(R.id.action_loginactivity_to_chatlist);
                        }
                    }
                });
            }

        });

        binding.signUpPrompt.setOnClickListener(v ->
                Navigation.findNavController(requireView()).navigate(R.id.action_loginactivity_to_signupactivity)
        );

        return binding.getRoot();
    }

    private void loadHome() {
        Navigation.findNavController(requireView()).navigate(R.id.action_loginactivity_to_chatlist);

        assert  getActivity() != null;
        getActivity().finish();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TAG", "onResume: ");
        if (currentUser != null) {
            assert getActivity() != null;
            getActivity().finish();
        }
    }
}