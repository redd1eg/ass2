public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("Size: " + list.size());
        System.out.println("First element: " + list.get(0)); // 1
        System.out.println("Last element: " + list.get(2)); // 3

        list.remove(1);
        System.out.println("Size after removal: " + list.size());

        list.sort((a, b) -> b - a);
        System.out.println("Sorted list: ");
        for (Integer num : list) {
            System.out.println(num);
        }
    }
}
