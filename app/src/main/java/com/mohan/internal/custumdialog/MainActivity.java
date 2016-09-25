package com.mohan.internal.custumdialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }


    public void showDialog(final View view) {
        final MyDialogFragment myDialogFragment=new MyDialogFragment();
        myDialogFragment.setCustumDialogListener(new MyDialogFragment.CustumDialogListener() {


            @Override
            public void onClickNext(int value, boolean close, View... views) {

                TextView heading= (TextView) views[0];
                EditText valueView= (EditText) views[1];
                if(close){
                    Log.d(TAG, "onClickNext: "+value);
                    myDialogFragment.dismiss();
                    Toast.makeText(MainActivity.this, "Thank u", Toast.LENGTH_SHORT).show();
                }else {
                    heading.setText("Please add weight");
                    valueView.setHint("Weight in KG's");
                    valueView.setText("");
                    Log.d(TAG, "onClickNext: "+value);
                }



            }

            @Override
            public void onClickSkip() {
                Toast.makeText(MainActivity.this, "Skip Clicked", Toast.LENGTH_SHORT).show();
                myDialogFragment.dismiss();
            }
        });
        DialogFragment dialogFragment=myDialogFragment;
        dialogFragment.show(getSupportFragmentManager(),null);
    }


}
