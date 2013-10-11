-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 11. Okt 2013 um 11:36
-- Server Version: 5.6.11
-- PHP-Version: 5.5.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `fitness`
--
CREATE DATABASE IF NOT EXISTS `fitness` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `fitness`;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `friends`
--

CREATE TABLE IF NOT EXISTS `friends` (
  `friendship_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `friend_id` bigint(20) NOT NULL,
  PRIMARY KEY (`friendship_id`),
  KEY `user_id` (`user_id`),
  KEY `friend_id` (`friend_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=30 ;

--
-- Daten für Tabelle `friends`
--

INSERT INTO `friends` (`friendship_id`, `user_id`, `friend_id`) VALUES
(1, 1, 2),
(2, 1, 3),
(3, 1, 8),
(16, 11, 2),
(17, 2, 11),
(18, 11, 3),
(19, 3, 11),
(20, 3, 7),
(21, 7, 3),
(22, 3, 2),
(23, 2, 3);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `yearbirth` int(11) NOT NULL,
  `sex` tinyint(1) NOT NULL,
  `height` double NOT NULL,
  `run` int(11) DEFAULT NULL,
  `bike` int(11) DEFAULT NULL,
  `swim` int(11) DEFAULT NULL,
  `pump` int(11) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `fitnesslevel` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Daten für Tabelle `user`
--

INSERT INTO `user` (`user_id`, `username`, `password`, `firstname`, `lastname`, `email`, `yearbirth`, `sex`, `height`, `run`, `bike`, `swim`, `pump`, `status`, `fitnesslevel`) VALUES
(1, 'archi', 'test', 'Stephanie', 'Gerlich', 'stg@gmail.com', 1979, 0, 1.72, 1, 1, 0, 1, '', 3),
(2, 'buzzy', 'test', 'Michael', 'Schoene', 'buzzin@gmx.de', 1964, 1, 1.82, 1, 0, 0, 1, 'bored', 3),
(3, 'tester', 'test', 'Paul', 'Müller', 'pm@muster.de', 1982, 1, 1.75, 1, 1, 1, NULL, 'nicht so toll', 3),
(7, 'maja', 'test', 'Biene', 'Maja', 'biene@maje.de', 1985, 0, 1.65, NULL, NULL, NULL, NULL, NULL, NULL),
(8, 'tops', 'test', 'Mia', 'Meier-Müller', 'mmm@w.de', 1982, 0, 1.63, NULL, NULL, NULL, NULL, NULL, NULL),
(9, 'karo', 'karo', 'Caroline', 'Bruns', 'cab@cb.org', 1972, 0, 1.78, 1, 0, 0, 0, 'hochmotiviert', 2),
(10, 'stg', 'test', 'Peter', 'Lenz', 'pl@fr.de', 1975, 1, 1.81, 1, 1, 1, 1, NULL, 4),
(11, 'maxi', 'test', 'Maxi', 'Tester', 'maxt@test.de', 1980, 1, 1.76, 0, 1, 0, 1, 'beinahe gut', 3);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `weekplaner`
--

CREATE TABLE IF NOT EXISTS `weekplaner` (
  `plan_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `monday` bigint(20) DEFAULT NULL,
  `tuesday` bigint(20) DEFAULT NULL,
  `wednesday` bigint(20) DEFAULT NULL,
  `thursday` bigint(20) DEFAULT NULL,
  `friday` bigint(20) DEFAULT NULL,
  `saturday` bigint(20) DEFAULT NULL,
  `sunday` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`plan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `weights`
--

CREATE TABLE IF NOT EXISTS `weights` (
  `weights_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `weight` double NOT NULL,
  `date` date NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`weights_id`),
  KEY `weights_id` (`weights_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

--
-- Daten für Tabelle `weights`
--

INSERT INTO `weights` (`weights_id`, `weight`, `date`, `user_id`) VALUES
(1, 109.8, '1970-01-02', 3),
(2, 99.2, '1970-01-16', 3),
(3, 98.8, '1970-01-16', 3),
(4, 92.1, '1970-01-16', 3),
(8, 83.2, '2013-07-25', 11),
(9, 83.2, '2013-08-08', 11),
(10, 81.2, '2013-10-08', 11),
(11, 81.4, '2013-10-09', 11),
(12, 92.4, '2013-08-02', 9),
(13, 89.9, '2013-08-14', 9),
(14, 87.5, '2013-08-30', 9),
(15, 86.5, '2013-09-03', 9),
(16, 86.8, '2013-09-12', 9),
(17, 83.4, '2013-09-18', 9),
(18, 81.2, '2013-10-01', 9);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `workouts`
--

CREATE TABLE IF NOT EXISTS `workouts` (
  `w_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `sport` varchar(20) NOT NULL,
  `fierce` int(11) NOT NULL,
  `time` int(11) NOT NULL,
  PRIMARY KEY (`w_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Daten für Tabelle `workouts`
--

INSERT INTO `workouts` (`w_id`, `name`, `sport`, `fierce`, `time`) VALUES
(1, 'Langsamer Lauf 30 min', 'run', 2, 30),
(2, 'Zügiger Lauf 30 min', 'run', 4, 30),
(3, 'BodyPump', 'pump', 7, 50),
(4, '20 Bahnen Schwimmen', 'swim', 3, 20),
(5, 'Kleine Radtour 20km', 'bike', 4, 60),
(6, 'Langer Lauf 2 Std', 'run', 5, 120),
(7, 'Geräte-Training', 'pump', 6, 60),
(8, 'Schwimmen Intervalle', 'swim', 6, 45);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
