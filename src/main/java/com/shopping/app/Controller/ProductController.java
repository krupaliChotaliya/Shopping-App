package com.shopping.app.Controller;

import com.shopping.app.Service.ProductService;
import com.shopping.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
}
