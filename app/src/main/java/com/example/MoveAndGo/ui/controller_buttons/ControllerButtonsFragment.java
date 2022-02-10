
package com.example.MoveAndGo.ui.controller_buttons;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.MoveAndGo.MainActivity;
import com.example.MoveAndGo.R;
import com.example.MoveAndGo.databinding.FragmentControllerButtonsBinding;

public class ControllerButtonsFragment extends Fragment {
    //Variables declaration
    private FragmentControllerButtonsBinding binding;

    /*
    Creates the view
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentControllerButtonsBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @SuppressLint("ClickableViewAccessibility")
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Handler mHandler = new Handler();
        LinearLayout layoutButtons = view.findViewById(R.id.layoutButtons);

        for (int i = 1; i <= getArguments().getInt("amount"); i++) {
            // create items to add on view
            LinearLayout layoutButton = new LinearLayout(getContext());
            Button button = new Button(getContext());
            EditText editText = new EditText(getContext());

            // set up items
            layoutButton.setOrientation(LinearLayout.HORIZONTAL);
            button.setId(i*2);
            button.setText("button " + i);
            editText.setId(i*2 + 1);
            editText.setText(String.valueOf(i));

            // create params
            LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            params2.weight = 5;

            // button on touch listener
            button.setOnTouchListener((v, event) -> {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //Button pressed
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            MainActivity.SendAction(editText.getText().toString());
                            Toast.makeText(getContext(), editText.getText().toString(), Toast.LENGTH_SHORT).show();
                            mHandler.postDelayed(this, 500); // 0.5 seconds
                        }
                    }, 0); // 0 seconds
                    return false;
                }
                if (event.getAction() == MotionEvent.ACTION_UP){
                    mHandler.removeCallbacksAndMessages(null);
                    return false;
                }
                return false;
            });

            // add elements to the views
            layoutButton.addView(editText, params2);
            layoutButton.addView(button, params2);
            layoutButtons.addView(layoutButton, params1);
        }
    }


    /*
    Destroys the view
    */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}