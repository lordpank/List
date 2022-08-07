import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void printList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + " " + list.get(i));
        }
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1 - Добавить товар");
            System.out.println("2 - Показать товар");
            System.out.println("3 - Удалить товар");
            System.out.println("4 - Найти товар в списке по названию.");
            System.out.println("Введите end если хотите завершить программу");

            String meaning = scanner.nextLine();
            if ("end".equals(meaning)) {
                System.out.println("Программа завершена");
                break;
            }

            int meaningInt = Integer.parseInt(meaning);
            switch (meaningInt) {
                case 1:
                    System.out.println("Введите название товара чтобы добавить");
                    String itemAdd = scanner.nextLine();
                    list.add(itemAdd);
                    System.out.println("Итого: " + list.size());
                    break;
                case 2:
                    System.out.println("Список товаров:");
                    printList(list);
                    break;
                case 3:
                    System.out.println("Список товаров:");
                    printList(list);
                    System.out.println("Введите номер или название который хотите удалить");
                    String itemDel = scanner.nextLine();
                    try {
                        int itemDelOn = Integer.parseInt(itemDel) - 1;
                        System.out.println("Товар " + " " + list.get(itemDelOn) + " " + " удален, список:");
                        list.remove(itemDelOn);
                        printList(list);
                        continue;
                    } catch (NumberFormatException e) {
                        if (list.contains(itemDel)) {
                            list.remove(itemDel);
                            System.out.println("Товар " + " " + itemDel + " " + " удален");
                            System.out.println("Список товаров:");
                            printList(list);
                        } else {
                            System.out.println("Товар не найден.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Введите название товара для поиска:");
                    String search = scanner.nextLine();
                    String searchLower = search.toLowerCase();
                    System.out.println("Найдено: ");
                    for (int i = 0; i < list.size(); i++) {
                        String item = list.get(i);
                        String itemLower = item.toLowerCase();
                        if (itemLower.contains(searchLower)) {
                            System.out.println((i + 1) + " " + item);
                        }
                    }
                default:
                    System.out.println("Такой операции нет");
            }
        }
    }
}