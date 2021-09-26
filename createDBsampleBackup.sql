-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.21-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for codefury
CREATE DATABASE IF NOT EXISTS `codefury` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `codefury`;

-- Dumping structure for table codefury.asset
CREATE TABLE IF NOT EXISTS `asset` (
  `assetId` int(11) NOT NULL AUTO_INCREMENT,
  `assetName` varchar(254) DEFAULT NULL,
  `type` varchar(254) DEFAULT NULL,
  `desciption` varchar(255) DEFAULT NULL,
  `dateAdded` date DEFAULT NULL,
  `isAvailable` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`assetId`),
  KEY `fk_key` (`type`),
  CONSTRAINT `fk_key` FOREIGN KEY (`type`) REFERENCES `assetcategory` (`category`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

INSERT INTO `asset` (`assetId`, `assetName`, `type`, `desciption`, `dateAdded`, `isAvailable`) VALUES
	(1, 'Redmi', 'Mobile', 'ram-4 gb,storage=128 gb', '2020-02-03', 1),
	(2, 'Hp ', 'Laptop', 'ram-8 gb,storage=1 TB', '2020-06-03', 1),
	(3, 'Shantanu sir ka laptop', 'Laptop', 'Shantanu sir ka laptop', '2021-09-23', 1),
	(4, 'Zebronics Mouse', 'PC Mouse', 'Zebrnoics PC Mouse', '2021-09-23', 1),
	(5, 'Redmi', 'Mobile', 'ram-4 gb,storage=128 gb', '2021-09-24', 1),
	(8, 'PS5', 'Playstation', 'Always out of stock', '2021-09-25', 1);
/*!40000 ALTER TABLE `asset` ENABLE KEYS */;

-- Dumping structure for table codefury.assetallocation
CREATE TABLE IF NOT EXISTS `assetallocation` (
  `allocationId` int(11) NOT NULL AUTO_INCREMENT,
  `assetId` int(11) DEFAULT NULL,
  `empId` int(11) DEFAULT NULL,
  `allocation_date` date DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  PRIMARY KEY (`allocationId`),
  KEY `assetId` (`assetId`),
  KEY `empId` (`empId`),
  CONSTRAINT `assetallocation_ibfk_1` FOREIGN KEY (`assetId`) REFERENCES `asset` (`assetId`),
  CONSTRAINT `assetallocation_ibfk_2` FOREIGN KEY (`empId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;


-- Data exporting was unselected.

-- Dumping structure for table codefury.assetcategory
CREATE TABLE IF NOT EXISTS `assetcategory` (
  `category` varchar(100) NOT NULL,
  `lending_period` int(11) DEFAULT NULL,
  `late_return_fee` int(11) DEFAULT NULL,
  `days_banned` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`category`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `assetcategory` (`category`, `lending_period`, `late_return_fee`, `days_banned`) VALUES
	('Laptop', 10, 100, '14'),
	('Mobile', 15, 75, '10'),
	('PC Mouse', 20, 100, '15'),
	('Playstation', 10, 10000, '365');
-- Data exporting was unselected.

-- Dumping structure for table codefury.historyassetallocation
CREATE TABLE IF NOT EXISTS `historyassetallocation` (
  `allocationId` int(11) NOT NULL AUTO_INCREMENT,
  `assetname` varchar(254) DEFAULT NULL,
  `type` varchar(254) DEFAULT NULL,
  `description` varchar(254) DEFAULT NULL,
  `empId` int(11) DEFAULT NULL,
  `allocation_date` date DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  PRIMARY KEY (`allocationId`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
INSERT INTO `historyassetallocation` (`allocationId`, `assetname`, `type`, `description`, `empId`, `allocation_date`, `due_date`) VALUES
	(1, 'Redmi', 'Mobile', 'ram-4 gb,storage=128 gb', 12, '2021-09-23', '2021-09-25'),
	(9, 'Redmi', 'Mobile', 'ram-4 gb,storage=128 gb', 23, '2021-09-25', '2021-10-10'),
	(10, 'Redmi', 'Mobile', 'ram-4 gb,storage=128 gb', 23, '2021-09-25', '2021-10-10'),
	(11, 'Redmi', 'Mobile', 'ram-4 gb,storage=128 gb', 23, '2021-09-25', '2021-10-10'),
	(12, 'Shantanu sir ka laptop', 'Laptop', 'Shantanu sir ka laptop', 23, '2021-09-25', '2021-09-25'),
	(13, 'Hp ', 'Laptop', 'ram-8 gb,storage=1 TB', 2, '2021-09-25', '2021-10-05'),
	(14, 'Hp ', 'Laptop', 'ram-8 gb,storage=1 TB', 2, '2021-09-25', '2021-10-05'),
	(15, 'Hp ', 'Laptop', 'ram-8 gb,storage=1 TB', 2, '2021-09-25', '2021-10-05'),
	(16, 'Hp ', 'Laptop', 'ram-8 gb,storage=1 TB', 2, '2021-09-25', '2021-10-05'),
	(17, 'Hp ', 'Laptop', 'ram-8 gb,storage=1 TB', 2, '2021-09-26', '2021-10-06'),
	(18, 'Hp ', 'Laptop', 'ram-8 gb,storage=1 TB', 2, '2021-09-26', '2021-10-06'),
	(19, 'Hp ', 'Laptop', 'ram-8 gb,storage=1 TB', 2, '2021-09-26', '2021-10-06'),
	(20, 'Hp ', 'Laptop', 'ram-8 gb,storage=1 TB', 2, '2021-09-26', '2021-10-06'),
	(21, 'Hp ', 'Laptop', 'ram-8 gb,storage=1 TB', 2, '2021-09-26', '2021-10-06'),
	(22, 'Redmi', 'Mobile', 'ram-4 gb,storage=128 gb', 12, '2021-09-26', '2021-10-11'),
	(23, 'Zebronics Mouse', 'PC Mouse', 'Zebrnoics PC Mouse', 12, '2021-09-26', '2021-10-16'),
	(24, 'Hp ', 'Laptop', 'ram-8 gb,storage=1 TB', 23, '2021-09-26', '2021-10-06');

-- Dumping structure for table codefury.overdueasset
CREATE TABLE IF NOT EXISTS `overdueasset` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(254) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `assetid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `assetid` (`assetid`),
  CONSTRAINT `overdueasset_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`userId`),
  CONSTRAINT `overdueasset_ibfk_2` FOREIGN KEY (`assetid`) REFERENCES `asset` (`assetId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

INSERT INTO `overdueasset` (`id`, `message`, `userid`, `assetid`) VALUES
	(1, 'OverDue', 12, 1),
-- Data exporting was unselected.

-- Dumping structure for table codefury.user
CREATE TABLE IF NOT EXISTS `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `role` varchar(25) DEFAULT NULL,
  `telephone` bigint(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(254) DEFAULT NULL,
  `lastLogin` datetime DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

INSERT INTO `user` (`userId`, `name`, `role`, `telephone`, `email`, `username`, `password`, `lastLogin`) VALUES
	(1, 'Rahul Ghosh', 'Admin', 9893884898, 'ghoshrahul@gmail.com', 'rahul', '3a100fb1d83ab0e32bf798e3a18352a113dfedc1482697c944a45d4e021180b2', '2021-09-26 11:05:47'),
	(2, 'Snehal Gunjal', 'Borrower', 9893884898, 'sg@gmail.com', 'snehal', '2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824', '2021-09-26 10:15:35'),
	(3, 'Shivani ', 'Borrower', 89893884898, 'sghdbd@gmail.com', 'Shivani', 'Shivani2699', NULL),
	(4, 'Nikita Deshmane ', 'Borrower', 89893564898, 'nikita@gmail.com', 'nikita', 'nikitad', NULL),
	(5, 'ankita', 'Borrower', 99893564898, 'ankita@gmail.com', 'ankita', 'ankita', '2021-09-23 22:03:05'),
	(6, 'Pooja Mule', 'Borrower', 885893564898, 'pujaMule@gmail.com', 'puja', 'puja', NULL),
	(7, 'Vaishnavi', 'Borrower', 775893564898, 'vaishnavi@gmail.com', 'vaishnavi', 'vaish', NULL),
	(8, 'Akanksha', 'Borrower', 6775893564898, 'akanksha@gmail.com', 'akanksha', 'akanksha', NULL),
	(9, 'Riya Khanna', 'Borrower', 9946763655, 'khannariya@gmail.com', 'riya', 'khanna55', NULL),
	(10, 'Princy Sultania', 'Borrower', 7846763633, 'princy606@gmail.com', 'princy', 'princy606', NULL),
	(11, 'Simran Tannu', 'Borrower', 7446767623, 'simran12@gmail.com', 'simran', 'simran23', NULL),
	(12, 'Avanti Kamal', 'Borrower', 9642763611, 'kamalavanti@gmail.com', 'avkamal', '6510126aae54bb1a39c360955a0fc67b049b60100763aba7827a389a90d10da6', '2021-09-26 10:32:00'),
	(13, 'neha', 'Borrower', 8846793622, 'mneha@gmail.com', 'neha', 'neha123', NULL),
	(14, 'Dipali', 'Borrower', 7786793622, 'Dipali@gmail.com', 'dipa', 'dipa123', NULL),
	(15, 'Rutuja', 'Borrower', 9986793611, 'Rutuja@gmail.com', 'Rutu', 'rutu123', NULL),
	(16, 'Shubham gite', 'Borrower', 7786793611, 'shubham@gmail.com', 'shubham', 'shubham123', NULL),
	(17, 'Vipul lodha', 'Borrower', 7796793622, 'vipullodha@gmail.com', 'vipul', 'vipullodha', NULL),
	(18, 'Kunal More', 'Borrower', 8846793622, 'morekunal@gmail.com', 'kunal', 'kunal22', '2021-09-23 22:00:07'),
	(19, 'Priyambada', 'Borrower', 9342363865, 'priyam@gmail.com', 'priyambada', 'priyambada65', NULL),
	(20, 'Shantanu Banerjee', 'Borrower', 1234567890, 'shantanu@google.com', 'sbtalks', 'sbtalks', '2021-09-19 17:04:26'),
	(21, 'First Person', 'Borrower', 1234567890, 'fp@gmail.com', 'fp', 'fp', NULL),
	(22, 'Second Person', 'Borrower', 1234567890, 'sp@gmail.com', 'sp', 'sp', NULL),
	(23, 'Rocky', 'Borrower', 1234567890, 'rocky@rocky.com', 'rocky', '6510126aae54bb1a39c360955a0fc67b049b60100763aba7827a389a90d10da6', '2021-09-26 11:30:22'),
	(24, 'TestForModificatoins', 'Borrower', 1234567890, 'TestForModificatoins@test.com', 'TestForModificatoins', 'faa2e221caa51c2dbe9ac16ae80cc4f4efafe8aeb8f342dec09defff2c2965e', '2021-09-24 10:00:58'),
	(25, 'TestForModificatoins2', 'Borrower', 1234567890, 'TestForModificatoins2@test.com', 'TestForModificatoins2', '62560f44088bcb952092db6bcdbe92cc242db97a97cc7bd5470a440e02ec84ed', '2021-09-24 10:03:46'),
	(26, 'TestForModificatoins3', 'Borrower', 1234567890, 'TestForModificatoins3@test.com', 'TestForModificatoins3', '6c44578ba94bcb12a97dbd5fdc0bd76146bfd25160ce2974b873c5703587560a', '2021-09-24 14:13:13'),
	(27, 'ram', 'Borrower', 12345, 'srash@gfgh', 'ram', '65e84be33532fb784c48129675f9eff3a682b27168c0ea744b2cf58ee02337c5', '2021-09-25 11:48:49'),
	(28, 'shyam', 'Borrower', 1234567890, 'shyam@shyam', 'shyam', '5648c5cdca917f5ad7fdd4cc82847e24e893e6ed7adb8f43e3ac0839e066ddf6', '2021-09-25 11:51:07');
-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
