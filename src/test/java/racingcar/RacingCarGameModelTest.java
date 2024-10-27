package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingGameInitializationRequest;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarGameModelTest {
    private RacingCarGameModel gameModel;
    public ArrayList<ParticipantEntity> participantEntities;

    @BeforeEach
    void setUp() {
        gameModel = new RacingCarGameModel();
        participantEntities = new ArrayList<>();
    }

    @Test
    void 이름_반복횟수_공백_검증() {
        RacingGameInitializationRequest request = new RacingGameInitializationRequest("car1, car2", "5");
        gameModel.initializationGame(request);

        assertThat(gameModel.startGame()).isNotEmpty();
    }

    @Test
    void 이름_반복횟수_공백_예외처리_검증() {
        RacingGameInitializationRequest request = new RacingGameInitializationRequest("", "");

        assertThatThrownBy(() -> gameModel.initializationGame(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자는 2명이상 가능합니다.");
    }

    @Test
    void 참가자수_예외처리_검증() {
        RacingGameInitializationRequest request = new RacingGameInitializationRequest("car1", "3");

        assertThatThrownBy(() -> gameModel.initializationGame(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자는 2명이상 가능합니다.");
    }

    @Test
    void 참가자_이름_길이_검증() {
        RacingGameInitializationRequest request = new RacingGameInitializationRequest("car1car2, car3", "3");

        assertThatThrownBy(() -> gameModel.initializationGame(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자의 이름은 1글자 이상, 5자 이하만 가능합니다.");
    }

    @Test
    void 반복횟수_예외처리_검증() {
        RacingGameInitializationRequest request = new RacingGameInitializationRequest("car1, car2", "3d");

        assertThatThrownBy(() -> gameModel.initializationGame(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시행횟수는 숫자만 가능합니다.");
    }

    @Test
    void 반복횟수_테스트() {
        RacingGameInitializationRequest request = new RacingGameInitializationRequest("car1,car2", "3");
        gameModel.initializationGame(request);

        String result = gameModel.startGame();

        assertThat(result.split("\n\n").length).isEqualTo(3);
    }

    @Test
    void 참가자_한칸_전진_테스트() {
        RacingGameInitializationRequest request = new RacingGameInitializationRequest("car1,car2", "5");
        gameModel.initializationGame(request);

        simulateGameProgress(request, new int[]{1, 1});

        assertThat(participantEntities.get(0).getDistance().length()).isEqualTo(1);
        assertThat(participantEntities.get(1).getDistance().length()).isEqualTo(1);
    }

    @Test
    void 참가자_전진_테스트() {
        RacingGameInitializationRequest request = new RacingGameInitializationRequest("car1,car2", "5");
        gameModel.initializationGame(request);

        simulateGameProgress(request, new int[]{3, 4});

        assertThat(participantEntities.get(0).getDistance().length()).isEqualTo(3);
        assertThat(participantEntities.get(1).getDistance().length()).isEqualTo(4);
    }

    @Test
    void 단일_우승자_검증() {
        RacingGameInitializationRequest request = new RacingGameInitializationRequest("car1,car2, car3", "5");
        gameModel.initializationGame(request);
        gameModel.initializeParticipantsForTesting(request, new int[]{5,3,4});

        String result = gameModel.winnerParticipants();

        assertThat(result).isEqualTo("car1");
    }

    @Test
    void 다중_우승자_검증() {
        RacingGameInitializationRequest request = new RacingGameInitializationRequest("car1,car2, car3", "5");
        gameModel.initializationGame(request);
        gameModel.initializeParticipantsForTesting(request, new int[]{5,5,4});

        String result = gameModel.winnerParticipants();

        assertThat(result).isEqualTo("car1, car2");
    }

    private void simulateGameProgress(RacingGameInitializationRequest request, int[] distances) {
        String[] participants = request.participants().split(",");

        for (int i = 0; i < participants.length; i++) {
            ParticipantEntity participant = new ParticipantEntity(participants[i]);
            addDistance(participant, distances[i]);

            participantEntities.add(participant);
        }
    }

    private void addDistance(ParticipantEntity participant, int distance) {
        for (int i = 0; i < distance; i++) {
            participant.forward();
        }
    }
}