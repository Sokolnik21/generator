package generator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class MainPersonsi {

	public static void main(String[] args) {
		Random generator = new Random();
		
//		@firstName nchar(30)=NULL,
//		@lastName nchar(30)=NULL,
//		@studentDocument nchar(10)=null,
//		@studentDocumentExpirationDate date=null,
//		@birthDate date=null,
//		@email nchar(30)=null,
//		@phone nchar(10)=null,
//		@address nchar(10)=null,
//		@city nchar(10)=null,
//		@postal nchar(10)=null,
//		@country nchar(10)=null
		
		String exec = "EXEC ";
		String person = "dbo.newPerson ";
		String fName = "@firstName = ";
		String lName = "@lastName = ";
		String sDoc = "@studentDocument = ";
		String sDocEx = "@studentDocumentExpirationDate = ";
		String bDate = "@birthDate = ";
		String email = "@email = ";
//				"@phone = "
//				@address nchar(10)=null,
//				@city nchar(10)=null,
//				@postal nchar(10)=null,
//				@country nchar(10)=null
		
		String wynik="";
		for(int i=0;i<400;i++){
		Boolean disc = Math.abs(generator.nextInt())%2 == 1;
		
		wynik = wynik + exec + person + fName + "'" +
				efName.values()[Math.abs(generator.nextInt())%25] + "'" + ", " + lName + "'" +
				efNazw.values()[Math.abs(generator.nextInt())%14] + "'" + ", " + sDoc + data.sDoc(true, generator.nextInt()%10000 + 20000) +
				", " + sDocEx + data.dataGen(true, Math.abs(generator.nextInt())%3 + 2025, Math.abs(generator.nextInt())%11 + 1, Math.abs(generator.nextInt())%27 + 1)
				+ ", " + bDate + data.dataGodzGen(true, Math.abs(generator.nextInt())%40 + 1960, Math.abs(generator.nextInt())%11 + 1, Math.abs(generator.nextInt())%27 + 1, Math.abs(generator.nextInt())%23, Math.abs(generator.nextInt())%59, Math.abs(generator.nextInt())%59)
				+ ", " + email + "'" + eMail.values()[Math.abs(generator.nextInt())%22] +"@vp.pl" + "'" + ", "
				+ "@phone = " + "'" + (Math.abs(generator.nextInt())%900000000 + 100000000) + "'" + ", "
				+ "@address = " + "'" + (eAddress.values()[Math.abs(generator.nextInt())%21]) + "'" + ", "
				+ "@city = " + "'" + (eCity.values()[Math.abs(generator.nextInt())%27]) + "'" + ", "
				+ "@postal = " + "'" + (Math.abs(generator.nextInt())%90 + 10) + "-" + (Math.abs(generator.nextInt())%900 + 100) + "'" + ", "
				+ "@country = " + "'" + (eCountry.values()[Math.abs(generator.nextInt())%21]) + "'" + " ";
		}
		for(int i=0;i<800;i++){
		wynik = wynik + exec + person + fName + "'" +
				efName.values()[Math.abs(generator.nextInt())%25] + "'" + ", " + lName + "'" +
				efNazw.values()[Math.abs(generator.nextInt())%14] + "'" + ", " + sDoc + data.sDoc(false, generator.nextInt()%10000 + 20000) +
				", " + sDocEx + data.dataGen(false, Math.abs(generator.nextInt())%3 + 2025, Math.abs(generator.nextInt())%11 + 1, Math.abs(generator.nextInt())%27 + 1)
				+ ", " + bDate + data.dataGodzGen(true, Math.abs(generator.nextInt())%40 + 1960, Math.abs(generator.nextInt())%11 + 1, Math.abs(generator.nextInt())%27 + 1, Math.abs(generator.nextInt())%23, Math.abs(generator.nextInt())%59, Math.abs(generator.nextInt())%59)
				+ ", " + email + "'" + eMail.values()[Math.abs(generator.nextInt())%22] +"@vp.pl" + "'" + ", "
				+ "@phone = " + "'" + (Math.abs(generator.nextInt())%900000000 + 100000000) + "'" + ", "
				+ "@address = " + "'" + (eAddress.values()[Math.abs(generator.nextInt())%21]) + "'" + ", "
				+ "@city = " + "'" + (eCity.values()[Math.abs(generator.nextInt())%27]) + "'" + ", "
				+ "@postal = " + "'" + (Math.abs(generator.nextInt())%90 + 10) + "-" + (Math.abs(generator.nextInt())%900 + 100) + "'" + ", "
				+ "@country = " + "'" + (eCountry.values()[Math.abs(generator.nextInt())%21]) + "'" + " ";
		}
//		@name nchar(10)=null,
//		@personToContactID nchar(10)=null,
//		@email nchar(30)=null,
//		@phone nchar(10)=null,
//		@address nchar(10)=null,
//		@city nchar(10)=null,
//		@postal nchar(10)=null,
//		@country nchar(10)=null
		for(int i=0;i<200;i++){
		wynik = wynik + exec + "dbo.newCompany " + "@name = " + "'" +
			ecName.values()[Math.abs(generator.nextInt())%23] + "'" 
			+ ", " + email + "'" + eMail.values()[Math.abs(generator.nextInt())%22] +"@vp.pl" + "'" + ", "
			+ "@phone = " + "'" + (Math.abs(generator.nextInt())%900000000 + 100000000) + "'" + ", "
			+ "@address = " + "'" + (eAddress.values()[Math.abs(generator.nextInt())%21]) + "'" + ", "
			+ "@city = " + "'" + (eCity.values()[Math.abs(generator.nextInt())%27]) + "'" + ", "
			+ "@postal = " + "'" + (Math.abs(generator.nextInt())%90 + 10) + "-" + (Math.abs(generator.nextInt())%900 + 100) + "'" + ", "
			+ "@country = " + "'" + (eCountry.values()[Math.abs(generator.nextInt())%21]) + "'" + " ";
	}
		try{
		    PrintWriter writer = new PrintWriter("GeneratorPersonsow.txt", "UTF-8"); //UTF-8
		    writer.println(wynik);
		    writer.close();
		} catch (IOException e) {
		   System.out.println("nope");
		}
		System.out.println(wynik);
		


	}

}
