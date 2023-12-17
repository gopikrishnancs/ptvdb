
The android project is developed in the motivation of creating an android application to show the popular television series database with multi module using jetpack compose, Material3 design and retrofit with paging 

-initial commit provided with scratch in main and master branch

-base commit for UI and basic screen with authentication network calls added in ptvdb_base branch 

made 2 architecture one with compose only without additional support which is migrated to jetpack compose + hilt + also migrated from retrofit to httpClient url client due to time limitations for delivery

 -Created branch mentioned as db_prototype which is migrated to new architecture to use view-model and hitl efficiently  

Screen List 
1) Tv Show screen (To show list of Popular Tv Shows) 
2) Tv Show detail screen (To show Details of Popular Tv Show)

App Flow 

ForegroundFlow HomeScreen
MainViewModel -> Authentication -> MainScreen -> NavigationComponent -> HomeScreen

ForegroundFlow DetailScreen
HomeScreenUI -> DetailScreen -> DetailScreenUI
     \ /                             \ /
      |>-----------------------------<|
       
BackgroundFlow HomeScreen
HomeScreen <-> HomeScreenViewModel <-> Repository <-> FetchData

BackgroundFlow DetailScreen
HomeScreen <-> DetailScreen <-> DetailScreenViewModel <-> Repository <-> FetchData




(Life of application)
Legacy Library Used
- androidx.core:core-ktx:1.12.0
- androidx.lifecycle:lifecycle-runtime-ktx:2.6.2
- androidx.activity:activity-compose:1.8.2
- androidx.compose:compose-bom:2023.08.00
- androidx.compose.ui:ui
- androidx.compose.ui:ui-graphics
- androidx.compose.ui:ui-tooling-preview
- androidx.compose.material3:material3
- androidx.paging:paging-compose:3.3.0-alpha02
- androidx.paging:paging-runtime-ktx:3.2.1
- androidx.paging:paging-compose:3.2.1
- androidx.appcompat:appcompat:1.6.1
- androidx.constraintlayout:constraintlayout:2.1.4
- androidx.navigation:navigation-fragment-ktx:2.7.6
- androidx.navigation:navigation-ui-ktx:2.7.6
- androidx.lifecycle:lifecycle-livedata-ktx:2.6.2
- androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2
- androidx.hilt:hilt-navigation-compose:1.1.0
- androidx.palette:palette-ktx:1.0.0
- androidx.room:room-runtime:2.6.1
- androidx.room:room-ktx:2.6.1
- androidx.room:room-compiler:2.6.1
- androidx.datastore:datastore-preferences:1.0.0


Google Support Library Used
- com.google.dagger:hilt-android:2.48
- com.google.android.material:material:1.11.0
- com.google.accompanist:accompanist-pager:0.18.0


Third Party Libraries used
- io.coil-kt:coil-compose:2.5.0
- com.squareup.retrofit2:retrofit:2.9.0
- com.squareup.retrofit2:converter-gson:2.9.0
- com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2






















































Licensed only for personal use