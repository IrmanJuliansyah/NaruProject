package com.project.telkom.helper.storage;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author Irman Juliansyah <irmanjuliansyah@gmail.com>
 */
@ConfigurationProperties("storage")
public class StorageProperties {

    @Getter
    private String location = "upload-dir";
}
