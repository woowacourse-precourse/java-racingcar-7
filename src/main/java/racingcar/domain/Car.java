package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String name;
    private final List<Boolean> reportCard;

    public Car(String name, int tryTimes) {
        if (isInvalidName(name) || isInvalidTryTimes(tryTimes)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.reportCard = new ArrayList<>(tryTimes);
        for (int i = 0; i < tryTimes; i++) {
            reportCard.add(movement());
        }
    }

    public String getName() {
        return name;
    }

    public List<Boolean> getReportCard() {
        return reportCard;
    }

    private boolean isInvalidName(String name) {
        return name == null || name.isEmpty() || name.length() > 5;
    }

    private boolean isInvalidTryTimes(int tryTimes) {
        return tryTimes <= 0;
    }

    private boolean movement() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
