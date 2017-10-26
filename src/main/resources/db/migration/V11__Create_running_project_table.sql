CREATE TABLE `wzsport_running_project` (
`id` bigint(11) UNSIGNED NOT NULL AUTO_INCREMENT,
`university_id` bigint(11) UNSIGNED NOT NULL,
`name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
`type` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
`enabled` tinyint(1) UNSIGNED NOT NULL DEFAULT 1,
`qualified_distance` int(11) NOT NULL,
`qualified_cost_time` int(11) NOT NULL,
`min_cost_time` int(11) NOT NULL,
`hourly_calorie_consumption` int(11) NOT NULL,
`created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
`updated_at` datetime ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
ROW_FORMAT = compact;
