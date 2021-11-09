package com.example.warehousemanagementsystem.model;

import javax.persistence.*;

@Entity
@Table(name = "purchase_order")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "po_number")
    private String poNumber;

    @Column(name = "status")
    private String status;

    @Column(name = "vendor")
    private String vendor;

    @Column(name = "po_type")
    private String poType;

    @Column(name = "po_reference_nbr")
    private String poReferenceNbr;

    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "ship_date")
    private String shipDate;

    @Column(name = "cancel_date")
    private String cancelDate;

    @Column(name = "delivery_date")
    private String deliveryDate;

    @Column(name = "dept_code")
    private String deptCode;

    @Column(name = "lock")
    private String lock;

    @Column(name = "customer_nbr")
    private String customerNbr;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_address")
    private String customerAddress;

    @Column(name = "customer_address2")
    private String customerAddress2;

    @Column(name = "customer_address3")
    private String customerAddress3;

    @Column(name = "rma_nbr")
    private String rmaNbr;

    public PurchaseOrder() {
    }

    public PurchaseOrder(String poNumber, String status, String vendor, String poType, String poReferenceNbr, String orderDate, String shipDate, String cancelDate, String deliveryDate, String deptCode, String lock, String customerNbr, String customerName, String customerAddress, String customerAddress2, String customerAddress3, String rmaNbr) {
        this.poNumber = poNumber;
        this.status = status;
        this.vendor = vendor;
        this.poType = poType;
        this.poReferenceNbr = poReferenceNbr;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.cancelDate = cancelDate;
        this.deliveryDate = deliveryDate;
        this.deptCode = deptCode;
        this.lock = lock;
        this.customerNbr = customerNbr;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerAddress2 = customerAddress2;
        this.customerAddress3 = customerAddress3;
        this.rmaNbr = rmaNbr;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setPoType(String poType) {
        this.poType = poType;
    }

    public void setPoReferenceNbr(String poReferenceNbr) {
        this.poReferenceNbr = poReferenceNbr;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public void setCancelDate(String cancelDate) {
        this.cancelDate = cancelDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public void setLock(String lock) {
        this.lock = lock;
    }

    public void setCustomerNbr(String customerNbr) {
        this.customerNbr = customerNbr;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setCustomerAddress2(String customerAddress2) {
        this.customerAddress2 = customerAddress2;
    }

    public void setCustomerAddress3(String customerAddress3) {
        this.customerAddress3 = customerAddress3;
    }

    public void setRmaNbr(String rmaNbr) {
        this.rmaNbr = rmaNbr;
    }

    public long getId() {
        return id;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public String getStatus() {
        return status;
    }

    public String getVendor() {
        return vendor;
    }

    public String getPoType() {
        return poType;
    }

    public String getPoReferenceNbr() {
        return poReferenceNbr;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getShipDate() {
        return shipDate;
    }

    public String getCancelDate() {
        return cancelDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public String getLock() {
        return lock;
    }

    public String getCustomerNbr() {
        return customerNbr;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerAddress2() {
        return customerAddress2;
    }

    public String getCustomerAddress3() {
        return customerAddress3;
    }

    public String getRmaNbr() {
        return rmaNbr;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "id=" + id +
                ", poNumber='" + poNumber + '\'' +
                ", status='" + status + '\'' +
                ", vendor='" + vendor + '\'' +
                ", poType='" + poType + '\'' +
                ", poReferenceNbr='" + poReferenceNbr + '\'' +
                ", orderDate=" + orderDate +
                ", shipDate=" + shipDate +
                ", cancelDate=" + cancelDate +
                ", deliveryDate=" + deliveryDate +
                ", deptCode='" + deptCode + '\'' +
                ", lock='" + lock + '\'' +
                ", customerNbr='" + customerNbr + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerAddress2='" + customerAddress2 + '\'' +
                ", customerAddress3='" + customerAddress3 + '\'' +
                ", rmaNbr='" + rmaNbr + '\'' +
                '}';
    }
}
