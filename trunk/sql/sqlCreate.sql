SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';


-- -----------------------------------------------------
-- Table `grupo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `grupo` ;

CREATE  TABLE IF NOT EXISTS `grupo` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `usuario` ;

CREATE  TABLE IF NOT EXISTS `usuario` (
  `id` INT NOT NULL ,
  `nombre` VARCHAR(45) NULL ,
  `id_grupo` INT NULL ,
  PRIMARY KEY (`id`) ,
  CONSTRAINT `fk_usuario_grupo`
    FOREIGN KEY (`id_grupo` )
    REFERENCES `mydb`.`grupo` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_usuario_grupo` ON `usuario` (`id_grupo` ASC) ;


-- -----------------------------------------------------
-- Table `estado_contacto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `estado_contacto` ;

CREATE  TABLE IF NOT EXISTS `estado_contacto` (
  `id` INT NOT NULL ,
  `nombre` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tipo_contacto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tipo_contacto` ;

CREATE  TABLE IF NOT EXISTS `tipo_contacto` (
  `id` INT NOT NULL ,
  `nombre` VARCHAR(45) NULL ,
  `costo` DOUBLE NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cliente` ;

CREATE  TABLE IF NOT EXISTS `cliente` (
  `id` INT NOT NULL ,
  `nombre` VARCHAR(45) NULL ,
  `apellido` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `prioridad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `prioridad` ;

CREATE  TABLE IF NOT EXISTS `prioridad` (
  `id` INT NOT NULL ,
  `nombre` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contacto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `contacto` ;

CREATE  TABLE IF NOT EXISTS `contacto` (
  `id` INT NOT NULL ,
  `recibido_el` TIMESTAMP NULL ,
  `asignado_el` TIMESTAMP NULL ,
  `numero_entrante` VARCHAR(45) NULL ,
  `desc` TEXT NULL ,
  `id_estado_contacto` INT NULL ,
  `id_tipo_contacto` INT NULL ,
  `id_cliente` INT NULL ,
  `id_prioridad` INT NULL ,
  `id_tecnico` INT NULL ,
  `id_telefonista` INT NULL ,
  PRIMARY KEY (`id`) ,
  CONSTRAINT `fk_contacto_estado_contacto`
    FOREIGN KEY (`id_estado_contacto` )
    REFERENCES `mydb`.`estado_contacto` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contacto_tipo_contacto`
    FOREIGN KEY (`id_tipo_contacto` )
    REFERENCES `mydb`.`tipo_contacto` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contacto_cliente`
    FOREIGN KEY (`id_cliente` )
    REFERENCES `mydb`.`cliente` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contacto_prioridad`
    FOREIGN KEY (`id_prioridad` )
    REFERENCES `mydb`.`prioridad` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contacto_usuario`
    FOREIGN KEY (`id_tecnico` )
    REFERENCES `mydb`.`usuario` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contacto_usuario1`
    FOREIGN KEY (`id_telefonista` )
    REFERENCES `mydb`.`usuario` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_contacto_estado_contacto` ON `contacto` (`id_estado_contacto` ASC) ;

CREATE INDEX `fk_contacto_tipo_contacto` ON `contacto` (`id_tipo_contacto` ASC) ;

CREATE INDEX `fk_contacto_cliente` ON `contacto` (`id_cliente` ASC) ;

CREATE INDEX `fk_contacto_prioridad` ON `contacto` (`id_prioridad` ASC) ;

CREATE INDEX `fk_contacto_usuario` ON `contacto` (`id_tecnico` ASC) ;

CREATE INDEX `fk_contacto_usuario1` ON `contacto` (`id_telefonista` ASC) ;


-- -----------------------------------------------------
-- Table `articulo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `articulo` ;

CREATE  TABLE IF NOT EXISTS `articulo` (
  `id` INT NOT NULL ,
  `nombre` VARCHAR(45) NULL ,
  `id_padre` INT NULL ,
  `costo` DOUBLE NULL ,
  PRIMARY KEY (`id`) ,
  CONSTRAINT `fk_articulo_articulo`
    FOREIGN KEY (`id_padre` )
    REFERENCES `mydb`.`articulo` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_articulo_articulo` ON `articulo` (`id_padre` ASC) ;


-- -----------------------------------------------------
-- Table `articulo_contacto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `articulo_contacto` ;

CREATE  TABLE IF NOT EXISTS `articulo_contacto` (
  `articulo_id` INT NOT NULL ,
  `contacto_id` INT NOT NULL ,
  `cantidad` INT NULL ,
  PRIMARY KEY (`articulo_id`, `contacto_id`) ,
  CONSTRAINT `fk_articulo_has_contacto_articulo`
    FOREIGN KEY (`articulo_id` )
    REFERENCES `mydb`.`articulo` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_articulo_has_contacto_contacto`
    FOREIGN KEY (`contacto_id` )
    REFERENCES `mydb`.`contacto` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE INDEX `fk_articulo_has_contacto_articulo` ON `articulo_contacto` (`articulo_id` ASC) ;

CREATE INDEX `fk_articulo_has_contacto_contacto` ON `articulo_contacto` (`contacto_id` ASC) ;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
