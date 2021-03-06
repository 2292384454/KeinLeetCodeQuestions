//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 112 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//Java：N叉树的前序遍历
public class P589NAryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P589NAryTreePreorderTraversal().new Solution();
        // TO TEST
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> preorder(Node root) {
            Stack<Node> stack = new Stack<>();
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            stack.add(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                result.add(node.val);
                Collections.reverse(node.children);
                for (Node item : node.children) {
                    stack.add(item);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}