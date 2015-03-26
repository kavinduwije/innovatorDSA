import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import java.io.*; 
import java.util.LinkedList;
import java.util.ListIterator; 

public class RealEstate 
{
static // The list of house information
LinkedList<House> ml = new LinkedList<House>();
// Text fields
private static JTextField lotText; // Lot number field
private static JTextField firstText; // First name field

private static JTextField lastText; // Last name field
private static JTextField priceText; // Price field
private static JTextField feetText; // Square feet field
private static JTextField bedText; // Number of bedrooms field
// Status Label
private static JLabel statusLabel; // Label for status info
// Display information about parameter house on screen

private static int getnext(int lotn)
{
	int z= ml.size();

	int location = 0;
	int status=0;
	int comparedSize= lotn;
	
	
	while (location < z)
	{    	
	House h2=(House) ml.get(location);
	int cuurentlot=h2.lotNumber;
		if (cuurentlot> comparedSize) {
			
			
		} else if (cuurentlot == comparedSize) {
		   status=location;	
		   break;
		}
        
		
		location++;
	}
	if(lotn==0 || location==z )
		status= 0;
	return status;
	
}

private static int search(int lotnum,LinkedList<House> ml)
{
	
	int z= ml.size();

	int location = 0;
	int status=0;
	
	int searchableitem= lotnum;
	while (location <= z)
	{    
		if (location == z) {
        	status=-1;
        	break;
			
			
		} 
		else
		{
	House h2=(House) ml.get(location);
	int cuurentlot=h2.lotNumber;
		
	if (cuurentlot == searchableitem) {
		   
		House house=new House("x","x",0, 0,0,0);
    	house=h2;
    	showHouse(house);
		status=0;	
	   break;
		}
        
		}
		location++;
	}//while close
	
	return status;
}


private static int insert(House h1, LinkedList<House> ml)
{
	
	int z= ml.size();

	int location = 0;
	int status=0;
	
	int comparedSize= h1.lotNumber;
	while (location < z)
	{    
	
		
	House h2=(House) ml.get(location);
	int cuurentlot=h2.lotNumber;
		if (cuurentlot> comparedSize) {
			ml.add(location,h1);
			status=1;
			break;
			
		} else if (cuurentlot == comparedSize) {
		   status=0;	
		   break;
		}
        
		
		location++;
	}//while close
	
	if (location == z) {
    	ml.add(location,h1);
    	status=1;} 
	return status;
}



private static void showHouse(House house)
{
lotText.setText(Integer.toString(house.lotNumber()));
firstText.setText(house.firstName());
lastText.setText(house.lastName());
priceText.setText(Integer.toString(house.price()));
feetText.setText(Integer.toString(house.squareFeet()));
bedText.setText(Integer.toString(house.bedRooms()));
}
// Returns current screen information as a ListHouse
private static House getHouse()
{
String lastName;
String firstName;
int lotNumber;
int price;
int squareFeet;
int bedRooms;
lotNumber = Integer.parseInt(lotText.getText());
firstName = firstText.getText();
lastName = lastText.getText();
price = Integer.parseInt(priceText.getText());
squareFeet = Integer.parseInt(feetText.getText());
bedRooms = Integer.parseInt(bedText.getText());
House house = new House(lastName, firstName, lotNumber, price,
squareFeet, bedRooms);
return house;
}
// Clears house information from screen
private static void clearHouse()
{
lotText.setText("");
firstText.setText("");
lastText.setText("");
priceText.setText("");
feetText.setText("");
bedText.setText("");
}
// Define a button listener
private static class ActionHandler implements ActionListener
{
public void actionPerformed(ActionEvent event)
// Listener for the button events
{
if (event.getActionCommand().equals("Reset"))
{ // Handles Reset event

clearHouse();
statusLabel.setText("List reset");

}
else
if (event.getActionCommand().equals("Next"))
{ // Handles Next event
if (ml.size() == 0)
statusLabel.setText("list is empty!");
else
	{
	int lotNumber = Integer.parseInt(lotText.getText());
	
	
	int currentindex=getnext(lotNumber);
	    currentindex++;
	    if(currentindex==ml.size())
	    {
	    	currentindex=0;
	    }
    	showHouse(ml.get(currentindex));
    	statusLabel.setText("Next house displayed");
    }

}


else
if (event.getActionCommand().equals("Add"))
{ // Handles Add event
try
{
	House h1=getHouse();
int status=insert(h1,ml);
if(status==1)
	statusLabel.setText("New House added");
else if(status==0)
	statusLabel.setText("House already added");
}
catch (NumberFormatException badHouseData)
{
// Text field info incorrectly formated
statusLabel.setText("Number? " + badHouseData.getMessage());
}
}
/*else
if (event.getActionCommand().equals("Delete"))
{ // Handles Delete event
try
{
house = getHouse();
if (list.isThere(house))
{
list.delete(house);
statusLabel.setText("House deleted");
}
else
statusLabel.setText("Lot number not on list");
}
catch (NumberFormatException badHouseData)
{
// Text field info incorrectly formated
statusLabel.setText("Number? " + badHouseData.getMessage());
}
}*/
else
if (event.getActionCommand().equals("Clear"))
{ // Handles Clear event
clearHouse();
statusLabel.setText(ml.size() + " houses on list");
} 
else
if (event.getActionCommand().equals("Find"))
{ // Handles Find event
int lotNumber;
try
{
     lotNumber = Integer.parseInt(lotText.getText());
     
	int status=search(lotNumber,ml);
	if(status==-1)
		statusLabel.setText("House not found");
     
	else
		statusLabel.setText("House found");
     }

    
     

catch (NumberFormatException badHouseData)
{
// Text field info incorrectly formated
statusLabel.setText("Number? " + badHouseData.getMessage());
}
}
}
}
public static void main(String args[]) throws IOException
{
House house;
//char command;
//int length;
JLabel blankLabel; // To use up one frame slot
JLabel lotLabel; // Labels for input fields
JLabel firstLabel;
JLabel lastLabel;
JLabel priceLabel;
JLabel feetLabel;
JLabel bedLabel;
JButton reset; // Reset button
JButton next; // Next button
JButton add; // Add button
JButton delete; // Delete button
JButton clear; // Clear button
JButton find; // Find button
ActionHandler action; // Declare listener
// Declare/Instantiate/Initialize display frame
final JFrame displayFrame = new JFrame();
displayFrame.setTitle("Real Estate Program");
displayFrame.setSize(350,443);
displayFrame.addWindowListener(new WindowAdapter() // handle window
// closing
{
public void windowClosing(WindowEvent event)
{
House house;
displayFrame.dispose(); // Close window
try
{
// Store info from list into house file
HouseFile.rewrite();


int length = ml.size();
for (int counter = 0; counter < length; counter++)
{
	house=ml.get(counter);
HouseFile.putToFile(house);
}
HouseFile.close();
}
catch (IOException fileCloseProblem)
{
System.out.println("Exception raised concerning the house info file "
+ "upon program termination");
}
System.exit(0); // Quit the program
}
});
// Instantiate content pane and information panel
Container contentPane = displayFrame.getContentPane();
JPanel infoPanel = new JPanel();
// Instantiate/initialize labels, and text fields
statusLabel = new JLabel("", JLabel.CENTER);
statusLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
statusLabel.setBounds(10, 11, 314, 26);
statusLabel.setForeground(new Color(64, 224, 208));
statusLabel.setBorder(new LineBorder(Color.red));
blankLabel = new JLabel("");
blankLabel.setBounds(167, 1, 167, 36);
lotLabel = new JLabel("Lot Number: ", JLabel.RIGHT);
lotLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
lotLabel.setBounds(0, 44, 167, 29);
lotLabel.setForeground(new Color(64, 224, 208));
lotText = new JTextField("", 15);
lotText.setBounds(167, 44, 157, 29);
firstLabel = new JLabel("First Name: ", JLabel.RIGHT);
firstLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
firstLabel.setBounds(0, 80, 167, 29);
firstLabel.setForeground(new Color(64, 224, 208));
firstText = new JTextField("", 15);
firstText.setBounds(167, 80, 157, 29);
lastLabel = new JLabel("Last Name: ", JLabel.RIGHT);
lastLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
lastLabel.setBounds(0, 116, 167, 29);
lastLabel.setForeground(new Color(64, 224, 208));
lastText = new JTextField("", 15);
lastText.setBounds(167, 116, 157, 29);
priceLabel = new JLabel("Price: ", JLabel.RIGHT);
priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
priceLabel.setBounds(0, 152, 167, 29);
priceLabel.setForeground(new Color(64, 224, 208));
priceText = new JTextField("", 15);
priceText.setBounds(167, 156, 157, 25);
feetLabel = new JLabel("Square Feet: ", JLabel.RIGHT);
feetLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
feetLabel.setBounds(0, 188, 167, 29);
feetLabel.setForeground(new Color(64, 224, 208));
feetText = new JTextField("", 15);
feetText.setBounds(167, 188, 157, 29);
bedLabel = new JLabel("Number of Bedrooms: ", JLabel.RIGHT);
bedLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
bedLabel.setBounds(0, 228, 167, 25);
bedLabel.setForeground(new Color(64, 224, 208));
bedText = new JTextField("", 15);
bedText.setBounds(167, 224, 157, 29);
// Instantiate/register buttons
reset = new JButton("Reset");
reset.setBounds(10, 264, 144, 36);
next = new JButton("Next");
next.setBounds(177, 264, 147, 36);
add = new JButton("Add");
add.setBounds(10, 311, 144, 36);
delete = new JButton("Delete");
delete.setBounds(176, 311, 148, 36);
clear = new JButton("Clear");
clear.setBounds(10, 358, 144, 36);
find = new JButton("Find");
find.setBounds(177, 358, 147, 36);
// Instantiate/register button listeners
action = new ActionHandler();
reset.addActionListener(action);
next.addActionListener(action);
add.addActionListener(action);
delete.addActionListener(action);
clear.addActionListener(action);
find.addActionListener(action);
// Load info from house file into list
House h1;
HouseFile.reset();
while (HouseFile.moreHouses())
{
h1 = HouseFile.getNextHouse();
int status=insert(h1,ml);
}
// If possible insert info about first house into text fields

if (ml.size() != 0)
{
h1=ml.getFirst();	
showHouse(h1);
}
infoPanel.setLayout(null);
// Update status
statusLabel.setText(ml.size() + " houses on list ");
infoPanel.add(statusLabel);
infoPanel.add(blankLabel);
infoPanel.add(lotLabel);
infoPanel.add(lotText);
infoPanel.add(firstLabel);
infoPanel.add(firstText);
infoPanel.add(lastLabel);
infoPanel.add(lastText);
infoPanel.add(priceLabel);
infoPanel.add(priceText);
infoPanel.add(feetLabel);
infoPanel.add(feetText);
infoPanel.add(bedLabel);
infoPanel.add(bedText);
infoPanel.add(reset);
infoPanel.add(next);
infoPanel.add(add);
infoPanel.add(delete);
infoPanel.add(clear);
infoPanel.add(find);
// Set up and show the frame
contentPane.add(infoPanel);
displayFrame.show();
}
}
