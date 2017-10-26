CREATE TABLE `wzsport_r_teacher_class` (
`id` bigint(11) UNSIGNED NOT NULL AUTO_INCREMENT,
`teacher_id` bigint(11) UNSIGNED NOT NULL,
`class_id` bigint(11) UNSIGNED NOT NULL,
`created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
`updated_at` datetime ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
ROW_FORMAT = compact;
