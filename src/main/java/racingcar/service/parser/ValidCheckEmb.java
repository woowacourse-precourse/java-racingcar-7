package racingcar.service.parser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidCheckEmb implements ValidCheck {
    @Override
    public void areCarNamesValid(List<String> carNames) {
        carNames.forEach(carName -> {if(carName.length() > 5) throw new IllegalArgumentException("자동차 이름이 5자 이하여야 합니다.");});
        carNames.forEach(carName -> {if(carName.isEmpty()) throw new IllegalArgumentException("자동차 이름을 1자 이상 넣어주세요.");});
        carNames.forEach(carName -> {if(carName.matches("^[\\s,]{1,5}$")) throw new IllegalArgumentException("자동차 이름을 공백이나 쉼표만으로 설정할 수 없습니다.");});
    }

    @Override
    public void isDuplicate(List<String> carNames) {
        Set<String> checkSet = new HashSet<>(carNames);
        if(checkSet.size() != carNames.size()) throw new IllegalArgumentException("중복된 이름이 있습니다.");
    }
}
