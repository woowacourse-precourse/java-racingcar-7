package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import racingcar.dto.ExecuteRaceResultDTO;
import racingcar.dto.RacingOutputDTO;
import racingcar.dto.ValidatedInputDataDTO;
import racingcar.exception.ExceptionMessage;
import racingcar.infrastructure.RacingCarHistory;

public class CarRacing implements Racing{
    private final ValidatedInputDataDTO validatedInputDataDTO;
    private final RacingPolicy racingPolicy;
    private final RacingCarHistory racingCarHistory;


    public CarRacing(ValidatedInputDataDTO validatedInputDataDTO, RacingPolicy racingPolicy,
                     RacingCarHistory racingCarHistory) {
        this.validatedInputDataDTO = validatedInputDataDTO;
        this.racingPolicy = racingPolicy;
        this.racingCarHistory = racingCarHistory;
    }

    @Override
    public RacingOutputDTO racingStart() {
        String[] splitNames = validatedInputDataDTO.name().split(racingPolicy.getNameSeparator());
        generateRacer(splitNames);
        String raceStatus = runRace();
        String raceWinner = fineRaceWinner(validatedInputDataDTO.count());

        return new RacingOutputDTO(raceStatus, raceWinner);
    }

    @Override
    public void generateRacer(String[] splitNames) {
        List<Car> cars = new ArrayList<>();
        for (String name:splitNames) {
            Car car = new Car(name);
            cars.add(car);
        }
        racingCarHistory.addRound(0, cars);
    }


    /**
     * 전체 레이스경기가 실행된다.
     * @return 레이스 전체턴 진행결과
     */
    @Override
    public String runRace(){
        List<String> raceTurn = new ArrayList<>();
        //TODO : 여기 더 깔끔하게 코드 리팩터링 필요
        for (long i = 0; i < validatedInputDataDTO.count(); i++) {
            ExecuteRaceResultDTO resultDTO = executeRaceTurn(racingCarHistory.getCars(i));
            raceTurn.add(resultDTO.executeResult());
            racingCarHistory.addRound(i+1,resultDTO.cars());
        }

        return String.join("\n", raceTurn);
    }

    /**
     * 한 턴만 출력된다.
     * @param carList 이전 경기 기록
     * @return 레이스 한턴 진행결과
     */
    public ExecuteRaceResultDTO executeRaceTurn(List<Car> carList) {
        //TODO: 리팩터링 필요
        ArrayList<Car> newRoundRacingCars = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (Car car : carList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if(racingPolicy.isMoveForward(randomNumber)){
                car.move();
            }
            newRoundRacingCars.add(car);
            stringBuilder.append(car.getVehicleName()).append(" : ")
                    .append(racingPolicy.getMoveForwardSymbol().repeat(
                            car.getMoveForwardCount().intValue())).append("\n");
        }

        return new ExecuteRaceResultDTO(newRoundRacingCars, stringBuilder.toString());
    }

    /**
     * 라운드 별 경기 우승자를 찾는다.
     * @param round 찾고자 하는 라운드
     * @return 해당 라운드의 우승자 이름 List
     */
    @Override
    public String fineRaceWinner(Long round){
        List<String> winnerList = new ArrayList<>();
        List<Car> carList = racingCarHistory.getCars(round);
        if(carList.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessage.NO_PARTICIPANTS_IN_ROUND.getMessage());
        }
        carList.sort(Comparator.comparingLong(Car::getMoveForwardCount).reversed());
        for (Car car:carList) {
            if(winnerList.isEmpty()){
                winnerList.add(car.getVehicleName());
            }
            if(!car.getVehicleName().equals(carList.get(0).getVehicleName())
                    && car.getMoveForwardCount().equals(carList.get(0).getMoveForwardCount())){
                winnerList.add(car.getVehicleName());
            }
        }
        return String.join(",", winnerList);
    }
}
