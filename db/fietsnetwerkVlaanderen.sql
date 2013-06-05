CREATE DATABASE  IF NOT EXISTS `knooppuntennetwerkenvlaanderen` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `knooppuntennetwerkenvlaanderen`;
-- MySQL dump 10.13  Distrib 5.1.40, for Win32 (ia32)
--
-- Host: localhost    Database: knooppuntennetwerkenvlaanderen
-- ------------------------------------------------------
-- Server version	5.5.8

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `knooppunt`
--

DROP TABLE IF EXISTS `knooppunt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `knooppunt` (
  `idknooppunt` int(11) NOT NULL,
  `knooppuntnummer` int(11) NOT NULL,
  `gemeente` varchar(45) DEFAULT NULL,
  `omschrijving` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idknooppunt`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `knooppunt`
--

LOCK TABLES `knooppunt` WRITE;
/*!40000 ALTER TABLE `knooppunt` DISABLE KEYS */;
INSERT INTO `knooppunt` VALUES (0,18,'Kortrijk','Leiestreek Bissegem'),(1,19,'Kortrijk','Leiestreek Bissegem'),(2,20,'Kortrijk','Marke Rekkemsestraat'),(3,21,'Kortrijk','Kloosterstraat'),(4,31,'Kortrijk','Rollegemknokstraat'),(5,30,'Kortrijk','Elleboogstraat'),(6,37,'Kortrijk','Schaapsdreef'),(7,50,'Zwevegem','Kwadepoelstraat'),(8,59,'Zwevegem','Bekaertstraat'),(9,49,'Kortrijk','Keizerstraat'),(10,36,'Kortrijk','Hugo Verriestlaan'),(11,29,'Kortrijk','Damkaai'),(12,28,'Kortrijk','Diksmuidekaai'),(13,17,'Kortrijk','Heulsestraat'),(14,16,'Heule','Dokter Dumortierlaan'),(15,11,'Heule','Aardappelhoek'),(16,5,'Moorsele','Zuidhoekstraat'),(17,6,'Moorsele','Ter poperenweg'),(18,7,'Moorsele','Ezelstraat'),(19,10,'Lauwe','Wevelgemstraat'),(20,9,'Lauwe','Wevelgemstraat'),(21,22,'Lauwe','Preshoekstraat');
/*!40000 ALTER TABLE `knooppunt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `route` (
  `idRoute` int(11) NOT NULL,
  `startKnooppuntId` int(11) NOT NULL,
  `eindKnooppuntId` int(11) NOT NULL,
  `aantalKm` int(11) DEFAULT NULL,
  `info` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idRoute`),
  KEY `FK1` (`startKnooppuntId`),
  KEY `FK2` (`eindKnooppuntId`),
  CONSTRAINT `FK1` FOREIGN KEY (`startKnooppuntId`) REFERENCES `knooppunt` (`idknooppunt`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK2` FOREIGN KEY (`eindKnooppuntId`) REFERENCES `knooppunt` (`idknooppunt`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES (0,0,1,1,NULL),(1,1,2,3,'Brug oversteken'),(2,2,3,2,NULL),(3,3,4,12,NULL),(4,4,5,8,NULL),(5,5,6,14,NULL),(6,6,7,8,NULL),(7,7,8,6,NULL),(8,8,9,9,NULL),(9,9,10,7,NULL),(10,10,11,4,'wegwerkzaamheden 2011'),(11,11,12,2,NULL),(12,12,0,5,NULL),(13,0,13,4,NULL),(14,13,14,1,NULL),(15,14,15,7,NULL),(16,15,16,2,NULL),(17,16,17,6,NULL),(18,17,18,1,NULL),(19,18,13,5,NULL),(20,1,19,6,NULL),(21,19,20,1,NULL),(22,20,21,3,NULL),(23,21,3,3,NULL),(24,2,10,7,NULL),(25,18,19,8,NULL);
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fietstocht`
--

DROP TABLE IF EXISTS `fietstocht`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fietstocht` (
  `idfietstocht` int(11) NOT NULL AUTO_INCREMENT,
  `naamFietstocht` varchar(45) DEFAULT NULL,
  `aantalKm` varchar(45) DEFAULT NULL,
  `info` varchar(45) DEFAULT NULL,
  `startKnooppuntId` int(11) NOT NULL,
  PRIMARY KEY (`idfietstocht`),
  KEY `fk5` (`startKnooppuntId`),
  CONSTRAINT `fk5` FOREIGN KEY (`startKnooppuntId`) REFERENCES `knooppunt` (`idknooppunt`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fietstocht`
--

LOCK TABLES `fietstocht` WRITE;
/*!40000 ALTER TABLE `fietstocht` DISABLE KEYS */;
INSERT INTO `fietstocht` VALUES (4,'Test1','11','',0),(5,'Test2','26','Goed uitgestippeld. Prima weg!',5),(6,'Cantus Howest Route','18','Niet voor watjes!',0);
/*!40000 ALTER TABLE `fietstocht` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routesinfietstocht`
--

DROP TABLE IF EXISTS `routesinfietstocht`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `routesinfietstocht` (
  `idroutesInFietstocht` int(11) NOT NULL AUTO_INCREMENT,
  `idFietstocht` int(11) DEFAULT NULL,
  `idRoute` int(11) DEFAULT NULL,
  PRIMARY KEY (`idroutesInFietstocht`),
  KEY `fk3` (`idFietstocht`),
  KEY `fk4` (`idRoute`),
  CONSTRAINT `fk3` FOREIGN KEY (`idFietstocht`) REFERENCES `fietstocht` (`idfietstocht`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk4` FOREIGN KEY (`idRoute`) REFERENCES `route` (`idRoute`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routesinfietstocht`
--

LOCK TABLES `routesinfietstocht` WRITE;
/*!40000 ALTER TABLE `routesinfietstocht` DISABLE KEYS */;
INSERT INTO `routesinfietstocht` VALUES (7,4,0),(8,4,1),(9,4,24),(10,5,4),(11,5,3),(12,5,23),(13,5,22),(14,6,12),(15,6,11),(16,6,10),(17,6,24);
/*!40000 ALTER TABLE `routesinfietstocht` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-06-08 14:35:07
