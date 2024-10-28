package racingcar.domain;

import racingcar.util.MovementStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;
    private final List<RoundResult> history;
    private int currentRound;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
        this.history = new ArrayList<>();
        this.currentRound = 0;
    }

    public void moveAll(MovementStrategy movementStrategy) {
        currentRound++;
        List<CarMovement> roundMoves = new ArrayList<>();

        cars.forEach(car -> {
            boolean moved = movementStrategy.shouldMove();
            car.move(moved);
            roundMoves.add(new CarMovement(car.getName(), moved));
        });

        history.add(new RoundResult(currentRound, roundMoves));
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public List<RankingEntry> getRankings() {
        return cars.stream()
                .map(car -> new RankingEntry(car.getName(), car.getPosition()))
                .sorted(Comparator.comparingInt(RankingEntry::getPosition).reversed())
                .collect(Collectors.toList());
    }

    public String getProgressBar() {
        int maxProgress = getMaxPosition();
        int totalDistance = maxProgress * cars.size();
        int currentDistance = cars.stream()
                .mapToInt(Car::getPosition)
                .sum();

        int percentage = totalDistance == 0 ? 0 : (currentDistance * 100) / totalDistance;
        int barLength = percentage / 5;  // 20칸 기준
        return "[" + "=".repeat(barLength) + " ".repeat(20 - barLength) + "] " + percentage + "%";
    }

    public GameStatistics getStatistics() {
        return new GameStatistics(
                currentRound,
                cars.stream()
                        .mapToDouble(car -> car.getForwardRate(currentRound))
                        .average()
                        .orElse(0.0),
                cars.stream()
                        .mapToInt(Car::getMaxConsecutiveForwards)
                        .max()
                        .orElse(0)
        );
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}