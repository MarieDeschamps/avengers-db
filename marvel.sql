-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Lun 27 Février 2017 à 13:05
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `marvel`
--

-- --------------------------------------------------------

--
-- Structure de la table `heroes`
--

CREATE TABLE `heroes` (
  `id` int(16) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `sex` varchar(1) NOT NULL,
  `likes` int(32) NOT NULL DEFAULT '0',
  `dislikes` int(32) NOT NULL DEFAULT '0',
  `picture` longblob,
  `abilities` varchar(255) DEFAULT NULL,
  `history` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `heroes`
--

INSERT INTO `heroes` (`id`, `name`, `sex`, `likes`, `dislikes`, `picture`, `abilities`, `history`) VALUES
(1, 'Spiderman', 'M', 30000, 28000, NULL, NULL, NULL),
(2, 'Iron man', 'M', 50000000, 51000000, NULL, NULL, NULL),
(3, 'Hulk', 'M', 100000, 80000, NULL, NULL, NULL),
(4, 'Captain America', 'M', 16000000, 18000000, NULL, NULL, NULL),
(5, 'Thor', 'M', 30, 100, NULL, NULL, NULL),
(6, 'Ant man', 'M', 1300, 500, NULL, NULL, NULL),
(7, 'Deadpool', 'M', 66666666, 500, NULL, NULL, NULL),
(8, 'Wolverine', 'M', 9632, 851, NULL, NULL, NULL),
(9, 'Black cat', 'F', 10, 10, NULL, NULL, NULL),
(11, 'Loki', 'M', 9630, 9631, NULL, NULL, NULL),
(12, 'Black Widow', 'F', 150000001, 600, NULL, NULL, NULL),
(13, 'Captain Marvel', 'F', 3, 1, NULL, NULL, NULL),
(14, 'Elektra', 'F', 90, 54, NULL, NULL, NULL),
(15, 'Mystic', 'F', 561233, 654, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `irl`
--

CREATE TABLE `irl` (
  `hero_id` int(16) NOT NULL,
  `name` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `irl`
--

INSERT INTO `irl` (`hero_id`, `name`) VALUES
(1, 'Peter Parker'),
(3, 'Bruce Banner'),
(4, 'Steve Rogers'),
(6, 'Scott Lang'),
(7, 'Wade Wilson'),
(8, 'Logan');

-- --------------------------------------------------------

--
-- Structure de la table `movie`
--

CREATE TABLE `movie` (
  `id` int(8) NOT NULL,
  `name` varchar(64) NOT NULL,
  `gross` int(32) NOT NULL,
  `budget` int(32) NOT NULL,
  `picture` longblob,
  `history` text,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `movie`
--

INSERT INTO `movie` (`id`, `name`, `gross`, `budget`, `picture`, `history`, `date`) VALUES
(1, 'Deadpool', 783, 58, NULL, NULL, '0000-00-00'),
(2, 'Civil war', 1153, 250, NULL, NULL, '0000-00-00'),
(3, 'Iron man', 585, 140, NULL, NULL, '0000-00-00'),
(4, 'Xmen', 296, 75, NULL, NULL, '0000-00-00'),
(5, 'Spiderman', 822, 140, NULL, NULL, '0000-00-00'),
(6, 'Thor', 645, 170, NULL, NULL, '0000-00-00'),
(7, 'Wolverine', 415, 120, NULL, NULL, '0000-00-00');

-- --------------------------------------------------------

--
-- Structure de la table `movie_hero`
--

CREATE TABLE `movie_hero` (
  `id_movie` int(8) NOT NULL,
  `id_hero` int(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `movie_hero`
--

INSERT INTO `movie_hero` (`id_movie`, `id_hero`) VALUES
(1, 7),
(2, 2),
(2, 12),
(2, 4),
(2, 3),
(2, 5),
(3, 2),
(4, 15),
(4, 8),
(6, 5),
(7, 8),
(5, 1);

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `pop`
-- (Voir ci-dessous la vue réelle)
--
CREATE TABLE `pop` (
`name` varchar(16)
,`ratio` decimal(39,8)
);

-- --------------------------------------------------------

--
-- Structure de la table `team`
--

CREATE TABLE `team` (
  `team_id` int(1) NOT NULL,
  `name` varchar(16) NOT NULL,
  `picture` longblob,
  `history` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `team`
--

INSERT INTO `team` (`team_id`, `name`, `picture`, `history`) VALUES
(1, 'Avengers', NULL, NULL),
(2, 'Xmen', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `team_hero`
--

CREATE TABLE `team_hero` (
  `team_id` int(11) NOT NULL,
  `hero_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `team_hero`
--

INSERT INTO `team_hero` (`team_id`, `hero_id`) VALUES
(1, 3),
(1, 4),
(1, 5),
(1, 12),
(1, 13),
(1, 2),
(2, 8),
(2, 15);

-- --------------------------------------------------------

--
-- Structure de la vue `pop`
--
DROP TABLE IF EXISTS `pop`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `pop`  AS  select `t`.`name` AS `name`,avg((`h`.`likes` / (`h`.`likes` + `h`.`dislikes`))) AS `ratio` from ((`heroes` `h` join `team_hero` `th` on((`h`.`id` = `th`.`hero_id`))) join `team` `t` on((`th`.`team_id` = `t`.`team_id`))) where 1 group by `t`.`name` ;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `heroes`
--
ALTER TABLE `heroes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Index pour la table `irl`
--
ALTER TABLE `irl`
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `hero_id` (`hero_id`);

--
-- Index pour la table `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`),
  ADD KEY `name` (`name`);

--
-- Index pour la table `movie_hero`
--
ALTER TABLE `movie_hero`
  ADD KEY `id_movie` (`id_movie`),
  ADD KEY `id_hero` (`id_hero`);

--
-- Index pour la table `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`team_id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Index pour la table `team_hero`
--
ALTER TABLE `team_hero`
  ADD KEY `team_id` (`team_id`),
  ADD KEY `hero_id` (`hero_id`),
  ADD KEY `team_id_2` (`team_id`),
  ADD KEY `hero_id_2` (`hero_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `heroes`
--
ALTER TABLE `heroes`
  MODIFY `id` int(16) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT pour la table `movie`
--
ALTER TABLE `movie`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `team`
--
ALTER TABLE `team`
  MODIFY `team_id` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `irl`
--
ALTER TABLE `irl`
  ADD CONSTRAINT `irl_ibfk_1` FOREIGN KEY (`hero_id`) REFERENCES `heroes` (`id`);

--
-- Contraintes pour la table `movie_hero`
--
ALTER TABLE `movie_hero`
  ADD CONSTRAINT `movie_hero_ibfk_1` FOREIGN KEY (`id_movie`) REFERENCES `movie` (`id`),
  ADD CONSTRAINT `movie_hero_ibfk_2` FOREIGN KEY (`id_hero`) REFERENCES `heroes` (`id`);

--
-- Contraintes pour la table `team_hero`
--
ALTER TABLE `team_hero`
  ADD CONSTRAINT `team_hero_ibfk_1` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`),
  ADD CONSTRAINT `team_hero_ibfk_2` FOREIGN KEY (`hero_id`) REFERENCES `heroes` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
