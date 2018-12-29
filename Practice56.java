/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 :
 *
 * 输入: [3,0,1]
 * 输出: 2
 */

class Solution {
    public int missingNumber(int[] nums) {
        int max = nums[0];
        int flag = 1; //判断是否有0
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max)
                max = nums[i];
            if(nums[i] == 0)
                flag = 0;
        }
        int sum = 0;
        for(int i = 0; i <= max; i++){
            sum = sum + i;
        }
        int cur = 0;
        for(int i = 0; i < nums.length; i++){
            cur = cur + nums[i];
        }
        int res = sum - cur;
        if(res == 0 && flag == 0)
            res = max + 1;
        return res;
    }
}

public class Practice56 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,2,3,6,5,4};
        Solution solution = new Solution();
        System.out.println(solution.missingNumber(nums));
    }
}
