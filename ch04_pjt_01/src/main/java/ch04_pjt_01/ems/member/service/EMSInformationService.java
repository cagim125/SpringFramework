package ch04_pjt_01.ems.member.service;

public class EMSInformationService {

    private String info;
    private String copyright;
    private String version;
    private String sYear;
    private String sMonth;
    private String sDay;
    private String eYear;
    private String eMonth;
    private String eDay;
    private List<String> developer;
    private Map<String, String> administrator;
    private Map<String, DBConnectionInfo> dbInfo;

    public void printEMSInformation() {
        System.out.println("EMS INFORMATION START--------")
    }
}
