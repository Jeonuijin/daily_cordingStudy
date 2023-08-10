/* ===================
SELECT * | [ DISTINCT ] {컬럼명, 컬럼명, ...}
  FROM 테이블명
[WHERE 조건절]
[GROUP BY {컬럼명, ....}
    [HAVING 조건] ] --GROUP BY 절에 대한 조건
[ORDER BY {컬럼명 [ASC | DESC], ....}] 
------------------------------------------------------
-- GROUP BY : 데이터를 그룹핑해서 처리할 경우 사용
-- GROUP BY 문을 사용하면 SELECT 항목에 사용할 수 있는 데이터가 제한됨
---- GROUP BY 절에 사용된 컬럼 또는그룹함수(COUNT, SUM, AVG, MAX, MIN)사용가능
---- 상수값 사용가능(문자열, 숫자, 날짜 값)
--------------------------------
--HAVING 절은 단독으로 사용할 수 없고, 반드시 GROUP BY 절과 함께사용 (종속절)
--HAVING 절 : GROUP BY 절에 의해서 만들어진 데이터에서 검색조건 부여(선택)
--===================*/
--출판사별 출판한 책 개수 구하기

SELECT PUBLISHER, COUNT(*),  --올수있는 컬럼이 제한된다.(GROUP BY 를 써서)/ 상수값, 그룹함수는 가능
       SUM(PRICE), AVG(PRICE), MIN(PRICE),MAX(PRICE)
 FROM BOOK
 GROUP BY PUBLISHER
;


--구매 고객별로 구매금액 합계를 구하시오
SELECT CUSTID, SUM(SALEPRICE)
  FROM ORDERS
GROUP BY CUSTID
;
-- 이름표시 : 이름으로 그룹핑
SELECT C.NAME, SUM(SALEPRICE)
  FROM CUSTOMER C, ORDERS O
  WHERE C.CUSTID = O.CUSTID
  GROUP BY C.NAME
  ORDER BY SUM(O.SALEPRICE) DESC --많이 구입한 금액부터
  ;

SELECT C.NAME, SUM(SALEPRICE)
  FROM CUSTOMER C, ORDERS O
  WHERE C.CUSTID = O.CUSTID
  GROUP BY C.NAME
  ORDER BY 2 DESC --많이 구입한 금액부터(위치번호기준)=> 위치가 바뀌면 값이 바뀐다.
  ;

SELECT C.NAME, SUM(SALEPRICE) AS SUM_PRICE
  FROM CUSTOMER C, ORDERS O
  WHERE C.CUSTID = O.CUSTID
  GROUP BY C.NAME
  ORDER BY SUM_PRICE DESC --많이 구입한 금액부터(그룹함수값 별칭 기준)
  ;
----------------------------
--주문(판매) 테이블의 고객별 데이터 조회(건수, 합계, 평균, 최소, 최대금액)
SELECT CUSTID,
       COUNT(*), SUM(SALEPRICE), TRUNC(AVG(SALEPRICE)),
       MIN(SALEPRICE), MAX(SALEPRICE)
  FROM ORDERS
  GROUP BY CUSTID;
  
--박지성, 추신수 데이터 (건수, 합계, 평균, 최소, 최대금액)
SELECT C.NAME,
       COUNT(*), SUM(SALEPRICE), TRUNC(AVG(SALEPRICE)),
       MIN(SALEPRICE), MAX(SALEPRICE)
  FROM CUSTOMER C, ORDERS O
  WHERE C.CUSTID = O.CUSTID
  AND C.NAME IN ('박지성', '추신수')
  GROUP BY C.NAME
  ;
-----------------------------------
--(실습) 고객명 기준으로 고객별 구매데이터 조회(건수, 합계, 평균, 최소, 최대)
---- 추신수, 장미란 고객 2명만 조회(검색)
SELECT C.NAME, COUNT(*), SUM(SALEPRICE), TRUNC(AVG(SALEPRICE)),
       MIN(SALEPRICE), MAX(SALEPRICE)
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
   AND C.NAME IN ('추신수', '장미란')
GROUP BY C.NAME;

-- 표준SQL 형식
SELECT C.NAME, COUNT(*), SUM(SALEPRICE), TRUNC(AVG(SALEPRICE)),
         MIN(SALEPRICE), MAX(SALEPRICE)
  FROM CUSTOMER C INNER JOIN ORDERS O
  ON C.CUSTID = O.CUSTID
  WHERE C.NAME IN ('추신수', '장미란') 
  GROUP BY C.NAME;
--------------------------------
--HAVING 절은 단독으로 사용할 수 없고, 반드시 GROUP BY 절과 함께사용 (종속절)
--HAVING 절 : GROUP BY 절에 의해서 만들어진 데이터에서 검색조건 부여(선택)
---------------------------------
--3건 이상 구입한 고객 조회
SELECT C.NAME,COUNT(*)
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
GROUP BY C.NAME
   HAVING COUNT(*)>=3
;
------------------------------------
--구매한 책중에 20000원 이상의 책을 구입한 사람의 통계 데이터(WHERE랑 GROUP BY 비교)

SELECT C.NAME, COUNT(*) AS CNT, SUM(O.SALEPRICE),
       TRUNC(AVG(O.SALEPRICE)), MIN(o.SALEPRICE), MAX(o.SALEPRICE)
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
GROUP BY C.NAME
HAVING MAX(O.SALEPRICE) >= 20000  --2만원 이상 책을 1권이라도 구입한 사람
;
SELECT C.NAME, COUNT(*) AS CNT, SUM(O.SALEPRICE),
       TRUNC(AVG(O.SALEPRICE)), MIN(o.SALEPRICE), MAX(o.SALEPRICE)
  FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
 AND (O.SALEPRICE) >= 20000 --2 만원 이상 책들만 대상으로(테이블에서 대상을 찾음)
GROUP BY C.NAME
;