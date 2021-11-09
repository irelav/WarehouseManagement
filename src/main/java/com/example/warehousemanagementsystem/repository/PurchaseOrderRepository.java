package com.example.warehousemanagementsystem.repository;

import com.example.warehousemanagementsystem.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
    Optional<PurchaseOrder> findByStatus(String status);

    Optional<PurchaseOrder> findByPoNumber(String poNumber);

    List<PurchaseOrder> deleteByPoNumber(String poNumber);
}
