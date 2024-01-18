package ch04_pjt_01.ems;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch04_pjt_01.ems.member.Student;
import ch04_pjt_01.ems.member.service.StudentRegisterService;
import ch04_pjt_01.ems.member.service.StudentSelectService;
import ch04_pjt_01.ems.member.service.PrintStudentInformationService;
import ch04_pjt_01.ems.member.service.StudentDeleteService;
import ch04_pjt_01.ems.member.service.StudentModifyService;
import ch04_pjt_01.ems.utils.InitSampleData;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		InitSampleData initSampleData = ctx.getBean("initSampleData", InitSampleData.class);
		
		String[] sNums = initSampleData.getsNums();
//		System.out.println(sNums[1]);
		String[] sIds = initSampleData.getsIds();
		String[] sPws = initSampleData.getsPws();
		String[] sNames = initSampleData.getsNames();
		int[] sAges = initSampleData.getsAges();
		char[] sGenders = initSampleData.getsGenders();
		String[] sMajor = initSampleData.getsMajors();
		
		//데이터베이스에 샘플 데이터 등록
		StudentRegisterService registerService = 
				ctx.getBean("studentRegisterService", StudentRegisterService.class);
		
		for(int i=0; i < sNums.length; i++) {
			registerService.register(new Student(sNums[i], sIds[i], sPws[i], sNames[i], sAges[i], sGenders[i], sMajor[i]));
		}
		
		PrintStudentInformationService printStudentInformationService =
				ctx.getBean("printStudentInformationService",PrintStudentInformationService.class);
		
		printStudentInformationService.printStudentsInfo();
		
		registerService.register(new Student("hbs006", "deer", "p0006", "melisa", 26 , 'W', "music" ));
		
		printStudentInformationService.printStudentsInfo();
		
		StudentSelectService studentSelectService =
				ctx.getBean("studentSelectService" , StudentSelectService.class);
		
		Student selStudent = studentSelectService.select("hbs006");
		
		System.out.println("STUDENT START--------=---------");
        System.out.print("|sNums:" + selStudent.getsNum() + "\t");
        System.out.print("|sIds:" + selStudent.getsId() + "\t" );
        System.out.print("|sPw:" + selStudent.getsPw() + "\t");
        System.out.print("|sName:" + selStudent.getsName() + "\t");
        System.out.print("|sAge" + selStudent.getsAge()+ "\t" );
        System.out.print("|sGender" + selStudent.getsGender() + "\t");
        System.out.print("|sMajor" + selStudent.getsMajor() + "\t");
        System.out.println("END ---------------------------");
		
		
		StudentModifyService ModifyService = 
				ctx.getBean("studentModifyService", StudentModifyService.class);
		
		ModifyService.modify(new Student("hbs006", "pig", "p0066", "melissa", 27, 'w', "Computer"));
		
		printStudentInformationService.printStudentsInfo();
		
		StudentDeleteService deleteService = 
				ctx.getBean("studentDeleteService", StudentDeleteService.class);
		
		deleteService.delete("hbs005");
		
		printStudentInformationService.printStudentsInfo();
		
		ctx.close();
	
	}

}
