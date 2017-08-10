
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFromFile {

	public static void main(String[] args)  {

		String filePath = "src/inputFile.txt";
		BufferedReader br = doesFileExist(filePath);
		//	if ((br = doesFileExist(filePath) == null) return;
		try {
			String newLine; 
			int i;
			while ((newLine = br.readLine()) != null) {
				String[] tokens = newLine.split("-|,");
				i=0;
				while (i < tokens.length)
					System.out.println(tokens[i++]);
			}
		} catch (IOException e) {
			System.out.println("Could not read new line.");
			e.printStackTrace();
		}

		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static BufferedReader doesFileExist(String path) {
		Path p=Paths.get(path);
		File file = new File(p.toUri());
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			System.out.println("File not found " + file);
			return null;
		}
		return br;
	}
}
