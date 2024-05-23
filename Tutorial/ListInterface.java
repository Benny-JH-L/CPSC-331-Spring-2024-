package Tutorial;

/**
 * List ADT operations
 *
 * @author Jalal Kawash
 */

public interface ListInterface <T extends Comparable>
{
    public boolean isEmpty();
    public boolean isFull();
    public int size();
    public void clear();
    public void reset();
    public T getNext();
    public void add (T element);
    public int contains(T element);
    public void remove(T element);
    public void sort();    
}
