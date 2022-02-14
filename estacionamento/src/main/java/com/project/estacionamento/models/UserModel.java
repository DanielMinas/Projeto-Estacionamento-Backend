package com.project.estacionamento.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Tbl_User")
public class UserModel {
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		@Column()
		private String user;
		@Column()
		private String password;
		
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getUser() {
			return user;
		}
		public void setUser(String user) {
			this.user = user;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	
}
