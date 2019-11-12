-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3206
-- Tiempo de generación: 08-11-2019 a las 16:32:57
-- Versión del servidor: 10.4.8-MariaDB
-- Versión de PHP: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `operations`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `codCategoria` int(10) UNSIGNED NOT NULL,
  `txtNombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `configuraciones`
--

CREATE TABLE `configuraciones` (
  `codConfiguracion` int(10) UNSIGNED NOT NULL,
  `numCantidad` decimal(11,2) NOT NULL,
  `indTipo` tinyint(3) UNSIGNED NOT NULL,
  `numAno` smallint(5) UNSIGNED NOT NULL,
  `numMes` tinyint(3) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `operations`
--

CREATE TABLE `gastos` (
  `codGasto` int(10) UNSIGNED NOT NULL,
  `txtConcepto` varchar(200) NOT NULL,
  `txtNota` text NOT NULL,
  `datFecha` datetime NOT NULL,
  `numCantidad` decimal(11,2) NOT NULL,
  `indTipo` tinyint(3) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gastos_categorias`
--

CREATE TABLE `gastos_categorias` (
  `codGasto` int(10) UNSIGNED NOT NULL,
  `codCategoria` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gastos_fijos`
--

CREATE TABLE `gastos_fijos` (
  `codGastoFijo` int(10) UNSIGNED NOT NULL,
  `txtConcepto` varchar(200) NOT NULL,
  `numCantidad` decimal(11,2) NOT NULL,
  `txtNota` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `gastos_fijos`
--

INSERT INTO `gastos_fijos` (`codGastoFijo`, `txtConcepto`, `numCantidad`, `txtNota`) VALUES
(1, 'klkl', '10.00', ''),
(2, 'hkj', '9.00', ''),
(3, 'nhhj', '9.00', ''),
(4, 'bjkk', '4.00', ''),
(5, 'hjkjh', '11.89', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gastos_fijos_categorias`
--

CREATE TABLE `gastos_fijos_categorias` (
  `codGastoFijoCategoria` int(10) UNSIGNED NOT NULL,
  `codGastoFijo` int(10) UNSIGNED NOT NULL,
  `codCategoria` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gastos_fijos_mes`
--

CREATE TABLE `gastos_fijos_mes` (
  `codGastoFijoMes` int(10) UNSIGNED NOT NULL,
  `codGastoFijo` int(10) UNSIGNED NOT NULL,
  `datFecha` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`codCategoria`);

--
-- Indices de la tabla `configuraciones`
--
ALTER TABLE `configuraciones`
  ADD PRIMARY KEY (`codConfiguracion`);

--
-- Indices de la tabla `operations`
--
ALTER TABLE `gastos`
  ADD PRIMARY KEY (`codGasto`);

--
-- Indices de la tabla `gastos_categorias`
--
ALTER TABLE `gastos_categorias`
  ADD KEY `codGasto` (`codGasto`),
  ADD KEY `codCategoria` (`codCategoria`);

--
-- Indices de la tabla `gastos_fijos`
--
ALTER TABLE `gastos_fijos`
  ADD PRIMARY KEY (`codGastoFijo`);

--
-- Indices de la tabla `gastos_fijos_categorias`
--
ALTER TABLE `gastos_fijos_categorias`
  ADD PRIMARY KEY (`codGastoFijoCategoria`),
  ADD KEY `codCategoria` (`codCategoria`),
  ADD KEY `codGastoFijo` (`codGastoFijo`);

--
-- Indices de la tabla `gastos_fijos_mes`
--
ALTER TABLE `gastos_fijos_mes`
  ADD PRIMARY KEY (`codGastoFijoMes`),
  ADD KEY `codGastoFijo` (`codGastoFijo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `codCategoria` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `configuraciones`
--
ALTER TABLE `configuraciones`
  MODIFY `codConfiguracion` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `operations`
--
ALTER TABLE `gastos`
  MODIFY `codGasto` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `gastos_fijos`
--
ALTER TABLE `gastos_fijos`
  MODIFY `codGastoFijo` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `gastos_fijos_categorias`
--
ALTER TABLE `gastos_fijos_categorias`
  MODIFY `codGastoFijoCategoria` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `gastos_fijos_mes`
--
ALTER TABLE `gastos_fijos_mes`
  MODIFY `codGastoFijoMes` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `gastos_categorias`
--
ALTER TABLE `gastos_categorias`
  ADD CONSTRAINT `gastos_categorias_ibfk_1` FOREIGN KEY (`codGasto`) REFERENCES `gastos` (`codGasto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `gastos_categorias_ibfk_2` FOREIGN KEY (`codCategoria`) REFERENCES `categorias` (`codCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `gastos_fijos_categorias`
--
ALTER TABLE `gastos_fijos_categorias`
  ADD CONSTRAINT `gastos_fijos_categorias_ibfk_1` FOREIGN KEY (`codCategoria`) REFERENCES `categorias` (`codCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `gastos_fijos_categorias_ibfk_2` FOREIGN KEY (`codGastoFijo`) REFERENCES `gastos_fijos` (`codGastoFijo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `gastos_fijos_mes`
--
ALTER TABLE `gastos_fijos_mes`
  ADD CONSTRAINT `gastos_fijos_mes_ibfk_1` FOREIGN KEY (`codGastoFijo`) REFERENCES `gastos_fijos` (`codGastoFijo`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
