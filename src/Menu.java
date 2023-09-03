import Assortment.Assortment;
import Toy.Toy;
import crook.Crook;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    /**
     * Вывод строки-приглашения
     */
    public static void startPrompt() {
        System.out.println();
        System.out.println("***************** ГЛАВНОЕ МЕНЮ **********************");
        String str = "Выберите нужное действие, введя с клавиатуры соответствующую цифру:  " + "\n";
        System.out.println();
        str += "1 - Редактировать список игрушек (добавить/удалить)" + "\n";
        str += "2 - Показать список игрушек в консоли" + "\n";
        str += "3 - Создать список призов (обязательный шаг перед началом тиража) " + "\n";
        str += "4 - Запустить тираж" + "\n";
        str += "клавиша 'Enter' - выйти из программы" + "\n";
        str += "Ваш выбор: ";
        System.out.print(str);
    }

    /**
     * Главное меню
     * @param arr список игрушек
     */
    public static void startMenu(ArrayList<Toy> arr) throws Exception {
        boolean getOut = false;
        String choice = "start";
        Scanner scanner = new Scanner(System.in);
        while (!getOut) {
            startPrompt();
            choice = scanner.nextLine();
            switch (choice) {
                case ("1"):
                    Assortment.assortmentMenu();
                    break;
                case ("2"):
                    Assortment.printToysList();
                    break;
                case ("3"):
                    Crook.createListOfPrizes(10, "конструктор", "робот", "кукла");
                    if (Crook.prizesList.size() != 0) {
                        System.out.println();
                        System.out.println("Список призов создан: ");
                        Crook.printArr(Crook.prizesList);
                    }
                    else {
                        System.out.println();
                        System.out.println("Список призов не создан: ");
                    }
                    break;
                case ("4"):
                    if (Crook.prizesList.size() != 0) {
                        System.out.println();
                        Crook.printArr(Crook.prizesList);
                        Crook.printArr(Crook.prizesList);
                        Crook.Get(Crook.prizesList);
                    }
                    else {
                        System.out.println();
                        System.out.println("Список призов не создан: ");
                    }
                    break;
                case (""):
                    getOut = true;
                    System.out.println("Ну, дело хозяйское, Вам виднее.");
                    System.out.println("До новых встреч!");
                    break;
                default:
                    System.out.println("Что-то пошло не так...");
            } // switch
        } // while
    }
}
