# ChatMeUp
## Introduction
This is a application based on the MVVM architectural pattern.

See below for more information.

## Technologies & Architecture 

#### Technologies
Android, Kotlin

#### Architecture
Model-View-ViewModel (MVVM)

#### Firebase
* Authentication
* Realtime Database
* Storage

#### Architecture Components
[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel), [LiveData](https://developer.android.com/topic/libraries/architecture/livedata), [Jetpack Compose](https://developer.android.com/jetpack/compose?gclid=Cj0KCQjwwISlBhD6ARIsAESAmp5eTKsRAVvdgIBFEu7ACiZM2ll6nRF8xwqCxuIIF55zxosP71k_T1QaAj21EALw_wcB&gclsrc=aw.ds) , 
[Navigation](https://developer.android.com/guide/navigation/)

## Features

**Start:** Login/create account

**Chats:** List of chats, online status, update on change

**Notifications:** Accept/decline friend requests, notifications symbol

**Edit Profile:** Change image, change status, Change name

**Chat:** Send and show messages sorted by timestamp, online status, update on change

## Screenshots

### Splash Screen | Login | Create Account

<p align = "left" >
  <img width="421" alt="Screenshot 2023-07-02 at 18 28 27" src="https://github.com/VIPlearner/ChatMeUp/assets/63104739/6ae5a850-20d5-4459-be07-26ac32d0fadf">
  <img width="407" alt="Screenshot 2023-07-02 at 19 01 36" src="https://github.com/VIPlearner/ChatMeUp/assets/63104739/132a78d7-a144-4913-a26e-46ff7abd6fab">
  <img width="406" alt="Screenshot 2023-07-02 at 19 01 49" src="https://github.com/VIPlearner/ChatMeUp/assets/63104739/302610ff-d3df-4508-9c6e-30ec3f01bf86">
</p>

### Chats | Notifications | Users

<p align = "left" >
  <img width="410" alt="Screenshot 2023-07-02 at 18 36 55" sr<img width="406" alt="Screenshot 2023-07-02 at 19 20 42"       
   src="https://github.com/VIPlearner/ChatMeUp/assets/63104739/7543e458-d751-4ada-bbff-cce76c3b2ca7">
</p>


### Firebase
<p align = "left" >
  <img width="613" alt="Screenshot 2023-07-02 at 19 24 20" src="https://github.com/VIPlearner/ChatMeUp/assets/63104739/2302609e-80e9-4b1f-ac01-f5c438dba588">
</p>

## Setup
#### Requirements
* Basic knowledge about Android Studio
* Basic knowledge about Firebase

#### Firebase
 * Setup Authentication and use the Sign-in method 'Email/Password'
 * Setup Realtime Database
 * Setup Storage
 * Replace the file [google-services.json](app/google-services.json)
 * <b>Note:</b> Download the google-services.json file after the Firebase services are set up to automatically include the services in the json file.
 * <b>Note:</b> When updating the google-services.json file then make sure to invalidate the caches as well as doing a clean + rebuild.

#### Project
1. Download and open the project in Android Studio
2. Connect your Android phone or use the emulator to start the application

