package Windowstaskmanager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.peer.TextAreaPeer;


	public class FK extends JFrame{

		

		FK() 
		{	
			this.setTitle("Window Task Manager Developed by FK ");
			this.setSize(600, 650);
			this.setLocation(220,100);
			setExtendedState(JFrame.MAXIMIZED_BOTH); 
				
				final JFileChooser fc = new JFileChooser();
				
				
			 MenuBar  MB = new  MenuBar();	
			 
	         Menu file = new  Menu("File");
	         
	         MenuItem eMenuItem = new  MenuItem("Exit");
	         eMenuItem.addActionListener(new ActionListener() {
	        	 public void actionPerformed(ActionEvent e)
	             {System.exit(DISPOSE_ON_CLOSE);}});
	         
	            MenuItem rMenuItem = new  MenuItem("Run new task");
	            rMenuItem.addActionListener(new ActionListener() {
		        	 public void actionPerformed(ActionEvent e)
		             {	JFrame jfrm = new JFrame();
		             	
		             	jfrm.setTitle("Create New Task");
		             	jfrm.setSize(350, 150);
		             	jfrm.setLocation(253,173);
		             	JPanel jpn = new JPanel();
		             	jfrm.add(jpn);
		             	final JTextField jfld = new JTextField(26);
		             	
		             	JLabel jlb1 = new JLabel("Open:");
		             	jpn.add(jlb1);
		             	jpn.add(jfld);
		             	
		             	JButton jb1 = new JButton("Ok");
		             	jb1.addActionListener(new ActionListener() {
		             		
			   	        	 public void actionPerformed(ActionEvent e)
			   	        	 
			   	             {String getname = jfld.getText();
			   	              String File_Name=getname.replaceAll("\\\\", "\\\\\\\\");
			   	              final String file_Open=File_Name;
			   	             	
			   	             try {File file = new File(file_Open);
			   	             Desktop.getDesktop().open(file);
			   	             System.out.print("tes");
			   	          
									System.exit(DISPOSE_ON_CLOSE);
									
								} catch (IllegalArgumentException  e2) {
									try {
										Runtime.getRuntime().exec(file_Open);
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									e2.printStackTrace();		} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}		}	   	         });
		             	     
		             	JButton jb2 = new JButton("Cancel");
		             	JButton jb3 = new JButton("Browse");
		             	jpn.add(jb1);
		             	jpn.add(jb2);
		             	jpn.add(jb3);
		             	             	
		             	jb3.addActionListener(new ActionListener() {
		   	        	 public void actionPerformed(ActionEvent e)
		   	             {fc.showOpenDialog(getComponent(0));
		   	          
		   	             	jfld.setText( fc.getSelectedFile().getAbsolutePath()); }	});
		             		
		             		
		             	
		            	jfrm.show();
		             }
		         });
	            
	         file.add(rMenuItem);
	         file.add(eMenuItem);
	         
	            
	         
	         
	         MB.add(file);
	        
	         Menu option = new  Menu("Option");    
	         	MenuItem ALMenuItem = new  MenuItem("Always on top");
	         	MenuItem MIMenuItem = new  MenuItem("Minimize on use");
	         	MenuItem HIMenuItem = new  MenuItem("Hide when minimized"); 
	         	MenuItem SHMenuItem = new  MenuItem("Show full account name");
	         	MenuItem SHOMenuItem = new  MenuItem("Show history for all processes");
	        option.add(ALMenuItem);
	        option.add(MIMenuItem);
	        option.add(HIMenuItem);
	        option.add(SHMenuItem);
	        option.add(SHOMenuItem);
	        MB.add(option);
	        	        
	        Menu view = new  Menu("View");
	        	MenuItem REMenuItem = new  MenuItem("Refresh now");
	        	Menu UPMenuItem = new  Menu("Update speed");
	        		MenuItem HIGMenuItem= new  MenuItem("High");
	        		MenuItem NOMenuItem = new  MenuItem("Noraml");
	        		MenuItem LOMenuItem = new  MenuItem("Low");
	        		MenuItem PAMenuItem = new  MenuItem("Paused");
	        	MenuItem GRMenuItem = new  MenuItem("Group by type");
	        	MenuItem EXMenuItem = new  MenuItem("Expand all");
	        	MenuItem COMenuItem = new  MenuItem("Collaspe all");
	        	Menu STMenuItem = new  Menu("Status Values");
	        		MenuItem STSMenuItem = new  MenuItem("Show suspended status");
	        		MenuItem STS2MenuItem = new  MenuItem("Hide suspended status");
	        		 
	        		 
	        				
	        
	        view.add(REMenuItem);
	        
	        UPMenuItem.add(HIGMenuItem);
	        UPMenuItem.add(NOMenuItem);
	        UPMenuItem.add(LOMenuItem);
	        UPMenuItem.add(PAMenuItem);
	        view.add(UPMenuItem);
	        view.add(GRMenuItem);
	     	view.add(EXMenuItem);
	     	view.add(COMenuItem);	
	             
	        STMenuItem.add(STSMenuItem);
	        STMenuItem.add(STS2MenuItem);
	        view.add(STMenuItem);
	      
	        MB.add(view);
	        JLayeredPane jpl = new JLayeredPane();
	                         
	        JTabbedPane jtp = new JTabbedPane();
	        jpl.add(jtp);
	       
	        
	        JPanel jp1 = new JPanel();
	        JPanel jp2 = new JPanel();
	        JPanel jp3 = new JPanel();
	        JPanel jp4 = new JPanel();
	        JPanel jp5 = new JPanel();
	        JPanel jp6 = new JPanel();
	        JPanel jp7 = new JPanel();
	        
	        jtp.addTab("Processes", jp1);
	        
	        final JTextArea textArea = new JTextArea();
	        jp1.add(textArea);
	        textArea.setFont( new Font("Calibri", Font.ROMAN_BASELINE, 13 ));
		    textArea.setMargin( new Insets(17,17,17,17) );
		    textArea.setEditable(false);		   
			JScrollPane scrolltxt = new JScrollPane(jp1);
			scrolltxt.setBounds(5, 5, 500, 500);
			
			jtp.add("Processes",scrolltxt);
			jtp.addTab("Performance", jp2);
	        jtp.addTab("App history", jp3);
	        jtp.addTab("Startup", jp4);
	        jtp.addTab("Users", jp5);
	        jtp.addTab("Detail", jp6);
	        jtp.addTab("Services", jp7);
			getContentPane().add(jtp);
			
			
			/*List<String> processes = new ArrayList<String>();
			try {
			String line;
			Process p = Runtime.getRuntime().exec("tasklist.exe /nh");
			BufferedReader input = new BufferedReader
			(new InputStreamReader(p.getInputStream()));
			while ((line = input.readLine()) != null) {
			if (!line.trim().equals("")) {
			// keep only the process name
			processes.add(line.substring(0, line.indexOf("  ")));
			}
			 
			}
			input.close();
			}
			catch (Exception err) {
			err.printStackTrace();
			}
							
			String result = "";
			 
						Iterator<String> it = processes.iterator();
			int i = 0;
			while (it.hasNext()) {
			result += it.next()+"\n";
						}
			System.out.println(result+"\n Total No of Processes: "+ processes.size());
			*/
			
			
			
			
	               	
	    	ActionListener actListner = new ActionListener() {        		 
	    		public void actionPerformed(ActionEvent event) {
	    			try {   
				        String line;
				        Process p = Runtime.getRuntime().exec("TASKLIST");
				        Process proc = Runtime.getRuntime().exec("tasklist.exe ");
				        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
				        BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
				        textArea.setText(null);
				        
				        while ((line = input.readLine()) != null) 
				        {
				        	String st_1=line.replaceAll("  ", " ");
				        	
				        	String st_2=st_1.replaceAll("  ", "        ");
				        	String st_3="  "+st_2.replaceAll("Console  ", "\tConsole\t");
				        	String st_4="  "+st_3.replaceAll("Services  ", "\tServices\t");
				        	textArea.setLayout(new GridLayout(3, 2));
				        	textArea.append(st_4+"\n");}
				        input.close(); 			        }
	  	        		
	    				catch(Exception e)
				        {System.out.println(e.getMessage());}}
	    		};
	    		Timer timer = new Timer(1000, actListner);
	    		timer.start();
	    		
	    		setMenuBar(MB);
	    			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}	

			public static void main(String args[]) {
			FK Call_Frame = new FK();
			Call_Frame.show();
			
			    }

	}


