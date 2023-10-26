import java.util.ArrayList;
import java.util.Random;

public class SortComparison {

    // MergeSort
    public static void mergeSort(ArrayList<Integer> list) {
        if (list.size() <= 1) {
            return;
        }

        ArrayList<Integer> left = new ArrayList<>(list.subList(0, list.size() / 2));
        ArrayList<Integer> right = new ArrayList<>(list.subList(list.size() / 2, list.size()));

        mergeSort(left);
        mergeSort(right);

        merge(list, left, right);
    }

    private static void merge(ArrayList<Integer> list, ArrayList<Integer> left, ArrayList<Integer> right) {
        list.clear();
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                list.add(left.get(leftIndex++));
            } else {
                list.add(right.get(rightIndex++));
            }
        }

        while (leftIndex < left.size()) {
            list.add(left.get(leftIndex++));
        }

        while (rightIndex < right.size()) {
            list.add(right.get(rightIndex++));
        }
    }

    // BubbleSort
    public static void bubbleSort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    // Test
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random rand = new Random();

        // Generating a list of random numbers
        for (int i = 0; i < 1000; i++) {
            numbers.add(rand.nextInt(1000));
        }

        ArrayList<Integer> numbersToMergeSort = new ArrayList<>(numbers);
        ArrayList<Integer> numbersToBubbleSort = new ArrayList<>(numbers);

        long startTime, endTime;

        // Timing MergeSort
        startTime = System.currentTimeMillis();
        mergeSort(numbersToMergeSort);
        endTime = System.currentTimeMillis();
        System.out.println("MergeSort time: " + (endTime - startTime) + "ms");

        // Timing BubbleSort
        startTime = System.currentTimeMillis();
        bubbleSort(numbersToBubbleSort);
        endTime = System.currentTimeMillis();
        System.out.println("BubbleSort time: " + (endTime - startTime) + "ms");
    }
}
