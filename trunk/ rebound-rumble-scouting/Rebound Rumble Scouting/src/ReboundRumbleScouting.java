import java.io.File;

import javax.swing.JFileChooser;


public class ReboundRumbleScouting
{

	public static AccessFiles accessFiles;
	public static ManagementSystem managementSystem;
	public static JFileChooser fileChooser;
	public static File matchFile;
	
	public static void main(String[] args)
	{
		fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Select Match Config. File");
		fileChooser.showDialog(null, "Okay");
		matchFile = fileChooser.getSelectedFile();
		
		if(matchFile.canRead() && matchFile.canWrite())
			managementSystem = new ManagementSystem(matchFile);
		else
			System.out.println("CANNOT READ/WRITE TO MATCH FILE!!!");
		
	}

}
