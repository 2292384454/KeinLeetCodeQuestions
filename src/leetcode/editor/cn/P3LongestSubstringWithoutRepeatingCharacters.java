//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

package leetcode.editor.cn;

import java.util.HashMap;

//Java：无重复字符的最长子串
public class P3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST
        String s = "bbbbb";
        int result = solution.lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {//核心思想：滑动窗口法
            int result = 0;
            HashMap<Character, Integer> mymap = new HashMap<>();//哈希表，key为字符，value为字符在字符串中的位置
            for (int start = 0, end = 0; end < s.length(); end++) {
                char temp = s.charAt(end);
                if (mymap.containsKey(temp))
                    start = Math.max(start, mymap.get(temp) + 1);
                result = Math.max(result, end - start + 1);
                mymap.put(temp, end);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}