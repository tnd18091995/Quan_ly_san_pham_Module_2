package View;

import Model.Product;
import Controller.ProductManager;
import Storage.ReadWriteFile;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static Storage.ReadWriteFile.readFile;

public class Main {
    private static Storage.ReadWriteFile ReadWriteFile;
    private static List<Product> list;

    static {
            list = readFile();
    }

    public static void main(String[] args) {
        System.out.println(list);
        Product newP = createNewProduct();
        ProductManager.addNewProduct(newP);
        System.out.println(list);
    }

    public static Product createNewProduct() {
        List<Product> list = readFile();
        System.out.println(list);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ID san pham ID= ");
        String id = scanner.nextLine();
        System.out.println("Nhap ten san pham NAME= ");
        String name = scanner.nextLine();
        System.out.println("Nhap gia san pham PRICE= ");
        double price = scanner.nextDouble();
        System.out.println("Nhap hang san pham COMPANY= ");
        String company = scanner.nextLine();
        System.out.println("Nhap mo ta san pham DESCRIPTION= ");
        String description = scanner.nextLine();
        return new Product(id,name,price,company,description);
    }

    public static void setReadWriteFile(Storage.ReadWriteFile readWriteFile) {
        ReadWriteFile = readWriteFile;
    }
}
