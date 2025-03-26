package model;

import java.util.Date;

public class Admin {
private int adminId;
private String adminName;
private String adminAddress;
private String adminEmail;
private long adminPhone;
private Date adminDob;
private User User;
public int getAdminId() {
	return adminId;
}
public void setAdminId(int adminId) {
	this.adminId = adminId;
}
public String getAdminName() {
	return adminName;
}
public void setAdminName(String adminName) {
	this.adminName = adminName;
}
public String getAdminAddress() {
	return adminAddress;
}
public void setAdminAddress(String adminAddress) {
	this.adminAddress = adminAddress;
}
public String getAdminEmail() {
	return adminEmail;
}
public void setAdminEmail(String adminEmail) {
	this.adminEmail = adminEmail;
}
public long getAdminPhone() {
	return adminPhone;
}
public void setAdminPhone(long adminPhone) {
	this.adminPhone = adminPhone;
}
public Date getAdminDob() {
	return adminDob;
}
public void setAdminDob(Date adminDob) {
	this.adminDob = adminDob;
}
public User getUser() {
	return User;
}
public void setUser(User user) {
	User = user;
}
public Admin(int adminId, String adminName, String adminAddress, String adminEmail, long adminPhone, Date adminDob,
		model.User user) {
	super();
	this.adminId = adminId;
	this.adminName = adminName;
	this.adminAddress = adminAddress;
	this.adminEmail = adminEmail;
	this.adminPhone = adminPhone;
	this.adminDob = adminDob;
	User = user;
}
public Admin()
{
	super();
}
@Override
public String toString() {
	return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminAddress=" + adminAddress + ", adminEmail="
			+ adminEmail + ", adminPhone=" + adminPhone + ", adminDob=" + adminDob + ", User=" + User + "]";
}

}
