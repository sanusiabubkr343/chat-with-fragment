package com.example.chatwithfragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentB extends Fragment {
    private FragmentBListener listener;
    private EditText editText;
    private TextView replyText;
    private Button buttonOk;
    public interface FragmentBListener {
        void onInputBSent(CharSequence input);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_b, container, false);
        editText = v.findViewById(R.id.edit_text_B);
        buttonOk = v.findViewById(R.id.buttonSend_B);
        replyText = v.findViewById(R.id.replyTextB);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = editText.getText();
                listener.onInputBSent(input);
            }
        });
        return v;
    }
    public void updateEditText(CharSequence newText) {
      replyText.setText(newText);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentBListener) {
            listener = (FragmentBListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentBListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}