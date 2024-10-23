package service;

import dto.ValidatedInputDataDTO;
import policy.RacingPolicy;
import repository.Repository;
import vehicle.Car;

public class RacingCarService implements RacingService {
    private final ValidatedInputDataDTO validatedInputDataDTO;
    private final RacingPolicy racingPolicy;
    private final Repository repository;

    public RacingCarService(ValidatedInputDataDTO validatedInputDataDTO, RacingPolicy racingPolicy,
                            Repository repository) {
        this.validatedInputDataDTO = validatedInputDataDTO;
        this.racingPolicy = racingPolicy;
        this.repository = repository;
    }

    @Override
    public String racingStart() {
        String[] splitNames = validatedInputDataDTO.name().split(racingPolicy.getNameSeparator());
        generateCar(splitNames);
        return null;
    }

    @Override
    public Repository getRepository() {
        return this.repository;
    }

    @Override
    public RacingPolicy getRacingPolicy() {
        return this.racingPolicy;
    }

    public void generateCar(String[] splitNames) {
        for (String name:splitNames) {
            Car car = new Car(name, racingPolicy);
            if(repository.isDuplicateName(car.getVehicleName())){
                //TODO : exceptionMessage Enum 만들어서 관리 하기.
                throw new IllegalArgumentException("중복되는 이름은 사용할 수 없습니다.");
            };
            repository.save(car.getVehicleName(), car.getMoveForwardCount());
        }
    }
}
