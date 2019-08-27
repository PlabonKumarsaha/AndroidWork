In the app you will find some country name with their image on left side.by cliking image you will find details of that country.
/In this simple app manny basic topics of andoid was coverd.
Here we tried textview,imageview,buttons,how to implement view.onclicklistener.
Use of scroll view(noted : scrol view can take only one widget insite itself).Intent was used to pass data from one activity to another.
Here onbackPassed method was also overriddent(This app asks permition from the user if he wasnts to press back button from the app).Unfortunately
the backpass is not working..


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AlertDialog.Builder alertbuilder = new AlertDialog.Builder(MainActivity.this);
        //alertbuilder.setIcon(R.drawable.question);
        alertbuilder.setTitle("This is a title");
        alertbuilder.setMessage("Do you want to close?");
        alertbuilder.setCancelable(false);
        alertbuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertbuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
             dialog.cancel();
            }
        });

        AlertDialog alertDialog = alertbuilder.create();
        alertDialog.show();
        alertbuilder.show();


    }
