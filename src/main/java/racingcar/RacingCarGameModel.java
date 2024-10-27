package racingcar;

import racingcar.dto.RacingGameInitializationRequest;

import java.util.ArrayList;

public class RacingCarGameModel {
    ArrayList<ParticipantEntity> participantEntities = new ArrayList<>();

    public void initializationGame(RacingGameInitializationRequest request) {
        String[] participants = request.participants().split(",");

        for (String participant : participants) {
            participantEntities.add(new ParticipantEntity(nameValidation(participant)));
        }
    }

    private String nameValidation(String name) {
        name = name.trim();

        if (name.length() > 5 || name.isEmpty()) {
            throw new IllegalArgumentException("참가자의 이름은 1글자 이상, 5자 이하만 가능합니다.");
        }

        return name;
    }
}
