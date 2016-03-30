package com.weddingbells_androidclient.Adapters;


import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper;

public class AdapterSwipeDragHelper extends ItemTouchHelper.SimpleCallback {
    private RecyclerViewAdapter_EventsList mAdapter;

    public AdapterSwipeDragHelper(int arg0, int arg1) {
        super(arg0, arg1);
    }

    public AdapterSwipeDragHelper(RecyclerViewAdapter_EventsList adapter) {
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT
                | ItemTouchHelper.RIGHT);
        this.mAdapter = adapter;
    }

    @Override
    public boolean onMove(RecyclerView arg0, ViewHolder arg1, ViewHolder arg2) {
        return false;
    }

    @Override
    public int getDragDirs(RecyclerView recyclerView, ViewHolder viewHolder) {

        if (viewHolder instanceof RecyclerViewAdapter_EventsList.DataObjectHolder) {
            int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
            return makeMovementFlags(0, swipeFlags);
        } else if (viewHolder instanceof RecyclerViewAdapter_EventsList.TitleObjectHolder){
            return 0;
        }
        return 0;

    }
    
    @Override
    public int getSwipeDirs(RecyclerView recyclerView, ViewHolder viewHolder) {
        if (viewHolder instanceof RecyclerViewAdapter_EventsList.DataObjectHolder) {
            int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
            return makeMovementFlags(0, swipeFlags);
        } else if (viewHolder instanceof RecyclerViewAdapter_EventsList.TitleObjectHolder){
            return 0;
        }
        return 0;
    }

    @Override
    public void onSwiped(ViewHolder viewHolder, int direction) {
        mAdapter.deleteItem(viewHolder.getAdapterPosition());
    }
}
