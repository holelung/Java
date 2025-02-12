package section03.dto;

import java.io.Serializable;
import java.util.Objects;

/* 마커 인터페이스(Marker Interface)
 * - 어떤 역할 또는 어떤 기능의 대상임을 표시하는 인터페이스
 * 
 * Serializable 인터페이스
 * - 직렬화의 대상임을 명시하는 인터페이스
 * - 안하면 java.io.NotSerializableException 예외발생
 */

public class Member implements Serializable{
  //직렬화된 객체가 Member 인지 확인하는 용도의 id(식별번호)
	private static final long serialVersionUID = -5366985699786334762L;
	
	private String id;
	private String pw;
	private String name;
	
	
	public Member() {}
	
	public Member(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, pw);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(pw, other.pw);
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}
	
	
}
