
DROP TABLE IF EXISTS games;
DROP TABLE IF EXISTS players;

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


CREATE TABLE IF NOT EXISTS `players` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL DEFAULT 'ANONIMO', 
  `registration_date` DATE NOT NULL DEFAULT (NOW()),
  `success_rate` INT DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `games` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dice1` INT NOT NULL,
  `dice2` INT NOT NULL,
  `game_result` VARCHAR(45) NOT NULL,
  `players_id` INT NOT NULL,
  PRIMARY KEY (`id`, `players_id`),
  INDEX `fk_games_players1_idx` (`players_id` ASC) VISIBLE,
  CONSTRAINT `fk_games_players1`
    FOREIGN KEY (`players_id`)
    REFERENCES `dice_game`.`players` (`id`)
    ON DELETE CASCADE 
    ON UPDATE CASCADE )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;