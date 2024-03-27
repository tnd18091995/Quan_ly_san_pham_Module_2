package Storage;

import Model.Product;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {

    public static final String PATHNAME = "product.txt";

    public static void writeFile(List<Product> Product){
        File a = new File(PATHNAME);
        try {
            OutputStream outputStream = new FileOutputStream(a);
            ObjectOutputStream oos =  new ObjectOutputStream(outputStream);
            oos.writeObject(Product);
            oos.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static List<Product> readFile(){
        File a = new File(PATHNAME);
        try {
            InputStream is = new FileInputStream(a);
            ObjectInputStream ois = new ObjectInputStream(is);
            Object object = ois.readObject();
            return (List<Product>) object;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
