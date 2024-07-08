import org.example.HashTable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {

    @Test
    void testPutAndGet() {
        HashTable<String, Integer> ht = new HashTable<>(10);

        ht.put("Cat", 1);
        ht.put("Dog", 2);
        ht.put("Rabbit", 3);

        assertEquals(3, ht.size());
        assertEquals(1, ht.get("Cat"));
        assertEquals(2, ht.get("Dog"));
        assertEquals(3, ht.get("Rabbit"));
    }

    @Test
    void testPutOverwrite() {
        HashTable<String, Integer> ht = new HashTable<>(10);
        ht.put("Cat", 1);
        ht.put("Cat", 4);
        assertEquals(1, ht.size());
        assertEquals(4, ht.get("Cat"));
    }

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

    @Test
    void testRemoveNonExistingKey() {
        HashTable<String, Integer> ht = new HashTable<>(10);
        ht.put("Cat", 1);
        ht.put("Dog", 2);
        ht.remove("Rabbit");
        assertEquals(2, ht.size());
    }

    @Test
    void testIsEmpty() {
        HashTable<String, Integer> ht = new HashTable<>(10);
        assertTrue(ht.isEmpty());
        ht.put("Cat", 1);
        assertFalse(ht.isEmpty());
    }

    @Test
    void testHashCollision() {
        HashTable<String, Integer> ht = new HashTable<>(3);

        ht.put("Cat", 1);
        ht.put("Cet", 2);

        assertEquals(2, ht.size());
        assertEquals(1, ht.get("Cat"));
        assertEquals(2, ht.get("Cet"));
    }
}