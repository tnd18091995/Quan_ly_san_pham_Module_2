package controller;

import model.Product;
import storage.ReadWriteFile;

import java.util.List;

public class ProductManager {
    private static List<Product> productsList = ReadWriteFile.readFile();

    public static void addNewProduct(Product product) {
        productsList.add(product);
        ReadWriteFile.writeFile(productsList);
    }
    public static void showProduct(){
        if(productsList.isEmpty()){
            System.out.println("Khong Co San Pham Nao!");
        }
        for(Product product: productsList){
            System.out.println(product);
        }
    }
    public static void findProduct(String id){
        for(Product product: productsList){
            if(product.getId().equals(id)){
                System.out.println(product);
            }
        }
    }
}