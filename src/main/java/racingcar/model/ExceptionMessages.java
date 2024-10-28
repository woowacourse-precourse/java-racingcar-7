package racingcar.model;

public class ExceptionMessages {
    public class Car {
        public static final String LENGTH_OF_NAME_EXCEED = "자동차의 이름은 5자 이하여야 합니다.";
    }

    public class Cars {
        public static final String DUPLICATE_CAR_NAME = "중복된 이름이 존재합니다.";
        public static final String NO_REGISTERED_CARS = "등록된 차량이 없습니다.";
    }

    public class Game {
        public static final String INSUFFICIENT_CAR_COUNT = "최소 2대 이상 출전해야 합니다.";
        public static final String NO_REGISTERED_WINNERS = "아직 우승자들이 등록되지 않았습니다.";
    }

    public class TotalRounds {
        public static final String TOTAL_ROUNDS_BELOW_MINIMUM = "총 라운드 수는 2회 이상이어야 합니다.";
        public static final String TOTAL_ROUNDS_ABOVE_MAXIMUM = "총 라운드 수는 10회 이하여야 합니다.";
    }
}
