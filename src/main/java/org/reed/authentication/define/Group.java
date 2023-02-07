/**
 * E5Projects @ org.reed.authentication.define/Group.java
 */
package org.reed.authentication.define;

import java.util.Set;

/**
 * @author chenxiwen
 * @createTime 2020年03月11日 下午5:56
 * @description
 */
public class Group {
	private String gid;
	private String appCode;
	private String desc;

	private Set<Role> roles;
	private Set<Permission> permissions;
	private Set<User> users;

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appCode == null) ? 0 : appCode.hashCode());
		result = prime * result + ((gid == null) ? 0 : gid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		if (appCode == null) {
			if (other.appCode != null)
				return false;
		} else if (!appCode.equals(other.appCode))
			return false;
		if (gid == null) {
			if (other.gid != null)
				return false;
		} else if (!gid.equals(other.gid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Group [gid=" + gid + ", appCode=" + appCode + ", desc=" + desc + ", roles=" + roles + ", permissions="
				+ permissions + ", users=" + users + "]";
	}
}
