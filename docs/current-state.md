---
title: Current State
description: "Current state of completion, known deficiencies, and test environments used."
menu: State
order: 40
---

{% include ddc-abbreviations.md %}

## Completion state
{: menu="Completion" }

Things needed for ideal completion of app include:
* Participant Details: Users can view participant information, including names and email addresses.
* Custom Fields: It allows users to add custom fields for additional participant information, such as role or ID.
* Export Data: Users can export attendance data to various formats (CSV, PDF) for record-keeping.
* Attendance Reports: The app generates detailed reports, summarizing attendance data for each meeting.

## Known deficiencies
{: menu="Deficiencies" }

* Because of several issues with the Zoom API, the original concept of this app changed late in development; they included:
    * The documentation for the Zoom API was incorrect, out of date, or both.
    * The Zoom Meeting API doesn't return recurrent meetings unless the recurrences are all in the past.
        * It also doesn't return a recurrent meeting that doesn't have a scheduled recurrence.
        * It doesn't return meetings at all if it doesn't have a fixed schedule.
    * And most notably, only returns participants if you have a paid plan! Which means, unless you are willing to pay to use the Zoom API, you WILL NOT have access to participants of any Zoom meeting, beyond oneself.


## Test environments used
{: menu="Environments" }

* This was developed using a Pixel 7 API 33 emulator for testing purposes.
