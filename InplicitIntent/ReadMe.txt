There are two kind of intent in android One is Explicit(One activity to another within the app) and 
one is implicit Intent(which means from one activity to another app's activity).
So in order to get to the destination of implicit intent we have to make the destination activity visible
for all other app..So in the destination app's Manifest file we find the activity which we want to make visible

then we must add this in <activity-android: name  = ".app">

   android:parentActivityName=".MainActivity"
            >
            <intent-filter>
                <action android:name="com.example.countryprofile.ProfileActivity" />

                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>


here in the  ' <action android:name="com.example.countryprofile.ProfileActivity" />' the name is the package name of the application!
and set the actegory.DEFAULT ..
