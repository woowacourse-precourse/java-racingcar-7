package service;

import dto.ValidatedInputDataDTO;
import java.util.List;
import policy.RacingPolicy;
import repository.Repository;
import vehicle.Car;

public class RacingCarService implements RacingService {
    private final ValidatedInputDataDTO validatedInputDataDTO;
    //TODO : 서비스가 레이싱 정책을 갖고있는게 맞을까..? car 객체가 가지고있어야 하는게 아니고..? 정책을 굳이 빈팩토리에서 주입해줘야할까? 그냥 상수모음인데..?
    private final RacingPolicy racingPolicy;
    //TODO : 서비스는 레이싱상태 레포지토리랑 카객체 레포지토리만 갖고있자. 근데 그러면 둘 다 동기화를 해줘야하는데 괜찮을까..?
    private final Repository raceStatusRepository;

    public RacingCarService(ValidatedInputDataDTO validatedInputDataDTO, RacingPolicy racingPolicy,
                            Repository raceStatusRepository) {
        this.validatedInputDataDTO = validatedInputDataDTO;
        this.racingPolicy = racingPolicy;
        this.raceStatusRepository = raceStatusRepository;
    }

    @Override
    public String racingStart() {
        String[] splitNames = validatedInputDataDTO.name().split(racingPolicy.getNameSeparator());
        generateRacer(splitNames);
        String raceStatus = runRace(splitNames);
        String raceWinner = fineRaceWinner();

        return raceStatus + ("\n")+raceWinner;
    }

    @Override
    public Repository getRaceStatusRepository() {
        return this.raceStatusRepository;
    }

    @Override
    public RacingPolicy getRacingPolicy() {
        return this.racingPolicy;
    }

    @Override
    public void generateRacer(String[] splitNames) {
        for (String name:splitNames) {
            Car car = new Car(name, racingPolicy);
            if(raceStatusRepository.isDuplicateName(car.getVehicleName())){
                //TODO : exceptionMessage Enum 만들어서 관리 하기.
                throw new IllegalArgumentException("중복되는 이름은 사용할 수 없습니다.");
            };
            raceStatusRepository.save(car.getVehicleName(), car.getMoveForwardCount());
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
            stringBuilder.append(executeRaceTurn(splitNames)).append("\n");
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
            if(racingPolicy.isMoveForward()){
                raceStatusRepository.save(name, raceStatusRepository.find(name)+1L);
            }
            stringBuilder.append(name).append(" :")
                    .append(racingPolicy.getMoveForwardSymbol().repeat(raceStatusRepository.find(name).intValue())).append("\n");
        }

        return stringBuilder.toString();
    }

    @Override
    public String fineRaceWinner(){
        List<String> winners = raceStatusRepository.findWinner();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            if(i< winners.size()-1){
                stringBuilder.append(winners.get(i)).append(","); 
            }else {
                stringBuilder.append(winners.get(i));
            }
        }
        return stringBuilder.toString();
    }



}
