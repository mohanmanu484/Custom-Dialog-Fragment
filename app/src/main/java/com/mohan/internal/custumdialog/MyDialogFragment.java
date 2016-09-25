package com.mohan.internal.custumdialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by mohan on 25/9/16.
 */

public class MyDialogFragment extends DialogFragment implements View.OnClickListener {

    CustumDialogListener custumDialogListener;
    TextView heading;
    EditText value;
    static int closeDialog;

    public MyDialogFragment() {
    }

    public void setCustumDialogListener(CustumDialogListener custumDialogListener) {
        this.custumDialogListener = custumDialogListener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_layout, null);
        Button nextButton= (Button) view.findViewById(R.id.btNext);
        Button skipButton= (Button) view.findViewById(R.id.btSkip);
         heading= (TextView) view.findViewById(R.id.tvHeading);
         value= (EditText) view.findViewById(R.id.etValue);
        nextButton.setOnClickListener(this);
        skipButton.setOnClickListener(this);
        builder.setView(view);
        AlertDialog alertDialog=builder.create();
        return alertDialog;
    }

    interface CustumDialogListener{
        void onClickNext(int value,boolean close,View... views);
        void onClickSkip();
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        if(id==R.id.btNext){
            int valueEntered=Integer.valueOf(value.getText().toString());
            custumDialogListener.onClickNext(valueEntered,++closeDialog==2,heading,value);
        }else if(id==R.id.btSkip){
            custumDialogListener.onClickSkip();
        }
    }

}
