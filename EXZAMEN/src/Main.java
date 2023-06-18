import java.util.Scanner;

class Person {
    String name;
    String birthday;

    Person(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }
}

class Node {
    Person person;
    Node next;

    Node(Person person) {
        this.person = person;
        next = null;
    }
}

class LinkedList {
    Node head;
    int size;

    LinkedList() {
        head = null;
        size = 0;
    }

    void add(Person person) {
        Node newNode = new Node(person);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    void remove(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    void edit(int index, Person person) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.person = person;
    }

    void viewAll() {
        Node current = head;
        while (current != null) {
            System.out.println(current.person.name + " " + current.person.birthday);
            current = current.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 5) {
            System.out.println("1. Add a person");
            System.out.println("2. Remove a person");
            System.out.println("3. Edit a person");
            System.out.println("4. View all people");
            System.out.println("5. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter birthday:");
                    String birthday = scanner.nextLine();
                    Person person = new Person(name, birthday);
                    list.add(person);
                    break;
                case 2:
                    System.out.println("Enter index:");
                    int index = scanner.nextInt();
                    list.remove(index);
                    break;
                case 3:
                    System.out.println("Enter index:");
                    int index2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter name:");
                    String name2 = scanner.nextLine();
                    System.out.println("Enter birthday:");
                    String birthday2 = scanner.nextLine();
                    Person person2 = new Person(name2, birthday2);
                    list.edit(index2, person2);
                    break;
                case 4:
                    list.viewAll();
                    break;
            }
        }
    }
}