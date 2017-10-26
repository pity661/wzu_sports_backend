CREATE TABLE `wzsport_sport_score` (
`id` bigint(11) NOT NULL AUTO_INCREMENT,

`student_id` bigint(11) UNSIGNED NOT NULL,
`term_id` bigint(11) UNSIGNED NOT NULL,

`meter50_sprint_time` decimal(5,2) NOT NULL,
`meter50_sprint_score` tinyint(3) UNSIGNED NOT NULL,

`standing_jump_distance` smallint(6) UNSIGNED NOT NULL,
`standing_jump_score` tinyint(3) UNSIGNED NOT NULL,

`meter1500_run_time` smallint(6) UNSIGNED NOT NULL,
`meter1500_run_score` tinyint(3) UNSIGNED NOT NULL,

`abdominal_curl_count` tinyint(3) UNSIGNED NOT NULL,
`abdominal_curl_score` tinyint(3) UNSIGNED NOT NULL,

`created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
`updated_at` datetime ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
ROW_FORMAT = compact;