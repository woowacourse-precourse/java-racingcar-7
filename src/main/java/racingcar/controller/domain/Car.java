package racingcar.controller.domain;

import camp.nextstep.edu.missionutils.Randoms;

public record Car(String name) {

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
