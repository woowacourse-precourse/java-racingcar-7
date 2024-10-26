package racingcar.service.factory;

import racingcar.model.RacingCar;
import racingcar.model.RacingCarEmb;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactoryEmb implements CarFactory {
    @Override
    public List<RacingCar> createCars(List<String> participants) {
        return participants.stream()
                .map(RacingCarEmb::new) // RacingCarEmb 생성자 참조
                .collect(Collectors.toList()); // List로 수집
    }
}
