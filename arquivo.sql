-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Mar 17, 2021 at 05:56 PM
-- Server version: 5.7.25
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `devChallenge`
--

-- --------------------------------------------------------

--
-- Table structure for table `pais`
--

CREATE TABLE `pais` (
  `id` int(11) NOT NULL,
  `area` varchar(255) DEFAULT NULL,
  `capital` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `regiao` varchar(255) DEFAULT NULL,
  `sub_regiao` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pais`
--

INSERT INTO `pais` (`id`, `area`, `capital`, `nome`, `regiao`, `sub_regiao`) VALUES
(1, 'Baixa', 'Maputo', 'Mozambique', 'Sul', 'Sudeste'),
(2, 'Mpumalanga', 'NelsPruit', 'South Africa', 'Norte', 'Nordeste');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pais`
--
ALTER TABLE `pais`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pais`
--
ALTER TABLE `pais`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
