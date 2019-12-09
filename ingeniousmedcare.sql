-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 09 déc. 2019 à 15:27
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ingeniousmedcare`
--
CREATE DATABASE IF NOT EXISTS `ingeniousmedcare` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `ingeniousmedcare`;

-- --------------------------------------------------------

--
-- Structure de la table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
CREATE TABLE IF NOT EXISTS `doctor` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `firstName` varchar(255) COLLATE utf8_bin NOT NULL,
  `specialization` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `medicalstock`
--

DROP TABLE IF EXISTS `medicalstock`;
CREATE TABLE IF NOT EXISTS `medicalstock` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `description` varchar(2555) COLLATE utf8_bin NOT NULL,
  `indication` varchar(255) COLLATE utf8_bin NOT NULL,
  `laboratory` varchar(255) COLLATE utf8_bin NOT NULL,
  `composition` varchar(255) COLLATE utf8_bin NOT NULL,
  `quantity` int(10) NOT NULL,
  `cisCode` int(11) NOT NULL,
  `idToxicity` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE IF NOT EXISTS `patient` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `firstName` varchar(255) COLLATE utf8_bin NOT NULL,
  `birthDate` date NOT NULL,
  `email` varchar(255) COLLATE utf8_bin NOT NULL,
  `gender` varchar(1) COLLATE utf8_bin NOT NULL,
  `address` varchar(255) COLLATE utf8_bin NOT NULL,
  `city` varchar(255) COLLATE utf8_bin NOT NULL,
  `postalCode` int(5) NOT NULL,
  `phoneNumber` int(10) NOT NULL,
  `homePhoneNumber` int(10) NOT NULL,
  `country` varchar(255) COLLATE utf8_bin NOT NULL,
  `profession` varchar(255) COLLATE utf8_bin NOT NULL,
  `civilStatus` varchar(255) COLLATE utf8_bin NOT NULL,
  `socialSecurityNumber` int(13) NOT NULL,
  `mutualNumber` int(8) NOT NULL,
  `bloodGroup` varchar(2) COLLATE utf8_bin NOT NULL,
  `pathology` varchar(255) COLLATE utf8_bin NOT NULL,
  `note` varchar(255) COLLATE utf8_bin NOT NULL,
  `familyDoctor` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `planning`
--

DROP TABLE IF EXISTS `planning`;
CREATE TABLE IF NOT EXISTS `planning` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `dateTimeStart` datetime NOT NULL,
  `dateTimeEnd` datetime NOT NULL,
  `doctorId` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(10) NOT NULL,
  `nameRole` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `toxicity`
--

DROP TABLE IF EXISTS `toxicity`;
CREATE TABLE IF NOT EXISTS `toxicity` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) COLLATE utf8_bin NOT NULL,
  `email` varchar(255) COLLATE utf8_bin NOT NULL,
  `password` varchar(255) COLLATE utf8_bin NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `firstName` varchar(255) COLLATE utf8_bin NOT NULL,
  `idRole` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `login`, `email`, `password`, `name`, `firstName`, `idRole`) VALUES
(1, 'qzd', 'l.moulin@lprs.fr', 'qzd', 'qzd', 'qzd', 2);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
