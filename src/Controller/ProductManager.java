package Controller;

import Model.Product;
import Storage.ReadWriteFile;

import java.util.List;

public class ProductManager {
    private static List<Product> productsList = ReadWriteFile.readFile();

    public static void addNewProduct(Product product) {
        productsList.add(product);
        ReadWriteFile.writeFile(productsList);
    }
}