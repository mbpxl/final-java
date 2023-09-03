package crook;

import Assortment.Assortment;
import Toy.Toy;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Работа со списком призов
 */
public class Crook {
    /**
     * @param prizesList список призов для розыгрыша
     */
    public static ArrayList<Toy> prizesList = new ArrayList<Toy>(); // список для розыгрыша


    /**
     * Метод формирует список призов по заданным типам игрушек в соответствии с их весом (частотой выпадания)
     *
     * @param prizesCount длина списка призов
     * @param cat_1 первый тип призов
     * @param cat_2 второй тип призов
     * @param cat_3 третий тип призов
     * @return
     */
    public static ArrayList<Toy> createListOfPrizes(int prizesCount, String cat_1, String cat_2, String cat_3) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Toy> cat_1_list = new ArrayList<>();
        ArrayList<Toy> cat_2_list = new ArrayList<>();
        ArrayList<Toy> cat_3_list = new ArrayList<>();
        ArrayList<Toy> all_list = new ArrayList<>();
        int pos;
        // получаем количество игрушек данного типа исходя из длины общего призового списка и
        // веса игрушек данного типа
        cat_1_list = thisTypeArray(Toy.toysList, cat_1); // отбор игрушек по типу cat_1
        int cat_1_count = prizesCount * cat_1_list.get(0).frequency / 100;
        Random random = new Random();
        for (int i = 0; i < cat_1_count; i++) {
            if (cat_1_list.size() > 1) {
                pos = random.nextInt(cat_1_list.size());
            }
            else {
                pos = 0;
            }
            all_list.add(cat_1_list.get(pos));
        }
        cat_2_list = thisTypeArray(Toy.toysList, cat_2); // отбор игрушек по типу cat_2
        int cat_2_count = prizesCount * cat_2_list.get(0).frequency / 100;
        Random random2 = new Random();
        for (int i = 0; i < cat_2_count; i++) {
            if (cat_2_list.size() > 1) {
                pos = random2.nextInt(cat_2_list.size());
            }
            else {
                pos = 0;
            }
            all_list.add(cat_2_list.get(pos));
        }
        cat_3_list = thisTypeArray(Toy.toysList, cat_3); // // отбор игрушек по типу cat_3
        int cat_3_count = prizesCount * cat_3_list.get(0).frequency / 100;
        for (int i = 0; i < cat_3_count; i++) {
            if (cat_3_list.size() > 1) {
                pos = random2.nextInt(cat_3_list.size());
            }
            else {
                pos = 0;
            }
            all_list.add(cat_3_list.get(pos));
        }
        prizesList = shuffleList(all_list);
        return prizesList;
    }

    /**
     * Метод отфильтровывает нужный тип игрушек из общего ассортимента (списка игрушек) и возвращает
     * массив игрушек одного типа
     * @param cat
     * @return
     */
    public static ArrayList<Toy> thisTypeArray(ArrayList<Toy> arr, String cat) {
        ArrayList<Toy> toysThisType = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).toyType.equals(cat)) {
                toysThisType.add(arr.get(i));
            }
        }
        return toysThisType;
    }

    /**
     * Вывод в консоль массива игрушек
     * @param arr - любой ArrayList<Toy>
     */
    public static void printArr(ArrayList<Toy> arr) {
        for (Toy toy : arr) {
            System.out.println(toy);
        }
    }

    /**
     * Метод визуализации розыгрыша призов и сохранения результатов тиража в файл
     * @param arr
     */
    public static void Get(ArrayList<Toy> arr) throws Exception {
        int randPosition = 0;
        int counter = 0;
        String strToFile = "";
        String pause = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("!!!!!!!!!!!!!!!! Розыгрыш призов начинается !!!!!!!!!!!!!!!!!!!!!");
        System.out.println();
        System.out.println("Список призов:");
        printArr(prizesList);
        System.out.println();
        while (arr.size() > 0) {
            if (arr.size() == 1) {
                counter++;
                System.out.println("шаг " + counter);
                System.out.print("Вы получаете следующий приз:  ");
                System.out.println("артикул " + arr.get(0).id + ". " + arr.get(0).toyType + " " + arr.get(0).note);
                strToFile += "шаг " + counter + ": ";
                strToFile += "артикул " + arr.get(0).id + ". " + arr.get(0).toyType + " " + arr.get(0).note;
                strToFile += "\n";
                arr.remove(0);
                System.out.println("Для продолжения нажмите клавишу \"Enter\" ");
                pause = scanner.nextLine();
            }
            else {
                counter++;
                System.out.println("шаг " + counter);
                System.out.print("Вы получаете следующий приз:  ");
                System.out.println("артикул " + arr.get(0).id + ". " + arr.get(0).toyType + " " +arr.get(0).note);
                strToFile += "шаг " + counter + ": ";
                strToFile += "артикул " + arr.get(0).id + ". " + arr.get(0).toyType + " " + arr.get(0).note;
                strToFile += "\n";
                arr.remove(0);
                System.out.println("Для продолжения нажмите клавишу \"Enter\" ");
                pause = scanner.nextLine();
            }
        }
            Assortment.drowingToFile("results.txt", strToFile);
    }

    /**
     * Метод "перемешивания" призов в списке призов для розыгрыша
     * @param arr_in
     * @return
     */
    public static ArrayList<Toy> shuffleList(ArrayList<Toy> arr_in) {
        ArrayList<Toy> arr_out = new ArrayList<>();
        int randPosition = 0;
        Random random = new Random();
        while (arr_in.size() > 0) {
            if (arr_in.size() == 1) {
                arr_out.add(arr_in.get(0));
                arr_in.remove(0);
            }
            else {
                randPosition = random.nextInt(0,arr_in.size());
                arr_out.add(arr_in.get(randPosition));
                arr_in.remove(randPosition);
            }
        }
        return arr_out;
    }
}
