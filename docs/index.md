---
title: Overview
description: "Project proposal or summary of in-progress/completed project."
menu: Overview
order: 0
---

{% include ddc-abbreviations.md %}

## Summary

This application serves as an essential attendance record tracking application. It, enables users to perform computations on user-driven data. This functionality is made possible through Zoom's existing APIs.

I developed this application because I saw an obvious need for it. Any educator or business leader utilizing Zoom for remote learning stands to gain from its integrated attendance tracking features. It exemplifies how technology can simplify your life.

Once you are logged into the app, it populates your meeting history of previously attended Zoom meetings. This is thanks to the services provided by the Zoom API and utilities (such as the Zoom meeting API, the user Id, etc.). Due to unforeseen complications with the Zoom API, a list of participants is not available and in use within the scope of this project. 

## Intended users & user stories
{: menu="Users" }

* A teacher or instructor who needs to keep track of virtual attendance for their students, via Zoom.

    > "As a teacher who needs to keep track of virtual attendance for my students via Zoom, I want to have a seamless attendance tracking feature in the application so that I can efficiently monitor and record students' participation, ensuring accurate records for future reference and assessments."

* Someone in a supervisory or managerial position within a company who needs to utilize an attendance tracking software for their business meetings conducted via Zoom.

    > "As someone in a supervisory or managerial position within a company, I want to use an attendance tracking software for our business meetings conducted via Zoom so that I can ensure efficient and accountable participation, streamline reporting, and make informed decisions based on attendance data, ultimately improving the effectiveness of our meetings and business operations."
  
## Functionality

* User Authentication: Users can log in securely to access the app, ensuring data privacy.
* Meeting Integration: The app should seamlessly integrate with Zoom meetings, allowing users to automatically view their past Zoom meeting records.
* Real-time Updates: The app provides real-time updates on attendance (after pressing the refresh button).

* Search and Filter: Users can search for specific meetings or participants and filter data as needed.
* Privacy and Compliance: Ensure compliance with data privacy regulations and secure user data.
* User-Friendly Interface: Intuitive and user-friendly design for easy navigation and operation.


## Persistent data
{: menu="Persistence" }

* Meeting History: Information about previously tracked Zoom meetings, including meeting names, IDs & timestamps. This allows users to review past meetings without a server connection.
* User
    * Display name
    * OAuth2.0 identifier
    * Timestamp of first login to the app
    
## Device/external services
{: menu="Services" }

* Compliance services
* Privacy and security tools
* Customization tools
* User management tools
* Data storage
* Zoom API login for user authentication
* Access to device's
  * Operating system (Android)

## Stretch goals and possible enhancements 
{: menu="Stretch goals" }

* Attendance Tracking: Users can mark attendance for participants as they join or leave the meeting, with timestamps.
* User Preferences: User settings, such as language preferences, notification preferences, and default meeting settings.
* Analytics: It provides insights into attendance trends and patterns over time.
* Integration with LMS: If applicable, integration with Learning Management Systems for seamless tracking.
* Automated Reminders: Optionally, it can send automated reminders to participants to join the meeting.
* User Roles: Different user roles (host, co-host, attendee) with varying permissions for data access.
* Notifications: Notify hosts of late arrivals or early departures.
* A list of meeting attendance participants.
* Custom Fields: Any custom fields or additional participant information created by the user for specific meetings.
* User Accounts: User account details, such as usernames, profile pictures, and login tokens for quick access without frequent re-authentication.
* Cached Meeting Participants: A local cache of participant information (names, email addresses) for recently attended meetings to display attendee details even offline.
* Reports and Analytics: Generate attendance reports and analytics data for past meetings to allow users to view historical data without an internet connection.
* Feedback and Support: Provide a channel for users to seek help and provide feedback.
