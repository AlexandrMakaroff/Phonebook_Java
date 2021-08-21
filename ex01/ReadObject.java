package ex01;

import java.io.*;

public class ReadObject
{
    public static DataBase[] Deserial() {
        DataBase [] contacts = new DataBase[8];
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("contacts.bin"))) { // Такая конструкция
            contacts = (DataBase[]) ois.readObject();                                              // позволяет нам не
        } catch (IOException e) {                                                                  // закрывать файл вручную
            contacts = new DataBase[8];
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return contacts;
    }
}