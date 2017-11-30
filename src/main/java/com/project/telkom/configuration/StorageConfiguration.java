package com.project.telkom.configuration;

import com.project.telkom.helper.storage.StorageHelper;
import com.project.telkom.helper.storage.StorageProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Irman Juliansyah <irmanjuliansyah@gmail.com>
 */
@Configuration
@EnableConfigurationProperties(StorageProperties.class)
public class StorageConfiguration {

    @Bean
    CommandLineRunner init(StorageHelper storageHelper) {
        return (args) -> storageHelper.init();
    }

}
