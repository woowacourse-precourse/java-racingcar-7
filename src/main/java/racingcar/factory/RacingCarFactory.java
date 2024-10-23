package racingcar.factory;

import racingcar.component.RacingCar;

import java.util.List;

public class RacingCarFactory {

    private final RacingCarMaker racingCarMaker;
    private final NamingProcessor namingProcessor;
    private final String namingInput;

    public RacingCarFactory(String namingInput) {
        this.racingCarMaker = new RacingCarMaker();
        this.namingProcessor = new NamingProcessor();
        this.namingInput = namingInput;
    }

    public List<RacingCar> createRacingCars() {
        List<String> names = namingProcessor.separateName(namingInput);
        namingProcessor.checkDuplication(names);

        return names.stream()
                .map(racingCarMaker::make)
                .toList();
    }

}
