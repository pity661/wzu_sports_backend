CREATE TABLE `wzsport_term` (
`id` bigint(11) UNSIGNED NOT NULL AUTO_INCREMENT,
`university_id` bigint(11) UNSIGNED NOT NULL,
`name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
`start_date` datetime NOT NULL,
`end_date` datetime NOT NULL,
`created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
`updated_at` datetime ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
ROW_FORMAT = compact;