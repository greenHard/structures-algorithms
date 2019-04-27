package com.zhang.linked;

public class CircularLinkedListMain {

    public static void main(String[] args) {
        CircularLinkedList clList = new CircularLinkedList();
        clList.initList();
        clList.insertList(1);
        clList.insertList(2);
        clList.insertList(3);
        clList.insertList(4);
        clList.insertList(5);
        clList.print();

        System.out.println("链表长度："+clList.size());
        clList.deletelist(1);
        clList.deletelist(5);
        clList.print();
        System.out.println("第1个元素值为："+clList.getElement(1).getValue());
        System.out.println("第2个元素值为："+clList.getElement(2).getValue());
        System.out.println("第3个元素值为："+clList.getElement(3).getValue());

        System.out.println(clList.isContain(2));
        System.out.println(clList.isContain(6));
//      System.out.println(clList.isContain(5));
    }

}
