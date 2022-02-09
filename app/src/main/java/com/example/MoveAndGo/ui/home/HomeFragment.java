
package com.example.MoveAndGo.ui.home;

import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.MoveAndGo.MainActivity;
import com.example.MoveAndGo.R;
import com.example.MoveAndGo.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    //Variables declaration
    private FragmentHomeBinding binding;

    /*
    Creates the view
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*
        Navigates to the following page when the "Enter" button is clicked.
        The navigation can be seen in the app/res/navigation/mobile_navigation.xml.
         */
        view.findViewById(R.id.enter_button).setOnClickListener(view1 -> NavHostFragment.findNavController(HomeFragment.this)
                .navigate(R.id.action_nav_home_to_nav_controller));

        /*
        Gets the bluetooth adapter of the MainActivity
         */
        BluetoothAdapter bluetoothAdapter = MainActivity.getBluetoothAdapter();

        /*
        Disables the "Enter" button when there is no bluetooth enabled
         */
        /*if (!bluetoothAdapter.isEnabled()){
            view.findViewById(R.id.enter_button).setEnabled(false);
            MainActivity.bluetoothEnabled = false;
        } else {
            view.findViewById(R.id.enter_button).setEnabled(true);
            MainActivity.bluetoothEnabled = true;
        }*/
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