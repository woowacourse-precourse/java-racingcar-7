## 📚 구현할 기능 목록들

### 프로그램 실행

- 자동차 경주 게임을 실행할 메서드 구현

### 입출력

- 자동차 이름 입력받기 메서드 구현
- 자동차 이동 횟수 입력받기 메서드 구현
- 매 횟수마다 출력하는 메서드 구현
- 최종 우승자 출력하는 메서드 구현

### 예외처리_유효성 검증

- 자동차 이름 유효성 검증하기 메서드 구현
    - 자동차 이름이 null이거나 공백인 경우 유효성 검증 메서드 구현
    - 자동차 이름에 개행 문자가 포함될 경우 유효성 검증 메서드 구현
    - 자동차 이름의 길이가 5이하인지 유효성 검증 메서드 구현
    - 자동차 이름에 공백이 포함될 경우 유효성 검증 메서드 구현
    - 자동차 이름이 중복이 될 경우 유효성 검증 메서드 구현
- 자동차 이동 횟수 유효성 검증하기 메서드 구현
    - 숫자가 null이거나 공백인 경우 유효성 검증 메서드 구현
    - 숫자에 개행 문자가 포함될 경우 유효성 검증 메서드 구현
    - 숫자에 공백이 존재할 경우 유효성 검증 메서드 구현
    - 숫자의 길이가 2이상이면서 0으로 시작하는 경우 유효성 검증 메서드 구현
    - 숫자가 Integer인지 유효성 검증 메서드 구현

### 도메인

- 구분자 “,”를 기준으로 입력 문자열 자르는 메서드 구현
- 자동차 객체 생성
    - 자동차 객체의 최종 Position 반환 메서드 구현
    - 자동차 객체의 현재 Position 반환 메서드 구현
    - 자동차 객체의 position 속성값 증가시키는 메서드 구현
    - 자동차 객체의 이름 반환하는 메서드 구현
- 자동차 게임 진행하는 메서드 구현
- Randoms.pickNumberInRange() 메서드 이용해서 전진 값 생성 메서드 구현
- 매 횟수 결과 누적하는 메서드 구현
- 최종 우승자 결정하는 메서드 구현
- 객체 타입의 리스트에서 가장 많이 전진한 객체의 index 반환하는 메서드 구현

### 데이터 저장 및 관리

- Enum 클래스 활용하여 출력 문구 관리
    - 출력 문구 반환하는 메서드 구현

### 테스트 코드 작성

- Car 클래스
- 자동차 게임 진행 관리 클래스(RacingCarGame)
- 자동차 그룹 관리 클래스(RacingCarsGroup)
- 자동차 이름 유효성 검증 클래스(CarNameValidation)
- 시도할 횟수 값 유효성 검증 클래스(InputNumberValidation)

## 📝구현 기능들 점검 리스트

### 프로그램 실행

- [X]  자동차 경주 게임을 실행할 메서드 구현

### 입출력

- [X]  자동차 이름 입력받기 메서드 구현
- [X]  자동차 이동 횟수 입력받기 메서드 구현
- [X]  매 횟수마다 출력하는 메서드 구현
- [X]  최종 우승자 출력하는 메서드 구현

### 예외처리_유효성 검증

- [X]  자동차 이름 유효성 검증하기 메서드 구현
    - [X]  자동차 이름이 null이거나 공백인 경우 유효성 검증 메서드 구현
    - [X]  자동차 이름에 개행 문자가 포함될 경우 유효성 검증 메서드 구현
    - [X]  자동차 이름의 길이가 5이하인지 유효성 검증 메서드 구현
    - [X]  자동차 이름에 공백이 포함될 경우 유효성 검증 메서드 구현
    - [X]  자동차 이름이 중복이 될 경우 유효성 검증 메서드 구현
- [X]  자동차 이동 횟수 유효성 검증하기 메서드 구현
    - [X]  숫자가 null이거나 공백인 경우 유효성 검증 메서드 구현
    - [X]  숫자에 개행 문자가 포함될 경우 유효성 검증 메서드 구현
    - [X]  숫자에 공백이 존재할 경우 유효성 검증 메서드 구현
    - [X]  숫자의 길이가 2이상이면서 0으로 시작하는 경우 유효성 검증 메서드 구현
    - [X]  숫자가 Integer인지 유효성 검증 메서드 구현

### 도메인

- [X]  구분자 “,”를 기준으로 입력 문자열 자르는 메서드 구현
- [X]  자동차 객체 생성
    - [X]  자동차 객체의 최종 Position 반환 메서드 구현
    - [X]  자동차 객체의 현재 Position 반환 메서드 구현
    - [X]  자동차 객체의 position 속성값 증가시키는 메서드 구현
    - [X]  자동차 객체의 이름 반환하는 메서드 구현
- [X]  자동차 게임 진행하는 메서드 구현
- [X]  Randoms.pickNumberInRange() 메서드 이용해서 전진 값 생성 메서드 구현
- [X]  매 횟수 결과 누적하는 메서드 구현
- [X]  최종 우승자 결정하는 메서드 구현
- [X]  객체 타입의 리스트에서 가장 많이 전진한 객체의 index 반환하는 메서드 구현

### 데이터 저장 및 관리

- [X]  Enum 클래스 활용하여 출력 문구 관리
    - [X]  출력 문구 반환하는 메서드 구현

### 테스트 코드 작성

- [X]  Car 클래스
- [X]  자동차 게임 진행 관리 클래스(RacingCarGame)
- [ ]  자동차 그룹 관리 클래스(RacingCarsGroup)
- [ ]  자동차 이름 유효성 검증 클래스(CarNameValidation)
- [ ]  시도할 횟수 값 유효성 검증 클래스(InputNumberValidation)