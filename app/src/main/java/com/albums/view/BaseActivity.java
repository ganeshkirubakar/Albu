package com.albums.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupMenu;

import com.albums.R;
import com.albums.appInterface.ActivityInterface;
import com.albums.appInterface.FragmentInterface;
import com.albums.view.frament.AlbumListFragment;
import com.albums.view.frament.UserFragment;

public class BaseActivity extends AppCompatActivity implements FragmentInterface {

    private final String TAG = BaseActivity.class.getName();
    private ActivityInterface activityInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                .getColor(R.color.golden)));
        setInitialFragment();
    }

    /**
     * Add Initial Fragment to the container
     */
    private void setInitialFragment(){
        addFragment(AlbumListFragment.newInstance());
    }

    /**
     * Add Fragment to container
     * @param fragment fragment to be added in container
     */
    @Override
    public void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        int count  = getSupportFragmentManager().getBackStackEntryCount();
        getSupportFragmentManager().popBackStack();
        if(count <= 1){
            super.onBackPressed();
        }
    }

    /**
     * Check Network Availability
     * @return returns to availability of network to load data
     */
    @Override
    public boolean checkNetworkConnection(){
        boolean isNetworkAvailable;
        ConnectivityManager ConnectionManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
        isNetworkAvailable = networkInfo != null && networkInfo.isConnected();
        return isNetworkAvailable;
    }

    @Override
    public void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        View focusedView = getCurrentFocus();
        if (focusedView != null) {
            inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    @Override
    public void setActivityInterfaceFromFragment(ActivityInterface activityInterface) {
        this.activityInterface = activityInterface;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.refresh:
                activityInterface.onRefresh();
                return(true);
            case R.id.more:
                View menuItemView = findViewById(R.id.more);
                PopupMenu popupMenu = new PopupMenu(this, menuItemView);
                popupMenu.inflate(R.menu.menu_overflow);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        addFragment(UserFragment.newInstance());
                        return false;
                    }
                });
                popupMenu.show();
                return(true);
        }
        return(super.onOptionsItemSelected(item));
    }
}
