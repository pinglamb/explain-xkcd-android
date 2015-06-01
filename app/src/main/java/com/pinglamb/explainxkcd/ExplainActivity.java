package com.pinglamb.explainxkcd;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class ExplainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get intent, action and MIME type
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            String url = intent.getStringExtra(Intent.EXTRA_TEXT);
            if (url != null && url.contains("xkcd")) {
                Uri uri = Uri.parse(url);
                String path = uri.getPath();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.explainxkcd.com" + path));
                startActivity(i);
                finish();
                return;
            }
        }

        Toast.makeText(this, "I don't know how to explain :(", Toast.LENGTH_LONG).show();
        finish();
    }
}
