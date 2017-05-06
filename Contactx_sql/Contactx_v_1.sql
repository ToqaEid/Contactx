-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema Contactx
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Contactx
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Contactx` DEFAULT CHARACTER SET utf8 ;
USE `Contactx` ;

-- -----------------------------------------------------
-- Table `Contactx`.`group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Contactx`.`group` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `Contactx`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Contactx`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `phone_no` VARCHAR(12) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `phone_no_UNIQUE` (`phone_no` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `Contactx`.`contact`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Contactx`.`contact` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `img_path` VARCHAR(45) NULL DEFAULT NULL,
  `title` VARCHAR(45) NULL DEFAULT NULL,
  `company` VARCHAR(45) NULL DEFAULT NULL,
  `group_id` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_contact_group1_idx` (`group_id` ASC),
  INDEX `fk_contact_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_contact_group1`
    FOREIGN KEY (`group_id`)
    REFERENCES `Contactx`.`group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contact_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `Contactx`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `Contactx`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Contactx`.`address` (
  `idaddress` INT(11) NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(100) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `contacts_id` INT(11) NOT NULL,
  PRIMARY KEY (`idaddress`),
  INDEX `fk_address_contacts1_idx` (`contacts_id` ASC),
  CONSTRAINT `fk_address_contacts1`
    FOREIGN KEY (`contacts_id`)
    REFERENCES `Contactx`.`contact` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `Contactx`.`email`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Contactx`.`email` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `contacts_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_email_contacts1_idx` (`contacts_id` ASC),
  CONSTRAINT `fk_email_contacts1`
    FOREIGN KEY (`contacts_id`)
    REFERENCES `Contactx`.`contact` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `Contactx`.`phone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Contactx`.`phone` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '	',
  `phone_no` VARCHAR(45) NOT NULL COMMENT '	',
  `type` VARCHAR(45) NOT NULL,
  `contacts_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_phone_no_contacts_idx` (`contacts_id` ASC),
  CONSTRAINT `fk_phone_no_contacts`
    FOREIGN KEY (`contacts_id`)
    REFERENCES `Contactx`.`contact` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
