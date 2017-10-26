CREATE TABLE `wzsport_user` (
`id` bigint(11) UNSIGNED NOT NULL AUTO_INCREMENT,
`username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL UNIQUE,
`password` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
`latest_token` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
`created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
`updated_at` datetime ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`) ,
UNIQUE INDEX `username_index` (`username` ASC) USING BTREE
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
ROW_FORMAT = compact;
