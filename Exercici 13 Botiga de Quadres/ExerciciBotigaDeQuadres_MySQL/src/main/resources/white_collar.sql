DROP TABLE IF EXISTS `pictures`;
DROP TABLE IF EXISTS shops;

CREATE TABLE `shops` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(250) NOT NULL,
    `capacity` INT NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `pictures` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(250) NOT NULL,
    `author_name` VARCHAR(250) NOT NULL DEFAULT 'ANONIMO',
    `price` INT DEFAULT NULL,
    -- `entry_date` DATE NOT NULL DEFAULT NOW(),
	`entry_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `shop_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `pictures_fk` FOREIGN KEY (`shop_id`)
        REFERENCES `shops` (`id`)
        ON DELETE CASCADE ON UPDATE CASCADE
);

insert into shops (name, capacity)values('Collar City', 20);
insert into shops (name, capacity)values('Colorful Collar', 35);
insert into shops (name, capacity)values('BlackCollar', 15);
insert into shops (name, capacity)values('Painted Collars', 45);


insert into pictures (name, author_name,price,entry_date,shop_id)values('Mar Azul','ANONIMO',150, NOW(), 1);
insert into pictures (name, price,entry_date,shop_id)values('La Noche Estrellada', 600, NOW(), 2);
insert into pictures (name, author_name,price,entry_date,shop_id)values('The Son of Man','Rene',200, NOW(), 1);
insert into pictures (name, author_name,price,entry_date,shop_id)values('American Gothic','Grant',150, NOW(), 4);
insert into pictures (name, author_name,price,entry_date,shop_id)values('Las Meninas','ANONIMO',350, NOW(), 4);
insert into pictures (name, author_name,price,entry_date,shop_id)values('The Kiss','Gustav',500, NOW(), 3);