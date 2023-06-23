import java.math.BigInteger;

public class AddTwoNumbers {
    public static void main(String[] args) {

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger sum = new BigInteger(linkedListSum("", l1)).add(new BigInteger(linkedListSum("", l2)));
        ListNode a = new ListNode(sum.mod(new BigInteger("10")).intValue());
        if(sum.divide(new BigInteger("10")).equals(new BigInteger("0"))) return a;
        sum = sum.divide(new BigInteger("10"));
        ListNode b = new ListNode();
        while(!sum.equals(new BigInteger("0"))) {
            b = new ListNode(sum.mod(new BigInteger("10")).intValue(), a);
            a = b;
            sum = sum.divide(new BigInteger("10"));
            System.out.println(sum);
        }
        return reverse(b);

    }
    public String linkedListSum(String num, ListNode l1) {
        if(l1.next == null) return l1.val + num;
        return linkedListSum(l1.val + num, l1.next);
    }
    public ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
}
