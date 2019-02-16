/**
 * 单链表反转
 */
public class LinkedReverse {

    private static LinkedNode linkedNode = new LinkedNode(0);

    private static void initLinked() {
        LinkedNode temp1 = new LinkedNode(4);
        linkedNode.next = temp1;

        LinkedNode temp2 = new LinkedNode(3);
        temp1.next = temp2;

        LinkedNode temp3 = new LinkedNode(7);
        temp2.next = temp3;

        LinkedNode temp4 = new LinkedNode(9);
        temp3.next = temp4;

        LinkedNode temp5 = new LinkedNode(6);
        temp4.next = temp5;

        temp5.next = null;
    }

    private static void printfLinked() {
        LinkedNode temp = linkedNode;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * 非递归单链表反转
     * @param head
     * @return
     */
    private LinkedNode reverseListN(LinkedNode head) {
        LinkedNode prev = null;
        while (head != null) {
            LinkedNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    /**
     * 递归单链表反转
     * @param head
     * @return
     */
    private LinkedNode reverseListY(LinkedNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedNode prev = reverseListY(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }

    public static void main(String args[]) {

        LinkedReverse linkedReverse = new LinkedReverse();
        initLinked();

        printfLinked();

        //linkedNode = linkedReverse.reverseListN(linkedNode);
        linkedNode = linkedReverse.reverseListY(linkedNode);

        printfLinked();
    }




}
