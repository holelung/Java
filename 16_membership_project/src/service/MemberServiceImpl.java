
package service;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import dto.Member;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 왜 Service, Dao 인터페이스를 만들어서 구현했을까?
 * - 인터페이스를 상속 받아 구현하면
 *   모든 자식 클래스가 똑같은 기능을 가지게되어
 *   비슷하게 생김!
 *
 *  -> 언제든지 서로 다른 자식 클래스로 대체 가능!!
 *    ==> 유지보수성 증가
 */

// MemberService를 상속 받아 구현
public class MemberServiceImpl implements MemberService{

    // dao 객체 부모 참조 변수 선언
    private MemberDAO dao = null;
    private String[] gradeArr = {"일반", "골드", "다이아"};


    // 기본 생성자
    // - MemberServiceImpl 객체 생성 시
    //   MemberDAOImpl 객체도 생성
    public MemberServiceImpl() 
    		throws FileNotFoundException, ClassNotFoundException, IOException {
        dao = new MemberDAOImpl();
    }

    
    //********************************
    // 추가, 수정 삭제 기능이 수행되면
    // 무조건 dao.saveFile() 수행!
    //********************************

    // 회원 추가
    @Override
    public boolean addMember(String name, String phone) throws IOException {
    	List<Member> memberList = dao.getMemberList();
    	for(Member m : memberList) {
    		if(m.getPhone().equals(phone)) {
    			return false;
    		}
    	}
    	dao.addMember(new Member(name, phone,0,0));
    	return true;
    }


    // DAO에서 조회한 memberList를 그대로 반환
    @Override
    public List<Member> getMemberList() {
    	// dao 에서 반환 받은 memberList를 그대로 view 로 리턴
        return dao.getMemberList();
    }


    // 이름 검색
    @Override
    public List<Member> selectName(String searchName) {
    		List<Member> memberList = dao.getMemberList();
    		// 같은 이름이 아니면 memberList에서 제거
        return memberList.stream().filter(m->m.getName().equals(searchName)).collect(Collectors.toList());
    }


    // 금액 누적 
    // 동명이인일 경우 선택 하는 화면 추가 필요
    // 금액이 숫자로 입력하지 않을 경우 예외 처리 필요
    // 없을 경우 : "### 이름이 일치하는 회원이 존재하지 않습니다 ###"
    @Override
    public String updateAmount(Member target, int acc) throws IOException {
    	int before = target.getAmount();
    	int sum =before + acc;
    	int index = dao.getMemberList().indexOf(target);
    	
    	if( target.getGrade() < Member.DIAMOND && target.getAmount() >=1_000_000) {
    		dao.getMemberList().get(index).setGrade(Member.DIAMOND);
    		dao.getMemberList().get(index).setAmount(sum);
    		dao.saveFile();
    		return String.format("%d -> %d\n* 다이아 * 등급으로 변경 되셨습니다.\n", before, target.getAmount());
    	}
    	else if(target.getGrade() < Member.GOLD && target.getAmount() >= 100_000) {
    		dao.getMemberList().get(index).setGrade(Member.GOLD);
    		dao.getMemberList().get(index).setAmount(sum);
    		dao.saveFile();
    		return String.format("%d -> %d\n* 골드 * 등급으로 변경 되셨습니다.\n", before, target.getAmount());
    	}
    	dao.getMemberList().get(index).setAmount(sum);
    	dao.saveFile();
      return String.format("%d -> %d\n", before, sum); // 결과 문자열 반환
        
        //ex)
        // 2000 -> 100000
        // * 골드 * 등급으로 변경 되셨습니다
    }


    //회원 정보(전화번호) 수정
    @Override
    public String updateMember(Member target, String phone) throws IOException {
    	
    	int index = dao.getMemberList().indexOf(target);
    	
    	if(phone.length() != 11) {
    		System.out.println("제대로된 전화번호가 아니니 재입력 하쇼");
    		return null;
    	}
    	if(dao.getMemberList().stream().filter(m -> m.getPhone().equals(phone)).count() != 0) {
    		// 중복이 있다
    		System.out.println("중복된 번호가 있으니 재입력 하쇼");
    		return null;
    	}
    	String before = target.getPhone();
    	
    	dao.getMemberList().get(index).setPhone(phone);
    	dao.saveFile();
    	
      return String.format("\n%s님의 전화번호가 변경 되었습니다.\n %s -> %s",target.getName(), before, phone); // 결과 문자열 반환
 
    }


    // 회원 탈퇴
    @Override
    public String deleteMember(Member target) throws IOException {
    	int index = dao.getMemberList().indexOf(target);
    	dao.getMemberList().remove(index);
    	dao.saveFile();
      return String.format("%s 회원이 탈퇴 처리 되었습니다.", target.getName()); // 결과 문자열 반환
    }

}
