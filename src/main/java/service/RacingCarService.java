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
    //TODO : 서비스가 레이싱 정책을 갖고있는게 맞을까..? car 객체가 가지고있어야 하는게 아니고..? 정책을 굳이 빈팩토리에서 주입해줘야할까? 그냥 상수모음인데..?
    private final RacingPolicy racingPolicy;
    //TODO : 서비스는 레이싱상태 레포지토리랑 카객체 레포지토리만 갖고있자. 근데 그러면 둘 다 동기화를 해줘야하는데 괜찮을까..?
    private final RacingCarRepository racingCarRepository;

    public RacingCarService(ValidatedInputDataDTO validatedInputDataDTO, RacingPolicy racingPolicy,
                            RacingCarRepository racingCarRepository) {
        this.validatedInputDataDTO = validatedInputDataDTO;
        this.racingPolicy = racingPolicy;
        this.racingCarRepository = racingCarRepository;
    }

    @Override
    public RacingOutputDTO racingStart() {
        String[] splitNames = splitCarName();
        generateRacer(splitNames);
        String raceStatus = runRace(splitNames);
        String raceWinner = fineRaceWinner();

        return new RacingOutputDTO(raceStatus, raceWinner);
    }

    private String[] splitCarName() {
        if(!validatedInputDataDTO.name().contains(racingPolicy.getNameSeparator())
                && validatedInputDataDTO.name().length()>racingPolicy.getNameLengthPolicy()){
            throw new IllegalArgumentException("이름 사이에는 " + racingPolicy.getNameSeparator() + " 구분자를 넣어주세요");
        }
        return validatedInputDataDTO.name().split(racingPolicy.getNameSeparator());
    }

    @Override
    public void generateRacer(String[] splitNames) {
        for (String name:splitNames) {
            Car car = new Car(name,racingPolicy);
            if(racingCarRepository.isDuplicateName(car.getVehicleName())){
                //TODO : exceptionMessage Enum 만들어서 관리 하기.
                throw new IllegalArgumentException("중복되는 이름은 사용할 수 없습니다.");
            };
            racingCarRepository.save(car.getVehicleName(),car);
        }
    }


    /**
     * 전체 턴만 출력된다.
     * @param splitNames
     * @return 레이스 전체턴 진행결과
     */
    @Override
    public String runRace(String[] splitNames){
        StringBuilder stringBuilder = new StringBuilder();
        
        for (int i = 0; i < validatedInputDataDTO.count(); i++) {
            if(i < validatedInputDataDTO.count()-1){
                stringBuilder.append(executeRaceTurn(splitNames)).append("\n");
            }else {
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
        for (int i = 0; i < winners.size(); i++) {
            if(i< winners.size()-1){
                stringBuilder.append(winners.get(i)).append(","); 
            }else {
                stringBuilder.append(winners.get(i));
            }
        }
        return stringBuilder.toString();
    }

    public RacingCarRepository getRacingCarRepository() {
        return racingCarRepository;
    }
}
