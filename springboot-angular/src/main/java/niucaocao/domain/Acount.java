package niucaocao.domain;

import java.io.Serializable;

public class Acount implements Serializable{
    //下面是表单绑定的data 数据
   

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String furikana;
    private String password;
    private String email;
	public Acount(String name,String furikana,String password,String email) {
		super();
	   this.name=name;
	   this.furikana=furikana;
	   this.password=password;
	   this.email=email;
	}
	public Acount() {
		super();

	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFurikana() {
		return furikana;
	}

	public void setFurikana(String furikana) {
		this.furikana = furikana;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


    
    @Override
	public String toString() {
		return "Acount [name=" + name + ", furikana=" + furikana + ", password=" + password + ", email=" + email + "]";
	}

}
