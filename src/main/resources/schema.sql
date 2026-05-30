-- MySQL dump 10.13  Distrib 8.0.45, for Linux (x86_64)
--
-- Host: localhost   Database: eventosParaCongreso
-- ------------------------------------------------------
-- Server version	8.0.45-0ubuntu0.24.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `AUTORIA`
--

DROP TABLE IF EXISTS `AUTORIA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `AUTORIA` (
                           `tipoAutoria` enum('autor','coautor') DEFAULT 'autor',
                           `idUsuario` int unsigned DEFAULT NULL,
                           `idTrabajo` int unsigned NOT NULL,
                           KEY `indiceIdUsuario` (`idUsuario`),
                           KEY `indiceIdTrabajo` (`idTrabajo`),
                           CONSTRAINT `AUTORIA_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `CONGRESISTA` (`idUsuario`) ON DELETE SET NULL,
                           CONSTRAINT `AUTORIA_ibfk_2` FOREIGN KEY (`idTrabajo`) REFERENCES `TRABAJO` (`idTrabajo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AUTORIA`
--

LOCK TABLES `AUTORIA` WRITE;
/*!40000 ALTER TABLE `AUTORIA` DISABLE KEYS */;
/*!40000 ALTER TABLE `AUTORIA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CONGRESISTA`
--

DROP TABLE IF EXISTS `CONGRESISTA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CONGRESISTA` (
                               `fechaRegistro` date NOT NULL,
                               `idUsuario` int unsigned NOT NULL,
                               PRIMARY KEY (`idUsuario`),
                               CONSTRAINT `CONGRESISTA_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `USUARIO` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CONGRESISTA`
--

LOCK TABLES `CONGRESISTA` WRITE;
/*!40000 ALTER TABLE `CONGRESISTA` DISABLE KEYS */;
/*!40000 ALTER TABLE `CONGRESISTA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CREACION`
--

DROP TABLE IF EXISTS `CREACION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CREACION` (
                            `fechaCreacion` date NOT NULL,
                            `idUsuario` int unsigned NOT NULL,
                            `idSesion` int unsigned NOT NULL,
                            PRIMARY KEY (`idUsuario`,`idSesion`),
                            KEY `indiceIdUsuario` (`idUsuario`),
                            KEY `indiceIdSesion` (`idSesion`),
                            CONSTRAINT `CREACION_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `LOGISTICA` (`idUsuario`) ON DELETE RESTRICT,
                            CONSTRAINT `CREACION_ibfk_2` FOREIGN KEY (`idSesion`) REFERENCES `SESION` (`idSesion`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CREACION`
--

LOCK TABLES `CREACION` WRITE;
/*!40000 ALTER TABLE `CREACION` DISABLE KEYS */;
/*!40000 ALTER TABLE `CREACION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EVALUACION`
--

DROP TABLE IF EXISTS `EVALUACION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `EVALUACION` (
                              `voto` enum('Aceptar','rechazar') DEFAULT NULL,
                              `idTrabajo` int unsigned NOT NULL,
                              `idUsuario` int unsigned NOT NULL,
                              `idSesion` int unsigned NOT NULL,
                              PRIMARY KEY (`idUsuario`,`idSesion`),
                              KEY `indiceIdSesion` (`idSesion`),
                              KEY `indiceIdUsuario` (`idUsuario`),
                              KEY `indiceIdTrabajo` (`idTrabajo`),
                              CONSTRAINT `EVALUACION_ibfk_1` FOREIGN KEY (`idUsuario`, `idSesion`) REFERENCES `TIPO_PARTICIPACION` (`idUsuario`, `idSesion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EVALUACION`
--

LOCK TABLES `EVALUACION` WRITE;
/*!40000 ALTER TABLE `EVALUACION` DISABLE KEYS */;
/*!40000 ALTER TABLE `EVALUACION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LOGISTICA`
--

DROP TABLE IF EXISTS `LOGISTICA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `LOGISTICA` (
                             `responsabilidad` varchar(200) NOT NULL,
                             `idUsuario` int unsigned NOT NULL,
                             PRIMARY KEY (`idUsuario`),
                             UNIQUE KEY `idUsuario` (`idUsuario`),
                             CONSTRAINT `LOGISTICA_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `USUARIO` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LOGISTICA`
--

LOCK TABLES `LOGISTICA` WRITE;
/*!40000 ALTER TABLE `LOGISTICA` DISABLE KEYS */;
/*!40000 ALTER TABLE `LOGISTICA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PROGRAMACION_TRABAJOS`
--

DROP TABLE IF EXISTS `PROGRAMACION_TRABAJOS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PROGRAMACION_TRABAJOS` (
                                         `idSesion` int unsigned NOT NULL,
                                         `idTrabajo` int unsigned NOT NULL,
                                         PRIMARY KEY (`idSesion`,`idTrabajo`),
                                         KEY `indiceIdTrabajo` (`idTrabajo`),
                                         KEY `indiceIdSesion` (`idSesion`),
                                         CONSTRAINT `PROGRAMACION_TRABAJOS_ibfk_1` FOREIGN KEY (`idSesion`) REFERENCES `SESION` (`idSesion`) ON DELETE CASCADE,
                                         CONSTRAINT `PROGRAMACION_TRABAJOS_ibfk_2` FOREIGN KEY (`idTrabajo`) REFERENCES `TRABAJO` (`idTrabajo`) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROGRAMACION_TRABAJOS`
--

LOCK TABLES `PROGRAMACION_TRABAJOS` WRITE;
/*!40000 ALTER TABLE `PROGRAMACION_TRABAJOS` DISABLE KEYS */;
/*!40000 ALTER TABLE `PROGRAMACION_TRABAJOS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SALA`
--

DROP TABLE IF EXISTS `SALA`;
/*!40101 SET @saved_cs_client      = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SALA` (
                        `numSala` int unsigned NOT NULL,
                        `nombreSala` varchar(200) DEFAULT NULL,
                        `salaStatus` enum('ENABLED','DISABLED') DEFAULT 'ENABLED',
                        PRIMARY KEY (`numSala`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SALA`
--

LOCK TABLES `SALA` WRITE;
/*!40000 ALTER TABLE `SALA` DISABLE KEYS */;
/*!40000 ALTER TABLE `SALA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SESION`
--

DROP TABLE IF EXISTS `SESION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SESION` (
                          `idSesion` int unsigned NOT NULL AUTO_INCREMENT,
                          `fecha` date NOT NULL,
                          `horaInicio` time NOT NULL,
                          `horaFin` time NOT NULL,
                          `categoria` varchar(255) NOT NULL,
                          `numSala` int unsigned DEFAULT NULL,
                          PRIMARY KEY (`idSesion`),
                          KEY `indiceNumSala` (`numSala`),
                          CONSTRAINT `SESION_ibfk_1` FOREIGN KEY (`numSala`) REFERENCES `SALA` (`numSala`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SESION`
--

LOCK TABLES `SESION` WRITE;
/*!40000 ALTER TABLE `SESION` DISABLE KEYS */;
/*!40000 ALTER TABLE `SESION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TIPO_PARTICIPACION`
--

DROP TABLE IF EXISTS `TIPO_PARTICIPACION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TIPO_PARTICIPACION` (
                                      `tipoParciticipacion` enum('chairman','examinador','ponente','congresista') NOT NULL,
                                      `idUsuario` int unsigned NOT NULL,
                                      `idSesion` int unsigned NOT NULL,
                                      PRIMARY KEY (`idUsuario`,`idSesion`),
                                      KEY `indiceIdSesion` (`idSesion`),
                                      KEY `indiceIdUsuario` (`idUsuario`),
                                      CONSTRAINT `TIPO_PARTICIPACION_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `USUARIO` (`id`) ON DELETE RESTRICT,
                                      CONSTRAINT `TIPO_PARTICIPACION_ibfk_2` FOREIGN KEY (`idSesion`) REFERENCES `SESION` (`idSesion`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TIPO_PARTICIPACION`
--

LOCK TABLES `TIPO_PARTICIPACION` WRITE;
/*!40000 ALTER TABLE `TIPO_PARTICIPACION` DISABLE KEYS */;
/*!40000 ALTER TABLE `TIPO_PARTICIPACION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TRABAJO`
--

DROP TABLE IF EXISTS `TRABAJO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TRABAJO` (
                           `idTrabajo` int unsigned NOT NULL,
                           `titulo` varchar(100) NOT NULL,
                           `resumen` varchar(255) NOT NULL,
                           `tematica` varchar(100) NOT NULL,
                           `estado` enum('aprovado','rechazado','en espera','en evaluacion') NOT NULL DEFAULT 'en espera',
                           PRIMARY KEY (`idTrabajo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TRABAJO`
--

LOCK TABLES `TRABAJO` WRITE;
/*!40000 ALTER TABLE `TRABAJO` DISABLE KEYS */;
/*!40000 ALTER TABLE `TRABAJO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USUARIO`
--

DROP TABLE IF EXISTS `USUARIO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `USUARIO` (
                           `id` int unsigned NOT NULL AUTO_INCREMENT,
                           `nombre` varchar(100) NOT NULL,
                           `apellido` varchar(200) NOT NULL,
                           `correo` varchar(255) NOT NULL,
                           `institucion` varchar(255) NOT NULL,
                           `telefono` int DEFAULT NULL,
                           `areaInvestigacion` varchar(200) NOT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USUARIO`
--

LOCK TABLES `USUARIO` WRITE;
/*!40000 ALTER TABLE `USUARIO` DISABLE KEYS */;
/*!40000 ALTER TABLE `USUARIO` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-24 17:47:19

