<style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar"> this line's NoActionbar makes this layout full screen!this line will be
found in drawable/styles file.
we implemented progressbar here..the progess of the bar was kept seperately with a thread so despite the activity which is ran by mainthread 
and the progess is notified in the newly created thread!
  
  
  #Make full Screen
  To make only a specific activity full screen write
  getSupportActionBar().hide();
 
 #Hide Action Bar
 
  if (Build.VERSION.SDK_INT < 16) {
        // Hide the Action Bar on Android 4.0 and Lower
         getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
     }else {
        // Hide the Action Bar on Android 4.1 and Higher
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        android.app.ActionBar actionBar = getActionBar();
        actionBar.hide();
     }
