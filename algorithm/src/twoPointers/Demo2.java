package twoPointers;

public class Demo2 {

    // 复写零
    // https://leetcode.cn/problems/duplicate-zeros/description/

    public static void duplicateZeros(int[] arr) {

        // 1. 先找到最后一个复写的元素
        int cur = 0;
        int dest = -1;
        int n = arr.length;
        while(cur < n) {
            if(arr[cur] != 0) {
                dest++;
            }else {
                dest += 2;
            }
            if(dest >= n - 1) {
                break;
            }
            cur++;
        }
        // 2. 处理特殊情况
        if(dest == n) {
            arr[dest - 1] = 0;
            dest -= 2;
            cur--;
        }
        // 3. 从后往前复写元素
        while(cur >= 0) {
            if(arr[cur] != 0) {
                arr[dest--] = arr[cur--];
            }else {
                arr[dest--] = arr[cur];
                arr[dest--] = arr[cur--];
            }
        }

    }

    public static void main(String[] args) {

        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        int[] arr2 = {1, 0, 2, 3, 0, 4};
        duplicateZeros(arr2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

    }

}
