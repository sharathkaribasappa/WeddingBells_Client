
package com.weddingbells_androidclient.notUsed;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.weddingbells_androidclient.R;
import com.weddingbells_androidclient.R.id;
import com.weddingbells_androidclient.R.layout;

public class SelectedUpdatedItemFragment extends Fragment {

    private ImageView mImageView;
    private TextView mDescriptionTextView;
    private ListView mListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.selected_updated_item_fragment, container, false);
        mImageView = (ImageView) rootView.findViewById(R.id.selected_Update_Item_Imageview);
        mDescriptionTextView = (TextView) rootView
                .findViewById(R.id.selected_Update_Item_description);
        mListView = (ListView) rootView.findViewById(R.id.selected_Update_Item_Comments_List);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        
    }

}
