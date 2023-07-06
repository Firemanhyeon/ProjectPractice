package co.micol.prj.member.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

public class memberList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//멤버목록보기
		MemberService memberService = new MemberServiceImpl();
		List<MemberVO> members = new ArrayList<>();
		
		members = memberService.memberSelectList();
		request.setAttribute("members", members);
		
		return "member/memberList";
	}

}
