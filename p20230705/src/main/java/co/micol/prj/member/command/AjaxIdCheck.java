package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

public class AjaxIdCheck implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//aJax를 이용한 아이디 중복 체크 
		MemberService memberService = new MemberServiceImpl();
		String result = "Ajax:";
		
		String id = request.getParameter("id");
		boolean b= memberService.isMemberIdCheck(id);
		if(b) {
			result += "1";//이미존재
		}else {
			result += "0";//사용가능
		}
		return result;
	}

}
