package com.shopping.inventory.controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.inventory.model.Product;
import com.shopping.inventory.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> getProducts() {
		return productService.getProducts();
	}

	@PostMapping("/add")
	public Product addProducts(Product product) {
		return productService.saveProduct(product);
	}

	@SuppressWarnings("deprecation")
	@GetMapping("/add")
	public List<Product> addProduct() {
		String csvFile = "./products.csv";

//        try (Stream<String> lines = Files.lines(Paths.get(csvFile))) {
//            lines.skip(1) // Skip header row if present
//                 .map(line -> line.split(","))
//                 .forEach(values -> System.out.println("Column 1: " + values[0] + ", Column 2: " + values[1]));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//		String line = "";
//        String delimiter = ",";
//
//        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
//            while ((line = br.readLine()) != null) {
//                // Split the line using the delimiter
//                String[] values = line.split(delimiter);
//                System.out.println("Column 1: " + values[0] + ", Column 2: " + values[1]);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//		"product_name",	"product_category_tree", "retail_price",	"discounted_price",	"image",	"description",	"brand"	,"product",_"specifications"

		List<Product> products = new ArrayList<>();
		boolean isFirst = true;
		int counter = 0;
		Product product;
		try (Reader reader = new FileReader(csvFile);
				CSVParser csvParser = new CSVParser(reader,
						CSVFormat.DEFAULT.withHeader("product_name", "product_category_tree", "retail_price",
								"discounted_price", "image", "description", "brand", "product_specifications"))) {
			for (CSVRecord csvRecord : csvParser) {
				if (isFirst) {
					isFirst = false;
					continue;
				}
				
				if (counter > 5) {
					break;
				}
				// Accessing values by header name
				String product_name = csvRecord.get("product_name").trim();
				String product_category_tree = csvRecord.get("product_category_tree").trim();
				String retail_price = csvRecord.get("retail_price");
				String discounted_price = csvRecord.get("discounted_price").trim();
				String image = csvRecord.get("image").trim();
				String description = csvRecord.get("description").trim();
				String brand = csvRecord.get("brand").trim();
				String product_specifications = csvRecord.get("product_specifications").trim();
				product = Product.builder().name(product_name).brand(brand).category(product_category_tree)
						.price(retail_price).description(description).discountedPrice(discounted_price).image(image)
						.specifications(product_specifications).build();
				products.add(product);
				counter++;
			}
			
			productService.saveProducts(products);
		} catch (IOException e) {
			System.out.println("counter ## " + counter);
			e.printStackTrace();
		}
		return products;
	}

}
