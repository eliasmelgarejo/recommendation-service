package com.ventas.ecommerce.recommendation.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * The type Ecommerce statistics.
 */
@Entity
@Table(name = "ecommerce_statistics", uniqueConstraints = {
        @UniqueConstraint(name = "uk_year_month_product_code", columnNames = {"year", "month", "product_code"})
})
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EcommerceStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_dated", updatable = false)
    private LocalDateTime createdDate;
    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_dated", insertable = false)
    private LocalDateTime updatedDate;
    @Version
    private Long version;
    private int year;
    private int month;
    @Column(name = "product_code")
    private String productCode;
    @Column(name = "product_category")
    private String productCategory;
    private int quantity;
}
