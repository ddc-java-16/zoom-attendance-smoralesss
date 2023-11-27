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

Once you are logged into the app, it populates your meeting history of previously attended Zoom meetings. This is thanks to the services provided by the Zoom API and faculties such as the user id. Due to unforeseen complications with the Zoom API, a list of participants is not available and in use within the scope of this project. 

## Intended users & user stories
{: menu="Users" }

* A teacher or instructor who needs to keep track of virtual attendance for their students, via Zoom.

    > "As a teacher who needs to keep track of virtual attendance for my students via Zoom, I want to have a seamless attendance tracking feature in the application so that I can efficiently monitor and record students' participation, ensuring accurate records for future reference and assessments."

* Someone in a supervisory or managerial position within a company who needs to utilize an attendance tracking software for their business meetings conducted via Zoom.

    > "As someone in a supervisory or managerial position within a company, I want to use an attendance tracking software for our business meetings conducted via Zoom so that I can ensure efficient and accountable participation, streamline reporting, and make informed decisions based on attendance data, ultimately improving the effectiveness of our meetings and business operations."
  
## Functionality

* User Authentication: Users can log in securely to access the app, ensuring data privacy.
* Meeting Integration: The app should seamlessly integrate with Zoom meetings, allowing users to select which meetings to track.
* Attendance Tracking: Users can mark attendance for participants as they join or leave the meeting, with timestamps.
* Real-time Updates: The app provides real-time updates on attendance, enabling the host to monitor participation.
* Participant Details: Users can view participant information, including names and email addresses.
* Custom Fields: It allows users to add custom fields for additional participant information, such as role or ID.
* Export Data: Users can export attendance data to various formats (CSV, PDF) for record-keeping.
* Attendance Reports: The app generates detailed reports, summarizing attendance data for each meeting.
* Search and Filter: Users can search for specific meetings or participants and filter data as needed.
* Privacy and Compliance: Ensure compliance with data privacy regulations, like GDPR, and secure user data.
* User-Friendly Interface: Intuitive and user-friendly design for easy navigation and operation.
* Feedback and Support: Provide a channel for users to seek help and provide feedback.

## Persistent data
{: menu="Persistence" }

* Meeting History: Information about previously tracked Zoom meetings, including meeting names, IDs, timestamps, and attendance records. This allows users to review past meetings without a server connection.
* Custom Fields: Any custom fields or additional participant information created by the user for specific meetings.
* User Accounts: User account details, such as usernames, profile pictures, and login tokens for quick access without frequent reauthentication.
* Cached Meeting Participants: A local cache of participant information (names, email addresses) for recently attended meetings to display attendee details even offline.
* Reports and Analytics: Generated attendance reports and analytics data for past meetings to allow users to view historical data without an internet connection.
* User
    * Display name
    * OAuth2.0 identifier
    * Timestamp of first login to the app
    
## Device/external services
{: menu="Services" }

* Feedback and support platforms
* Compliance services
* Privacy and security tools
* Customization tools
* User management tools
* Email services
* Data storage
* Google Sign-In API or other user authentication service
* Zoom API
* Access to device's 
  * Microphone
  * Camera
  * Notifications
  * Operating system (Android)

## Stretch goals and possible enhancements 
{: menu="Stretch goals" }

* User Preferences: User settings, such as language preferences, notification preferences, and default meeting settings.
* Analytics: It provides insights into attendance trends and patterns over time.
* Integration with LMS: If applicable, integration with Learning Management Systems for seamless tracking.
* Automated Reminders: Optionally, it can send automated reminders to participants to join the meeting.
* User Roles: Different user roles (host, co-host, attendee) with varying permissions for data access.
* Notifications: Notify hosts of late arrivals or early departures.
