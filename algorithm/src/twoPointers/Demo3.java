package twoPointers;

public class Demo3 {

    // 快乐数
    // https://leetcode.cn/problems/happy-number/description/

    // 返回 n 每一位上的平方和
    public static int bitSum(int n) {
        int sum = 0;
        while(n != 0) {
            int num = n % 10;
            sum += num * num;
            n /= 10;
        }
        return sum;
    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = bitSum(n);
        while(slow != fast) {
            slow = bitSum(slow);
            fast = bitSum(bitSum(fast));
        }
        return slow == 1;
    }

    public static void main(String[] args) {

        int n = 19;
        int m = 2;
        System.out.println(isHappy(n));
        System.out.println(isHappy(m));

    }

}
