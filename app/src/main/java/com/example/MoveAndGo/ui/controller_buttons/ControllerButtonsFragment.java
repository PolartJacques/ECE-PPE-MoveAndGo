
package com.example.MoveAndGo.ui.controller_buttons;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;

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

        //Variables declaration
        Button button0 = view.findViewById(R.id.button0);
        Button button1 = view.findViewById(R.id.button1);
        Button button2 = view.findViewById(R.id.button2);
        Button button3 = view.findViewById(R.id.button3);
        Button button4 = view.findViewById(R.id.button4);
        Button button5 = view.findViewById(R.id.button5);
        Button button6 = view.findViewById(R.id.button6);
        Button button7 = view.findViewById(R.id.button7);
        Button button8 = view.findViewById(R.id.button8);
        Button button9 = view.findViewById(R.id.button9);

        Switch switch0 = view.findViewById(R.id.switch0);
        Switch switch1 = view.findViewById(R.id.switch1);
        Switch switch2 = view.findViewById(R.id.switch2);
        Switch switch3 = view.findViewById(R.id.switch3);
        Switch switch4 = view.findViewById(R.id.switch4);
        Switch switch5 = view.findViewById(R.id.switch5);
        Switch switch6 = view.findViewById(R.id.switch6);
        Switch switch7 = view.findViewById(R.id.switch7);
        Switch switch8 = view.findViewById(R.id.switch8);
        Switch switch9 = view.findViewById(R.id.switch9);

        Handler mHandler = new Handler();

        /*
        repeats the action while the user touches the button
        */
        button0.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //Button pressed
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        /*
                        Sends an action to the raspberry
                         */
                        MainActivity.SendAction("0");

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

        button1.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //Button pressed
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.SendAction("1");
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

        button2.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //Button pressed
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.SendAction("2");
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

        button3.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //Button pressed
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.SendAction("3");
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

        button4.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //Button pressed
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.SendAction("4");
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

        button5.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //Button pressed
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.SendAction("5");
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

        button6.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //Button pressed
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.SendAction("6");
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

        button7.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //Button pressed
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.SendAction("7");
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

        button8.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //Button pressed
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.SendAction("8");
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

        button9.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //Button pressed
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.SendAction("9");
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

        switch0.setOnTouchListener((v, event) -> {
            button0.setEnabled(switch0.isChecked());
            return false;
        });

        switch1.setOnTouchListener((v, event) -> {
            button1.setEnabled(switch1.isChecked());
            return false;
        });

        switch2.setOnTouchListener((v, event) -> {
            button2.setEnabled(switch2.isChecked());
            return false;
        });

        switch3.setOnTouchListener((v, event) -> {
            button3.setEnabled(switch3.isChecked());
            return false;
        });

        switch4.setOnTouchListener((v, event) -> {
            button4.setEnabled(switch4.isChecked());
            return false;
        });

        switch5.setOnTouchListener((v, event) -> {
            button5.setEnabled(switch5.isChecked());
            return false;
        });

        switch6.setOnTouchListener((v, event) -> {
            button6.setEnabled(switch6.isChecked());
            return false;
        });

        switch7.setOnTouchListener((v, event) -> {
            button7.setEnabled(switch7.isChecked());
            return false;
        });

        switch8.setOnTouchListener((v, event) -> {
            button8.setEnabled(switch8.isChecked());
            return false;
        });

        switch9.setOnTouchListener((v, event) -> {
            button9.setEnabled(switch9.isChecked());
            return false;
        });
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