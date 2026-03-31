package com.sparta;

import com.sparta.pom.ProductDetailsPage;
import com.sparta.pom.ProductsPage;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SerenityJUnit5Extension.class)
public class ProductsTests {

    @Managed
    ProductsPage productsPage;



}