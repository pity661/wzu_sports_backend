ALTER TABLE `wzsport`.`wzsport_running_activity` CHANGE COLUMN `step_count` `step_count` smallint(5) UNSIGNED NOT NULL DEFAULT 1,
ADD COLUMN `speed` decimal(4,2) NOT NULL DEFAULT 0 AFTER `cost_time`,
ADD COLUMN `step_per_second` decimal(4,2) NOT NULL DEFAULT 0 AFTER `speed`, 
ADD COLUMN `distance_per_step` decimal(4,2) NOT NULL DEFAULT 0 AFTER `step_per_second`;