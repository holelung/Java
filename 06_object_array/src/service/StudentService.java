package service;

import java.util.Random;

import dto.StudentDTO;

/* Service 
 * - 프로그램의 실질적인 기능(비즈니스 로직)을 
 *   제공하는 클래스
 */

public class StudentService {

	// StudentDTO 객체 배열 선언
	private StudentDTO[] students = new StudentDTO[5];

	/* 기본 생성자 */
	public StudentService() {
		System.out.println("[초기 학생 정보가 추가됨...]\n");

		students[0] = new StudentDTO("20250001", "짱구", '남');
		students[1] = new StudentDTO("20250002", "유리", '여');
		students[2] = new StudentDTO("20250003", "훈이", '남');

		// 자바 제공 난수 발생 객체
//		Random random = new Random();
//		
//		for(StudentDTO std : students) {
//			if(std == null) {
//				continue;
//			}
//			// random.nextInt(101) : 0 이상 101 미만의 정수형 난수 생성
//			std.setHtml(random.nextInt(101));
//			std.setCss(random.nextInt(101));
//			std.setJs(random.nextInt(101));
//			std.setJava(random.nextInt(101));
//		}

	}

	// new StudentDTO[5]
	// - StudentDTO 참조형 변수 5칸짜리 배열 생성
	// - 인덱스 : 0 ~ 4
	// - 각 인덱스 요소의 초기값 : null (참조하는 객체 없음)

	/**
	 * students 객체 배열을 반환하는 메서드 (student 에 저장된 주소가 복사되서 반환됨 == 얕은 복사)
	 * 
	 * @return students
	 */
	public StudentDTO[] getStudents() {
		return students;
	}

	/**
	 * add Student 빈 배열에 학생 정보 추가
	 * 
	 * 없으면 정원 꽉찼다고 알림
	 * 
	 * @param studentNumber
	 * @param name
	 * @param gender
	 */
	public boolean addStudent(String studentNumber, String name, char gender) {
		boolean complatedAdd = false;

		for (int i = 0; i < 5; i++) {
			if (students[i] == null) {
				students[i] = new StudentDTO(studentNumber, name, gender);
				complatedAdd = true;
				break;
			}
		}
		System.out.println(students[3].toString());
		return complatedAdd;
	}

	/**
	 * 학생 조회(인덱스 번호)
	 * 
	 * @param idx
	 * @return student[@param idx]
	 */
	public StudentDTO oneStudent(int idx) {
		return students[idx];
	}

	/**
	 * 학생 조회(인덱스 번호) 존재만 확인
	 * 
	 * @param idx
	 * @return
	 */
	public int findIndex(int idx) {
		if (idx > 5) {
			return 1;
		}
		if (students[idx] == null) {
			return 2;
		}
		return 0;
	}

	/**
	 * 학생 조회(이름, 중복X)
	 * 
	 * @param name
	 * @return 있으면 std, 없으면 null
	 */
	public StudentDTO findByName(String name) {
		for (StudentDTO std : students) {
			if (std.getName() == name) {
				return std;
			}
		}
		return null;
	}

	/**
	 * 학적 정보 수정
	 * 
	 * @param idx
	 * @param studentNumber
	 * @param name
	 * @param gender
	 */
	public void modifyInfo(int idx, String studentNumber, String name, char gender) {
		students[idx].setStudentNumber(studentNumber);
		students[idx].setName(name);
		students[idx].setGender(gender);
	}

	/**
	 * 학생 점수 수정
	 * 
	 * @param idx
	 * @param html
	 * @param css
	 * @param js
	 * @param java
	 */
	public void updateScore(int idx, int html, int css, int js, int java) {
		students[idx].setHtml(html);
		students[idx].setCss(css);
		students[idx].setJs(js);
		students[idx].setJava(java);
	}

	public String selectMaxMin() {

		// 점수 평균 최고,최저점 저장 변수선언
		double min = 100.0;
		double max = 0.0;
		// 최고, 최저점자 이름 저장 변수선언
		String minName = "";
		String maxName = "";

		for (StudentDTO std : students) {
			if (std == null) {
				break;
			}
			double temp = std.avgScore();

			if (temp > max) {
				max = temp;
				maxName = std.getName();
			}
			if (temp < min) {
				min = temp;
				minName = std.getName();
			}
		}
		return String.format("최고점 : %s(%.1f)\n최저점 : %s(%.1f)", maxName, max, minName, min);
	}

	/** 학생 제거 함수
	 * 삭제 후 인덱스 정렬
	 */
	public void deleteStudent(int idx) {
		// 삭제 전 이름 백업
		String deleteName = students[idx].getName();
		
		// 입력받은 index 에 해당하는 학생 삭제 
		students[idx] = null;
		
		
		// 배열 당기기 null 이면 뒤의 배열값을 
		// 앞으로 댕기고 뒤에값 null 로 변환
		for(int i=idx; i<students.length -1; i++) {
			students[i] = students[i+1];
		}
		students[students.length -1] = null;
		
		System.out.println(deleteName + "학생이 삭제되었습니다.");
	}
	
	
	
	
	
}
