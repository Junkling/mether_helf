# MurtheHelp

---

---

# 📒 프로젝트 기획

> 
> 
> 
> <aside>
> 💡 **내용 :**
> 
> - 드라마 ‘킬러들의 쇼핑몰’에 등장하는 페이지를 구현해본다.
> </aside>
> 

---

---

# 🛠️Stack

---

## 백앤드

- Java-17
    - OpenJDK-21
- SpringBoot 3.2.2
    - Spring Web
    - Spring Data JPA
    - SpringSecurity
    - Swagger-UI
    - Tomcat
    - Mapstruct
    - Gradle
- JWT

---

## 프론트엔드

- Node.js 20.11.1
- Vue 3
- HTML
- CSS
- JS

---

## Server

- Ubuntu 20.04.6 LTS
- AWS RDS

---

## 데이터베이스

- MySQL

---

## Tools

- IntelliJ
- VSCode
- Git, Github

---

---

# 📑ERD 다이어그램

https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F552fe0dc-fdb3-4c62-979e-df2a2e235613%2F5b6e5a35-25c4-468f-a16e-753584d3a395%2FMH_ERD.png?table=block&id=559544b6-b09e-4e38-a53b-7edf14f4e377&spaceId=552fe0dc-fdb3-4c62-979e-df2a2e235613&width=2000&userId=a09a1ca3-4214-4905-a7a2-172e60f8cd39&cache=v2

---

---

# ♦️Flow

https://file.notion.so/f/f/552fe0dc-fdb3-4c62-979e-df2a2e235613/618b456a-6e62-42cb-8907-047034f91165/%ED%94%8C%EB%A1%9C%EC%9A%B0%EC%B0%A8%ED%8A%B8.png?id=050dc76e-e9f3-4cf3-b172-19fd8a8bc4aa&table=block&spaceId=552fe0dc-fdb3-4c62-979e-df2a2e235613&expirationTimestamp=1710619200000&signature=Lq-Ec31PIRClQ-UDyMZGwDLhIOTl4W7nEIUvWvYWHnM&downloadName=%ED%94%8C%EB%A1%9C%EC%9A%B0%EC%B0%A8%ED%8A%B8.png

---

---

# 🍃Swagger-UI

### URL 링크

> 
> 
> 
> http://34.47.73.241:8080/swagger-ui/index.html#/
> 

---

---

# 🛫 기능 구현

### 1. 유저 관련(User , Security)

> **구현 내용**
> 
> - **회원 가입**
>     - 비밀번호 저장 시 비밀번호 인코딩
>     - 기본 권한 세팅
>     - 관리자단에서 유저의 권한 수정 가능
> 
> - **로그인 기능**
>     - 로그인 로직
>         - 로그인 시 token을 body에 넣어 줌
>         - 토큰을 기반으로 한 관리자 여부 확인 API 개발
> 
> - **사용자 접근 관련 (시큐리티)**
>     - 접근 필터
>         - 계정 인증이 필수인 URL은 필터를 통해 token검증을 받는다.
>         - 토큰이 만료 되었는지 토큰이 유효한 토큰인지 검증한다.
>         - 토큰을 해석하여 내부에 가지고 있는 정보를 저장한다
>         - AuthenticationProvider를 통해 저장된 정보를 기반으로 Authentication 객체를 만든다. 해당 객체는 접근자를 식별하는데 사용된다.
>         - (**로그인 여부**: Authenticated, **ID**: Principal , **권한** : Authorities)
> 

### 2. 권한 관련 (Role)

> **구현 내용**
> 
> - **회원 관련**
>     - Default 권한에 해당하는 WHITE 코드 부여
>     - 관리자(GREEN 코드)는 유저의 권한을 수정 할 수 있음
> 
> - **대 카테고리**
>     - 대카테고리는 권한을 바라보고 있음
> 
> - **Role 가드**
>     - 권한에 따른 페이지 가드 적용

### 3. 카테고리 관련 (First/SecondCategory)

> **구현 내용**
> 
> - **카테고리 구분**
>     - 대 카테고리
>     - 소 카테고리
>     
> - **기능 구현 (Swagger 참고)**
>     - 생성
>         - 관리자에서만 접근 가능
>     - 조회
>         - 관리자와 동일한 코드를 갖는 USR만 접근 가능
>     - 수정
>         - 관리자에서만 접근 가능
>     - 삭제
>         - 관리자에서만 접근 가능
>     

### 4. 상품 관련 (Item)

> **구현 내용**
> 
> - **카테고리 연관 관계**
>     - 소 카테고리 하위에 Item 테이블이 존재하도록 설계
>     
> - **기능 구현 (Swagger 참고)**
>     - 생성
>         - 소 카테고리 연관관계 설정
>     - 조회
>         - 관리자와 코드에 해당하는 User만 접근 가능
>     - 수정
>         - 관리자에서만 접근 가능
>     - 삭제
>         - 관리자에서만 접근 가능
> 
> - **필드**
>     - 가격
>     - 이름
>     - 판매 수량
>     - 재고
>     - 할인률
> 
> - 검증 로직
>     - 재고 이상으로 주문 시 주문 실패 로직 구현
>     - 주문 시 OrderItem에 할인률, 수량, 원가에 따른 계산된 총액 저장

### 5. 장바구니 관련 (Cart)

> **구현 내용**
> 
> - **엔티티 설계**
>     - User와 Item을 갖는 중간 테이블
>     - DB테이블에서 관리하기 때문에 Local, Session 스토리지에서 지워져도 장바구니를 가지고 있음
>     
> - **기능 구현 (Swagger 참고)**
>     - 생성
>         - 접속자가 ItemId 를 가지고 API 요청 했을 때 filter를 통해 접속자를 식별하여 테이블 생성
>     - 조회
>         - 접속자를 식별하여 접속자가 생성한 Cart만 조회
>     - 수정
>         - 해당 User가 수량 수정 가능
>     - 삭제
>         - 해당 User가 수량 삭제 가능
>         - 주문으로 전환 되었을 때 해당 테이블 삭제
> 
> - **필드**
>     - 이용자 ID
>     - 상품 ID
>     - 장바구니에 담은 수량
> 

### 6. 주문 관련 (Order)

> **구현 내용**
> 
> - **엔티티 설계**
>     - 주문의 내용을 담고 있는 테이블
>     - 배송 테이블 참조
>     - Item과의 중간 테이블 OrderItem  참조
>     - 상태 코드 StatusCode 참조
>     
> - **기능 구현 (Swagger 참고)**
>     - 생성
>         - Cart 테이블에 해당하는 정보를 기반으로 Order 생성
>         - 생성 시 입력 받은 배송 정보를 기반으로 Delivery 생성
>         - Order에 포함된 Cart 삭제
>         - 생성시 기본 상태값(StatusCode) 부여
>     - 조회
>         - 접속자를 식별하여 접속자가 생성한 Order 조회
>         - 관리자는 모든 주문 정보를 검색 기반으로 조회 가능
>     - 수정
>         - 주문 상태만 수정 가능
>     - 삭제
>         - 삭제 시나리오 없음
> 
> - **필드**
>     - 결제 정보
>     - 총액
>     - 배송 관련 정보
>     - UserID
> 

### 7. 주문된 상품 내용 관련(OrderItem)

> **구현 내용**
> 
> - **엔티티 설계**
>     - 주문이 상품  테이블을 알 수 있도록 중간 테이블 OrderItem 엔티티 설계
>     - 주문 당시의 값을 저장 하기 위해 주문 시의 상품 정보 OrderItem 필드에 값 저장
>     
> - **기능 구현 (Swagger 참고)**
>     - 생성
>         - Order가 생성될 때 주문 된 Item의 종류 만큼 테이블 생성
>         - 생성 당시의 정보를 저장하기 위한 필드에 값 저장
>         - 총액 합산(원가, 할인률, 수량 기반)
>     - 조회
>         - Order 조회에 함께 조회됨
>     - 수정
>         - 주문 후엔 수정 불가
>     - 삭제
>         - Order이 삭제 되면 함께 삭제
> 
> - **필드**
>     - 주문 당시 상품의 가격, 이름 , 수량
>     - 해당 상품의 주문 총액
>     - OrderID
>     - ItemID
> 

### 8. 이미지 관련(Attachment)

> **구현 내용**
> 
> - **엔티티 설계**
>     - 서비스에 사용되는 모든 파일들에 대한 데이터
>     - 저장을 담당하는 로직을 수행하고 저장된 경로 값을 저장
>     
> - **기능 구현 (예정)**
>     - 생성
>         - 이미지가 필요한 테이블을 생성할 때 함께 생성(Item)
>         - 이름 및 경로의 중첩을 방지하기 위한 UUID 기반 이름 부여(store_name)
>         - Multipart Form Data로 받은 파일 저장
>     - 조회
>         - 이미지가 참조된 엔티티 접근시 조회
>     - 수정
>         - 수정 후 이미지에 해당하는 테이블과 연관관계 수정
>     - 삭제
>         - 해당 이미지와 연관된 테이블이 삭제 되면 함께 삭제
> 
> - **필드**
>     - 연관된 Entity의 PK
>     - 저장 시 이름
>     - 중복 방지를 위한 UUID 이름을 부여한 후 경로
