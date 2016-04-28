package design.example.ngondo.storiez;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ngondo on 4/28/16.
 */
public class FragmentPageAdapter extends FragmentPagerAdapter {
    /*
   * Since the adapter cannot return empty items to the view, we need to
   * return items in the getItem() and getCount() methods
   * */
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mTitle = new ArrayList<>();

    public FragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }

    //Method that will add fragments dynamically
    public void addFragment(Fragment fragment, String title){
        mFragmentList.add(fragment);
        mTitle.add(title);
    }
}
