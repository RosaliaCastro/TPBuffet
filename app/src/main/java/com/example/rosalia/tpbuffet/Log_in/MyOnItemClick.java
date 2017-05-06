package com.example.rosalia.tpbuffet.Log_in;

import android.view.MenuItem;

/**
 * Created by Jona on 03/05/2017.
 */
public interface MyOnItemClick {
    boolean onCreateOptionMenu(android.view.Menu menu_layout);

    boolean onOptionItemSelected(MenuItem item);

    void onItemClick(int position);
}
