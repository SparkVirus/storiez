package design.example.ngondo.storiez;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Categories extends AppCompatActivity {
    TabLayout mTablayout;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //setting up viewpager from the setter
        mViewPager = (ViewPager) findViewById(R.id.vPager);
        setmViewPager(mViewPager);
        //using the viewpager in the tabs
        mTablayout = (TabLayout) findViewById(R.id.categories);
        mTablayout.setupWithViewPager(mViewPager);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Add your own story", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void setmViewPager(ViewPager mViewPager) {
        FragmentPageAdapter adapter = new FragmentPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fables(), "FABLES");
        adapter.addFragment(new Epics(), "EPICS");
        adapter.addFragment(new Legends(), "LEGENDS");
        //point viewpager to the adapter
        mViewPager.setAdapter(adapter);
    }
}
