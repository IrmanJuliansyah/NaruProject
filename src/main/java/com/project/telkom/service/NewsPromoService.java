/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.telkom.service;

import com.project.telkom.domain.NewsPromo;
import java.util.Optional;

/**
 *
 * @author Irman Juliansyah <irmanjuliansyah@gmail.com>
 */
public interface NewsPromoService {

    NewsPromo saveNewsPromo(NewsPromo newsPromo);

    NewsPromo updateNewsPromo(NewsPromo newsPromo);

    public void deleteNewsPromo(String idNewsPromo);

    Optional<NewsPromo> getNewsPromo(String idNewsPromo);

    Iterable<NewsPromo> getNewsPromos();
}
