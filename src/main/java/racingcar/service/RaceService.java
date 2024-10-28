package racingcar.service;

import racingcar.dto.RaceRequest;

/**
 * 경주 서비스 인터페이스입니다.
 * <p>
 * 이 인터페이스는 경주를 시작하는 기능을 정의합니다.
 * </p>
 */
public interface RaceService {

    /**
     * 경주를 시작합니다.
     *
     * @param request 경주를 시작하기 위한 요청 객체
     * @return 경주 시작에 대한 결과 메시지
     * @throws IllegalArgumentException 요청이 유효하지 않은 경우 발생하는 예외
     */
    String startRace(RaceRequest request) throws IllegalArgumentException;
}
