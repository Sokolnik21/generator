package generator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class MainCourse {

	public static void main(String[] args) {
		Random generator = new Random();
		
		String wynik="";
		for(int i=1;i<=25;i++){
			
//			[newCourse]
//			@courseName nchar(50),
//			@furtherReading varchar(50),
//			@curriculum varchar(50)
			
		wynik = wynik + ("EXEC " + "dbo.newCourse " + "@courseName = "
				+ "'" + ecName.values()[Math.abs(generator.nextInt())%23] + "'" + ", "
				+ "@furtherReading = "
				+ "'" + ecName.values()[Math.abs(generator.nextInt())%23] + "'" + ", "
				 + "@curriculum = "
				+ "'" + ecName.values()[Math.abs(generator.nextInt())%23] + "'" + " "
				);
		}
		try{
		    PrintWriter writer = new PrintWriter("GeneratorCouseow.txt", "UTF-8"); //UTF-8
		    writer.println(wynik);
		    writer.close();
		} catch (IOException e) {
		   System.out.println("nope");
		}
		System.out.println(wynik);
		


	}

}
