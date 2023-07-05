package co.micol.prj.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	public String exec(HttpServletRequest request , HttpServletResponse response);//값받아오고 보내는 exec정의하는 추상메소드  
}
