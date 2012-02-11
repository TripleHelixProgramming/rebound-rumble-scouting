import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MatchManaged
{
	public int matchNum;
	public int red1, red2, red3, blue1, blue2, blue3;
	public boolean red1Check, red2Check, red3Check, blue1Check, blue2Check, blue3Check;
	
	public static final String checkTrue = "yes", checkFalse = "no";
	
	public JTextField matchNumJ, red1J, red2J, red3J, blue1J, blue2J, blue3J;
	
	
	public MatchManaged(String data)
	{
		matchNum = Integer.parseInt(data.substring(0, data.indexOf(" ")));
		data = data.substring(data.indexOf(" ") + 1);
		
		red1 = Integer.parseInt(data.substring(0, data.indexOf(" ")));
		data = data.substring(data.indexOf(" ") + 1);
		
		red1Check = data.substring(0, data.indexOf(" ")).equals(checkTrue); 
		data = data.substring(data.indexOf(" ") + 1);
		
		red2 = Integer.parseInt(data.substring(0, data.indexOf(" ")));
		data = data.substring(data.indexOf(" ") + 1);
		
		red2Check = data.substring(0, data.indexOf(" ")).equals(checkTrue); 
		data = data.substring(data.indexOf(" ") + 1);
		
		red3 = Integer.parseInt(data.substring(0, data.indexOf(" ")));
		data = data.substring(data.indexOf(" ") + 1);
		
		red3Check = data.substring(0, data.indexOf(" ")).equals(checkTrue); 
		data = data.substring(data.indexOf(" ") + 1);
		
		blue1 = Integer.parseInt(data.substring(0, data.indexOf(" ")));
		data = data.substring(data.indexOf(" ") + 1);
		
		blue1Check = data.substring(0, data.indexOf(" ")).equals(checkTrue); 
		data = data.substring(data.indexOf(" ") + 1);
		
		blue2 = Integer.parseInt(data.substring(0, data.indexOf(" ")));
		data = data.substring(data.indexOf(" ") + 1);
		
		blue2Check = data.substring(0, data.indexOf(" ")).equals(checkTrue); 
		data = data.substring(data.indexOf(" ") + 1);
		
		blue3 = Integer.parseInt(data.substring(0, data.indexOf(" ")));
		data = data.substring(data.indexOf(" ") + 1);
		
		blue3Check = data.substring(0).equals(checkTrue);
		
		createGUIInputs();
	}
	
	public JPanel getGUIInputs()
	{
		resetGUIInputs();
		
		JPanel panel = new JPanel();
		
		panel.add(matchNumJ);
		panel.add(new JLabel("           "));
		panel.add(red1J);
		panel.add(red2J);
		panel.add(red3J);
		panel.add(new JLabel("                   "));
		panel.add(blue1J);
		panel.add(blue2J);
		panel.add(blue3J);
		panel.add(new JLabel("\n"));
		
		return panel;
	}

	public void createGUIInputs()
	{
		matchNumJ = new JTextField(Integer.toString(matchNum), 4);
		
		red1J = new JTextField(Integer.toString(red1), 4);
		
		if(red1Check)
		{
			red1J.setBackground(Color.GREEN);
		}
		{
			red1J.setBackground(Color.YELLOW);
		}
		
		red2J = new JTextField(Integer.toString(red2), 4);
		
		if(red2Check)
		{
			red2J.setBackground(Color.GREEN);
		}
		{
			red2J.setBackground(Color.YELLOW);
		}
		
		red3J = new JTextField(Integer.toString(red3), 4);
		
		if(red3Check)
		{
			red3J.setBackground(Color.GREEN);
		}
		{
			red3J.setBackground(Color.YELLOW);
		}
		
		blue1J = new JTextField(Integer.toString(blue1), 4);
		
		
		if(blue1Check)
		{
			blue1J.setBackground(Color.GREEN);
		}
		{
			blue1J.setBackground(Color.YELLOW);
		}
		
		blue2J = new JTextField(Integer.toString(blue2), 4);
		
		if(blue2Check)
		{
			blue2J.setBackground(Color.GREEN);
		}
		{
			blue2J.setBackground(Color.YELLOW);
		}
		
		blue3J = new JTextField(Integer.toString(blue3), 4);
		
		if(blue3Check)
		{
			blue3J.setBackground(Color.GREEN);
		}
		{
			blue3J.setBackground(Color.YELLOW);
		}
	}
	
	public void resetGUIInputs()
	{
		matchNumJ.setText(Integer.toString(matchNum));
		
		red1J.setText(Integer.toString(red1));
		
		if(red1Check)
		{
			red1J.setBackground(Color.GREEN);
		}else
		{
			red1J.setBackground(Color.YELLOW);
		}
		
		red2J.setText(Integer.toString(red2));
		
		if(red2Check)
		{
			red2J.setBackground(Color.GREEN);
		}else
		{
			red2J.setBackground(Color.YELLOW);
		}
		
		red3J.setText(Integer.toString(red3));
		
		if(red3Check)
		{
			red3J.setBackground(Color.GREEN);
		}else
		{
			red3J.setBackground(Color.YELLOW);
		}
		
		blue1J.setText(Integer.toString(blue1));
		
		
		if(blue1Check)
		{
			blue1J.setBackground(Color.GREEN);
		}else
		{
			blue1J.setBackground(Color.YELLOW);
		}
		
		blue2J.setText(Integer.toString(blue2));
		
		if(blue2Check)
		{
			blue2J.setBackground(Color.GREEN);
		}else
		{
			blue2J.setBackground(Color.YELLOW);
		}
		
		blue3J.setText(Integer.toString(blue3));
		
		if(blue3Check)
		{
			blue3J.setBackground(Color.GREEN);
		}else
		{
			blue3J.setBackground(Color.YELLOW);
		}
	}
	
	public String toString()
	{
		String output = matchNum + " " + red1 + " ";
		
		if(red1Check)
			output += checkTrue + " " + red2 + " ";
		else
			output += checkFalse + " " + red2 + " ";
		
		if(red2Check)
			output += checkTrue + " " + red3 + " ";
		else
			output += checkFalse + " " + red3 + " ";
		
		if(red3Check)
			output += checkTrue + " " + blue1 + " ";
		else
			output += checkFalse + " " + blue1 + " ";
		
		if(blue1Check)
			output += checkTrue + " " + blue2 + " ";
		else
			output += checkFalse + " " + blue2 + " ";
		
		if(blue2Check)
			output += checkTrue + " " + blue3 + " ";
		else
			output += checkFalse + " " + blue3 + " ";
		
		if(blue3Check)
			output += checkTrue;
		else
			output += checkFalse;
		
		return output;
		
		
	}

	
}
