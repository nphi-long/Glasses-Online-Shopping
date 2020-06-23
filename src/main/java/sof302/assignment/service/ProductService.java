package sof302.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sof302.assignment.entities.Product;
import sof302.assignment.repository.IProductRepository;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    IProductRepository productRepo;
    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepo.findById(id).get();
    }
}
