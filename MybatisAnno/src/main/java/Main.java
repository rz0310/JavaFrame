import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] arr = new int[num][num];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < num; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < num; i++) {
            int result = 0;
            for (int j = 3; j >=0 ; j--) {
                if(j == 3){
                    result = arr[i][j];
                    continue;
                }
                if(j == 2){
                    int min = Math.min(arr[i][j], arr[i][0]);
                    result += min;
                    arr[i][j] = arr[i][j] - min;
                    arr[i][0] = arr[i][0] - min;
                }
                if (j == 1) {
                    if(arr[i][j] >= 2){
                        result += arr[i][j] * 2 / 4;
                        arr[i][j] = arr[i][j] * 2 % 4 / 2;
                    }else if(arr[i][j] < 2){
                        result += (arr[i][j] * 2 + arr[i][0]) / 4;
                    }
                }
                if(j == 0){
                    result += (arr[i][j] + arr[i][1] * 2) / 4;
                }
            }
            System.out.println(result);
            result = 0;
        }
    }
}
