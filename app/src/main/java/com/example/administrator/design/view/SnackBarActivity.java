
package com.example.administrator.design.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.design.R;

public class SnackBarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar_activivty);
    }

    public void onCLick2(View view) {
        switch (view.getId()) {
            case R.id.btn_sanckBar_toast:
                Toast.makeText(SnackBarActivity.this, "馒头", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_sanckBar_show:
                Snackbar.make(view, "米饭", Snackbar.LENGTH_SHORT)
                        .setAction("面条", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.e("提示", "===都是主食===OnClick: ");
                            }
                        })
                        .show();
                break;
        }
    }
}
