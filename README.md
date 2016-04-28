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
          `` git checkout dev ``

  2. Once you have your app is ready, it's now time to add some resources that we shall use for the project.
      - Head over to your ``build.gradle`` file and check whether you have added the design support dependency.
      if not add the following and build your project
          ````
            compile 'com.android.support:design:23.1.1'

          ````
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

## Creating Tab layouts
