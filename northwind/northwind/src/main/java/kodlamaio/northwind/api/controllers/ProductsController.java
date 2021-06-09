package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        super();
        this.productService = productService;
    }


    @GetMapping("/getall")
    public DataResult<List<Product>> get() {
        return this.productService.getAll();
    }

    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> ProductWithCategoryDetails() {
        return this.productService.getProductWithCategoryDetails();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product) {
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName) {
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategory")
    public DataResult<Product>
    getByProductNameAndCategory(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId) {
        return this.productService.getByProductNameAndCategory(productName, categoryId);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        return this.productService.getAll(pageNo, pageSize);
    }

    @GetMapping("/getAllSortDESC")
    public DataResult<List<Product>> getAllSorted() {
        return this.productService.getAllSorted();
    }

}