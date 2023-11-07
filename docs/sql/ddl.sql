-- Generated 2023-11-07 14:12:09-0700 for database version 1

CREATE TABLE IF NOT EXISTS `user`
(
    `user_id`      INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `created`      INTEGER                           NOT NULL,
    `oauth_key`    TEXT                              NOT NULL,
    `display_name` TEXT                              NOT NULL COLLATE NOCASE
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_user_oauth_key` ON `user` (`oauth_key`);

CREATE UNIQUE INDEX IF NOT EXISTS `index_user_display_name` ON `user` (`display_name`);

CREATE TABLE IF NOT EXISTS `student`
(
    `student_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `name`       TEXT COLLATE NOCASE
);

CREATE TABLE IF NOT EXISTS `zoom_meeting`
(
    `zoom_meeting_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `student_id`      INTEGER                           NOT NULL,
    `created`         INTEGER                           NOT NULL,
    `started`         INTEGER                           NOT NULL,
    `duration`        INTEGER                           NOT NULL,
    FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS `index_zoom_meeting_student_id` ON `zoom_meeting` (`student_id`);