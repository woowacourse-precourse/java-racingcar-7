package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class RaceServiceTest {

    @Test
    @DisplayName("랜덤 생성 값이 4 이상이면 progress를 1 증가해야 한다.")
    void move() {
        List<String> players = List.of("a", "b", "c", "d");
        List<Car> cars = new ArrayList<>();

        for (String player : players) {
            cars.add(new Car(player));
        }

        int[] random = {1, 2, 3, 4};
        List<Integer> result = List.of(0, 0, 0, 1);

        for (int i = 0; i < random.length; i++) {
            RaceService.move(cars.get(i), random[i]);
        }

        for (int i = 0; i < 4; i++) {
            Assertions.assertThat(cars.get(i).getProgress()).isEqualTo(result.get(i));
        }
    }

    @Test
    @DisplayName("진행도가 가장 큰 참가자가 승자가 되어야 한다.")
    void findWinner() {
        List<String> players = List.of("a", "b", "c", "d");
        List<Integer> progress = List.of(1, 2, 3, 4);
        List<Car> cars = new ArrayList<>();
        List<String> winner = new ArrayList<>();

        for (int i = 0; i < players.size(); i++) {
            cars.add(new Car(players.get(i), progress.get(i)));
        }

        RaceService raceService = new RaceService();
        raceService.findWinner(cars, winner);

        Assertions.assertThat(winner).hasSize(1).contains("d");
    }

    @Test
    @DisplayName("진행도가 가장 큰 참가자가 여러명이면 모두 승자가 되어야 한다.")
    void findDuplicatedWinner() {
        List<String> players = List.of("a", "b", "c", "d");
        List<Integer> progress = List.of(1, 2, 4, 4);
        List<Car> cars = new ArrayList<>();
        List<String> winner = new ArrayList<>();

        for (int i = 0; i < players.size(); i++) {
            cars.add(new Car(players.get(i), progress.get(i)));
        }

        RaceService raceService = new RaceService();
        raceService.findWinner(cars, winner);

        Assertions.assertThat(winner).hasSize(2).containsAll(List.of("c", "d"));
    }
}