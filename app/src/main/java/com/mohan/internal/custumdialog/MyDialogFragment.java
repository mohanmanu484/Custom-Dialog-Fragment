package com.mohan.internal.custumdialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

/**
 * Created by mohan on 25/9/16.
 */

public class MyDialogFragment extends DialogFragment implements View.OnClickListener {

    CustumDialogListener custumDialogListener;

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
        nextButton.setOnClickListener(this);
        skipButton.setOnClickListener(this);
        builder.setView(view);
        AlertDialog alertDialog=builder.create();
        return alertDialog;
    }

    interface CustumDialogListener{
        void onClickNext();
        void onClickSkip();
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        if(id==R.id.btNext){
            custumDialogListener.onClickNext();
        }else if(id==R.id.btSkip){
            custumDialogListener.onClickSkip();
        }
    }

}
