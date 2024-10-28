# java-racingcar-precourse

## Car
- 각 자동차의 이름과 위치를 저장
- 이름은 최대 5자 이하로 제한
- 난수를 이용해 이동 조건을 설정하고, 조건 충족 시 전진
    - **메서드**: `move`

## Race
- 전체 레이스를 관리
- 라운드마다 각 자동차의 이동을 결정하고 이동 결과를 기록
    - **메서드**: `startRace`
- 레이스 종료 후 최종 우승자 결정
    - **메서드**: `getWinners`

## GameController
- 사용자 입력 및 출력을 담당
    - 게임 초기 설정: 자동차 이름, 이동 횟수 등 입력 받기
        - **메서드**: `getCarNames`, `getRounds`
- 전체 게임의 흐름을 제어
    - **메서드**: `startRace`, `displayRaceStatus`, `displayWinners`
- 잘못된 사용자 입력에 대한 예외 처리
    - 유효하지 않은 자동차 이름이나 이동 횟수 입력 시 `IllegalArgumentException` 발생

## 주의사항
- 들여쓰기 깊이(depth)는 최대 2까지만 허용
- 3항 연산자 사용 금지
- 메서드는 최대한 한 가지 역할만 수행하도록 구현
- JUnit 5와 AssertJ를 이용하여 테스트 코드 작성
