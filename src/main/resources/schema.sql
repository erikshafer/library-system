-- If the `role` table doesn't exist, create it.
CREATE TABLE IF NOT EXISTS `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
);

CREATE TABLE IF NOT EXISTS `book` (
  `id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `author_name` varchar(255) NOT NULL,
  `book_title` varchar(255) NOT NULL,
  `isbn` int DEFAULT NULL,
  `publication_country` varchar(255) DEFAULT NULL,
  `publication_year` varchar (255) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `author` (
  `author_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `author_name` varchar(255) NOT NULL,
  `author_country` varchar(255) NULL
);