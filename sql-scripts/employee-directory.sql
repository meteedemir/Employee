CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
	(1,'Valya','Harkonnen','valya@harkonnen.com','(206) 342-8631'),
	(2,'Elliot','Alderson','elliot@alderson.com','(201) 874-8593'),
	(3,'Paul','Atreides','paul@atreides.com','(209) 300-2557'),
	(4,'Jeff','Roy','jeff@roy.com','(717) 550-1675'),
	(5,'Kendall','Bezos','kendall@bezosmembersemployee.com','(262) 162-1585');

