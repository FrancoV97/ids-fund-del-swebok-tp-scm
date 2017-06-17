/*
 * Copyright 2004-2010 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package sample.web.product;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sample.service.ItemService;
import sample.service.ProductService;

@Controller
@RequestMapping("/product")
@Transactional
public class ProductController {

    private ProductService productService;

    private ItemService itemService;

    public ProductController(ProductService productService,
            ItemService itemService) {
        this.productService = productService;
        this.itemService = itemService;
    }

    @GetMapping("/{productId}")
    public String product(@PathVariable String productId,
            Model model) {
        model.addAttribute("product", productService.getProduct(productId));
        model.addAttribute("itemList", itemService.getItemsByProduct(productId));
        return "product/list";
    }

}
