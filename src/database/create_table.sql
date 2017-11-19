CREATE DATABASE IF NOT EXISTS `cat_life` DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `personal_user_info`;

CREATE TABLE `personal_user_info` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `open_id` VARCHAR(200) NOT NULL COMMENT '微信号id',
  `nick_name` VARCHAR(200) NOT NULL ,
  `gender` TINYINT NOT NULL DEFAULT 0,
  `city` INT NOT NULL DEFAULT 0,
  `province` INT NOT NULL DEFAULT 0,
  `country` INT NOT NULL DEFAULT 0,
  `avatar_url` VARCHAR(500) DEFAULT '' COMMENT '头像url',
  `personal_statement` VARCHAR(250) DEFAULT NULL COMMENT '个人描述',
  `age` INT NOT NULL DEFAULT 0,
  `emotion_state` INT NOT NULL DEFAULT 0,
  `job` INT NOT NULL COMMENT '职业' DEFAULT 0,
  `constellation` INT NOT NULL COMMENT '星座' DEFAULT 0,
  `hobby` INT NOT NULL COMMENT '兴趣' DEFAULT 0,

  `update_time` BIGINT NOT NULL ,
  `create_time` BIGINT NOT NULL ,

  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_open_id` (`open_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;