CREATE database IF NOT EXISTS video_game;

use video_game;

DROP TABLE IF EXISTS abilities;
DROP TABLE IF EXISTS weapons;
DROP TABLE IF EXISTS players;

CREATE TABLE players(
player_id int NOT NULL auto_increment,
player_name varchar(50),
PRIMARY KEY (player_id)
);

CREATE TABLE weapons(
weapon_id int NOT NULL auto_increment,
player_id int NOT NULL,
weapon varchar(60) NOT NULL,
PRIMARY KEY (weapon_id),
FOREIGN KEY (player_id) REFERENCES players (player_id)
);

CREATE TABLE abilities(
ability_id int NOT NULL auto_increment,
player_id int NOT NULL,
ability varchar(60) NOT NULL,
PRIMARY KEY (ability_id),
FOREIGN KEY (player_id) REFERENCES players (player_id)
);