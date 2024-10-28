package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Game {
    // 게임 시작 설정 및 라운드 결과 출력
    private final List<racingcar.Car> cars;
    private final int rounds;   // 시도 횟수

    public Game() {
        this.cars = getCarName();
        this.rounds = inputRoundCount();
    }
}