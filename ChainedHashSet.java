package datastructures.sets;

import datastructures.dictionaries.ChainedHashDictionary;
import datastructures.dictionaries.IDictionary;
import datastructures.dictionaries.KVPair;

import java.util.Objects;



import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @see ISet for more details on what each method is supposed to do.
 */
public class ChainedHashSet<T> implements ISet<T> {
    // This should be the only field you need
    private IDictionary<T, Boolean> map;

    public ChainedHashSet() {
        // No need to change this method
        this.map = new ChainedHashDictionary<>();
    }

    /**
     * If the given item is not in the set, adds it to the set and returns `true`. Otherwise,
     * returns `false`.
     *
     * @param item: the item the user wants to add to the set
     * @return is true if the item was not already in the set, returns false otherwise
     */
    @Override
    public boolean add(T item) {
        return Objects.equals(this.map.put(item, true), null);
    }

    /**
     * If the given item is in the set, removes it from the set and returns `true`. Otherwise,
     * returns `false`.
     *
     * @param item: the item the user wishes to remove from the set
     * @return is true if removed item successfully, false otherwise
     */
    @Override
    public boolean remove(T item) {
        return !Objects.equals(this.map.remove(item), null);
    }

    /**
     * Returns `true` if the set contains this item and `false` otherwise.
     * @param item: The item the user wants to see is in the set or not
     * @return is true if the item is in the set, false otherwise
     */
    @Override
    public boolean contains(T item) {
        return this.map.containsKey(item);
    }

    /**
     * Returns the number of items contained within this set.
     * @return is the number of items in the set
     */
    @Override
    public int size() {
        return this.map.size();
    }

    /**
     * Returns an iterator over the contents of this set.
     * @return is the iterator over the set
     */
    @Override
    public Iterator<T> iterator() {
        return new SetIterator<>(this.map.iterator());
    }

    /**
     *
     * @return is a string representation of the set
     */
    @Override
    public String toString() {
        // return super.toString();

        /*
        After you've implemented the iterator, comment out the line above and uncomment the line
        below to get a better string representation for objects in assertion errors and in the
        debugger.
        */

        return ISet.toString(this);
    }

    private static class SetIterator<T> implements Iterator<T> {
        // This should be the only field you need
        private Iterator<KVPair<T, Boolean>> iter;

        public SetIterator(Iterator<KVPair<T, Boolean>> iter) {
            // No need to change this method.
            this.iter = iter;
        }

        @Override
        public boolean hasNext() {
            return iter.hasNext();
        }

        @Override
        public T next() {
            if (!iter.hasNext()) {
                throw new NoSuchElementException();
            }
            return iter.next().getKey();
        }
    }
}
