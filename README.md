# 언제만나?


**기간**
2022.03~2022.06 <br><br>

**담당**
허은택(본인)<br><br>

1. **REST API** 개발

  그룹 생성 및 참가 API 구현<br>
  스케줄 작성, 공유, 매칭 API 구현

2. 서버 세팅 및 담당

  `RDS(Aurora)` 사용해`AWS EC2` 배포, 


**문제1**
 - JPA 다대다 매핑 무한 호출 에러

→ 중간 테이블을 연관관계로 매핑하여 해결<br>


**문제2**
- JPA에서 양방향으로 연결된 Entity 조회 시 양방향 순환 참조 문제

→ @JsonIgnore 사용  

( Json 데이터에 해당하는 data는 null로 들어감)

→ DTO 사용 

( Entity 자체를 return 하지 않고 DTO 객체를 만들어 필요한 데이터만 옮겨담아 return) <br><br>

**배운것**
1. Spring boot MVC, REST API
2. JPA 이용한 DB 연관관계 매핑
3. EC2 Spring boot jar 배포
4. Retrofit API 학습 및 적용
5. Git을 활용한 협업 방법
<br><br>

**느낀점**
1. 앱을 개발하는 과정에서 생각한 아이디어가 실제로 구현되는 순간에 큰 흥미와 함께 성취감을 느낄 수 있었다. 이 경험이 어렵다고 생각했던 개발에 대한 흥미를 본격적으로 갖게 된 계기가 되었다.
<br>
![슬라이드1](https://user-images.githubusercontent.com/80875005/227515787-7a98ee0b-40a4-460b-abfc-e66ce80ccacd.JPG)
### 서로 다른 스케쥴 때문에 미팅 시간을 잡기 어려워 하는 사람들에게 각자의 스케줄을 매칭해 미팅가능한 시간을 직관적으로 보여줍니다.
<br/> <br/><br>

![슬라이드2](https://user-images.githubusercontent.com/80875005/227515788-2e897452-920c-4f72-8113-4b282af2de2a.JPG)
<br/>

![슬라이드3](https://user-images.githubusercontent.com/80875005/227515791-e0aee72f-9e12-456d-a67b-8a58536cf574.JPG)
<br/> <br/>

![슬라이드4](https://user-images.githubusercontent.com/80875005/227515793-30722de4-73a8-4eb3-80ba-e7df983bc63a.JPG)
### 멘토링, 스터디, 대외활동, 회사의 프로젝트까지 우리는 다양한 그룹에 속해 있는데 서로 다른 스케줄 때문에 멤버들과 미팅 시간을 잡기가 어려웠던 경험이 한번쯤은 있었을 것이다. 그럴 때 미팅에 참여하는 사람들의 스케줄을 매칭해 최적의 미팅시간을 제시해준다.
<br/><br/>

![슬라이드5](https://user-images.githubusercontent.com/80875005/227515796-88a2a20c-181e-426e-8413-bbab0187fb6f.JPG)


<br/>

![슬라이드6](https://user-images.githubusercontent.com/80875005/227515798-0e6fc3d6-0cdc-49ca-9e83-acc2e7a24c05.JPG)



![캡스톤](https://user-images.githubusercontent.com/80875005/227667478-32a4c00f-e60a-4f20-b8e2-6e20d7dc7f70.gif)

구현영상
<br/><br/>

![image38](https://user-images.githubusercontent.com/80875005/227517134-22e6d198-2c79-431a-a560-d56cb1a10c5c.png)
<br/>

메인페이지
<br/><br/>
![image39](https://user-images.githubusercontent.com/80875005/227517142-d6f5369b-bfd2-4e3e-b1a0-4b0341f57a60.png)

스케줄 작성
<br/><br/>

![image40](https://user-images.githubusercontent.com/80875005/227517144-b64ee465-b54f-4c72-854e-6aedcefeb996.png)

그룹 메뉴
<br/><br/>


![image41](https://user-images.githubusercontent.com/80875005/227517151-ec294179-3e6f-48cb-bbbf-ca34dd472c02.png)

스케줄 매칭
