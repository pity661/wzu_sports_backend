CREATE TABLE `wzsport`.`wzsport_running_activity_data` (
	`id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
	`activity_id` bigint NOT NULL,
	`acquisition_time` datetime NOT NULL,
	`step_count` smallint UNSIGNED NOT NULL,
	`distance` smallint UNSIGNED NOT NULL,
	`longitude` decimal(10,6) NOT NULL,
	`latitude` decimal(10,6) NOT NULL,
	`location_type` tinyint UNSIGNED NOT NULL,
	`created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_at` datetime ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`)
) COMMENT='';