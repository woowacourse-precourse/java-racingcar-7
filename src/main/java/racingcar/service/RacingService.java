package racingcar.service;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public class RacingService {
    private static final RacingService instance = new RacingService();

    private RacingService() {}

    public static RacingService getInstance() {
        return instance;
    }

    public List<Car> initializeCars(List<String> names) {
        return names.stream()
                .map(Car::new)
                .toList();
    }

    public void validateInput(List<Car> cars, int count) {
        for (Car car : cars) {
            if (car.getName().length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5글자 이하만 가능합니다.");
            }
        }
        if (cars.size() < 2) {
            throw new IllegalArgumentException("자동차는 최소 2대가 입력되어야 합니다.");
        }
        if (count < 1) {
            throw new IllegalArgumentException("횟수는 최소 1번 이상 입력되어야 합니다.");
        }
    }

    public void playGame(List<Car> cars, int count) {
        StringBuilder sb = new StringBuilder("실행 결과\n");
        for (int i = 0; i < count; i++) {
            playRound(cars, sb);
        }
        sb.append("최종 우승자 : ").append(findWinner(cars));
        System.out.println(sb);
    }

    private void playRound(List<Car> cars, StringBuilder sb) {
        for (Car car : cars) {
            if (camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9) >= 4) {
                car.addMove();
            }
            sb.append(car.getName())
                    .append(" : ")
                    .append("-".repeat(car.getMove()))
                    .append("\n");
        }
        sb.append("\n");
    }

    private String findWinner(List<Car> cars) {
        PriorityQueue<Car> pq = new PriorityQueue<>((o1, o2) -> o2.getMove() - o1.getMove());
        pq.addAll(cars);

        List<String> winners = new ArrayList<>();
        Car car = pq.poll();
        winners.add(Objects.requireNonNull(car).getName());
        while (!pq.isEmpty() && pq.peek().getMove() == car.getMove()) {
            winners.add(Objects.requireNonNull(pq.poll()).getName());
        }

        return String.join(", ", winners);
    }
}
