## 구현할 기능 목록

- 입력
    - 경주할 자동차 이름
    - 시도할 횟수
- 출력
    - 차수별 실행 결과
    - 우승자 안내 문구 (단독 우승자 및 공동 우승자 판별)
- 자동차 경주
    - 입력받은 자동차 이름 구분하기(쉼표(,) 기준)
    - 각 자동차 위치 업데이트 (무작위 값이 4 이상일 경우 전진 아닐 경우 멈춤)
    - 우승자 판별
- 예외 처리 (IllegalArgumentException)
    - 자동차 이름 입력받는 상황
        - `,`와 `,` 사이에 아무 것도 입력되지 않았을 경우
        - 경계에 `,`가 존재할 경우
        - 이름이 5자 이하가 아닐 경우
        - 아무것도 입력되지 않았을 경우
        - `,`가 존재하지 않을 경우 (자동차 한 대인 경우)
    - 시도할 횟수 입력받는 상황
        - 아무것도 입력하지 않았을 경우
        - 문자가 포함되었을 경우
        - 범위를 벗어난 경우 (범위 : 1 이상 1000 이하로 설정)

## 개발 방식

- **TDD(테스트 주도 개발) 방식**을 사용하여 기능을 구현합니다. 기본적으로 다음의 세 단계로 진행합니다.

    1. **테스트 코드 작성**: 구현하고자 하는 기능에 대한 테스트 코드를 작성합니다. 이 단계에서 테스트는 실패하게 됩니다. 

    2. **기능 구현**: 작성한 테스트를 통과할 수 있도록 최소한의 기능을 구현합니다. 

    3. **리팩토링**: 구현한 코드를 정리하고 최적화합니다.


- 테스트 코드가 명확할 경우, 3단계로 나누지 않고 2단계로 진행하겠습니다.