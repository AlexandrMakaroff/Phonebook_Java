package ex01;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;
import java.io.EOFException;

public class Phonebook
{
    public static int getIter(DataBase contacts[])
    {
        int i = 0;
        while (i < 8 && contacts[i] != null)
            i++;
        return i;
    }
    public static void funcSearch(DataBase contacts[])
    {
        int idx;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n------Выберите интересующий никнейм по id или нажмите ноль------");
        System.out.println("  ID  NICK");
        if (contacts[0] == null)
        {
            System.out.println("*Список пуст*");
            return;
        }
        for (int j = 0; j < 8; j++)
        {
            if (contacts[j] == null)
                break;
            System.out.println(contacts[j].getInfo());
        }
        try // Обрабатыевам невалидные значения
        {
            idx = sc.nextInt();
            if (idx == 0)
                return;
            else if (--idx < 0 || idx > 7 || contacts[idx] == null)
                System.out.println("*Контакта с таким индексом не существует*");
            else
               System.out.println(contacts[idx]);
        }
        catch (InputMismatchException e)
        {
            System.out.println("*Ожидалось число*");
        }
    }
    
    public static void funcAdd(DataBase contacts[], int i) {
        contacts[i %= 8] = new DataBase();
        contacts[i].addInfo(i);
    }
    
    public static void main(String[] args) {
        DataBase[]  contacts = ReadObject.Deserial();
        int         i = getIter(contacts);
        Scanner     in = new Scanner(System.in);
        String      string;

        while (true) {
            System.out.println("\n -----------------------------------");
            System.out.println("| ADD     -   добавить контакт      |");
            System.out.println("| SEARCH  -   найти контакт контакт |");
            System.out.println("| EXIT    -   выйти                 |");
            System.out.println("\\__________________________________/\n");
            string = in.nextLine();

            if (string.equals("ADD")) {
                funcAdd(contacts, i++);
                continue;
            }
            else if (string.equals("SEARCH"))
                funcSearch(contacts);
            else if (string.equals("EXIT")) {
                WriteObject.Serial(contacts);
                break;
            }
            else
                System.out.println("Incorrect command. Try again.");
        }
    }
}
