package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

public class MemberLogin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//로그인처리하는부분
		MemberService memberService= new MemberServiceImpl();
		MemberVO memberVO = new MemberVO();
		HttpSession session = request.getSession();
		String str = null;
		
		memberVO.setMemberId(request.getParameter("memberId"));
		memberVO.setMemberPassword(request.getParameter("memberPassword"));
		
		memberVO = memberService.memberSelect(memberVO);
		if(memberVO!= null) {
			//세션에 필요한 값을 담고
			session.setAttribute("id", memberVO.getMemberId());
			session.setAttribute("author", memberVO.getMemberAuthor());
			session.setAttribute("name", memberVO.getMemberName());
			str= "main.do";
		}else {
			//메세지전달
			request.setAttribute("message", "아이디 또는 패스워드가 일치하지 않습니다");
			str = "member/errorMessage";
		}
		return str;
	}

}
