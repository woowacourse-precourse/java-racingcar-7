package racingcar;

import java.util.List;

/**
 * 한 라운드의 결과를 나타내는 클래스. 자동차 경주 게임은 여러 라운드를 진행하며, 매 라운드마다 결과를 보여줘야 하기 때문에 이 클래스를 사용한다. (such as {@link RacingGame#determineRoundResult()})
 * @param positions
 */
public record RoundResult(List<Position> positions) {

    public List<Integer> extractResults() {
        return positions.stream()
                .map(Position::getPosition)
                .toList();
    }
}
