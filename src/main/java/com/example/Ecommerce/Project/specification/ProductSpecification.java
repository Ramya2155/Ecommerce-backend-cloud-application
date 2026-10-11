
package com.example.Ecommerce.Project.specification;

import com.example.Ecommerce.Project.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    public static Specification<Product> hasCategory(String category) {
        return (root, query, cb) -> {
            if (category == null || category.trim().isEmpty()) {
                return null;
            }
            return cb.equal(
                    cb.lower(root.get("category")),
                    category.trim().toLowerCase()
            );
        };
    }

    public static Specification<Product> priceBetween(Double min, Double max) {
        return (root, query, cb) -> {
            if (min == null && max == null) {
                return null;
            }

            if (min == null) {
                return cb.lessThanOrEqualTo(root.<Double>get("price"), max);
            }

            if (max == null) {
                return cb.greaterThanOrEqualTo(root.<Double>get("price"), min);
            }

            return cb.between(root.<Double>get("price"), min, max);
        };
    }

    public static Specification<Product> hasNameOrDescriptionLike(String keyword) {
        return (root, query, cb) -> {
            if (keyword == null || keyword.trim().isEmpty()) {
                return null;
            }

            String searchKeyword = "%" + keyword.trim().toLowerCase() + "%";

            return cb.or(
                    cb.like(cb.lower(root.get("name")), searchKeyword),
                    cb.like(cb.lower(root.get("description")), searchKeyword)
            );
        };
    }

    public static Specification<Product> ratingGreaterThan(Double ratings) {
        return (root, query, cb) -> {
            if (ratings == null) {
                return null;
            }

            return cb.greaterThanOrEqualTo(
                    root.<Double>get("ratings"), ratings
            );
        };
    }
}

