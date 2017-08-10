

public class ReverseString {

	public static void main(String[] args) {

		System.out.println(reverseEverything ("hope you are doing well"));
		System.out.println(reverseEverything ("abc de fgh u"));
		System.out.println(reverseEverything (" "));
		System.out.println(reverseEverything (""));
		System.out.println(reverseEverything ("a"));
		System.out.println(reverseEverything (" abc de fgh u "));
	}

	private static String reverseEverything(String s) {	

		if (s.isEmpty() || s.length()==1) return s;
		StringBuffer newString = new StringBuffer();	
		for (int i = s.length()-1; i>-1; i--) {
			newString.append(s.charAt(i));
		}
		return newString.toString();
	}
}
