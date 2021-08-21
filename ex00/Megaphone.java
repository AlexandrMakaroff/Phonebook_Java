public class Megaphone
{
    public static void main(String[] args)
    {
        if (args.length != 1)
            System.out.println("* LOUD AND UNBEARABLE FEEDBACK NOISE *");
        else
            System.out.println(args[0].toUpperCase());
    }
}