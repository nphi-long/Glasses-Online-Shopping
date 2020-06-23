package sof302.assignment.service;

import sof302.assignment.entities.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Integer id);
}
