import java.util.Scanner;

public class StringCal {
	private static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Please enter the string containing numbers");
		String number = scnr.nextLine();
		System.out.println("Sum is " + add(number));

	}

	public static String add(String number) {
		int len = number.length();

		// If number string has ',' in the end(example- 12,4,)
		if (number.charAt(len - 1) == ',') {
			return "Number expected but EOF found";
		}

		// Number string with , as separator(eg-1,2,2.3)(int or double both values)
		else if (number.contains(",")) {
			double sum = 0;
			String[] div = number.split(",");
			int wrong = 0;
			String negNum = "";

			// Number string with -ve numbers(eg-1,2,3)
			if (number.contains("-")) {
				try {
					int i;
					for (i = 0; i < div.length; i++) {
						if (Double.parseDouble(div[i]) < 0) {
							negNum += div[i] + ",";
						}
					}
					negNum = negNum.substring(0, negNum.length() - 1);
					return "Negative not allowed: " + negNum;
				} // number string as ,, together(if user missed number, expection will be thrown)
				catch (NumberFormatException e) {
					wrong = number.indexOf(",,") + 1;
					return "Negative not allowed: " + negNum.substring(0, negNum.length() - 1)
							+ "\nNumber expected but ',' found at position " + wrong;
				}
			}
			for (int i = 0; i < div.length; i++)
				sum += Double.parseDouble(div[i]);
			if (!(number.contains("."))) {
				int sumInt = (int) sum;
				return String.valueOf(sumInt);
			}
			return String.valueOf(sum);
		}

		// If number string is 0 only
		else if (number.equals("0")) {
			return "0";
		}

		// if '|' is used as delimiter
		else if (number.contains("|")) {
			double sum = 0;

			String[] div = number.split("[|]");

			for (int i = 0; i < div.length; i++) {
				sum += Double.parseDouble(div[i]);
			}

			if (!(number.contains("."))) {
				int sumInt = (int) sum;
				return String.valueOf(sumInt);
			}
			return String.valueOf(sum);
		}

		// if ';' is used as delimiter
		else if (number.contains(";")) {
			double sum = 0;

			String[] div = number.split("[;]");

			for (int i = 0; i < div.length; i++) {
				sum += Double.parseDouble(div[i]);
			}

			if (!(number.contains("."))) {
				int sumInt = (int) sum;
				return String.valueOf(sumInt);
			}
			return String.valueOf(sum);
		}

		// if '\n' is used as delimeter
		else if (number.contains("\n")) {
			double sum = 0;

			String[] div = number.split("[\n]");

			for (int i = 0; i < div.length; i++) {
				sum += Double.parseDouble(div[i]);
			}

			if (!(number.contains("."))) {
				int sumInt = (int) sum;
				return String.valueOf(sumInt);
			}
			return String.valueOf(sum);
		}

		// Number string contains only 1 number
		else if(number.length()==1)
			return number;
		else
			return "Not valid for addition";

	}

}
