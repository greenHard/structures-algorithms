package com.zhang.linked;

import java.util.Scanner;

/**
 * 约瑟夫环问题
 */
public class YuesefuCircleTest {
    public static void main(String[] args) {
        // 属兔一个数字去创建一个环
        System.out.println("Input a num to create a circle....");
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println("Input a num to count...");
        int M = scanner.nextInt();
        int[] array = new int[N];
        for (int i = 1; i <= N; i++) {
            array[i - 1] = i;
        }

        YuesefuCircle circle = new YuesefuCircle();
        circle.createCircleByArr(array);
        circle.deleteNodeByDivident(M);
        circle.printCircle();
    }
}


class Node {
    Node next;

    int data;

    public Node(int data) {
        this.data = data;
        next = null;
    }
}

/**
 * 约瑟夫环
 */
class YuesefuCircle {
    Node head, tail;
    int count = 0;
    int divident = 0;

    /**
     * 创建一个环
     * @param arr
     * @return
     */
    public int createCircleByArr(int[] arr) {
        int number = 0;
        int length = arr.length;
        for (int i = 1; i <= length; i++) {
            Node newNode = new Node(arr[i - 1]);
            if (i == 1) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
                newNode.next = head;
            }
            number++;
            count++;
        }
        return number;
    }


    public Node deleteNodeByDivident(int div) {
        this.divident = div;
        Node current = head, prior = head;
        while (this.count > 1) {
            for (int i = 1; i < div; i++) {
                prior = current;
                current = current.next;
            }
            //删除current
            if (current == head) //current 为 head 删除head
            {
                head = head.next;
                current = head;
            } else if (current == tail) //current为tail 删除tail
            {
                tail = prior;
                tail.next = head;
                current = head;
            } else {
                prior.next = current.next;
                current = prior.next;
            }
            count--;
        }
        return head;
    }

    public void printCircle() {
        if (head == null) {
            System.out.println("null list...");
        }
        System.out.println("count= " + count + "\r\n" + "person left= " + head.data);
    }

    public YuesefuCircle() {
        head = tail = null;
    }
}




