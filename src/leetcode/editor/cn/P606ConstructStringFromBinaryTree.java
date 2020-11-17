//你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。 
//
// 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。 
//
// 示例 1: 
//
// 
//输入: 二叉树: [1,2,3,4]
//       1
//     /   \
//    2     3
//   /    
//  4     
//
//输出: "1(2(4))(3)"
//
//解释: 原本将是“1(2(4)())(3())”，
//在你省略所有不必要的空括号对之后，
//它将是“1(2(4))(3)”。
// 
//
// 示例 2: 
//
// 
//输入: 二叉树: [1,2,3,null,4]
//       1
//     /   \
//    2     3
//     \  
//      4 
//
//输出: "1(2()(4))(3)"
//
//解释: 和第一个示例相似，
//除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
// 
// Related Topics 树 字符串 
// 👍 150 👎 0

package leetcode.editor.cn;

//Java：根据二叉树创建字符串
public class P606ConstructStringFromBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P606ConstructStringFromBinaryTree().new Solution();
        // TO TEST
        TreeNode t = TreeNode.constructTree(new Integer[]{1, 2, 3, null, 4});
        solution.tree2str(t);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        public String tree2str(TreeNode t) {
            return hleper(t).toString();
        }

        public StringBuilder hleper(TreeNode t) {
            StringBuilder result = new StringBuilder();
            if (t != null) {
                if (t.left == null && t.right == null)
                    result.append(t.val);
                else if (t.right == null) {
                    result.append(t.val);
                    result.append("(");
                    result.append(tree2str(t.left));
                    result.append(")");
                } else {
                    result.append(t.val);
                    result.append("(");
                    result.append(tree2str(t.left));
                    result.append(")(");
                    result.append(tree2str(t.right));
                    result.append(")");
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}