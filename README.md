# java-racingcar-precourse

## 기능 요구 사항

---

> 초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 도메인

---

### 상위 수준 설계
![28fced48-4770-4b30-84df-8fe41acc1e2d](https://github.com/user-attachments/assets/c78e9534-2f6b-444c-b850-52e264b472df)

### 개별 객체 수준 설계
![ba7f6589-28a5-4f66-a8dc-f096c22370b7](https://github.com/user-attachments/assets/cdc2d579-754d-4b4c-a1fa-65000d33595c)


### 애그리거트 단위
![d832c4c0-fe30-4ecb-8a2e-70bd259bae55](https://github.com/user-attachments/assets/62cf88cd-a2d9-4ae9-a859-fcaa03685972)



## 객체 요청 흐름

---
![image](https://github.com/user-attachments/assets/c00fe434-42d8-4321-9dbd-f5b13ae7d7a1)


## 구현 계획 목록

### Member

---

- name: String

### Car

---

- member: Member
- racingDistance: Long

### Race

---

- cars: List<Cars>
- List<Cars> `race`(Long times)

### Race Result

---

- raceResult: List<Cars>
- String `result`

### Controller

---

### Validator

---

### Service

---