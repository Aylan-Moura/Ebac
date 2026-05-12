public class HashMapCustom {

    private static class Entry {
        int key;
        int value;
        boolean occupied;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
            this.occupied = true;
        }
    }

    private Entry[] table;
    private final int CAPACITY = 10;

    public HashMapCustom() {
        table = new Entry[CAPACITY];
    }

    private int hash(int key) {
        return key % CAPACITY;
    }

    public void put(int key, int value) {

        int index = hash(key);

        int startIndex = index;

        while (table[index] != null && table[index].occupied && table[index].key != key) {
            index = (index + 1) % CAPACITY;

            if (index == startIndex) {
                throw new RuntimeException("HashMap is full");
            }
        }

        table[index] = new Entry(key, value);
    }

    public Integer get(int key) {

        int index = hash(key);

        int startIndex = index;

        while (table[index] != null) {

            if (table[index].occupied && table[index].key == key) {
                return table[index].value;
            }

            index = (index + 1) % CAPACITY;

            if (index == startIndex) {
                break;
            }
        }

        return null;
    }

    public void delete(int key) {

        int index = hash(key);

        int startIndex = index;

        while (table[index] != null) {

            if (table[index].occupied && table[index].key == key) {
                table[index].occupied = false;
                return;
            }

            index = (index + 1) % CAPACITY;

            if (index == startIndex) {
                break;
            }
        }
    }

    public void clear() {
        table = new Entry[CAPACITY];
    }
}
