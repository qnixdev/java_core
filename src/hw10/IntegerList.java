package hw10;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class IntegerList implements List {
    private static final int DEFAULT_CAPACITY = 8;

    private Integer[] integerData;

    private int nextIndex;

    public IntegerList() {
        this.integerData = new Integer[DEFAULT_CAPACITY];
    }

    public IntegerList(int capacity) {
        this.integerData = new Integer[capacity];
    }

    public IntegerList(Collection<Integer> list) {
        this.integerData = new Integer[Math.max(list.size(), DEFAULT_CAPACITY)];
        addAll(list);
    }

    @Override
    public boolean add(Object o) {
        add(o, this.integerData, this.nextIndex);

        return true;
    }

    @Override
    public void add(int index, Object element) {
        if (!(element instanceof Integer) || index < 0 || index > this.nextIndex) {
            return;
        }

        Integer[] destArray = new Integer[Math.max(this.nextIndex + 1, DEFAULT_CAPACITY)];
        int j = 0;

        for (int i = 0; i < destArray.length - 1; i++) {
            if (i == index) {
                Object[] list = destArray;
                list[i] = element;
            } else {
                destArray[i] = this.integerData[j];
                j++;
            }
        }

        this.integerData = destArray;
        this.nextIndex++;
    }

    /**
     * self method
     */
    private void add(Object o, Object[] list, int index) {
        if (!(o instanceof Integer)) {
            return;
        }

        if (this.nextIndex + 1 == this.integerData.length) {
            resize();
        }

        list[index] = o;
        this.nextIndex++;
    }

    @Override
    public boolean addAll(Collection c) {
        Object[] list = c.toArray();

        for (Object o : list) {
            add(o);
        }

        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        if (index < 0 || index > this.nextIndex) {
            return false;
        }

        Integer[] destArray = new Integer[Math.max(this.nextIndex + c.size(), DEFAULT_CAPACITY)];
        int j = 0;

        for (int i = 0; i < destArray.length; i++) {
            if (i == index) {
                Object[] destList = destArray;
                Object[] listToAdd = c.toArray();

                for (int n = 0; n < c.size(); n++) {
                    destList[i] = listToAdd[n];
                    i++;
                }

                i--;
            } else {
                destArray[i] = this.integerData[j];
                j++;
            }
        }

        this.integerData = destArray;
        this.nextIndex += c.size();

        return true;
    }

    @Override
    public void clear() {
        this.integerData = new Integer[this.integerData.length];
    }

    @Override
    public boolean contains(Object o) {
        Object[] list = this.integerData;

        for (Object i : list) {
            if (o.equals(i)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Object get(int index) {
        return this.integerData[index];
    }

    @Override
    public boolean isEmpty() {
        return this.nextIndex == 0;
    }

    @Override
    public Object remove(int index) {
        Object[] list = this.integerData;
        Object oldItem = list[index];
        remove(list, index);

        return oldItem;
    }

    @Override
    public boolean remove(Object o) {
        if (null == o) {
            return false;
        }

        Object[] list = this.integerData;

        for (int i = 0; i < list.length; i++) {
            if (o.equals(list[i])) {
                remove(list, i);
                this.nextIndex--;

                return true;
            }
        }

        return false;
    }

    /**
     * self method
     */
    private void remove(Object[] list, int removeIndex) {
        final int newIndex = this.nextIndex - 1;

        if (newIndex > removeIndex) {
            System.arraycopy(
                list,
                removeIndex + 1,
                list,
                removeIndex,
                newIndex - removeIndex
            );
        }

        list[newIndex] = null;
    }

    /**
     * self method
     */
    private void resize() {
        int oldCapacity = this.integerData.length;

        if (oldCapacity > 0) {
            int newCapacity = oldCapacity * 2;
            this.integerData = Arrays.copyOf(this.integerData, newCapacity);
        } else {
            this.integerData = new Integer[DEFAULT_CAPACITY];
        }
    }

    @Override
    public Object set(int index, Object element) {
        if (!(element instanceof Integer)) {
            return null;
        }

        if (index > this.nextIndex) {
            resize();
            set(index, element);
        }

        Object oldItem = this.integerData[index];
        add(element, this.integerData, index);

        return oldItem;
    }

    @Override
    public int size() {
        return this.nextIndex;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.integerData, this.nextIndex);
    }

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
