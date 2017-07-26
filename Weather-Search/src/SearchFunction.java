import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sun.imageio.plugins.common.ImageUtil;

public class SearchFunction 
{
	//all variables to hold weather data
	public static Element temp;
	public static Element descrip;
	public static Element precip;
	public static Element humid;
	public static Element wind;
	
	public static ImageIcon imageIcon;
	
	public static String search = null;
	
	public SearchFunction(String search) throws IOException
	{
		//replace all the spaces in the search string with an addition sign
		search = search.replaceAll(" ", "+");
		
		//jsoup connecting to url to get weather data
		Document doc = Jsoup.connect("https://www.google.com/search?q="+search+"+weather&oq="+search+"+weather&gs_l=serp.3..0i131k1l4j0l6.572041.573048.0.573464.7.7.0.0.0.0.139.769.1j6.7.0....0...1.1.64.serp..0.7.765.TlvHiGCRM0I").get();
		
		//storing weather data in the vars
		temp = doc.getElementById("wob_tm"); 
		descrip =doc.getElementById("wob_dc");
		precip =  doc.getElementById("wob_pp");
		humid = doc.getElementById("wob_hm");
		wind = doc.getElementById("wob_ws");
		
		System.out.println("Temperature: " + temp.text() +"\u00b0"+"F");
        System.out.println(descrip.text());
        System.out.println("Precipitation: " + precip.text());
        System.out.println("Humidity: " + humid.text());
        System.out.println("Wind: " + wind.text());
	}
	
	//method to create and resize the image icon 
	public static void createImage()
	{
		BufferedImage img = null;
		System.out.println(descrip.text());
		
		//delcare path to pic file
		String picURL = null;
	
		//checking which image to display
		if(descrip.text().equals("Partly Cloudy"))
		{
			picURL ="icons/partcloud.png";
		}
		else if(descrip.text().equals("Thunderstorm") || descrip.text().equals("Scattered Thunderstorms"))
		{
			picURL = "icons/tstorm.png";
		}
		else if(descrip.text().equals("Sunny") || descrip.text().equals("Mostly Sunny") || descrip.text().equals("Clear"))
		{
			picURL = "icons/sun.png";
		}
		else if(descrip.text().equals("Windy"))
		{
			picURL = "icons/wind.png";
		}
		else if(descrip.text().equals("Snow") || descrip.text().equals("Snow Showers"))
		{
			picURL = "icons/snow.png";
		}
		else if(descrip.text().equals("Cloudy") || descrip.text().equals("Mostly Cloudy") || descrip.text().equals("Clear with periodic clouds"))
		{
			picURL = "icons/cloud.png";
		}
		else
		{
			System.out.println("Error in getting data for image");
			picURL = null;
		}
		
		File picFile = new File(picURL);
		try 
		{
			img = ImageIO.read(picFile);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		//fit image into icon size
		Image dimg = img.getScaledInstance(150, 125, Image.SCALE_SMOOTH);
		
		//set image icon
		imageIcon = new ImageIcon(dimg);
	}
}