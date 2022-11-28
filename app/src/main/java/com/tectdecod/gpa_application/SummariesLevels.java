package com.tectdecod.gpa_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class SummariesLevels extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //outside from youtube, it is hide the Action bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_summaries_levels);
    }
    // level 5
    public void openWebSite1(View V) {
        Button ed = (Button) findViewById(R.id.Level_5_btn);
        String url = "https://www.dropbox.com/sh/okbj0nhsxu0l0o7/AABH12XFPNV9Hqi12_jAN_dna?dl=0" ;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }
    // level 6
    public void openWebSite2(View V) {
        Button ed = (Button) findViewById(R.id.Level_6_btn);
        String url = "https://www.dropbox.com/sh/1xziugnog7hwn86/AAAinEnNRcfLL718RC_OVwPFa?dl=0" ;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }
    // level 7
    public void openWebSite3(View V) {
        Button ed = (Button) findViewById(R.id.Level_7_btn);
        String url = "https://www.dropbox.com/sh/ys2x6euv6u2zlay/AAC1HA6U1wWlpbDIU0MMxKJSa?dl=0" ;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }
    //level 8
    public void openWebSite4(View V) {
        Button ed = (Button) findViewById(R.id.Level_8_btn);
        String url = "https://www.dropbox.com/sh/1n6e3melnetwqcq/AAC2N22AA3DAR62NpTiYQCpTa?dl=0" ;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }


}


