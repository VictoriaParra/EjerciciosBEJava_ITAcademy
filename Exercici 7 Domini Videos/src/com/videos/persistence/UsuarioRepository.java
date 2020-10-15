package com.videos.persistence;

import java.util.ArrayList;
import java.util.List;

import com.videos.domain.Usuario;

public class UsuarioRepository {

	private List<Usuario> userList = new ArrayList<Usuario>();

	public UsuarioRepository() {

	}

	public List<Usuario> getUserList() {
		return userList;
	}

	public void setUserList(List<Usuario> userList) {
		this.userList = userList;
	}

	public void addUser(Usuario user) {
		userList.add(user);

	}

}
