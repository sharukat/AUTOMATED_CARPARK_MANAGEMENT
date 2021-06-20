-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: newpslots
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `new_table`
--

DROP TABLE IF EXISTS `new_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `new_table` (
  `SlotID` int(10) unsigned NOT NULL,
  `State` varchar(45) NOT NULL,
  `DTime` varchar(45) DEFAULT NULL,
  `Duration` int(11) DEFAULT NULL,
  `EndTime` varchar(45) DEFAULT NULL,
  `IDNo` varchar(45) NOT NULL,
  `TimeCheck` varchar(45) NOT NULL,
  PRIMARY KEY (`SlotID`),
  UNIQUE KEY `SlotID_UNIQUE` (`SlotID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `new_table`
--

LOCK TABLES `new_table` WRITE;
/*!40000 ALTER TABLE `new_table` DISABLE KEYS */;
INSERT INTO `new_table` VALUES (1,'Vacant','',0,'','',''),(2,'Vacant','',0,'','',''),(3,'Vacant','',0,'','',''),(4,'Vacant','',0,'','',''),(5,'Vacant','',0,'','',''),(6,'Vacant','',0,'','',''),(7,'Vacant','',0,'','',''),(8,'Vacant','',0,'','',''),(9,'Vacant','',0,'','',''),(10,'Vacant','',0,'','',''),(11,'Vacant','',0,'','',''),(12,'Vacant','',0,'','',''),(13,'Vacant','',0,'','',''),(14,'Vacant','',0,'','',''),(15,'Vacant','',0,NULL,'',''),(16,'Vacant','',0,'','',''),(17,'Vacant','',0,'','',''),(18,'Vacant','',0,NULL,'',''),(19,'Vacant','',0,'','',''),(20,'Vacant','',0,'','','');
/*!40000 ALTER TABLE `new_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-28  0:28:00
