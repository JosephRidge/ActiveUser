# ActiveUser ReadMe

Objective : Consume an online JSONAPI (".https://jsonplaceholder.typicode.com/" under the **users** resource

*Tools/ Dependencies :*
- Retrofit2
- gsonConverter
- SearchView 
- RecyclerView
- Pojo
- Google Maps

    *Navigation*
    def navigationVersion = '2.3.1'
    implementation 'com.google.android.material:material:1.2.1'
    implementation "androidx.navigation:navigation-fragment:$navigationVersion"
    implementation "androidx.navigation:navigation-ui:$navigationVersion"

    *Maps utils for clustering*
    implementation 'com.google.maps.android:android-maps-utils:2.0.3'

    *CardView*
    implementation "androidx.cardview:cardview:1.0.0"

    *Retrofit2 dependency*
    def Retrofit2Version ='2.9.0'
    implementation "com.squareup.retrofit2:retrofit:$Retrofit2Version"
    *Gson converter*
    implementation "com.squareup.retrofit2:converter-gson:$Retrofit2Version"

    *RecyclerView*
    implementation "androidx.recyclerview:recyclerview:1.1.0"
    *For control over item selection of both touch and mouse driven selection*
    implementation "androidx.recyclerview:recyclerview-selection:1.1.0-rc03"

     *MVVM dependencies*
    def version= '1.1.1'
    implementation "android.arch.lifecycle:extensions:$version"
    annotationProcessor "android.arch.lifecycle:compiler:$version"


*Recycler View :* 
To achieve this we need three parts: 
-  Adapter
- xml file holding the recyclerview widget
- xml file holding the data view or rather how your view would look to the user


*Design Pattern*
 Model View View Model
 - create modules withing your class dir
 - we will have three classes since we will also be querying nested object data : 
     - Users ( will carry user data )
     - Address ( will hold the User Address object )
     - Location ( will hold the User geolocation data object ) 
 - We will have a ViewHolder Module ( handling how data logic to UI )
 - Repository Module that will serve a purpose of having the API inteface 
 
 *User Interface*
 <img src=“https://github.com/JosephRidge/ActiveUser/app/src/main/res/readmeImages/splashscreen.png”>
  ![Design of SplashScreen ](https://github.com/JosephRidge/ActiveUser/app/src/main/res/readmeImages/splashscreen.png)
  ![Design of User Location Activity page ](https://github.com/JosephRidge/ActiveUser/app/src/main/res/readmeImages/userLoc.png)
  ![Design of Employees activity page](https://github.com/JosephRidge/ActiveUser/app/src/main/res/readmeImages/users.png)

  *NOTE:* 
   - Icons used are attained from various www.flaticon.com , and are attributed in the icon xml files

 
