import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Journal {

	public static void main(final String[] args) throws IOException {
		final Journal j = new Journal();
		j.erstelle();
	}

	Double g_sum = 0d;
	Double l_sum = 0d;
	Double m_sum = 0d;
	double stundensatz = 6.0;

	private void erstelle() throws IOException {
		ArrayList<String[]> newOne = new ArrayList<>();
		final List<String[]> journal = readCsv();
		boolean found = false;
		for (int i = 0; i < journal.size(); i++) {
			found = false;
			String[] temp = journal.get(i);
			for (int j = 0; j < newOne.size(); j++) {
				String[] toCompare = newOne.get(j);
				if (temp[2].equals(toCompare[2])) {
					int one = Integer.parseInt(newOne.get(j)[3]);
					int two = Integer.parseInt(temp[3]);
					newOne.get(j)[3] = Integer.toString(one + two);
					found = true;
				}
			}
			if (!found) {
				newOne.add(temp);
			}
		}
		for(int i = 0; i < newOne.size(); i++) {
			printSatz("", i + 1, newOne.get(i), Integer.parseInt(newOne.get(i)[3]));
		}
		Double temp = 0.0;
		for (int i = 0; i < newOne.size(); i++) {
			temp += Double.parseDouble(newOne.get(i)[3]) * stundensatz;
		}
		printSumme(temp);
	}

	private void printSatz(final String x, Integer nr, final String[] satz, final Integer astd) {
		l_sum = astd * stundensatz;
		m_sum += l_sum;
		g_sum += l_sum;
		System.out.printf("%s %d  %s  %s   %d      %5.2f    %5.2f\n", x, nr++, satz[1], satz[2], astd, stundensatz,
				l_sum);

	}

	private void printSumme(Double d) {
		System.out.printf("                               Summe %5.2f\n", d);
		d = 0d;
	}

	private List<String[]> readCsv() throws IOException {
		final ArrayList<String[]> liste = new ArrayList<String[]>();
		final BufferedReader in = new BufferedReader(
				new FileReader("journal.csv", StandardCharsets.UTF_8));
		String line;
		boolean header = true;
		while ((line = in.readLine()) != null) {
			if (!header) {
				final String[] cols = line.split(",", 4);
				liste.add(cols);
			} else {
				header = false;
			}
		}
		in.close();
		return liste;
	}

}