package com.example.pratik.sugarormdemo;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends Fragment {


    public TestFragment() {
        // Required empty public constructor
    }

    public static TestFragment newInstance() {
        Bundle args = new Bundle();

        TestFragment fragment = new TestFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvHello = (TextView) view.findViewById(R.id.tvHello);

        tvHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog();

            }
        });

    }

    public void openDialog() {

        Dialog dialog = new Dialog(getActivity(), R.style.DialogSlideAnim);

        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);

        WindowManager.LayoutParams wmlp = window.getAttributes();
        wmlp.width = android.view.WindowManager.LayoutParams.MATCH_PARENT;
        wmlp.height = android.view.WindowManager.LayoutParams.WRAP_CONTENT;

        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.setContentView(R.layout.selectpic_dialog);

        dialog.setCancelable(true);

        dialog.show();


    }
}
