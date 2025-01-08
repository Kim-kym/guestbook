package learnbyteaching.guestbook.vo;

import java.util.Date;

public class BookVo {
	// Fields
	private Integer no;
	private String name; 
	private String password;
	private String content; 
	private Date regDate;
	
//	Constructor 
	public BookVo(Integer no, 
			String name, 
			String password, 
			String content, 
			Date regDate) {
		super();
		this.no = no;
		this.name = name;
		this.password = password;
		this.content = content;
		this.regDate = regDate;
	}

	public BookVo(String name, 
			String password, 
			String content) {
		this.name = name;
		this.password = password;
		this.content = content;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "BookVo [no=" + no + ", name=" + name + ", password=" + password + ", content=" + content + ", regDate="
				+ regDate + "]";
	}
	
}
