package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RacingGame {
    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 9;
    private static final int MOVE_THRESHOLD = 4;

    private final List<Car> cars;
    private final int attempts;
    private final StringBuilder roundBuilder;

    public RacingGame(List<Car> cars, int attempts) {
        this.cars = new ArrayList<>(cars);
        this.attempts = attempts;
        this.roundBuilder = new StringBuilder(cars.size() * 10);
    }

    public void play() {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<?>> futures = new ArrayList<>();

        for(int i = 0; i < attempts; i++) {
            futures.add(executor.submit(this::playRound));
        }

        futures.forEach(future -> {
            try {
                future.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        executor.shutdown();
    }

    private void playRound() {
        roundBuilder.setLength(0);
        for(Car car : cars) {
            int number = Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM);
            car.move(number >= MOVE_THRESHOLD);
            roundBuilder.append(car.toString()).append('\n');
        }
        System.out.print(roundBuilder.toString());
    }

    public List<String> getWinners() {
        int maxPosition = 0;
        for (Car car : cars) {
            int position = car.getPosition();
            if (position > maxPosition) {
                maxPosition = position;
            }
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}