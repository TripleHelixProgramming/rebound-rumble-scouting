import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class AccessFiles
{
	public static final String FILE_NAME = "SCOUTING.txt";
	
	private ArrayList<Match> matches;
	
	public AccessFiles()
	{
		matches = new ArrayList<Match>();
		scanHarddrives();
	}
	
	
	private void scanHarddrives()
	{
		
		for(char hardDrive = 'C'; hardDrive <= 'Z' ; hardDrive++)
		{
			File f = new File(hardDrive + ":\\" + "REBOUND RUMBLE DATA\\" + FILE_NAME);
			
			
			
			if(f.exists() && f.canRead())
			{
				//System.out.println("DATA[" + f.getAbsolutePath() + "]");
				collectMatches(f);
			}
		}
	}
	
	private void collectMatches(File f)
	{
		try
		{
			BufferedReader read = new BufferedReader(new FileReader(f));
			String line = "";
			while((line = read.readLine()) != null)
			{
				Match m = new Match(line);
				//System.out.println(m);
				matches.add(m);
			}
			
			read.close();
			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<Match> getMatches()
	{
		return matches;
	}
	
	
}
