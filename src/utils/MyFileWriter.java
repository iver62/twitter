package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MyFileWriter {
	
	public static void writeData(List<String> tweets) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("res.txt"));
			for (String str : tweets) {
				bw.write(str);
				bw.newLine();
			}
			bw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
