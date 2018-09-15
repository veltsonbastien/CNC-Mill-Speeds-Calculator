import java.io.*;
import java.util.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.ButtonGroup; 
import java.awt.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.*;   
import java.awt.event.ActionListener; //for the action listener
import java.awt.event.ActionEvent; //both for the action events

public class dataHandler {
    private static double toolDiameter = 0.0;
    private static int numberFlutes = 0;
    private static double toolFeedAmount = 0.0;
    private static boolean checkReaming = false;
    private static boolean checkCounterboring = false;
    private static boolean checkCountersinking = false;
    private static int chosenValue = 0;
    private static double chosenDiameter = 0.0;
    private static int chosenFluteNumber = 2;
    private static int chosenMillCheck;
    private static boolean reamingSelected = false;
    private static boolean counterboringSelected = false;
    private static boolean countersinkingSelected = false;
    private static boolean frameChanged = false;
    private static boolean materialChange = false;
    private static  boolean diameterChange = false;
    private static boolean fluteChange = false;
    private static boolean millChange = false;
    private static boolean twoFluteButton = false;
    private static boolean fourFluteButton = false;
    private static String millCheckString = " ";

    public static void main (String args[])
    {

        ArrayList<MillSpeeds> cuttingSpeeds = new ArrayList<MillSpeeds>();
        MillSpeeds m1 = new MillSpeeds("Magnesium", 300, 0.005, 0.004, 0.005);
        m1.setMaterial("Magnesium");
        m1.setCuttingSpeed(300);
        m1.setFaceMillFeed(0.005);
        m1.setSideMillFeed(0.004);
        m1.setEndMillFeed(0.005);

        MillSpeeds m2 = new MillSpeeds("Aluminium", 250, 0.005, 0.004, 0.005);
        m2.setMaterial("Aluminium");
        m2.setCuttingSpeed(250);
        m2.setFaceMillFeed(0.005);
        m2.setSideMillFeed(0.004);
        m2.setEndMillFeed(0.005);

        MillSpeeds m3 = new MillSpeeds("Copper", 100, 0.004, 0.004, 0.004);
        m3.setMaterial("Copper");
        m3.setCuttingSpeed(100);
        m3.setFaceMillFeed(0.004);
        m3.setSideMillFeed(0.004);
        m3.setEndMillFeed(0.004);

        MillSpeeds m4 = new MillSpeeds("Mild Steel", 90, 0.004, 0.002, 0.002);
        m4.setMaterial("Mild Steel");
        m4.setCuttingSpeed(90);
        m4.setFaceMillFeed(0.004);
        m4.setSideMillFeed(0.002);
        m4.setEndMillFeed(0.002);

        MillSpeeds m5 = new MillSpeeds("Tool Steel", 50, 0.004, 0.002, 0.002);
        m5.setMaterial("Tool Steel");
        m5.setCuttingSpeed(50);
        m5.setFaceMillFeed(0.004);
        m5.setSideMillFeed(0.002);
        m5.setEndMillFeed(0.002);

        MillSpeeds m6 = new MillSpeeds("Cast Steel", 80, 0.004, 0.004, 0.004); //check this 
        m6.setMaterial("Cast Steel");
        m6.setCuttingSpeed(80);
        m6.setFaceMillFeed(0.004);
        m6.setSideMillFeed(0.004);
        m6.setEndMillFeed(0.004);

        MillSpeeds m7 = new MillSpeeds("Stainless Steel", 60, 0.004, 0.002, 0.002);
        m7.setMaterial("Stainless Steel");
        m7.setCuttingSpeed(60);
        m7.setFaceMillFeed(0.004);
        m7.setSideMillFeed(0.002);
        m7.setEndMillFeed(0.002);

        MillSpeeds m8 = new MillSpeeds("Titanium", 50, 0.004, 0.002, 0.002);
        m8.setMaterial("Titanium");
        m8.setCuttingSpeed(50);
        m8.setFaceMillFeed(0.004);
        m8.setSideMillFeed(0.002);
        m8.setEndMillFeed(0.002);

        cuttingSpeeds.add(m1);
        cuttingSpeeds.add(m2);
        cuttingSpeeds.add(m3);
        cuttingSpeeds.add(m4);
        cuttingSpeeds.add(m5);
        cuttingSpeeds.add(m6);
        cuttingSpeeds.add(m7);
        cuttingSpeeds.add(m8);

        final int displayWidth = 550;
        final int displayHeight = 600;

        final JPanel t1;
        final JPanel t2;
        final JPanel t3;
        final JPanel t4;
        final JPanel t5;
        final JPanel t6;
        final JPanel spacer;

        final JLabel title = new JLabel ("CNC Operator Virtual Assistant");
        ArrayList<chosenData> selectedData = new ArrayList<chosenData>();
        chosenData cd = new chosenData();
        JFrame display = new JFrame("CNC Operator Virtual Assistant");
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.setSize(displayWidth,displayHeight);
        display.setVisible(true);
        display.setResizable(false);
        display.setLayout(new FlowLayout(FlowLayout.LEFT, 20,40));

        display.getContentPane().setBackground(new java.awt.Color(82,179,217));

        title.setFont(new Font("Serif", Font.PLAIN, 28));
        display.add(title);

        //materials
        String[] choices = {cuttingSpeeds.get(0).getMaterial(),  cuttingSpeeds.get(1).getMaterial() , 
                cuttingSpeeds.get(2).getMaterial() , cuttingSpeeds.get(3).getMaterial(), 
                cuttingSpeeds.get(4).getMaterial(), cuttingSpeeds.get(5).getMaterial(), 
                cuttingSpeeds.get(6).getMaterial(), cuttingSpeeds.get(7).getMaterial()};

        final JComboBox<String> materialSelect = new JComboBox<String>(choices);
        t1=new JPanel();
        TitledBorder titled = new TitledBorder("Select Material");

        titled.setTitleFont(new Font("Serif", Font.PLAIN, 18));
        t1.setBorder(titled);

        materialSelect.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    int valueIndex = 0;
                    JComboBox comboBox = (JComboBox) event.getSource();
                    Object selected = comboBox.getSelectedItem();
                    System.out.println("Selected Item  = " + selected);
                    cd.setValue(comboBox.getSelectedIndex());
                    String command = event.getActionCommand();
                    System.out.println("Action Command = " + command);

                    if(command.equals("comboBoxChanged"))
                    {
                        materialChange = true;
                    }

                }
            });

        t1.add(materialSelect);
        t1.setOpaque(false);
        t1.setPreferredSize(new Dimension(245, 75));
        display.add(t1);

        //diameters
        String[] diameters = {" 0.25 " ," 0.5 "," 0.75 "," 1.0 "};
        final JComboBox<String> diameterSelect = new JComboBox<String>(diameters);
        t2=new JPanel();
        TitledBorder titled2 = new TitledBorder("Tool Diamter In Inches: ");
        titled2.setTitleFont(new Font("Serif", Font.PLAIN, 18));
        t2.setBorder(titled2);
        t2.setOpaque(false);

        diameterSelect.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    JComboBox comboBox = (JComboBox) event.getSource();
                    Object selected = comboBox.getSelectedItem();
                    System.out.println("Selected Item  = " + selected);
                    String command = event.getActionCommand();
                    System.out.println("Action Command = " + command);
                    cd.setDiameter(Double.parseDouble(comboBox.getSelectedItem().toString()));

                    if(command.equals("comboBoxChanged"))
                    {
                        diameterChange = true;
                    }

                }
            });

        t2.add(diameterSelect);
        diameterSelect.setEditable(true);
        t2.setPreferredSize(new Dimension(245, 75));
        display.add(t2);
        //flutes
        JRadioButton twoFlute = new JRadioButton("2");
        JRadioButton fourFlute = new JRadioButton("4");
        final ButtonGroup fluteButtonGroup = new ButtonGroup();
        t3=new JPanel();
        TitledBorder titled3 = new TitledBorder("Number of Flutes: ");

        titled3.setTitleFont(new Font("Serif", Font.PLAIN, 18));
        t3.setBorder(titled3);
        t3.setOpaque(false);
        twoFlute.setOpaque(false);
        fourFlute.setOpaque(false);

        ActionListener fluteButtonActionListener = new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    AbstractButton button = (AbstractButton) actionEvent.getSource();     
                    System.out.println("Selected: " + button.getText());
                    String command = actionEvent.getActionCommand();
                    System.out.println(command);
                    if(command.equals("2") || command.equals("4"))
                    {
                        fluteChange = true;
                        System.out.println("Roger dodger on that dodger roger sauce boss! Flute numbers are gooooooooooood!");
                    }

                    cd.setFluteNumber(Integer.parseInt(button.getText()));
                }
            };

        fluteButtonGroup.add(twoFlute);
        fluteButtonGroup.add(fourFlute);
        t3.add(twoFlute);
        t3.add(fourFlute);
        twoFlute.addActionListener(fluteButtonActionListener);
        fourFlute.addActionListener(fluteButtonActionListener);
        t3.setPreferredSize(new Dimension(245, 75));
        // t3.setLayout(new GridLayout(0,1));
        display.add(t3);
        //mills
        final JRadioButton faceMillButton = new JRadioButton("Face Mill", false);
        final JRadioButton sideMillButton = new JRadioButton("Side Mill", false);
        final JRadioButton endMillButton = new JRadioButton("End Mill", false);
        final ButtonGroup millButtonGroup = new ButtonGroup();
        t4=new JPanel();
        TitledBorder titled4 = new TitledBorder("Select Mill: ");
        titled4.setTitleFont(new Font("Serif", Font.PLAIN, 18));
        t4.setBorder(titled4);
        t4.setOpaque(false);
        faceMillButton.setOpaque(true);
        sideMillButton.setOpaque(true);
        endMillButton.setOpaque(true);

        ActionListener millButtonActionListener = new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    AbstractButton button = (AbstractButton) actionEvent.getSource();     
                    System.out.println("Selected: " + button.getText());

                    if(button.getText().equals("Face Mill") ){ cd.setMillCheck(1); }
                    else if(button.getText().equals("Side Mill")) { cd.setMillCheck(2);  }
                    else if(button.getText().equals("End Mill")) { cd.setMillCheck(3); }
                    else 
                    {
                        cd.setMillCheck(1);  
                    }

                    String command = actionEvent.getActionCommand();
                    System.out.println(command);
                    if(command.equals("Face Mill") || command.equals("Side Mill") || command.equals("End Mill"))
                    {
                        millChange = true;
                        System.out.println("aaaaaaaand here we goooo mill check is lookin a o k on the k o a if ya know what we meaaaaaaaaaaaaan!");
                    }

                }
            };

        millButtonGroup.add(faceMillButton);
        millButtonGroup.add(sideMillButton);
        millButtonGroup.add(endMillButton);
        t4.add(faceMillButton);
        t4.add(sideMillButton);
        t4.add(endMillButton);
        t4.setPreferredSize(new Dimension(245, 75));
        // t3.setLayout(new GridLayout(0,1));
        faceMillButton.addActionListener(millButtonActionListener);
        sideMillButton.addActionListener(millButtonActionListener);
        endMillButton.addActionListener(millButtonActionListener);
        display.add(t4);
        //special options
        final JRadioButton reamingButton = new JRadioButton("Reaming", false);
        final JRadioButton counterboringButton = new JRadioButton("Counterboring", false);
        final JRadioButton countersinkingButton = new JRadioButton("Countersinking", false);
        final ButtonGroup specialButtonGroup = new ButtonGroup();
        t5=new JPanel();
        TitledBorder titled5 = new TitledBorder("Select A Special Option (If Applicable): ");
        titled5.setTitleFont(new Font("Serif", Font.PLAIN, 18));
        t5.setBorder(titled5);
        t5.setOpaque(false);
        reamingButton.setOpaque(true);
        counterboringButton.setOpaque(true);
        countersinkingButton.setOpaque(true);

        ActionListener soButtonActionListener = new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    AbstractButton button = (AbstractButton) actionEvent.getSource();     
                    System.out.println("Selected: " + button.getText());

                    if(button.getText().equals("Reaming")){
                        cd.setReaming(true);
                    }
                    else {
                        cd.setReaming(false);
                    }

                    if(button.getText().equals("Counterboring")){
                        cd.setCounterboring(true);
                    }
                    else {
                        cd.setCounterboring(false);
                    }

                    if(button.getText().equals("Countersinking")){
                        cd.setCountersinking(true);
                    }
                    else {
                        cd.setCountersinking(false);
                    }

                }
            };

        specialButtonGroup.add(reamingButton);
        specialButtonGroup.add(counterboringButton);
        specialButtonGroup.add(countersinkingButton);
        t5.add(reamingButton);
        t5.add(counterboringButton);
        t5.add(countersinkingButton);
        t5.setPreferredSize(new Dimension(510, 75));
        // t3.setLayout(new GridLayout(0,1));
        reamingButton.addActionListener(soButtonActionListener);
        counterboringButton.addActionListener(soButtonActionListener);
        countersinkingButton.addActionListener(soButtonActionListener);
        display.add(t5);
        spacer = new JPanel();
        spacer.setPreferredSize(new Dimension(190,0));
        display.add(spacer);
        //finished button
        final JButton finishedButton = new JButton("Finished");
        t6 = new JPanel();
        t6.setOpaque(false);
        t6.add(finishedButton);

        finishedButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    ArrayList<String> missingItems = new ArrayList();
                    ArrayList<String> specialOptions = new ArrayList(); 

                    missingItems.removeAll(missingItems);
                    specialOptions.removeAll(specialOptions);

                    JButton button = (JButton) event.getSource();
                    String command = event.getActionCommand();
                    System.out.println("Action Command = " + command);

                    selectedData.add(cd);

                    cuttingSpeeds.get(cd.getValue()).showAll(cd.getDiameter(), cd.getFluteNumber(), cd.getMillCheck(), cd.getReaming(), cd.getCounterboring(), cd.getCountersinking());

                    if(materialChange && diameterChange && fluteChange && millChange)
                    {
                        frameChanged = true;
                    }

                    if(frameChanged){
                        if(cd.getMillCheck() == 1){ millCheckString = "Front Mill"; }
                        else if(cd.getMillCheck() == 2) { millCheckString = "Side Mill";}
                        else if(cd.getMillCheck() == 3) { millCheckString = "End Mill";}
                        else { millCheckString = ""; }

                        if(cd.getReaming() == true) {specialOptions.add("Reaming");}
                        else if(cd.getCounterboring() == true) { specialOptions.add("Counterboring"); }
                        else if(cd.getCountersinking() == true) { specialOptions.add("Countersinking");}
                        else { specialOptions.add("None"); }

                        final JLabel text1 = new JLabel ("Calculations Based On Data");
                        text1.setFont(new Font("Serif", Font.BOLD, 18));
                        final JLabel text2 = new JLabel ("Material: "+ cuttingSpeeds.get(cd.getValue()).getMaterial());
                        text2.setFont(new Font("Serif", Font.PLAIN, 14));
                        final JLabel text3 = new JLabel ("Diameter: "+ cd.getDiameter() + " inches");
                        text3.setFont(new Font("Serif", Font.PLAIN, 14));
                        final JLabel text4 = new JLabel ("Flute Number: "+ cd.getFluteNumber());
                        text4.setFont(new Font("Serif", Font.PLAIN, 14));
                        final JLabel text5 = new JLabel ("Using: "+ millCheckString);
                        text5.setFont(new Font("Serif", Font.PLAIN, 14));
                        final JLabel text6 = new JLabel ("Special Options: "+ printList(specialOptions));
                        text6.setFont(new Font("Serif", Font.PLAIN, 14));
                        final JLabel text7 = new JLabel ("Spindle Speed: "+ cuttingSpeeds.get(cd.getValue()).calculateSpindleSpeed(cd.getDiameter(), 
                                    cd.getReaming(),cd.getCounterboring(),
                                    cd.getCountersinking()) + " RPM" );
                        text7.setFont(new Font("Serif", Font.PLAIN, 14));
                        final JLabel text8 = new JLabel ("Feed Rate: "+ cuttingSpeeds.get(cd.getValue()).calculateFeedRates(cd.getFluteNumber(), 
                                    cd.getDiameter(), cuttingSpeeds.get(cd.getValue()).getCuttingSpeed(), cd.getMillCheck()) + " Inches/Min");
                        text8.setFont(new Font("Serif", Font.PLAIN, 14));
                        final JLabel text9 = new JLabel ("Plunge Feed Rate: "+ cuttingSpeeds.get(cd.getValue()).calculatePlungeFeedRates(cd.getFluteNumber(), 
                                    cd.getDiameter(), cuttingSpeeds.get(cd.getValue()).getCuttingSpeed(), cd.getMillCheck())+ " Inches/Min");
                        text9.setFont(new Font("Serif", Font.PLAIN, 14));

                        //  JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20,40));
                        JPanel panel = new JPanel(new GridLayout(0,1, 0, 20));
                        panel.add(text1);
                        panel.add(text2);
                        panel.add(text3);
                        panel.add(text4);
                        panel.add(text5);
                        panel.add(text6);
                        panel.add(text7);
                        panel.add(text8);
                        panel.add(text9);

                        JOptionPane.showMessageDialog(display, panel, "Results", JOptionPane.PLAIN_MESSAGE);
                    } //end of if frame changed

                    else {

                        if(!materialChange) { missingItems.add("- Material not Selected");  }
                        if(!diameterChange) {missingItems.add("- Diameter not Selected"); }
                        if(!fluteChange) { missingItems.add("- Flute not Selected"); }
                        if(!millChange) { missingItems.add("- Mill not Selected "); }

                        System.out.println(listToString(missingItems));

                        JOptionPane.showMessageDialog(display, "Error: Not All Values Selected" + "\n" + listToString(missingItems), "Incomplete Data", JOptionPane.WARNING_MESSAGE);
                    }

                }
            }); //END OF FINISHED BUTTON ACTION LISTENER

        display.add(t6);
        
        
        display.setVisible(true);
          
          
    }    ///////////// END OF VOID MAIN ///////////////////////
    public static String listToString(ArrayList<String> missingItems) {
        String result = "";
        for (int i = 0; i < missingItems.size(); i++) {
            result += missingItems.get(i) + "\n";
        }
        return result;
    }

    public static String printList(ArrayList<String> specialOptions) {

        String result = "";

        for(int i = 0; i<specialOptions.size(); i++) 
        {
            if(i==0)
                result += specialOptions.get(i);
            else
                result += " , "+specialOptions.get(i);

        }
        return result;
    }

}

class MillSpeeds{

    String material = "Default";
    int cuttingSpeed = 0;
    double faceMillFeed = 0.0;
    double sideMillFeed = 0.0;
    double endMillFeed = 0.0;

    public void setMaterial(String mat) {  this.material = mat;  }

    public void setCuttingSpeed(int cS)  { this.cuttingSpeed = cS; }

    public void setFaceMillFeed(double fMF)  { this.faceMillFeed = fMF;}

    public void setSideMillFeed(double sMF)  {  this.sideMillFeed = sMF; }

    public void setEndMillFeed(double eMF)  { this.endMillFeed = eMF; }

    public String getMaterial() { return material; }

    public int getCuttingSpeed(){  return cuttingSpeed; }

    public double getFaceMillFeed() { return faceMillFeed; }

    public double getSideMillFeed() {  return sideMillFeed; }

    public double getEndMillFeed() { return endMillFeed; }

    public double calculateSpindleSpeed(double diameter, boolean reaming, boolean counterboring, boolean countersinking)
    {

        double n = 0.0;
        double adjustedSpeed = 0.0;

        n = Math.floor(((this.cuttingSpeed)*12)/(3.14*diameter));

        if(reaming){ 
            adjustedSpeed = Math.floor(n * 0.585);
        }
        else if(counterboring)
        {
            adjustedSpeed = Math.floor(n * 0.25);
        }
        else if(countersinking)
        {
            adjustedSpeed = Math.floor(n*0.25);
        }
        else {
            adjustedSpeed = n;
        }

        System.out.println(this.material + " " + "Spindle Speed for a " + diameter + " inch diameter: "+ adjustedSpeed + " RPM");
        return adjustedSpeed;

    }

    public double calculateFeedRates(int fluteNumber, double diameter, double cutSpeed, int millCheck)
    {

        double toolFeed = this.toolFeedToUse(millCheck);

        double feedRate = (((this.cuttingSpeed)*12)/(3.14*diameter)) * fluteNumber * toolFeed;
        System.out.println(this.material + " " + "Feed Rate Speed for "+ fluteNumber + " flute, with a " + diameter + " diameter, and a " + toolFeed+ " Tool Feed: "  +  feedRate + " inches/min");

        return Math.floor(feedRate);

    }

    public double calculatePlungeFeedRates(int fluteNumber, double diameter, double cutSpeed, int millCheck)
    {

        double toolFeed = this.toolFeedToUse(millCheck);

        double plungeFeedRate = ((((this.cuttingSpeed)*12)/(3.14*diameter)) * fluteNumber * toolFeed)/2.0;

        System.out.println(this.material + " " + "Plunge Feed Rate Speed for "+ fluteNumber + " flute, with a " + diameter + " diameter, and a " + toolFeed + " Tool Feed: " + plungeFeedRate + " RPM");

        return Math.floor(plungeFeedRate); 

    }

    public boolean checkSpecialOperations(boolean reaming, boolean counterboring, boolean countersinking)
    {

        boolean temp = false;

        if(reaming || counterboring || countersinking)
        {
            temp = true;
        }

        return temp;
    } 

    public double toolFeedToUse(int millCheck)
    {
        double number = 0.0;

        if(millCheck == 1) { number = this.getFaceMillFeed(); }
        else if(millCheck == 2) { number = this.getSideMillFeed(); }
        else if(millCheck == 3) { number = this.getEndMillFeed(); }
        else { number = 0.1; }

        return number;

    }

    public void showAll(double diameter, int fluteNumber, int millCheck, boolean reaming, boolean counterboring, boolean countersinking)
    {

        this.showStats(this.material, this.cuttingSpeed);
        this.calculateSpindleSpeed(diameter, reaming, counterboring, countersinking);
        this.calculateFeedRates(fluteNumber, diameter, this.calculateSpindleSpeed(diameter, reaming, counterboring, countersinking), millCheck);
        this.calculatePlungeFeedRates(fluteNumber, diameter, this.calculateSpindleSpeed(diameter, reaming, counterboring, countersinking), millCheck);

    }

    public MillSpeeds()
    {

        material = "Default";
        cuttingSpeed = 0;
        faceMillFeed = 0.0;
        sideMillFeed = 0.0;
        endMillFeed = 0.0;

    }

    public MillSpeeds(String material, int cuttingSpeed, double faceMillFeed, double sideMillFeed, double endMillFeed)
    {

        this.material = material;
        this.cuttingSpeed = cuttingSpeed;
        this.faceMillFeed = faceMillFeed;
        this.sideMillFeed = sideMillFeed;
        this.endMillFeed = endMillFeed;

    }

    public void showStats(String material, int cuttingSpeed)
    {
        System.out.println ("STATS:" + "\n" + " Material: "+ material + "\n" + " Cutting Speed: "+ cuttingSpeed + "\n" ) ;    
    }

}
//end of millspeeds

class chosenData {

    int value = 0;
    double diameter = 0.0;
    int fluteNumber = 0;
    int millCheck = 1;
    boolean reaming = false;
    boolean counterboring = false;
    boolean countersinking = false;

    public chosenData()
    {
        System.out.println("This is here for testing purposes.");
    }

    public chosenData(int value, double diameter, int fluteNumber, int millCheck, boolean reaming, boolean counterboring, boolean countersinking  )
    {

        System.out.println("This is here for testing purposes."); 

    }

    public void setValue(int sV) { 
        this.value = sV;
    }

    public void setDiameter(double sD) { this.diameter = sD; }

    public void setFluteNumber(int sFN) { this.fluteNumber = sFN; }

    public void setMillCheck(int sMC) { this.millCheck = sMC; }

    public void setReaming(boolean sR) { this.reaming = sR; }

    public void setCounterboring(boolean sCB) { this.counterboring = sCB; }

    public void setCountersinking(boolean sCS){ this.countersinking = sCS; }

    public int getValue(){ return value; }

    public double getDiameter(){ return diameter; }

    public int getFluteNumber() { return fluteNumber; }

    public int getMillCheck(){ return millCheck; }

    public boolean getReaming(){ return reaming; }

    public boolean getCounterboring(){ return counterboring; }

    public boolean getCountersinking(){ return countersinking; }

}
