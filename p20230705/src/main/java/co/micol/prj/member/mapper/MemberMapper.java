package co.micol.prj.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.micol.prj.member.service.MemberVO;

public interface MemberMapper {
	List<MemberVO> memberSelectList();//R
	
	List<MemberVO> memberSelectList(@Param("key")String key ,@Param("val") String val);//R ajax 쓸거임 mapper는 매개변수가 두개이상인곳엔 param사용
	
	MemberVO memberSelect(MemberVO vo);//R
	
	int memberInsert (MemberVO vo);//C
	
	int memberUpdate(MemberVO vo);//U
	
	int memberDelete(MemberVO vo);//D
	
	boolean isMemberIdCheck(String id);//아이디체크 불린 메소드들은 관례로 is를 앞에 붙여준다 ajax
}
