package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;
    private static final int CAN_MOVE_STANDARD = 4;

    public boolean canMove() {
        int n = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
        if (n >= CAN_MOVE_STANDARD) {
            return true;
        }
        return false;
    }

    public List<String> getWinners(List<Car> participants) {
        return participants.stream()
                .collect(Collectors.groupingBy(Car::getMovedCnt))  // movedCnt 기준으로 그룹화
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(Map.Entry::getKey))  // 가장 큰 movedCnt 그룹 찾기
                .map(entry -> entry.getValue().stream()
                        .map(Car::getName)
                        .collect(Collectors.toList()))  // 해당 그룹의 이름 리스트 생성
                .orElseThrow();  // 최대 movedCnt를 가진 Car 객체가 없으면 예외 발생
    }
}
