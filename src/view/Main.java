package view;

import controller.ProductManager;
import model.Product;
import storage.ReadWriteFile;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

import static storage.ReadWriteFile.readFile;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            System.out.println("-----Menu-----");
            System.out.println("1. Add Product");
            System.out.println("2. Show Product");
            System.out.println("3. Find Product");
            System.out.println("0. Exit ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    Product newProduct = creatNewProduct(scanner);
                    ProductManager.addNewProduct(newProduct);
                    break;
                case 2:
                    ProductManager.showProduct();
                    break;
                case 3:
                    System.out.println("Nhap ma san pham can tim");
                    String id = scanner.nextLine();
                    ProductManager.findProduct(id);
                break;
                case 0:
                    System.out.println("Chuong trinh ket thuc");
                    break;
                default:
                    System.out.println("Nhap sai roi nhap lai di!");
                    break;
            }
        } while(choice != 0);
    }

    public static Product creatNewProduct(Scanner scanner) {
        List<Product> list = readFile();
        System.out.println(list);
//        Scanner scanner = new Scanner(System.in);
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
}
