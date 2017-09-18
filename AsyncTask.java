package fi.jamk.kuvaharjoitus;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by K1755 on 9/18/2017.
 */

public class AsyncTask {

    //this is done in UI thread, nothing this time
    @Override
    protecetd void onPreExecute(){
        // show loading progress bar
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected Bitmap doInBackground(String...urls){
        URL imageUrl;
        Bitmap bitmap = null;
        try{
            imageUrl = new URL(urls[0]);
            InputStream in = imageUrl.openStream();
            bitmap = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("<<LOADIMAGE>>", e.getMessage());
        }
        return bitmap;
    }

    // this is done in UI thread
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        iamgeView.setImageBitmap(bitmap);
        textView.setText("Image " + (imageIndex + 1) + "/" + images.length);
        // hide loading progress bar
        progressBar.setVisibility(View.INVISIBLE);
    }
}
