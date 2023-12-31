/* ** 실습문제 : HR유저(DB)에서 요구사항 해결 **********
--1) 사번(employee_id)이 100인 직원 정보 전체 보기
--2) 월급(salary)이 15000 이상인 직원의 모든 정보 보기
--3) 월급이 15000 이상인 사원의 사번, 이름(LAST_NAME), 입사일(hire_date), 월급여 정보 보기
--4) 월급이 10000 이하인 사원의 사번, 이름(LAST_NAME), 입사일, 월급여 정보 보기
---- (급여가 많은 사람부터)
--5) 이름(first_name)이 john인 사원의 모든 정보 조회
--6) 이름(first_name)이 john인 사원은 몇 명인가?
--7) 2008년에 입사한 사원의 사번, 성명('first_name last_name'), 월급여 정보 조회
---- 성명 출력예) 'Steven King'
--8) 월급여가 20000~30000 구간인 직원 사번, 성명(last_name first_name), 월급여 정보 조회
--9) 관리자ID(MANAGER_ID)가 없는 사람 정보 조회
--10) 직종(job_id)코드 'IT_PROG'에서 가장 많은 월급여는 얼마
---------------------------------
--11) 직종별 최대 월급여 검색
--12) 직종별 최대 월급여 검색하고, 최대 월급여가 10000이상인 직종 조회
--13) 직종별 평균급여 이상인 직원 조회
*****************************/
--1) 사번(employee_id)이 100인 직원 정보 전체 보기
SELECT *
FROM EMPLOYEES
WHERE EMPLOYEE_ID = 100
;
--2) 월급(salary)이 15000 이상인 직원의 모든 정보 보기
SELECT *
FROM EMPLOYEES
WHERE SALARY >= 15000
;
--3) 월급이 15000 이상인 사원의 사번, 이름(LAST_NAME), 입사일(hire_date), 월급여 정보 보기
SELECT EMPLOYEE_ID, LAST_NAME, HIRE_DATE, SALARY
FROM EMPLOYEES
WHERE SALARY >= 15000
;
--4) 월급이 10000 이하인 사원의 사번, 이름(LAST_NAME), 입사일, 월급여 정보 보기(급여가 많은 사람부터)
SELECT EMPLOYEE_ID, LAST_NAME, HIRE_DATE, SALARY
FROM EMPLOYEES
WHERE SALARY <= 10000
ORDER BY SALARY DESC
;

--5) 이름(first_name)이 john인 사원의 모든 정보 조회
SELECT *
FROM EMPLOYEES
WHERE FIRST_NAME = INITCAP('john') -- 데이터가 표준화 된 경우 입력값을 동일한 형태로
;

SELECT FIRST_NAME, LOWER(FIRST_NAME), UPPER(FIRST_NAME), INITCAP(FIRST_NAME)
FROM EMPLOYEES
;
--6) 이름(first_name)이 john인 사원은 몇 명인가?
SELECT COUNT(*)
FROM EMPLOYEES
WHERE LOWER(FIRST_NAME) = 'john'
;
--7) 2008년에 입사한 사원의 사번, 성명('first_name last_name'), 월급여 정보 조회
---- 성명 출력예) 'Steven King' (컬럼명만들기)
SELECT EMPLOYEE_ID, FIRST_NAME||' '||LAST_NAME AS 성명, SALARY,HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE BETWEEN TO_DATE('2008/01/01', 'YYYY/MM/DD') 
                    AND TO_DATE('2008/12/31', 'YYYY/MM/DD')
ORDER BY HIRE_DATE
;
--8) 월급여가 20000~30000 구간인 직원 사번, 성명(last_name first_name), 월급여 정보 조회
SELECT EMPLOYEE_ID, LAST_NAME||' '||FIRST_NAME AS 성명, SALARY
FROM EMPLOYEES
WHERE SALARY BETWEEN 2000 AND 3000
ORDER BY SALARY
;
--9) 관리자ID(MANAGER_ID)가 없는 사람 정보 조회
SELECT *
FROM EMPLOYEES
WHERE MANAGER_ID IS NULL
;
--10) 직종(job_id)코드 'IT_PROG'에서 가장 많은 월급여는 얼마
SELECT MAX(SALARY)
FROM EMPLOYEES
WHERE JOB_ID = 'IT_PROG'
;
---------------------------------
--GROUP BY
--11) 직종별 최대 월급여 검색
SELECT JOB_ID, MAX(SALARY)
FROM EMPLOYEES
GROUP BY JOB_ID
ORDER BY MAX(SALARY) DESC
;
--12) 직종별 최대 월급여 검색하고, 최대 월급여가 10000이상인 직종 조회
--SELECT J.JOB_TITLE, J.MAX_SALARY
--FROM EMPLOYEES E, JOBS J
--WHERE E.JOB_ID = J.JOB_ID AND J.MAX_SALARY >= 10000
--GROUP BY J.JOB_TITLE, J.MAX_SALARY;
SELECT JOB_ID, MAX(SALARY)
FROM EMPLOYEES
GROUP BY JOB_ID
HAVING MAX(SALARY) >= 10000
ORDER BY MAX(SALARY)
;
--13) 직종별 평균급여 이상인 직원 조회

--직종별 평균급여
SELECT JOB_ID, AVG(SALARY)
FROM EMPLOYEES
GROUP BY JOB_ID, FIRST_NAME
;

--조인(직원테이블 + 직종별 평균급여)  --선생님
SELECT E.EMPLOYEE_ID, E.FIRST_NAME, E.JOB_ID, E.SALARY
     , A.JOB_ID AS A_JOB_ID, A.AVG_SALARY
FROM EMPLOYEES E,
     (SELECT JOB_ID, AVG(SALARY) AVG_SALARY 
      FROM EMPLOYEES 
      GROUP BY JOB_ID) A  --서브쿼리 : 가상테이블(인라인 뷰)
WHERE E.JOB_ID = A.JOB_ID
AND E.SALARY >= A.AVG_SALARY
;
----
--서브쿼리 방식으로 찾기(WHERE절)
SELECT *
FROM EMPLOYEES E
WHERE SALARY >= (SELECT AVG(SALARY) FROM EMPLOYEES WHERE JOB_ID = E.JOB_ID)
;
