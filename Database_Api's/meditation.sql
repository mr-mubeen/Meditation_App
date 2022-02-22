-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 21, 2022 at 03:14 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `meditation`
--

-- --------------------------------------------------------

--
-- Table structure for table `point`
--

CREATE TABLE `point` (
  `p_id` int(11) NOT NULL,
  `anxiety_points` varchar(200) NOT NULL DEFAULT '0',
  `depression_points` varchar(50) NOT NULL DEFAULT '0',
  `pstd_points` varchar(50) NOT NULL DEFAULT '0',
  `bipolar_points` varchar(50) NOT NULL DEFAULT '0',
  `psychosis_points` varchar(50) NOT NULL DEFAULT '0',
  `addiction_points` varchar(50) NOT NULL DEFAULT '0',
  `r_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `point`
--

INSERT INTO `point` (`p_id`, `anxiety_points`, `depression_points`, `pstd_points`, `bipolar_points`, `psychosis_points`, `addiction_points`, `r_id`) VALUES
(1, '10', '0', '0', '0', '0', '0', 6),
(2, '9', '0', '0', '0', '0', '0', 10);

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `r_id` int(11) NOT NULL,
  `uname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `image` varchar(2000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`r_id`, `uname`, `email`, `password`, `phone`, `image`) VALUES
(1, 'test', 'abc@gmail.com', '03152baD@', '03152813132', ''),
(6, 'test', 'abcd@gmail.com', '03152basdD@', '03152813199', ''),
(7, 'test', 'abce@gmail.com', '03152basdD@', '03152813132', ''),
(9, 'test', 'ac@gmail.com', '03152Aasda@', '03152813132', 'IMG640951527.jpeg'),
(10, 'test', 'ab@gmail.com', '03152baSa@', '03152813132', 'IMG1797466089.jpeg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `point`
--
ALTER TABLE `point`
  ADD PRIMARY KEY (`p_id`),
  ADD KEY `r_id` (`r_id`);

--
-- Indexes for table `register`
--
ALTER TABLE `register`
  ADD PRIMARY KEY (`r_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `point`
--
ALTER TABLE `point`
  MODIFY `p_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `register`
--
ALTER TABLE `register`
  MODIFY `r_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `point`
--
ALTER TABLE `point`
  ADD CONSTRAINT `point_ibfk_1` FOREIGN KEY (`r_id`) REFERENCES `register` (`r_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
