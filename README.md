<h1>Database</h1>

-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 16, 2020 at 03:00 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qlbh`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `BID` int(11) NOT NULL,
  `USERNAME` varchar(24) NOT NULL,
  `DATE` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `billdetails`
--

CREATE TABLE `billdetails` (
  `BID` int(11) NOT NULL,
  `PID` int(11) NOT NULL,
  `QUANTITY` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `PID` int(11) NOT NULL,
  `NAME` varchar(30) NOT NULL,
  `TYPE` varchar(30) DEFAULT NULL,
  `PRICE` float DEFAULT NULL,
  `QUANTITY` int(11) DEFAULT NULL,
  `IMAGE` varchar(100) DEFAULT NULL,
  `DESCRIPTION` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`PID`, `NAME`, `TYPE`, `PRICE`, `QUANTITY`, `IMAGE`, `DESCRIPTION`) VALUES
(1, 'LALA BC4', 'SUNGLASSES', 280, 15, NULL, NULL),
(2, 'KARMA 032', 'SUNGLASSES', 320, 20, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `USERNAME` varchar(24) NOT NULL,
  `PASSWORD` varchar(24) NOT NULL,
  `ROLE` char(1) NOT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  `GENDER` char(1) DEFAULT NULL,
  `PHONE` varchar(15) DEFAULT NULL,
  `ADDRESS` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`USERNAME`, `PASSWORD`, `ROLE`, `NAME`, `GENDER`, `PHONE`, `ADDRESS`) VALUES
('admin', 'admin', 'A', NULL, NULL, NULL, NULL),
('client', 'client', 'C', 'Nguyễn Phi Long', 'M', '0352362540', 'Hà Nội'),
('dat', '147369', 'C', 'dat', 'M', '0981618097', 'hà nọi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`BID`),
  ADD KEY `USERNAME` (`USERNAME`);

--
-- Indexes for table `billdetails`
--
ALTER TABLE `billdetails`
  ADD KEY `BID` (`BID`),
  ADD KEY `PID` (`PID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`PID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`USERNAME`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `BID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `PID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `bill_ibfk_2` FOREIGN KEY (`USERNAME`) REFERENCES `user` (`USERNAME`);

--
-- Constraints for table `billdetails`
--
ALTER TABLE `billdetails`
  ADD CONSTRAINT `billdetails_ibfk_1` FOREIGN KEY (`BID`) REFERENCES `bill` (`BID`),
  ADD CONSTRAINT `billdetails_ibfk_2` FOREIGN KEY (`PID`) REFERENCES `product` (`PID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
