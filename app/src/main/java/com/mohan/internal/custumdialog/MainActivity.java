package com.mohan.internal.custumdialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }


    public void showDialog(View view) {
        final MyDialogFragment myDialogFragment=new MyDialogFragment();
        myDialogFragment.setCustumDialogListener(new MyDialogFragment.CustumDialogListener() {
            @Override
            public void onClickNext() {
                Toast.makeText(MainActivity.this, "Next clicked", Toast.LENGTH_SHORT).show();
                myDialogFragment.dismiss();
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
