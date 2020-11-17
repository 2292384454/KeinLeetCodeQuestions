//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1168 👎 0

package leetcode.editor.cn;

//Java：反转链表
public class P206ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new P206ReverseLinkedList().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode result = null, p = head, temp = null;
            while (p != null) {
                temp = new ListNode(p.val);
                temp.next = result;
                result = temp;
                p = p.next;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}