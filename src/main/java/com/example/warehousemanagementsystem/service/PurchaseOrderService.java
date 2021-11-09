package com.example.warehousemanagementsystem.service;

import com.example.warehousemanagementsystem.model.PurchaseOrder;
import com.example.warehousemanagementsystem.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderService {

    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;

    public ResponseEntity<List<PurchaseOrder>> fetchPurchaseOrders() {
        List<PurchaseOrder> purchaseOrders = purchaseOrderRepository.findAll();

        try {
            if (purchaseOrders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(purchaseOrders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<PurchaseOrder> fetchPurchaseOrderByPoNumber(String poNumber) {
        Optional<PurchaseOrder> purchaseOrderData = purchaseOrderRepository.findByPoNumber(poNumber);

        if (purchaseOrderData.isPresent()) {
            return new ResponseEntity<>(purchaseOrderData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Optional<PurchaseOrder>> fetchPurchaseOrdersByStatus(String status) {
        Optional<PurchaseOrder> purchaseOrderData = purchaseOrderRepository.findByStatus(status);

        try {
            if (purchaseOrderData.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(purchaseOrderData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<PurchaseOrder> createPurchaseOrder(PurchaseOrder purchaseOrder) {
        try {
            PurchaseOrder purchaseOrder1 = purchaseOrderRepository
                    .save(new PurchaseOrder(purchaseOrder.getPoNumber(), purchaseOrder.getStatus(),
                            purchaseOrder.getVendor(), purchaseOrder.getPoType(), purchaseOrder.getPoReferenceNbr(),
                            purchaseOrder.getOrderDate(), purchaseOrder.getShipDate(), purchaseOrder.getCancelDate(),
                            purchaseOrder.getDeliveryDate(), purchaseOrder.getDeptCode(), purchaseOrder.getLock(),
                            purchaseOrder.getCustomerNbr(), purchaseOrder.getCustomerName(), purchaseOrder.getCustomerAddress(),
                            purchaseOrder.getCustomerAddress2(), purchaseOrder.getCustomerAddress3(), purchaseOrder.getRmaNbr()));
            System.out.println("Saved to database: " + purchaseOrder1);
            return new ResponseEntity<>(purchaseOrder1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<PurchaseOrder> updatePurchaseOrder(String poNumber, PurchaseOrder purchaseOrder) {
        Optional<PurchaseOrder> purchaseOrderData = purchaseOrderRepository.findByPoNumber(poNumber);

        if (purchaseOrderData.isPresent()) {
            PurchaseOrder purchaseOrder1 = purchaseOrderData.get();
            purchaseOrder1.setId(purchaseOrder.getId());
            purchaseOrder1.setPoNumber(purchaseOrder.getPoNumber());
            purchaseOrder1.setStatus(purchaseOrder.getStatus());
            purchaseOrder1.setVendor(purchaseOrder.getVendor());
            purchaseOrder1.setPoType(purchaseOrder.getPoType());
            purchaseOrder1.setPoReferenceNbr(purchaseOrder.getPoReferenceNbr());
            purchaseOrder1.setOrderDate(purchaseOrder.getOrderDate());
            purchaseOrder1.setShipDate(purchaseOrder.getShipDate());
            purchaseOrder1.setCancelDate(purchaseOrder.getCancelDate());
            purchaseOrder1.setDeliveryDate(purchaseOrder.getDeliveryDate());
            purchaseOrder1.setDeptCode(purchaseOrder.getDeptCode());
            purchaseOrder1.setLock(purchaseOrder.getLock());
            purchaseOrder1.setCustomerNbr(purchaseOrder.getCustomerNbr());
            purchaseOrder1.setCustomerName(purchaseOrder.getCustomerName());
            purchaseOrder1.setCustomerAddress(purchaseOrder.getCustomerAddress());
            purchaseOrder1.setCustomerAddress2(purchaseOrder.getCustomerAddress2());
            purchaseOrder1.setCustomerAddress3(purchaseOrder.getCustomerAddress3());
            purchaseOrder1.setRmaNbr(purchaseOrder.getRmaNbr());
            return new ResponseEntity<>(purchaseOrderRepository.save(purchaseOrder1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> deletePurchaseOrderFromDatabase(String poNumber) {
        try {
            purchaseOrderRepository.deleteByPoNumber(poNumber);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
