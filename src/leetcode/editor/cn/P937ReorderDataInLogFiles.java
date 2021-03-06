//你有一个日志数组 logs。每条日志都是以空格分隔的字串。 
//
// 对于每条日志，其第一个字为字母与数字混合的 标识符 ，除标识符之外的所有字为这一条日志的 内容 。 
//
// 
// 除标识符之外，所有字均由小写字母组成的，称为 字母日志 
// 除标识符之外，所有字均由数字组成的，称为 数字日志 
// 
//
// 题目所用数据保证每个日志在其标识符后面至少有一个字。 
//
// 请按下述规则将日志重新排序： 
//
// 
// 所有 字母日志 都排在 数字日志 之前。 
// 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序； 
// 数字日志 应该按原来的顺序排列。 
// 
//
// 返回日志的最终顺序。 
//
// 
//
// 示例 ： 
//
// 输入：["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
//输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= logs.length <= 100 
// 3 <= logs[i].length <= 100 
// logs[i] 保证有一个标识符，并且标识符后面有一个字。 
// 
// Related Topics 字符串 
// 👍 52 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//Java：重新排列日志文件
public class P937ReorderDataInLogFiles {
    public static void main(String[] args) {
        Solution solution = new P937ReorderDataInLogFiles().new Solution();
        // TO TEST
        String logs[] = new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        System.out.println(solution.reorderLogFiles(logs));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] reorderLogFiles(String[] logs) {
            String[][] numlogs = new String[logs.length][2];
            String[][] letterlogs = new String[logs.length][2];
            String[] result = new String[logs.length];
            int digitalLogCount = 0;
            int letterCount = 0;
            for (int i = 0; i < logs.length; i++) {
                String[] temp = logs[i].split(" ", 2);
                if (Character.isDigit(temp[1].charAt(0))) {
                    numlogs[digitalLogCount++] = temp;
                } else {
                    letterlogs[letterCount++] = temp;
                }
            }
            Arrays.sort(letterlogs, 0, letterCount, new Comparator<String[]>() {
                @Override
                //判断，第二列是否相等，相等则使用第一列作为判断条件
                public int compare(String[] aa, String[] bb) {
                    if (aa[1].compareTo(bb[1]) == 0) {
                        return aa[0].compareTo(bb[0]);
                    }
                    return aa[1].compareTo(bb[1]);
                }
            });
            for (int i = 0; i < letterCount; i++) {
                result[i] = letterlogs[i][0] + " " + letterlogs[i][1];
            }
            for (int i = 0; i < digitalLogCount; i++) {
                result[i + letterCount] = numlogs[i][0] + " " + numlogs[i][1];
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
