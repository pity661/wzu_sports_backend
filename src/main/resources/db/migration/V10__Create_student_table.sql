CREATE TABLE `wzsport_student` (
`id` bigint(11) UNSIGNED NOT NULL AUTO_INCREMENT,
`user_id` bigint(11) UNSIGNED NOT NULL,
`class_id` bigint(11) UNSIGNED NOT NULL,
`university_id` bigint(11) UNSIGNED NOT NULL,
`student_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
`is_man` tinyint(1) UNSIGNED NOT NULL DEFAULT 1,
`name` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
`created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
`updated_at` datetime ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
ROW_FORMAT = compact;
