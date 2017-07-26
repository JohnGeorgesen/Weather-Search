import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.sql.Time;
import java.util.Map;

import javax.swing.*;

import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SearchGUI  extends JPanel
{
	@SuppressWarnings("unchecked")
	public SearchGUI()
	{
		//declaring main frame
		JFrame mainFrame = new JFrame("Weather Search");
		
		//fonts used
		Font searchFont = new Font("Arial", Font.PLAIN, 35);
		Font titleFont = new Font("Roland", Font.PLAIN, 50);
		Font titleFontUnderline = new Font("Arial", Font.BOLD, 50);
		
		Color backgroundColor = new Color(73,73,73);
		
		JLabel title = new JLabel("Weather Search");
		title.setSize(600,70);
		title.setForeground(Color.white);
		title.setLocation(60,75);
		title.setFont(titleFont);
		
		JLabel titleUnderline = new JLabel("_________________");
		titleUnderline.setSize(600,70);
		titleUnderline.setForeground(Color.white);
		titleUnderline.setLocation(60,80);
		titleUnderline.setFont(titleFontUnderline);
		
		JTextField searchbar = new JTextField(15);
		searchbar.setFont(searchFont);
		searchbar.setSize(370,35);
		searchbar.setLocation(115,250);
		
		JButton searchButton = new JButton("Search");
		searchButton.setBackground(new Color(59, 89, 182));
		searchButton.setForeground(Color.WHITE);
		searchButton.setFocusPainted(false);
		searchButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		searchButton.setSize(140,50);
		searchButton.setLocation(230,400);
		
		//add functionality to search button
		searchButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				SearchFunction.search = searchbar.getText();
				
				try 
				{
					new SearchFunction(SearchFunction.search);
					new ResultsGUI();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			} 
		});
		
		//add to panel
		this.add(titleUnderline);
		this.add(title);
		this.add(searchButton);
		this.add(searchbar);
		
		//set panel
		this.setOpaque(true);
	    this.setBackground(backgroundColor);
		this.setLayout(null);
		this.setSize(mainFrame.getWidth(), mainFrame.getHeight());
		
		//set frame
		mainFrame.add(this);
		mainFrame.setVisible(true);
		mainFrame.setSize(600, 600);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
	}
}
