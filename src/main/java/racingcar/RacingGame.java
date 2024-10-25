package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<RacingCar> cars = new ArrayList<>();
    private final int round;

    /**
     * RacingGame 생성자
     * @param carNames 자동차 이름 리스트
     * @param round 라운드 수
     */
    public RacingGame(List<String> carNames, int round) {
        this.round = round;
        createCar(carNames);
    }

    /**
     * 자동차를 생성하여 리스트에 추가합니다.
     * @param carNames 자동차 이름 리스트
     */
    private void createCar(List<String> carNames) {
        carNames.forEach(carName -> cars.add(new RacingCar(carName)));
    }

    /**
     * 게임을 시작합니다.
     */
    public void startGame() {
        for (int i = 0; i < round; i++) {
            playRound();
            printRoundResult();
        }
        printGameResult();
    }

    /**
     * 한 라운드를 플레이합니다.
     */
    private void playRound() {
        cars.forEach(car -> {
            if (shouldMove()) {
                car.forward();
            }
            car.stop();
        });
    }

    /**
     * 자동차가 이동할지 여부를 결정합니다.
     * @return 이동 여부
     */
    private boolean shouldMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    /**
     * 현재 라운드의 결과를 출력합니다.
     */
    private void printRoundResult() {
        System.out.println("실행 결과");

        cars.forEach(car -> {
            CarDTO dto = car.toDTO();
            System.out.print(dto.getCarName() + " : ");
            System.out.print("-".repeat(dto.getCurrentPosition())+"\n");
        });
    }

    /**
     * 최종 우승자를 출력합니다.
     */
    private void printGameResult() {
        List<CarDTO> winners = findWinners();
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners.stream()
                .map(CarDTO::getCarName)
                .toList()));
    }

    /**
     * 우승자를 찾습니다.
     * @return 우승자 DTO 리스트
     */
    private List<CarDTO> findWinners() {
        List<CarDTO> carDTOs = cars.stream()
                .map(Car::toDTO)
                .toList();

        int maxPosition = carDTOs.stream()
                .mapToInt(CarDTO::getCurrentPosition)
                .max()
                .orElse(0);

        return carDTOs.stream()
                .filter(dto -> dto.getCurrentPosition() == maxPosition)
                .collect(Collectors.toList());
    }

}
