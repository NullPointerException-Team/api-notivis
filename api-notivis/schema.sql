SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `Notivis` DEFAULT CHARACTER SET utf8 ;
USE `Notivis` ;

DROP TABLE IF EXISTS `Notivis`.`aluno` ;

CREATE TABLE `alunos` (
                         `numero_matricula` SERIAL NOT NULL,
                         `nome` varchar(100) NOT NULL,
                         PRIMARY KEY (`numero_matricula`),
                         UNIQUE KEY `numero_matricula_UNIQUE` (`numero_matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `Notivis`.`anotacao` ;

CREATE TABLE `perguntas` (
                            `id` SERIAL NOT NULL,
                            `conteudo` TEXT NOT NULL ,
                            `numero_matricula_aluno` int DEFAULT NULL,
                            `status_respondida` boolean default NULL,
                            PRIMARY KEY (`id`),
                            FOREIGN KEY (`numero_matricula_aluno`) REFERENCES aluno(`numero_matricula`),
                            UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `Notivis`.`materia` ;

CREATE TABLE `materia` (
                           `codigo` int NOT NULL,
                           `descricao` varchar(45) DEFAULT NULL,
                           `ementa` varchar(45) DEFAULT NULL,
                           `ch` int DEFAULT NULL,
                           `id_professor` int DEFAULT NULL,
                           `numero_matricula_aluno` int DEFAULT NULL,
                           PRIMARY KEY (`codigo`),
                           FOREIGN KEY (`id_professor`) REFERENCES professor(`id`),
                           FOREIGN KEY (`numero_matricula_aluno`) REFERENCES aluno(`numero_matricula`),
                           UNIQUE KEY `codigo_UNIQUE` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `Notivis`.`professor` ;

CREATE TABLE `professor` (
                             `id` int NOT NULL,
                             `nome_professor` varchar(45) NOT NULL,
                             `codigo_materia` int DEFAULT NULL,
                             PRIMARY KEY (`id`),
                             FOREIGN KEY (`codigo_materia`) REFERENCES materia(`codigo`),
                             UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;