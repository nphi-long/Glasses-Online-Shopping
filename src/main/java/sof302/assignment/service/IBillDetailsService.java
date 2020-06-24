package sof302.assignment.service;

import sof302.assignment.entities.Billdetails;

public interface IBillDetailsService {
    Billdetails findById(Billdetails.Pk pk);
    void saveOrUpdate(Billdetails billdetails);
}
