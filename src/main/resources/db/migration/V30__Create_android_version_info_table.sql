CREATE TABLE `wzsport`.`wzsport_android_version_info` (
	`id` bigint(11) NOT NULL AUTO_INCREMENT,
	`version` varchar(10) NOT NULL,
	`version_code` int(11) UNSIGNED NOT NULL,
	`changelog` varchar(255) NOT NULL,
	`forced` tinyint(1) UNSIGNED NOT NULL DEFAULT 0,
	`apk_url` varchar(100) NOT NULL,
	`created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_at` datetime ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`)
);