import Assortment.Assortment;
import Toy.Toy;

public class Main {
    public static void main(String[] args) throws Exception {

        Assortment.fromFile("toys.txt");
        Assortment.toFile("toys.bak");
        Menu.startMenu(Toy.toysList);
        Assortment.toFile("toys.txt");
    }
}