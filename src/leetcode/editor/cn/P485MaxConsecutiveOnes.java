//给定一个二进制数组， 计算其中最大连续1的个数。 
//
// 示例 1: 
//
// 
//输入: [1,1,0,1,1,1]
//输出: 3
//解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
// 
//
// 注意： 
//
// 
// 输入的数组只包含 0 和1。 
// 输入数组的长度是正整数，且不超过 10,000。 
// 
// Related Topics 数组 
// 👍 120 👎 0

package leetcode.editor.cn;

//Java：最大连续1的个数
public class P485MaxConsecutiveOnes {
    public static void main(String[] args) {
        Solution solution = new P485MaxConsecutiveOnes().new Solution();
        // TO TEST
        int nums[] = {1, 1, 0, 1, 1, 1};
        System.out.println(solution.findMaxConsecutiveOnes(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int result = 0, count = 0;
            for (int x : nums) {
                if (x == 0) {
                    result = Math.max(result, count);
                    count = 0;
                } else {
                    count += x;
                }
            }
            result = Math.max(result, count);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}