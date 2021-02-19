import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Doubly-linked list class.
 * 
 * FIFO: add at tail (prev) and remove from head (next)
 * Head points to index 0 first element in the queue.
 * Tail points to the last element in the queue.
 * An empty queue is when next and prev point to the queue.
 * 
 * Runtime: 7 ms, faster than 95.55% of Java online submissions.
 * Memory Usage: 39.6 MB, less than 67.68% of Java online submissions
 */
class MyLinkedList {

    // **** class members ****
    public int val;
    public MyLinkedList next;
    public MyLinkedList prev;

    /**
     * Constructor(s).
     */
    public MyLinkedList() {
        this.next = this;
        this.prev = this;
    }

    public MyLinkedList(int val) {
        this.val = val;
    }

    /**
     * Add node at head of queue.
     */
    public void addAtHead(int val) {

        // **** new node ****
        MyLinkedList node = new MyLinkedList(val);

        // **** set node references ****
        node.next = this.next;
        node.prev = this;

        // **** set other references ****
        this.next = node;
        node.next.prev = node;
    }

    /**
     * Add node at tail of queue.
     */
    public void addAtTail(int val) {

        // **** new node ****
        MyLinkedList node = new MyLinkedList(val);

        // **** set node references ****
        node.next = this;
        node.prev = this.prev;

        // **** set other references ****
        this.prev = node;
        node.prev.next = node;

    }

    /**
     * Add a node of value val BEFORE the index-th node in the linked list. 
     * If index equals to the length of linked list, 
     * the node will be appended to the end of linked list. 
     * If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {

        // **** get to the node in the queue specified by the index ****
        MyLinkedList p  = this.next;
        int i           = 0;
        for (i = 0; i < index && p != this; i++, p = p.next);

        // **** check if index greater than length ****
        if (p == this && i < index)
            return;

        // **** allocate node to insert ****
        MyLinkedList node = new MyLinkedList(val);

        // **** set node references ****
        node.next = p;
        node.prev = p.prev;

        // **** set other references ****
        p.prev.next = node;
        p.prev = node;
    }

    /**
     * Get the value of the index-th node in the linked list.
     * If the index is invalid, return -1.
     */
    public int get(int index) {

        // **** get to the node in the queue specified by the index ****
        MyLinkedList p  = this.next;
        int i           = 0;
        for (i = 0; i < index && p != this; i++, p = p.next);

        // **** check if index greater than length ****
        if (p == this && i >= index)
            return -1;

        // **** return node value ****
        return p.val;
    }

    /**
     * Delete the index-th node in the linked list, 
     * if the index is valid.
     */
    public void deleteAtIndex(int index) {
        
        // **** get to the node in the queue specified by the index ****
        MyLinkedList p  = this.next;
        int i           = 0;
        for (i = 0; i < index && p != this; i++, p = p.next);

        // **** check if index greater than length ****
        if (p == this && i >= index)
            return;

        // **** update references to exclude the node ****
        p.prev.next = p.next;
        p.next.prev = p.prev;
    }

    /**
     * Traverse head to tail.
     * 
     * !!!! NOT PART OF SOLUTION !!!!
     */
    public void headToTail() {
        System.out.print("head->");
        for (MyLinkedList p = this.next; p != this; p = p.next) {
            System.out.print(p.val);
            if (p.next != this)
                System.out.print("->");
        }
        System.out.println();
    }

    /**
     * Traverse tail to head.
     * 
     * !!!! NOT PART OF SOLUTION !!!!
     */
    public void tailToHead() {
        System.out.print("tail->");
        for (MyLinkedList p = this.prev; p != this; p = p.prev) {
            System.out.print(p.val);
            if (p.prev != this)
                System.out.print("->");
        }
        System.out.println();
    }

    /**
     * Return string of object.
     * 
     * !!!! NOT PART OF SOLUTION !!!!
     */
    @Override
    public String toString() {
        return "" + this.val;
    }
}


/**
 * 
 */
public class DesignLinkedList {

    /**
     * Test scafolding
     * 
     * !!!! NOT PART OF SOLUTION !!!!
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read commands ****
        String[] cmds = br.readLine().trim().split(",");

        // **** number of commands ****
        int n = cmds.length;

        // ???? ????
        System.out.println("main <<< n: " + n);
        for (String cmd : cmds)
            System.out.println("main <<< cmd ==>" + cmd + "<===");

        // **** ****
        MyLinkedList obj = null;
        int val;
        int index;

        // **** loop once per command ****
        for (String cmd : cmds) {

            // **** process command ****
            switch (cmd) {
                case "MyLinkedList":
                    obj = new MyLinkedList();

                    // ???? ????
                    System.out.println("main <<< MyLinkedList: null");
                break;

                case "addAtHead":

                    // **** get value to add at head ****
                    val = Integer.parseInt(br.readLine().trim());

                    // **** ****
                    obj.addAtHead(val);

                    // ???? ????
                    System.out.println("main <<< addAtHead: null");
                break;

                case "addAtTail":

                    // **** get value to add at tail of queue ****
                    val = Integer.parseInt(br.readLine().trim());

                    // **** ****
                    obj.addAtTail(val);

                    // ???? ????
                    System.out.println("main <<< addAtTail: null");
                break;

                case "addAtIndex":

                    // **** get data to add at index ****
                    String[] idStrs = br.readLine().trim().split(",");

                    // **** ****
                    index   = Integer.parseInt(idStrs[0]);
                    val     = Integer.parseInt(idStrs[1]);

                    // **** ****
                    obj.addAtIndex(index, val);

                    // ???? ????
                    System.out.println("main <<< addAtIndex: null");            
                break;

                case "get":

                    // **** get index ****
                    index = Integer.parseInt(br.readLine().trim());

                    // **** ****
                    System.out.println("main <<< get: " + obj.get(index));
                break;

                case "deleteAtIndex":

                    // **** get index ****
                    index = Integer.parseInt(br.readLine().trim());

                    // **** ****
                    obj.deleteAtIndex(index);

                    // ???? ????
                    System.out.println("main <<< deleteAtIndex: null");
                break;

                default:
                    System.out.println("main <<< UNEXPECTED cmd ==>" + cmd + "<==");
                    System.exit(-1);
                break;
            }

            // ???? ????
            // obj.headToTail();
            // obj.tailToHead();
        }

        // **** close buffered reader ****
        br.close();
    }

}