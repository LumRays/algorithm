package binarySearch;

public class Demo3 {

    // x 的平方根
    // https://leetcode.cn/problems/sqrtx/

    public static int mySqrt(int x) {
        if(x < 1) {
            return 0;
        }
        long left = 1;
        long right = x;
        while(left < right) {
            long mid = left + (right - left + 1) / 2;
            if(mid * mid <= x) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return (int)left;
    }

    public static void main(String[] args) {

        System.out.println(mySqrt(8));
        System.out.println(mySqrt(16));
        System.out.println(mySqrt(3));
        System.out.println(mySqrt(5));

    }

}
