package com.example.officecrimes;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

public class PictureUtils {

    //A method to manually scale the bitmap image to better size
    public static Bitmap getScaledBitmap(String path, int destWidth, int destHeight){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        float srcWidth = options.outWidth;
        float srcHeight = options.outHeight;

        //How much to scale down
        int inSampleSize = 1;
        if(srcHeight > destHeight || srcWidth > destWidth){
            float heightScale = srcHeight/destHeight;
            float widthScale = srcWidth/destWidth;

            inSampleSize = Math.round(heightScale > widthScale ? heightScale:widthScale);
        }

        options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;

        //Read in and create final bitmap with desired scaling
        return BitmapFactory.decodeFile(path, options);
    }

    //This method will check how big the screen is and then scale the image down.
    public static Bitmap getScaledBitmap(String path, Activity activity){
        Point size = new Point();
        //From the activity get the size of the display
        activity.getWindowManager().getDefaultDisplay().getSize(size);

        return getScaledBitmap(path, size.x, size.y);
    }
}
