-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Host: localhost:8889
-- Generation Time: Mar 05, 2016 at 07:32 PM
-- Server version: 5.5.42
-- PHP Version: 7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

DROP TABLE library.check_out;
DROP TABLE library.books;
DROP TABLE library.person;


DROP TABLE IF EXISTS library.books;
CREATE TABLE `books` (
  `book_id` int(11) NOT NULL,
  `book_title` varchar(50) NOT NULL,
  `book_author` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`book_id`, `book_title`, `book_author`) VALUES
(1, 'ULYSSES', 'James Joyce'),
(2, 'THE GREAT GATSBY', 'F. Scott Fitzgerald'),
(3, 'A PORTRAIT OF THE ARTIST AS A YOUNG MAN', 'James Joyce'),
(4, 'LOLITA', 'Vladimir Nabokov'),
(5, 'BRAVE NEW WORLD', 'Aldous Huxley'),
(6, 'THE SOUND AND THE FURY', 'William Faulkner'),
(7, 'CATCH-22', 'Joseph Heller'),
(8, 'DARKNESS AT NOON', 'Arthur Koestler'),
(9, 'SONS AND LOVERS', 'D.H. Lawrence'),
(10, 'THE GRAPES OF WRATH', 'John Steinbeck'),
(11, 'UNDER THE VOLCANO', 'Malcolm Lowry'),
(12, 'THE WAY OF ALL FLESH', 'Samuel Butler'),
(13, '1984', 'George Orwell'),
(14, 'AN AMERICAN TRAGEDY', 'Theodore Dreiser'),
(15, 'TO THE LIGHTHOUSE', 'Virginia Woolf');

-- --------------------------------------------------------

--
-- Table structure for table `check_out`
--
DROP TABLE IF EXISTS library.check_out;
CREATE TABLE `check_out` (
  `person_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `person`
--
DROP TABLE IF EXISTS library.person;
CREATE TABLE `person` (
  `person_id` int(11) NOT NULL,
  `person_first_name` varchar(30) NOT NULL,
  `person_last_name` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`person_id`, `person_first_name`, `person_last_name`) VALUES
(1, 'Erle', 'Johns'),
(2, 'Daly', 'Triggs'),
(3, 'Nicola', 'Adair'),
(4, 'Cherokee', 'Courtney'),
(5, 'Nick', 'Pierce'),
(6, 'Grady', 'Fear'),
(7, 'Jacqueline', 'Rye'),
(8, 'Jonny', 'Greene'),
(9, 'Cooper', 'Cokes'),
(10, 'Rastus', 'Ashworth'),
(11, 'Iona', 'Church'),
(12, 'Libbie', 'Dean'),
(13, 'Noah', 'Danniel'),
(14, 'Jolene', 'Crawford'),
(15, 'Ivonette', 'Abrahamson');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`book_id`);

--
-- Indexes for table `check_out`
--
ALTER TABLE `check_out`
  ADD KEY `person_id` (`person_id`),
  ADD KEY `book_id` (`book_id`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`person_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `person_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `check_out`
--
ALTER TABLE `check_out`
  ADD CONSTRAINT `person_if_fk` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`),
  ADD CONSTRAINT `book_id_fk` FOREIGN KEY (`book_id`) REFERENCES `books` (`book_id`) ON DELETE CASCADE ON UPDATE CASCADE;
