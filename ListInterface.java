public interface ListInterface
{
    boolean isEmpty();
    int size();
    void add(int index, Comparable item) throws ListIndexOutOfBoundsException;
    void remove(int index) throws ListIndexOutOfBoundsException;
    Comparable get(int index) throws ListIndexOutOfBoundsException;
    void removeAll();
    boolean isSorted();
    void reverseList();
}
