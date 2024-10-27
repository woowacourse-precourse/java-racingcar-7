package racingcar.service.parser;

import java.util.List;

public interface ValidCheck {
    void areCarNamesValid(List<String> carNames);
    void isDuplicate(List<String> cars);
}
