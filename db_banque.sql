-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 13, 2018 at 03:30 AM
-- Server version: 5.7.23-0ubuntu0.16.04.1
-- PHP Version: 7.0.32-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_banque`
--

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `code_client` bigint(20) NOT NULL,
  `nom_client` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`code_client`, `nom_client`) VALUES
(1, 'A'),
(2, 'ClientA'),
(3, 'ClientB'),
(4, 'ClientC'),
(5, 'ClientD');

-- --------------------------------------------------------

--
-- Table structure for table `compte`
--

CREATE TABLE `compte` (
  `type_cpte` varchar(2) NOT NULL,
  `code_compte` varchar(255) NOT NULL,
  `date_creation` date DEFAULT NULL,
  `solde` double NOT NULL,
  `decouvert` double DEFAULT NULL,
  `taux` double DEFAULT NULL,
  `code_cli` bigint(20) DEFAULT NULL,
  `code_emp` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `compte`
--

INSERT INTO `compte` (`type_cpte`, `code_compte`, `date_creation`, `solde`, `decouvert`, `taux`, `code_cli`, `code_emp`) VALUES
('CC', 'CC1', '2018-10-27', 20999, 0, NULL, 3, 3),
('CE', 'CE1', '2018-10-27', 25000, NULL, 0, 3, 3),
('CE', 'CE2', '2018-10-27', 62334, NULL, 0, 1, 5),
('CE', 'CE3', '2018-10-27', 18000, NULL, 0, 4, 4),
('CC', 'CC2', '2018-10-27', 20000, 0, NULL, 5, 1),
('CC', 'CC4', '2018-10-27', 30000, 12345, NULL, 2, 2),
('CE', 'CE4', '2018-10-27', 30000, NULL, 12.5, 2, 2),
('CE', 'CE5', '2018-10-27', 27000, NULL, 15, 3, 1),
('CC', 'RMICC99', '2018-10-28', 99999, 1000, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `employe`
--

CREATE TABLE `employe` (
  `code_employe` bigint(20) NOT NULL,
  `nom_employe` varchar(255) DEFAULT NULL,
  `code_emp_sup` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employe`
--

INSERT INTO `employe` (`code_employe`, `nom_employe`, `code_emp_sup`) VALUES
(1, 'Employe1', NULL),
(2, 'Employe2', NULL),
(3, 'Employe3', NULL),
(4, 'Employe4', NULL),
(5, 'Employe5', 1),
(6, 'Employe6', 1),
(7, 'Employe7', 2),
(8, 'Employe8', 2);

-- --------------------------------------------------------

--
-- Table structure for table `emp_gr`
--

CREATE TABLE `emp_gr` (
  `employes_code_employe` bigint(20) NOT NULL,
  `groupes_code_groupe` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `groupes`
--

CREATE TABLE `groupes` (
  `code_groupe` bigint(20) NOT NULL,
  `nom_groupe` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `operations`
--

CREATE TABLE `operations` (
  `dtype` varchar(31) NOT NULL,
  `numero_operation` bigint(20) NOT NULL,
  `date_operation` datetime DEFAULT NULL,
  `montant` double NOT NULL,
  `code_cpte` varchar(255) DEFAULT NULL,
  `code_emp` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `operations`
--

INSERT INTO `operations` (`dtype`, `numero_operation`, `date_operation`, `montant`, `code_cpte`, `code_emp`) VALUES
('V', 1, '2018-10-28 00:55:04', 5000, 'CC1', 1),
('V', 2, '2018-10-28 01:22:25', 2000, 'CE2', 5),
('V', 3, '2018-10-28 01:23:30', 26000, 'CE2', 5),
('V', 4, '2018-10-28 01:23:59', 26000, 'CE2', 1),
('R', 5, '2018-10-28 01:25:29', 6000, 'CE2', 1),
('R', 6, '2018-10-28 01:26:43', 7000, 'CE2', 1),
('R', 7, '2018-10-28 01:29:46', 5000, 'CC1', 3),
('V', 8, '2018-10-28 01:29:46', 5000, 'CC2', 3),
('V', 9, '2018-10-28 02:44:35', 999, 'CC1', 1),
('R', 10, '2018-10-28 02:47:04', 666, 'CE2', 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`code_client`);

--
-- Indexes for table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`code_compte`),
  ADD KEY `FK2hw4shqsxc782lychpkr52lmv` (`code_cli`),
  ADD KEY `FKbm21kemcgkptyq3x0ge8ciaqu` (`code_emp`);

--
-- Indexes for table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`code_employe`),
  ADD KEY `FKhsh3jgj0ctoiewmr371xmvby5` (`code_emp_sup`);

--
-- Indexes for table `emp_gr`
--
ALTER TABLE `emp_gr`
  ADD KEY `FKjhp1uprhg2x5coadrabgmb7qv` (`groupes_code_groupe`),
  ADD KEY `FK5qwh8m8pw9xxgjpqr0lh1tobx` (`employes_code_employe`);

--
-- Indexes for table `groupes`
--
ALTER TABLE `groupes`
  ADD PRIMARY KEY (`code_groupe`);

--
-- Indexes for table `operations`
--
ALTER TABLE `operations`
  ADD PRIMARY KEY (`numero_operation`),
  ADD KEY `FKjebuh2o30jfjy921nkks7p25c` (`code_cpte`),
  ADD KEY `FK293goou09mrmn60vqtlxmj62` (`code_emp`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `code_client` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `employe`
--
ALTER TABLE `employe`
  MODIFY `code_employe` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `groupes`
--
ALTER TABLE `groupes`
  MODIFY `code_groupe` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `operations`
--
ALTER TABLE `operations`
  MODIFY `numero_operation` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
