package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }

    @Test
    void testZipEqualLengthLists() {
        List<Integer> list1 = Arrays.asList(1, 3, 5);
        List<Integer> list2 = Arrays.asList(2, 4, 6);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expected, App.zip(list1, list2));
    }

    @Test
    void testZipUnequalLengthLists() {
        List<String> list1 = Arrays.asList("a", "c", "e");
        List<String> list2 = Arrays.asList("b", "d");
        List<String> expected = Arrays.asList("a", "b", "c", "d", "e");
        assertEquals(expected, App.zip(list1, list2));
    }

    @Test
    void testZipFirstListEmpty() {
        List<Double> list1 = List.of();
        List<Double> list2 = List.of(1.1, 2.2, 3.3);
        List<Double> expected = List.of(1.1, 2.2, 3.3);
        assertEquals(expected, App.zip(list1, list2));
    }

    @Test
    void testZipSecondListEmpty() {
        List<Double> list1 = List.of(1.1, 2.2, 3.3);
        List<Double> list2 = List.of();
        List<Double> expected = List.of(1.1, 2.2, 3.3);
        assertEquals(expected, App.zip(list1, list2));
    }

    @Test
    void testZipBothListsEmpty() {
        List<Object> list1 = List.of();
        List<Object> list2 = List.of();
        List<Object> expected = List.of();
        assertEquals(expected, App.zip(list1, list2));
    }

    @Test
    void testZipWithCustomObjects() {
        class Person {
            String name;
            Person(String name) { this.name = name; }

            @Override
            public boolean equals(Object o) {
                if (!(o instanceof Person)) return false;
                return ((Person) o).name.equals(this.name);
            }

            @Override
            public String toString() {
                return name;
            }
        }

        List<Person> list1 = List.of(new Person("Alice"), new Person("Charlie"));
        List<Person> list2 = List.of(new Person("Bob"));
        List<Person> expected = List.of(new Person("Alice"), new Person("Bob"), new Person("Charlie"));
        assertEquals(expected, App.zip(list1, list2));
    }
}
