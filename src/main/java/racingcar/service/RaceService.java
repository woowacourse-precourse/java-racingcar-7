package racingcar.service;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
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

    private final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public Race createRace(int lap) {
        List<Car> carList = carService.findAll();
        Cars cars = new Cars(carList);

        return new Race(cars, lap);
    }

    public void save(Race race) {
        raceRepository.save(race);
    }

    public Race findById(int id) {
        return raceRepository.findById(id);
    }

    public void isLapValid(int lap) {
        LapValidator.run(lap);
    }

    public void displayCarMovementByLap(Race race) {
        try {
            bw.newLine();
            bw.write("실행 결과");
            for (int i = 0; i < race.getLap(); i++) {
                race.updateCarDataByLap();
                outputView.displayResultByLap(race,bw);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public void displayWinner(Race race) {
        Cars cars = race.getCars();
        int max = 0;

        try {
            for (Car car : cars.getCars()) {
                int carMovement = car.getMoveCount();
                if (max < car.getMoveCount()) {
                    max = carMovement;
                }
            }
            outputView.displayWinner(max,cars,bw);
            bw.flush();
            bw.close();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
