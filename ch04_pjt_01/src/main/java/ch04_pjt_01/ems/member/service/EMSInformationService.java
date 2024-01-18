package ch04_pjt_01.ems.member.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ch04_pjt_01.ems.member.DBConnectionInfo;

public class EMSInformationService {

    private String info;
    private String copyRight;
    private String version;
    private String sYear;
    private String sMonth;
    private String sDay;
    private String eYear;
    private String eMonth;
    private String eDay;
    private List<String> developers;
    private Map<String, String> administrators;
    private Map<String, DBConnectionInfo> dbInfo;

    public void printEMSInformation() {
        System.out.println("EMS INFORMATION START--------");
        String devPeriod = sYear + "/" + sMonth + "/" + sDay + "/" 
        		+ "~" + eYear + "/" + eMonth + "/" + eDay;
        
        System.out.println(info + "(" + devPeriod + ")" );
        System.out.println(copyRight);
        System.out.println(version);
        System.out.println("Developer:" + developers);
        System.out.println("Administrator" + administrators);
        printDBInfo();
        
        System.out.println("END ---------------------------");
                	
        }
    private void printDBInfo() {
    	Set<String> keys = dbInfo.keySet();
    	Iterator<String> iterator = keys.iterator();	
        
    	while(iterator.hasNext()) {
    		String key = iterator.next();
    		DBConnectionInfo info = dbInfo.get(key);
    		System.out.print("[" + key + "DB]");
    		System.out.print("url:" + info.getUrl()+ "\t");
    		System.out.print("userId:" + info.getUserId() + "\t");
    		System.out.print("userPw:" + info.getUserPw() + "\n");
    	}
    	
    }
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getCopyRight() {
		return copyRight;
	}
	public void setCopyRight(String copyRight) {
		this.copyRight = copyRight;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getsYear() {
		return sYear;
	}
	public void setsYear(String sYear) {
		this.sYear = sYear;
	}
	public String getsMonth() {
		return sMonth;
	}
	public void setsMonth(String sMonth) {
		this.sMonth = sMonth;
	}
	public String getsDay() {
		return sDay;
	}
	public void setsDay(String sDay) {
		this.sDay = sDay;
	}
	public String geteYear() {
		return eYear;
	}
	public void seteYear(String eYear) {
		this.eYear = eYear;
	}
	public String geteMonth() {
		return eMonth;
	}
	public void seteMonth(String eMonth) {
		this.eMonth = eMonth;
	}
	public String geteDay() {
		return eDay;
	}
	public void seteDay(String eDay) {
		this.eDay = eDay;
	}
	public List<String> getDevelopers() {
		return developers;
	}
	public void setDevelopers(List<String> developers) {
		this.developers = developers;
	}
	public Map<String, String> getAdministrators() {
		return administrators;
	}
	public void setAdministrators(Map<String, String> administrators) {
		this.administrators = administrators;
	}
	public Map<String, DBConnectionInfo> getDbInfo() {
		return dbInfo;
	}
	public void setDbInfo(Map<String, DBConnectionInfo> dbInfo) {
		this.dbInfo = dbInfo;
	}
    
    
}
