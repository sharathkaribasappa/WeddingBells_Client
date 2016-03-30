package com.weddingbells_androidclient.cardlayoutfunctionality;

import android.content.Context;
import android.view.View;
import android.widget.TabHost.TabContentFactory;

public class TabFactory implements TabContentFactory {

    private final Context mContext;
    
    /**
     * @param context
     */
    public TabFactory(Context context) {
        mContext = context;
    }

    /** (non-Javadoc)
     * @see TabContentFactory#createTabContent(String)
     */
    public View createTabContent(String tag) {
        View v = new View(mContext);
        v.setMinimumWidth(0);
        v.setMinimumHeight(0);
        return v;
    }

}
