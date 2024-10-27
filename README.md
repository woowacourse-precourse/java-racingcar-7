# 🚗 자동차 경주 게임 🏁

## 기능 명세서

> 📝 기능 명세서는 프로그램 실행 흐름에 따라 작성한다.<br/>
> ☑️ 기능 구현은 주요 기능부터 먼저 구현한다.<br/>
> ⚠️ 경주는 경쟁 상대가 있어야 하므로 유효한 이름을 2개 이상 입력해야 게임을 진행할 수 있다.

### 경주할 자동차들의 이름을 입력받는다.

- [X] 자동차 이름 입력을 요청하는 메시지를 출력한다.
- [X] 입력된 문자열을 쉼표(,)를 기준으로 구분해 이름을 추출한다.
- [X] 잘못된 값을 입력할 경우 `IllegalArgumentException`을 던진다.
    - [X] 이름을 1개만 입력할 경우(쉼표 구분이 없는 경우)
    - [X] 5자가 넘는 이름을 입력할 경우
    - [X] 이름이 중복일 경우

### 전진 시도 횟수를 입력받는다.

- [X] 시도 횟수 입력 안내 메시지를 출력한다.
- [X] 입력된 문자열을 자연수로 변환한다.
- [X] 잘못된 값을 입력할 경우 `IllegalArgumentException`을 던진다.
    - [X] 0~9로 이루어진 문자열이 아닌 경우
    - [X] 1 미만의 수를 입력한 경우

### 자동차 경주를 진행한다.

- [X] 실행 결과 문구를 출력한다.
- [X] 사용자가 입력한 시도 횟수만큼 반복한다.
    - [X] 모든 자동차가 전진을 1번 시도한다.
        - [X] 0부터 9까지의 정수 중 무작위 값을 1개 뽑는다.
        - [X] 무작위 값이 4 이상이면 전진한다.
    - [X] 한 라운드 실행 결과를 출력한다.
        - [X] 1줄에 자동차 1개씩 이름과 현재 위치를 출력한다.

### 게임 종료 후 우승자를 찾는다.

- [X] 자동차들의 현재 위치값 중 최대값을 찾는다.
- [X] 최대위치값을 가진 자동차들의 이름을 리턴한다.

### 우승자를 알려준다.

- [X] 우승자 안내 문구를 출력한다.
    - [X] 우승자의 이름을 출력한다.
    - [X] 공동 우승자는 쉼표(,)를 이용하여 구분한다.

### `IllegalArgumentException`이 발생하면 애플리케이션을 종료한다.