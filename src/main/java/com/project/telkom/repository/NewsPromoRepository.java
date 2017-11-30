/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.telkom.repository;

import com.project.telkom.domain.NewsPromo;
import java.io.Serializable;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Irman Juliansyah <irmanjuliansyah@gmail.com>
 */
public interface NewsPromoRepository extends PagingAndSortingRepository<NewsPromo, String> {

    Optional<NewsPromo> findByIdNewsPromo(String idNewsPromo);
}
