-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 12, 2023 at 10:06 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `login`
--

-- --------------------------------------------------------

--
-- Table structure for table `info`
--

CREATE TABLE `info` (
  `rollno` varchar(6) NOT NULL,
  `name` varchar(40) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `year` varchar(1) NOT NULL,
  `dpt` varchar(20) DEFAULT NULL,
  `phone` varchar(10) NOT NULL,
  `color` varchar(20) NOT NULL,
  `address` varchar(60) NOT NULL,
  `mname` varchar(15) NOT NULL,
  `model` varchar(8) NOT NULL,
  `price` varchar(8) NOT NULL,
  `imei` varchar(15) NOT NULL,
  `status` varchar(50) DEFAULT 'absent',
  `reason` varchar(50) DEFAULT NULL,
  `explain1` varchar(500) DEFAULT NULL,
  `request1` varchar(20) DEFAULT NULL,
  `date1` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `info`
--

INSERT INTO `info` (`rollno`, `name`, `mail`, `year`, `dpt`, `phone`, `color`, `address`, `mname`, `model`, `price`, `imei`, `status`, `reason`, `explain1`, `request1`, `date1`) VALUES
('B2000', 'PDHStudentsMobile', 'jkashdk@gmail.com', '1', 'cs', '2147483647', 'Black', 'kjdsfk', 'Vivo', 'ulahd', '21474836', '876348763487236', 'verified', NULL, NULL, NULL, NULL),
('B20201', 'abc', 'davidalex2@gmail.com', '3', 'ms', '2147483647', 'Black', 'savariyarpalaiyam', 'Vivo', 'y30', '97834893', '079847328467341', 'verified', 'To prepare for gov exams', 'fdfdsgdsg', 'approved', '2023-05-10 07:55:48'),
('B20202', 'uhf', 'alex@gmail.com', '1', 'ma', '2147483647', 'Black', 'savariyarpalaiyam', 'Vivo', 'y30', '45634', '834782376587346', 'submitted', 'To study', 'oijwehrowe', 'requested', '2023-05-10 07:00:47'),
('b20211', 'stu1', 'ab1@gmail.com', '2', 'en', '1231424256', 'blue', 'asdsdf', 'moto', 'e32', '234345', '324562341676657', 'absent', NULL, NULL, NULL, NULL),
('B20222', '545', 'klewjwe@gmail.com', '1', 'msc', '2147483647', 'Black', 'hjjsgdysd', 'Vivo', 'jd', '21474836', '873642983469873', 'verified', '', '', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `uname` varchar(6) DEFAULT NULL,
  `pwd` text DEFAULT NULL,
  `status` text NOT NULL DEFAULT 'student',
  `year` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`uname`, `pwd`, `status`, `year`) VALUES
('B20222', 'B20222', 'student', 0),
('admin', 'admin', 'admin', 0),
('B20201', 'B20201', 'student', 0),
('B20202', 'B20202', 'student', 0),
('B2000', 'B2000', 'student', 0),
('dbcy1', 'dbcy1', '1incharge', 0),
('P21102', 'amal', 'admin', 0),
('abcd', 'abcd', 'student', 3),
('b20211', 'b20211', 'student', 2),
('b20212', 'b20212', 'student', 3),
('b20213', 'b20213', 'student', 3),
('b20214', 'b20214', 'student', 3),
('b21212', 'b21212', 'student', 0),
('abc', 'abc', 'admin', 0),
('b2021', 'b2021', 'admin', 0),
('b202', 'b202', 'student', 3),
('123d', '123d', 'admin', 0),
('jkasd', 'kjsdjsfd', 'admin', 0),
('b20221', '', 'admin', 0),
('b12345', 'b12345', 'student', 3);

-- --------------------------------------------------------

--
-- Table structure for table `post1`
--

CREATE TABLE `post1` (
  `uname` varchar(20) DEFAULT NULL,
  `post1` varchar(1000) DEFAULT NULL,
  `date1` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `post1`
--

INSERT INTO `post1` (`uname`, `post1`, `date1`) VALUES
('admin', 'iuuhsdwehoiuwdd', '2023-05-12');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `info`
--
ALTER TABLE `info`
  ADD PRIMARY KEY (`rollno`),
  ADD UNIQUE KEY `mail` (`mail`),
  ADD UNIQUE KEY `imei` (`imei`),
  ADD UNIQUE KEY `imei_2` (`imei`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD UNIQUE KEY `no` (`uname`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `info`
--
ALTER TABLE `info`
  ADD CONSTRAINT `info_ibfk_1` FOREIGN KEY (`rollno`) REFERENCES `login` (`uname`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
