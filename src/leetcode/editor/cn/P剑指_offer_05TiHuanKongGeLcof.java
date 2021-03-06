//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 122 👎 0

package leetcode.editor.cn;

//Java：替换空格
public class P剑指_offer_05TiHuanKongGeLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_05TiHuanKongGeLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c != ' ') {
                    sb.append(c);
                } else {
                    sb.append("%20");
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}