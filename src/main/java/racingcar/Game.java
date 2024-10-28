package racingcar;

import racingcar.io.Reader;
import racingcar.io.Writer;
import racingcar.randomgenerator.JavaRandomGenerator;

import java.util.Arrays;
import java.util.List;

public class Game {
    private final Reader reader;
    private final Writer writer;

    public Game(Reader reader, Writer writer){
        this.reader = reader;
        this.writer = writer;
    }

    public void play(){
        List<String> players = recruitPlayers();
        Cars cars = new Cars(players, new JavaRandomGenerator());

        int round = readRound();

        writer.write("실행 결과");
        for(int i=0; i< round; i++){
            cars.race();
            System.out.println();
        }
        announceWinners(cars);
    }
    public List<String> recruitPlayers(){
        writer.write("경주할 자동차 이름을 입력하세요.(이름은 쉼표 (,) 기준으로 구분)");
        String input = reader.read();
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }
    public int readRound() {
        writer.write("시도할 횟수는 몇회 인가요?");
        int round = Integer.parseInt(reader.read());
        return round;
    }
    private void announceWinners(Cars cars) {
        String winners = cars.getWinners();
        writer.write("최종 우승자:" + winners);
    }
}
