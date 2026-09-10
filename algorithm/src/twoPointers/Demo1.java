package twoPointers;

public class Demo1 {

    public static void moveZeroes(int[] nums) {
        int cur = 0;
        int dest = -1;
        for(cur = 0; cur < nums.length; cur++) {
            if(nums[cur] != 0) {
                dest++;
                int tmp = nums[cur];
                nums[cur] = nums[dest];
                nums[dest] = tmp;
            }
        }
    }

    public static void main(String[] args) {



    }

}
