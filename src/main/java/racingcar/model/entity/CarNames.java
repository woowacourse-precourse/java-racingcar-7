package racingcar.model.entity;

import racingcar.utils.validator.CarNamesValidator;

import java.util.Iterator;
import java.util.List;

/** 자동차 이름을 저장한 일급 컬력션 입력값 검증 기능 수행 */
public class CarNames implements Iterable<String> {

    private final List<String> names;

    private CarNames(List<String> names) {
        this.names = names;
    }

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
        return new CarNamesIterator(this);
    }

    public int getLength() {
        return names.size();
    }

    public String getAt(int index) {
        return names.get(index);
    }

}
