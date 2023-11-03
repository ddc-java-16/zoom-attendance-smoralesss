---
title: Overview
description: "Project proposal or summary of in-progress/completed project."
menu: Overview
order: 0
---

{% include ddc-abbreviations.md %}

## Summary

This application serves as an essential attendance record, enabling users to perform mathematical computations on user-driven data. This functionality is made possible through Zoom's existing APIs.

## Intended users & user stories
{: menu="Users" }

* A teacher or instructor who needs to keep track of virtual attendance for their students, via Zoom.

    > As a teacher who needs to keep track of virtual attendance for my students via Zoom, I want to have a seamless attendance tracking feature in the application so that I can efficiently monitor and record students' participation, ensuring accurate records for future reference and assessments.

* Someone in a supervisory or managerial position within a company who needs to utilize an attendance tracking software for their business meetings conducted via Zoom.

    > As someone in a supervisory or managerial position within a company, I want to use an attendance tracking software for our business meetings conducted via Zoom so that I can ensure efficient and accountable participation, streamline reporting, and make informed decisions based on attendance data, ultimately improving the effectiveness of our meetings and business operations.
  

## Functionality

A Zoom attendance tracking app could offer the following key functional aspects:

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

By offering these features, the app aims to enhance the user experience and streamline the attendance tracking process during Zoom meetings.

## Persistent data
{: menu="Persistence" }

Using a bullet list, list what content will be stored on the Android device. This should include any information that users of your app would expect to be maintained (i.e. without connection to a server) across multiple sessions of use.

For example, this starter app already includes the necessary data model elements and data-access code to store & retrieve the following 

* User
    * Display name
    * OAuth2.0 identifier
    * Timestamp of first login to the app
    
## Device/external services
{: menu="Services" }

If the client component will need to access special services of the device (e.g. sensors, contacts, messaging), list them here using a bullet list. Also, if the client component will need to access already-existing external services (e.g. real-time weather data, Open Movie Database, Open Trivia Database), those should also be listed here; any such references to external services should include links to the main page or API description page for the service.

## Stretch goals and possible enhancements 
{: menu="Stretch goals" }

* Analytics: It provides insights into attendance trends and patterns over time.
* Integration with LMS: If applicable, integration with Learning Management Systems for seamless tracking.
* Automated Reminders: Optionally, it can send automated reminders to participants to join the meeting.
* User Roles: Different user roles (host, co-host, attendee) with varying permissions for data access.
* Notifications: Notify hosts of late arrivals or early departures.
