package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingMachine {
    Cars players;
    int round;

    public RacingMachine() {}

    void run() {
        initialization();
        racing();
        printResult();
    }

    private void initialization() {
        initCars();
        initRound();
    }

    private void racing() {
        System.out.println("실행 결과");
        for ( int i = 0; i < round; i++ ) {
            rollTheDice();
            printScore();
        }
    }

    private void printResult() {
        Cars winners = players.getWinners();

        StringBuilder racingResult = new StringBuilder("최종 우승자 : ");
        boolean isFirst = true;
        for ( int i = 0; i < winners.getSize(); i ++ ) {
            if (isFirst) {
                racingResult.append(winners.getCar(i).getName());
                isFirst = false;
            } else {
                racingResult.append(", ").append(winners.getCar(i).getName());
            }
        }

        System.out.println(racingResult);
    }

    private void initCars() {
        players = new Cars();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = InputHandler.readInputName();
        for ( String name : names ) {
            players.addCar(new Car(name));
        }
    }

    private void initRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        round = InputHandler.readInputRound();
    }

    private void rollTheDice() {
        for ( int i = 0; i < players.getSize(); i++ ) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                players.getCar(i).goAhead();
            }
        }
    }

    private void printScore() {
        for ( int i = 0; i < players.getSize(); i++ ) {
            StringBuilder roundResult = new StringBuilder(players.getCar(i).getName()).append(" : ");
            roundResult.append("-".repeat(players.getCar(i).getPos()));
            System.out.println(roundResult);
        }
        System.out.println();
    }
}
