import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;

class ResultsGUI extends JPanel
{
	private Object temp;
	
	public static JLabel weatherPic;

	@SuppressWarnings("unchecked")
	public ResultsGUI()
	{
		//declare variables to display weather data
		String tempText = SearchFunction.temp.text();
		String windText = SearchFunction.wind.text();
		String humidText = SearchFunction.humid.text();
		String precipText = SearchFunction.precip.text();
		
		SearchFunction.createImage();
		
		//declare the main frame
		JFrame mainFrame = new JFrame("Search Results");
		
		Font resultsFont = new Font("Arial", Font.PLAIN, 40);
		Font titleFont = new Font("Arial", Font.PLAIN, 30);
		
		//making the title font underlined
		Map attributes = titleFont.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		
		Color backgroundColor = new Color(73,73,73);
		
		JLabel title = new JLabel("Search Results:");
		title.setSize(600,70);
		title.setForeground(Color.white);
		title.setLocation(30,20);
		title.setFont(titleFont.deriveFont(attributes));
	
		//weather icon
		weatherPic = new JLabel();
		weatherPic.setSize(150,125);
		weatherPic.setLocation(375,25);
		weatherPic.setIcon(SearchFunction.imageIcon);
		
		JLabel temp = new JLabel("Temperature: "+  tempText +"\u00b0"+"F");
		temp.setFont(resultsFont);
		temp.setForeground(Color.white);
		temp.setSize(400,50);
		temp.setLocation(50,175);
		
		JLabel precip = new JLabel("Precipitation: " + precipText);
		precip.setFont(resultsFont);
		precip.setForeground(Color.white);
		precip.setSize(400,50);
		precip.setLocation(50,250);
		
		JLabel humid = new JLabel("Humidity: " + humidText);
		humid.setFont(resultsFont);
		humid.setForeground(Color.white);
		humid.setSize(400,50);
		humid.setLocation(50,325);
		
		JLabel wind = new JLabel("Wind: " + windText);
		wind.setFont(resultsFont);
		wind.setForeground(Color.white);
		wind.setSize(400,50);
		wind.setLocation(50,400);
		
		//add all components to panel
		this.add(weatherPic);
		this.add(precip);
		this.add(humid);
		this.add(wind);
		this.add(temp);
		this.add(title);
		
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
