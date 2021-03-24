package com.example.mywhatsaap.Addapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.mywhatsaap.Fragment.BlankFragmentCallFragment;
import com.example.mywhatsaap.Fragment.BlankFragmentChatsFragment;
import com.example.mywhatsaap.Fragment.BlankFragmentStatusFragment;

public class FragmentAdapter extends FragmentStatePagerAdapter {
    private int TabCount;
    public FragmentAdapter(@NonNull FragmentManager fm, int CountTab) {
        super(fm);
        this.TabCount=CountTab;
     }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new BlankFragmentChatsFragment();
            case 1:
                return new BlankFragmentStatusFragment();
            case 2:
                return new BlankFragmentCallFragment();
            default:
                return new BlankFragmentChatsFragment();
        }
    }

    @Override
    public int getCount() {
        return TabCount;
    }




}
