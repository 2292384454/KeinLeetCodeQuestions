//你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下： 
//
// 
// 你写出一个秘密数字，并请朋友猜这个数字是多少。 
// 朋友每猜测一次，你就会给他一个提示，告诉他的猜测数字中有多少位属于数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位属于数字猜对了但是位置不对
//（称为“Cows”, 奶牛）。 
// 朋友根据提示继续猜，直到猜出秘密数字。 
// 
//
// 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，返回字符串的格式为 xAyB ，x 和 y 都是数字，A 表示公牛，用 B 表示奶牛。 
//
// 
// xA 表示有 x 位数字出现在秘密数字中，且位置都与秘密数字一致。 
// yB 表示有 y 位数字出现在秘密数字中，但位置与秘密数字不一致。 
// 
//
// 请注意秘密数字和朋友的猜测数都可能含有重复数字，每位数字只能统计一次。 
//
// 
//
// 示例 1: 
//
// 输入: secret = "1807", guess = "7810"
//输出: "1A3B"
//解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。 
//
// 示例 2: 
//
// 输入: secret = "1123", guess = "0111"
//输出: "1A1B"
//解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。 
//
// 
//
// 说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。 
// Related Topics 哈希表 
// 👍 91 👎 0

package leetcode.editor.cn;

//Java：猜数字游戏
public class P299BullsAndCows {
    public static void main(String[] args) {
        Solution solution = new P299BullsAndCows().new Solution();
        // TO TEST
        String secret = "1123", guess = "0111";
        System.out.println(solution.getHint(secret, guess));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String getHint(String secret, String guess) {
            char[] s = secret.toCharArray(), g = guess.toCharArray();
            int x = 0, y = 0;
            // num[]中存储0到9每个数字出现的次数，在guess中出现就+1，在secret中出现就-1
            // 最终num中存储所有猜错的数字猜错的次数（当num[i]>0时）
            int[] num = new int[10];
            for (int i = 0; i < s.length; i++) {
                num[g[i] - '0']++;
                num[s[i] - '0']--;
                x += ((s[i] == g[i]) ? 1 : 0);
            }
            for (int n : num) {
                if (n > 0) {
                    y += n;
                }
            }
            y = s.length - y - x;
            return x + "A" + y + "B";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}