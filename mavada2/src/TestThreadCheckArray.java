import java.util.ArrayList;
import java.util.Scanner;

public class TestThreadCheckArray {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            Thread thread1, thread2;
            System.out.println("Enter array size");
            int num = input.nextInt();
            
            ArrayList<Integer> array = new ArrayList<Integer>();
            System.out.println("Enter numbers for array");

            for (int index = 0; index < num; index++)
                array.add(input.nextInt());

            System.out.println("Enter number");
            num = input.nextInt();

            SharedData sd = new SharedData(array, num);

            thread1 = new Thread(new ThreadCheckArray(sd), "thread1");
            thread2 = new Thread(new ThreadCheckArray(sd), "thread2");
            thread1.start();
            thread2.start();
            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!sd.getFlag()) {
                System.out.println("Sorry");
                return;
            }

            System.out.println("Solution for b : " + sd.getB() + ", n = " + sd.getArray().size());
            System.out.print("I:    ");
            for (int index = 0; index < sd.getArray().size(); index++)
                System.out.print(index + "    ");
            System.out.println();

            System.out.print("A:    ");
            for (int val : sd.getArray()) {
                System.out.print(val);
                int counter = 5;
                int temp = val;
                while (true) {
                    temp = temp / 10;
                    counter--;
                    if (temp == 0)
                        break;
                }
                for (int i = 0; i < counter; i++)
                    System.out.print(" ");
            }

            System.out.println();
            System.out.print("C:    ");
            boolean first = true;
            String sumString = "";
            for (int i = 0; i < sd.getWinArray().length; i++) {
                if (sd.getWinArray()[i]) {
                    System.out.print("1    ");
                    if (!first) sumString += "+";
                    sumString += sd.getArray().get(i);
                    first = false;
                } else
                    System.out.print("0    ");
            }

            System.out.println();
            System.out.println(sumString + "=" + sd.getB());
        }
    }
}