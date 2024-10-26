package racingcar.model.dto;

import racingcar.utils.validator.CarNamesValidator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/** 자동차 이름을 저장한 일급 컬력션 입력값 검증 기능 수행 */
public record CarNames(List<String> names) implements Iterable<String> {

    /**
     * 자동차 이름 문자열을 받아서 형식을 검증한 후 문자열로 반환하는 메서드
     *
     * @param 검증되지 않은 자동차 이름 문자열
     * @return CarNames 객체 반환
     * @throws 자동차 이름이 5글자 초과하거나 이름 중간에 알파벳, 한글, 숫자 이외의 문자가
     *         있으면 IllegalArgumentException 발생
     */
    public static CarNames getAfterValidateFormat(String namesToValidate) {
        CarNamesValidator.whiteSpace(namesToValidate);
        CarNamesValidator.illegalLetter(namesToValidate);
        CarNamesValidator.duplicateName(namesToValidate);

        List<String> names = List.of(namesToValidate.split(","));
        return new CarNames(names);
    }

    @Override
    public Iterator<String> iterator() {
        return new CarNamesIterator();
    }

    private final class CarNamesIterator implements Iterator<String> {

        private int index;

        private CarNamesIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < names.size();
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String name = names.get(index);
            index++;
            return name;
        }

    }

}
