package cn.dz.user.domain;

/**
 * 实体类
 * 
 * @author Administrator
 */
public class User {
	private String username;
	private String password;
	private String verifyCode;
	private String province;
	private String city;
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", verifyCode=" + verifyCode + ", province="
				+ province + ", city=" + city + ", id=" + id + "]";
	}

}
