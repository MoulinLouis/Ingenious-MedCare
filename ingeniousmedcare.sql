-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mer. 15 jan. 2020 à 16:25
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP :  7.4.1

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

CREATE TABLE `doctor` (
  `id` int(10) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `firstName` varchar(255) COLLATE utf8_bin NOT NULL,
  `specialization` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `doctor`
--

INSERT INTO `doctor` (`id`, `name`, `firstName`, `specialization`) VALUES
(1, 'Eric', 'Benenou', 'Generaliste');

-- --------------------------------------------------------

--
-- Structure de la table `medicalproduct`
--

CREATE TABLE `medicalproduct` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) COLLATE utf8_bin NOT NULL,
  `classification` varchar(255) COLLATE utf8_bin NOT NULL,
  `substance` varchar(255) COLLATE utf8_bin NOT NULL,
  `excipient` varchar(255) COLLATE utf8_bin NOT NULL,
  `conservation` varchar(255) COLLATE utf8_bin NOT NULL,
  `toxicity` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `medicalproduct`
--

INSERT INTO `medicalproduct` (`id`, `nom`, `classification`, `substance`, `excipient`, `conservation`, `toxicity`) VALUES
(2, 'DOLIPRANE 1000 mg cp', 'ANALGESIQUES,PARACETAMOL', 'Paracétamol', 'povidone, amidon prégélatinisé, sodium carboxyméthylamidon, talc, magnésium stéarate', 'Avant ouverture : durant 36 mois', 1);

-- --------------------------------------------------------

--
-- Structure de la table `medicalstock`
--

CREATE TABLE `medicalstock` (
  `id` int(11) NOT NULL,
  `id_medicalProduct` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `orders`
--

CREATE TABLE `orders` (
  `id` int(10) NOT NULL,
  `id_medicalProduct` int(10) NOT NULL,
  `quantity` int(10) NOT NULL,
  `commandDate` date NOT NULL,
  `status` int(10) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

CREATE TABLE `patient` (
  `id` int(10) NOT NULL,
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
  `familyDoctor` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`id`, `name`, `firstName`, `birthDate`, `email`, `gender`, `address`, `city`, `postalCode`, `phoneNumber`, `homePhoneNumber`, `country`, `profession`, `civilStatus`, `socialSecurityNumber`, `mutualNumber`, `bloodGroup`, `pathology`, `note`, `familyDoctor`) VALUES
(1, 'Louis', 'Moulin', '2000-12-26', 'l.moulin@lprs.fr', 'H', '79 rue d\'alsace', 'Tremblay', 93290, 659737458, 123456789, 'France', 'Développeur web', 'Célibataire', 1234511111, 1234567, 'O+', 'Aucune', 'Note adressé du médecin', 'Jean Dubois');

-- --------------------------------------------------------

--
-- Structure de la table `planning`
--

CREATE TABLE `planning` (
  `id` int(10) NOT NULL,
  `dateTimeStart` datetime NOT NULL,
  `dateTimeEnd` datetime NOT NULL,
  `doctorId` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `planning`
--

INSERT INTO `planning` (`id`, `dateTimeStart`, `dateTimeEnd`, `doctorId`) VALUES
(1, '2019-12-25 12:00:00', '2019-12-25 13:00:00', 1);

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE `role` (
  `idRole` int(10) NOT NULL,
  `nomRole` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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

CREATE TABLE `toxicity` (
  `id` int(10) NOT NULL,
  `libelle` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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

CREATE TABLE `user` (
  `id` int(10) NOT NULL,
  `login` varchar(255) COLLATE utf8_bin NOT NULL,
  `email` varchar(255) COLLATE utf8_bin NOT NULL,
  `password` varchar(255) COLLATE utf8_bin NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `firstName` varchar(255) COLLATE utf8_bin NOT NULL,
  `idRole` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `login`, `email`, `password`, `name`, `firstName`, `idRole`) VALUES
(1, 's', 's@s', 's', 'Elodie', 'Surupi', 2),
(2, 'a', 'a@a', 'a', 'Jean', 'Dupilon', 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `medicalproduct`
--
ALTER TABLE `medicalproduct`
  ADD PRIMARY KEY (`id`),
  ADD KEY `toxicity` (`toxicity`);

--
-- Index pour la table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `planning`
--
ALTER TABLE `planning`
  ADD PRIMARY KEY (`id`),
  ADD KEY `doctorId` (`doctorId`);

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`idRole`);

--
-- Index pour la table `toxicity`
--
ALTER TABLE `toxicity`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idRole` (`idRole`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `medicalproduct`
--
ALTER TABLE `medicalproduct`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `patient`
--
ALTER TABLE `patient`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `planning`
--
ALTER TABLE `planning`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `role`
--
ALTER TABLE `role`
  MODIFY `idRole` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `toxicity`
--
ALTER TABLE `toxicity`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `medicalproduct`
--
ALTER TABLE `medicalproduct`
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
