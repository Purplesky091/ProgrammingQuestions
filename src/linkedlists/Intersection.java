package linkedlists;

import java.util.LinkedList;
/*
* 12 -> 10 -> 5 -> 4 -> 3
*                         \
*                          2 -> 1
*                         /
*             9 -> 8 -> 7
*
* 1. get the size & determine if there's an interseciton by checking if tails are equal
* 2. walk the longer list forward by the difference in list size
* 3. walk to the end and check if the references equal
*
* public Node getIntersection(Node list1, Node list2)
* {
*   if (list1 == null || list2 == null)
*       return null;
*
*   ListInfo list1Info = getTailAndSize(list1);
*   ListInfo list2Info = getTailAndSize(list2);
*
*   if(list1Info.tail != list2Info.tail)
*       return null;
*
*   Node shorterList = list1Info.size < list2Info.size ? list1 : list2;
*   Node longerList = list1Info.size < list2Info.size ? list2 : list1;
*
*   longerList = goToKthElement(longerList, Math.abs(list2.size - list1.size));
*   while(longerList != shorterList) {
*       longerList = longerList.next;
*       shorterList = shorterList.next;
*   }
*
*   return shorterList;
* }
*
* private Node goToKthElement(Node list, int k) {
*       Node walker = list;
*       while(k > 0){
*           walker = walker.next;
*           k--;
*       }
*
*       return walker;
* }
*
* private ListInfo getTailAndSize(Node list) {
*       Node walker = list1;
 *       int size = 1;
 *       while(walker.next != null) {
 *           size++;
 *          walker = walker.next;
 *       }
 *
 *       return new ListInfo(walker, size);
 * }
*
* private class ListInfo {
*   int size;
*   Node tail;
*
*   public ListInfo(Node tail, int size) {
*       this.size = size;
*       this.tail = tail;
*   }
* }
*
* */


public class Intersection {
    private static class LinkedListNode {
        int data;
        LinkedListNode next;

        public LinkedListNode(int data) {
            this.data = data;
        }
    }

    class Result {
        public LinkedListNode tail;
        public int size;

        public Result(LinkedListNode tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }

    LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
        if(list1 == null || list2 == null)
            return null;

        /*get tail and sizes*/
        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);

        if(result1.tail != result2.tail)
            return null;

        LinkedListNode shorter = result1.size < result2.size ? list1 : list2;
        LinkedListNode longer = result1.size < result2.size ? list2 : list1;

        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        return longer;
    }

    LinkedListNode getKthNode(LinkedListNode head, int k) {
        LinkedListNode current = head;
        while(k > 0 && current != null) {
            current = current.next;
            k--;
        }

        return current;
    }

    Result getTailAndSize(LinkedListNode list) {
        if(list == null)
            return null;

        LinkedListNode walker = list;
        int size = 1;
        while(walker.next != null) {
            walker = walker.next;
            size++;
        }

        return new Result(walker, size);
    }


}
