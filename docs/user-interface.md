---
title: User Interface
description: "Entity-relationship diagram and DDL."
menu: UI
order: 10
wireframe:
  image: img/wireframe.svg
  pdf: pdf/wireframe.pdf
---

{% include ddc-abbreviations.md %}

## Navigation

As shows by the wireframe below, the finished app will be designed having multiple screens including:
* Zoom Attendance Tracker home screen
  * (1) button
    * Login
* Sign In screen 
  * (2) text input fields
    * Email Address
    * Password
  * (1) button
    * Sign In
* Welcome, User screen
  * (1) text input field
    * Zoom Meeting Id
  * (2) buttons
    * Submit
    * View Past Meetings
  * (1) menu bar button ...
    * Settings
    * Sign Out
* Attendance/Current screen
  * (2) options & selections
    * Log
    * Generate Report
  * (1) button
    * Generate
  * (4) bottom navigation tabs
    * Current
    * Past
    * Report
    * Settings sprocket
  * (1) menu bar button ...
    * Settings
    * Sign Out
* Reports/Past screen
  * (1) unordered list
    * list of generated meetings
  * (4) bottom navigation tabs
    * Current
    * Past
    * Report
    * Settings sprocket
  * (1) menu bar button ...
    * Settings
    * Sign Out
* Settings screen
  * (2) text input fields w/ corresponding buttons
    * Email
      * (1) button
        * Save
    * Password
      * (1) button
        * Save
  * (1) button
    * Back arrow <-
    
Only variations of the last 2 screens on the wireframe and described above, have been developed for this version of the app. The first 4 screens (the home screen, the sign in, the welcome user,  & the attendance/current screen) are all currently under development and will not be included in this first version. 

{% include wireframe.md %}
