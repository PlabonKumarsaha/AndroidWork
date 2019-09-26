<style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar"> this line's NoActionbar makes this layout full screen!this line will be
found in drawable/styles file.
we implemented progressbar here..the progess of the bar was kept seperately with a thread so despite the activity which is ran by mainthread 
and the progess is notified in the newly created thread!
  
  To make only a specific activity full screen write
  getSupportActionBar().hide();
