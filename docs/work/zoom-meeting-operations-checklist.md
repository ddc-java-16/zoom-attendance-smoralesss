# Entity Operations Checklist

## Entity name: ZoomMeeting

## Operations

In the list of operations below, check all the operations that apply. For example, if you know you will need to be able to insert a single instance of the entity at a time into the database, check **Single instance** in the **Create/insert** section.

Note that the pairs of square brackets below are rendered as checkboxes in GitHub Pages. To insert a checkmark, **replace** the single space between the square brackets in the Markdown with an "x" character (uppercase or lowercase; **do not** include the quote characters). To remove a checkmark, **replace** the "x" between the square brackets with a **single** space character. Aside from adding or removing checkmarks, do not modify the formatting or content of the remainder of this section.

### Create/insert
    
* [x] Single instance 
* [ ] Multiple instances 
    
### Read/query/select

* [x] Single instance 
* [x] Multiple instances 

### Update

* [ ] Single instance 
* [ ] Multiple instances 

### Delete

* [x] Single instance 
* [x] Multiple instances 


## Queries

For any queries (i.e. selecting from the database) that you think you will need to do with this entity, summarize the purpose of the query (what functionality in your application will use the query), whether the query is intended to return a single instance or multiple instances (and whether returning no instances is a valid possibility), what field/column of your entity will be used as filter criteria, and in what order the results (if multiple) should be returned.

Copy and paste the section below as many times as necessary, for all of the queries you currently anticipate implementing for this entity.

### Query: "CREATE/INSERT a zoom meeting"

Purpose

: To be able to create/insert a zoom meeting in the database.

Cardinality/modality

: one/required.
 
Filter

: zoom_meeting_id
 
Sort order

: ASC

### Query: "Read/query/SELECT a zoom meeting"

Purpose

: To be able to query/read/select a zoom meeting in the database.

Cardinality/modality

: one/required.

Filter

: student_id

Sort order

: ASC

### Query: "GET all zoom meetings"

Purpose

: To be able to query and see all instances of the zoom meetings in the database.

Cardinality/modality

: Many/required.

Filter

: student_id

Sort order

: ASC

### Query: "DELETE a zoom meeting"

Purpose

: To be able to delete a zoom meeting in the database.

Cardinality/modality

: one/required.

Filter

: zoom_meeting_id; student_id

Sort order

: ASC; ASC

### Query: "DELETE all zoom meetings"

Purpose

: To be able to delete all zoom meetings in the database.

Cardinality/modality

: Many/required.

Filter

: zoom_meeting_id; student_id 

Sort order

: ASC; ASC



