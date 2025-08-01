package searchingsorting;

import java.util.Scanner;

public class LinearSearch {
    public static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {23, 34, 45, 56, 67};
        System.out.println("enter the targeted value:");
        int target = sc.nextInt();
        int result = search(arr, target);
        System.out.println(result);
    }
}
