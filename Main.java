package generator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random generator = new Random();
		
//		EXEC dbo.newConference @name = 'Tajniki SQL', -- nchar(30)
//	    @dateStart = '2018-01-15', -- datetime
//	    @dateEnd = '2018-01-20', -- datetime
//	    @maxParticipants = 10, -- smallint
//	    @address = 'Galaxy far, far away', -- nchar(30)
//	    @basePrice = 30, -- money
//	    @studentDiscount = 0.2 -- decimal(2, 0)
		
		String exec = "EXEC ";
		String arg1 = "dbo.newConference ";
		String arg2 = "@name = ";
		String arg3 = "@dateStart = ";
		String arg4 = "@dateEnd = ";
		String arg5 = "@maxParticipants = ";
		String arg6 = "@address = ";
		String arg7 = "@basePrice = ";
		String arg8 = "@studentDiscount = ";
		
//		@conferenceID = 1, -- nchar(10)
//		@dayNumber = 1, -- tinyint
//		@courseID = 1, -- nchar(10)
//		@maxParticipants = 2, -- smallint
//		@price = 10, -- money
//		@timeStart = '16:00', -- time(0)
//		@timeEnd = '19:00' -- time(0)
		String wynik="";
		int rok;
		int mies;
		int dz;
		int ilDni;
		int maxParti;
		int cusid;
		int resid;
		for(int i=1;i<=72;i++){		//i-ConferenceID
			rok = (i-1)/24 + 2018;
			mies = ((i-1)%24)/3 + 4;
			dz = ((i-1)%3)*7 + 1;
			ilDni = 1;		//ilDni = Math.abs(generator.nextInt())%2 + 1;
			maxParti = Math.abs(generator.nextInt())%20 + 190;
			
		wynik = wynik + (exec + arg1 
				+ arg2 + "'" + ecName.values()[Math.abs(generator.nextInt())%23] + "'" + ", " 
				+ arg3 + data.dataGen(true, rok, mies, dz) + ", "
				+ arg4 + data.dataGen(true, rok, mies, dz + ilDni) + ", "
				+ arg5 + maxParti + ", "
				+ arg6 + "'" + ecName.values()[Math.abs(generator.nextInt())%21] + "'" + ", "
				+ arg7 + (Math.abs(generator.nextInt())%25 + 25) + ", "
				+ arg8 + "0." + (Math.abs(generator.nextInt())%4 + 1) + " "
				);
		//jest konferencja
		//dodanie progów cenowych
//		@conferenceID NCHAR(10),
//		@discount decimal(2,2),
//		@finalDate DATE 
		int m = Math.abs(generator.nextInt())%2 + 1;
		for(int k=1;k<=ilDni + 1;k++){
			wynik = wynik + (exec + "dbo.newConferencePrice " + "@conferenceID = " + "'" + i + "'" + ", " + "@discount = 0." + (k*m)
					+ ", " + "@finalDate = " + data.dataGen(true, rok, mies - k - 1, dz) + " ");	//edited!!! k-1
		}
		//jest cena konferencji
		//dodanie warsztatu
//		[newWorkshop]
//		@conferenceID nchar(10)=null,
//		@dayNumber tinyint=null,
//		@courseID nchar(10)=null,
//		@maxParticipants smallint=null,
//		@price money=null,
//		@timeStart time(0)=null,
//		@timeEnd time(0)=null
		for(int k=1;k<=ilDni + 1;k++){	//dayNum
			for(int w=1;w<=4;w++){
			wynik = wynik + exec + "dbo.newWorkshop " + "@conferenceID = " + "'" + i + "'" + ", " 
					+ "@dayNumber = " + k
					+ ", " + "@courseID = " + (Math.abs(generator.nextInt())%25 + 1)
					+ ", " + "@maxParticipants = " + maxParti
					+ ", " + "@price = " + (Math.abs(generator.nextInt())%30 + 20)
					+ ", " + "@timeStart = " + "'" + (2*w+9)+":00" + "'"
					+ ", " + "@timeEnd = " + "'" + (w*2+10)+":30" + "'" + " ";
			}
		}
		//dodanie rezerwacji konferencji
//		@customerID nchar(10) = null,
//		@conferenceID nchar(10) = null,
//		@reservationDate date = null,
//		@paymentDate date = null
//		m = Math.abs(generator.nextInt())%2 + 2;
//		for(int k=1;k<=ilDni + 1;k++){
//			wynik = wynik + (exec + "dbo.ConferencePrice " + "@conferenceID = " + "'" + i + "'" + ", " + "@discount = 0." + (k*m)
//					+ ", " + "@finalDate = " + data.dataGen(true, rok, mies - k, dz) + " ");
//		}
		//nowe
		m = (Math.abs(generator.nextInt())%2 +1);
		for(int k=0;k<3;k++){
			cusid = (Math.abs(generator.nextInt())%66 + 1201 + k*66);
		wynik = wynik + exec + "dbo.newConferenceReservation " + "@customerID = " 
				+ "'" + cusid + "'"
				+ ", " + "@conferenceID = " + "'" + i + "'"
				+ ", " + "@reservationDate = " + data.dataGen(true, rok, mies - m, dz)
				+ ", " + "@paymentDate = " + data.dataGen(true, rok, mies - m, dz)
				+ " ";
		//dodanie conference reservation date
//		dbo.newConferenceReservationDate @conferenceID = 1, -- nchar(10)
//		@dayNumber = 1, -- tinyint
//		@customerID = 1, -- nchar(10)
//		@normalQuantity = 1, -- smallint
//		@discountQuantity = 2 -- smallint
		//nowe
		for(int w=1;w<=ilDni + 1;w++){
		wynik = wynik + exec + "dbo.newConferenceReservationDate " + "@conferenceID = "
				+ "'" + i + "'"
				+ ", " + "@dayNumber = " + w
				+ ", " + "@customerID = " + "'" + cusid + "'"
				+ ", " + "@normalQuantity = " + 20
				+ ", " + "@discountQuantity = " + 20
				+ " ";
			//dodanie workshop reservation
//				newWorkshopReservation]
//				@workshopID nchar(10),
//				@customerID nchar(10),
//				@peopleQuantity smallint
		
		//tu jestem	-- chyba ok, ale mo¿e trzeba bêdzie poprawiæ coœ z ck.blabla
			for(int warsz = 0;warsz<4;warsz++){
			wynik = wynik + exec + "newWorkshopReservation "
					+ "@workshopID = " + "'" + ((i-1)*8 + (w-1)*4 + warsz + 1) + "'"
					+ ", " + "@customerID = " + "'" + cusid + "'"
					+ ", " + "@peopleQuantity = " + 10 + " ";
			}
		//dot¹d
			
			//dodanie reservation detail
//				dbo.newConferenceReservationDetail @reservedCustomerID = 3, -- nchar(10)
//			    @dayNumber = 1, -- tinyint
//			    @customerID = 1, -- nchar(10)
//			    @conferenceID = 1 -- nchar(10)
				for(int cus=0;cus<20;cus++){
					resid = ((Math.abs(generator.nextInt())%6 + 1) + cus*6 + 120*k);
				wynik = wynik + exec + "dbo.newConferenceReservationDetail "
						+ "@reservedCustomerID = " + "'" + resid + "'"
						+ ", " + "@dayNumber = " + w
						+ ", " + "@customerID = " + "'" + cusid + "'"
						+ ", " + "@conferenceID = " + "'" + i + "'" 
						+ " ";
				
						//dodanie workshop reservation detail
//						[newWorkshopReservationDetail]
//						@reservedCustomerID nchar(10),
//						@workshopID nchar(10),
//						@present bit
						if(cus<5){
							for(int warsz = 0;warsz<4;warsz++){
							wynik = wynik + exec + "dbo.newWorkshopReservationDetail "
									+ "@reservedCustomerID = " + "'" + resid + "'"
									+ ", " + "@workshopID = " + "'" + ((i-1)*8 + (w-1)*4 + warsz + 1) + "'"
									+ ", " + "@present = NULL" + " ";
							}
						}
						
				}
				//dla normalnych
				for(int cus=0;cus<20;cus++){
					resid = ((Math.abs(generator.nextInt())%12 + 1) + cus*12 + 250*k + 441);
					wynik = wynik + exec + "dbo.newConferenceReservationDetail "
							+ "@reservedCustomerID = " + "'" + resid + "'"
							+ ", " + "@dayNumber = " + w
							+ ", " + "@customerID = " + "'" + cusid + "'"
							+ ", " + "@conferenceID = " + "'" + i + "'" 
							+ " ";
					//edited
					if(cus<5){
						for(int warsz = 0;warsz<4;warsz++){
						wynik = wynik + exec + "dbo.newWorkshopReservationDetail "
								+ "@reservedCustomerID = " + "'" + resid + "'"
								+ ", " + "@workshopID = " + "'" + ((i-1)*8 + (w-1)*4 + warsz + 1) + "'"
								+ ", " + "@present = NULL" + " ";
						}
					}
				}
				
		}
		}		
		//edit - tu jest dla prywatnych
		cusid = (Math.abs(generator.nextInt())%40 + 401);
		wynik = wynik + exec + "dbo.newConferenceReservation " + "@customerID = " 
				+ "'" + cusid + "'"	//400 - 440 normalni prywatni
				+ ", " + "@conferenceID = " + "'" + i + "'"
				+ ", " + "@reservationDate = " + data.dataGen(true, rok, mies - m, dz)
				+ ", " + "@paymentDate = " + data.dataGen(true, rok, mies - m, dz)
				+ " ";
		for(int w=1;w<=ilDni + 1;w++){
			wynik = wynik + exec + "dbo.newConferenceReservationDate " + "@conferenceID = "
					+ "'" + i + "'"
					+ ", " + "@dayNumber = " + w
					+ ", " + "@customerID = " + "'" + cusid + "'"
					+ ", " + "@normalQuantity = " + 1
					+ ", " + "@discountQuantity = " + 0
					+ " ";
			wynik = wynik + exec + "dbo.newConferenceReservationDetail "
					+ "@reservedCustomerID = " + "'" + cusid + "'"
					+ ", " + "@dayNumber = " + w
					+ ", " + "@customerID = " + "'" + cusid + "'"
					+ ", " + "@conferenceID = " + "'" + i + "'" 
					+ " ";
		}
		
		
		
		}
	
		
		
		try{
		    PrintWriter writer = new PrintWriter("GeneratorConferencji.txt", "UTF-8"); //UTF-8
		    writer.println(wynik);
		    writer.close();
		} catch (IOException e) {
		   System.out.println("nope");
		}
//		System.out.println(wynik);
		System.out.println("done");
		


	}

}
