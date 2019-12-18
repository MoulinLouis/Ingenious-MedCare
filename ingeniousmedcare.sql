-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 18 déc. 2019 à 13:06
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `doctor`
--

INSERT INTO `doctor` (`id`, `name`, `firstName`, `specialization`) VALUES
(1, 'Eric', 'Benenou', 'Generaliste');

-- --------------------------------------------------------

--
-- Structure de la table `medicalstock`
--

DROP TABLE IF EXISTS `medicalstock`;
CREATE TABLE IF NOT EXISTS `medicalstock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) COLLATE utf8_bin NOT NULL,
  `classification` varchar(255) COLLATE utf8_bin NOT NULL,
  `substance` varchar(255) COLLATE utf8_bin NOT NULL,
  `excipient` varchar(255) COLLATE utf8_bin NOT NULL,
  `conservation` varchar(255) COLLATE utf8_bin NOT NULL,
  `toxicity` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `toxicity` (`toxicity`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `medicalstock`
--

INSERT INTO `medicalstock` (`id`, `nom`, `classification`, `substance`, `excipient`, `conservation`, `toxicity`) VALUES
(2, 'DOLIPRANE 1000 mg cp', 'ANALGESIQUES,PARACETAMOL', 'Paracétamol', 'povidone, amidon prégélatinisé, sodium carboxyméthylamidon, talc, magnésium stéarate', 'Avant ouverture : durant 36 mois', 1);

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`id`, `name`, `firstName`, `birthDate`, `email`, `gender`, `address`, `city`, `postalCode`, `phoneNumber`, `homePhoneNumber`, `country`, `profession`, `civilStatus`, `socialSecurityNumber`, `mutualNumber`, `bloodGroup`, `pathology`, `note`, `familyDoctor`) VALUES
(1, 'Louis', 'Moulin', '2000-12-26', 'l.moulin@lprs.fr', 'H', '79 rue d\'alsace', 'Tremblay', 93290, 659737458, 123456789, 'France', 'Développeur web', 'Célibataire', 1234511111, 1234567, 'O+', 'Aucune', 'Note adressé du médecin', 'Jean Dubois');

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
  PRIMARY KEY (`id`),
  KEY `doctorId` (`doctorId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `planning`
--

INSERT INTO `planning` (`id`, `dateTimeStart`, `dateTimeEnd`, `doctorId`) VALUES
(1, '2019-12-25 12:00:00', '2019-12-25 13:00:00', 1);

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `idRole` int(10) NOT NULL AUTO_INCREMENT,
  `nomRole` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`idRole`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`idRole`, `nomRole`) VALUES
(1, 'administratif'),
(2, 'stock');

-- --------------------------------------------------------

--
-- Structure de la table `toxicity`
--

DROP TABLE IF EXISTS `toxicity`;
CREATE TABLE IF NOT EXISTS `toxicity` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `toxicity`
--

INSERT INTO `toxicity` (`id`, `libelle`) VALUES
(1, 'Aucune'),
(2, 'Légère'),
(3, 'Moyenne'),
(4, 'Dangereux'),
(5, 'Tres dangereux');

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
  PRIMARY KEY (`id`),
  KEY `idRole` (`idRole`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `login`, `email`, `password`, `name`, `firstName`, `idRole`) VALUES
(1, 's', 's@s', 's', 'Elodie', 'Surupi', 2),
(2, 'a', 'a@a', 'a', 'Jean', 'Dupilon', 1);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `medicalstock`
--
ALTER TABLE `medicalstock`
  ADD CONSTRAINT `fk_toxicity` FOREIGN KEY (`toxicity`) REFERENCES `toxicity` (`id`);

--
-- Contraintes pour la table `planning`
--
ALTER TABLE `planning`
  ADD CONSTRAINT `fk_doctor` FOREIGN KEY (`doctorId`) REFERENCES `doctor` (`id`);

--
-- Contraintes pour la table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_role` FOREIGN KEY (`idRole`) REFERENCES `role` (`idRole`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
