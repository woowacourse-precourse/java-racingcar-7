package racingcar.model.entity;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** CarNames 클래스의 이터레이터 */
public class CarNamesIterator implements Iterator<String> {

    private final CarNames names;

    private int index;

    public CarNamesIterator(CarNames names) {
        this.names = names;
    }

    @Override
    public boolean hasNext() {
        return index < names.getLength();
    }

    @Override
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        String name = names.getAt(index);
        index++;
        return name;
    }

}
