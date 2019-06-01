-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  sam. 01 juin 2019 à 13:36
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `connection`
--

-- --------------------------------------------------------

--
-- Structure de la table `anneescolaire`
--

DROP TABLE IF EXISTS `anneescolaire`;
CREATE TABLE IF NOT EXISTS `anneescolaire` (
  `id_as` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_t1` int(11) UNSIGNED NOT NULL,
  `id_t2` int(11) UNSIGNED NOT NULL,
  `id_t3` int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id_as`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `anneescolaire`
--

INSERT INTO `anneescolaire` (`id_as`, `id_t1`, `id_t2`, `id_t3`) VALUES
(1, 1, 2, 3),
(2, 4, 5, 6);

-- --------------------------------------------------------

--
-- Structure de la table `bulletin`
--

DROP TABLE IF EXISTS `bulletin`;
CREATE TABLE IF NOT EXISTS `bulletin` (
  `id` int(10) UNSIGNED NOT NULL,
  `id_trim` int(10) UNSIGNED NOT NULL,
  `id_inscr` int(10) UNSIGNED NOT NULL,
  `app_g` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `bulletin`
--

INSERT INTO `bulletin` (`id`, `id_trim`, `id_inscr`, `app_g`) VALUES
(1, 1, 1, 'Ensemble bon'),
(2, 1, 2, 'bon');

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `id_classe` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nom_classe` varchar(255) NOT NULL,
  `id_ecole` int(11) UNSIGNED NOT NULL,
  `id_niveau` int(11) UNSIGNED NOT NULL,
  `id_annee` int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id_classe`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`id_classe`, `nom_classe`, `id_ecole`, `id_niveau`, `id_annee`) VALUES
(1, '1', 1, 1, 1),
(2, '2', 1, 1, 1),
(3, '1', 1, 1, 2),
(4, '2', 1, 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `detailbulletin`
--

DROP TABLE IF EXISTS `detailbulletin`;
CREATE TABLE IF NOT EXISTS `detailbulletin` (
  `id_detailBulletin` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `appreciation_b` varchar(255) NOT NULL,
  `id_bulletin` int(11) UNSIGNED NOT NULL,
  `id_enseignement` int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id_detailBulletin`),
  KEY `trimestre` (`id_enseignement`),
  KEY `id_trim` (`id_bulletin`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `detailbulletin`
--

INSERT INTO `detailbulletin` (`id_detailBulletin`, `appreciation_b`, `id_bulletin`, `id_enseignement`) VALUES
(1, 'pas mauvais', 1, 1),
(2, 'peu mieux faire', 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `discipline`
--

DROP TABLE IF EXISTS `discipline`;
CREATE TABLE IF NOT EXISTS `discipline` (
  `id_discipline` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nom_discipline` varchar(255) NOT NULL,
  PRIMARY KEY (`id_discipline`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `discipline`
--

INSERT INTO `discipline` (`id_discipline`, `nom_discipline`) VALUES
(1, 'Mathématiques'),
(2, 'Français');

-- --------------------------------------------------------

--
-- Structure de la table `ecole`
--

DROP TABLE IF EXISTS `ecole`;
CREATE TABLE IF NOT EXISTS `ecole` (
  `id_ecole` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nom_ecole` varchar(255) NOT NULL,
  PRIMARY KEY (`id_ecole`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ecole`
--

INSERT INTO `ecole` (`id_ecole`, `nom_ecole`) VALUES
(1, 'ecole des bois');

-- --------------------------------------------------------

--
-- Structure de la table `enseignement`
--

DROP TABLE IF EXISTS `enseignement`;
CREATE TABLE IF NOT EXISTS `enseignement` (
  `id_enseignement` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_classe` int(11) UNSIGNED NOT NULL,
  `id_discipline` int(11) UNSIGNED NOT NULL,
  `id_p` int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id_enseignement`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `evaluation`
--

DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE IF NOT EXISTS `evaluation` (
  `id_evaluation` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `note` double UNSIGNED NOT NULL,
  `appreciation_e` varchar(255) NOT NULL,
  `id_db` int(11) UNSIGNED NOT NULL,
  `id_p` int(11) UNSIGNED NOT NULL,
  `id_discipline` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id_evaluation`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `evaluation`
--

INSERT INTO `evaluation` (`id_evaluation`, `note`, `appreciation_e`, `id_db`, `id_p`, `id_discipline`) VALUES
(1, 18.5, 'Pas mauvais', 1, 1, 1),
(2, 5, 'vraiment nul', 2, 1, 2),
(3, 15, 'test3', 2, 1, 2),
(4, 14, 'test4', 2, 1, 2),
(5, 12, 'test5', 1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

DROP TABLE IF EXISTS `inscription`;
CREATE TABLE IF NOT EXISTS `inscription` (
  `id_inscription` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_classe` int(11) UNSIGNED NOT NULL,
  `id_p` int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id_inscription`),
  UNIQUE KEY `id_p` (`id_p`),
  KEY `id_classe` (`id_classe`,`id_p`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `inscription`
--

INSERT INTO `inscription` (`id_inscription`, `id_classe`, `id_p`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 3);

-- --------------------------------------------------------

--
-- Structure de la table `niveau`
--

DROP TABLE IF EXISTS `niveau`;
CREATE TABLE IF NOT EXISTS `niveau` (
  `id_niveau` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nom_niveau` varchar(255) NOT NULL,
  PRIMARY KEY (`id_niveau`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `niveau`
--

INSERT INTO `niveau` (`id_niveau`, `nom_niveau`) VALUES
(1, 'CP'),
(2, 'CE1'),
(3, 'CE2'),
(4, 'CM1'),
(5, 'CM2');

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `id_personne` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nom_p` varchar(255) NOT NULL,
  `prenom_p` varchar(255) NOT NULL,
  `type` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_personne`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`id_personne`, `nom_p`, `prenom_p`, `type`) VALUES
(1, 'eleve1_n', 'eleve1_p', 1),
(2, 'eleve2_n', 'eleve2_p', 1),
(3, 'eleve3_n', 'eleve3_p', 1),
(4, 'professeur1_n', 'professeur1_p', 0);

-- --------------------------------------------------------

--
-- Structure de la table `trimestre`
--

DROP TABLE IF EXISTS `trimestre`;
CREATE TABLE IF NOT EXISTS `trimestre` (
  `id_trimestre` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `numero` int(11) UNSIGNED NOT NULL,
  `debut` date NOT NULL,
  `fin` date NOT NULL,
  `id_annee` int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id_trimestre`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `trimestre`
--

INSERT INTO `trimestre` (`id_trimestre`, `numero`, `debut`, `fin`, `id_annee`) VALUES
(4, 1, '2019-09-01', '2019-12-01', 2),
(5, 2, '2019-12-02', '2020-03-01', 2),
(6, 3, '2020-03-02', '2020-06-01', 2),
(1, 1, '2018-09-01', '2018-12-01', 1),
(2, 2, '2018-12-02', '2019-03-01', 1),
(3, 3, '2019-03-02', '2019-06-01', 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
