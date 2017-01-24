package generator;

public class data {	
	public static String dataGen(Boolean a,int rok, int mies, int dz){
		if(a){
			String ret = "";
			ret = ret + "'" + Integer.toString(rok) + "-";
			if(mies < 10){
				ret = ret + "0" + Integer.toString(mies) + "-";
			}
			else ret = ret + Integer.toString(mies) + "-";
			if(dz < 10){
				ret = ret + "0" + Integer.toString(dz) + "'";
			}
			else ret = ret + Integer.toString(dz) + "'";
			return ret;
		}
		else return "null";
	}
	public static String sDoc(Boolean a,int doc){
		if(a){
			return "'" + Integer.toString(doc) + "'";
		}
		else return "null";
	}
	public static String dataGodzGen(Boolean a,int rok, int mies, int dz, int godz, int min, int sek){
		if(a){
			String ret = "";
			ret = ret + "'" + Integer.toString(rok) + "-";
			if(mies < 10){
				ret = ret + "0" + Integer.toString(mies) + "-";
			}
			else ret = ret + Integer.toString(mies) + "-";
			if(dz < 10){
				ret = ret + "0" + Integer.toString(dz) + " ";
			}
			else ret = ret + Integer.toString(dz) + " ";
			if(godz < 10){
				ret = ret + "0" + Integer.toString(godz) + ":";
			}
			else ret = ret + Integer.toString(godz) + ":";
			if(min < 10){
				ret = ret + "0" + Integer.toString(min) + ":";
			}
			else ret = ret + Integer.toString(min) + ":";
			if(sek < 10){
				ret = ret + "0" + Integer.toString(sek) + "'";
			}
			else ret = ret + Integer.toString(sek) + "'";

			return ret;
		}
		else return "null";
	}
}
