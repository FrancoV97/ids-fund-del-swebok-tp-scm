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
package sample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.dao.ProductDao;
import sample.entity.Product;

@Service
public class ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Product getProduct(String productId) {
        return productDao.selectProduct(productId);
    }

    public List<Product> getProductListByCategory(String categoryId) {
        return productDao.selectProductsByCategory(categoryId,
                SelectOptions.get());
    }

    public List<Product> searchProductList(String keywords) {
        List<String> keywordList = new ArrayList<String>();
        for (StringTokenizer tokenizer = new StringTokenizer(
                keywords.toLowerCase(), " ", false); tokenizer.hasMoreTokens();) {
            keywordList.add(tokenizer.nextToken());
        }
        return productDao.selectProductList(keywordList, SelectOptions.get());
    }

}