package racingcar.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * List 인터페이스를 확장하여 추가 기능을 제공하는 데코레이터 클래스입니다. 이 클래스는 기존 List의 모든 기능을 유지하면서 최대값 검색 등의 추가 기능을 제공합니다.
 *
 * @param <E> 리스트에 저장될 요소의 타입. Comparable 인터페이스를 구현해야 합니다.
 */

public class EnhancedList<E extends Comparable<? super E>> implements List<E> {
    private final List<E> delegate;

    /**
     * 주어진 List를 감싸는 새로운 EnhancedList를 생성합니다.
     *
     * @param delegate 확장할 List 구현체
     * @throws NullPointerException delegate가 null인 경우
     */
    public EnhancedList(List<E> delegate) {
        if (delegate == null) {
            throw new NullPointerException("Delegate list cannot be null");
        }
        this.delegate = delegate;
    }

    /**
     * 리스트에서 최대값과 동일한 모든 요소를 반환합니다.
     *
     * @return 최대값과 동일한 모든 요소들의 리스트
     * @throws NoSuchElementException 리스트가 비어있는 경우
     */
    public List<E> maxAll() {
        if (delegate.isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        List<E> maxElements = new ArrayList<>();
        E max = delegate.get(0);
        maxElements.add(max);

        for (int i = 1; i < delegate.size(); i++) {
            E current = delegate.get(i);
            int comparison = current.compareTo(max);

            if (comparison > 0) {
                max = current;
                maxElements.clear();
                maxElements.add(current);
            } else if (comparison == 0) {
                maxElements.add(current);
            }
        }

        return maxElements;
    }

    @Override
    public int size() {
        return delegate.size();
    }

    @Override
    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return delegate.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return delegate.iterator();
    }

    @Override
    public Object[] toArray() {
        return delegate.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return delegate.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return delegate.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return delegate.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return delegate.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return delegate.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return delegate.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return delegate.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return delegate.retainAll(c);
    }

    @Override
    public void clear() {
        delegate.clear();
    }

    @Override
    public E get(int index) {
        return delegate.get(index);
    }

    @Override
    public E set(int index, E element) {
        return delegate.set(index, element);
    }

    @Override
    public void add(int index, E element) {
        delegate.add(index, element);
    }

    @Override
    public E remove(int index) {
        return delegate.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return delegate.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return delegate.lastIndexOf(o);
    }

    @Override
    public ListIterator<E> listIterator() {
        return delegate.listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return delegate.listIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return delegate.subList(fromIndex, toIndex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof List)) {
            return false;
        }
        return delegate.equals(o);
    }

    @Override
    public int hashCode() {
        return delegate.hashCode();
    }

    @Override
    public String toString() {
        return delegate.toString();
    }
}