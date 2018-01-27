package com.example.lyy.quartertheeightgroup.view.avtivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lyy.quartertheeightgroup.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SayActivity extends ImmersiveActivity implements View.OnClickListener {

    @BindView(R.id.e_cancel)
    TextView eCancel;
    @BindView(R.id.e_publish)
    TextView ePublish;
    @BindView(R.id.etContent)
    EditText etContent;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.line)
    View line;
    @BindView(R.id.s_image)
    ImageView sImage;

    private PopupWindow mPopWindow;
    private TextView text1;
    private TextView text2;
    private TextView text3;


    //调用系统相册-选择图片
    private static final int IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_say);
        ButterKnife.bind(this);
        eCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow();
            }
        });
        ePublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SayActivity.this, PublishActivity.class);
                startActivity(intent);
            }
        });
    }


    private void showPopupWindow() {

        View contentView = LayoutInflater.from(SayActivity.this).inflate(R.layout.layout_popwindow, null);

        mPopWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        mPopWindow.setContentView(contentView);
        //显示PopupWindow
        View rootview = LayoutInflater.from(SayActivity.this).inflate(R.layout.activity_say, null);
        //解决popwindow和键盘的覆盖问题
        mPopWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        mPopWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        text1 = contentView.findViewById(R.id.pop_save);
        text2 = contentView.findViewById(R.id.pop_never_save);
        text3 = contentView.findViewById(R.id.pop_cancle);
        text1.setOnClickListener(this);
        text2.setOnClickListener(this);
        text3.setOnClickListener(this);
        mPopWindow.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.pop_save:
                Toast.makeText(this, "保存", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pop_never_save:
                Toast.makeText(this, "不保存", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pop_cancle:
                Toast.makeText(this, "取消", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    @OnClick(R.id.s_image)
    public void onClick() {
        //调用相册
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //获取图片路径
        if (requestCode == IMAGE && resultCode == SayActivity.RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            String[] filePathColumns = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePathColumns[0]);
            String imagePath = c.getString(columnIndex);
            showImage(imagePath);
            c.close();
        }
    }
    //加载图片
    private void showImage(String imaePath){
        Bitmap bm = BitmapFactory.decodeFile(imaePath);
        ((ImageView)findViewById(R.id.image)).setImageBitmap(bm);
    }
}
