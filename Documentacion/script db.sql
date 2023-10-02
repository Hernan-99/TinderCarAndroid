CREATE DATABASE  IF NOT EXISTS `tindercar` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tindercar`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: tindercar
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `adm_log`
--

DROP TABLE IF EXISTS `adm_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adm_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tiempo_accion` datetime(6) DEFAULT NULL,
  `id_objeto` longtext,
  `objeto` varchar(200) DEFAULT NULL,
  `action_flag` varchar(150) DEFAULT NULL,
  `mensaje` longtext,
  `content_type_id` int DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `adm_log_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adm_log`
--

LOCK TABLES `adm_log` WRITE;
/*!40000 ALTER TABLE `adm_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `adm_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auth_permission`
--

DROP TABLE IF EXISTS `auth_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auth_permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `last_login` int DEFAULT NULL,
  `is_superuser` int DEFAULT NULL,
  `nombre_usu` varchar(150) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `is_staff` tinyint DEFAULT NULL,
  `is_active` tinyint DEFAULT NULL,
  `fecha_joined` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_permission`
--

LOCK TABLES `auth_permission` WRITE;
/*!40000 ALTER TABLE `auth_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `auth_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auth_usuario`
--

DROP TABLE IF EXISTS `auth_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auth_usuario` (
  `id_auth` int NOT NULL AUTO_INCREMENT,
  `contrasenia` varchar(100) DEFAULT NULL,
  `last_login` int DEFAULT NULL,
  `is_superuser` int DEFAULT NULL,
  `nombre_usu` varchar(150) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `is_staff` tinyint DEFAULT NULL,
  `is_active` tinyint DEFAULT NULL,
  `fecha_joined` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id_auth`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_usuario`
--

LOCK TABLES `auth_usuario` WRITE;
/*!40000 ALTER TABLE `auth_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `auth_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cochera`
--

DROP TABLE IF EXISTS `cochera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cochera` (
  `id_cochera` int NOT NULL AUTO_INCREMENT,
  `nombre_cochera` varchar(50) DEFAULT NULL,
  `imagen` varchar(200) DEFAULT NULL,
  `descripcion` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id_cochera`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cochera`
--

LOCK TABLES `cochera` WRITE;
/*!40000 ALTER TABLE `cochera` DISABLE KEYS */;
/*!40000 ALTER TABLE `cochera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicio`
--

DROP TABLE IF EXISTS `servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicio` (
  `id_servicio` bigint NOT NULL AUTO_INCREMENT,
  `servicio` varchar(20) DEFAULT NULL,
  `precio` int DEFAULT NULL,
  `cochera_id` int DEFAULT NULL,
  PRIMARY KEY (`id_servicio`),
  KEY `cochera_id` (`cochera_id`),
  CONSTRAINT `servicio_ibfk_1` FOREIGN KEY (`cochera_id`) REFERENCES `cochera` (`id_cochera`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio`
--

LOCK TABLES `servicio` WRITE;
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiempo_alquiler`
--

DROP TABLE IF EXISTS `tiempo_alquiler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tiempo_alquiler` (
  `id_tiempo` bigint NOT NULL AUTO_INCREMENT,
  `tiempo` varchar(20) DEFAULT NULL,
  `precio` int DEFAULT NULL,
  `cochera_id` int DEFAULT NULL,
  PRIMARY KEY (`id_tiempo`),
  KEY `cochera_id` (`cochera_id`),
  CONSTRAINT `tiempo_alquiler_ibfk_1` FOREIGN KEY (`cochera_id`) REFERENCES `cochera` (`id_cochera`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiempo_alquiler`
--

LOCK TABLES `tiempo_alquiler` WRITE;
/*!40000 ALTER TABLE `tiempo_alquiler` DISABLE KEYS */;
/*!40000 ALTER TABLE `tiempo_alquiler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre_usuario` varchar(50) DEFAULT NULL,
  `contrasenia_usuario` varchar(9) DEFAULT NULL,
  `aceptar_terminos` tinyint DEFAULT NULL,
  `apellido_usuario` varchar(50) DEFAULT NULL,
  `correo_usuario` varchar(254) DEFAULT NULL,
  `telefono_usuario` int DEFAULT NULL,
  `rol` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'tindercar'
--

--
-- Dumping routines for database 'tindercar'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-01 22:28:18
