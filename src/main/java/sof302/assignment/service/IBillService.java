package sof302.assignment.service;

import sof302.assignment.entities.Bill;
import sof302.assignment.entities.Product;

import java.util.List;

public interface IBillService {
    void saveOrUpdate(Bill bill);
}
