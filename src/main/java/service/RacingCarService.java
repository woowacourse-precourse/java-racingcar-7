package service;

import camp.nextstep.edu.missionutils.Randoms;
import dto.RacingOutputDTO;
import dto.ValidatedInputDataDTO;
import java.util.List;
import policy.RacingPolicy;
import repository.RacingCarRepository;
import vehicle.Car;

public class RacingCarService implements RacingService {
    private final ValidatedInputDataDTO validatedInputDataDTO;
    private final RacingPolicy racingPolicy;
    private final RacingCarRepository racingCarRepository;

    public RacingCarService(ValidatedInputDataDTO validatedInputDataDTO, RacingPolicy racingPolicy,
                            RacingCarRepository racingCarRepository) {
        this.validatedInputDataDTO = validatedInputDataDTO;
        this.racingPolicy = racingPolicy;
        this.racingCarRepository = racingCarRepository;
    }

    @Override
    public RacingOutputDTO racingStart() {
        String[] splitNames = validatedInputDataDTO.name().split(racingPolicy.getNameSeparator());
        generateRacer(splitNames);
        String raceStatus = runRace(splitNames);
        String raceWinner = fineRaceWinner();

        return new RacingOutputDTO(raceStatus, raceWinner);
    }

    @Override
    public void generateRacer(String[] splitNames) {
        for (String name:splitNames) {
            Car car = new Car(name,racingPolicy);
            racingCarRepository.save(car.getVehicleName(),car);
        }
    }


    /**
     * 전체 레이스경기가 실행된다.
     * @param splitNames : 중복없이 구분자를 기준으로 자른 자동차 이름
     * @return : 레이스 전체턴 진행결과
     */
    @Override
    public String runRace(String[] splitNames){
        StringBuilder stringBuilder = new StringBuilder();
        //TODO : 여기 더 깔끔하게 코드 리팩터링 필요
        for (int i = 0; i < validatedInputDataDTO.count(); i++) {
            if(i < validatedInputDataDTO.count()-1){
                stringBuilder.append(executeRaceTurn(splitNames)).append("\n");
            }
            if(i == validatedInputDataDTO.count()-1){
                stringBuilder.append(executeRaceTurn(splitNames));
            }
        }

        return stringBuilder.toString();
    }

    /**
     * 한 턴만 출력된다.
     * @param splitNames
     * @return 레이스 한턴 진행결과
     */
    public String executeRaceTurn(String[] splitNames) {
        //TODO: 리팩터링 필요
        StringBuilder stringBuilder = new StringBuilder();
        for (String name: splitNames) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if(racingPolicy.isMoveForward(randomNumber)){
                racingCarRepository.find(name).move();
                racingCarRepository.save(name, racingCarRepository.find(name));
            }
            stringBuilder.append(name).append(" : ")
                    .append(racingPolicy.getMoveForwardSymbol().repeat(racingCarRepository.find(name).getMoveForwardCount().intValue())).append("\n");
        }

        return stringBuilder.toString();
    }

    @Override
    public String fineRaceWinner(){
        List<String> winners = racingCarRepository.findWinner();
        StringBuilder stringBuilder = new StringBuilder();
        //TODO : 여기 더 깔끔하게 코드 리팩터링 필요
        for (int i = 0; i < winners.size(); i++) {
            if(i< winners.size()-1){
                stringBuilder.append(winners.get(i)).append(","); 
            }
            if(i == winners.size()-1){
                stringBuilder.append(winners.get(i));
            }
        }
        return stringBuilder.toString();
    }

    public RacingCarRepository getRacingCarRepository() {
        return racingCarRepository;
    }
}
