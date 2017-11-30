package com.project.telkom.helper.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Irman Juliansyah <irmanjuliansyah@gmail.com>
 */
public interface StorageHelper {

    void init();

    String store(String filename);

    Resource loadAsResource(String filename);

    void delete(String filename);
}
