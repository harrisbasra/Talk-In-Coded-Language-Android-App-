package com.example.coddedlang;

import android.annotation.SuppressLint;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.EditText;
import android.content.ClipboardManager;
import com.example.coddedlang.databinding.ActivityFullscreenBinding;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler(Looper.myLooper());
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar
            if (Build.VERSION.SDK_INT >= 30) {
                mContentView.getWindowInsetsController().hide(
                        WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
            } else {
                // Note that some of these constants are new as of API 16 (Jelly Bean)
                // and API 19 (KitKat). It is safe to use them, as they are inlined
                // at compile-time and do nothing on earlier devices.
                mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
            }
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (AUTO_HIDE) {
                        delayedHide(AUTO_HIDE_DELAY_MILLIS);
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    view.performClick();
                    break;
                default:
                    break;
            }
            return false;
        }
    };
    private ActivityFullscreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFullscreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mVisible = true;
        mControlsView = binding.fullscreenContent;
        mContentView = binding.fullscreenContent;

        // Set up the user interaction to manually show or hide the system UI.
        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle();
            }
        });

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
        binding.dummyButton.setOnTouchListener(mDelayHideTouchListener);
        EditText a1 = findViewById(R.id.editTextTextPersonName5);
        TextView t1 = findViewById(R.id.textView17);
        Button b1 = findViewById(R.id.dummy_button2);
        String t1a = "";
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FullscreenActivity.this, "Copied to ClipBoard...!", Toast.LENGTH_LONG).show();
                String a1a = a1.getText().toString();
                char [] w = a1a.toCharArray();
                for(int i=0;i<a1a.length();i++){

                    if(w[i]>=97&&w[i]<=122){
                        w[i]-=32;
                    }
                    if (w[i]==' '){
                        w[i]='|';
                        continue;
                    }
                    if (w[i]=='A'){
                        w[i]='G';
                        continue;
                    }
                    if(w[i]=='B'){
                        w[i]='P';
                        continue;
                    }
                    if (w[i]=='C'){
                        w[i]='X';
                        continue;
                    }
                    if(w[i]=='D'){
                        w[i]='B';
                        continue;
                    }
                    if (w[i]=='E'){
                        w[i]='Z';
                        continue;
                    }
                    if(w[i]=='F'){
                        w[i]='V';
                        continue;
                    }
                    if (w[i]=='G'){
                        w[i]='W';
                        continue;
                    }
                    if(w[i]=='H'){
                        w[i]='A';
                        continue;
                    }
                    if (w[i]=='I'){
                        w[i]='R';
                        continue;
                    }
                    if(w[i]=='J'){
                        w[i]='F';
                        continue;
                    }
                    if (w[i]=='K'){
                        w[i]='J';
                        continue;
                    }
                    if(w[i]=='L'){
                        w[i]='Q';
                        continue;
                    }
                    if (w[i]=='M'){
                        w[i]='E';
                        continue;
                    }
                    if(w[i]=='N'){
                        w[i]='M';
                        continue;
                    }
                    if (w[i]=='O'){
                        w[i]='N';
                        continue;
                    }
                    if(w[i]=='P'){
                        w[i]='C';
                        continue;
                    }
                    if (w[i]=='Q'){
                        w[i]='Y';
                        continue;
                    }
                    if(w[i]=='R'){
                        w[i]='L';
                        continue;
                    }
                    if (w[i]=='S'){
                        w[i]='I';
                        continue;
                    }
                    if(w[i]=='T'){
                        w[i]='T';
                        continue;
                    }
                    if (w[i]=='U'){
                        w[i]='S';
                        continue;
                    }
                    if(w[i]=='V'){
                        w[i]='D';
                        continue;
                    }
                    if (w[i]=='W'){
                        w[i]='U';
                        continue;
                    }
                    if(w[i]=='X'){
                        w[i]='K';
                        continue;
                    }
                    if (w[i]=='Y'){
                        w[i]='O';
                        continue;
                    }
                    if(w[i]=='Z'){
                        w[i]='H';
                        continue;
                    }
                    if(w[i]=='0'){
                        w[i]='1';
                        continue;
                    }
                    if (w[i]=='1'){
                        w[i]='6';
                        continue;
                    }
                    if(w[i]=='2'){
                        w[i]='3';
                        continue;
                    }
                    if (w[i]=='3'){
                        w[i]='7';
                        continue;
                    }
                    if(w[i]=='4'){
                        w[i]='0';
                        continue;
                    }
                    if (w[i]=='5'){
                        w[i]='9';
                        continue;
                    }
                    if(w[i]=='6'){
                        w[i]='5';
                        continue;
                    }
                    if (w[i]=='7'){
                        w[i]='2';
                        continue;
                    }
                    if(w[i]=='8'){
                        w[i]='4';
                        continue;
                    }
                    if(w[i]=='9'){
                        w[i]='8';
                        continue;
                    }

                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < w.length; i++) {
                    sb.append(w[i]);
                }
                a1a = sb.toString();
                t1.setText("The Encrypted Cipher is :: "+a1a);
                ClipboardManager manager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("text", a1a);
                manager.setPrimaryClip(clipData);
                a1.setText("");
            }
        });
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        EditText a2 = findViewById(R.id.editTextTextPersonName4);
        TextView t2 = findViewById(R.id.textView18);
        Button b2 = findViewById(R.id.dummy_button);
        String t2a = "";
        b2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Intent g = new Intent(FullscreenActivity.this, ForegroundCheck.class);
                //startService(g);
                //startForegroundService(g);
                Toast.makeText(FullscreenActivity.this, "Copied to ClipBoard...!", Toast.LENGTH_LONG).show();
                String a2a = a2.getText().toString();
                char [] w = a2a.toCharArray();
                for(int i=0;i<a2a.length();i++){
                    if (w[i]=='|'){
                        w[i]=' ';
                        continue;
                    }
                    if (w[i]=='G'){
                        w[i]='A';
                        continue;
                    }
                    if(w[i]=='P'){
                        w[i]='B';
                        continue;
                    }
                    if (w[i]=='X'){
                        w[i]='C';
                        continue;
                    }
                    if(w[i]=='B'){
                        w[i]='D';
                        continue;
                    }
                    if (w[i]=='Z'){
                        w[i]='E';
                        continue;
                    }
                    if(w[i]=='V'){
                        w[i]='F';
                        continue;
                    }
                    if (w[i]=='W'){
                        w[i]='G';
                        continue;
                    }
                    if(w[i]=='A'){
                        w[i]='H';
                        continue;
                    }
                    if (w[i]=='R'){
                        w[i]='I';
                        continue;
                    }
                    if(w[i]=='F'){
                        w[i]='J';
                        continue;
                    }
                    if (w[i]=='J'){
                        w[i]='K';
                        continue;
                    }
                    if(w[i]=='Q'){
                        w[i]='L';
                        continue;
                    }
                    if (w[i]=='E'){
                        w[i]='M';
                        continue;
                    }
                    if(w[i]=='M'){
                        w[i]='N';
                        continue;
                    }
                    if (w[i]=='N'){
                        w[i]='O';
                        continue;
                    }
                    if(w[i]=='C'){
                        w[i]='P';
                        continue;
                    }
                    if (w[i]=='Y'){
                        w[i]='Q';
                        continue;
                    }
                    if(w[i]=='L'){
                        w[i]='R';
                        continue;
                    }
                    if (w[i]=='I'){
                        w[i]='S';
                        continue;
                    }
                    if(w[i]=='T'){
                        w[i]='T';
                        continue;
                    }
                    if (w[i]=='S'){
                        w[i]='U';
                        continue;
                    }
                    if(w[i]=='D'){
                        w[i]='V';
                        continue;
                    }
                    if (w[i]=='U'){
                        w[i]='W';
                        continue;
                    }
                    if(w[i]=='K'){
                        w[i]='X';
                        continue;
                    }
                    if (w[i]=='O'){
                        w[i]='Y';
                        continue;
                    }
                    if(w[i]=='H'){
                        w[i]='Z';
                        continue;
                    }
                    if(w[i]=='1'){
                        w[i]='0';
                        continue;
                    }
                    if (w[i]=='6'){
                        w[i]='1';
                        continue;
                    }
                    if(w[i]=='3'){
                        w[i]='2';
                        continue;
                    }
                    if (w[i]=='7'){
                        w[i]='3';
                        continue;
                    }
                    if(w[i]=='0'){
                        w[i]='4';
                        continue;
                    }
                    if (w[i]=='9'){
                        w[i]='5';
                        continue;
                    }
                    if(w[i]=='5'){
                        w[i]='6';
                        continue;
                    }
                    if (w[i]=='2'){
                        w[i]='7';
                        continue;
                    }
                    if(w[i]=='4'){
                        w[i]='8';
                        continue;
                    }
                    if(w[i]=='8'){
                        w[i]='9';
                        continue;
                    }

                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < w.length; i++) {
                    sb.append(w[i]);
                }
                a2a = sb.toString();
                t2.setText("The Decrypted Cipher is :: "+a2a);
                ClipboardManager manager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("text", a2a);
                manager.setPrimaryClip(clipData);
//                a2.setText("");
            }
        });
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        //Button bbbbb = findViewById(R.id.nextpage);
//        Intent np = new Intent(FullscreenActivity.this,Second.class);
//        bbbbb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //startActivity(np);
//            }
//        });
//       // Button harry = findViewById(R.id.nextpage2);
//        Intent hhhhh = new Intent (FullscreenActivity.this, FileReaderManual.class);
//        harry.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //startActivity(hhhhh);
//            }
//        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    private void show() {
        // Show the system bar
        if (Build.VERSION.SDK_INT >= 30) {
            mContentView.getWindowInsetsController().show(
                    WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
        } else {
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        }
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in delay milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }
}