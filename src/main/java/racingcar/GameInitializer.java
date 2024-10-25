package racingcar;

import java.util.Set;

/** 유저 input 을 받아 게임의 초기 세팅을 담당하는 클래스 */
public class GameInitializer {

    /**
      자동차 이름 입력 및 검증
      쉼표로 구분된 자동차 이름을 입력받는다.
      각 자동차 이름이 5자 이하여야 하며, 유효성을 검증한다.
      이름이 유효하지 않을 경우 IllegalArgumentException 을 발생시킨다.
     */
    private static void initRacingCars(CarRace race) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = OhMyConsole.readLine();
        String[] carNames = input.split(",");

        Set<String> participantNames = race.getParticipantNames();

        for (String carName : carNames) {
            /* 자동차 이름 앞뒤 공백 제거 */
            String cleanedCarName = carName.trim();

            if (cleanedCarName.isEmpty() || participantNames.contains(cleanedCarName)) {
                throw new IllegalArgumentException();
            }

            try {
                race.addParticipants(cleanedCarName);
            } catch (CarRace.DuplicateCarNameException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void initRaceRound(CarRace race) {

        System.out.println("시도할 횟수는 몇 회인가요?");
        String numRoundStr = OhMyConsole.readLine();

        try {
            int numRound = Integer.parseInt(numRoundStr);
            race.setNumRounds(numRound);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }



    /** GameInitializer 클래스의 프로시져 함수 */
    public static void initGame(CarRace race) {

        initRacingCars(race);
        initRaceRound(race);
    }
}
