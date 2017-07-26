package com.example.administrator.design.view;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.design.R;

public class TextInputLayoutActivity extends AppCompatActivity {
    private EditText mEditText;
    private TextInputLayout mTextInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_inputlayout);
        initView();
    }

    private void initView() {
        mEditText = ((EditText) findViewById(R.id.editTextShow));
        mTextInputLayout = ((TextInputLayout) findViewById(R.id.textInputLayout));
    }

    public void onClick(View view) {
        String pwd = mEditText.getText().toString();
        if (TextUtils.isEmpty(pwd)) {
            mTextInputLayout.setErrorEnabled(true);
            mTextInputLayout.setError("输入内容为空");
        } else {
            mTextInputLayout.setErrorEnabled(false);
            Toast.makeText(TextInputLayoutActivity.this, "您的账户余额为一个亿", Toast.LENGTH_SHORT).show();
        }
    }
}
