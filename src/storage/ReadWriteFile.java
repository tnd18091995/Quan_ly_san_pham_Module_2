package storage;

import model.Product;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {

    public static final String PATHNAME = "product.txt";

    public static void writeFile(List<Product> products){
        File file = new File(PATHNAME);
        try {
            OutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream oos =  new ObjectOutputStream(outputStream);
            oos.writeObject(products);
            oos.close();
            outputStream.close();
            oos.writeObject(products);
        } catch (IOException e) {
            System.out.println("loi ghi file" + e.getMessage());
        }
    }
    public static List<Product> readFile(){
        File file = new File(PATHNAME);
        if (!file.exists()) {
            return getProduct();
        }
        try {
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            Object object = ois.readObject();
            return (List<Product>) object;
        } catch (FileNotFoundException e) {
            System.out.println("Loi doc file" + e.getMessage());
            return getProduct();
        } catch (IOException e) {
            System.out.println("Loi doc file" + e.getMessage());
            return getProduct();
        } catch (ClassNotFoundException e) {
            System.out.println("Loi doc file" + e.getMessage());
            return getProduct();
        }
    }
    private static List<Product> getProduct(){
        List<Product> listProduct = new ArrayList<>();
        listProduct.add(new Product("01", "Khoa Ga",100,"Codegym","Di hoc muon"));
        listProduct.add(new Product("02", "Quan",1000,"Codegym","future professional"));
        listProduct.add(new Product("03", "Hieu",9000,"Codegym","badboy"));
        writeFile(listProduct);
        return listProduct;
    }
}
