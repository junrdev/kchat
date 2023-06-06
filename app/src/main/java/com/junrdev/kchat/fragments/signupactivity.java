package com.junrdev.kchat.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.junrdev.kchat.R;
import com.junrdev.kchat.databinding.FragmentSignupactivityBinding;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link signupactivity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class signupactivity extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentSignupactivityBinding binding;

    public signupactivity() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment signupactivity.
     */
    // TODO: Rename and change types and number of parameters
    public static signupactivity newInstance(String param1, String param2) {
        signupactivity fragment = new signupactivity();
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

    //fields
    private EditText username, email, password, passwordConfirm;


    //error fields
    private TextView emailError, usernameError, passwordError, passwordConfirmError;


    //for email regex validation
    private final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private final Pattern PATTERN   =  Pattern.compile(EMAIL_PATTERN);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSignupactivityBinding.inflate(inflater);

        //fields initialization
        username= binding.signUpName;
        email= binding.signUpEmail;
        password= binding.signUpPassword;
        passwordConfirm= binding.signUpPasswordConfirm;

        //error fields initialization
        emailError = binding.emailError;
        passwordError = binding.passwordError;
        passwordConfirmError = binding.passwordConfirmError;
        usernameError = binding.usernameError;

        Context context = binding.getRoot().getContext();

        binding.signUpButton.setOnClickListener(v ->{
           if(checkFields()){

           }
        });

        binding.loginPrompt.setOnClickListener(v ->{
            Navigation.findNavController(requireView()).popBackStack();
        });
        return binding.getRoot();
    }

    private boolean checkFields() {

        //check fields entered
        if(TextUtils.isEmpty(username.getText())){
            usernameError.setVisibility(View.VISIBLE);
            usernameError.setText(R.string.username_required_error);
            return false;
        }else
            usernameError.setVisibility(View.GONE);


        if(TextUtils.isEmpty(email.getText())){
            emailError.setVisibility(View.VISIBLE);
            emailError.setText(R.string.email_required_error);
            return false;
        }else
            emailError.setVisibility(View.GONE);

        //validate email format
        if(!PATTERN.matcher(email.getText()).matches()){
            emailError.setVisibility(View.VISIBLE);
            emailError.setText(R.string.invalid_email_error);
            return false;
        }else
            emailError.setVisibility(View.GONE);

        if(TextUtils.isEmpty(password.getText())){
            passwordError.setVisibility(View.VISIBLE);
            passwordError.setText(R.string.password_missing_error);
            return false;
        }else
            passwordError.setVisibility(View.GONE);


        if(TextUtils.isEmpty(passwordConfirm.getText())){
            passwordConfirmError.setVisibility(View.VISIBLE);
            passwordConfirmError.setText(R.string.password_confirmation_error);
            return false;
        }else
            passwordConfirmError.setVisibility(View.GONE);


        //validate password lengths and equality
        if(password.getText().length() < 6){
            passwordError.setVisibility(View.VISIBLE);
            passwordError.setText(R.string.short_password_error);
            return false;
        }else
            passwordError.setVisibility(View.GONE);

        if(passwordConfirm.getText().length() < 6){
            passwordConfirmError.setVisibility(View.VISIBLE);
            passwordConfirmError.setText(R.string.short_password_error);
            return false;
        }else
            passwordConfirmError.setVisibility(View.GONE);

        //equality of the two password
        if (!Objects.equals(password.getText(), passwordConfirm.getText())){
            passwordConfirmError.setVisibility(View.VISIBLE);
            passwordConfirmError.setText(R.string.password_mismatch_error);
            return false;
        }else
            passwordConfirmError.setVisibility(View.GONE);

        passwordConfirmError.setText(R.string.fields_ok_message);
        passwordConfirmError.setTextColor(Color.GREEN);
        passwordConfirmError.setVisibility(View.VISIBLE);

        return true;
    }


}