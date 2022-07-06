CREATE SCHEMA IF NOT EXISTS `k-pac` DEFAULT CHARACTER SET utf8;

DROP TABLE IF EXISTS `knowledge_packages`;
CREATE TABLE `knowledge_packages`(
                                     `id` BIGINT NOT NULL AUTO_INCREMENT,
                                     `title` VARCHAR(250) NULL,
                                     `description` VARCHAR(2000) NULL,
                                     `creation_date` DATE NOT NULL DEFAULT (CURRENT_DATE()),
                                     PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `knowledge_package_sets`;
CREATE TABLE `knowledge_package_sets`(
                                         `id` BIGINT NOT NULL AUTO_INCREMENT,
                                         `title` VARCHAR(250) NULL,
                                         PRIMARY KEY (`id`)
);

CREATE TABLE `pac_sets` (
                                    `knowledge_package_id` BIGINT NOT NULL,
                                    `knowledge_package_set_id` BIGINT NOT NULL,

                                    CONSTRAINT `pac_sets_knowledge_packages_fk`
                                        FOREIGN KEY (`knowledge_package_id`) REFERENCES `knowledge_packages` (`id`),
                                    CONSTRAINT `pac_sets_knowledge_package_sets_fk`
                                        FOREIGN KEY (`knowledge_package_set_id`) REFERENCES `knowledge_package_sets` (`id`)
);