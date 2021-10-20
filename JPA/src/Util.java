

public class Util {

	public static String truncateString(String s, int length) {
		if (s.length() <= length) {
			return s;
		} else {
			return s.substring(0, length);
		}
	}

}