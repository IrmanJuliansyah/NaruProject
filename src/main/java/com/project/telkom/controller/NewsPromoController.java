/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.telkom.controller;

import com.project.telkom.domain.NewsPromo;
import com.project.telkom.helper.NotFoundRestHelper;
import com.project.telkom.helper.ValidationIdHelper;
import com.project.telkom.helper.storage.StorageFileNotFoundException;
import com.project.telkom.helper.storage.StorageHelper;
import com.project.telkom.service.NewsPromoService;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Irman Juliansyah <irmanjuliansyah@gmail.com>
 */
@RestController
@RequestMapping(value = "/api")
public class NewsPromoController implements ValidationIdHelper {

    @Autowired
    private NewsPromoService newsPromoService;

    @Autowired
    private StorageHelper storageHelper;

    @GetMapping(value = "/promos")
    public ResponseEntity<?> getPromos() {
        Map<String, Object> map = new HashMap<>();
        map.put("news_promo", newsPromoService.getNewsPromos());

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping(value = "/promos/{idNewsPromo}")
    public ResponseEntity<?> getPromo(@PathVariable("idNewsPromo") String idNewsPromo) {
        this.validateSelf(idNewsPromo);

        Map<String, Object> map = new HashMap<>();
        map.put("news_promo", newsPromoService.getNewsPromo(idNewsPromo));

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/file/{filename:.+}")
    public ResponseEntity<Resource> getFileImagePariwisata(@PathVariable String filename) {

        Resource file = storageHelper.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @PostMapping(value = "/promos")
    public ResponseEntity<?> savePromos(@RequestBody @Valid NewsPromo newsPromo) {

        String filename = storageHelper.store(newsPromo.getNewsPromoImage());

        NewsPromo newsPromo1 = newsPromoService.saveNewsPromo(new NewsPromo(
                newsPromo.getNewsPromoName(),
                filename,
                newsPromo.getNewsPromoDescription()
        ));

        Map<String, Object> map = new HashMap<>();
        map.put("Success", Boolean.TRUE);
        map.put("Info", "Data Berhasil disimpan");

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @PutMapping(value = "/promos/{idNewsPromo}")
    public ResponseEntity<?> updatePromos(@PathVariable("idNewsPromo") String idNewsPromo, @RequestBody @Valid NewsPromo newsPromo) {
        this.validateSelf(idNewsPromo);

        NewsPromo newsPromo1 = newsPromoService.updateNewsPromo(new NewsPromo(
                idNewsPromo,
                newsPromo.getNewsPromoName(),
                newsPromo.getNewsPromoImage(),
                newsPromo.getNewsPromoDescription()
        ));

        Map<String, Object> map = new HashMap<>();
        map.put("Success", Boolean.TRUE);
        map.put("Info", "Data Berhasil diupdate");

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @DeleteMapping(value = "/promos/{idNewsPromo}")
    public ResponseEntity<?> deletePromos(@PathVariable("idNewsPromo") String idNewsPromo) {

        this.validateSelf(idNewsPromo);
        NewsPromo newsPromo = newsPromoService.getNewsPromo(idNewsPromo).orElseThrow(() -> new NotFoundRestHelper(idNewsPromo, "Data News Promo tidak tersedia"));
        storageHelper.delete(newsPromo.getNewsPromoImage());

        Map<String, Object> map = new HashMap<>();
        map.put("Success", Boolean.TRUE);
        map.put("Info", "Data Berhasil dihapus");

        return new ResponseEntity<>(map, HttpStatus.OK);

    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException storageFileNotFoundException) {
        return ResponseEntity.notFound().build();
    }

    @Override
    public void validateSelf(String id) {
        this.newsPromoService.getNewsPromo(id).orElseThrow(() -> new NotFoundRestHelper(id, "Maaf id data yang ada cari tidak tersedia"));
    }

}
