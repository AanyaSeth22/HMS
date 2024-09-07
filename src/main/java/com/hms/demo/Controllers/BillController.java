package com.hms.demo.Controllers;

import com.hms.demo.models.Bill;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bills")
public class BillController {

    @GetMapping
    public List<Bill> getAllBills() {
        List<Bill> bills = new ArrayList<Bill>();
        return bills;
    }

    @PostMapping
    public void createBill(@RequestBody Bill bill) {
        System.out.println("creating");
    }

    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable int id) {
        Bill bill = new Bill();
        bill.setId(id);
        return bill;
    }
    @DeleteMapping("/{id}")
    public void deleteBillById(@PathVariable int id) {
        System.out.println("delete");
    }

    @PostMapping("/{id}")
    public void updateBillById(@PathVariable int id, @RequestBody Bill bill) {
        System.out.println("update");
    }
}
