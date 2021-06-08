//给你一个以行程长度编码压缩的整数列表 nums 。 
//
// 考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后子列表中
//有 freq 个值为 val 的元素，你需要从左到右连接所有子列表以生成解压后的列表。 
//
// 请你返回解压后的列表。 
//
// 
//
// 示例： 
//
// 输入：nums = [1,2,3,4]
//输出：[2,4,4,4]
//解释：第一对 [1,2] 代表着 2 的出现频次为 1，所以生成数组 [2]。
//第二对 [3,4] 代表着 4 的出现频次为 3，所以生成数组 [4,4,4]。
//最后将它们串联到一起 [2] + [4,4,4] = [2,4,4,4]。 
//
// 示例 2： 
//
// 输入：nums = [1,1,2,3]
//输出：[1,3,3]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 100 
// nums.length % 2 == 0 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 39 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;

//Java：解压缩编码列表
public class P1313DecompressRunLengthEncodedList {
    public static void main(String[] args) {
        Solution solution = new P1313DecompressRunLengthEncodedList().new Solution();
        // TO TEST
        System.out.println(solution.decompressRLElist(new int[]{1, 2, 3, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] decompressRLElist(int[] nums) {
            ArrayList<Integer> resultList = new ArrayList<>();
            for (int i = 0; i < nums.length; i += 2) {
                for (int j = 0; j < nums[i]; j++) {
                    resultList.add(nums[i + 1]);
                }
            }
            int[] result = new int[resultList.size()];
            for (int i = 0; i < resultList.size(); i++) {
                result[i] = resultList.get(i);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
