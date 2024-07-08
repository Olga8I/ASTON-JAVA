package org.example;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

/**
 * Реализация HashMap с использованием массива LinkedList для разрешения коллизий.
 * @param <K> Тип ключа.
 * @param <V> Тип значения.
 */
public class HashTable<K, V> {

    private final LinkedList<Entry<K, V>>[] table;
    private int size;
    private final int capacity;

    /**
     * Конструктор HashMap с указанной емкостью.
     * @param capacity Емкость таблицы.
     */

    public HashTable(int capacity) {
        this.capacity = capacity;
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
        size = 0;
    }

    /**
     * Вычисляет хеш-код для ключа.
     * @param key Ключ для вычисления хеш-кода.
     * @return Хеш-код ключа.
     */

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    /**
     * Добавляет или обновляет пару ключ-значение в HashMap.
     * @param key Ключ.
     * @param value Значение.
     */

    public void put(K key, V value) {
        int index = hash(key);
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
        size++;
    }

    /**
     * Возвращает значение по ключу.
     * @param key Ключ.
     * @return Значение, связанное с ключом, или null, если ключ
     * не найден.
     */

    public V get(K key) {
        int index = hash(key);
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    /**
     * Удаляет пару ключ-значение из HashMap.
     * @param key Ключ.
     */

    public void remove(K key) {
        int index = hash(key);
        for (int i = 0; i < table[index].size(); i++) {
            if (table[index].get(i).key.equals(key)) {
                table[index].remove(i);
                size--;
                return;
            }
        }
    }

    /**
     *  Возвращает размер HashMap.
     *  @return Размер HashMap.
     */

    public int size() {
        return size;
    }

    /**
     *  Проверяет, пуста ли HashMap.
     *  @return true, если HashMap пуста,иначе false.
     */

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Возвращает набор ключей HashMap.
     * @return Набор ключей HashMap .
     */

    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (LinkedList<Entry<K, V>> list : table) {
            for (Entry<K, V> entry : list) {
                keys.add(entry.key);
            }
        }
        return keys;
    }

    /**
     *  Возвращает набор значений HashMap.
     *  @return    Набор значений HashMap .
     */

    public Set<V> values() {
        Set<V> values = new HashSet<>();
        for (LinkedList<Entry<K, V>> list : table) {
            for (Entry<K, V> entry : list) {
                values.add(entry.value);
            }
        }
        return values;
    }

    /**
     *  Внутренний клас для хранения пары ключ-значение.
     *  @param <K> Тип ключа.
     *  @param <V> Тип значения.
     */

    private static class Entry<K, V> {
        private final K key;
        private V value;

        /**
         *  Конструктор Entry.
         *  @param key Ключ.
         *  @param value Значение.
         */

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


}
