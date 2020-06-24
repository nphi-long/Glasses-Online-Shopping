package sof302.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sof302.assignment.entities.Bill;
import sof302.assignment.entities.Product;
import sof302.assignment.repository.IBillRepository;

import java.util.List;

@Service
public class BillService implements IBillService{
    @Autowired
    IBillRepository billRepo;

    @Override
    public Bill findUserBillUnpaid(Integer uid, String status) {
        return billRepo.findByUserUidAndStatusEquals(uid,status);
    }

    @Override
    public void saveOrUpdate(Bill bill) {
        billRepo.save(bill);
    }
}
