package com.weddingbells_androidclient.cardlayoutfunctionality;

import java.io.File;
import java.util.ArrayList;

import com.weddingbells_androidclient.Adapters.RecyclerViewAdapter_EventsList;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.weddingbells_androidclient.R;

public class EventListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter_EventsList mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "CardViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayout.VERTICAL, false);//true for reverse layout
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerViewAdapter_EventsList(getDataSet());
        mRecyclerView.setAdapter(mAdapter);

        createFolder();
        
        /*
         * //For swipe functionality //ItemTouchHelper.Callback callback = new
         * AdapterSwipeDragHelper(mAdapter); //ItemTouchHelper helper = new
         * ItemTouchHelper(callback); //helper.attachToRecyclerView(mRecyclerView); // FastScroller
         * fastScroller = (FastScroller) findViewById(R.id.fast_scroller); //
         * fastScroller.setRecyclerView(mRecyclerView); // Code to Add an item with default
         * animation // ((MyRecyclerViewAdapter) mAdapter).addItem(obj, index);
         */
    }

    private String getDirectory() {
        String mImagesFolder = null;
        if (Environment.getExternalStorageState() == null) {
            mImagesFolder = Environment.getDataDirectory().getAbsolutePath()
                    + "/MyAppImagesFolder/";
        } else if (Environment.getExternalStorageState() != null) {
            mImagesFolder = Environment.getExternalStorageDirectory().getAbsolutePath()
                    + "/MyAppImagesFolder/";
        }

        return mImagesFolder;
    }

    private void createFolder() {
        File photoDirectory;
        // if (Environment.getExternalStorageState() == null) {
        // create new file directory object

        photoDirectory = new File(getDirectory());
        /*
         * this checks to see if there are any previous test photo files if there are any photos,
         * they are deleted for the sake of memory
         */
//        if (photoDirectory.exists()) {
//            File[] dirFiles = photoDirectory.listFiles();
//            if (dirFiles.length != 0) {
//                for (int ii = 0; ii <= dirFiles.length; ii++) {
//                    dirFiles[ii].delete();
//                }
//            }
//        }
        // if no directory exists, create new directory
        if (!photoDirectory.exists()) {
            Log.d(LOG_TAG, "Making File in SDCard");
            photoDirectory.mkdir();
        }

        // if phone DOES have sd card
        // } else if (Environment.getExternalStorageState() != null) {
        // // search for directory on SD card
        // photoDirectory = new File(Environment.getExternalStorageDirectory()
        // + "/MyAppImagesFolder/");
        //
        // if (photoDirectory.exists()) {
        // File[] dirFiles = photoDirectory.listFiles();
        // if (dirFiles.length > 0) {
        // for (int ii = 0; ii < dirFiles.length; ii++) {
        // dirFiles[ii].delete();
        // }
        // dirFiles = null;
        // }
        // }
        // // if no directory exists, create new directory to store test
        // // results
        // if (!photoDirectory.exists()) {
        // Log.d(LOG_TAG, "Making File in Storage");
        // System.out.println(""+photoDirectory.mkdir());
        // }
        // }// end of SD card checking
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((RecyclerViewAdapter_EventsList) mAdapter).setOnItemClickListener(new RecyclerViewAdapter_EventsList
                .MyClickListener() {
                    @Override
                    public void onItemClick(int position, View v) {
                        Log.i(LOG_TAG, " Clicked on Item " + position);
                        Intent i = new Intent(getApplicationContext(), EventDetailsActivity.class);
                        startActivity(i);
                    }

                });

    }

    private File getImage() {
        File filePath = new File(getDirectory()+"images.png");
        return filePath;
    }

    private ArrayList<EventListDataObject> getDataSet() {
        ArrayList<EventListDataObject> results = new ArrayList<EventListDataObject>();
        for (int index = 0; index < 20; index++) {
            EventListDataObject obj = new EventListDataObject(getImage(),"Title" + index, "Some Primary Text " + index,
                    "Secondary " + index);
            results.add(index, obj);
        }
        return results;
    }
}
