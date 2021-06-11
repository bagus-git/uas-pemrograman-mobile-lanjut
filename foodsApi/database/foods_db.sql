-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 11 Jun 2021 pada 22.15
-- Versi server: 10.4.17-MariaDB
-- Versi PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `foods_db`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tabel_foods`
--

CREATE TABLE `tabel_foods` (
  `food_code` int(11) NOT NULL,
  `categories_food` varchar(50) NOT NULL,
  `food_name` varchar(50) NOT NULL,
  `price` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `image` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tabel_foods`
--

INSERT INTO `tabel_foods` (`food_code`, `categories_food`, `food_name`, `price`, `stock`, `image`) VALUES
(1, 'Hamburger', 'Burger Mini', 20000, 1, 'Burger Mini.jpg'),
(2, 'Pizza', 'Pizza Medium', 45000, 2, 'Pizza Medium.png'),
(3, 'Dimsum', 'Dimsum Hakau', 20000, 10, 'Dimsum Hakau.png'),
(4, 'Hot dog', 'Burger Large', 40000, 4, 'Burger Large.png'),
(5, 'Dimsum', 'Chicken Fillet', 25000, 20, 'Chicken Fillet.jpg');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tabel_foods`
--
ALTER TABLE `tabel_foods`
  ADD PRIMARY KEY (`food_code`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tabel_foods`
--
ALTER TABLE `tabel_foods`
  MODIFY `food_code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
