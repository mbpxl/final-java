import java.util.ArrayList;

public class tTest {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("первый");
        arr.add("второй");
        arr.add("третий");
        arr.add("четвертый");
        System.out.println(arr);
        arr.remove(2);
        System.out.println("Хер с ним, с третьим... Удаляем!");
        System.out.println(arr);
    }


}
