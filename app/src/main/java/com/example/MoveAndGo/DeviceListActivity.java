
package com.example.MoveAndGo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


import java.util.Set;

public class DeviceListActivity extends AppCompatActivity {
    //Variables declaration
    private ProgressBar progressScanDevices;

    private ArrayAdapter<String> adapterAvailableDevices;
    private Context context;
    private BluetoothAdapter bluetoothAdapter;

    /*
    Function called when the activity is launched.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_list);
        context = this;

        init();
    }

    /*
    Initiates the bluetooth connection
     */
    private void init() {
        /*
        Variables attributions
         */
        ListView listPairedDevices = findViewById(R.id.list_paired_devices);
        ListView listAvailableDevices = findViewById(R.id.list_available_devices);
        progressScanDevices = findViewById(R.id.progress_scan_devices);

        ArrayAdapter<String> adapterPairedDevices = new ArrayAdapter<>(context, R.layout.device_list_item);
        adapterAvailableDevices = new ArrayAdapter<>(context, R.layout.device_list_item);

        listPairedDevices.setAdapter(adapterPairedDevices);
        listAvailableDevices.setAdapter(adapterAvailableDevices);

        /*
        Sets on click listener
         */
        listAvailableDevices.setOnItemClickListener((adapterView, view, i, l) -> {
            /*
            A device is selected. No need to continue the Discovery.
             */
            bluetoothAdapter.cancelDiscovery();

            String info = ((TextView) view).getText().toString();
            String address = info.substring(info.length() - 17);

            Toast.makeText(context, "Selected:\n" + info, Toast.LENGTH_SHORT).show();

            Log.d("Address", address);

            /*
            Sets the address of the chosen device in an intent
             */
            Intent intent = new Intent();
            intent.putExtra("deviceAddress", address);

            /*
             Sends the intent and a result confirmation to the main activity
             */
            setResult(RESULT_OK, intent);
            finish();
        });

        /*
        Gets the paired devices
         */
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();

        if (pairedDevices != null && pairedDevices.size() > 0) {
            for (BluetoothDevice device : pairedDevices) {
                adapterPairedDevices.add(device.getName() + "\n" + device.getAddress());
            }
        }

        /*
        When a device is found or the bluetooth discovery is finished, calls the
        bluetoothDeviceListener method
         */
        IntentFilter intentFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(bluetoothDeviceListener, intentFilter);
        IntentFilter intentFilter1 = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        registerReceiver(bluetoothDeviceListener, intentFilter1);

        /*
        Sets on click listener
         */
        listPairedDevices.setOnItemClickListener((adapterView, view, i, l) -> {
            /*
            A device is selected. No need to continue the Discovery.
             */
            bluetoothAdapter.cancelDiscovery();

            String info = ((TextView) view).getText().toString();
            String address = info.substring(info.length() - 17);

            Toast.makeText(context, "Selected:\n" + info, Toast.LENGTH_SHORT).show();

            Log.d("Address", address);

            /*
            Sets the address of the chosen device in an intent
             */
            Intent intent = new Intent();
            intent.putExtra("deviceAddress", address);

            /*
             Sends the intent and a result confirmation to the main activity
             */
            setResult(Activity.RESULT_OK, intent);
            finish();
        });

        /*
        Starts the devices' scan
         */
        scanDevices();
    }

    private final BroadcastReceiver bluetoothDeviceListener = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                if (device.getBondState() != BluetoothDevice.BOND_BONDED) {
                    /*
                    Adds the device name to the list
                     */
                    adapterAvailableDevices.add(device.getName() + "\n" + device.getAddress());
                }
            } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                progressScanDevices.setVisibility(View.GONE);
                if (adapterAvailableDevices.getCount() == 0) {
                    Toast.makeText(context, "No new devices found", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Click on the device to start the connection", Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_device_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*
        Sets action to the menu buttons
         */
        switch (item.getItemId()) {
            case R.id.menu_search_devices_start:
                scanDevices();
                return true;
            case R.id.menu_home:
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void scanDevices() {
        /*
        Starts the discovery of the devices
         */
        progressScanDevices.setVisibility(View.VISIBLE);
        adapterAvailableDevices.clear();
        Toast.makeText(context, "Scan started", Toast.LENGTH_SHORT).show();

        if (bluetoothAdapter.isDiscovering()) {
            bluetoothAdapter.cancelDiscovery();
        }

        bluetoothAdapter.startDiscovery();
    }

    /*
    Destroys the view
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (bluetoothDeviceListener != null) {
            unregisterReceiver(bluetoothDeviceListener);
        }
    }
}
