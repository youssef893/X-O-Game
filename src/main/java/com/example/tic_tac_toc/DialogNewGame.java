package com.example.tic_tac_toc;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogNewGame extends AppCompatDialogFragment {
   private TextView dialogText;
   private DialogListner listener;
   private String winner;

    public DialogNewGame(String winner) {
        this.winner = winner;
    }

    @Override
   public Dialog onCreateDialog(Bundle savedInstanceState) {
       AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
       LayoutInflater inflater = getActivity().getLayoutInflater();
       View view = inflater.inflate(R.layout.layout_dialog, null);
       builder.setView(view)
               .setTitle("")
               .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       listener.endGame();
                   }
               })
               .setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       listener.startEewGame();
                   }
               });
       dialogText = view.findViewById(R.id.dialogTxt);
       dialogText.setText(winner);
       return builder.create();
   }
   @Override
   public void onAttach(Context context) {
       super.onAttach(context);
       try {
           listener = (DialogListner) context;
       } catch (ClassCastException e) {
           throw new ClassCastException(context.toString() +
                   "must implement DialogListner");
       }
   }
   public interface DialogListner {
       void startEewGame();
       void endGame();
   }
}
