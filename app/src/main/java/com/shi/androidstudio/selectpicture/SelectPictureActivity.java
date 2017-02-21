package com.shi.androidstudio.selectpicture;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import me.iwf.photopicker.PhotoPicker;

public class SelectPictureActivity extends AppCompatActivity {

    ListView listView;
    List<String> listImageUrl = new ArrayList<>();
    ImageView imageView;
    AdapterListView adapterListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_picture);

        Button btn_selectPicture = (Button) findViewById(R.id.btn_selectPicture);
        btn_selectPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PhotoPicker.builder()
                        .setPhotoCount(9)
                        .setShowCamera(true)
                        .setShowGif(true)
                        .setPreviewEnabled(true)
                        .start(SelectPictureActivity.this, PhotoPicker.REQUEST_CODE);
            }
        });
        imageView = (ImageView) findViewById(R.id.imageView);
        listView = (ListView) findViewById(R.id.listView);
        adapterListView = new AdapterListView();
        listView.setAdapter(adapterListView);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
         if (resultCode == RESULT_OK && requestCode == PhotoPicker.REQUEST_CODE) {
            if (data != null) {
                ArrayList<String> photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                Log.e("图片地址", photos.get(0));
                try {
                    Uri url = Uri.parse(photos.get(0));
                    imageView.setImageURI(url);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                listImageUrl.clear();
                listImageUrl.addAll(photos);
                adapterListView.notifyDataSetChanged();
            }
        }
    }


    private class AdapterListView extends BaseAdapter{

        @Override
        public int getCount() {
            return listImageUrl.size();
        }

        @Override
        public Object getItem(int position) {
            return listImageUrl.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(SelectPictureActivity.this);
            Uri url = Uri.parse(listImageUrl.get(position));
            imageView.setImageURI(url);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            return imageView;
        }
    }

}
