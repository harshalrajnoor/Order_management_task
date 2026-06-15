package com.harshal.orderManagement.repository;

import com.harshal.orderManagement.entity.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryItemsRepository extends JpaRepository<GroceryItem, Long> {
}
