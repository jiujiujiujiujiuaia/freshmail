package entity; 
import org.springframework.stereotype.Component;

@Component
public class User { // ʵ��������Ժͱ���ֶ�����һһ��Ӧ 
	int id; 
	String username; 
	String password;
	String phone;
	String address;
	
//	public User() {
//		id=0;
//		password=phone=address=username=null;
//	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	// getter��setter��
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
}
