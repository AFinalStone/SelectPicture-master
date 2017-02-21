package com.shi.androidstudio.selectpicture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private ImageView imageView02;
    private ImageView imageView03;
    private ImageView imageView04;

    private String url01 = "http://www.dainif.com/app/GIF.gif";
    private String url02 = "http://img.blog.csdn.net/20150507153918629?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvemhhbmdwaGls/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center";
    private String url03 = "http://www.myexception.cn/img/2015/03/29/165158272.gif";
    private String url04 = "http://img2.imgtn.bdimg.com/it/u=2352920470,672319252&fm=21&gp=0.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView02 = (ImageView) findViewById(R.id.imageView02);
        imageView03 = (ImageView) findViewById(R.id.imageView03);
        imageView04 = (ImageView) findViewById(R.id.imageView04);
//        Glide.with(this).load(url01).into(imageView);
        Glide.with(MainActivity.this).load(url01).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(new GlideDrawableImageViewTarget(imageView, 2));
        Glide.with(MainActivity.this).load(url02).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(new GlideDrawableImageViewTarget(imageView02, 2));
        Glide.with(MainActivity.this).load(url03).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imageView03);
        Glide.with(MainActivity.this).load(url04).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imageView04);

    }
}
