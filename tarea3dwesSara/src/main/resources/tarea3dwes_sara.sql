-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-12-2024 a las 12:40:09
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tarea3dwes_sara`
--
CREATE DATABASE IF NOT EXISTS `tarea3dwes_sara` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `tarea3dwes_sara`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `credenciales`
--

CREATE TABLE `credenciales` (
  `id` bigint(20) NOT NULL,
  `password` varchar(10) NOT NULL,
  `usuario` varchar(15) NOT NULL,
  `id_persona` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `credenciales`
--

INSERT INTO `credenciales` (`id`, `password`, `usuario`, `id_persona`) VALUES
(1, 'admin', 'admin', 1),
(2, 'sara1988', 'sara1988', 2),
(3, 'prudencio', 'prudencio', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplares`
--

CREATE TABLE `ejemplares` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `id_planta` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ejemplares`
--

INSERT INTO `ejemplares` (`id`, `nombre`, `id_planta`) VALUES
(1, 'HORTENSIA_1', 2),
(2, 'HORTENSIA_2', 2),
(3, 'HORTENSIA_3', 2),
(4, 'LAVANDA_1', 4),
(5, 'LAVANDA_2', 4),
(6, 'BAMBU_1', 8),
(7, 'BAMBU_2', 8),
(8, 'BAMBU_3', 8),
(9, 'BAMBU_4', 8),
(10, 'BAMBU_5', 8),
(11, 'GIRASOL_1', 5),
(12, 'GIRASOL_2', 5),
(13, 'GIRASOL_3', 5),
(14, 'MARGARITA_1', 10),
(15, 'MARGARITA_2', 10),
(16, 'MARGARITA_3', 10),
(17, 'ROSA_1', 1),
(18, 'TULIPAN_1', 9),
(19, 'TULIPAN_2', 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensajes`
--

CREATE TABLE `mensajes` (
  `id` bigint(20) NOT NULL,
  `fecha_hora` datetime(6) NOT NULL,
  `mensaje` text NOT NULL,
  `id_ejemplar` bigint(20) NOT NULL,
  `id_persona` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mensajes`
--

INSERT INTO `mensajes` (`id`, `fecha_hora`, `mensaje`, `id_ejemplar`, `id_persona`) VALUES
(1, '2024-10-10 12:10:29.000000', 'Ejemplar registrado por: admin a las 10/10/2024 12:10:29', 1, 1),
(2, '2024-11-10 12:10:42.000000', 'Ejemplar registrado por: admin a las 10/11/2024 12:10:42', 2, 1),
(3, '2024-12-10 12:10:46.000000', 'Ejemplar registrado por: admin a las 10/12/2024 12:10:46', 3, 1),
(4, '2024-09-10 12:10:57.000000', 'Ejemplar registrado por: admin a las 10/09/2024 12:10:57', 4, 1),
(5, '2024-12-01 12:11:05.000000', 'Ejemplar registrado por: admin a las 01/12/2024 12:11:05', 5, 1),
(6, '2024-12-10 12:13:50.000000', 'Ejemplar registrado por: sara1988 a las 10/12/2024 12:13:50', 6, 2),
(7, '2024-12-10 12:13:54.000000', 'Ejemplar registrado por: sara1988 a las 10/12/2024 12:13:54', 7, 2),
(8, '2024-12-10 12:13:58.000000', 'Ejemplar registrado por: sara1988 a las 10/12/2024 12:13:58', 8, 2),
(9, '2024-12-10 12:14:01.000000', 'Ejemplar registrado por: sara1988 a las 10/12/2024 12:14:01', 9, 2),
(10, '2024-12-10 12:14:04.000000', 'Ejemplar registrado por: sara1988 a las 10/12/2024 12:14:04', 10, 2),
(11, '2024-12-10 12:14:10.000000', 'Ejemplar registrado por: sara1988 a las 10/12/2024 12:14:10', 11, 2),
(12, '2024-12-10 12:14:13.000000', 'Ejemplar registrado por: sara1988 a las 10/12/2024 12:14:13', 12, 2),
(13, '2024-12-10 12:14:16.000000', 'Ejemplar registrado por: sara1988 a las 10/12/2024 12:14:16', 13, 2),
(14, '2024-11-10 12:15:25.000000', 'El panda del vecino le pegó un bocao!', 6, 2),
(15, '2024-11-15 17:15:33.000000', 'Se recupera adecuadamente del bocao del panda', 6, 2),
(16, '2024-11-22 12:16:39.000000', 'El bocao ya casi no se nota', 6, 2),
(17, '2024-12-10 12:17:12.000000', 'Ejemplar más amarillo que los demás', 7, 2),
(18, '2024-12-10 12:17:41.000000', 'Regado en su justa medida', 9, 2),
(19, '2024-12-10 12:18:43.000000', 'Ejemplar registrado por: prudencio a las 10/12/2024 12:18:43', 14, 3),
(20, '2024-12-10 12:18:47.000000', 'Ejemplar registrado por: prudencio a las 10/12/2024 12:18:47', 15, 3),
(21, '2024-12-10 12:18:54.000000', 'Ejemplar registrado por: prudencio a las 10/12/2024 12:18:54', 16, 3),
(22, '2024-12-10 12:19:01.000000', 'Ejemplar registrado por: prudencio a las 10/12/2024 12:19:01', 17, 3),
(23, '2024-12-10 12:19:06.000000', 'Ejemplar registrado por: prudencio a las 10/12/2024 12:19:06', 18, 3),
(24, '2024-12-10 12:19:10.000000', 'Ejemplar registrado por: prudencio a las 10/12/2024 12:19:10', 19, 3),
(25, '2024-12-10 12:19:58.000000', 'Un ejemplar lavanda con color muy lavanda', 6, 3),
(26, '2024-11-22 12:20:33.000000', 'La pisé sin querer. Veremos como evoluciona...', 2, 3),
(27, '2024-12-10 12:21:04.000000', 'Regada con aditivos para darle fuerzas', 2, 3),
(28, '2024-12-03 12:21:35.000000', 'Ya no se le nota que la pisé!', 2, 3),
(29, '2024-12-10 12:22:25.000000', 'Buen bambú. Muy robusto!', 9, 1),
(30, '2024-12-10 12:22:40.000000', 'A punto de dar pipas', 12, 1),
(31, '2024-12-10 12:23:46.000000', 'Una margarita perfecta', 15, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE `personas` (
  `id` bigint(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`id`, `email`, `nombre`) VALUES
(1, 'admin@vivero.es', 'Admin'),
(2, 'sara@vivero.es', 'Sara'),
(3, 'elpruden@vivero.es', 'Prudencio');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plantas`
--

CREATE TABLE `plantas` (
  `id` bigint(20) NOT NULL,
  `codigo` varchar(30) NOT NULL,
  `nombre_cientifico` varchar(100) DEFAULT NULL,
  `nombre_comun` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `plantas`
--

INSERT INTO `plantas` (`id`, `codigo`, `nombre_cientifico`, `nombre_comun`) VALUES
(1, 'ROSA', 'Rosa spp', 'Rosa'),
(2, 'HORTENSIA', 'Hydrangea macrophylla', 'Hortensia'),
(3, 'MENTA', 'Mentha piperita', 'Menta'),
(4, 'LAVANDA', 'Lavandula angustifolia', 'Lavanda'),
(5, 'GIRASOL', 'Helianthus annuus', 'Girasol'),
(6, 'HIEDRA', 'Hedera helix', 'Hiedra'),
(7, 'ALOE', 'Aloe barbadensis miller', 'Aloe Vera'),
(8, 'BAMBU', 'Bambusa spp', 'Bambú'),
(9, 'TULIPAN', 'Tulipa spp', 'Tulipán'),
(10, 'MARGARITA', 'Bellis perennis', 'Margarita');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `credenciales`
--
ALTER TABLE `credenciales`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKgl50fmouks2ue8s9yclvv059j` (`usuario`),
  ADD UNIQUE KEY `UKkj0bakygq84a8uwy2avcihxqi` (`id_persona`);

--
-- Indices de la tabla `ejemplares`
--
ALTER TABLE `ejemplares`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK44fnp4rtcs2j6ppkmkoqbtton` (`id_planta`);

--
-- Indices de la tabla `mensajes`
--
ALTER TABLE `mensajes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKidbx1mhngh3c3ry5bqisftxbv` (`id_ejemplar`),
  ADD KEY `FK2e6au5w562m7skcvx9jckiba6` (`id_persona`);

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKlrw7flsg11d8nhgyvueqtnp8e` (`email`);

--
-- Indices de la tabla `plantas`
--
ALTER TABLE `plantas`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKbqo6lbeads0ifdh6dohhfhryp` (`codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `credenciales`
--
ALTER TABLE `credenciales`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `ejemplares`
--
ALTER TABLE `ejemplares`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `mensajes`
--
ALTER TABLE `mensajes`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT de la tabla `personas`
--
ALTER TABLE `personas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `plantas`
--
ALTER TABLE `plantas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `credenciales`
--
ALTER TABLE `credenciales`
  ADD CONSTRAINT `FKgntr1s6h8ryu511tqjln50yp2` FOREIGN KEY (`id_persona`) REFERENCES `personas` (`id`);

--
-- Filtros para la tabla `ejemplares`
--
ALTER TABLE `ejemplares`
  ADD CONSTRAINT `FK44fnp4rtcs2j6ppkmkoqbtton` FOREIGN KEY (`id_planta`) REFERENCES `plantas` (`id`);

--
-- Filtros para la tabla `mensajes`
--
ALTER TABLE `mensajes`
  ADD CONSTRAINT `FK2e6au5w562m7skcvx9jckiba6` FOREIGN KEY (`id_persona`) REFERENCES `personas` (`id`),
  ADD CONSTRAINT `FKidbx1mhngh3c3ry5bqisftxbv` FOREIGN KEY (`id_ejemplar`) REFERENCES `ejemplares` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
