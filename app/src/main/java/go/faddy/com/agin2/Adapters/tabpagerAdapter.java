package go.faddy.com.agin2.Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import go.faddy.com.agin2.Fragments.CalenderFrag;
import go.faddy.com.agin2.Fragments.NoticeFrag;
import go.faddy.com.agin2.Fragments.RoutineFrag;

public class tabpagerAdapter extends FragmentStatePagerAdapter {
    String[] tabarray = new String[]{"Routine", "Notice", "Calendar"};

    public tabpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabarray[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new RoutineFrag();
            case 1:
                return new NoticeFrag();
            case 2:
                return new CalenderFrag();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
