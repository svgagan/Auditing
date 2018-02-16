

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;




public class Receiver implements ActionListener
{
	
	public Font f = new Font("Algerian" , Font.BOLD + Font.ITALIC, 45);	
	public Font f1 = new Font("Calibrie", Font.BOLD + Font.ITALIC, 25);
	public Font f2 = new Font("Calibrie", Font.BOLD + Font.ITALIC, 15);
	public Font f5 = new Font("Bell MT", Font.BOLD, 20);
	public Font f6 = new Font("Bell MT", Font.BOLD, 18);


	public Font f3 = new Font("Bell MT", Font.BOLD , 25);
    public Font f4 = new Font("Arial Rounded MT Bold", Font.BOLD , 35);
    public JLabel T3= new JLabel("Privacy-Preserving Public Auditing for Secure Cloud Storage");
    public JLabel T4= new JLabel(" ");
    public JLabel ieee = new JLabel("  ");

	public JLabel vol = new JLabel("  ");
	public JLabel T1= new JLabel("CLOUD RECEIVER");
	public JLabel T2= new JLabel("Select the File");
	
	
	public JComboBox TAreu = new JComboBox();	
	public JButton btn = new JButton("Save");
	public JTextArea tf = new JTextArea();
	public JTextArea tf1 = new JTextArea();
	public JTextArea tf2 = new JTextArea();
	public JTextArea tf3 = new JTextArea();
	public JScrollPane pane = new JScrollPane();
	public JScrollPane pane1 = new JScrollPane();
	public JScrollPane pane2 = new JScrollPane();
	public JScrollPane pane3 = new JScrollPane();
	public JButton btn1 = new JButton("Browse");
	public JButton req=new JButton("Request Secret Key");
	
	
	FileDialog fd;
	
	public JFrame jf;
	public Container c;
	
	
	public JLabel l1 = new JLabel("Block1");
	public JLabel l2 = new JLabel("Block2");
	public JLabel l3 = new JLabel("Block3");
	public JLabel l4 = new JLabel("Block4");
	
	public JButton btn11 = new JButton("Receive");
	public JButton btn2 = new JButton("Receive");
	public JButton btn3 = new JButton("Receive");
	public JButton btn4 = new JButton("Receive");
	public JButton btn5 = new JButton("Logout");
	
	JLabel image;
	ImageIcon im;
	
	Receiver()
	{
		
        im = new ImageIcon(this.getClass().getResource("Receiver1.jpg"));
		image = new JLabel();
   		image.setIcon(im);
   		image.setBounds(30, 0, 1300, 170);
   	
		jf = new JFrame("Receiver::Privacy-Preserving Public Auditing for Secure Cloud Storage");
		c = jf.getContentPane();
		c.setLayout(null);
		jf.setSize(1000,700);
        
		c.setBackground(new Color(50,130,180));
		T2.setBounds(560, 130, 250,45);
		T2.setFont(f3);
		T2.setForeground(new Color(120,120,0));
        T2.setForeground(Color.BLUE);

		//btn1.setBounds(780,230,230,45);
		btn1.setFont(f3);
		btn1.setForeground(Color.BLACK);
		
		req.setBounds(110, 400, 250	, 40);
		req.setFont(f5);
		req.setForeground(Color.BLACK);
		//req.setBackground(Color.WHITE);
		req.addActionListener(this);
		
		T1.setBounds(450,50,250,45);
        T1.setForeground(Color.RED);
		TAreu.setBounds(550,150,200,35);
		
		T1.setFont(f4);
		
		btn.setBounds(570,630,140,45);
		btn.setFont(f3);
		//btn.setBackground(Color.WHITE);
		btn.setForeground(new Color(0, 0, 0));
		
		btn5.setBounds(1200,630,140,45);//Logout
		btn5.setFont(f2);
		//btn5.setBackground(Color.RED);
		btn5.setForeground(Color.RED);
		
		
		TAreu.addItem("Mesh Route");
		TAreu.addItem(" Node ");
		TAreu.setFont(f3);
		TAreu.setBackground(Color.WHITE);
		TAreu.setForeground(Color.BLUE);
		
		
		pane.setBounds(400,210,500,400);
		l1.setBounds(450,120,400,100);
		pane1.setBounds(550,250,400,100);
		l2.setBounds(450,250,400,100);
		pane2.setBounds(550,380,400,100);
		l3.setBounds(450,380,400,100);
		pane3.setBounds(550,500,400,100);
		l4.setBounds(450,500,400,100);
		
		btn11.setBounds(980, 400, 150, 40);
		btn11.setFont(f3);
		//btn11.setBackground(Color.WHITE);
		btn11.setForeground(new Color(0, 0, 0));

		btn2.setBounds(980,280, 150, 40);
		btn2.setFont(f3);
		btn2.setBackground(Color.WHITE);
		btn2.setForeground(new Color(120, 0, 0));

		btn3.setBounds(980, 400, 150, 40);
		btn3.setFont(f3);
		btn3.setBackground(Color.WHITE);
		btn3.setForeground(new Color(120, 0, 0));

		btn4.setBounds(980, 550, 150, 40);
		btn4.setFont(f3);
		btn4.setBackground(Color.WHITE);
		btn4.setForeground(new Color(120, 0, 0));

		tf.setColumns(20);
		tf.setRows(200);
		tf.setName("tf");
		pane.setName("pane");
		pane.setViewportView(tf);
		
		tf1.setColumns(20);
		tf1.setRows(10);
		tf1.setName("tf1");
		pane1.setName("pane1");
		pane1.setViewportView(tf1);
		
		tf2.setColumns(20);
		tf2.setRows(10);
		tf2.setName("tf2");
		pane2.setName("pane2");
		pane2.setViewportView(tf2);
		
		tf3.setColumns(20);
		tf3.setRows(10);
		tf3.setName("tf3");
		pane3.setName("pane3");
		pane3.setViewportView(tf3);
		
		
		
	
        btn1.setBackground(new Color(176,174,144));
       
		
		btn1.addActionListener(this);
		btn.addActionListener(this);
		T3.setBounds(140, 3, 1050, 50);
		T3.setForeground(new Color(10, 120, 7));
		T3.setFont(f4);
		T4.setBounds(320, 40, 950, 50);
		T4.setForeground(new Color(10, 120, 7));
		T4.setFont(f4);
		
		ieee.setBounds(350, 70, 950, 50);
		ieee.setForeground(Color.BLACK);
		ieee.setFont(f5);

		vol.setBounds(390, 100, 950, 50);
		vol.setForeground(Color.BLACK);
		vol.setFont(f6);
		
		btn1.setMnemonic(KeyEvent.VK_B);
		btn.setMnemonic(KeyEvent.VK_S); 
		jf.show();
		//c.add(T1);
		
		//c.add(btn);
		//c.add(T2);
		c.add(req);
		c.add(pane, BorderLayout.CENTER);
	//	c.add(pane1, BorderLayout.CENTER);
	//	c.add(pane2, BorderLayout.CENTER);
	//	c.add(pane3, BorderLayout.CENTER);
		//c.add(btn1);

		//c.add(T3);
		c.add(T4);
		c.add(ieee);
		c.add(vol);
	//	c.add(l1);
	//	c.add(l2);
	//	c.add(l3);
	//	c.add(l4);
		
		btn11.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		
		/* btn.setBackground(new java.awt.Color(255, 0, 0));
	        btn.setFont(new java.awt.Font("Arial", 0, 15));
			btn.setForeground(new java.awt.Color(255, 255, 255));
	        btn.setText("Save");
	        btn.addActionListener(new java.awt.event.ActionListener() 
		{
		            public void actionPerformed(java.awt.event.ActionEvent evt) 
			{

		                saveActionPerformed(evt);
				
         			}
     		});*/

	        
	        
	        c.add(btn);
	        c.add(btn11);
	        c.add(btn5);
	   //     c.add(btn2);
	    //    c.add(btn3);
	    //    c.add(btn4);
	c.add(image);
		
		
		
		
		
		
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent win) {
				System.exit(0);
			}
		});
		
		int[] ports = new int[]{};
		for(int i=0;i<0;i++)
		{
			Thread th = new Thread(new PortListener(ports[i]));
			th.start();
		}
		
		
		 
		
		//JOptionPane.showMessageDialog(null,"      Sucessful LOGIN");
        
		
		
	}
		
	class PortListener implements Runnable
	{
		ServerSocket sc = null;
		Socket s1,s2;
		DataInputStream ds=null;
		 int port;
		 
		 public PortListener(int port)
		 {
			 this.port=port;
		 }
		 
		 public void run()
		 {
			 Connection connect;
			 
			
		 }
		
		
	}
	
	
	
		
		
		 public void actionPerformed(ActionEvent e)
		 {
			 

		    	DataInputStream input;

		    	BufferedInputStream bis;
		    	BufferedOutputStream bos = null;
		    	BufferedWriter writer = null;
		    	int in;
		    	byte[] byteArray;
		    	
		    	
		    	 
		    	
		    	
		    	
		    	
			 
			 String strLine = null;
			 String newline = "\n";
			 if (e.getSource()== btn1)
			 {
				 JFileChooser chooser = new JFileChooser();
			    
			    // Set the current directory to the application's current directory
			    try {
			        // Create a File object containing the canonical path of the
			        // desired file
			        File f = new File(new File("filename.txt").getCanonicalPath());
			    
			        // Set the selected file
			        chooser.setSelectedFile(f);
			    } catch (IOException e1) {
			    }
			    
			    // Show the dialog; wait until dialog is closed
			    chooser.showOpenDialog(btn1);
			    
			    // Get the currently selected file
			    File curFile = chooser.getSelectedFile();


			    try{
				    // Open the file that is the first 
				    // command line parameter
				    FileInputStream fstream = new FileInputStream(curFile);
				    // Get the object of DataInputStream
				    DataInputStream ins = new DataInputStream(fstream);
				        BufferedReader br = new BufferedReader(new InputStreamReader(ins));
				   // String strLine;
				    //Read File Line By Line
				        
//				        Socket client = new Socket("127.0.0.1", 8585);
//			    		input = new DataInputStream (client.getInputStream() );
//			    		bis = new BufferedInputStream(new FileInputStream(curFile));
//			    		bos = new BufferedOutputStream(client.getOutputStream());
//			    		byteArray = new byte[8192];
//			    		while ((in = bis.read(byteArray)) != -1)
//			    			{
//				    		bos.write(byteArray,0,in);
//				    		}
//			    		
//			    		System.out.println("Server message: " +input.readUTF() );
			    		
			    		
				    StringBuffer buffer = new StringBuffer();
				    while ((strLine = br.readLine()) != null)   {
				      // Print the content on the console
				      System.out.println (strLine);
				      buffer.append(strLine+ "\n");
				          
				      
				    }
				    tf.setText(buffer.toString());
				    //Close the input stream
//				    ins.close();
//				    bis.close();
//		    		bos.close();
				    }catch (Exception e1){//Catch exception if any
				      System.err.println("Error: " + e1.getMessage());
				    }
			 }
			 
			 
			 if(e.getSource()==btn11)
			 {
				 	String user = JOptionPane.showInputDialog(jf, "Enter UserName");
					String fname = JOptionPane.showInputDialog(jf, " Enter the File Name");
					String sk = JOptionPane.showInputDialog(jf, " Enter the Secret Key");
					String ip = JOptionPane.showInputDialog(jf, " Enter the IP Address Of Cloud Server");
					
					
						Socket client ;
						DataOutputStream ds ;
						DataInputStream in1;
						try
						{
							client = new Socket(ip,10013);
							ds = new DataOutputStream(client.getOutputStream());
							ds.writeUTF(user);
							ds.writeUTF(fname);
							ds.writeUTF(sk);
							
							in1 = new DataInputStream(client.getInputStream());
							
							String file = in1.readUTF();
							String fstatus = in1.readUTF();
							
							if(fstatus.equals("success"))
							{
							
							tf.setText(file);
							
							JOptionPane.showMessageDialog(null,"File received");
							}
							if(fstatus.equals("failure"))
							{
							
							JOptionPane.showMessageDialog(null,"Enter Correct Filename or Secret Key !!! From Cloud Server");
							}
							
							
							
						}
						catch(Exception e1)
						{
							e1.printStackTrace();
						}
				
			 }
			 
			 
			 if(e.getSource()==btn2)
			 {
				 
					String fname = JOptionPane.showInputDialog(jf, " Enter the File Name");
					String uname = JOptionPane.showInputDialog(jf, " Enter User Name");
					String csn = JOptionPane.showInputDialog(jf, " Enter Cloud Server Name  CS1 ,CS2,CS3,CS4 ");
					String bn = JOptionPane.showInputDialog(jf, " Enter File Block Name B1,B2,B3,B4 ");
					String ip = JOptionPane.showInputDialog(jf, " Enter the IP Address Of Cloud Server");
					String sk = JOptionPane.showInputDialog(jf, " Enter the Secret Key");
					
					
					try {

						
						Socket con1=new Socket("localhost",10005);
						DataOutputStream dos1 = new DataOutputStream(con1.getOutputStream());
						dos1.writeUTF("UserRequest");
						
						dos1.writeUTF(uname);
						dos1.writeUTF(fname);
						dos1.writeUTF(sk);
						
						
						DataInputStream	dis = new DataInputStream(con1.getInputStream());
						String response = dis.readUTF();
						
						
						if(response.equals("success"))
						{
							
							
	

								String fname1 = dis.readUTF();

								String sk1 = dis.readUTF();

								String ct = dis.readUTF();

								System.out.println("User:"+fname1);
								System.out.println("User:"+sk1);
								System.out.println("User:"+ct);
								
								//FileOutputStream fos = new FileOutputStream("User/"+ fname);
								//fos.write(ct.getBytes());
								
								tf1.setText(ct);
								
								
								JOptionPane.showMessageDialog(null, fname+"Reveivecd The Block");
						

						}
						if(response.equals("failure"))
						{
							
							JOptionPane.showMessageDialog(null, "File Name or Secret Key Wrong U  R Automatically Blocked","Message From Cloud Server", JOptionPane.WARNING_MESSAGE);

						}
						
						if(response.equals("Block"))
						{
							
							JOptionPane.showMessageDialog(null, "You Are Currentlly Blocked Please Contact Cloud Server","Message From Cloud Server", JOptionPane.WARNING_MESSAGE);

						}
					
						
						
						
			}
					 catch (Exception e1) {
						System.out.println(e1);
					}
					
					
					
				 
				 
				 
			 }
			 if(e.getSource()==btn3)
			 {
				 
					String fname = JOptionPane.showInputDialog(jf, " Enter the File Name");
					String uname = JOptionPane.showInputDialog(jf, " Enter User Name");
					String csn = JOptionPane.showInputDialog(jf, " Enter Cloud Server Name  CS1 ,CS2,CS3,CS4 ");
					String bn = JOptionPane.showInputDialog(jf, " Enter File Block Name B1,B2,B3,B4 ");
					String ip = JOptionPane.showInputDialog(jf, " Enter the IP Address Of Cloud Server");
					String sk = JOptionPane.showInputDialog(jf, " Enter the Secret Key");
					
					
					try {

						
						Socket con1=new Socket("localhost",10008);
						DataOutputStream dos1 = new DataOutputStream(con1.getOutputStream());
						dos1.writeUTF("UserRequest");
						
						dos1.writeUTF(uname);
						dos1.writeUTF(fname);
						dos1.writeUTF(sk);
						
						
						DataInputStream	dis = new DataInputStream(con1.getInputStream());
						String response = dis.readUTF();
						
						
						if(response.equals("success"))
						{
							
							
	

								String fname1 = dis.readUTF();

								String sk1 = dis.readUTF();

								String ct = dis.readUTF();

								System.out.println("User:"+fname1);
								System.out.println("User:"+sk1);
								System.out.println("User:"+ct);
								
								//FileOutputStream fos = new FileOutputStream("User/"+ fname);
								//fos.write(ct.getBytes());
								
								tf2.setText(ct);
								
								
								JOptionPane.showMessageDialog(null, fname+"Reveivecd The Block");
						

						}
						if(response.equals("failure"))
						{
							
							JOptionPane.showMessageDialog(null, "File Name or Secret Key Wrong You Are Automatically Blocked","Message From Cloud Server", JOptionPane.WARNING_MESSAGE);

						}
						
						if(response.equals("Block"))
						{
							
							JOptionPane.showMessageDialog(null, "You Are Currentlly Blocked Pls Contact Cloud Server","Message From Cloud Server", JOptionPane.WARNING_MESSAGE);

						}
					
						
						
						
			}
					 catch (Exception e1) {
						System.out.println(e1);
					}
					
					
					
				 
				 
				 
			 }
			 if(e.getSource()==btn4)
			 {
				 
					String fname = JOptionPane.showInputDialog(jf, " Enter The File Name");
					String csn = JOptionPane.showInputDialog(jf, " Enter Cloud Server Name  CS1 ,CS2,CS3,CS4 ");
					String ip = JOptionPane.showInputDialog(jf, " Enter The IP Address Of Cloud Server");
					String sk = JOptionPane.showInputDialog(jf, " Enter The Secret Key");
					
					
					try {

						
						Socket con1=new Socket("localhost",10011);
						DataOutputStream dos1 = new DataOutputStream(con1.getOutputStream());
						dos1.writeUTF("UserRequest");
						
						
						dos1.writeUTF(fname);
						dos1.writeUTF(sk);
						
						
						DataInputStream	dis = new DataInputStream(con1.getInputStream());
						String response = dis.readUTF();
						
						
						if(response.equals("success"))
						{
							
							
	

								String fname1 = dis.readUTF();

								String sk1 = dis.readUTF();

								String ct = dis.readUTF();

								System.out.println("User:"+fname1);
								System.out.println("User:"+sk1);
								System.out.println("User:"+ct);
								
								//FileOutputStream fos = new FileOutputStream("User/"+ fname);
								//fos.write(ct.getBytes());
								
								tf3.setText(ct);
								
								
								JOptionPane.showMessageDialog(null, fname+"Reveivecd The Block");
						

						}
						if(response.equals("failure"))
						{
							
							JOptionPane.showMessageDialog(null, "File Name or Secret Key Wrong U  R Automatically Blocked","Message From Cloud Server", JOptionPane.WARNING_MESSAGE);

						}
						
						if(response.equals("Block"))
						{
							
							JOptionPane.showMessageDialog(null, "U R Currentlly Blocked Pls Contact Cloud Server","Message From Cloud Server", JOptionPane.WARNING_MESSAGE);

						}
					
						
						
						
			}
					 catch (Exception e1) {
						System.out.println(e1);
					}
					
					
					
				 
				 
				 
			 }
			 if(e.getSource()==btn5)
			 {
				 new register();
				 jf.setVisible(false);
			 }
			 
			 
			 
			 
			 
			 
			 
			 
			 if(e.getSource()== btn)
			 {
				 
				 try {
					FileDialog fd=new FileDialog(jf,"File Store", FileDialog.SAVE);
						
					
						
						
						fd.setVisible(true);
						String f= fd.getFile();
						
						
						//String f= "check.java";
						
						fd.setFile(f); // Filename filter
						fd.getDirectory();
						fd.show();
						FileOutputStream out=new FileOutputStream(f);	
						String s=tf.getText();
						//String s1=tf1.getText();
						//String s2=tf2.getText();
						//String s3=tf3.getText();
						System.out.println(s);
						//System.out.println(s1);
						//System.out.println(s2);
						//System.out.println(s3);
						
						
						
						byte b[]=s.getBytes();
						//byte b1[]=s1.getBytes();
						//byte b2[]=s2.getBytes();
						//byte b3[]=s3.getBytes();
						
						
						
						out.write(b);
						//out.write(b1);
					//	out.write(b2);
						//out.write(b3);
						
						
						
					} catch(Exception e1)
						{
						System.out.println(e1);
						}
				 
				 
				 
			 }
			 
			 
			 
			 if(e.getSource()==req){
				 String uname=JOptionPane.showInputDialog("Enter The File name");
				 String ipad=JOptionPane.showInputDialog("Enter The IP Addres Of Cloud Server");
				 
				 try {
					Socket req=new Socket(ipad,104);
					DataOutputStream d=new DataOutputStream(req.getOutputStream());
					d.writeUTF("skrequest");
					d.writeUTF(uname);
					d.writeUTF(ipad);
					
					DataInputStream dis = new DataInputStream(req.getInputStream());
					String response = dis.readUTF();
					String sk = dis.readUTF();

					if (response.equals("success")) {

						JOptionPane.showMessageDialog(null, sk + " is the Secret Key ");

					}
					if (response.equals("failure")) {
						JOptionPane.showMessageDialog(null,
								"No File Found in the Cloud Server");

					}

				} catch (Exception ex) {
					System.out.println(ex);
				}

			}
			
					
			
				 
				 
			 }
			 
			 
			 
			 
			 
	    	
	    
	
	public static void main(String args[])
	{
		new Receiver();
	}
}
	
	
	

		


