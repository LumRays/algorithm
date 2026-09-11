package twoPointers;

public class Demo2 {

    // https://leetcode.cn/problems/duplicate-zeros/description/

    public static void duplicateZeros(int[] arr) {
        int cur = 0;
        int dest = -1;
        // 1. 先找到最后一个需要复写的数
        while(cur < arr.length) {
            if(arr[cur] == 0) {
                dest += 2;
            }else {
                dest++;
            }
            if(dest >= arr.length - 1) {
                break;
            }
            cur++;
        }
        // 2. 处理边界情况
        if(dest == arr.length) {
            arr[arr.length - 1] = 0;
            cur--;
            dest -= 2;
        }
        // 3. 从后向前完成复写操作
        while(cur >= 0) {
            if(arr[cur] != 0) {
                arr[dest--] = arr[cur--];
            }else {
                arr[dest--] = 0;
                arr[dest--] = 0;
                cur--;
            }
        }

    }

    public static void main(String[] args) {

        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

}
