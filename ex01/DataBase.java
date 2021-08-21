package ex01;

import java.util.Scanner;
import java.io.*;

public class DataBase implements Serializable // реализовываем интерфейс, чтобы разрешить серилизацию объектов класса DataBase
{
    private String      firstName;
    private String      nickName;
    private String      phoneNumber;
    private int         index;

    public void addInfo(int index)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\nВведите имя: ");
        this.firstName = in.nextLine();
        System.out.print("\nВведите никнейм: ");
        this.nickName = in.nextLine();
        System.out.print("\nВведите номер телефона: ");
        this.phoneNumber = in.nextLine();
        this.index = index + 1;
//        if (SomeFunctionWithPattern())
//            System.exit(-1);
    }

    public String getInfo()
    {
        if (this.nickName.length() > 10)
            return ("| " + this.index + " | " + this.nickName.substring(0, 10) + "...|");
        return ("| " + this.index + " | " + this.nickName + " |");
    }

    public String toString() // Переопределяем метод toString дял вывода полной информации  контакте
    {
        return ("\nName: " + this.firstName +
                "\nNickname: " + this.nickName +
                "\nPhone number: " + this.phoneNumber);
    }
}

