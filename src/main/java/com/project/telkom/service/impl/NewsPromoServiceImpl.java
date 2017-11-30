/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.telkom.service.impl;

import com.project.telkom.domain.NewsPromo;
import com.project.telkom.repository.NewsPromoRepository;
import com.project.telkom.service.NewsPromoService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Irman Juliansyah <irmanjuliansyah@gmail.com>
 */
@Service
@Transactional(readOnly = true)
public class NewsPromoServiceImpl implements NewsPromoService {

    @Autowired
    private NewsPromoRepository newsPromoRepository;

    @Transactional
    @Override
    public NewsPromo saveNewsPromo(NewsPromo newsPromo) {
        return newsPromoRepository.save(newsPromo);
    }

    @Transactional
    @Override
    public NewsPromo updateNewsPromo(NewsPromo newsPromo) {
        return newsPromoRepository.save(newsPromo);
    }

    @Transactional
    @Override
    public void deleteNewsPromo(String idNewsPromo) {
        newsPromoRepository.delete(idNewsPromo);
    }

    @Override
    public Optional<NewsPromo> getNewsPromo(String idNewsPromo) {
        return newsPromoRepository.findByIdNewsPromo(idNewsPromo);
    }

    @Override
    public Iterable<NewsPromo> getNewsPromos() {
        return newsPromoRepository.findAll();
    }

}
