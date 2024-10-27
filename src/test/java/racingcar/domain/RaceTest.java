package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {

    @Test
    void 경주차_생성_확인() {
        List<String> carsname = List.of("pobi", "woni", "jun");
        Race race = new Race(carsname);
        IntStream.range(0, carsname.size())
                .forEach(index -> assertThat(race.getCars().get(index).getCarname()).isEqualTo(carsname.get(index)));
    }
    
    @Test
    void 경주_주행_확인() {
        List<String> carsname = List.of("pobi", "woni", "jun");
        Race race = new Race(carsname);
        race.playOneRound();
        race.getCars().forEach(oneCar -> {
            System.out.println("oneCar.getCarDistance() = " + oneCar.getCarDistance());
        });
    }

    @Test
    void 이긴_차_찾기() {
        List<String> carsname = List.of("pobi", "woni", "jun");
        Race race = new Race(carsname);
        IntStream.range(0, 6)
                .forEach(index -> race.playOneRound());

        List<Car> winnerCars = race.getWinnerCars();
        winnerCars.forEach(wincar -> {
            System.out.println("wincar.carname = " + wincar.getCarname());
            System.out.println("wincar.distance = " + wincar.getCarDistance());
        });
    }
}