package Utils;

public class DateUtil {

	public static String GetTodayStr() {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyMMddHHmmss");
		java.util.Date today = new java.util.Date();
		
		return sdf.format(today);
	}
}
