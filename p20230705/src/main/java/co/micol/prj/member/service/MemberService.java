package co.micol.prj.member.service;

import java.util.List;

public interface MemberService {
	List<MemberVO> memberSelectList();//R
	
	List<MemberVO> memberSelectList(String key , String val);//R ajax 쓸거임
	
	MemberVO memberSelect(MemberVO vo);//R
	int memberInsert (MemberVO vo);//C
	int memberUpdate(MemberVO vo);//U
	int memberDelete(MemberVO vo);//D
	
	boolean isMemberIdCheck(String id);//아이디체크 불린 메소드들은 관례로 is를 앞에 붙여준다 ajax
}
