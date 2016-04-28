# storiez
Tutorial that explores the new android design support library by building two simple layouts.

## Overview
#### What you'll learn
  - Adding support libraries to your app
  - Working with material design colors
  - Using co-ordinator layout
  - Implementing collapsing Toolbar
  - Working with Tabs

#### what you'll need
  - Android Studio installed preferrably v1.5 and later
  - SDK Tools for API 21 and above
  - An emulator or android device running android 5.0(Lollipop) and above
  - Active internet connection

## Sample Code
You can get the sample code from github: https://github.com/cngondo/ for further
reference.

## Create an android application and add resources
  1. Create a new android app using android studio.
      - Launch android studio and select the ``start an new project``. If you were working on a previous project,
      go to ``File`` -> ``New`` -> ``New Project``
      - On the dialog that pops out, give your project a name and click next
      - Check the option on ``phone and tablet`` and ensure that the minumum SDK is ``API 21``
      - Select the option of ``basic activity`` and click next.
      - Give your parent activity a name and click ``finish``. Note that this is the initial activity that will be launched once the application starts running.

  2. Once you have your app ready, it's now time to add some resources that we shall use for the project.
      - Head over to your ``build.gradle`` file and check whether you have added the design support dependency.
      if not add the following and build your project
          ````
            compile 'com.android.support:design:23.1.1'

          ````
      
