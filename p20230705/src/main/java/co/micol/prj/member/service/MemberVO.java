package co.micol.prj.member.service;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberVO {
	private String memberId;
	private String memberPassword;
	private String memberName;
	private String memberTel;
	private String memberAddress;
	private String memberAuthor;
	
	
	
	@JsonFormat(shape=JsonFormat.Shape.STRING , pattern="yyyy-MM-dd")
	private Date memberEdate;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING , pattern="yyyy-MM-dd")
	private Date memberDdate;
}
