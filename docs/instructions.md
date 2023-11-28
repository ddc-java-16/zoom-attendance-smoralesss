---
title: Instructions
description: "Project build instructions and user instructions for the app."
menu: Instructions
order: 30
---

{% include ddc-abbreviations.md %}

## Build instructions
{: menu="Build" }

* Create an account or login with credentials at https://marketplace.zoom.us.
* Click the dropdown "Develop" from the upper right corner of the page and select "Build App".
* Find "Server-to-Server OAuth", and click on "Create" button.
* Name your application and type the name chosen in the text input field. Click on "Create" button.
* COPY & STORE for later use in local.properties file:
  * Account ID
  * Client ID
  * Client Secret
* After, click "Continue" button.
* Complete all necessary fields (Short Description, Company Name, Name & Email) and click "Continue" button.
* Copy Secret Token and Verification Token for good measure. Click "Continue" button.
* Click "+ Add Scopes" button:
  * In new dialog:
    * Select "Meeting"
      * Mark "View and manage all user meetings" selection
    * Select "User"
      * Mark "View all users information and manage users" selection
      * And mark "View all user information"
    * Select "Account"
      * Mark "View account info"
      * And mark "View and manage account info"
    * Click on "Done" button.
  * Click on "Continue" button.
* Click on "Activate your app" button.
* Download the Zoom SDK from https://developers.zoom.us/docs/meeting-sdk/android/get-started/install-sdk/
* Traverse this outdated page https://developers.zoom.us/docs/meeting-sdk/android/build-an-app/#import-the-meeting-sdk-libraries and import the SDK libraries to your project.


## User instructions
{: menu="User" }

* Clone/download the repository.
* Import the project into Android Studio/IntelliJ IDEA.
* In your app directory, create a file named local.properties and following this schema, paste the previously stored App Credentials generated in the User Instructions.
  * account_id=
  * client_id=
  * client_secret=
* Execute the build.
* Cross your mingers!
