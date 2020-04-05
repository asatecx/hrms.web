package hrms.model;

public class DevPhase {

	/**
	 * 要件定義
	 */
	private String require = "";
	/**
	 * 基本設計
	 */
	private String baseDesign = "";
	/**
	 * 機能設計
	 */
	private String functionDesign = "";
	/**
	 * 詳細設計
	 */
	private String detailDesign = "";
	/**
	 * 製造
	 */
	private String coding = "";
	/**
	 * 単体テスト
	 */
	private String unitTest = "";
	/**
	 * 結合テスト
	 */
	private String interfaceTest = "";
	/**
	 * 総合テスト
	 */
	private String systemTest = "";
	/**
	 * 運用保守
	 */
	private String maintenance = "";

	public void setRequire(String require) {
		this.require = require;
	}

	public String getRequire() {
		return this.require;
	}

	public void setBaseDesign(String baseDesign) {
		this.baseDesign = baseDesign;
	}

	public String getBaseDesign() {
		return this.baseDesign;
	}

	public void setFunctionDesign(String functionDesign) {
		this.functionDesign = functionDesign;
	}

	public String getFunctionDesign() {
		return this.functionDesign;
	}

	public void setDetailDesign(String detailDesign) {
		this.detailDesign = detailDesign;
	}

	public String getDetailDesign() {
		return this.detailDesign;
	}

	public void setCoding(String coding) {
		this.coding = coding;
	}

	public String getCoding() {
		return this.coding;
	}

	public void setUnitTest(String unitTest) {
		this.unitTest = unitTest;
	}

	public String getUnitTest() {
		return this.unitTest;
	}

	public void setInterfaceTest(String interfaceTest) {
		this.interfaceTest = interfaceTest;
	}

	public String getInterfaceTest() {
		return this.interfaceTest;
	}

	public void setSystemTest(String systemTest) {
		this.systemTest = systemTest;
	}

	public String getSystemTest() {
		return this.systemTest;
	}

	public void setMaintenance(String maintenance) {
		this.maintenance = maintenance;
	}

	public String getMaintenance() {
		return this.maintenance;
	}

}