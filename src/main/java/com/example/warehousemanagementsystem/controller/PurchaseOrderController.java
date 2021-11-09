package com.example.warehousemanagementsystem.controller;

import com.example.warehousemanagementsystem.model.PurchaseOrder;
import com.example.warehousemanagementsystem.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PurchaseOrderController {

    @Autowired
    PurchaseOrderService purchaseOrderService;

    //purchase orders list
    @GetMapping("/purchaseorder")
    public ResponseEntity<List<PurchaseOrder>> getAllPurchaseOrders() {
        return purchaseOrderService.fetchPurchaseOrders();
    }

    //purchase order with specific poNumber
    @GetMapping("/purchaseorder?poNumber={poNumber}")
    public ResponseEntity<PurchaseOrder> getPurchaseOrderByPoNumber(@RequestParam(value = "poNumber") String poNumber) {
        return purchaseOrderService.fetchPurchaseOrderByPoNumber(poNumber);
    }

    //purchase order list with specific status
    @GetMapping("/purchaseorder?status={status}")
    public ResponseEntity<Optional<PurchaseOrder>> getPurchaseOrderByStatus(@RequestParam(value = "status") String status) {
        return purchaseOrderService.fetchPurchaseOrdersByStatus(status);
    }

    //add purchase order
    @PostMapping("/purchaseorder")
    public ResponseEntity<PurchaseOrder> createPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
        return purchaseOrderService.createPurchaseOrder(purchaseOrder);
    }

    //edit purchase order
    @PutMapping("/purchaseorder/{poNumber}")
    public ResponseEntity<PurchaseOrder> updatePurchaseOrder(@PathVariable("poNumber") String poNumber, @RequestBody PurchaseOrder purchaseOrder) {
        return purchaseOrderService.updatePurchaseOrder(poNumber, purchaseOrder);
    }

    //delete purchase order
    @DeleteMapping("/purchaseorder/{poNumber}")
    public ResponseEntity<HttpStatus> deletePurchaseOrder(@PathVariable("poNumber") String poNumber) {
        return purchaseOrderService.deletePurchaseOrderFromDatabase(poNumber);
    }

}
