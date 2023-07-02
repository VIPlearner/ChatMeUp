# ChatMeUp
## Introduction
This is a demo application built with the goal to create a fun and challenging application based on the MVVM architectural pattern.

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

**Users:** List of users

**Edit Profile:** Change image, change status, Change name

**Chat:** Send and show messages sorted by timestamp, online status, custom toolbar, update on change

**General:** Auto login, bottom navigation, error messages with snackbar, progress bar

## Screenshots

### Start | Login | Create Account

<p align = "left" >
  <img width="250" height="500" src="github_images/start.png">
  <img width="250" height="500"  src="github_images/login.png"> 
  <img width="250" height="500" src="github_images/create.png"> 
</p>

### Chats | Notifications | Users

<p align = "left" >
  <img width="250" height="500" src="github_images/chats.png">
  <img width="250" height="500"  src="github_images/notifications.png"> 
  <img width="250" height="500" src="github_images/users.png"> 
</p>

### Settings | Chat | Profile

<p align = "left" >
  <img width="250" height="500" src="github_images/settings.png">
  <img width="250" height="500"  src="github_images/chat.png"> 
  <img width="250" height="500" src="github_images/profile.png"> 
</p>

### Firebase
<p align = "left" >
  <img  width="378" height="332" src="github_images/db.png"> 
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

