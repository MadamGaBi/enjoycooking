-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema EnjoyCooking
-- -----------------------------------------------------
-- Schema used with the EnjoyCooking application.
DROP SCHEMA IF EXISTS `EnjoyCooking` ;

-- -----------------------------------------------------
-- Schema EnjoyCooking
--
-- Schema used with the EnjoyCooking application.
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `EnjoyCooking` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `EnjoyCooking` ;

-- -----------------------------------------------------
-- Table `EnjoyCooking`.`classification`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EnjoyCooking`.`classification` ;

CREATE TABLE IF NOT EXISTS `EnjoyCooking`.`classification` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'maintains classification of vegetables',
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EnjoyCooking`.`vegetables`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EnjoyCooking`.`vegetables` ;

CREATE TABLE IF NOT EXISTS `EnjoyCooking`.`vegetables` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'maintains list of vegetables',
  `name` VARCHAR(45) NOT NULL,
  `weight` INT UNSIGNED NOT NULL,
  `kcalPer100g` INT UNSIGNED NOT NULL,
  `classification_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_vegetables_classification_idx` (`classification_id` ASC),
  CONSTRAINT `fk_vegetables_classification`
    FOREIGN KEY (`classification_id`)
    REFERENCES `EnjoyCooking`.`classification` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EnjoyCooking`.`recipes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EnjoyCooking`.`recipes` ;

CREATE TABLE IF NOT EXISTS `EnjoyCooking`.`recipes` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'maintains recipes of salads',
  `kcal` INT UNSIGNED NOT NULL,
  `weight` INT UNSIGNED NOT NULL,
  `description` TINYTEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EnjoyCooking`.`recipes_has_vegetables`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EnjoyCooking`.`recipes_has_vegetables` ;

CREATE TABLE IF NOT EXISTS `EnjoyCooking`.`recipes_has_vegetables` (
  `recipes_id` INT UNSIGNED NOT NULL,
  `vegetables_id` INT UNSIGNED NOT NULL,
  `quantity` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`recipes_id`, `vegetables_id`),
  INDEX `fk_recipes_has_vegetables_vegetables1_idx` (`vegetables_id` ASC),
  INDEX `fk_recipes_has_vegetables_recipes1_idx` (`recipes_id` ASC),
  CONSTRAINT `fk_recipes_has_vegetables_recipes1`
    FOREIGN KEY (`recipes_id`)
    REFERENCES `EnjoyCooking`.`recipes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_recipes_has_vegetables_vegetables1`
    FOREIGN KEY (`vegetables_id`)
    REFERENCES `EnjoyCooking`.`vegetables` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
