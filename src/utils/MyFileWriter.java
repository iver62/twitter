package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MyFileWriter {
	
	public static void write(List<String> tweets) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("tweets.txt"));
			for (String tw : tweets) {
				bw.write(tweets.indexOf(tw)+1 + " " + tw);
				bw.newLine();
			}
			bw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
