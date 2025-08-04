package searchingsorting;

import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch(int[] ar,int target) {
        int left=0;
        int right=ar.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(ar[mid]==target){
                return mid;
            }
            else if(ar[mid]>target){
                right=mid-1;
            }
            else if(ar[mid]<target){
                left=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int result = binarySearch(ar, target);
        if (result == -1) {
            System.out.println("-1");
        }else{
            System.out.println(result);
        }
        sc.close();
    }
}
