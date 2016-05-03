-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 04, 2016 at 12:29 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `kino`
--

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `event` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_comment_user` (`user`),
  KEY `FK_comment_event` (`event`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`id`, `content`, `time`, `event`, `user`) VALUES
(1, 'Bilo je ludo i nezaboravno.', '2016-04-19 21:19:39', 3, 6),
(2, 'Bilo je ludo i nezaboravno.', '2016-04-27 00:04:21', 4, 9),
(3, 'Bilo je ludo i nezaboravno.', '2016-04-27 00:04:48', 5, 10),
(4, 'Bilo je ludo i nezaboravno.', '2016-04-27 00:13:24', 6, 11);

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE IF NOT EXISTS `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `timeBegin` datetime DEFAULT NULL,
  `timeEnd` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`id`, `description`, `name`, `timeBegin`, `timeEnd`) VALUES
(1, 'wds', 'asdasd', '2016-03-02 00:00:00', '2016-03-04 00:00:00'),
(2, 'ghvg', 'jaksb', NULL, NULL),
(3, 'Loodilo, oduzimanje, mnozenje, dijeljene, rastavljanje na proste faktore.', 'Brucosijada', '2016-04-19 21:19:39', '2016-04-19 21:19:39'),
(4, 'Loodilo, oduzimanje, mnozenje, dijeljene, rastavljanje na proste faktore.', 'Brucosijada', '2016-04-27 00:04:21', '2016-04-27 00:04:21'),
(5, 'Loodilo, oduzimanje, mnozenje, dijeljene, rastavljanje na proste faktore.', 'Brucosijada', '2016-04-27 00:04:48', '2016-04-27 00:04:48'),
(6, 'Loodilo, oduzimanje, mnozenje, dijeljene, rastavljanje na proste faktore.', 'Brucosijada', '2016-04-27 00:13:24', '2016-04-27 00:13:24');

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE IF NOT EXISTS `movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=107 ;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`id`, `description`, `duration`, `name`) VALUES
(3, 'ksajbjab', 10, 'Ilvana'),
(4, NULL, NULL, 'Ilvana'),
(5, 'ksajbjab', 10, 'Ilvana'),
(6, 'Leonardo di Caprio. Enough said.', 120, 'Catch me if you can'),
(7, 'ksajbjab', 10, 'Ilvana'),
(8, 'Some description', 10, 'Test Movie'),
(9, 'Some description', 10, 'Test Movie'),
(10, 'Some description', 10, 'Test Movie'),
(11, 'Some description', 10, 'Test Movie'),
(12, 'Some description', 10, 'Test Movie'),
(13, 'Some description', 10, 'Test Movie'),
(14, 'Some description', 10, 'Test Movie'),
(15, 'Some description', 10, 'Test Movie'),
(16, 'Some description', 10, 'Test Movie'),
(17, 'Some description', 10, 'Test Movie'),
(18, 'Some description', 10, 'Test Movie'),
(19, 'Some description', 10, 'Test Movie'),
(20, 'Some description', 10, 'Test Movie'),
(21, 'Some description', 10, 'Test Movie'),
(22, 'Some description', 10, 'Test Movie'),
(23, 'Some description', 10, 'Test Movie'),
(24, 'Some description', 10, 'Test Movie'),
(25, 'Some description', 10, 'Test Movie'),
(26, 'Some description', 10, 'Test Movie'),
(27, 'Some description', 10, 'Test Movie'),
(28, 'Some description', 10, 'Test Movie'),
(29, 'Some description', 10, 'Test Movie'),
(30, 'Some description', 10, 'Test Movie'),
(31, 'Some description', 10, 'Test Movie'),
(32, 'Some description', 10, 'Test Movie'),
(33, 'Some description', 10, 'Test Movie'),
(34, 'Some description', 10, 'Test Movie'),
(35, 'Some description', 10, 'Test Movie'),
(36, 'Some description', 10, 'Test Movie'),
(37, 'Leonardo di Caprio. Enough said.', 120, 'Catch me if you can'),
(38, 'Leonardo di Caprio. Enough said.', 120, 'Catch me if you can'),
(39, 'Leonardo di Caprio. Enough said.', 120, 'Catch me if you can'),
(40, 'Some description', 10, 'Test Movie'),
(41, 'Some description', 10, 'Test Movie'),
(42, 'Some description', 10, 'Test Movie'),
(43, 'Some description', 10, 'Test Movie'),
(44, 'Some description', 10, 'Test Movie'),
(45, 'Some description', 10, 'Test Movie'),
(46, 'Some description', 10, 'Test Movie'),
(47, 'Some description', 10, 'Test Movie'),
(48, 'Some description', 10, 'Test Movie'),
(49, 'Some description', 10, 'Test Movie'),
(50, 'Some description', 10, 'Test Movie'),
(51, 'Some description', 10, 'Test Movie'),
(52, 'Some description', 10, 'Test Movie'),
(53, 'Some description', 10, 'Test Movie'),
(54, 'Some description', 10, 'Test Movie'),
(55, 'Some description', 10, 'Test Movie'),
(56, 'Some description', 10, 'Test Movie'),
(57, 'Some description', 10, 'Test Movie'),
(58, 'Some description', 10, 'Test Movie'),
(59, 'Some description', 10, 'Test Movie'),
(60, 'Some description', 10, 'Test Movie'),
(61, 'Some description', 10, 'Test Movie'),
(62, 'Some description', 10, 'Test Movie'),
(63, 'Some description', 10, 'Test Movie'),
(64, 'Some description', 10, 'Test Movie'),
(65, 'Some description', 10, 'Test Movie'),
(66, 'Some description', 10, 'Test Movie'),
(67, 'Some description', 10, 'Test Movie'),
(68, 'Some description', 10, 'Test Movie'),
(69, 'Some description', 10, 'Test Movie'),
(70, 'Some description', 10, 'Test Movie'),
(71, 'Some description', 10, 'Test Movie'),
(72, 'Some description', 10, 'Test Movie'),
(73, 'Some description', 10, 'Test Movie'),
(74, 'Some description', 10, 'Test Movie'),
(75, 'Some description', 10, 'Test Movie'),
(76, 'Some description', 10, 'Test Movie'),
(77, 'Some description', 10, 'Test Movie'),
(78, 'Some description', 10, 'Test Movie'),
(79, 'Some description', 10, 'Test Movie'),
(80, 'Some description', 10, 'Test Movie'),
(81, 'Some description', 10, 'Test Movie'),
(82, 'Some description', 10, 'Test Movie'),
(83, 'Some description', 10, 'Test Movie'),
(84, 'Some description', 10, 'Test Movie'),
(85, 'Some description', 10, 'Test Movie'),
(86, 'Some description', 10, 'Test Movie'),
(87, 'Some description', 10, 'Test Movie'),
(88, 'Some description', 10, 'Test Movie'),
(89, 'Some description', 10, 'Test Movie'),
(90, 'Some description', 10, 'Test Movie'),
(91, 'Some description', 10, 'Test Movie'),
(92, 'Some description', 10, 'Test Movie'),
(93, 'Some description', 10, 'Test Movie'),
(94, 'Some description', 10, 'Test Movie'),
(95, 'Some description', 10, 'Test Movie'),
(96, 'Some description', 10, 'Test Movie'),
(97, 'Some description', 10, 'Test Movie'),
(98, 'Some description', 10, 'Test Movie'),
(99, 'Some description', 10, 'Test Movie'),
(100, 'Some description', 10, 'Test Movie'),
(101, 'Some description', 10, 'Test Movie'),
(102, 'Some description', 10, 'Test Movie'),
(103, 'Some description', 10, 'Test Movie'),
(104, 'Some description', 10, 'Test Movie'),
(105, 'Some description', 10, 'Test Movie'),
(106, 'Some description', 10, 'Test Movie');

-- --------------------------------------------------------

--
-- Table structure for table `screening`
--

CREATE TABLE IF NOT EXISTS `screening` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timeBegin` datetime DEFAULT NULL,
  `timeEnd` datetime DEFAULT NULL,
  `movie` int(11) DEFAULT NULL,
  `theater` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_screening_theater` (`theater`),
  KEY `FK_screening_movie` (`movie`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `screening`
--

INSERT INTO `screening` (`id`, `timeBegin`, `timeEnd`, `movie`, `theater`) VALUES
(1, '2016-04-19 21:19:39', '2016-04-19 21:19:39', 6, 1),
(2, '2016-04-27 00:04:21', '2016-04-27 00:04:21', 37, 2),
(3, '2016-04-27 00:04:48', '2016-04-27 00:04:48', 38, 3),
(4, '2016-04-27 00:13:25', '2016-04-27 00:13:25', 39, 4);

-- --------------------------------------------------------

--
-- Table structure for table `theater`
--

CREATE TABLE IF NOT EXISTS `theater` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sizeX` int(11) DEFAULT NULL,
  `sizeY` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `theater`
--

INSERT INTO `theater` (`id`, `name`, `sizeX`, `sizeY`) VALUES
(1, 'Cinema city', NULL, NULL),
(2, 'Cinema city', NULL, NULL),
(3, 'Cinema city', NULL, NULL),
(4, 'Cinema city', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE IF NOT EXISTS `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seatX` int(11) DEFAULT NULL,
  `seatY` int(11) DEFAULT NULL,
  `screening` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ticket_user` (`user`),
  KEY `FK_ticket_screening` (`screening`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `ticket`
--

INSERT INTO `ticket` (`id`, `seatX`, `seatY`, `screening`, `user`) VALUES
(1, 2, 1, 1, 6),
(2, 2, 1, 2, 9),
(3, 2, 1, 3, 10),
(4, 2, 1, 4, 11);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `adminFlag` tinyint(1) DEFAULT '0',
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(60) NOT NULL,
  `enabled` tinyint(4) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `address`, `adminFlag`, `email`, `name`, `phone`, `username`, `password`, `enabled`, `role`) VALUES
(1, 'dsfsdfasd', 0, 'sdfs', 'ilvana', '54465', 'benjo', '$2a$08$QK6Yf9Y0ZpsYMb3RU296zOJMVji3ljvizvOvsu/UOZaus2PIegdJK', 1, 'ROLE_USER'),
(6, 'Zmaja od Bosne bb', 0, 'cizi@live.com', 'Narcis Behlilovic', '033-225-883', 'jhbjhsd', 'hjsdbdjs', 1, 'konj'),
(9, 'Zmaja od Bosne bb', 0, 'cizi@live.com', 'Narcis Behlilovic', '033-225-883', 'jhbjhsd', 'hjsdbdjs', 1, 'konj'),
(10, 'Zmaja od Bosne bb', 0, 'cizi@live.com', 'Narcis Behlilovic', '033-225-883', 'jhbjhsd', 'hjsdbdjs', 1, 'konj'),
(11, 'Zmaja od Bosne bb', 0, 'cizi@live.com', 'Narcis Behlilovic', '033-225-883', 'jhbjhsd', 'hjsdbdjs', 1, 'konj'),
(12, 'Ilica 24', 0, 'johny@gmail.com', 'Branimir Štuli?', '123456789', 'johnny', '$2a$10$aTKsVnGCqQM9H4rO8NSKXOXuLaSWvvJCB7FwvoHAkNBc.XpGyjN3m', 1, 'ROLE_USER'),
(13, 'Tesanjska 24', 0, 'mmujic1@etf.unsa.ba', 'Muhamed Mujic', '065322102', 'muhamed', '$2a$10$JbYxE0VQFabcuEFR5jtp6.V8W2xX1RT695D1.5sFqrV5kMur2Huoa', 0, 'ROLE_USER'),
(14, 'Tesanjska 24', 0, 'mmujic1@etf.unsa.ba', 'Muhamed Mujic', '062355108', 'mmujic', '$2a$10$VkdrjPVS.8BIiyxFM4QS4eXgtgN02jnOh8f1sxGGw/avPlCvjzJ3e', 1, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `verification_token`
--

CREATE TABLE IF NOT EXISTS `verification_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) NOT NULL,
  `token` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `verification_token`
--

INSERT INTO `verification_token` (`id`, `user`, `token`) VALUES
(1, 19, 'vp3nns4alff3slicg0nki6fsoi'),
(2, 20, '8lrrgpd4dmd4rkd91qrffthsdt'),
(3, 21, 'g6ju1fio1jlop3l0tgp2ndirn8'),
(4, 22, 'i7nqemkhcikcs02ue8027mssc'),
(5, 23, '2g25l9r1qhcjo74pmh4rntdf9c'),
(6, 24, '97fha0ms3sec0oa5c62acl48ac');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `FK_comment_event` FOREIGN KEY (`event`) REFERENCES `event` (`id`),
  ADD CONSTRAINT `FK_comment_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`);

--
-- Constraints for table `screening`
--
ALTER TABLE `screening`
  ADD CONSTRAINT `FK_screening_movie` FOREIGN KEY (`movie`) REFERENCES `movie` (`id`),
  ADD CONSTRAINT `FK_screening_theater` FOREIGN KEY (`theater`) REFERENCES `theater` (`id`);

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `FK_ticket_screening` FOREIGN KEY (`screening`) REFERENCES `screening` (`id`),
  ADD CONSTRAINT `FK_ticket_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
