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

List (using a bullet list---or ordered list, if order is relevant) the key functional aspects that will be provided by the app---i.e. tell us what the user will be able to do using the app. This should not simply be a re-statement of the [summary](#summary), but should instead provide a more specific articulation of the functionality and user experience. 

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

If you can identify functional elements of the software that you think might not be achievable in the scope of the project, but which would nonetheless add significant value if you were able to include them, list them here. For now, we recommend listing them in order of complexity/amount of work, from the least to the most.
