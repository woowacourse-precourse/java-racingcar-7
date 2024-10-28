package racingcar.service;

import java.util.List;
import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;
import racingcar.model.car.Car;
import racingcar.model.game.Race;

public class RaceService implements GameService<RaceRequest, RaceResponse> {

    private CarService carService;

    public RaceService() {
        this.carService = new RaceCarService();
    }

    public RaceResponse startGame(RaceRequest request) {

        String carInput = request.getCarInput();
        int tryCount = request.getTryCount();

        List<Car> cars = carService.createCars(carInput);
        Race track = new Race(tryCount);
        cars.forEach(track::addCar);
        return new RaceResponse(track.simulate());
    }
}
