CREATE TABLE `wzsport_running_activity` (
`id` bigint(11) UNSIGNED NOT NULL AUTO_INCREMENT,
`project_id` bigint(11) UNSIGNED NOT NULL,
`student_id` bigint(11) UNSIGNED NOT NULL,
`distance` int(11) NOT NULL,
`cost_time` int(11) NOT NULL,
`target_time` int(11) NULL DEFAULT NULL,
`start_time` datetime NOT NULL,
`calories_consumed` int(11) NULL DEFAULT NULL,
`qualified` tinyint(1) UNSIGNED NOT NULL,
`created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
`updated_at` datetime ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
ROW_FORMAT = compact;
