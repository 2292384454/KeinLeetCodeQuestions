//我们正在玩一个猜数游戏，游戏规则如下： 
//
// 我从 1 到 n 之间选择一个数字，你来猜我选了哪个数字。 
//
// 每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。 
//
// 然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。直到你猜到我选的数字，你才算赢得了这个游戏。 
//
// 示例: 
//
// n = 10, 我选择了8.
//
//第一轮: 你猜我选择的数字是5，我会告诉你，我的数字更大一些，然后你需要支付5块。
//第二轮: 你猜是7，我告诉你，我的数字更大一些，你支付7块。
//第三轮: 你猜是9，我告诉你，我的数字更小一些，你支付9块。
//
//游戏结束。8 就是我选的数字。
//
//你最终要支付 5 + 7 + 9 = 21 块钱。
// 
//
// 给定 n ≥ 1，计算你至少需要拥有多少现金才能确保你能赢得这个游戏。 
// Related Topics 极小化极大 动态规划 
// 👍 253 👎 0

package leetcode.editor.cn;

//Java：猜数字大小 II
public class P375GuessNumberHigherOrLowerIi {
    public static void main(String[] args) {
        Solution solution = new P375GuessNumberHigherOrLowerIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getMoneyAmount(int n) {
            if (n == 1) {
                return 0;
            }
            // dp[i][j]存储对于[i,j]的的猜数游戏，至少需要拥有多少现金才能确保能赢（j>=i）。
            int[][] dp = new int[n + 1][n + 1];
            //初始化dp中每个元素为Integer.MAX_VALUE
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == j) {
                        dp[i][i] = 0;
                    } else {
                        dp[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            //按列来，从第2列开始
            for (int j = 2; j <= n; j++) {
                //按行来，从下往上
                for (int i = j - 1; i >= 1; i--) {
                    //算除了两端的每一个分割点
                    for (int k = i + 1; k <= j - 1; k++) {
                        dp[i][j] = Math.min(k + Math.max(dp[i][k - 1], dp[k + 1][j]), dp[i][j]);
                    }
                    //算两端
                    dp[i][j] = Math.min(Math.min(i + dp[i + 1][j], j + dp[i][j - 1]), dp[i][j]);
                }
            }
            return dp[1][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
