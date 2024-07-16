import org.example.HashTable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

public class HashTableTest {

    /**
     * Тест добавления и получения значений.
     * Проверяет добавление и извлечение значений по ключам.
     */
    @Test
    void testPutAndGet() {
        HashTable<String, Integer> ht = new HashTable<>(10);
        ht.put("Cat", 1);
        ht.put("Dog", 2);
        ht.put("Rabbit", 3);

        assertEquals(3, ht.size());
        assertEquals(Integer.valueOf(1), ht.get("Cat"));
        assertEquals(Integer.valueOf(2), ht.get("Dog"));
        assertEquals(Integer.valueOf(3), ht.get("Rabbit"));
    }
    /**
     * Тест перезаписи существующего значения при добавлении.
     * Проверяет перезапись значения для существующего ключа.
     */
    @Test
    void testPutOverwritesExistingValue() {
        HashTable<String, Integer> ht = new HashTable<>(10);
        ht.put("Cat", 1);
        ht.put("Cat", 2);
        assertEquals(1, ht.size());
        assertEquals(Integer.valueOf(2), ht.get("Cat"));
    }
    /**
     * Тест удаления элемента по ключу.
     * Проверяет удаление пары ключ-значение и изменение размера.
     */
    @Test
    void testRemove() {
        HashTable<String, Integer> ht = new HashTable<>(10);
        ht.put("Cat", 1);
        ht.put("Dog", 2);
        ht.put("Rabbit", 3);
        ht.remove("Dog");

        assertEquals(2, ht.size());
        assertNull(ht.get("Dog"));
    }
    /**
     * Тест попытки удаления несуществующего элемента.
     */
    @Test
    void testRemoveNonExistingKey() {
        HashTable<String, Integer> ht = new HashTable<>(10);
        ht.put("Cat", 1);
        ht.put("Dog", 2);
        ht.put("Rabbit", 3);

        ht.remove("Fish");
        assertEquals(3, ht.size());
    }

    /**
     * Тест проверки на пустоту.
     * Проверяет начальное состояние (пустая таблица)
     * и состояние после добавления элементов.
     */
    @Test
    void testIsEmpty() {
        HashTable<String, Integer> ht = new HashTable<>(10);
        assertTrue(ht.isEmpty());

        ht.put("Cat", 1);
        assertFalse(ht.isEmpty());
    }

    /**
     * Тест получения размера таблицы.
     * Проверяет размер таблицы после добавления элементов.
     */
    @Test
    void testSize() {
        HashTable<String, Integer> ht = new HashTable<>(10);
        assertEquals(0, ht.size());

        ht.put("Cat", 1);
        ht.put("Dog", 2);
        ht.put("Rabbit", 3);

        assertEquals(3, ht.size());
    }

    /**
     * Тест получения множества ключей.
     * Проверяет набор ключей, возвращаемый методом `keySet()`
    `*/
    @Test
    void testKeySet() {
        HashTable<String, Integer> ht = new HashTable<>(10);
        ht.put("Cat", 1);
        ht.put("Dog", 2);
        ht.put("Rabbit", 3);

        Set<String> expectedKeys = new HashSet<>();
        expectedKeys.add("Cat");
        expectedKeys.add("Dog");
        expectedKeys.add("Rabbit");

        assertEquals(expectedKeys, ht.keySet());
    }

    /**
     *  Тест получения множества значений.
     *  Проверяет набор значений, возвращаемый методом `values()`
     */
    @Test
    void testValues() {
        HashTable<String, Integer> ht = new HashTable<>(10);
        ht.put("Cat", 1);
        ht.put("Dog", 2);
        ht.put("Rabbit", 3);

        Set<Integer> expectedValues = new HashSet<>();
        expectedValues.add(1);
        expectedValues.add(2);
        expectedValues.add(3);

        assertEquals(expectedValues, ht.values());
    }

    /**
     * Тест работы с большим количеством данных.
     * Этот тест проверяет производительность `HashTable` с большим количеством данных,
     * чтобы убедиться, что он справляется с коллизиями.
     */
    @Test
    void testLargeData() {
        HashTable<Integer, String> ht = new HashTable<>(10000);
        for (int i = 0; i < 100000; i++) {
            ht.put(i, "Value" + i);
        }
        assertEquals(100000, ht.size());
        for (int i = 0; i < 100000; i++) {
            assertEquals("Value" + i, ht.get(i));
        }
    }

    /**
     * Тест обработки коллизий.
     */
    @Test
    void testCollisions() {

        HashTable<Integer, String> ht = new HashTable<>(10);
        for (int i = 0; i < 20; i++) {
            ht.put(i * 10, "Value" + i);
        }

        for (int i = 0; i < 20; i++) {
            assertEquals("Value" + i, ht.get(i * 10));
        }
    }
}