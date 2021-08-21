package ex01;

import java.io.*;

public class WriteObject
{
    public static void Serial(DataBase contacts[]) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("contacts.bin"))) {
            oos.writeObject(contacts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}