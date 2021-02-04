# CameraX
<img src="Covid-19Images/covid-19.png" width="250" height="250">

CameraX  is an Android App through which the user can able to capture the image .Overhere I have used CameraX Library to Capture the Image .Firstly in this App I am Creating the 
Album_name and then I am storing the album_name into the database using room database and then with the help of album_name I am displaying the image by decoding the file  into the bitmap



# Screenshots

<img src="Covid-19Images/full.png" width="200" height="250"><img src="Covid-19Images/recycler.png" width="200" height="250">

<img src="Covid-19Images/stats.png" width="200" height="250"><img src="Covid-19Images/save.png" width="200" height="250">
<img src="Covid-19Images/graphic.png" width="200" height="200">

# Libraries this app uses
###### CameraX Libraries - 
                         
    
                           implementation "androidx.camera:camera-camera2:$camerax_version"
                           implementation "androidx.camera:camera-lifecycle:$camerax_version"
                           implementation "androidx.camera:camera-view:1.0.0-alpha10"


 
  ###### ViewModel - 
                         implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0'
   
  
         
         
   ###### Room Database   - 
                           implementation 'androidx.room:room-runtime:2.2.5'
                           annotationProcessor 'androidx.room:room-compiler:2.2.5'


# Permissions
###### Camera
###### WRITE AND READ EXTERNAL STORAGE
