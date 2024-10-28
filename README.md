# java-racingcar-precourse

# 자동차 경주 게임

## 🚀 기능 요구 사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다

## 구현할 기능 목록

### 1단계: 자동차 도메인 설계
- [ ] **자동차 상태 관리**
    - 이름, 위치 관리
    - 전진 시 위치 증가
    - 이름, 위치 출력 

- [ ] **원시값 포장**
    - Name: 이름 관리
    - Position: 위치 이동, 비교
    - Cars: 자동차들의 집합

### 2단계: 게임 핵심 로직
- [ ] **경주 진행**
    - 무작위 값 (0-9) 생성
    - 4 이상일 때 전진
    - 입력받은 횟수만큼 실행

- [ ] **우승자 판별**
    - 최대 이동 거리 자동차 선정
    - 공동 우승 처리

### 3단계: 사용자 인터페이스
- [ ] **입력**
    - 쉼표 구분된 자동차 이름들
    - 시도 횟수

- [ ] **출력**
    - 각 차수별 실행 결과
    - 최종 우승자

## 제한 사항
### 입력 제한
- 자동차 이름 5자 이하
- 시도 횟수는 양의 정수
- 이름에 공백이나 빈 값, `\` 문자 불가

### 출력 형식
- 자동차 이름: 위치(-) 형식
- 우승자는 쉼표(,) 구분

### 예외 처리
- 이름이 5자 초과인 경우
- 이름이 공백/null인 경우
- 시도 횟수가 양의 정수가 아닌 경우
- 모든 예외는 IllegalArgumentException 발생 후 종료

### 입출력 요구사항

#### 입력
- 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
- 시도할 회수

#### 출력
- 각 차수별 실행 결과는 각 자동차 이름을 같이 출력한다.
- 자동차 이름: 현재 위치 표시
- 우승자 안내 문구

예시:
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```