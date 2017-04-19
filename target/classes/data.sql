-- Populating the ROLE table. If the table is empty, registration will not work.
INSERT IGNORE INTO `db_alex`.`role` (`role_id`, `name`)
VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN'), (3, 'ROLE_LIBRARIAN'), (4, 'ROLE_STUDENT');
--INSERT IGNORE INTO `db_alex`.`role` (`name`) VALUES ('ROLE_ADMIN');
--INSERT IGNORE INTO `db_alex`.`role` (`name`) VALUES ('ROLE_LIBRARIAN');
--INSERT IGNORE INTO `db_alex`.`role` (`name`) VALUES ('ROLE_STUDENT');

-- AUTHOR INFO
--INSERT IGNORE INTO `db_alex`.`author` (`author_name`, `author_country`)
--VALUES ('Unknown', 'Unknown'),
--	   ('J. R. R. Tolkien', 'England'),
--	   ('Jane Austen', 'England'),
--	   ('Louisa May Alcott', 'America'),
--	   ('Harriet Beecher Stowe', 'America'),
--	   ('Mark Twain', 'America'),
--	   ('Oscar Wild', 'England'),
--	   ('Maule David', 'England'),
--	   ('Parrinder Patrick', 'England');