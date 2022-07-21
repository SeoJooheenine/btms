package kr.ac.btms.management.vo;

import java.util.Date;

public class reportVO {
	private int reportNO;
	public int getReportNO() {
		return reportNO;
	}
	public void setReportNO(int reportNO) {
		this.reportNO = reportNO;
	}
	public Date getReportReg() {
		return reportReg;
	}
	public void setReportReg(Date reportReg) {
		this.reportReg = reportReg;
	}
	private Date reportReg;
	
}
