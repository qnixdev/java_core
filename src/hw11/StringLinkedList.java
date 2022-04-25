package hw11;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class StringLinkedList implements List {
    /**
     * Pointer to first item of list.
     */
    private Item<String> first;

    /**
     * Pointer to last item of list.
     */
    private Item<String> last;

    /**
     * The size of the StringLinkedList (the number of items it contains).
     */
    private int size = 0;

    public StringLinkedList() {
    }

    public StringLinkedList(Collection<String> list) {
        this();
        addAll(list);
    }

    private static class Item<S> {
        S element;
        Item<S> prev;
        Item<S> next;

        Item(S element, Item<S> prev, Item<S> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    private Item<String> getItemByIndex(int index) {
        Item<String> item;

        if (index < (this.size >> 1)) {
            item = this.first;

            for (int i = 0; i < index; i++) {
                item = item.next;
            }
        } else {
            item = this.last;

            for (int i = this.size - 1; i > index; i--) {
                item = item.prev;
            }
        }

        return item;
    }

    /**
     * Self method.
     * Check it's are possible index of list
     */
    private boolean isPossibleIndex(int index) {
        return index >= 0 && index <= this.size;
    }

    /**
     * Self method.
     * Links o as last item
     */
    private void addNext(Object o) {
        if (!(o instanceof String s)) {
            return;
        }

        final var last = this.last;
        final var newItem = new Item<>(s, last, null);
        this.last = newItem;

        if (null == last) {
            this.first = newItem;
        } else {
            last.next = newItem;
        }

        this.size++;
    }

    /**
     * Self method.
     * Inserts element o before item.
     */
    private void addByIndex(Object o, Item<String> nextItem) {
        if (!(o instanceof String s)) {
            return;
        }

        final var prevItem = nextItem.prev;
        final var newItem = new Item<>(s, prevItem, nextItem);
        nextItem.prev = newItem;

        if (null == prevItem) {
            this.first = newItem;
        } else {
            prevItem.next = newItem;
        }

        this.size++;
    }

    /////////////////////////////////////
    // Beginning of overridden methods //
    /////////////////////////////////////

    /**
     * Method 1
     */
    @Override
    public boolean add(Object o) {
        addNext(o);

        return true;
    }

    /**
     * Method 2
     */
    @Override
    public void add(int index, Object o) {
        if (index < 0 || index > this.size) {
            return;
        }

        if (this.size != index) {
            addByIndex(o, getItemByIndex(index));

            return;
        }

        addNext(o);
    }

    /**
     * Method 3
     */
    @Override
    public boolean addAll(Collection c) {
        return addAll(this.size, c);
    }

    /**
     * Method 4
     */
    @Override
    public boolean addAll(int index, Collection c) {
        Object[] list = c.toArray();
        int count = list.length;

        if (!isPossibleIndex(index) || count == 0) {
            return false;
        }

        Item<String> prevItem;
        Item<String> nextItem;

        if (index == this.size) {
            nextItem = null;
            prevItem = this.last;
        } else {
            nextItem = getItemByIndex(index);
            prevItem = nextItem.prev;
        }

        for (Object o : list) {
            if (o instanceof String s) {
                var next = new Item<>(s, prevItem, null);

                if (null == prevItem) {
                    this.first = next;
                } else {
                    prevItem.next = next;
                }

                prevItem = next;
            }
        }

        if (null == nextItem) {
            this.last = prevItem;
        } else {
            prevItem.next = nextItem;
            nextItem.prev = prevItem;
        }

        this.size += count;

        return true;
    }

    /**
     * Method 5
     */
    @Override
    public void clear() {
        for (Item<String> item = this.first; null != item; ) {
            var next = item.next;
            item.element = null;
            item.prev = null;
            item.next = null;

            item = next;
        }

        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Method 6
     */
    @Override
    public boolean contains(Object o) {
        if (null != o) {
            for (Item<String> item = this.first; null != item; item = item.next) {
                if (o.equals(item.element)) {
                    return true;
                }
            }
        } else {
            for (Item<String> item = this.first; null != item; item = item.next) {
                if (null == item.element) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Method 7
     */
    @Override
    public String get(int index) {
        return getItemByIndex(index).element;
    }

    /**
     * Method 8
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Method 9
     */
    @Override
    public String remove(int index) {
        final var item = getItemByIndex(index);

        final String element = item.element;
        final Item<String> next = item.next;
        final Item<String> prev = item.prev;

        if (null == prev) {
            this.first = next;
        } else {
            prev.next = next;
            item.prev = null;
        }

        if (null == next) {
            this.last = prev;
        } else {
            next.prev = prev;
            item.next = null;
        }

        item.element = null;
        this.size--;

        return element;
    }

    /**
     * Method 10
     */
    @Override
    public boolean remove(Object o) {
        int index = 0;

        if (null != o) {
            for (Item<String> item = this.first; null != item; item = item.next) {
                if (o.equals(item.element)) {
                    remove(index);

                    return true;
                }

                index++;
            }
        } else {
            for (Item<String> item = this.first; null != item; item = item.next) {
                if (null == item.element) {
                    remove(index);

                    return true;
                }

                index++;
            }
        }

        return false;
    }

    /**
     * Method 11
     */
    @Override
    public String set(int index, Object o) {
        if (!isPossibleIndex(index) || !(o instanceof String s)) {
            return null;
        }

        Item<String> item = getItemByIndex(index);
        String old = item.element;
        item.element = s;

        return old;
    }

    /**
     * Method 12
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Method 13
     */
    @Override
    public Object[] toArray() {
        Object[] list = new Object[this.size];
        int index = 0;

        for (Item<String> item = this.first; null != item; item = item.next) {
            list[index++] = item.element;
        }

        return list;
    }

    /**
     * Method 14
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        Object[] list = toArray();

        for (int i = 0; i < list.length; i++) {
            sb.append(list[i]);

            if (i != list.length - 1) {
                sb.append(',').append(' ');
            }
        }

        return sb.append(']').toString();
    }

    ///////////////////////////////
    // End of overridden methods //
    ///////////////////////////////








    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {
        List.super.forEach(action);
    }

    @Override
    public Object[] toArray(IntFunction generator) {
        return List.super.toArray(generator);
    }

    @Override
    public boolean removeIf(Predicate filter) {
        return List.super.removeIf(filter);
    }

    @Override
    public void replaceAll(UnaryOperator operator) {
        List.super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator c) {
        List.super.sort(c);
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Spliterator spliterator() {
        return List.super.spliterator();
    }

    @Override
    public Stream stream() {
        return List.super.stream();
    }

    @Override
    public Stream parallelStream() {
        return List.super.parallelStream();
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}