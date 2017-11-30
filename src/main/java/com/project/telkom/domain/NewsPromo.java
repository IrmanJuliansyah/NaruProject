/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.telkom.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Irman Juliansyah <irmanjuliansyah@gmail.com>
 */
@Entity
@Table(name = "tb_news_promo")
public class NewsPromo implements Serializable {

    public NewsPromo() {
    }

    public NewsPromo(String newsPromoName, String newsPromoImage, String newsPromoDescription) {
        this.newsPromoName = newsPromoName;
        this.newsPromoImage = newsPromoImage;
        this.newsPromoDescription = newsPromoDescription;
    }

    public NewsPromo(String idNewsPromo, String newsPromoName, String newsPromoImage, String newsPromoDescription) {
        this.idNewsPromo = idNewsPromo;
        this.newsPromoName = newsPromoName;
        this.newsPromoImage = newsPromoImage;
        this.newsPromoDescription = newsPromoDescription;
    }

    @Id
    @Getter
    @Setter
    @Column(name = "id_news_promo", length = 36)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String idNewsPromo;

    @Getter
    @Setter
    @NotNull
    @NotEmpty
    @Column(name = "news_promo_name", length = 50, nullable = false)
    private String newsPromoName;

    @Getter
    @Setter
    @NotNull
    @NotEmpty
    @Column(name = "news_promo_image", nullable = false)
    private String newsPromoImage;

    @Getter
    @Setter
    @NotNull
    @NotEmpty
    @Lob
    @Column(name = "news_promo_description", nullable = false)
    private String newsPromoDescription;

}
