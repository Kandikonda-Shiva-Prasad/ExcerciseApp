package uk.ac.tees.aad.w9527290.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import uk.ac.tees.aad.w9527290.Framents.FifteendayFragment;
import uk.ac.tees.aad.w9527290.Framents.FivedayFragment;
import uk.ac.tees.aad.w9527290.Framents.TenDayFragment;

public class PageAdapter extends FragmentPagerAdapter {

    int NumberofFragments;
    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        NumberofFragments = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return new FivedayFragment();
            case 1: return new TenDayFragment();
            default:return null;

        }
    }

    @Override
    public int getCount() {
        return this.NumberofFragments;
    }
}
