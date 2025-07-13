package org.example;

import java.util.ArrayList;
import java.util.List;

public class App {
    public String getGreeting() {
        return "Hello User! This is my Zip it Project!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        // Example usage of zip method
        List<String> list1 = List.of("a", "c", "e");
        List<String> list2 = List.of("b", "d");
        List<String> zipped = zip(list1, list2);
        System.out.println(zipped); // Output: [a, b, c, d, e]
    }

    public static <T> List<T> zip(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>();
        int maxLength = Math.max(list1.size(), list2.size());

        for (int i = 0; i < maxLength; i++) {
            if (i < list1.size()) {
                result.add(list1.get(i));
            }
            if (i < list2.size()) {
                result.add(list2.get(i));
            }
        }

        return result;
    }
}
