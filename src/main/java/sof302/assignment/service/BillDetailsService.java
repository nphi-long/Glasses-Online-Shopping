package sof302.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sof302.assignment.entities.Billdetails;
import sof302.assignment.repository.IBillDetailsRepository;
import sof302.assignment.repository.IBillRepository;

@Service
public class BillDetailsService implements IBillDetailsService{
    @Autowired
    IBillDetailsRepository billDetailsRepo;

    @Override
    public Billdetails findById(Billdetails.Pk pk) {
        return billDetailsRepo.findById(pk).get();
    }

    @Override
    public void saveOrUpdate(Billdetails billdetails) {
        billDetailsRepo.save(billdetails);
    }
}
