<h1>Database</h1>

-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 23, 2020 at 05:46 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.6

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
  `UID` int(11) DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  `STATUS` char(1) DEFAULT NULL
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
  `NAME` varchar(24) NOT NULL,
  `TYPE` char(1) DEFAULT NULL,
  `PRICE` float DEFAULT NULL,
  `QUANTITY` int(11) DEFAULT NULL,
  `IMAGE` varchar(100) DEFAULT NULL,
  `DESCRIPTION` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`PID`, `NAME`, `TYPE`, `PRICE`, `QUANTITY`, `IMAGE`, `DESCRIPTION`) VALUES
(1, 'Lang 01', 'S', 249, 20, NULL, NULL),
(2, 'Kalo 032', 'S', 320, 10, NULL, NULL),
(3, 'MioMio 032', 'S', 280, 5, NULL, NULL),
(4, 'Liberty D01', 'G', 230, 15, NULL, NULL),
(5, 'Havana 01', 'G', 330, 18, NULL, NULL),
(6, 'Dear Classic 02', 'G', 220, 25, NULL, NULL),
(7, 'Mig B1', 'G', 250, 7, NULL, NULL),
(8, 'Gogh SV', 'A', 260, 20, NULL, NULL),
(9, 'RingRing GD', 'A', 170, 12, NULL, NULL),
(10, 'Fall Ring GD', 'A', 260, 18, NULL, NULL),
(11, 'Big Fish SV', 'A', 170, 14, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `UID` int(11) NOT NULL,
  `USERNAME` varchar(24) NOT NULL,
  `PASSWORD` varchar(10) NOT NULL,
  `ROLE` char(1) NOT NULL,
  `NAME` varchar(30) DEFAULT NULL,
  `PHONE` varchar(15) DEFAULT NULL,
  `ADDRESS` varchar(100) DEFAULT NULL,
  `GENDER` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`UID`, `USERNAME`, `PASSWORD`, `ROLE`, `NAME`, `PHONE`, `ADDRESS`, `GENDER`) VALUES
(1, 'admin', 'admin', 'A', 'Nguyen Phi Long', '0352362540', NULL, NULL),
(2, 'client', 'client', 'C', 'Nguyen Phi Long', '0352362540', 'Hanoi', 'M'),
(3, 'nphilong', 'nphilong', 'C', NULL, NULL, NULL, NULL),
(5, 'client2', 'client', 'C', NULL, NULL, NULL, NULL),
(7, 'client3', 'a', 'C', 'Nguyễn Phi Long', '0352362540', 'Số nhà 3, Ngõ 296, Lĩnh Nam, Hoàng Mai, Hà Nội', 'F'),
(8, 'longnp', 'a', 'C', NULL, NULL, NULL, NULL),
(9, 'khanhnk', 'a', 'C', 'Nguyễn Quốc Khánh', '0352365478', 'Hà Nội', 'M');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`BID`),
  ADD KEY `UID` (`UID`);

--
-- Indexes for table `billdetails`
--
ALTER TABLE `billdetails`
  ADD PRIMARY KEY (`BID`,`PID`),
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
  ADD PRIMARY KEY (`UID`),
  ADD UNIQUE KEY `USERNAME` (`USERNAME`);

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
  MODIFY `PID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `UID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `bill_ibfk_1` FOREIGN KEY (`UID`) REFERENCES `user` (`UID`);

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
