# storiez
Tutorial that explores the new android design support library by building two simple layouts.

## Overview
#### What you'll learn
  - Adding support libraries to your app
  - Working with material design colors
  - Using co-ordinator layout
  - Implementing collapsing Toolbar
  - Working with Tabs, viewpager and respective adapters

#### what you'll need
  - Android Studio installed preferrably v1.5 and later
  - SDK Tools for API 21 and above
  - An emulator or android device running android 5.0(Lollipop) and above
  - Active internet connection
  - git installed to your local machine
  - a valid github account

## Sample Code
You can get the sample code from github: https://github.com/cngondo/storiez for further
reference.

## Getting started
  1. Fork the repo from https://github.com/cngondo/storiez to your account and clone it to your local machine.
      - Launch android studio and import the project to your workspace.
      - Switch to the develop branch using the command in the terminal in your project root directory
          `` git checkout develop ``

  2. Once you have your app is ready, it's now time to add some resources that we shall use for the project.
      - Head over to your ``build.gradle`` file and check whether you have added the design support dependency.
      if not add the following and build your project

          ``
            compile 'com.android.support:design:23.1.1'

          ``
      - As for the images, check them out in the application's res folder on the ``master branch `` which has the complete project.

## Adding custom toolbars
We shall be dealing mostly with the layout part of the app by adding a collapsing toolbar.

  1. Go to your ``activity.xml`` file and ensure that you have `` co-ordinator Layout`` as you root layout.

  2. Add the `` AppBarLayout `` that will comprise of the image and the toolbar.

  3. Add `` CollapsingToolBarLayout`` and ensure that they have the ``scrollFlags``
      ````xml
      <android.support.design.widget.CollapsingToolbarLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_scrollFlags="scroll|exitUntilCollapsed"
        app:contentScrim="?attr/colorPrimary"
        app:expandedTitleMarginStart="48dp"
        app:expandedTitleMarginEnd="64dp"
        android:fitsSystemWindows="true">
        .
        .
        .
        .
      </android.support.design.widget.CollapsingToolbarLayout>
      ````
  4. Add an `` ImageView`` which also must have the `` app:layout_collapseMode="parallax" ``. As for our case we'll use parallax.
      ```xml      
          <ImageView
              android:src="@drawable/bg_nai"
              android:layout_width="match_parent"
              android:layout_height="wrap_content"
              android:scaleType="centerCrop"
              app:layout_collapseMode="parallax"
              app:layout_collapseParallaxMultiplier="0.7" />
      ```
      This is the image that will be displayed on the appbar and fades out with a parallax effect when user scrolls up for more content.

  5. Finally as for the `` AppBarLayout ``, modify the toolbar to look like this:

      ```xml

          <android.support.v7.widget.Toolbar
                android:id="@+id/toolbar"
                android:layout_width="match_parent"
                android:layout_height="?attr/actionBarSize"
                app:popupTheme="@style/AppTheme.PopupOverlay"
                app:layout_collapseMode="parallax"
                app:layout_scrollFlags="scroll|exitUntilCollapsed" />
      ```
      The toolbar must also have the collapse mode and the scroll flags in order to specify how the app bar should behave on
      scrolling.

  6. After that, we need to add a nested scrollview and wrap our content around it. This enables the co-ordinator layout
  to understand what needs to be done on scroll.

      ```xml

          <android.support.v4.widget.NestedScrollView
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              app:layout_behavior="@string/appbar_scrolling_view_behavior">

              <include layout="@layout/content_home" />

          </android.support.v4.widget.NestedScrollView>

      ```
  7. Now head over to ``content_home.xml`` in the res folder and add a long string to the TextView. You can do that by heading over to
  ``strings.xml`` under the values folder and add a long string resource from lipsum.com.

  8. Run your app and you should be able to see the collapsing toolbar effect.

  9. One last thing: you can anchor the FloatingActionButton to the AppBar by using the ``app:layout_anchorGravity`` property and
  pointing the ``app:layout_anchor`` to the appbar as shown:

    ```xml

        <android.support.design.widget.FloatingActionButton
         android:id="@+id/fab"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:layout_margin="@dimen/fab_margin"
         android:src="@drawable/ic_arrow_forward_white_24dp"
         app:layout_anchorGravity="bottom|right|end"
         app:layout_anchor="@id/appBar" />

    ```
    Also, create an Intent that'll fire the next activity containing the tabbed layout.

    ```java

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Start the tabbed activity
                Intent i = new Intent(Home.this, Categories.class);
                startActivity(i);
            }
        });

    ```

## Creating Tab layouts
For one to achieve working with tabs, you have to include 3 things i.e `` TabLayout ``, `` ViewPager `` and a `` FragmentPagerAdapter ``.
The TabLayout and the ViewPager are included in the xml of the parent activity while the FragmentPagerAdapter is responsible for
passing the relevant information to the specific fragment when selected.
Let's see how we can achieve this:

  1. Create a new basic activity that'll hold our tabs.

  2. On the activity.xml add now the TabLayout and the ViewPager. Add the ``TabLayout`` inside ``the AppBarLayout`` and the
  `` ViewPager`` in the CoordinatorLayout before the include for the content.

      ```xml

            <?xml version="1.0" encoding="utf-8"?>
            <android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
            xmlns:app="http://schemas.android.com/apk/res-auto"
            xmlns:tools="http://schemas.android.com/tools"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:fitsSystemWindows="true"
            tools:context="design.example.ngondo.storiez.Categories">

            <android.support.design.widget.AppBarLayout
              android:layout_width="match_parent"
              android:layout_height="wrap_content"
              android:theme="@style/AppTheme.AppBarOverlay">

              <android.support.v7.widget.Toolbar
                  android:id="@+id/toolbar"
                  android:layout_width="match_parent"
                  android:layout_height="?attr/actionBarSize"
                  android:background="?attr/colorPrimary"
                  app:popupTheme="@style/AppTheme.PopupOverlay" />

              <android.support.design.widget.TabLayout
                  android:id="@+id/categories"
                  android:layout_width="match_parent"
                  android:layout_height="match_parent" />

            </android.support.design.widget.AppBarLayout>

            <android.support.v4.view.ViewPager
              android:id="@+id/vPager"
              android:layout_height="match_parent"
              android:layout_width="match_parent"/>

            <include layout="@layout/content_categories" />

            <android.support.design.widget.FloatingActionButton
              android:id="@+id/fab"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:layout_gravity="bottom|end"
              android:layout_margin="@dimen/fab_margin"
              android:src="@drawable/ic_add_white_24dp" />

            </android.support.design.widget.CoordinatorLayout>

      ```

  3. Create a`` FragmentPagerAdapter `` that'll populate the different Fragments with the content.
  You can simply copy the one I created from [here](https://github.com/cngondo/storiez/blob/master/app/src/main/java/design/example/ngondo/storiez/FragmentPageAdapter.java) and
  use it in your project. Remember that all adapters must override two methods `` getItem() `` and `` getCount()`` since they are passing to the
  views.

  4. After you've created your adapter, create three fragments with their specific layouts. These are the fragments that'll be loaded once
  the tabs are selected. You can add different information on the fragments layouts so that you get to see the difference.
  I just had a simple TextView :

    ```xml

        <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
          xmlns:tools="http://schemas.android.com/tools"
          android:layout_width="match_parent"
          android:layout_height="match_parent"
          tools:context="design.example.ngondo.storiez.Fables">

          <TextView
              android:id="@+id/fables"
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              android:text="@string/fables"
              android:textSize="30dp"
              android:gravity="center" />

          </RelativeLayout>

    ```

  5. Initialize the TabLayout and the ViewPager in your activity's java class.

      ```java

        TabLayout mTablayout;
        ViewPager mViewPager;

      ```
      Once initialized, we need to point the viewPager to the FragmentPagerAdapter and we can do that by using a `` setter`` for the ``mViewPager``
      that looks like this:

      ```java

            public void setmViewPager(ViewPager mViewPager) {
                FragmentPageAdapter adapter = new FragmentPageAdapter(getSupportFragmentManager());
                adapter.addFragment(new Fables(), "FABLES");
                adapter.addFragment(new Epics(), "EPICS");
                adapter.addFragment(new Legends(), "LEGENDS");
                //point viewpager to the adapter
                mViewPager.setAdapter(adapter);
            }  

      ```

      Finally, we set up the `` mViewPager `` with the `` mTabLayout ``  by passing the `` mViewPager `` to a method `` setUpWithViewPager `` as shown:

      ```java

          //setting up viewpager from the setter
           mViewPager = (ViewPager) findViewById(R.id.vPager);
           setmViewPager(mViewPager);
           //using the viewpager in the tabs
           mTablayout = (TabLayout) findViewById(R.id.categories);
           mTablayout.setupWithViewPager(mViewPager);

      ```

      So in the end our activity should look something like this:

      ``` java

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
            // setter that points to the FragmentPagerAdapter
              public void setmViewPager(ViewPager mViewPager) {
                  FragmentPageAdapter adapter = new FragmentPageAdapter(getSupportFragmentManager());
                  adapter.addFragment(new Fables(), "FABLES");
                  adapter.addFragment(new Epics(), "EPICS");
                  adapter.addFragment(new Legends(), "LEGENDS");
                  //point viewpager to the adapter
                  mViewPager.setAdapter(adapter);
              }
          }

      ```

      And there you have it!! Run your app and you should see the tabbed activity.
