package niucaocao.domain;

import java.io.Serializable;

public class Hero implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private String name;
    

	/**
	 * @param id
	 * @param name
	 */
	public Hero(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Hero() {
		super();
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Hero [id=" + id + ", name=" + name + "]";
	}
}
