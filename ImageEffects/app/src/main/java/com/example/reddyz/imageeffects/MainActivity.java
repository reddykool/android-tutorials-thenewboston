package com.example.reddyz.imageeffects;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView myImgView ;
    Drawable myPic;
    Bitmap newBitmapImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myImgView = (ImageView) findViewById(R.id.myImageView);
        myPic = getResources().getDrawable(R.drawable.puru);
        myImgView.setImageDrawable(myPic);
    }

    public void applyInvertEffects(View view) {
        Bitmap bitmapImage = ((BitmapDrawable)myPic).getBitmap();
        newBitmapImage = invertImage(bitmapImage);
        myImgView.setImageBitmap(newBitmapImage);
    }

    public void applyFrameEffects(View view) {
        Drawable[] layers = new Drawable[2];
        layers[0] = myPic;
        layers[1] = getResources().getDrawable(R.drawable.effect1);

        LayerDrawable layerDraw = new LayerDrawable(layers);
        myImgView.setImageDrawable(layerDraw);
    }

    public void saveImage(View view) {
        //Save image
        MediaStore.Images.Media.insertImage(getContentResolver(), newBitmapImage, "saveImgTitle", "Millionaire");
    }

    //Invert bitmap image
    private static Bitmap invertImage(Bitmap inputImg) {
        int A,R,G,B;
        int pixelColor;
        int height = inputImg.getHeight();
        int width = inputImg.getWidth();

        Bitmap outputImg = Bitmap.createBitmap(width, height, inputImg.getConfig());

        for(int y=0; y<height; y++){
            for(int x=0; x<width; x++){
                pixelColor = inputImg.getPixel(x,y);
                A = Color.alpha(pixelColor);
                R = 255 - Color.red(pixelColor);
                G = 255 - Color.green(pixelColor);
                B = 255 - Color.blue(pixelColor);
                outputImg.setPixel(x,y, Color.argb(A,R,G,B));
            }
        }
        return outputImg;
    }
}
