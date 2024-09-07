package com.hms.demo.Service;

import com.hms.demo.Repository.BillRepository;
import com.hms.demo.models.Bill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;
    public static final Logger logger = LoggerFactory.getLogger(BillService.class);

    public List<Bill> getBills() {
        try {
            List<Bill> bills = new ArrayList<Bill>();
            return billRepository.findAll();
        }
        catch (Exception e) {
            System.out.println("Error in getBills" + e.getMessage());
            logger.error("Error in getBills" + e.getMessage());
            return null;
        }
    }
    public Bill getBill(int id) {
        try {
            Optional<Bill> bill = billRepository.findById(id);
            return bill.orElse(null);
        }
        catch (Exception e) {
            System.out.println("Error in getBill" + e.getMessage());
            logger.error("Error in getBill" + e.getMessage());
            return null;
        }
    }

    public Bill createBill(Bill bill) {
        try {
            billRepository.save(bill);
            return bill;
        }
        catch (Exception e) {
            System.out.println("Error in createBill" + e.getMessage());
            logger.error("Error in createBill" + e.getMessage());
            return null;
        }
    }

    public void deleteBillById(int id) {
        try{
            logger.info("Deleting bill by id: " + id);
            billRepository.deleteById(id);
        }
        catch (Exception e) {
            System.out.println("Error in deleteBillById" + e.getMessage());
            logger.error("Error in deleteBillById" + e.getMessage());
        }
    }

    public Bill updateBillById(Bill bill, int id) {
        try{
            Optional<Bill> existingbill = billRepository.findById(id);
            if(existingbill.isPresent()){
                Bill b = existingbill.get();
                b.setId(bill.getId());
                b.setAmount(bill.getAmount());
                b.setStatus(bill.getStatus());
                b.setPatiendId(bill.getPatiendId());
                billRepository.save(b);
                return b;
            }
            else{
                logger.error("Error in updateBillById" + id);
                return null;
            }
        }
        catch (Exception e) {
            System.out.println("Error in updateBillById" + e.getMessage());
            logger.error("Error in updateBillById" + e.getMessage());
            return null;
        }
    }
}
