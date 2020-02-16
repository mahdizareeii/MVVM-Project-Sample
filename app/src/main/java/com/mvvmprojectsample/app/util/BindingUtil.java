package com.mvvmprojectsample.app.util;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

public class BindingUtil {

    @BindingAdapter({"loadImageUrl"})
    public static void loadImageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .transform(new CenterCrop(), new RoundedCorners(2000))
                .into(imageView);
    }

}
