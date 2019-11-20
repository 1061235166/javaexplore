package com.k.list;

import java.util.*;

/**
 * Created by k on 2019/11/17.
 */
public class ListView {

    public static void main(String[] args) {
        array();
    }

    static void array(){
        int [] array = new int[2];
        array[0]=1;
        array[1]=2;
        System.out.println(array);

        int r = array[3];
        System.out.println(r);
    }

    static void arraylist(){
        ArrayList<Integer>list = new ArrayList<>();
        list.add(1);
        list.add(2);
        //使用拉姆达表达式遍历
        list.forEach(System.out::println);
        Iterator<Integer> iterator = list.iterator();
        //使用迭代器遍历
        iterator.forEachRemaining(System.out::println);

        ListIterator<Integer> listIterator = list.listIterator();
        listIterator.forEachRemaining(System.out::println);
        //删除
        list.remove(1);
        list.remove(new Integer(2));
    }

    static void LinkedList(){
        LinkedList<Integer>linkedList = new LinkedList<>();

        linkedList.addLast(1);
        linkedList.addFirst(2);
        linkedList.push(3);
        linkedList.iterator().forEachRemaining(System.out::println);
        Integer i1 = linkedList.peekLast();
        Integer i2 = linkedList.peekFirst();
        System.out.println(i1);
        System.out.println(i2);
    }

    static void stack(){
        Stack<Integer>stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.iterator().forEachRemaining(System.out::println);

        Integer peek = stack.peek();
        Integer pop = stack.pop();
        stack.iterator().forEachRemaining(System.out::println);
    }
}
