package fi.jamk.kuvaharjoitus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //image view object
    private ImageView imageView;
    // text view object
    private TextView textView;
    // progress bar object
    private ProgressBar progressBar;
    // example image's path (change to your own if needed...)
    private final String PATH = "";
    // private String[] images = {"",};
    // which image is now visible
    private int imageIndex;
    // async task to load a new image
    private DownloadImageTask task;
    // swipe down and up values
    private float x1,x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get views
        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        // start showing images
        imageIndex = 0;
        showImage();
    }

    public void showImage(){

        //create a new AsyncTask object
        task = new DownloadImageTask();
        //start asynctask
        task.execute(PATH + images[imageIndex]);
    }


}
