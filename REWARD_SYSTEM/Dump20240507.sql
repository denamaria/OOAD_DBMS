-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: reward_system
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departments` (
  `department_id` int NOT NULL AUTO_INCREMENT,
  `department_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (1,'Finance'),(2,'Consulting'),(3,'Marketing'),(4,'Human Resources'),(5,'Audits');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employeeperformance`
--

DROP TABLE IF EXISTS `employeeperformance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employeeperformance` (
  `performance_id` int NOT NULL AUTO_INCREMENT,
  `employee_id` int DEFAULT NULL,
  `performance_date` date DEFAULT NULL,
  `reviewer_id` int DEFAULT NULL,
  `technical_rating` int DEFAULT NULL,
  `behavioural_rating` int DEFAULT NULL,
  PRIMARY KEY (`performance_id`),
  KEY `employee_id` (`employee_id`),
  KEY `reviewer_id` (`reviewer_id`),
  CONSTRAINT `employeeperformance_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`employee_id`),
  CONSTRAINT `employeeperformance_ibfk_2` FOREIGN KEY (`reviewer_id`) REFERENCES `employees` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employeeperformance`
--

LOCK TABLES `employeeperformance` WRITE;
/*!40000 ALTER TABLE `employeeperformance` DISABLE KEYS */;
INSERT INTO `employeeperformance` VALUES (1,5,'2024-05-01',1,5,4),(2,6,'2024-05-01',1,4,4),(3,7,'2024-05-01',1,5,5),(4,8,'2024-05-01',1,4,5),(5,9,'2024-05-01',1,1,1),(6,10,'2024-05-02',1,5,5),(7,11,'2024-05-02',1,3,2),(8,12,'2024-05-02',1,3,1),(9,13,'2024-05-02',1,5,5),(10,14,'2024-05-03',1,5,5);
/*!40000 ALTER TABLE `employeeperformance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employeerewards`
--

DROP TABLE IF EXISTS `employeerewards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employeerewards` (
  `employee_reward_id` int NOT NULL AUTO_INCREMENT,
  `reward_id` int DEFAULT NULL,
  `date_received` date DEFAULT NULL,
  `performance_id` int DEFAULT NULL,
  PRIMARY KEY (`employee_reward_id`),
  KEY `reward_id` (`reward_id`),
  KEY `performance_id` (`performance_id`),
  CONSTRAINT `employeerewards_ibfk_1` FOREIGN KEY (`reward_id`) REFERENCES `reward` (`id`),
  CONSTRAINT `employeerewards_ibfk_2` FOREIGN KEY (`performance_id`) REFERENCES `employeeperformance` (`performance_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employeerewards`
--

LOCK TABLES `employeerewards` WRITE;
/*!40000 ALTER TABLE `employeerewards` DISABLE KEYS */;
INSERT INTO `employeerewards` VALUES (1,1,'2024-05-01',1),(2,2,'2024-05-01',2),(3,1,'2024-05-01',3),(4,2,'2024-05-01',4),(5,2,'2024-05-01',2),(6,5,'2024-05-01',5),(7,1,'2024-05-01',6),(8,1,'2024-05-03',10);
/*!40000 ALTER TABLE `employeerewards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `department_id` int DEFAULT NULL,
  `created_by` int DEFAULT NULL,
  `updated_by` int DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `department_id` (`department_id`),
  KEY `created_by` (`created_by`),
  KEY `updated_by` (`updated_by`),
  CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `departments` (`department_id`),
  CONSTRAINT `employees_ibfk_2` FOREIGN KEY (`created_by`) REFERENCES `employees` (`employee_id`),
  CONSTRAINT `employees_ibfk_3` FOREIGN KEY (`updated_by`) REFERENCES `employees` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Priya','Singh','priyasingh@gmail.com',4,1,1,'2024-05-01 10:30:38'),(4,'Amritha','Sharma','amritha@gmail.com',1,1,1,'2024-05-01 10:32:25'),(5,'Ram','Kumar','ram@gmail.com',1,1,1,'2024-05-01 10:32:25'),(6,'John','Hill','john@gmail.com',3,1,1,'2024-05-01 10:32:25'),(7,'Riya','Gupta','riya@gmail.com',1,1,1,'2024-05-01 10:38:14'),(8,'Susan','George','susan@gmail.com',2,1,1,'2024-05-01 10:38:14'),(9,'Kumar','Guptha','kumar@gmail.com',2,1,1,'2024-05-01 21:44:21'),(10,'Smitha','kumar','smitha@gmail.com',1,1,1,'2024-05-02 21:40:47'),(11,'John','Doe','johndoe@example.com',1,1,1,'2024-05-02 21:51:05'),(12,'Jane','Doe','janedoe@example.com',2,1,1,'2024-05-02 21:51:05'),(13,'Alice','Smith','alicesmith@example.com',3,1,1,'2024-05-02 21:51:19'),(14,'Dona','Maria','dona@gmail.com',5,NULL,NULL,NULL),(15,'Dena','Maria','dena@gmail.com',1,NULL,NULL,NULL);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reward`
--

DROP TABLE IF EXISTS `reward`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reward` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Technical_rating` int DEFAULT NULL,
  `Behavioural_rating` int DEFAULT NULL,
  `Performance` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reward`
--

LOCK TABLES `reward` WRITE;
/*!40000 ALTER TABLE `reward` DISABLE KEYS */;
INSERT INTO `reward` VALUES (1,5,5,'Excellent'),(2,4,4,'Very Good'),(3,3,3,'Good'),(4,2,2,'Average'),(5,1,1,'Poor'),(6,3,2,'Poor'),(7,3,1,'Poor');
/*!40000 ALTER TABLE `reward` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-07 15:11:39
