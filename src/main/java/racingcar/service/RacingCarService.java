package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import racingcar.entity.RacingCar;
import racingcar.repository.RacingCarRepositoryImpl;
import racingcar.util.RacingCarValidator;
import racingcar.util.StringProcessor;

public class RacingCarService {

    private final RacingCarRepositoryImpl racingCarRepository;
    private static final StringProcessor stringProcessor = new StringProcessor();
    private static final RacingCarValidator racingCarValidator = new RacingCarValidator();

    public RacingCarService(RacingCarRepositoryImpl racingCarRepository) {
        this.racingCarRepository = racingCarRepository;
    }

    public RacingCar create(String carName) {
        return new RacingCar(carName);
    }

    public List<String> processingInputToList(String input) {

        List<String> carNames = new ArrayList<>();

        if(stringProcessor.hasMultipleCarNames(input)) {
            carNames.addAll(stringProcessor.splitCarNames(input));
        } else {
            carNames.add(input);
        }

        return carNames;
    }

    public void checkCarNamesValid(List<String> carNames) {
        for(String carName : carNames) {
            racingCarValidator.validateCarName(carName);
        }
    }

    public void saveAll(List<String> carNames) {
        for(String carName : carNames) {
            RacingCar racingCar = create(carName);
            racingCarRepository.save(racingCar);
        }
    }

    //FIXME : just for test
    public void printAllNames() {

        List<RacingCar> racingCars = racingCarRepository.findAll();

        for(RacingCar racingCar : racingCars) {
            System.out.println(racingCar.getName());
        }
    }

    //FIXME : just for test??
    public Optional<RacingCar> getByName(String name) {
        return racingCarRepository.findByName(name);
    }
}
