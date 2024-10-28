# java-racingcar-precourse
> ⁜ **우아한테크코스 웹 백엔드 7기 프리코스 2주차 미션** (_Implemented by_ `yummygyudon(정동규)`)

##  기능 목록
### 도메인
- [x] **자동차** 
    - [x] 이름 저장
      - [x] 5글자 제한
    - [x] 이동(전진/정지)
    - [x] 위치 반환

### 연산
- [x] 이동
  - [x] 0-9 사이 무작위 값 반환
  - [x] 전진 여부 반환
- [x] 순위
  - [x] 복수의 차량 위치값 기반 순위 반환

### 입출력
- [x] **입력** 기능
  - [x] 자동차 이름 입력
  - [x] 횟수 입력
- [x] **출력** 기능
    - [x] 입력 요청 문구 출력 
      - [x] 자동차 이름(`경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`)
      - [x] 시도 횟수(`시도할 횟수는 몇 회인가요?`)
    - [x] 각 시도마다의 차량 위치 출력
    - [x] 결과 출력 문구
      - [x] 실행 결과 (`실행 결과`)
      - [x] 각 자동차 위치 (`${Car Name} : -`)
      - [x] 최종 우승자 (`최종 우승자 : ${Winner}, ${Winner}`)

<br/>

### 예외 처리 (`IllegalArgumentException`)
- [x] 빈 값 입력
- [x] 자동차 이름 입력
- [x] 횟수 입력
  - [x] `[0-9]+` 이외의 문자
- [x] 자동차
  - [x] 이름 5자 초과


<br/>

---
## 🚀 프리코스 목표 달성 여부
- [ ] 기술 아티클 1개 이상 작성
- [x] 적극적인 테스트 적용
- [x] 코드 리뷰(1주차 미션)
- [x] 회고(1주차 미션)

<br/>

---

## ⚙️  기능 요구 사항
> 초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- **사용자가 잘못된 값을 입력할 경우** `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

<br/>

### 입출력

[ **입력** ]

-  경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
    ```text
    pobi,woni,jun
    ```
- 시도할 횟수
  ```text
  5
  ```

<br/>

[ **출력** ]

- 차수별 실행 결과
    ```
    pobi : --
    woni : ----
    jun : ---
    ```
- 우승자 안내 문구
  - 단독 우승
    ```
    최종 우승자 : pobi
    ```
  - 공동 우승
    ```
    최종 우승자 : pobi, jun
    ```

<br/>

[ **실행 결과 예시** ]
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
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

<br/>

## 🧑🏻‍💻 프로그래밍 요구사항
- 실행 환경 : **JDK 21**
- 프로그램 실행 시작점 : `Application.class` - `main()`
- `build.gradle` 파일은 변경 불가
- 제공된 라이브러리 이외의 <u>외부 라이브러리는 사용 불가</u>
  - `camp.nextstep.edu.missionutils` - `Console API` 사용
  - **사용자가 입력하는 값** : `camp.nextstep.edu.missionutils.Console` - `readLine()`
- 프로그램 종료 시 System.exit() 호출 금지
- 파일, 패키지 등의 이름 변경 및 이동 금지 (_프로그래밍 요구 사항에서 달리 명시하지 않는 한_)
- Java Style Guide 코드 컨벤션 준수

<br/>

- indent(인덴트, 들여쓰기) depth 2까지만 허용
- 3항 연산자 금지
- 함수(또는 메서드) 단일 작업 최소화
- JUnit 5 / AssertJ 활용을 통한 기능 목록 정상 작동 테스트
- 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.

<br/>


