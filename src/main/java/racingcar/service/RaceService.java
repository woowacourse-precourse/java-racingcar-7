package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.repository.RaceRepository;
import racingcar.validation.LapValidator;
import racingcar.view.OutputView;

/**
 * packageName    : racingcar.service
 * fileName       : RaceService
 * author         : ehgur
 * date           : 2024-10-25
 * description    : 레이스 관련 로직을 구현한 서비스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-25         ehgur            최초 생성
 */

public class RaceService {
    //----- 싱글톤 패턴 적용 -----//
    private static final RaceService instance = new RaceService();
    private final RaceRepository raceRepository = RaceRepository.getInstance();
    private final CarService carService = CarService.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    private RaceService(){}
    public static RaceService getInstance() {
        return instance;
    }
    //------------------------//

    public Race createRace(String lap) {
        List<Car> carList = carService.findAll();
        Cars cars = new Cars(carList);

        return new Race(cars, Integer.parseInt(lap));
    }

    public void save(Race race) {
        raceRepository.save(race);
    }

    public Race findById(int id) {
        return raceRepository.findById(id);
    }

    public void isLapValid(String lap) {
        LapValidator.run(lap);
    }

    public void displayCarMovementByLap(Race race,StringBuilder output) {
        try {
            output.append("\n실행 결과");
            for (int i = 0; i < race.getLap(); i++) {
                race.updateCarDataByLap();
                outputView.displayResultByLap(race,output);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public String displayWinner(Race race, StringBuilder output) {
        Cars cars = race.getCars();
        int max = getMaxCarMovement(cars);

        try {
            outputView.displayWinner(max,cars,output);
            return output.toString();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private int getMaxCarMovement(Cars cars) {
        int max = 0;

        for (Car car : cars.getCars()) {
            int carMovement = car.getMoveCount();
            if (max < car.getMoveCount()) {
                max = carMovement;
            }
        }
        return max;
    }
}
