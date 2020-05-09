package niucaocao.domain;

import java.util.List;

public class City {

	private String province;
	private List<String> city;
	
	/**
	 * @param province
	 * @param city
	 */
	public City(String province, List<String> city) {
		super();
		this.province = province;
		this.city = city;
	}
	/**
	 * 
	 */
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * @return the city
	 */
	public List<String> getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(List<String> city) {
		this.city = city;
	}
	

}
