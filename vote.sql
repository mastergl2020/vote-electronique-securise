-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 29 mai 2020 à 15:54
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
-- Base de données :  `vote`
--

-- --------------------------------------------------------

--
-- Structure de la table `candidat`
--

DROP TABLE IF EXISTS `candidat`;
CREATE TABLE IF NOT EXISTS `candidat` (
  `id_candidats` int(11) NOT NULL AUTO_INCREMENT,
  `nom_c` varchar(30) NOT NULL,
  `prenom_c` varchar(30) NOT NULL,
  `partie_c` varchar(30) NOT NULL,
  `nbr_votes` int(11) NOT NULL,
  `image_c` blob NOT NULL,
  PRIMARY KEY (`id_candidats`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


--
-- Structure de la table `co`
--

DROP TABLE IF EXISTS `co`;
CREATE TABLE IF NOT EXISTS `co` (
  `id_co` int(11) NOT NULL AUTO_INCREMENT,
  `nom_co` varchar(30) NOT NULL,
  `nbr` int(11) NOT NULL,
  PRIMARY KEY (`id_co`)
) ENGINE=MyISAM AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;

--
-- Structure de la table `datevote`
--

DROP TABLE IF EXISTS `datevote`;
CREATE TABLE IF NOT EXISTS `datevote` (
  `id_d` int(11) NOT NULL AUTO_INCREMENT,
  `debut` date NOT NULL,
  `fin` date NOT NULL,
  PRIMARY KEY (`id_d`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;



--
-- Structure de la table `de`
--

DROP TABLE IF EXISTS `de`;
CREATE TABLE IF NOT EXISTS `de` (
  `name_c` varchar(30) NOT NULL,
  `login_v` varchar(30) NOT NULL,
  `id_de` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_de`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;


--
-- Structure de la table `votant`
--

DROP TABLE IF EXISTS `votant`;
CREATE TABLE IF NOT EXISTS `votant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `login` varchar(30) NOT NULL,
  `pass` varchar(30) NOT NULL,
  `statue` varchar(30) NOT NULL,
  `image` blob NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
