CREATE TABLE `wzsport_teacher` (
`id` bigint(11) UNSIGNED NOT NULL AUTO_INCREMENT,
`job_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
`university_id` bigint(11) UNSIGNED NOT NULL,
`name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
`is_man` tinyint(1) UNSIGNED NULL DEFAULT NULL,
`created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
`updated_at` datetime ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
ROW_FORMAT = compact;
