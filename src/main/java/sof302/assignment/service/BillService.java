package sof302.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sof302.assignment.repository.IBillRepository;

@Service
public class BillService implements IBillService{
    @Autowired
    IBillRepository billRepo;

    @Override
    public void deleteUserDontLoginBill() {
        billRepo.deleteBill();
    }
}
