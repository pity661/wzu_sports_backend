CREATE TABLE `wzsport_fitness_check_data` (
`id` bigint(11) UNSIGNED NOT NULL AUTO_INCREMENT,
`student_id` bigint(11) UNSIGNED NOT NULL,
`term_id` bigint(11) UNSIGNED NOT NULL,
`height` int(10) UNSIGNED NOT NULL,
`weight` int(10) UNSIGNED NOT NULL,
`lung_capacity` int(11) UNSIGNED NOT NULL,
`BMI` decimal(5,2) NOT NULL,
`created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
`updated_at` datetime ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
ROW_FORMAT = compact;
