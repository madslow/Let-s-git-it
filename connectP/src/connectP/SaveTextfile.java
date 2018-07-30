package connectP;

import java.io.*;

public class SaveTextfile{

	public void SaveText(String filename, String text) throws IOException{
		File f = new File(filename);
		
		
		if(!f.exists()){
			f.createNewFile();
		}
		
		FileWriter fw = new FileWriter(f, true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(text);
		bw.close();
		}
}
