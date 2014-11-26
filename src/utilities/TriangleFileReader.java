package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TriangleFileReader {
	
	public static List<Integer[]> getTriangleFromFile(String filePath) throws NumberFormatException, IOException{
		List<Integer[]> triangle = new ArrayList<Integer[]>();
		
		File numbersFile = new File(filePath);
		BufferedReader br = new BufferedReader(new FileReader(numbersFile));
		String line;
		while ((line = br.readLine()) != null) {
			String[] currentLine = line.split(" ");
			Integer[] pyramidLine = new Integer[currentLine.length];
			
			for (int i = 0; i < currentLine.length; i++){
				pyramidLine[i] = Integer.parseInt(currentLine[i]);
			}
			triangle.add(pyramidLine);
		}
		br.close();
		
		return triangle;
	}

}
