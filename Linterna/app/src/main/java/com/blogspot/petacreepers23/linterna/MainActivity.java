package com.blogspot.petacreepers23.linterna;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.security.Policy;

public class MainActivity extends AppCompatActivity {

    Switch s;
    ConstraintLayout cl;
    CameraManager man;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s = (Switch)findViewById(R.id.switch1);
        cl = (ConstraintLayout)findViewById(R.id.conslay);

        String cameraId = "";
        man = (CameraManager)getSystemService(Context.CAMERA_SERVICE);
        try {
            cameraId = man.getCameraIdList()[0];
        }catch (CameraAccessException e){
            e.printStackTrace();
        }

        final String finalCameraId = cameraId;
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
                if (bChecked) {
                    //switchOn);
                    try {
                        man.setTorchMode(finalCameraId,true);
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }

                } else {
                    //(switchOff);
                    try {
                        man.setTorchMode(finalCameraId,false);
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

}
