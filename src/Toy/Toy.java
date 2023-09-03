package Toy;

import java.util.ArrayList;

public class Toy {
    static int index = 0;
    public int id;
    public int frequency;
    public String toyType;
    public String note;
    public static ArrayList<Toy> toysList = new ArrayList<Toy>();
    public Toy(int frequency, String toyType, String note) {
        this.frequency = frequency;
        this.toyType = toyType;
        this.note = note;
        index++;
        this.id = index;
    }

    public void add() {
        int frequency = 0;
        String toyType = "";
        String note = "";
        Toy toy = new Toy(frequency, toyType, note);
        toysList.add(toy);
    }

    /**
     * Метод удаления игрушки из общего массива toysList
     * @param index индекс удаляемой игрушки
     */
    public static void delete(String index) {
        toysList.remove(Integer.parseInt(index));
    }

    /**
     * Метод поиска индекса игрушки с заданным значением поля id в массиве toysList
     * @param id - заданный id
     * @return index - индекс игрушки в массиве toysList
     */
    public static int findById(String id) {
        int index = -1;
        System.out.println("задан id = " + id);
        if (id.matches("[0-9]+")){
            for (int i = 0; i < toysList.size(); i++) {
                if (toysList.get(i).id == Integer.parseInt(id)) {
                    System.out.println("i: " + i + ", " + "тип " + toysList.get(i).toyType + ", примечание: " + toysList.get(i).note);
                    index = i;
                    break;
                }
            }
        }
        return index;
    }



    @Override
    public String toString() {
        String out = "id игрушки: " + this.id +
                ", вес: " + this.frequency +
                ", тип: " + this.toyType +
                ", примечание: " + this.note;
        return out;
    }
}
