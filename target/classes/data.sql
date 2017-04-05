-- Populating the ROLE table. If the table is empty, registration will not work.
INSERT IGNORE INTO `db_alex`.`role` (`role_id`, `name`)
VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN'), (3, 'ROLE_LIBRARIAN'), (4, 'ROLE_STUDENT');
--INSERT IGNORE INTO `db_alex`.`role` (`name`) VALUES ('ROLE_ADMIN');
--INSERT IGNORE INTO `db_alex`.`role` (`name`) VALUES ('ROLE_LIBRARIAN');
--INSERT IGNORE INTO `db_alex`.`role` (`name`) VALUES ('ROLE_STUDENT');
