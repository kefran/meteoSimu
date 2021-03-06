-- MySQL Script generated by MySQL Workbench
-- Fri Oct 24 16:45:31 2014
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `Alert`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Alert` ;

CREATE TABLE IF NOT EXISTS `Alert` (
  `Alr_code` VARCHAR(5) NOT NULL,
  `Alr_Label` VARCHAR(45) NOT NULL,
  `Alr_Description` TEXT NOT NULL,
  PRIMARY KEY (`Alr_code`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Area`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Area` ;

CREATE TABLE IF NOT EXISTS `Area` (
  `Are_Id` INT NOT NULL,
  `Are_Label` VARCHAR(45) NOT NULL,
  `Are_Road` VARCHAR(45) NULL,
  PRIMARY KEY (`Are_Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Station`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Station` ;

CREATE TABLE IF NOT EXISTS `Station` (
  `Sta_Id` INT NOT NULL,
  `Sta_Label` VARCHAR(45) NOT NULL,
  `Are_Id` INT NOT NULL,
  `Sta_LastCom` DATETIME NULL,
  `Sta_Valid` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`Sta_Id`),
  INDEX `fk_Sensor_Area1_idx` (`Are_Id` ASC),
  CONSTRAINT `fk_Sensor_Area1`
    FOREIGN KEY (`Are_Id`)
    REFERENCES `Area` (`Are_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sensor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Sensor` ;

CREATE TABLE IF NOT EXISTS `Sensor` (
  `Sen_Id` INT NOT NULL,
  `Sen_Label` VARCHAR(45) NOT NULL,
  `Sta_Id` INT NOT NULL,
  PRIMARY KEY (`Sen_Id`),
  INDEX `fk_Variable_Sensor1_idx` (`Sta_Id` ASC),
  CONSTRAINT `fk_Variable_Sensor1`
    FOREIGN KEY (`Sta_Id`)
    REFERENCES `Station` (`Sta_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Trigger`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Trigger` ;

CREATE TABLE IF NOT EXISTS `Trigger` (
  `Trg_Id` INT NOT NULL,
  `Trg_High` FLOAT NOT NULL,
  `Trg_Low` FLOAT NOT NULL,
  `Trg_Edge` TINYINT(1) NOT NULL,
  `Alr_code` VARCHAR(5) NOT NULL,
  `Sen_Id` INT NOT NULL,
  PRIMARY KEY (`Trg_Id`),
  INDEX `fk_Trigger_Alert_idx` (`Alr_code` ASC),
  INDEX `fk_Trigger_Variable1_idx` (`Sen_Id` ASC),
  CONSTRAINT `fk_Trigger_Alert`
    FOREIGN KEY (`Alr_code`)
    REFERENCES `Alert` (`Alr_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Trigger_Variable1`
    FOREIGN KEY (`Sen_Id`)
    REFERENCES `Sensor` (`Sen_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AlertHis`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `AlertHis` ;

CREATE TABLE IF NOT EXISTS `AlertHis` (
  `Alh_Id` INT NOT NULL,
  `Alh_Date` DATE NOT NULL,
  `Alh_State` TINYINT(1) NOT NULL,
  `Trg_Id` INT NOT NULL,
  PRIMARY KEY (`Alh_Id`),
  INDEX `fk_AlertHis_Trigger1_idx` (`Trg_Id` ASC),
  CONSTRAINT `fk_AlertHis_Trigger1`
    FOREIGN KEY (`Trg_Id`)
    REFERENCES `Trigger` (`Trg_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Temperature`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Temperature` ;

CREATE TABLE IF NOT EXISTS `Temperature` (
  `Tmp_Id` INT NOT NULL,
  `Tmp_Value` FLOAT NOT NULL,
  `Tmp_Date` DATETIME NOT NULL,
  `Sen_Id` INT NOT NULL,
  PRIMARY KEY (`Tmp_Id`),
  INDEX `fk_VariableData_Variable1_idx` (`Sen_Id` ASC),
  CONSTRAINT `fk_VariableData_Variable1`
    FOREIGN KEY (`Sen_Id`)
    REFERENCES `Sensor` (`Sen_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
