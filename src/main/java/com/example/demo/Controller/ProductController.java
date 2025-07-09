package com.example.demo.Controller;

import com.example.demo.Entity.ProductEntity;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/showall")
    public ResponseEntity<?> getAll(@RequestParam (defaultValue = "0") int page,
                                      @RequestParam (defaultValue = "5")int size,
                                      @RequestParam (defaultValue = "price") String sortBy,
                                      @RequestParam (defaultValue = "true") boolean ascending
                                      )
    {
        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size,sort);


        Page<ProductEntity> productpage = service.getall(pageable);
        if (productpage.hasContent()){
            return new ResponseEntity<>(productpage , HttpStatus.OK);
        }
        return new ResponseEntity<>("not Found" , HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProduct (@RequestBody ProductEntity entity){
        ProductEntity saveProduct = service.saveAll(entity);
        return new ResponseEntity<>("Product Successfully Addde",HttpStatus.OK);

    }

    @GetMapping("/show/{name}")
    public ResponseEntity<?> ShowByName(@PathVariable String name){
        List<ProductEntity> products  = service.findByName(name);
        if (products .isEmpty()){
            return new ResponseEntity<>("No products found with name: " + name, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products ,HttpStatus.FOUND);
    }

    @GetMapping("/{id}")

    public ResponseEntity<?> findById(@PathVariable Integer Id){
        Optional<ProductEntity> products  = service.findById(Id);
        if (products .isEmpty()){
            return new ResponseEntity<>("No products found with Id: " + Id, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products ,HttpStatus.FOUND);
    }
}
