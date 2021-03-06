//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。 
//
// 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。 
//
// 示例 1: 
//
// 输入: s = "egg", t = "add"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "foo", t = "bar"
//输出: false 
//
// 示例 3: 
//
// 输入: s = "paper", t = "title"
//输出: true 
//
// 说明: 
//你可以假设 s 和 t 具有相同的长度。 
// Related Topics 哈希表 
// 👍 227 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：同构字符串
public class P205IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new P205IsomorphicStrings().new Solution();
        // TO TEST
        System.out.println(solution.isIsomorphic("ab", "aa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s == null) {
                return true;
            }
            Map<Character, Character> sTot = new HashMap<>();
            char[] s_array = s.toCharArray(), t_array = t.toCharArray();
            for (int i = 0; i < s_array.length; i++) {
                if (!sTot.containsKey(s_array[i]) && !sTot.containsValue(t_array[i])) {
                    sTot.put(s_array[i], t_array[i]);
                } else if (!sTot.containsKey(s_array[i]) || !sTot.containsValue(t_array[i]) || t_array[i] != sTot.get(s_array[i])) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}