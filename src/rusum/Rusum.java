/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rusum;

// Java Program to create a text editor using java
import java.awt.*;
import static java.awt.SystemColor.window;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import javax.swing.plaf.metal.*;
import javax.swing.text.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.ArrayList;
import java.util.List;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.swing.event.UndoableEditEvent;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;


class Rusum extends JFrame implements ActionListener {
	// Text component
	public static  JTextArea t;
        
        public static  JTextField tt;
        
        String temp_data="";

	// Frame
	public static JFrame f;

	// Constructor
	Rusum()
       
	{
            
         
		// Create a frame
		f = new JFrame("Backbone Configuretion script writing system ");
                Image im = Toolkit.getDefaultToolkit().getImage(getClass().getResource("n2.png"));
 
    f.setIconImage(im);
    
                
                
               

		try {
			// Set metal look and feel
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

			// Set theme to ocean
			MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		}
		catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
		}
                tt = new JTextField( 7);
		// Text component
		t = new JTextArea();
              
                /////////////////////////
                
               //instantiate frame
    //instantiate textArea
    final UndoManager undo = new UndoManager(); //instantiate an UndoManager
    
    Document doc = t.getDocument();  //instantiate a Document class of the txtArea

    doc.addUndoableEditListener((UndoableEditEvent evt) -> {
        undo.addEdit(evt.getEdit());
                });

    t.getActionMap().put("Undo", new AbstractAction("Undo") {
      @Override
      public void actionPerformed(ActionEvent evt) {
        try {
          if (undo.canUndo()) {
            undo.undo();
            
          }
        } catch (CannotUndoException e) {
        }
      }
    });

    t.getInputMap().put(KeyStroke.getKeyStroke("control Z"), "Undo");

    
                ///////////////////////////////
                
                
             
   
    // textArea.setBackground(color);
                  
 //Set JTextArea background color to color that you choose
               t.setBackground(Color.BLACK);
              
               t. setForeground(Color.white);
               t.setCaretColor(Color.WHITE);
           
               t. setFont(new Font("Arial", Font.PLAIN, 14));
                
                
            
             
		// Create a menubar
		JMenuBar mb = new JMenuBar();


		// Create amenu for menu
		JMenu m1 = new JMenu("File");

		// Create menu items
		JMenuItem mi1 = new JMenuItem("New");
		JMenuItem mi2 = new JMenuItem("Open");
		JMenuItem mi3 = new JMenuItem("Save");
		JMenuItem mi9 = new JMenuItem("Print");

		// Add action listener
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		mi9.addActionListener(this);
                  m1.setBackground(Color.white);
		m1.add(mi1);
		m1.add(mi2);
		m1.add(mi3);
		m1.add(mi9);
               

		// Create amenu for menu
		JMenu m2 = new JMenu("Edit");

		// Create menu items
		JMenuItem mi4 = new JMenuItem("cut");
		JMenuItem mi5 = new JMenuItem("copy");
		JMenuItem mi6 = new JMenuItem("paste");

		// Add action listener
		mi4.addActionListener(this);
		mi5.addActionListener(this);
		mi6.addActionListener(this);

                m2.setBackground(Color.white);
		m2.add(mi4);
		m2.add(mi5);
		m2.add(mi6);
                

		JMenuItem mc = new JMenuItem("New");
                
                JMenuItem mcs = new JMenuItem("show");
                JMenuItem mca = new JMenuItem("Area");
                JMenuItem mcc = new JMenuItem("clear");
                JMenuItem mc2 = new JMenuItem("Resum");
                JMenuItem mc3 = new JMenuItem("Suspention");
                JMenuItem mc4 = new JMenuItem("BackUp-Resum");
                JMenuItem mc5 = new JMenuItem("BackUp-Suspen");
                 JMenuItem mc6 = new JMenuItem("VPN-Resum");
                 JMenuItem mc7 = new JMenuItem("VPN-Suspen");
                JMenuItem mc8 = new JMenuItem("Termination");
                 JMenuItem mc9 = new JMenuItem("double ip");
                 JMenuItem mc10 = new JMenuItem("Error");
                
                 mb.setBackground(Color.white);
                 mc.setBackground(Color.white);
                 mcs.setBackground(Color.white);
                 mca.setBackground(Color.white);
                 mcc.setBackground(Color.white);
                 mc2.setBackground(Color.white);
                 mc3.setBackground(Color.white);
                 mc4.setBackground(Color.white);
                 mc5.setBackground(Color.white);
                 mc6.setBackground(Color.white);
                 mc7.setBackground(Color.white);
                 mc8.setBackground(Color.white);
                 mc9.setBackground(Color.white);
                 mc10.setBackground(Color.white);
                 
		mc.addActionListener(this);
                mcs.addActionListener(this);
                mca.addActionListener(this);
                mcc.addActionListener(this);
                mc2.addActionListener(this);
                mc3.addActionListener(this);
                mc4.addActionListener(this);
                 mc5.addActionListener(this);
                 mc6.addActionListener(this);
                 mc7.addActionListener(this);
                  mc8.addActionListener(this);
                  mc9.addActionListener(this);
                  mc10.addActionListener(this);
		mb.add(m1);
		mb.add(m2);
		mb.add(mc);
                  mb.add(tt);
                  mb.add(mcs);
                  mb.add(mca);
                  mb.add(mcc);
                mb.add(mc2);
                mb.add(mc3);
                 mb.add(mc4);
                 mb.add(mc5);
               mb.add(mc6);
               mb.add(mc7);
                mb.add(mc8);
                mb.add(mc9);
               mb.add(mc10);
               
                ///////////////////////
                  //JTextField simpleinput=new JTextField();
        
                
                ///////////////////////
                JScrollPane scrolltxt = new JScrollPane(t);
                
               
        

		f.setJMenuBar(mb);
                
		f.add(scrolltxt);
               
		f.setSize(1200, 865);
		f.show();
	}

	// If a button is pressed
        @Override
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();

            switch (s) {
                case "cut":
                    t.cut();
                    break;
                case "copy":
                    t.copy();
                    break;
                case "paste":
                    t.paste();
                    break;
                case "Save":
                    {
                        // Create an object of JFileChooser class
                        JFileChooser j = new JFileChooser("f:");
                        // Invoke the showsSaveDialog function to show the save dialog
                        int r = j.showSaveDialog(null);
                        if (r == JFileChooser.APPROVE_OPTION) {
                            
                            // Set the label to the path of the selected directory
                            File fi = new File(j.getSelectedFile().getAbsolutePath());
                            
                            try {
                                // Create a file writer
                                FileWriter wr = new FileWriter(fi, false);
                                
                                // Write
                                try ( // Create buffered writer to write
                                        BufferedWriter w = new BufferedWriter(wr)) {
                                    // Write
                                    w.write(t.getText());
                                    
                                    w.flush();
                                }
                            }
                            catch (IOException evt) {
                                JOptionPane.showMessageDialog(f, evt.getMessage());
                            }
                        }
                        // If the user cancelled the operation
                        else
                            JOptionPane.showMessageDialog(f, "the user cancelled the operation");
                        break;
                    }
                case "Print":
                    try {
                        // print the file
                        t.print();
                        
                    }
                    catch (PrinterException evt) {
                        JOptionPane.showMessageDialog(f, evt.getMessage());
                    }
                    break;
                case "Open":
                    {
                        // Create an object of JFileChooser class
                        JFileChooser j = new JFileChooser("f:");
                        // Invoke the showsOpenDialog function to show the save dialog
                        int r = j.showOpenDialog(null);
                        // If the user selects a file
                        if (r == JFileChooser.APPROVE_OPTION) {
                            // Set the label to the path of the selected directory
                            File fi = new File(j.getSelectedFile().getAbsolutePath());
                            
                            try {
                                // String
                                String s2 = "", sl = "";
                                String qq="";
                                ArrayList<String> al = new ArrayList<>();
                                
                                // File reader
                                FileReader fr = new FileReader(fi);
                                
                                // Buffered reader
                                BufferedReader br = new BufferedReader(fr);
                                
                                // Initialize sl
                                sl = br.readLine();
                                sl = sl.trim();
                                al.add(sl);
                                
                                // Take the input from the file
                                while ((s2 = br.readLine()) != null) {
                                    sl = sl + "\n" + s2;
                                    sl = s2.trim();
                                    al.add(sl);
                                    
                                }
                                
                                // Set the text
                                // For loop for iterating over the List
                                for (int i = 0; i < al.size(); i++) {
                                    
                                    // Print all elements of List
                                    //System.out.println(al.get(i));
                                    //data clear
                                    
                                    //out put
                                    qq = qq + "\n" + al.get(i);
                                }
                                
                                
                                t.setText(qq);
                                //System.out.println(al);
                                
                                
                                
                                
                                
                                
                                
                                
                            }
                            catch (IOException evt) {
                                JOptionPane.showMessageDialog(f, evt.getMessage());
                            }
                        }
                        // If the user cancelled the operation
                        else
                            JOptionPane.showMessageDialog(f, "the user cancelled the operation");
                        break;
                    }
                case "New":
                    t.setText("");
                    break;
                case "close":
                    f.setVisible(false);
                    break;
                case "clear":
                    {
  
               
                        ArrayList<String> alr = new ArrayList<>();
                        String input =t.getText();
                        input = input.trim();
                        String qq="";
                        
                        // For loop for iterating over the List
                        String[] lines = input.split("\\r?\\n");
                        for (String line : lines) {
                           // System.out.println(line);
                           
                            if(find("^\\s*ip-host description.*?\\d+(M|K)[^ ]*?$",line)){
                                alr.add(line);
                            
                            
                           
                            }else{
                           alr.add( realfind("ip-host description.*?\\d+(M|K)[^ ]*?$",line));
                            }
                            
                        }
                        
                         alr.removeAll(Collections.singletonList(""));
                        for (int i = 0; i < alr.size(); i++) {
                            
                            qq = qq + "\n" + alr.get(i).trim();
                        } 
                      qq=qq.trim();
                      
                
                        t.setText(qq);
                   
 
      
                        break;
                    }
                case "Area":
                    {
                     
                        long startTime = System.nanoTime();
                       
                        ArrayList<String> alr = new ArrayList<>();
                        String input =t.getText();
                        input = input.trim();
                        
                        String qq="";
                        String qq2="";
                        // For loop for iterating over the List
                        String[] lines = input.split("\\r?\\n");
                        for (String line : lines) {
                           // System.out.println(line);
                            if(find("^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$",line)||find("^\\d{9,20}$",line)){
              
                                alr.add(line);
                            }
                            
                            
                        }
                        String text = "";
                        String textR = "";
                        int lineNumber;
                        ArrayList<String> filenames = new ArrayList<>();
                        ArrayList<String> fileout = new ArrayList<>();
                         ArrayList<String> fileout1 = new ArrayList<>();
                         
                        File directoryPath = new File("BUP");
                        //List all files and directories
                       // System.out.println("------------All files------------");
                        for (File file : directoryPath.listFiles()) {
                            
                            filenames.add(file.getName());
                            
                        }
                      // System.out.println(filenames);
                        for (int i = 0; i <  filenames.size(); i++){
                             ArrayList<String> alro = new ArrayList<>();
                            
                            for (int k = 0; k < alr.size(); k++){                                    

                                
                                try {
                                    
                                    
                                    String[]  l =  (findLine(alr.get(k),"BUP\\"+filenames.get(i)));
                                    if(l[1] != null){
                                      //  fileout1.add("\n-------------\n"+l[1]+"\n------------------------------------------------------------\n");
                                    fileout1.add(l[1]+"="+alr.get(k));
                                    
                                     
                        alro.add(alr.get(k));
                                    }
                                   
                                    
                                    
                                 
                                    
                                } catch (IOException ex) {
                                    Logger.getLogger(Rusum.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                            }
                            
                     
                           
                            
                             alr.removeAll(alro);
                            
                            
                        } 
                               Collections.sort(fileout1);
                               fileout1.stream().map((line) -> {
                                   fileout.add("\n-------------\n"+realfind("BUP.*\\=",line)+"\n-----------------------------------------------------------------------------------\n");
                        return line;
                    }).forEachOrdered((line) -> {
                        fileout.add(realfind("\\d{9,20}",line));
                    });
                        ArrayList<String> newfileout = new ArrayList<>();
                        fileout.removeAll(Collections.singletonList(null));
                        for (int i = 0; i < fileout.size(); i++){
                            newfileout.add(fileout.get(i).trim());}
                       // System.out.println("newModified List: " + newfileout);
                       /////
                
                            
                               
                               
                        /// List<String> newList = newfileout;      
                        List<String> newList = newfileout.stream()
                              .distinct()
                               .collect(Collectors.toList());
                        
                        ///////
                       // System.out.println("ArrayList with duplicates removed: "
                         //       + newList);
                        for (int i = 0; i < newList.size(); i++) {
                            qq=qq+'\n'+newList.get(i);
                           // System.out.println("original out put file");
                            
                        }               
                        //ArrayList<String> newfileout3 = new ArrayList<>();
                       // newfileout3.addAll(alr);
                        //alr.removeAll(newList);
                        for (int i = 0; i < alr.size(); i++) {
                            qq2=qq2+"\n"+alr.get(i);
                            //System.out.println("original out put file");
                            
                            
                            
                        }              
                         long endTime = System.nanoTime();
                        
                long timeElapsed = endTime - startTime;
                        t.setText(qq);
                        t.setText(input+"\n====================Area===================\n"+qq+"\n==============="+alr.size()+"===None=============="+qq2+"\n================Execution time ===============\n"+timeElapsed / 1000000000+"sec");
                        break;
                    }
                case "show":
                    {
                        
                        
                                // Now add the particular background color
                            ArrayList<String> alr = new ArrayList<>();
                        String vbui =tt.getText();
                        vbui = vbui.trim();
                        String input =t.getText();
                        input = input.trim();
                        String qq="";
                        
                        // For loop for iterating over the List
                        String[] lines = input.split("\\r?\\n");
                        for (String line : lines) {
                           // System.out.println(line);
                            if(find("^\\d{9,20}$",line)){
                                alr.add(line);}
                            
                        }
                        String  sh ="show running-config-interface vbui" ;
                        String y= sh+vbui+" | i ";
                        for (int i = 0; i < alr.size(); i++) {
                            qq=qq+'\n'+y+alr.get(i);
                            
                            
                        }     t.setText(input+"\n=======================================\n"+qq);
                        break;
                    }
                case "double ip":
                {   
                     long startTime = System.nanoTime();
                        String qq="";
                        int lineNumber;
                        ArrayList<String> filenames = new ArrayList<>();
                        ArrayList<String> fileout = new ArrayList<>();
                        ArrayList<String> fileout1 = new ArrayList<>();
                        File directoryPath = new File("BUP");
                        
                        for (File file : directoryPath.listFiles()) {
                            
                            filenames.add(file.getName());
                            
                        }
                        
                        // System.out.println(filenames);
                        String x ;
                        for (int i = 0; i <  filenames.size(); i++){
                            ArrayList<String> alro = new ArrayList<>();
                           
                                
                                try {
                                    
                                 
                                    
                                    alro=  (findLine2("BUP\\"+filenames.get(i)));
                                    alro.removeAll(Collections.singletonList(null));
                                    fileout1.addAll(alro);
                                 
                              
                                    
                        
                                    
                                } catch (IOException ex) {
                                    Logger.getLogger(Rusum.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                            
                        } 
                        
                          
                               Collections.sort(fileout1);
                            fileout1.stream().map((line) -> {
                                fileout.add("\n~~~~~~~~~~~~~~~~~~~\n"+realfind("BUP.*\\=",line)+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                        return line;
                    }).forEachOrdered((line) -> {
                        fileout.add(realfind("(^\\d{9,20}$|ip-host description.*)",line));
                    });
                        
                         /////////////
                         fileout.removeAll(Collections.singletonList(null));
                       
                        List<String> newList = fileout.stream()
                                .distinct()
                                .collect(Collectors.toList());

                         ////////////
                         
                         for (int i = 0; i < newList.size(); i++) {
                            qq=qq+'\n'+newList.get(i);
                            
                            
                        }  
                         
                      
                        long endTime = System.nanoTime();
                        
                long timeElapsed = endTime - startTime;
                
                        t.setText("\n=======================================\n"+qq+"\n================Execution time ===============\n"+timeElapsed / 1000000000+"sec");
                   
 
                       
                        
                    
                    //////////h
                break;
                } 
                
                     case "Termination":
                {
                /////////////
                     ArrayList<String> alr = new ArrayList<>();
                        String input =t.getText();
                        input = input.trim();
                        String qq="";
                        
                        // For loop for iterating over the List
                        String[] lines = input.split("\\r?\\n");
                        for (String line : lines) {
                            //System.out.println(line);
                            if(find("^\\d{9,20}$",line)){
                                alr.add(line);}
                            
                        }
                        String text = "";
                        String textR = "";
                        int lineNumber;
                        ArrayList<String> filenames = new ArrayList<>();
                        ArrayList<String> fileout = new ArrayList<>();
                        ArrayList<String> fileout1 = new ArrayList<>();
                        File directoryPath = new File("BUP");
                        
                        for (File file : directoryPath.listFiles()) {
                            
                            filenames.add(file.getName());
                            
                        }
                        String x ;
                        for (int i = 0; i <  filenames.size(); i++){
                            ArrayList<String> alro = new ArrayList<>();
                            for (int k = 0; k < alr.size(); k++){
                                
                                try {
                                    
                                    
                                    
                                    String[]  l =  (findLine(alr.get(k),"BUP\\"+filenames.get(i)));
                                    if(l[1]!=null){
                                        //fileout.add("\n----------\n"+l[1]+"\n--------------------------------------------------\n");
                                        alro.add(alr.get(k));
                                          //fileout.add(l[0]);
                                          fileout1.add(l[1]+"="+l[0]);
                                    }
                                  
                                    
                        
                                    
                                } catch (IOException ex) {
                                    Logger.getLogger(Rusum.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                            }
                            
                                  
                             
                           
                            
                            alr.removeAll(alro);
                            
                       
                        }  
                        
                        
                            Collections.sort(fileout1);
                            fileout1.stream().map((line) -> {
                                fileout.add("\n~~~~~~~~~~~~~~~~~~~\n"+realfind("BUP.*\\=",line)+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                        return line;
                    }).forEachOrdered((line) -> {
                        fileout.add(realfind("ip-host description.*",line));
                    });
                        ArrayList<String> newfileout = new ArrayList<>();
                        fileout.removeAll(Collections.singletonList(null));
                        for (int i = 0; i < fileout.size(); i++){
                            newfileout.add(fileout.get(i).trim());}
                       
                        List<String> newList = newfileout.stream()
                                .distinct()
                                .collect(Collectors.toList());
                        String   pbr   = "";
                        for (int i = 0; i < newList.size(); i++) {
                          
                            String  imput1 = newList.get(i).replace(",","");
                               String ip = realfind("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}",imput1);
                               if(find("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}",imput1)){
                               pbr = "\nno ip-host "+ip+"\ny";
                               
                               }else{
                                  pbr = '\n'+imput1+'\n';
                               }
                                qq = qq + pbr;
                    
                            }
                         qq = qq + "\n###########################REPORT###############################\n";
                         for (int i = 0; i < newList.size(); i++) {
                          
                            String  imput1 = newList.get(i).replace(",","");
                               String ip = realfind("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}",imput1);
                                String SmartG = realfind("smartgroup\\d+\\.\\d+",imput1);
                                String PH = realfind("\\d{9,15}",imput1);
                               if(find("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}",imput1)){
                               pbr = "\n"+PH+"\t"+ip+"\t"+SmartG;
                               
                               }else{
                                  pbr = '\n'+imput1+'\n';
                               }
                                qq = qq + pbr;
                    
                            }
                           
                                
                            
                            
                                        t.setText(input+"\n=======================================\n"+qq);
                        
                    
                    //////////h
                break;
                } 
                /////////////////
                
                
                
                case "Error":
                    {
                        ArrayList<String> alr = new ArrayList<>();
                        String input =t.getText();
                        input = input.trim();
                        String qq="";
                        
                        // For loop for iterating over the List
                        String[] lines = input.split("\\r?\\n");
                        for (String line : lines) {
                            //System.out.println(line);
                            if(find("^\\d{9,20}$",line)){
                                alr.add(line);}
                            
                        }
                        String text = "";
                        String textR = "";
                        int lineNumber;
                        ArrayList<String> filenames = new ArrayList<>();
                        ArrayList<String> fileout = new ArrayList<>();
                        ArrayList<String> fileout1 = new ArrayList<>();
                        File directoryPath = new File("BUP");
                        
                        for (File file : directoryPath.listFiles()) {
                            
                            filenames.add(file.getName());
                            
                        }
                        String x ;
                        for (int i = 0; i <  filenames.size(); i++){
                            ArrayList<String> alro = new ArrayList<>();
                            for (int k = 0; k < alr.size(); k++){
                                
                                try {
                                    
                                    
                                    
                                    String[]  l =  (findLine(alr.get(k),"BUP\\"+filenames.get(i)));
                                    if(l[1]!=null){
                                        //fileout.add("\n----------\n"+l[1]+"\n--------------------------------------------------\n");
                                        alro.add(alr.get(k));
                                          //fileout.add(l[0]);
                                          fileout1.add(l[1]+"="+l[0]);
                                    }
                                  
                                    
                        
                                    
                                } catch (IOException ex) {
                                    Logger.getLogger(Rusum.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                            }
                            
                                  
                             
                           
                            
                            alr.removeAll(alro);
                            
                       
                        }  
                        
                        
                            Collections.sort(fileout1);
                            fileout1.stream().map((line) -> {
                                fileout.add("\n~~~~~~~~~~~~~~~~~~~\n"+realfind("BUP.*\\=",line)+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                        return line;
                    }).forEachOrdered((line) -> {
                        fileout.add(realfind("ip-host description.*",line));
                    });
                        ArrayList<String> newfileout = new ArrayList<>();
                        fileout.removeAll(Collections.singletonList(null));
                        for (int i = 0; i < fileout.size(); i++){
                            newfileout.add(fileout.get(i).trim());}
                       
                
                        List<String> newList = newfileout.stream()
                                .distinct()
                                .collect(Collectors.toList());
                       
                        for (int i = 0; i < newList.size(); i++) {
                          
                            String  imput18 = newList.get(i);
                            
                            /////////////////
                              String yphr ="";
                            String ypo ="";
                            String vv ="";
                            String dv ="";
                            String ych ="";
                            String  myphr ="";
                            String  BB ="";
                            String  BBB ="";
                            String  BBBB ="";
                            String myphr1 = "";
                            String myphr2 = "";
                            String myphr3 = "";
                            String myphr4= "";
                            String myphr5 = "";
                            String myphr6 = "";
                            String myphr7 = "";
                            String myphr8 = "";
                            String myphr9 = "";
                            String myphr10 = "";
                            
                            String rfinal = "";
                            String chb = "";
                            String vyphr = "";
                            String sv = "";
                            
                            String  Rfinals  = "";
                            
                            String   ypht  = "";
                            String   pbr   = "";
                            final String regexsup =     "\\d{9,16}+\\-{0,2}\\.{0,2}[a-zA-Z]{0,1}\\w{0,15}-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}-{0,2}\\.{0,2}\\w{0,15}\\.{0,2}\\-{0,2}\\d{0,3}\\-{0,1}\\w{0,5}\\-{0,1}\\d{0,3}\\-{0,1}";
                            final String regex = "\\d{9,16}+\\-{0,2}\\.{0,2}[a-zA-Z]{0,1}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\d{0,3}\\-{0,1}\\w{0,5}\\-{0,1}\\d{0,3}\\-{0,1}\\-{0,1}\\_{0,1}\\w{0,1}\\d{3,4}\\-{0,1}\\\\{0,2}\\s";
                            final String string = imput18;
                            final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
                            final Matcher matcher = pattern.matcher(string);
                            
                            while (matcher.find()) {
                             
                                
                                
                                yphr = matcher.group(0);
                                
                            }
                            
                          yphr=yphr.trim();
                            
                            final String regex2 = "\\d{9,15}";
                            
                            
                            final Pattern pattern2 = Pattern.compile(regex2, Pattern.MULTILINE);
                            final Matcher matcher2 = pattern2.matcher(string);
                            
                            while (matcher2.find()) {
                                
                                
                                ypo = ypo + matcher2.group(0);
                            }
                            
                           
                            
                            
                            if (!"".equals(yphr))
                            {
                             
                                vv = yphr.substring(yphr.length() - 4);
                             
                                final String regex3 = "sec-vlan";
                                
                                final Pattern pattern3 = Pattern.compile(regex3, Pattern.MULTILINE);
                                final Matcher matcher3 = pattern3.matcher(string);
                              
                                while (matcher3.find()) {
                                
                                    ych =  matcher3.group(0);
                                    
                                    
                                    
                                }
                               
                                
                                if (!"sec-vlan".equals(ych)){
                                 
                                    vv = vv.replace("b", "");
                                    vv = vv.replace("B", "");
                                    vv = vv.replace("v", "");
                                    vv = vv.replace("V", "");
                                    vv = vv.replace("-", "");
                                    vv = vv.replace("_", "");
                                    vv = vv.replace(".", "");
                                    vv = vv.replace(",", "");
                                    vv = vv.replace("/", "");
                                    
                                    
                                  vv=realfind("\\d{1,4}",vv);
                                
                                
                                
                                
                                }}
                            
                            
                            
                            /////////////////////
                            
                            
                            
                            
                           if( newList.get(i).contains("ip-host description")){
                               ////////////////////
                           
                             
                             
                              if(!find("vlan\\s\\d{4}",imput18) && vv.length()<3 ){
                                    pbr = '\n'+imput18+"\n";
                                    
                                    }
                              if(find("sec-vlan",imput18) && !find("sec-vlan\\s\\d{3,4}",imput18) )   {
                                 pbr = '\n'+imput18+"\n";
                                    
                                 }
                               ////////////////////
                           
                           }
                           else if(find("~~",imput18)||find("BUP",imput18))
                               
                               
                                {
                                    pbr = '\n'+imput18+'\n'; 
                                }
                          qq = qq + pbr;   
                        }  
                         
                      t.setText(input+"\n===================ERROR====================\n"+qq+"\n==================\n"); 
                     break;
                    }
                  
                        
                      
                
                  
                   
                
            
                
                
                ////////////
                 case "BackUp-Resum":
                    {
                          try {
                              
                        long startTime = System.nanoTime();
                        ArrayList<String> alr = new ArrayList<>();
                        String input =t.getText();
                        input = input.trim();
                        String qq="";
                        
                        // For loop for iterating over the List
                        String[] lines = input.split("\\r?\\n");
                        for (String line : lines) {
                            //System.out.println(line);
                            if(find("^\\d{9,20}$",line)){
                                alr.add(line);}
                            
                        }
                        String text = "";
                        String textR = "";
                        int lineNumber;
                        ArrayList<String> filenames = new ArrayList<>();
                        ArrayList<String> fileout = new ArrayList<>();
                        ArrayList<String> fileout1 = new ArrayList<>();
                        File directoryPath = new File("BUP");
                        
                        for (File file : directoryPath.listFiles()) {
                            
                            filenames.add(file.getName());
                            
                        }
                        String x ;
                        for (int i = 0; i <  filenames.size(); i++){
                            ArrayList<String> alro = new ArrayList<>();
                            for (int k = 0; k < alr.size(); k++){
                                
                                try {
                                    
                                    
                                    
                                    String[]  l =  (findLine(alr.get(k),"BUP\\"+filenames.get(i)));
                                    if(l[1]!=null){
                                        //fileout.add("\n----------\n"+l[1
                                        //fileout.add("\n----------\n"+l]+"\n--------------------------------------------------\n");
                                        alro.add(alr.get(k));
                                          //fileout.add(l[0]);
                                          fileout1.add(l[1]+"="+l[0]);
                                    }
                                  
                                    
                        
                                    
                                } catch (IOException ex) {
                                    Logger.getLogger(Rusum.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                            }
                            
                                  
                             
                           
                            
                            alr.removeAll(alro);
                            
                       
                        }  
                        
                        
                            Collections.sort(fileout1);
                            fileout1.stream().map((line) -> {
                                fileout.add("\n~~~~~~~~~~~~~~~~~~~\n"+realfind("BUP.*\\=",line)+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                        return line;
                    }).forEachOrdered((line) -> {
                        fileout.add(realfind("ip-host description.*",line));
                    });
                        ArrayList<String> newfileout = new ArrayList<>();
                        fileout.removeAll(Collections.singletonList(null));
                        for (int i = 0; i < fileout.size(); i++){
                            newfileout.add(fileout.get(i).trim());}
                       
                        List<String> newList = newfileout.stream()
                                .distinct()
                                .collect(Collectors.toList());
                       
                        
                            int count =0;  
                            
                        for (int i = 0; i < newList.size(); i++) {
                          
                            String  imput1 = newList.get(i).replace(",","");
                            String imput2 = imput1.replace("|", "");
                            String  imput3 = imput2.replace("@", "");
                            String imput4 = imput3.replace("$", "");
                            String imput5 = imput4.replace("/", "-");
                            String imput51 = imput5.replace(":","");
                            String imput61 = imput51.replace("*", "");
                            String  imput6 = imput61.replace("+", "");
                            String imput62 = imput6.replace(">", "");
                            String imput63 = imput62.replace("<", "");
                            
                            
                            String imput7 = imput63.replace("[", "");
                            String imput8 = imput7.replace("]","" );
                            String imput9 = imput8.replace("%", "");
                            String imput10 = imput9.replace("?", "");
                            String imput11 = imput10.replace(";", "");
                            String imput12 = imput11.replace("#", "");
                            String imput13 = imput12.replace("!", "");
                            String imput14 = imput13.replace("{", "");
                            String imput15 = imput14.replace("}", "");
                            String imput151 = imput15.replace("(", "");
                            String imput152 = imput151.replace(")", "");
                            String imput16 = imput152.replace("&", "");
                            String imput17 = imput16.replace("^", "");
                            String imput18 = imput17.replace("_", "-");
                            
                            String cler;
  String cler1;
  
  cler=realfind("\\db\\s",imput18);

  if(!"".equals(cler)){
  cler1=realfind("\\d",cler);
   imput18 = sub("\\db\\s",cler1+" ",imput18);
  }else{
    cler=realfind("\\dB\\s",imput18);
    if(!"".equals(cler)){
    cler1=realfind("\\d",cler);
   imput18 = sub("\\dB\\s",cler1+" ",imput18);
    }else{
    cler=realfind("\\dv\\s",imput18);
    if(!"".equals(cler)){
  cler1=realfind("\\d",cler);
   imput18 = sub("\\dv\\s",cler1+" ",imput18);
    }else{
    cler=realfind("\\dV\\s",imput18);
    if(!"".equals(cler)){
  cler1=realfind("\\d",cler);
   imput18 = sub("\\dV\\s",cler1+" ",imput18);
    }else{
    cler=realfind("\\d-\\s",imput18);
    if(!"".equals(cler)){
  cler1=realfind("\\d",cler);
   imput18 = sub("\\d-\\s",cler1+" ",imput18);
    }else{
    cler=realfind("\\d_\\s",imput18);
    if(!"".equals(cler)){
  cler1=realfind("\\d",cler);
   imput18 = sub("\\d_\\s",cler1+" ",imput18);
    }else{
    cler=realfind("\\d\\,\\s",imput18);
    if(!"".equals(cler)){
  cler1=realfind("\\d",cler);
   imput18 = sub("\\d\\,\\s",cler1+" ",imput18);
    }else{
    cler=realfind("\\d\\\\\\s",imput18);
    if(!"".equals(cler)){
  cler1=realfind("\\d",cler);
   imput18 = sub("\\d\\\\\\s",cler1+" ",imput18);
    }else{
    cler=realfind("\\d\\.\\s",imput18);
    if(!"".equals(cler)){
  cler1=realfind("\\d",cler);
   imput18 = sub("\\d\\.\\s",cler1+" ",imput18);
    }}}}
    }}
  }}}
                            
                                Date date = new Date();
SimpleDateFormat DateFor = new SimpleDateFormat("ddMMMyy");
String stringDate = DateFor.format(date);
//System.out.println("ipm 18 "+imput18);
     
         
    if(find("\\d{0,2}(Augest|January|February|March|April|May|June|July|September|October|November|December)\\d{1,2}",imput18))  {
      
          imput18=sub("\\d{0,2}(Augest|January|February|March|April|May|June|July|September|October|November|December)\\d{1,2}",stringDate,imput18);
          
      }
     
                            ////
                         String imput20="";
    String imput21="";
     String imput25=""; 

     imput20 = realfind("\\D\\d{1,2}[a-zA-Z]{2,4}\\d{1,2}",imput18); 
      imput25 = realfind("\\D\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",imput18);
     if(find("^-",imput20)||find("^-",imput25))
    {
        if(find("^-",imput20)){
   imput21= imput20;
   
    }else{
       imput21= imput25; 
        
        }
        
     } else {
         String first = realfind("^\\w",imput20);
        String first2 = realfind("^\\w",imput25);
         imput20 = realfind("\\d{1,2}[a-zA-Z]{2,4}\\d{1,2}",imput20);
  //       System.out.println("20 is"+imput20);
   
         
         imput25 = realfind("\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",imput25);
         
         
         
         if("".equals(imput20)&&!"".equals(imput25)){
              
             // System.out.println("f2 is"+ first2);
             imput21="-"+imput25;
             imput25=sub( "\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",first2+imput21,imput25);
             imput18=sub( "\\D\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",imput25,imput18);
             
             //System.out.println("bhbhbh"+imput21);
             
         } else if("".equals(imput25)&&"".equals(imput20)){
             //System.out.println(imput21);
         }else{
            
             imput21="-"+imput20;
              
                  imput20=sub( "\\d{1,2}[a-zA-Z]{2,4}\\d{2}",first+imput21,imput20);
             imput18=sub( "\\D\\d{1,2}[a-zA-Z]{2,4}\\d{2}",imput20,imput18);
             
    //         System.out.println(imput21);
         }                       }
           if(!find("\\d{10,13}-",imput18))  
   {
     String imput22=realfind("\\d{9,13}",imput18);
    //System.out.println("22 is "+ imput22);
    // System.out.println("112 is "+ imput18);
     
                       String imput23=imput22+"-";
                             
                            imput18=sub("\\d{10,13}",imput23,imput18);
     }
            imput18=sub("\\-\\-+","-",imput18); 
      //               System.out.println("18 is "+ imput18);
                            
                            ///
                            String yphr ="";
                            String ypo ="";
                            String vv ="";
                            String dv ="";
                            String ych ="";
                            String  myphr ="";
                            String  BB ="";
                            String  BBB ="";
                            String  BBBB ="";
                            String myphr1 = "";
                            String myphr2 = "";
                            String myphr3 = "";
                            String myphr4= "";
                            String myphr5 = "";
                            String myphr6 = "";
                            String myphr7 = "";
                            String myphr8 = "";
                            String myphr9 = "";
                            String myphr10 = "";
                            
                            String rfinal = "";
                            String chb = "";
                            String vyphr = "";
                            String sv = "";
                            
                            String  Rfinals  = "";
                            
                            String   ypht  = "";
                            String   pbr   = "";
                            final String regexsup = "\\d{9,16}+\\-{0,2}\\.{0,2}[a-zA-Z]{0,1}\\w{0,15}-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}-{0,2}\\.{0,2}\\w{0,15}\\.{0,2}\\-{0,2}\\d{0,3}\\-{0,1}\\w{0,5}\\-{0,1}\\d{0,3}\\-{0,1}";
                            final String regex = "\\d{9,16}+\\-{0,2}\\.{0,2}[a-zA-Z]{0,1}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\d{0,3}\\-{0,1}\\w{0,5}\\-{0,1}\\d{0,3}\\-{0,1}\\-{0,1}\\_{0,1}\\w{0,1}\\d{3,4}\\-{0,1}\\\\{0,2}\\s";
                            final String string = imput18;
                            final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
                            final Matcher matcher = pattern.matcher(string);
                            
                            while (matcher.find()) {                        
                                yphr = matcher.group(0);
                                
                            }
                            
                          yphr=yphr.trim();
                            
                            final String regex2 = "\\d{9,15}";
                            
                        
                           final Pattern pattern2 = Pattern.compile(regex2, Pattern.MULTILINE);
                            final Matcher matcher2 = pattern2.matcher(string);
                            
                            while (matcher2.find()) {
                                
                                
                                ypo = ypo + matcher2.group(0);
                            }
                            
                           
                            
                            
                            if (!"".equals(yphr))
                            {
                             
                                vv = yphr.substring(yphr.length() - 4);
                             
                                final String regex3 = "sec-vlan";
                                
                                final Pattern pattern3 = Pattern.compile(regex3, Pattern.MULTILINE);
                                final Matcher matcher3 = pattern3.matcher(string);
                              
                                while (matcher3.find()) {
                                
                                    ych =  matcher3.group(0);
                                    
                                    
                                    
                                }
                               
                                
                                if (!"sec-vlan".equals(ych)){
                              
                                    vv = vv.replace("b", "");
                                    vv = vv.replace("B", "");
                                    vv = vv.replace("v", "");
                                    vv = vv.replace("V", "");
                                    vv = vv.replace("-", "");
                                    vv = vv.replace("_", "");
                                    vv = vv.replace(".", "");
                                    vv = vv.replace(",", "");
                                    vv = vv.replace("/", "");
                                      
                                    myphr =   yphr.substring(0, yphr.length() - 4);
                                    BB = myphr.substring(myphr.length() - 1);
                                    BBB = myphr.substring(myphr.length() - 2);
                                    BBBB =myphr.substring(myphr.length() - 3);
                                    
                                    
                                    
                                    
                       //             System.out.println("myphr0"+myphr);
                                    myphr1 = sub("b$","",myphr);
                                    
                                    //System.out.println("myphr1"+myphr1);
                                    myphr2 = sub("B$","",myphr1);
                                    myphr3 = sub("v$","",myphr2);
                                    myphr4 = sub("V$","",myphr3);
                                    myphr5 = sub("/$","",myphr4);
                                    myphr6 = sub("-$","",myphr5);
                                    myphr7 = sub("_$","",myphr6);
                                    myphr8 = sub("\\.$","",myphr7);
                                    myphr9 = sub("\\,$","",myphr8);
                                    myphr10 = sub("\\\\,$","",myphr9);
                                    myphr = myphr10;
                                  //  System.out.println("myphr+"+myphr9);
                                    
                                    
                                    
                                    final String regex5 = "[a-zA-Z]\\d{1}";
                                    final String string5 =  BBB;
                                    
                                    final Pattern pattern5 = Pattern.compile(regex5, Pattern.MULTILINE);
                                    final Matcher matcher5 = pattern5.matcher(string5);
                                    
                                    while (matcher5.find()) {
                                        
                                       if(vv.length()>3)
                {
                dv =  vv.substring(0, vv.length() - 4);
                // System.out.println("dv+"+dv);
                vv = vv.substring(1);
               // System.out.println("vv+"+vv);
                myphr=myphr+dv;
                }
                else if(vv.length()==3){
                dv =  vv.substring(0, vv.length() - 3);
                
                myphr=myphr+dv;
                }
                                    }
                                    
                                    rfinal = imput18.replace(yphr,myphr);
                                    
                                      ////////////////
             
                                 
       if(find("[a-zA-Z\\-\\_=,.]\\d{1,2}[a-zA-Z]{0,4}\\d{0,2}\\-\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,7}", rfinal)){
          
           String jj=realfind("[a-zA-Z\\-\\_=,.]\\d{1,2}[a-zA-Z]{0,4}\\d{0,2}\\-\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,7}",rfinal);
            char firstCharacter = jj.charAt(0);
       rfinal=sub("[a-zA-Z\\-\\_=,.]\\d{1,2}[a-zA-Z]{0,4}\\d{0,2}\\-\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,7}",firstCharacter+stringDate, rfinal);
     }
    
     
       else if(!find("\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,7}",rfinal)){
     rfinal=sub("\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}",stringDate,rfinal);}
     else{
      rfinal=sub("\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,7}",stringDate,rfinal);
     }
     
    rfinal=sub("\\d{1,2}\\-\\d{1,2}\\-\\d{1,7}",stringDate,rfinal);
      
             ///////////////////
                                    final String regex7 = "\\d{3,5}";
                                    final String string7 = vv;
                                    
                                    final Pattern pattern7 = Pattern.compile(regex7, Pattern.MULTILINE);
                                    final Matcher matcher7 = pattern7.matcher(string7);
                                    
                                    while (matcher7.find()) {
                         //               System.out.println("Full match: " + matcher7.group(0));
                                        
                                        
                                        chb = chb + matcher7.group(0);                                      
                                        
                                    }
                                    
                                    
                                    
                                    
                                    final String regex6 = "vlan\\s\\d{4}";
                                    
                                    
                                    final Pattern pattern6 = Pattern.compile(regex6, Pattern.MULTILINE);
                                    final Matcher matcher6 = pattern6.matcher(string);
                                    
                                    while (matcher6.find()) {
                                       // System.out.println("Full match: " + matcher6.group(0));
                                        vyphr = vyphr + matcher6.group(0);
                                    }
                                    
                                    
                                    if (!"".equals(vyphr) && !"".equals(vv)){
                                        sv = vyphr + " sec-vlan "+ chb;
                                    }
                                    else{
                                        sv =" vlan "+ chb;
                                    }
                           //         System.out.println("sv+"+sv);
                                    
                                    final String regexr = "vlan\\s\\d{1,4}";
                                    final String Rfinal =rfinal ;
                                    final String subst = sv;
                                    
                                    final Pattern patternr = Pattern.compile(regexr, Pattern.MULTILINE);
                                    final Matcher matcherr = patternr.matcher(Rfinal);
                                    
                                    // The substituted value will be contained in the result variable
                                    final String result = matcherr.replaceAll(subst);
                                    
                             //       System.out.println("Substitution result: " + result);
                                    
                                    final String regexss = "\\s\\s+";
                                    final String stringss = result;
                                    final String substs = " ";
                                    
                                    final Pattern patterns = Pattern.compile(regexss, Pattern.MULTILINE);
                                    final Matcher matchers = patterns.matcher(stringss);
                                    
                                    // The substituted value will be contained in the result variable
                                     String Results = matchers.replaceAll(substs);
                                    
                                   
                                    
                                    final String regex8= "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
                                    
                                    
                                    final Pattern pattern8 = Pattern.compile(regex8, Pattern.MULTILINE);
                                    final Matcher matcher8 = pattern8.matcher(string);
                                    
                                    while (matcher8.find()) {
                               //        System.out.println("Full match: " + matcher8.group(0));
                                        
                                        ypht = ypht + matcher8.group(0);
                                        
                                 //      System.out.println(ypht);     
                                        
                                        
                                    }
                                    
if(!find("\\d{1,2}[a-zA-Z]{2,4}\\d{1,2}",Results)&&!find("\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",Results)){
         String rt= realfind("\\d{9,16}.*?\\s",Results);
        String rt2=rt+"-"+stringDate;
        
        rt2=  rt2.replaceAll("\\s+", "");
        rt2=rt2+" ";
         if (rt2.length()>31){
         
         String dg = rt2.substring(rt2.length() - 15); 
                 
               String   sr=rt2.substring(0,15);
                rt2 = sr+"-"+dg ;
                  
         }
          Results =sub("\\d{9,16}.*?\\s",rt2,Results);
          Results=sub("[bBvV\\-,\\/_=]\\d{3,4}","",Results);
           Results=sub("--","-",Results);
         //System.out.println(imput18);
         ////////////
         
          
         ///////////
     }
                                         count++;
                                    pbr = "\nno ip-host "+ypht+"\ny"+'\n'+Results;
                        
                                    qq = qq + pbr;
                                    
                                    
                                }else{
                                    ////////////////////
                                      ////////////////
              ///System.out.println("111111111111");
                                
       if(find("[a-zA-Z\\-\\_=,.]\\d{1,2}[a-zA-Z]{0,4}\\d{0,2}\\-\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,7}",imput18)){
       String jj=realfind("[a-zA-Z\\-\\_=,.]\\d{1,2}[a-zA-Z]{0,4}\\d{0,2}\\-\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,7}",imput18);
            char firstCharacter = jj.charAt(0);
       imput18=sub("[a-zA-Z\\-\\_=,.]\\d{1,2}[a-zA-Z]{0,4}\\d{0,2}\\-\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,7}",firstCharacter+stringDate, imput18);
   
     }
    
     
    else if(!find("\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,7}",imput18)){
     imput18=sub("\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}",stringDate,imput18);
  //  System.out.println(imput18);
    }
     else{
      imput18=sub("\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,7}",stringDate,imput18);
     // System.out.println(imput18);
     }
     
    imput18=sub("\\d{1,2}\\-\\d{1,2}\\-\\d{1,7}",stringDate,imput18);
    imput18=sub("[bBvV\\-,\\/_=]\\d{3,4}","",imput18);
    //System.out.println(imput18);
      
             ///////////////////
             if(!find("\\d{1,2}[a-zA-Z]{2,4}\\d{1,2}",imput18)&&!find("\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",imput18)){
         String rt= realfind("\\d{9,16}.*?\\s",imput18);
        String rt2=rt+"-"+stringDate;
        rt2=  rt2.replaceAll("\\s+", "");
        rt2=rt2+" ";
        
          imput18=sub("\\d{9,16}.*?\\s",rt2,imput18);
         //System.out.println(imput18);
     }
   imput18=sub("--","-",imput18);                                 
                                   
                                     final String regex8= "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
                                    
                                    
                                    final Pattern pattern8 = Pattern.compile(regex8, Pattern.MULTILINE);
                                    final Matcher matcher8 = pattern8.matcher(string);
                                    
                                    while (matcher8.find()) {
                                 //      System.out.println("Full match: " + matcher8.group(0));
                                        
                                        ypht = ypht + matcher8.group(0);
                                        
                                   //    System.out.println(ypht);   
                                       count++; 
                                pbr = "\nno ip-host "+ypht+"\ny"+'\n'+imput18;
                        
                                    qq = qq + pbr;
                                }
                                   //System.out.println("here");
                                
                            }
                            }
                            
                            
        else if(find("^ip-host description.*?\\d+(M|K)[^ ]*?$",imput18))  {
            System.out.println("2222222222222222222222"); 
                                
                                 System.out.println(imput18);
                                 
       if(find("[a-zA-Z\\-\\_=,.]\\d{1,2}[a-zA-Z]{0,4}\\d{0,2}\\-\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,7}",imput18)){
      String jj=realfind("[a-zA-Z\\-\\_=,.]\\d{1,2}[a-zA-Z]{0,4}\\d{0,2}\\-\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,7}",imput18);
            char firstCharacter = jj.charAt(0);
            System.out.println(firstCharacter);
            
       imput18=sub("[a-zA-Z\\-\\_=,.]\\d{1,2}[a-zA-Z]{0,4}\\d{0,2}\\-\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,7}",firstCharacter+stringDate, imput18);
    System.out.println(imput18);
     }
    
    
     
       else if(!find("\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,7}",imput18)){
     imput18=sub("\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}",stringDate,imput18);}
     else{
      imput18=sub("\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,7}",stringDate,imput18);
     }
     
    imput18=sub("\\d{1,2}\\-\\d{1,2}\\-\\d{1,7}",stringDate,imput18);
                                ypht="";
                                final String regex8= "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
                                

                                final Pattern pattern8 = Pattern.compile(regex8, Pattern.MULTILINE);
                                final Matcher matcher8 = pattern8.matcher(imput18);
                                
                                while (matcher8.find()) {
                                  // System.out.println("Full match: " + matcher8.group(0));
                                    
                                    ypht = ypht + matcher8.group(0);
                                    
                                    //System.out.println(ypht);
                                    
                                    
                                }
                                
      if(!find("\\d{1,2}[a-zA-Z]{2,4}\\d{1,2}",imput18)&&!find("\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",imput18)){
         String rt= realfind("\\d{9,16}.*?\\s",imput18);
        String rt2=rt+"-"+stringDate;
        rt2=  rt2.replaceAll("\\s+", "");
        rt2=rt2+" ";
        
          imput18=sub("\\d{9,16}.*?\\s",rt2,imput18);
        // System.out.println(imput18);
     }
                                if(!"".equals(ypht)){
                                  String    ypkh =realfind(regexsup,imput18);
                        ypkh = ypkh.trim();
                                             if (ypkh.length()>31){
                if (!"".equals(imput20)||!"".equals(imput25)){
                 
                 String dg = ypkh.substring(ypkh.length() - 15); 
                 
               String   sr=ypkh.substring(0,15);
                String ypu = sr+"-"+dg ;
          //       System.out.println("ypu"+ypu);
                imput18 =sub(ypkh,ypu,imput18);
                 
                }
                                             
                                              else
                    
                {
                    
                 String dg = ypkh.substring(ypkh.length() - 15); 
                 
               String   sr=ypkh.substring(0,15);
                String ypu = sr+"-"+dg ;
            //      System.out.println("ypu"+ypu);
                imput18 =sub(ypkh,ypu,imput18);
                
                }
                  
                                             }
                                    
                                    
                                    if(find("vlan\\s\\d{4}",imput18)){
    
                                            count++;
                                    pbr = "\nno ip-host "+ypht+"\ny"+'\n'+imput18;
                                    }
                                    else{
                                    pbr ="\n~~~~~~~~~~~\nError\t"+imput18+"\n~~~~~~~~~~~\n";
                                    }
                                }else
                                {
                                    pbr = '\n'+imput18+'\n'; 
                                }
                                
                                
                              
                                qq = qq + pbr;
                               
                                
                            }
                            else {
                                
                            //    System.out.println("333333333333"); 
                                qq=qq+'\n'+imput18+'\n';
                                
                            }
                            
                        }                
                        
                        
                        
                      
                        long endTime = System.nanoTime();
                        
                long timeElapsed = endTime - startTime;
                
                    
                   
 
        
                        t.setText(input+"\n=======================================\n"+qq+"\n================Execution time ===============\n"+timeElapsed / 1000000000+"sec"+"\n Number of successful oppretion \t"+ count);
                        
                        
                        
                          }
                         catch (Exception evt) {
                        JOptionPane.showMessageDialog(f, evt.getMessage());
                    }
                        break;
                    }
                case "Resum":
                    // Create an object of JFileChooser class
                    
                    
                    // If the user selects a file
                    
                    
                    
                    
                    try {
                        // String
                        long startTime = System.nanoTime();
                        String qq="";
                        ArrayList<String> alr = new ArrayList<>();
                      
                        
                        
                        String input =t.getText();
                        input = input.trim();
                        
                        
                        // For loop for iterating over the List
                        
                        
                        String[] lines = input.split("\\r?\\n");
                        for (String line : lines) {
                           // System.out.println(line);
                            if(find("^ip-host description.*?\\d+(M|K)[^ ]*?$",line)){
                                alr.add(line);}
                            
                        }
                        
                        
                        
//opreation
for (int i = 0; i < alr.size(); i++) {
   // System.out.println("yonau");
    String  imput1 = alr.get(i).replace(",","");
    String imput2 = imput1.replace("|", "");
    String  imput3 = imput2.replace("@", "");
    String imput4 = imput3.replace("$", "");
    String imput5 = imput4.replace("/", "-");
    String imput51 = imput5.replace(":","");
    String imput61 = imput51.replace("*", "");
    String  imput6 = imput61.replace("+", "");
    String imput62 = imput6.replace(">", "");
    String imput63 = imput62.replace("<", "");
    
    
    String imput7 = imput63.replace("[", "");
    String imput8 = imput7.replace("]","" );
    String imput9 = imput8.replace("%", "");
    String imput10 = imput9.replace("?", "");
    String imput11 = imput10.replace(";", "");
    String imput12 = imput11.replace("#", "");
    String imput13 = imput12.replace("!", "");
    String imput14 = imput13.replace("{", "");
    String imput15 = imput14.replace("}", "");
    String imput151 = imput15.replace("(", "");
    String imput152 = imput151.replace(")", "");
    String imput16 = imput152.replace("&", "");
    String imput17 = imput16.replace("^", "");
    String imput18 = imput17.replace("_", "-");
   // System.out.println(imput18);
   
 //  String cler=realfind("\\d{9,16}.*?\\s",imput18);
 String cler;
  String cler1;
  
  cler=realfind("\\db\\s",imput18);

  if(!"".equals(cler)){
  cler1=realfind("\\d",cler);
   imput18 = sub("\\db\\s",cler1+" ",imput18);
  }else{
    cler=realfind("\\dB\\s",imput18);
    if(!"".equals(cler)){
    cler1=realfind("\\d",cler);
   imput18 = sub("\\dB\\s",cler1+" ",imput18);
    }else{
    cler=realfind("\\dv\\s",imput18);
    if(!"".equals(cler)){
  cler1=realfind("\\d",cler);
   imput18 = sub("\\dv\\s",cler1+" ",imput18);
    }else{
    cler=realfind("\\dV\\s",imput18);
    if(!"".equals(cler)){
  cler1=realfind("\\d",cler);
   imput18 = sub("\\dV\\s",cler1+" ",imput18);
    }else{
    cler=realfind("\\d-\\s",imput18);
    if(!"".equals(cler)){
  cler1=realfind("\\d",cler);
   imput18 = sub("\\d-\\s",cler1+" ",imput18);
    }else{
    cler=realfind("\\d_\\s",imput18);
    if(!"".equals(cler)){
  cler1=realfind("\\d",cler);
   imput18 = sub("\\d_\\s",cler1+" ",imput18);
    }else{
    cler=realfind("\\d\\,\\s",imput18);
    if(!"".equals(cler)){
  cler1=realfind("\\d",cler);
   imput18 = sub("\\d\\,\\s",cler1+" ",imput18);
    }else{
    cler=realfind("\\d\\\\\\s",imput18);
    if(!"".equals(cler)){
  cler1=realfind("\\d",cler);
   imput18 = sub("\\d\\\\\\s",cler1+" ",imput18);
    }else{
    cler=realfind("\\d\\.\\s",imput18);
    if(!"".equals(cler)){
  cler1=realfind("\\d",cler);
   imput18 = sub("\\d\\.\\s",cler1+" ",imput18);
    }}}}
    }}
  }}}
 
       String imput20="";
    String imput21="";
     String imput25=""; 
     
    Date date = new Date();
SimpleDateFormat DateFor = new SimpleDateFormat("ddMMMyy");
String stringDate = DateFor.format(date);
//System.out.println("Date Format with MM/dd/yyyy : "+stringDate);
     
    if(find("\\d{0,2}(Augest|January|February|March|April|May|June|July|September|October|November|December)\\d{1,2}",imput18))  {
      
          imput18=sub("\\d{0,2}(Augest|January|February|March|April|May|June|July|September|October|November|December)\\d{1,2}",stringDate,imput18);
          
      }
     
     
     imput20 = realfind("\\D\\d{1,2}[a-zA-Z]{2,4}\\d{1,2}",imput18); 
      imput25 = realfind("\\D\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",imput18);
     
      
      
     if(find("^-",imput20)||find("^-",imput25))
    {
        if(find("^-",imput20)){
   imput21= imput20;
   
    }else{
       imput21= imput25; 
        
        }
        
     } else {
         String first = realfind("^\\w",imput20);
        String first2 = realfind("^\\w",imput25);
         imput20 = realfind("\\d{1,2}[a-zA-Z]{2,4}\\d{1,2}",imput20);
        // System.out.println("20 is"+imput20);
   
         
         imput25 = realfind("\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",imput25);
         
         
         
         if("".equals(imput20)&&!"".equals(imput25)){
              
              //System.out.println("f2 is"+ first2);
             imput21="-"+imput25;
             imput25=sub( "\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",first2+imput21,imput25);
             imput18=sub( "\\D\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",imput25,imput18);
             
             //System.out.println("bhbhbh"+imput21);
             
         } else if("".equals(imput25)&&"".equals(imput20)){
            // System.out.println(imput21);
         }else{
            
             imput21="-"+imput20;
              
                  imput20=sub( "\\d{1,2}[a-zA-Z]{2,4}\\d{2}",first+imput21,imput20);
             imput18=sub( "\\D\\d{1,2}[a-zA-Z]{2,4}\\d{2}",imput20,imput18);
             
           //  System.out.println(imput21);
         }                       }
           if(!find("\\d{10,13}-",imput18))  
   {
     String imput22=realfind("\\d{9,13}",imput18);
    // System.out.println("22 is "+ imput22);
      //System.out.println("112 is "+ imput18);
     
                             String imput23=imput22+"-";
                             
                            imput18=sub("\\d{10,13}",imput23,imput18);
     }
            imput18=sub("\\-\\-+","-",imput18); 
                  // System.out.println("18 is "+ imput18);
        
                            
    String yphr ="";
    String ypo ="";
    String vv ="";
    String dv ="";
    String ych ="";
    String  myphr ="";
    String  BB ="";
    String  BBB ="";
    String  BBBB ="";
    String myphr1 = "";
    String myphr2 = "";
    String myphr3 = "";
    String myphr4= "";
    String myphr5 = "";
    String myphr6 = "";
    String myphr7 = "";
    String myphr8 = "";
    String myphr9 = "";
    String myphr10 = "";
    String rfinal = "";
    String chb = "";
    String vyphr = "";
    String sv = "";
    
    String  Rfinals  = "";
    
    String   ypht  = "";
    String   pbr   = "";
    
    final String regex = "\\d{9,16}+\\-{0,2}\\.{0,2}[a-zA-Z]{0,1}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\d{0,3}\\-{0,1}\\w{0,5}\\-{0,1}\\d{0,3}\\-{0,1}\\-{0,1}\\_{0,1}\\w{0,1}\\d{3,4}\\-{0,1}\\\\{0,2}\\s";
    final String string = imput18;
    final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
    final Matcher matcher = pattern.matcher(string);
    
    while (matcher.find()) {
       // System.out.println("Full match: " + matcher.group(0));
        
        
        yphr = matcher.group(0);
        
    }
  //  System.out.println(matcher.find());
    
   // System.out.println("vv");
    yphr=yphr.trim();
    final String regex2 = "\\d{9,15}";
    
    
    final Pattern pattern2 = Pattern.compile(regex2, Pattern.MULTILINE);
    final Matcher matcher2 = pattern2.matcher(string);
    
    while (matcher2.find()) {
       // System.out.println("Full match: " + matcher2.group(0));
        
        ypo = ypo + matcher2.group(0);
    }
    
   // System.out.println(yphr);
    
    
    if (!"".equals(yphr))
    {
      //  System.out.println("pass it"+yphr);
        vv = yphr.substring(yphr.length() - 4);
        
        
        //System.out.println(vv);
        final String regex3 = "sec-vlan";
        
         final Pattern pattern3 = Pattern.compile(regex3, Pattern.MULTILINE);
        final Matcher matcher3 = pattern3.matcher(string);
        //not need 
        while (matcher3.find()) {
           // System.out.println("Full match: " + matcher3.group(0));
            
            ych =  matcher3.group(0);
            
            
            
        }
        
     
      
       
        
        if (!"sec-vlan".equals(ych)){
            //System.out.println("hrrr+"+ych);
            vv = vv.replace("b", "");
            vv = vv.replace("B", "");
            vv = vv.replace("v", "");
            vv = vv.replace("V", "");
            vv = vv.replace("-", "");
            vv = vv.replace("_", "");
            vv = vv.replace(".", "");
            vv = vv.replace(",", "");
            vv = vv.replace("/", "");
            
            myphr =   yphr.substring(0, yphr.length() - 4);
            BB = myphr.substring(myphr.length() - 1);
            BBB = myphr.substring(myphr.length() - 2);
            BBBB =myphr.substring(myphr.length() - 3);
          
            
        
            myphr1 = sub("b$","",myphr);
         
            myphr2 = sub("B$","",myphr1);
            myphr3 = sub("v$","",myphr2);
            myphr4 = sub("V$","",myphr3);;
            myphr5 = sub("/$","",myphr4);
            myphr6 = sub("-$","",myphr5);
            myphr7 = sub("_$","",myphr6);
            myphr8 = sub("\\.$","",myphr7);
            myphr9 = sub("\\,$","",myphr8);
             myphr10 = sub("\\\\,$","",myphr9);
                                    myphr = myphr10;
           
           // System.out.println("myphr9+"+myphr9);
            
            
            
            final String regex5 = "[a-zA-Z]\\d{1}";
            final String string5 =  BBB;
            
            final Pattern pattern5 = Pattern.compile(regex5, Pattern.MULTILINE);
            final Matcher matcher5 = pattern5.matcher(string5);
            
            while (matcher5.find()) {
                
              if(vv.length()>3)
                {
                dv =  vv.substring(0, vv.length() - 4);
                // System.out.println("dv+"+dv);
                vv = vv.substring(1);
               // System.out.println("vv+"+vv);
                myphr=myphr+dv;
                }
                else if(vv.length()==3){
                dv =  vv.substring(0, vv.length() - 3);
                
                myphr=myphr+dv;
                }
              
              
                
            }
           // System.out.println("bef--"+  imput18);
            rfinal = imput18.replace(yphr,myphr);
            // System.out.println("af--"+  rfinal);
             ////////////////
             
    if(find("[a-zA-Z\\-\\_=,.]\\d{1,2}[a-zA-Z]{0,4}\\d{0,2}\\-\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,7}",rfinal)){
     String jj=realfind("[a-zA-Z\\-\\_=,.]\\d{1,2}[a-zA-Z]{0,4}\\d{0,2}\\-\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,7}",rfinal);
            char firstCharacter = jj.charAt(0);
       rfinal=sub("[a-zA-Z\\-\\_=,.]\\d{1,2}[a-zA-Z]{0,4}\\d{0,2}\\-\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,7}",firstCharacter+stringDate, rfinal);
    }
    
     
    else if(!find("\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,7}",rfinal)){
     rfinal=sub("\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}",stringDate,rfinal);}
    
    
     else{
      rfinal=sub("\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,7}",stringDate,rfinal);
     }
     
    rfinal=sub("\\d{1,2}\\-\\d{1,2}\\-\\d{1,7}",stringDate,rfinal);
      
             ///////////////////
            
            final String regex7 = "\\d{3,5}";
            final String string7 = vv;
            
            final Pattern pattern7 = Pattern.compile(regex7, Pattern.MULTILINE);
            final Matcher matcher7 = pattern7.matcher(string7);
            
            while (matcher7.find()) {
               // System.out.println("Full match: " + matcher7.group(0));
                
                
                chb = chb + matcher7.group(0);
                
            }
                        
            final String regex6 = "vlan\\s\\d{4}";
            
            
            final Pattern pattern6 = Pattern.compile(regex6, Pattern.MULTILINE);
            final Matcher matcher6 = pattern6.matcher(string);
            
            while (matcher6.find()) {
               /// System.out.println("Full match: " + matcher6.group(0));
                vyphr = vyphr + matcher6.group(0);
            }
            
            
            if (!"".equals(vyphr) && !"".equals(vv)){
                sv = vyphr + " sec-vlan "+ chb;
            }
            else{
                sv =" vlan "+ chb;
            }
           // System.out.println("sv+"+sv);
            
            final String regexr = "vlan\\s\\d{1,4}";
            final String Rfinal =rfinal ;
            final String subst = sv;
            
            final Pattern patternr = Pattern.compile(regexr, Pattern.MULTILINE);
            final Matcher matcherr = patternr.matcher(Rfinal);
            
            // The substituted value will be contained in the result variable
            final String result = matcherr.replaceAll(subst);
            
            //System.out.println("Substitution result: " + result);
            
            final String regexss = "\\s\\s+";
            final String stringss = result;
            final String substs = " ";
            
            final Pattern patterns = Pattern.compile(regexss, Pattern.MULTILINE);
            final Matcher matchers = patterns.matcher(stringss);
            
            // The substituted value will be contained in the result variable
             String Results = matchers.replaceAll(substs);
           
            
            final String regex8= "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
            
            
            final Pattern pattern8 = Pattern.compile(regex8, Pattern.MULTILINE);
            final Matcher matcher8 = pattern8.matcher(string);
            
            while (matcher8.find()) {
             //   System.out.println("Full match: " + matcher8.group(0));
                
                ypht = ypht + matcher8.group(0);
                
               // System.out.println(ypht);
                
                
            }
            
            if(!find("\\d{1,2}[a-zA-Z]{2,4}\\d{1,2}",Results)&&!find("\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",Results)){
         String rt= realfind("\\d{9,16}.*?\\s",Results);
        String rt2=rt+"-"+stringDate;
        
        rt2=  rt2.replaceAll("\\s+", "");
        rt2=rt2+" ";
         if (rt2.length()>31){
         
         String dg = rt2.substring(rt2.length() - 15); 
                 
               String   sr=rt2.substring(0,15);
                rt2 = sr+"-"+dg ;
                  
         }
          Results =sub("\\d{9,16}.*?\\s",rt2,Results);
             Results=sub("[bBvV\\-,\\/_=]\\d{3,4}","",Results);
             Results=sub("--","-",Results);
       //  System.out.println(imput18);
         ////////////
         
          
         ///////////
     }
            
            
            pbr = "no ip-host "+ypht+"\ny"+'\n'+Results+'\n';
            //System.out.println( pbr);
            ///System.out.println( "altesa");
            qq = qq + pbr;
            
            
        }
        
        //errorbvbfnklj
    }
    else if("".equals(ypo)) {
        t.setText("yonas");
    }
    
}

 
                        long endTime = System.nanoTime();
                        
                long timeElapsed = endTime - startTime;
                
                
 
t.setText(input+"\n=======================================\n"+qq+"\n================Execution time ===============\n"+timeElapsed / 1000000000+"sec");


                    }
                    catch (Exception evt) {
                        JOptionPane.showMessageDialog(f, evt.getMessage());
                    }
                    break;
                case "BackUp-Suspen":
                    // Create an object of JFileChooser class
                    
                    
                    // If the user selects a file
                    
                    
                    
                    try {
                        long startTime = System.nanoTime();
                        ArrayList<String> alr = new ArrayList<>();
                    String input =t.getText();
                    input = input.trim();
                    String qq="";
                    
                    // For loop for iterating over the List
                    
                    
                    String[] lines = input.split("\\r?\\n");
                    for (String line : lines) {
                       // System.out.println(line);
                        if(find("^\\d{9,20}$",line)){
                            alr.add(line);}
                        
                    }
                    
                    
                    String text = "";
                    String textR = "";
                    int lineNumber;
                    ArrayList<String> filenames = new ArrayList<>();
                    ArrayList<String> fileout = new ArrayList<>();
                    ArrayList<String> fileout1 = new ArrayList<>();
                    File directoryPath = new File("BUP");
                    
                    //List all files and directories
                   // System.out.println("------------All files------------");
                    for (File file : directoryPath.listFiles()) {
                        
                        filenames.add(file.getName());
                        
                    }
                    
                    
                    
                    
                  
                    for (int i = 0; i <  filenames.size(); i++){
                        ArrayList<String> alro = new ArrayList<>();
                        
                        for (int k = 0; k < alr.size(); k++){
                            
                            try {
                                
                                
                                
                                String[]  l =  (findLine(alr.get(k),"BUP\\"+filenames.get(i)));
                                if(l[1]!=null){
                                   // fileout.add("\n-----------\n"+l[1]+"\n---------------------------------------------------------\n");
                                    //fileout.add(l[0]);
                                    fileout1.add(l[1]+"="+l[0]);
                                    alro.add(alr.get(k));
                                }
                                
                             
                                
                            } catch (IOException ex) {
                                Logger.getLogger(Rusum.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                        
                        
                             
                         
                           
                        
                        
                        alr.removeAll(alro);
                        
                        
                    }
                    
                       Collections.sort(fileout1);
                          for (String line : fileout1) {
                           
                           
                                fileout.add("\n~~~~~~~~~~~~~~~~~~~~~\n"+realfind("BUP.*\\=",line)+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                                fileout.add(realfind("ip-host description.*",line));
                                
                        }
                    
                    ArrayList<String> newfileout = new ArrayList<>();
                    fileout.removeAll(Collections.singletonList(null));
                    
                    
                    for (int i = 0; i < fileout.size(); i++){
                        newfileout.add(fileout.get(i).trim());}
                    //System.out.println("newModified List: " + newfileout);
                    
                    List<String> newList = newfileout.stream()
                            .distinct()
                            .collect(Collectors.toList());
                    
                    //System.out.println("ArrayList with duplicates removed: "
                      //      + newList);
                      int count=0;
                    
                    for (int i = 0; i < newList.size(); i++) {
                        //System.out.println("yonau");
                        String  imput1 = newList.get(i).replace(",","");
                        String imput2 = imput1.replace("|", "");
                        String  imput3 = imput2.replace("@", "");
                        String imput4 = imput3.replace("$", "");
                        String imput5 = imput4.replace("/", "-");
                        String imput51 = imput5.replace(":","");
                        String imput61 = imput51.replace("*", "");
                        String  imput6 = imput61.replace("+", "");
                        String imput62 = imput6.replace(">", "");
                        String imput63 = imput62.replace("<", "");
                        
                        
                        String imput7 = imput63.replace("[", "");
                        String imput8 = imput7.replace("]","" );
                        String imput9 = imput8.replace("%", "");
                        String imput10 = imput9.replace("?", "");
                        String imput11 = imput10.replace(";", "");
                        String imput12 = imput11.replace("#", "");
                        String imput13 = imput12.replace("!", "");
                        String imput14 = imput13.replace("{", "");
                        String imput15 = imput14.replace("}", "");
                        String imput151 = imput15.replace("(", "");
                        String imput152 = imput151.replace(")", "");
                        String imput16 = imput152.replace("&", "");
                        String imput17 = imput16.replace("^", "");
                        String imput18 = imput17.replace("_", "-");
                        //System.out.println(imput18);
                        
                        
                        Date date2 = new Date();
SimpleDateFormat DateFor = new SimpleDateFormat("ddMMMyy");
String stringDate = DateFor.format(date2);
//System.out.println("Date Format with MM/dd/yyyy : "+stringDate);

///remaning same case sdat 
if ("sec-vlan".equals(realfind("sec-vlan",imput18))){
    if(find("[bBvV\\-,\\/_=]\\d{3,4}",imput18)){
        imput18=sub("[bBvV\\-,\\/_=]\\d{3,4}","",imput18);
    }
}
  if(!find("[bBvV\\-,\\/_=]\\d{3,4}",imput18)){
      
         if(find("[a-zA-Z\\-\\_=,.]\\d{1,2}[a-zA-Z]{0,4}\\d{0,2}\\-\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,2}", imput18)){
             
                 String jj=realfind("[a-zA-Z\\-\\_=,.]\\d{1,2}[a-zA-Z]{0,4}\\d{0,2}\\-\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,2}",imput18);
            char firstCharacter = jj.charAt(0);
      imput18=sub("[a-zA-Z\\-\\_=,.]\\d{1,2}[a-zA-Z]{0,4}\\d{0,2}\\-\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,2}",firstCharacter+stringDate, imput18);
     }
   
    else if(find("\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,2}",imput18)){
        
    imput18=sub("\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,2}",stringDate,imput18);}
     else if(find("\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",imput18)){
           
     imput18=sub("\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",stringDate,imput18);
     }
                 
   if(!find("\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,2}",imput18)&&!find("\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",imput18)){
       
       String rt= realfind("\\d{9,16}.*?\\s",imput18);
        String rt2=rt+"-"+stringDate;
        rt2=  rt2.replaceAll("\\s+", "");
        rt2=rt2+" ";
        
          imput18=sub("\\d{9,16}.*?\\s",rt2,imput18);
        // System.out.println(imput18);
     }
                              }    
     if(find("\\d{0,2}(Augest|January|February|March|April|May|June|July|September|October|November|December)\\d{1,2}",imput18))  {
      
          imput18=sub("\\d{0,2}(Augest|January|February|March|April|May|June|July|September|October|November|December)\\d{1,2}",stringDate,imput18);
          
      }
     
     /*
     
                       */ 
                        String imput20="";
    String imput21="";
     String imput25=""; 

     imput20 = realfind("\\D\\d{1,2}[a-zA-Z]{2,4}\\d{1,2}",imput18); 
      imput25 = realfind("\\D\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",imput18);
     if(find("^-",imput20)||find("^-",imput25))
    {
        if(find("^-",imput20)){
   imput21= imput20;
   
    }else{
       imput21= imput25; 
        
        }
        
     } else {
         String first = realfind("^\\w",imput20);
        String first2 = realfind("^\\w",imput25);
         imput20 = realfind("\\d{1,2}[a-zA-Z]{2,4}\\d{1,2}",imput20);
       //  System.out.println("20 is"+imput20);
   
         
         imput25 = realfind("\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",imput25);
         
         
         
         if("".equals(imput20)&&!"".equals(imput25)){
              
            //  System.out.println("f2 is"+ first2);
             imput21="-"+imput25;
             imput25=sub( "\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",first2+imput21,imput25);
             imput18=sub( "\\D\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",imput25,imput18);
             
         //    System.out.println("bhbhbh"+imput21);
             
         } else if("".equals(imput25)&&"".equals(imput20)){
             //System.out.println(imput21);
         }else{
            
             imput21="-"+imput20;
              
                  imput20=sub( "\\d{1,2}[a-zA-Z]{2,4}\\d{2}",first+imput21,imput20);
             imput18=sub( "\\D\\d{1,2}[a-zA-Z]{2,4}\\d{2}",imput20,imput18);
             
             //System.out.println(imput21);
         }                       }
           if(!find("\\d{10,13}-",imput18))  
   {
     String imput22=realfind("\\d{9,13}",imput18);
     //System.out.println("22 is "+ imput22);
      //System.out.println("112 is "+ imput18);
     
                             String imput23=imput22+"-";
                             
                            imput18=sub("\\d{10,13}",imput23,imput18);
     }
            imput18=sub("\\-\\-+","-",imput18); 
                     //System.out.println("18 is "+ imput18);
                        
                            
                        
                        String xsec  ="";
                        String xch  ="";
                        String yph  ="";
                       String yph1  ="";
                        String vv1  ="";
                        String chj  ="";
                        int ag;
                        String ypo  ="";
                        String removesec  ="";
                        String rsec  ="";
                        String ssec  ="";
                        String z ="";
                        String date ="";
                        int size ;
                        String stri ="";
                        String strii ="";
                        String ypu ="";
                        String ffinal ="";
                        String ffinals ="";
                        String ypht ="";
                        String pbr ="";
                        String vxch ="";
                        String vxch2 ="";
                        String vrsec ="";
                        String vsec ="";
                        
                        
                        
                        final String regex = "\\d{9,16}+\\-{0,2}\\.{0,2}[a-zA-Z]{0,1}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\d{0,3}\\-{0,1}\\w{0,5}\\-{0,1}\\d{0,3}\\-{0,1}\\-{0,1}\\_{0,1}\\w{0,1}\\d{3,4}";
                        final String regexsup =     "\\d{9,16}+\\-{0,2}\\.{0,2}[a-zA-Z]{0,1}\\w{0,15}-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}-{0,2}\\.{0,2}\\w{0,15}\\.{0,2}\\-{0,2}\\d{0,3}\\-{0,1}\\w{0,5}\\-{0,1}\\d{0,3}\\-{0,1}";
                        
                        xsec =realfind("sec-vlan\\s\\d{2,4}",imput18);
                        xsec = xsec.trim();
                        //System.out.println("xsec"+xsec);
                        
                        xch =realfind("sec-vlan",imput18);
                        xch = xch.trim();
                        
                        //System.out.println("xch"+xch);
                        yph =realfind(regexsup,imput18);
                        yph = yph.trim();
                       // System.out.println("yph"+yph);
                        
                        yph1 =realfind(regex,imput18);
                        yph1 = yph1.trim();
                        //System.out.println("yph1"+yph1);
                        
                        
                        
                        
                        if("".equals(yph1)||true!=find("^ip-host description.*?\\d+(M|K)[^ ]*?$",imput18)){ag=0;}else{
                            vv1 = yph1.substring(yph1.length() - 4);
                          //  System.out.println("vv1"+vv1);
                            chj = realfind("^.*\\d{3,4}$",vv1);
                            chj = chj.trim();
                            //System.out.println("chj"+chj);
                            ag =chj.length();
                            
                            
                        }
                        //System.out.println("vv1"+vv1);
                        
                        
                        
                        
                        ypo=realfind("\\d{9,15}",imput18);
                        
                        if ("sec-vlan".equals(xch)){
    
                 yph =realfind(regexsup,imput18);
                        yph = yph.trim();
                            
                            removesec = sub("sec-vlan\\s\\d{2,4}","",  imput18);
                          //  System.out.println("removesec "+removesec);
                            
                            if (!"".equals(yph)){
                                rsec = sub("sec-vlan","b", xsec);
                                ssec=sub("\\s","", rsec);
                                z =  yph + ssec;
                                
                                
                                
                                
                                if (z.length()>31){
                if (!"".equals(imput20)||!"".equals(imput25)){
                 String st=sub(imput21,"",yph);
                
                
               String   sr=st.substring(0,17);
                 ypu = sr+ imput21;
                 // System.out.println("ypu"+ypu);
                 z =  ypu+ ssec;
                 
                }
                else {
                    //System.out.println("yppppppppppppppppppppppppppppppppppppppppppppppppppp");
                date = yph.substring(yph.length() - 7); 
                
                size = date.length();
                
                stri=yph.substring(0,17);
                
                strii = stri + "-";
                
                
                ypu = strii + date ;
                
                
                z =  ypu+ ssec;
                }
            }              
                                
                                
                                ffinal = sub(yph, z,removesec);
                                ffinals = sub("\\s\\s+" , " ", ffinal);
                                  ffinals=sub("--","-",ffinals);
                                ypht=realfind("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}" ,ffinals);
                                ypht = ypht.trim();
                                count++;
                                pbr = "no ip-host "+ypht+"\ny";
                                qq=qq+"\n"+pbr+"\n"+ffinals;
                                
                                
                            }
                        }
                        else if( find("^ip-host description.*?\\d+(M|K)[^ ]*?$",imput18)==true && !"sec-vlan".equals(xch) && ag ==0) {
                            //////
                            
               
                            ////
                            vxch = realfind("vlan\\s\\d{4}",imput18);
                            size = vxch.length();
                            
                            vxch2 = vxch;
                            //System.out.println("vxchvxchvxch222222222"+vxch2);
                            
                            vxch=vxch.substring(0,vxch.length() - 2);
                            
                            
                            //System.out.println("vxchvxchvxch"+vxch);
                            removesec = sub("vlan\\s\\d{2,4}",vxch,  imput18);
                            
                            yph = realfind(regexsup,imput18);
                            yph = yph.trim();
                            if (!"".equals(yph)){
                                vrsec = sub("vlan","b",vxch2);
                                vsec=sub("\\s", "", vrsec);
                                z =  yph + vsec;
                                
                  if (z.length()>31){
                if (!"".equals(imput20)||!"".equals(imput25)){
                 String st=sub(imput21,"",yph);
            
                
               String   sr=st.substring(0,17);
                 ypu = sr+ imput21;
                  //System.out.println("ypu"+ypu);
                 z =  ypu+ vsec;
                 
                }
                else {
                date = yph.substring(yph.length() - 7); 
                
                size = date.length();
                
                stri=yph.substring(0,17);
                
                strii = stri + "-";
                
                
                ypu = strii + date ;
                
                
                z =  ypu+ vsec;
                }
            }      
                                
                                ffinal = sub(yph, z,removesec);
                                ffinals = sub("\\s\\s+" , " ", ffinal);
                                
                                ypht=realfind("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}" ,ffinals);
                                ypht = ypht.trim();
                                count++;
                                ffinals=sub("--","-",ffinals);
                                pbr = "no ip-host "+ypht+"\ny";
                                qq=qq+"\n"+pbr+"\n"+ffinals;
                                
                                
                                
                                
                                
                            }
                            
                            
                        }
                        else if(find("^ip-host description.*?\\d+(M|K)[^ ]*?$",imput18))  {
                            
                                    
                             if(find("[bBvV\\-,\\/_=]\\d{3,4}",imput18)){
                String bar= realfind("[bBvV\\-,\\/_=]\\d{3,4}",imput18); 
        
            
          if(find("[a-zA-Z\\-\\_=,.]\\d{1,2}[a-zA-Z]{0,4}\\d{0,2}\\-\\d{1,2}[a-zA-Z]{2,7}\\d{1,7}", imput18)){
              
         
             
                 String jj=realfind("[a-zA-Z\\-\\_=,.]\\d{1,2}[a-zA-Z]{0,4}\\d{0,2}\\-\\d{1,2}[a-zA-Z]{2,7}\\d{1,7}",imput18);
            char firstCharacter = jj.charAt(0);
     
              
     imput18=sub("[a-zA-Z\\-\\_=,.]\\d{1,2}[a-zA-Z]{0,4}\\d{0,2}\\-\\d{1,2}[a-zA-Z]{2,7}\\d{1,7}",firstCharacter+stringDate, imput18);
     }
     
   else if(find("\\d{1,2}[a-zA-Z]{2,7}\\d{1,7}",imput18)){
          imput18 = sub("[bBvV\\-,\\/_=]\\d{3,4}" , "",imput18); 
    imput18=sub("\\d{1,2}[a-zA-Z]{2,7}\\d{1,7}",stringDate+bar,imput18);}
     else if(find("\\d{1,2}\\-\\d{1,2}\\-\\d{1,7}",imput18)){
            imput18 = sub("[bBvV\\-,\\/_=]\\d{3,4}" , "",imput18);
     imput18=sub("\\d{1,2}\\-\\d{1,2}\\-\\d{1,7}",stringDate+bar,imput18);
     }
                 
   if(!find("\\d{1,2}[a-zA-Z]{2,7}\\d{1,7}",imput18)&&!find("\\d{1,2}\\-\\d{1,2}\\-\\d{1,7}",imput18)){
       imput18 = sub("[bBvV\\-,\\/_=]\\d{3,4}" , "",imput18); 
       String rt= realfind("\\d{9,16}.*?\\s",imput18);
        String rt2=rt+"-"+stringDate+bar;
        rt2=  rt2.replaceAll("\\s+", "");
        rt2=rt2+" ";
        
          imput18=sub("\\d{9,16}.*?\\s",rt2,imput18);
        // System.out.println(imput18);
     }
                              }                    
                            
                            ypht="";
                            final String regex8= "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
                            
                            
                            final Pattern pattern8 = Pattern.compile(regex8, Pattern.MULTILINE);
                            final Matcher matcher8 = pattern8.matcher(imput18);
                            
                            while (matcher8.find()) {
                              //  System.out.println("Full match: " + matcher8.group(0));
                                
                                ypht = ypht + matcher8.group(0);
                                
                                //System.out.println(ypht);
                                
                                
                            }
                            if(!"".equals(ypht)){
                                ///////////////////
                                 yph1 =realfind(regex,imput18);
                        yph1 = yph1.trim();
                                
                                if (yph1.length()>31){
                if (!"".equals(imput20)||!"".equals(imput25)){
                 
                 String dg = yph1.substring(yph1.length() - 15); 
                 
               String   sr=yph1.substring(0,15);
                 ypu = sr+"-"+dg ;
                 // System.out.println("ypu"+ypu);
                imput18 =sub(yph1,ypu,imput18);
                 
                }
                else
                    
                {
                    String dg = yph1.substring(yph1.length() - 15); 
                 
               String   sr=yph1.substring(0,15);
                 ypu = sr+"-"+dg ;
                 // System.out.println("ypu"+ypu);
                imput18 =sub(yph1,ypu,imput18);
                
                }
                                }
                                count++;
                                imput18=sub("--","-",imput18);
                                pbr = "\nno ip-host "+ypht+"\ny"+'\n'+imput18;
                            }else
                            {
                                pbr = '\n'+imput18+'\n';
                            }
                            
                            
                            qq = qq + pbr;
                            
                            
                        }
                        else {
                            qq=qq+'\n'+imput18+'\n';
                            //System.out.println("original out put file");
                        }
                        
                        
                        
                        
                        
                        
                    }
                    
                    
                  
                        
                        long endTime = System.nanoTime();
                        
                long timeElapsed = endTime - startTime;
                
                        t.setText(input+"\n=======================================\n"+qq+"\n================Execution time ===============\n"+timeElapsed / 1000000000+"sec"+"\n Number of successful oppretion \t"+ count);
                   
                    
                    }
                    catch (Exception evt) {
                        JOptionPane.showMessageDialog(f, evt.getMessage());
                    }
                    break;
                case "Suspention":
                  
                    try {
                        // String
                         long startTime = System.nanoTime();
                        String qq="";
                        ArrayList<String> alr = new ArrayList<>();
                        ArrayList<String> alro = new ArrayList<>();
                        
                        
                        String input =t.getText();
                        input = input.trim();
                        
                        
                        // For loop for iterating over the List
                        
                        
                        String[] lines = input.split("\\r?\\n");
                        for (String line : lines) {
                      //      System.out.println(line);
                            if(find("^ip-host description.*?\\d+(M|K)[^ ]*?$",line)){
                                alr.add(line);}
                            
                        }
                        
                        
//opreation
for (int i = 0; i < alr.size(); i++) {
   // System.out.println("yonau");
    String  imput1 = alr.get(i).replace(",","");
    
    String imput2 = imput1.replace("|", "");
    String  imput3 = imput2.replace("@", "");
    String imput4 = imput3.replace("$", "");
    String imput5 = imput4.replace("/", "-");
    String imput51 = imput5.replace(":","");
    String imput61 = imput51.replace("*", "");
    String  imput6 = imput61.replace("+", "");
    String imput62 = imput6.replace(">", "");
    String imput63 = imput62.replace("<", "");
    
    
    String imput7 = imput63.replace("[", "");
    String imput8 = imput7.replace("]","" );
    String imput9 = imput8.replace("%", "");
    String imput10 = imput9.replace("?", "");
    String imput11 = imput10.replace(";", "");
    String imput12 = imput11.replace("#", "");
    String imput13 = imput12.replace("!", "");
    String imput14 = imput13.replace("{", "");
    String imput15 = imput14.replace("}", "");
    String imput151 = imput15.replace("(", "");
    String imput152 = imput151.replace(")", "");
    String imput16 = imput152.replace("&", "");
    String imput17 = imput16.replace("^", "");
    String imput18 = imput17.replace("_", "-");
    //System.out.println(imput18);
    ////////////////////////
    
     Date date2 = new Date();
SimpleDateFormat DateFor = new SimpleDateFormat("ddMMMyy");
String stringDate = DateFor.format(date2);
//System.out.println("Date Format with MM/dd/yyyy : "+stringDate);
     
if(!find("[bBvV\\-,\\/_=]\\d{3,4}",imput18)){
      
         if(find("[a-zA-Z\\-\\_=,.]\\d{1,2}[a-zA-Z]{0,4}\\d{0,2}\\-\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,2}", imput18)){
             
               String jj=realfind("[a-zA-Z\\-\\_=,.]\\d{1,2}[a-zA-Z]{0,4}\\d{0,2}\\-\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,2}",imput18);
            char firstCharacter = jj.charAt(0);
      imput18=sub("[a-zA-Z\\-\\_=,.]\\d{1,2}[a-zA-Z]{0,4}\\d{0,2}\\-\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,2}",firstCharacter+stringDate, imput18);
     

     }
   
    else if(find("\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,2}",imput18)){
        
    imput18=sub("\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,2}",stringDate,imput18);}
     else if(find("\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",imput18)){
           
     imput18=sub("\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",stringDate,imput18);
     }
                 
   if(!find("\\d{1,2}[a-zA-Z]{2,3}[^bBvV\\-.,\\/_=\\d\\s]{0,4}\\d{1,2}",imput18)&&!find("\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",imput18)){
       
       String rt= realfind("\\d{9,16}.*?\\s",imput18);
        String rt2=rt+"-"+stringDate;
        rt2=  rt2.replaceAll("\\s+", "");
        rt2=rt2+" ";
        
          imput18=sub("\\d{9,16}.*?\\s",rt2,imput18);
        // System.out.println(imput18);
     }
                              }    
     if(find("\\d{0,2}(Augest|January|February|March|April|May|June|July|September|October|November|December)\\d{1,2}",imput18))  {
      
          imput18=sub("\\d{0,2}(Augest|January|February|March|April|May|June|July|September|October|November|December)\\d{1,2}",stringDate,imput18);
          
      }
     
     
    String imput20="";
    String imput21="";
     String imput25=""; 

     imput20 = realfind("\\D\\d{1,2}[a-zA-Z]{2,4}\\d{1,2}",imput18); 
      imput25 = realfind("\\D\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",imput18);
     if(find("^-",imput20)||find("^-",imput25))
    {
        if(find("^-",imput20)){
   imput21= imput20;
   
    }else{
       imput21= imput25; 
        
        }
        
     } else {
         String first = realfind("^\\w",imput20);
        String first2 = realfind("^\\w",imput25);
         imput20 = realfind("\\d{1,2}[a-zA-Z]{2,4}\\d{1,2}",imput20);
         //System.out.println("20 is"+imput20);
   
         
         imput25 = realfind("\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",imput25);
         
         
         
         if("".equals(imput20)&&!"".equals(imput25)){
              
            //  System.out.println("f2 is"+ first2);
             imput21="-"+imput25;
             imput25=sub( "\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",first2+imput21,imput25);
             imput18=sub( "\\D\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",imput25,imput18);
             
             //System.out.println("bhbhbh"+imput21);
             
         } else if("".equals(imput25)&&"".equals(imput20)){
             //System.out.println(imput21);
         }else{
            
             imput21="-"+imput20;
              
                  imput20=sub( "\\d{1,2}[a-zA-Z]{2,4}\\d{2}",first+imput21,imput20);
             imput18=sub( "\\D\\d{1,2}[a-zA-Z]{2,4}\\d{2}",imput20,imput18);
             
            /// System.out.println(imput21);
         }                       }
           if(!find("\\d{10,13}-",imput18))  
   {
     String imput22=realfind("\\d{9,13}",imput18);
    // System.out.println("22 is "+ imput22);
      //System.out.println("112 is "+ imput18);
     
                             String imput23=imput22+"-";
                             
                            imput18=sub("\\d{10,13}",imput23,imput18);
     }
            imput18=sub("\\-\\-+","-",imput18); 
                 //    System.out.println("18 is "+ imput18);

            //////////////////////////////
            
    ////////////////////////////
    
    String xsec  ="";
    String xch  ="";
    String yph  ="";
    String yph1  ="";
    String vv1  ="";
    String chj  ="";
    int ag;
    String ypo  ="";
    String removesec  ="";
    String rsec  ="";
    String ssec  ="";
    String z ="";
    String date ="";
    int size ;
    String stri ="";
    String strii ="";
    String ypu ="";
    String ffinal ="";
    String ffinals ="";
    String ypht ="";
    String pbr ="";
    String vxch ="";
    String vxch2 ="";
    String vrsec ="";
    String vsec ="";
    
    
    
    final String regex = "\\d{9,16}+\\-{0,2}\\.{0,2}[a-zA-Z]{0,1}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\d{0,3}\\-{0,1}\\w{0,5}\\-{0,1}\\d{0,3}\\-{0,1}\\-{0,1}\\_{0,1}\\w{0,1}\\d{3,4}";
    final String regexsup =     "\\d{9,16}+\\-{0,2}\\.{0,2}[a-zA-Z]{0,1}\\w{0,15}-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}-{0,2}\\.{0,2}\\w{0,15}\\.{0,2}\\-{0,2}\\d{0,3}\\-{0,1}\\w{0,5}\\-{0,1}\\d{0,3}\\-{0,1}";
    
    xsec =realfind("sec-vlan\\s\\d{2,4}",imput18);
    xsec = xsec.trim();
    //System.out.println("xsec"+xsec);
    
    xch =realfind("sec-vlan",imput18);
    xch = xch.trim();
    
    //System.out.println("xch"+xch);
    yph =realfind(regexsup,imput18);
    yph = yph.trim();
    
  
            
   
    //System.out.println("yph"+yph);
    
    yph1 =realfind(regex,imput18);
    yph1 = yph1.trim();
    //System.out.println("yph1"+yph1);
    
    
    
    
    if(!"".equals(yph1)){
        vv1 = yph1.substring(yph1.length() - 4);
      //  System.out.println("vv1"+vv1);
        chj = realfind("^.*\\d{3,4}$",vv1);
        chj = chj.trim();
        //System.out.println("chj"+chj);
        ag =chj.length();
        
        
    }else{ag=0;}
    //System.out.println("vv1"+vv1);
    
    
    
    
    ypo=realfind("\\d{9,15}",imput18);
    
    if ("sec-vlan".equals(xch)){
        
        if(!find("\\d{1,2}[a-zA-Z]{2,4}\\d{1,2}",imput18)&&!find("\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",imput18)){
         String rt= realfind("\\d{9,16}.*?\\s",imput18);
        String rt2=rt+"-"+stringDate;
        
        rt2=  rt2.replaceAll("\\s+", "");
        rt2=rt2+" ";
       
        imput18 =sub("\\d{9,16}.*?\\s",rt2,imput18);
         //System.out.println(imput18);
                              }
                 
         yph =realfind(regexsup,imput18);
         yph = yph.trim();
        removesec = sub("sec-vlan\\s\\d{2,4}","",  imput18);
      //  System.out.println("removesec "+removesec);
        
        if (!"".equals(yph)){
            rsec = sub("sec-vlan","b", xsec);
            ssec=sub("\\s","", rsec);
            z =  yph + ssec;
            
            
            
          if (z.length()>31){
                if (!"".equals(imput20)||!"".equals(imput25)){
                 String st=sub(imput21,"",yph);
               String   sr=st.substring(0,17);
                 ypu = sr+ imput21;
                  //System.out.println("ypu"+ypu);
                 z =  ypu+ ssec;        
                }
                else {
                date = yph.substring(yph.length() - 7);  
                size = date.length();  
                stri=yph.substring(0,17); 
                strii = stri + "-";
                ypu = strii + date ;
                z =  ypu+ ssec;
                }
            }
            
            
            ffinal = sub(yph, z,removesec);
            ffinals = sub("\\s\\s+" , " ", ffinal);
            ypht=realfind("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}" ,ffinals);
            ypht = ypht.trim();
            ffinals=sub("--","-",ffinals);
            pbr = "no ip-host "+ypht+"\ny";
            qq=qq+"\n"+pbr+"\n"+ffinals;
            
            
        }
    }      
    else if( !"sec-vlan".equals(xch) && ag ==0) {
                 if(!find("\\d{1,2}[a-zA-Z]{2,4}\\d{1,2}",imput18)&&!find("\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",imput18)){
         String rt= realfind("\\d{9,16}.*?\\s",imput18);
        String rt2=rt+"-"+stringDate;
        
        rt2=  rt2.replaceAll("\\s+", "");
        rt2=rt2+" ";
       
        imput18 =sub("\\d{9,16}.*?\\s",rt2,imput18);
        // System.out.println(imput18);
                              }
        
        vxch = realfind("vlan\\s\\d{4}",imput18);
        size = vxch.length();
        
        vxch2 = vxch;
       // System.out.println("vxchvxchvxch222222222"+vxch2);
        
        vxch=vxch.substring(0,vxch.length() - 2);
        
        
        //System.out.println("vxchvxchvxch"+vxch);
        removesec = sub("vlan\\s\\d{2,4}",vxch,  imput18);
        
        yph = realfind(regexsup,imput18);
        yph = yph.trim();
        if (!"".equals(yph)){
            vrsec = sub("vlan","b",vxch2);
            vsec=sub("\\s", "", vrsec);
            z =  yph + vsec;
     
           if (z.length()>31){
                if (!"".equals(imput20)||!"".equals(imput25)){
                 String st=sub(imput21,"",yph);
               String   sr=st.substring(0,17);
                 ypu = sr+ imput21;
                  
                 z =  ypu+ vsec;        
                }
                else {
                date = yph.substring(yph.length() - 7);  
                size = date.length();  
                stri=yph.substring(0,17); 
                strii = stri + "-";
                ypu = strii + date ;
                z =  ypu+ vsec;
                 
                }
            }
            
            ffinal = sub(yph, z,removesec);
            ffinals = sub("\\s\\s+" , " ", ffinal);
            
            ypht=realfind("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}" ,ffinals);
            ypht = ypht.trim();
            ffinals=sub("--","-",ffinals);
            pbr = "no ip-host "+ypht+"\ny";
            qq=qq+"\n"+pbr+"\n"+ffinals;
            
            
            
            
            
        }
        
        
    }
    
    
    
    
    
    
}


                        long endTime = System.nanoTime();
                        
                long timeElapsed = endTime - startTime;
                
                        t.setText(input+"\n=======================================\n"+qq+"\n================Excustion time ===============\n"+timeElapsed / 1000000000+"sec");
                   

                    }
                    catch (Exception evt) {
                        JOptionPane.showMessageDialog(f, evt.getMessage());
                    }
                    break;
                case "VPN-Resum":
                    {
                                   long startTime = System.nanoTime();
                        ArrayList<String> alr = new ArrayList<>();
                        String input =t.getText();
                        input = input.trim();
                        String qq="";
                        
                        // For loop for iterating over the List
                        String[] lines = input.split("\\r?\\n");
                        for (String line : lines) {
                        //    System.out.println(line);
                            if(find("^\\d{9,20}$",line)){
                                alr.add(line);}
                            
                        }
                        int count=0;
                        int count2=0;
                        String text = "";
                        String textR = "";
                        int lineNumber;
                        ArrayList<String> filenames = new ArrayList<>();
                        ArrayList<String> fileout = new ArrayList<>();
                        ArrayList<String> fileout2 = new ArrayList<>();
                        File directoryPath = new File("BUP");
                        //List all files and directories
                        //System.out.println("------------All files------------");
                        for (File file : directoryPath.listFiles()) {
                            
                            filenames.add(file.getName());
                            
                        }
                        //System.out.println(filenames);
                        String x ;
                        for (int i = 0; i <  filenames.size(); i++){
                             ArrayList<String> alro = new ArrayList<>();
                            for (int k = 0; k < alr.size(); k++){ 
                                
                                try {
                                    
                                    
                                    
                                    String[]  l =  (VfindLine(alr.get(k),"BUP\\"+filenames.get(i)));
                                    
                                    if("T".equals(l[3])){
                                        if(l[1]!=null){
                                            fileout2.add("\n~~~~~~~~~~~~~~~~~~~~~~~~\n"+l[1]+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                                            fileout2.add(l[2]);
                                            alro.add(alr.get(k));
                                            // fileout2.add(l[0]);
                                            
                                            /////////
                                        }
                                        
                                        
                                    }
                                    else {
                                        
                                        if(l[1]!=null){
                                            if(l[1]!=null){
                                                fileout.add("\n~~~~~~~~~~~~~~~~~~~~\n"+l[1]+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");}
                                            fileout.add(l[2]);
                                            alro.add(alr.get(k));
                                            //fileout.add(l[0]);
                                            
                                            /////////
                                        }
                                        
                                    }
                                    
                                    
                          //          System.out.println("l[1]"+l[1]);
                                    
                                    // fileout.add(filenames.get(i));
                                    
                                } catch (IOException ex) {
                                    Logger.getLogger(Rusum.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                            }
                            
                            
                        alr.removeAll(alro);    
                            
                        }         
                        ArrayList<String> newfileout2 = new ArrayList<>();
                        ArrayList<String> newfileout = new ArrayList<>();
                        fileout.removeAll(Collections.singletonList(null));
                        fileout2.removeAll(Collections.singletonList(null));
                        for (int i = 0; i < fileout.size(); i++){
                            newfileout.add(fileout.get(i).trim());}
                        for (int i = 0; i < fileout2.size(); i++){
                            newfileout2.add(fileout2.get(i).trim());}
                        //System.out.println("newModified List: " + newfileout);
                        List<String> newList = newfileout.stream()
                                .distinct()
                                .collect(Collectors.toList());
                        List<String> newList2 = newfileout2.stream()
                                .distinct()
                                .collect(Collectors.toList());
                        //System.out.println("ArrayList with duplicates removed: "
                          //      + newList);
                        //System.out.println("newModified List: " + newfileout);
                        for (int i = 0; i < newList.size(); i++) {
                            if(newList.get(i).contains("interface")){
                                count++;
                                qq=qq+"\n"+ newList.get(i)+"\nno shut"+"\nexit";
                            }
                            else if(newList.get(i).contains("ip-host description")){}
                            else if(newList.get(i).contains("ip host")){ count2++;}
                            else{
                                
                                 
                                qq=qq+"\n"+ newList.get(i);
                            }
                            
                            
                            
                            
                        }              qq=qq+"\n===========VRRP==========VRRP=============VRRP==================";
                        for (int i = 0; i < newList2.size(); i++) {
                            
                            if(newList2.get(i).contains("interface")){ 
                                count++;
                                qq=qq+"\n"+ newList2.get(i)+"\nno shut"+"\nexit";
                            }
                             else if(newList2.get(i).contains("ip-host description")){}
                            else if(newList2.get(i).contains("ip host")){ count2++;}
                            else{
                              
                                qq=qq+"\n"+ newList2.get(i);
                            }
                            
                            
                        }            
            
                        long endTime = System.nanoTime();
                        
                long timeElapsed = endTime - startTime;
                
                        t.setText(input+"\n=======================================\n"+qq+"\n================Execution time ===============\n"+timeElapsed / 1000000000+"sec"+"\n Number of successful VPN oppretion \t"+ count+"\n Number of left BRASS \t"+ count2);
                   
                      
                        break;
                    }
                case "VPN-Suspen":
                    {
                          long startTime = System.nanoTime();
                        ArrayList<String> alr = new ArrayList<>();
                        String input =t.getText();
                        input = input.trim();
                        String qq="";
                        
                        // For loop for iterating over the List
                        String[] lines = input.split("\\r?\\n");
                        for (String line : lines) {
                            //System.out.println(line);
                            if(find("^\\d{9,20}$",line)){
                                alr.add(line);}
                            
                        }
                        int count=0;
                        int count2=0;
                        String text = "";
                        String textR = "";
                        int lineNumber;
                        ArrayList<String> filenames = new ArrayList<>();
                        ArrayList<String> fileout = new ArrayList<>();
                        ArrayList<String> fileout2 = new ArrayList<>();
                        File directoryPath = new File("BUP");
                       
                        for (File file : directoryPath.listFiles()) {
                            
                            filenames.add(file.getName());
                            
                        }
                        
                        String x ;
                        for (int i = 0; i <  filenames.size(); i++){
                            ArrayList<String> alro = new ArrayList<>();
                            for (int k = 0; k < alr.size(); k++){
                                
                                try {
                                    
                                    
                                    
                                    String[]  l =  (VfindLine(alr.get(k),"BUP\\"+filenames.get(i)));
                                    
                                    if("T".equals(l[3])){
                                        if(l[1]!=null){
                                            fileout2.add("\n~~~~~~~~~~~~~~~~~~~~~\n"+l[1]+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                                            fileout2.add(l[2]);
                                              alro.add(alr.get(k));
                                           
                                        }
                                        
                                        
                                    }
                                    else {
                                        
                                        if(l[1]!=null){
                                            if(l[1]!=null){
                                                fileout.add("\n~~~~~~~~~~~~~~~~~~~~\n"+l[1]+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");}
                                            fileout.add(l[2]);
                                            alro.add(alr.get(k));
                                           
                                        }
                                        
                                    }
                                    
                                    
                     
                                } catch (IOException ex) {
                                    Logger.getLogger(Rusum.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                            }
                            
                            alr.removeAll(alro);
                            
                            
                        }           
                        ArrayList<String> newfileout2 = new ArrayList<>();
                        ArrayList<String> newfileout = new ArrayList<>();
                        fileout.removeAll(Collections.singletonList(null));
                        fileout2.removeAll(Collections.singletonList(null));
                        for (int i = 0; i < fileout.size(); i++){
                            newfileout.add(fileout.get(i).trim());}
                        for (int i = 0; i < fileout2.size(); i++){
                            newfileout2.add(fileout2.get(i).trim());}
                        //System.out.println("newModified List: " + newfileout);
                        List<String> newList = newfileout.stream()
                                .distinct()
                                .collect(Collectors.toList());
                        List<String> newList2 = newfileout2.stream()
                                .distinct()
                                .collect(Collectors.toList());
                        //System.out.println("ArrayList with duplicates removed: "
                          //      + newList);
                        //System.out.println("newModified List: " + newfileout);
                        for (int i = 0; i < newList.size(); i++) {
                            if(newList.get(i).contains("interface")){
                                count++;
                                qq=qq+"\n"+ newList.get(i)+"\nshut"+"\nexit";
                            }
                            else if(newList.get(i).contains("ip-host description")){}
                            else if(newList.get(i).contains("ip host")){ count2++;}
                            else{
                               
                                qq=qq+"\n"+ newList.get(i);
                            }
                            
                            
                            
                            
                        }              qq=qq+"\n========VRRP=============VRRP=============VRRP===============";
                        for (int i = 0; i < newList2.size(); i++) {
                            
                            if(newList2.get(i).contains("interface")){
                                count++;
                                qq=qq+"\n"+ newList2.get(i)+"\nshut"+"\nexit";
                            }
                             else if(newList2.get(i).contains("ip-host description")){}
                            else if(newList2.get(i).contains("ip host")){ count2++;}
                            else{
                             
                                qq=qq+"\n"+ newList2.get(i);
                            }
                            
                            
                        }             
                        
                        
                         
                        long endTime = System.nanoTime();
                        
                long timeElapsed = endTime - startTime;
                
                        t.setText(input+"\n=======================================\n"+qq+"\n================Execution time ===============\n"+timeElapsed / 100000000+"sec"+"\n Number of successful VPN oppretion \t"+ count+"\n Number of left BRASS \t"+ count2);
                   
                
                        break;
                    }
                default:
                    JOptionPane.showMessageDialog(f, "the user cancelled the operation");
                    break;
            }
		
		
	}
       
                
                
        
        
    public String realfind (String x ,String y){
    final String regex = x;
     String ypo="";
        final String string = y;
        
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);
        
        while (matcher.find()) {
           // System.out.println("Full match: " + matcher.group(0));
           ypo =  matcher.group(0); 
           
    } 
    
     return ypo;
    }  
    public   String sub(String x  ,String y,String z ){
    final String regex = x;
        final String string = z;
        final String subst = y;
        
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);
        
        // The substituted value will be contained in the result variable
        final String result = matcher.replaceAll(subst);
        
        //System.out.println("Substitution result: " + result);
    return  result;
    }
    
    public  boolean find  (String x,String row){
     final String regex = x;
             final String stringt = row;
        final Pattern patternt = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matchert = patternt.matcher(stringt);
              
            return matchert.find();
        }
    public  String[] findLine(String searchWord, String filename) throws IOException
 {
     
    String[] ans = new String[2];
     
     String replace="";
    
    
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            
            while( (line = br.readLine( )) != null){
                
                  if (line.contains("interface vbui"))
                {
                replace = line.replace("interface", "");
                    
                    
                    
                    
                }
                  
                  else if(line.contains("BUP")){
                      replace = line.replace("BUP", "");
                      
                  }
                if (line.contains(searchWord))
                {
                   
                    
                    ans[0]=line;
                    ans[1]=filename+replace;
                    
                 break;
                }
            }
            
        }
        
        return ans;
 } 
    
    public  ArrayList<String> findLine2( String filename) throws IOException
 {
    

   
     ArrayList<String> alro = new ArrayList<>(); 
     ArrayList<String> alro2 = new ArrayList<>(); 
     ArrayList<String> alro3 = new ArrayList<>();
     
     String replace="";
    
        
    
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            
            while( (line = br.readLine( )) != null){
                
            alro.add(realfind("\\d{9,15}",line));
           alro .removeIf(String::isEmpty); 
           
                 
               
            }
           
         ///////////
         
        Set<String> store = new HashSet<>();

        alro.stream().filter((name) -> (store.add(name) == false)).forEachOrdered((name) -> {
            alro2.add(name);
         }); //////////////
         
         
            
        }
          
         alro3.addAll(alro2);
          
        for(String searchWord : alro2){
        try (BufferedReader br2 = new BufferedReader(new FileReader(filename))) {
            String line;
            
            while( (line = br2.readLine( )) != null){
                
                  if (line.contains("interface vbui"))
                {
                replace = line.replace("interface", "");
                    
                    
                    
                    
                }
                if (line.contains(searchWord))
                {
                   
                   
                    alro3.add(filename+replace+"="+line);
                     
                    
                 
                }
                }
            }
            
        }
        
                
      
        
        return alro3;
 }   
    
     
      public  String[] VfindLine(String searchWord, String filename) throws IOException
 {
     
    String[] ans = new String[4];
     
     ArrayList<String> add1 = new ArrayList<>();
boolean ans2=false ;
     
          
  
    
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
             out:
            
             while( (line = br.readLine( )) != null)
            {
            line=line.trim();
              add1.add(line);
                if (line.contains(searchWord))
                { 
                    int x=add1.indexOf(line);
                    ans[0]=line;
                    ans[1]=filename;
                    ans[2]=add1.get(x-1);
                 while( (line = br.readLine( )) != null){
                    
                 if (line.contains(ans[2])){
                     line = br.readLine( );
                 if(line.contains("vrrp")){
                 ans2=true;
                 break out;
                 }
                 }    
                 }                
                   
 
                    
                }
            }
             
                    
        if (ans2)
            ans[3]="T";
        else
            ans[3]="F";
             
            
        }
        
        return ans;
 }
    
    
    
	// Main class
	public static void main(String args[])
	{
            
            
		Rusum e = new Rusum();
                
                

        //Popup menu Code
        JPopupMenu jPopupMenu=new JPopupMenu("Edit");

        JMenuItem cut=new JMenuItem("Cut");
        JMenuItem copy=new JMenuItem("Copy");
        JMenuItem paste=new JMenuItem("Paste");

        jPopupMenu.add(cut);
        jPopupMenu.add(copy);
        jPopupMenu.add(paste);
        //End Popup Menu Code

        f.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if(SwingUtilities.isRightMouseButton(mouseEvent)){
                    jPopupMenu.show(f,mouseEvent.getX(),mouseEvent.getY());
                }
            }
        });

        //End Popup Code
        //Example Popup menu
        //Popup menu Code
        JPopupMenu jPopupMenu2=new JPopupMenu("Edit");

        JMenuItem cut2=new JMenuItem("Cut");
        JMenuItem copy2=new JMenuItem("Copy");
        JMenuItem paste2=new JMenuItem("Paste");

        jPopupMenu2.add(cut2);
        jPopupMenu2.add(copy2);
        jPopupMenu2.add(paste2);
        //End Popup Menu Code

        t.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if(SwingUtilities.isRightMouseButton(mouseEvent)){
                    jPopupMenu2.show(t,mouseEvent.getX(),mouseEvent.getY());
                }
            }
        });

        cut2.addActionListener((ActionEvent actionEvent) -> {
            t.cut();
                });

        copy2.addActionListener((ActionEvent actionEvent) -> {
            t.copy();
                });

        paste2.addActionListener((ActionEvent actionEvent) -> {
            t.paste();
                });
                
                
                
	}
}
