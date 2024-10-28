package racingcar.race;

import racingcar.car.Car;
import racingcar.progress.Progress;

import java.util.*;

public class Race {
    private final List<Car> racingCars = new ArrayList<>();
    private final LinkedHashMap<String, Progress> progressMap = new LinkedHashMap<>();

    public Race(List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (String name : carNames) {
            racingCars.add(new Car(name));
            progressMap.put(name, new Progress());
        }
    }

    public LinkedHashMap<String, Integer> getRaceProgress() {
        LinkedHashMap<String, Integer> raceProgress = new LinkedHashMap<>();
        for (Car racingCar : racingCars) {
            String name = racingCar.getName();
            Integer progress = progressMap.get(name).getProgress();

            raceProgress.put(name, progress);
        }
        return raceProgress;
    }

    public void updateProgress(String carName) {
        Progress progress = progressMap.get(carName);
        if (progress == null) {
            throw new IllegalArgumentException("car not found");
        }
        Integer now = progress.getProgress();
        progress.setProgress(now + 1);
    }

    public List<String> getWinners() {
        Collection<Progress> allProgress = progressMap.values();

        int maxPosition = allProgress.stream()
                .mapToInt(Progress::getProgress)
                .max()
                .orElse(0);

        List<String> winners = new ArrayList<>();

        for (Car car : racingCars) {
            if (progressMap.get(car.getName()).getProgress() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

}
