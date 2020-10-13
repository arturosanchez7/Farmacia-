CREATE DATABASE  IF NOT EXISTS `usu_farmacia` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `usu_farmacia`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: usu_farmacia
-- ------------------------------------------------------
-- Server version	5.7.31-log

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
-- Table structure for table `cpuesto`
--

DROP TABLE IF EXISTS `cpuesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cpuesto` (
  `id_puesto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_puesto` varchar(45) NOT NULL,
  PRIMARY KEY (`id_puesto`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cpuesto`
--

LOCK TABLES `cpuesto` WRITE;
/*!40000 ALTER TABLE `cpuesto` DISABLE KEYS */;
INSERT INTO `cpuesto` VALUES (1,'Administrador'),(2,'Gerente'),(3,'Empleado general');
/*!40000 ALTER TABLE `cpuesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mempleado`
--

DROP TABLE IF EXISTS `mempleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mempleado` (
  `id_empleado` int(11) NOT NULL AUTO_INCREMENT,
  `id_puesto` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apat_emp` varchar(45) NOT NULL,
  `amat_emp` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `genero` varchar(45) NOT NULL,
  `edad` varchar(45) NOT NULL,
  PRIMARY KEY (`id_empleado`),
  KEY `id_puesto_idx` (`id_puesto`),
  CONSTRAINT `id_puesto` FOREIGN KEY (`id_puesto`) REFERENCES `cpuesto` (`id_puesto`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mempleado`
--

LOCK TABLES `mempleado` WRITE;
/*!40000 ALTER TABLE `mempleado` DISABLE KEYS */;
INSERT INTO `mempleado` VALUES (1,1,'Gerardo','Ortiz','Mendez','20284 Northwest 31st Avenue','5579841222','gerardo@gmail.com','M','32'),(2,2,'Luz','Arcos','Aguirre','20284 Northwest 31st Avenue','5596877741','sandra@gmail.com','F','28'),(3,3,'Miguel','Borja','Ortiz','20284 Northwest 31st Avenue','5547889632','miguel@gmail.com','M','25');
/*!40000 ALTER TABLE `mempleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musuario`
--

DROP TABLE IF EXISTS `musuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `id_empleado` int(11) NOT NULL,
  `id_puesto` int(11) NOT NULL,
  `nombre_usuario` varchar(45) NOT NULL,
  `contraseña` varchar(45) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `id_privilegio_idx` (`id_puesto`),
  KEY `id_empleado_idx` (`id_empleado`),
  CONSTRAINT `id_empleado` FOREIGN KEY (`id_empleado`) REFERENCES `mempleado` (`id_empleado`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `id_privilegio` FOREIGN KEY (`id_puesto`) REFERENCES `cpuesto` (`id_puesto`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musuario`
--

LOCK TABLES `musuario` WRITE;
/*!40000 ALTER TABLE `musuario` DISABLE KEYS */;
INSERT INTO `musuario` VALUES (1,1,1,'GerardoA','Admin.'),(2,2,2,'LuzG','Gere.'),(3,3,3,'MiguelE','Emp.');
/*!40000 ALTER TABLE `musuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-09 14:44:24
