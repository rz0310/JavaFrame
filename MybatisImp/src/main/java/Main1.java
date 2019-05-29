import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int times = sc.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int[][] temp = new int[times][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < times; j++) {
                temp[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < 2; j++) {
//                降序
                if(temp[i][0] == 1){

                }
//                升序
                if(temp[i][0] == 0){
                    Arrays.sort(arr,0,temp[i][1]);
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
