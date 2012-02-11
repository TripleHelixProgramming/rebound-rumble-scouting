import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class ManagementSystem extends JFrame
{
	private int width, height;
	private JScrollPane jScroll;
	private Container container;
	private JPanel panel;
	
	private File matchFile;
	private File scoreFile;
	private ArrayList<MatchManaged> matchArray;
	
	private AccessFiles accessFiles;
	private ArrayList<Match> matches;
	private UpdateFiles updateFiles;
	
	private ArrayList<Match> masterMatches;
	
	public ManagementSystem(File mF)
	{
		matchFile = mF;
		scoreFile = new File(matchFile.getAbsoluteFile().toString().substring(0, matchFile.getAbsoluteFile().toString().indexOf(".")) + "Scores.txt");
		getMasterMatches();
		
		setTitle("Scouting Management System");
		
		width = (int) ((3.0/8.0) * (Toolkit.getDefaultToolkit().getScreenSize().getWidth()));
		height = (int) ((8.0/9.0) * (Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
		setSize(width, height);
		setResizable(false);
		setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2)-(width/2), (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2)-(height/2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		container = getContentPane();
		container.setLayout(new BorderLayout());
		populateMatchFile();
		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		
		for(int i = 0; i < matchArray.size(); i++)
		{
			c.gridy = i;
			panel.add(matchArray.get(i).getGUIInputs(), c);
		}
		
		jScroll = new JScrollPane(panel);
		jScroll.setMinimumSize(new Dimension(width, height));
		jScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScroll.setMaximumSize(new Dimension(width, height));
		
		
		container.add(jScroll, BorderLayout.CENTER);
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1, 2));
		JPanel bluePanel = new JPanel();
		bluePanel.setBackground(Color.BLUE);
		JPanel redPanel = new JPanel();
		redPanel.setBackground(Color.RED);
		topPanel.add(redPanel);
		topPanel.add(bluePanel);
		
		container.add(topPanel, BorderLayout.NORTH);
		setVisible(true);
		
		addWindowListener(new WindowClosed());
		
		updateFiles = new UpdateFiles();
		updateFiles.start();
	}
	
	private void getMasterMatches()
	{
		try
		{
			masterMatches = new ArrayList<Match>();
			
			BufferedReader read = new BufferedReader(new FileReader(scoreFile));
			String line = "";
			while((line = read.readLine()) != null)
			{
				masterMatches.add(new Match(line));
			}
			
			//outputMatchArray();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private void saveData(Match m)
	{
		
	}
	
	private void populateMatchFile()
	{
		try
		{
			matchArray = new ArrayList<MatchManaged>();
			
			BufferedReader read = new BufferedReader(new FileReader(matchFile));
			String line = "";
			while((line = read.readLine()) != null)
			{
				matchArray.add(new MatchManaged(line));
			}
			
			//outputMatchArray();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private void outputMatchArray()
	{
		for(int i = 0; i < matchArray.size(); i++)
		{
			System.out.println(matchArray.get(i));
		}
	}

	private void checkData()
	{
		//panel = new JPanel();
		//panel.setLayout(new GridBagLayout());
		for(int i = 0; i < matches.size(); i++)
		{
			for(int j = 0; j < matchArray.size(); j++)
			{
				Match m = matches.get(i);
				MatchManaged completeM = matchArray.get(j);
				
				if((m.matchNum == completeM.matchNum))
				{
					if(!completeM.red1Check && m.teamNum == completeM.red1)
					{
						completeM.red1Check = true;
						
						saveData(m);
					}else if(!completeM.red2Check && m.teamNum == completeM.red2)
					{
						completeM.red2Check = true;
					}else if(!completeM.red3Check && m.teamNum == completeM.red3)
					{
						completeM.red3Check = true;
					}else if(!completeM.blue1Check && m.teamNum == completeM.blue1)
					{
						completeM.blue1Check = true;
					}else if(!completeM.blue2Check && m.teamNum == completeM.blue2)
					{
						completeM.blue2Check = true;
					}else if(!completeM.blue3Check && m.teamNum == completeM.blue3)
					{
						completeM.blue3Check = true;
					}else
					{
						//NOT FOUND IN MATCH, ERROR$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
					}
					
					revalFrame();
				}
			}
		}
		
		
	}
	
	private void revalFrame()
	{
		panel.removeAll();
		
		
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		
		for(int i = 0; i < matchArray.size(); i++)
		{
			c.gridy = i;
			panel.add(matchArray.get(i).getGUIInputs(), c);
		}
		
		panel.repaint();
		panel.revalidate();
		
	    
		
	}
	
	
	
	private class WindowClosed implements WindowListener
	{

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent arg0) {
			// TODO Auto-generated method stub
			updateFiles.stop();
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}

	private class UpdateFiles extends Thread
	{
		
		public void run()
		{
			try
			{
				while(true)
				{
					//System.out.println("Thread");
					accessFiles = new AccessFiles();
					
					if(matches == null || matches.size() != accessFiles.getMatches().size())
					{
						matches = accessFiles.getMatches();
						//System.out.println("Update Files");
						checkData();
					}
					
					sleep(1000);
				}
				
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
