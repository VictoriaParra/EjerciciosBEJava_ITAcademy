DROP TABLE IF EXISTS games;
DROP TABLE IF EXISTS players;
DROP view if exists ranking_view;


SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


CREATE TABLE IF NOT EXISTS `players` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL DEFAULT 'ANONIMO',
  `registration_date` DATE NOT NULL DEFAULT (NOW()),
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `games` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `dice1` INT(11) NOT NULL,
  `dice2` INT(11) NOT NULL,
  `game_result` VARCHAR(45) NOT NULL,
  `players_id` INT(11) NOT NULL,
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

-- Creación vista 

CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `ranking_view` AS
    SELECT 
        `games`.`players_id` AS `players_id`,
        COUNT(`games`.`players_id`) AS `won_games`,
        (SELECT 
                COUNT(0)
            FROM
                `games` `total_games`
            WHERE
                (`total_games`.`players_id` = `games`.`players_id`)
            GROUP BY `total_games`.`players_id`) AS `played_games`,
        CAST(((COUNT(`games`.`players_id`) * 100) / (SELECT 
                    COUNT(0)
                FROM
                    `games` `total_games`
                WHERE
                    (`total_games`.`players_id` = `games`.`players_id`)
                GROUP BY `total_games`.`players_id`))
            AS UNSIGNED) AS `success_rate`
    FROM
        `games`
    WHERE
        (`games`.`game_result` = 'WIN')
    GROUP BY `games`.`players_id`;
