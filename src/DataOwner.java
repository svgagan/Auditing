import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.DigestInputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DataOwner implements ActionListener {
	String str;
	Socket client;
	public Font f = new Font("Times new roman", Font.BOLD, 25);
	public Font f1 = new Font("Times new roman", Font.BOLD, 18);
	public Font f2 = new Font("Times new roman", Font.BOLD, 16);
	public Font f3 = new Font("Times new roman", Font.BOLD, 23);
	public Font f4 = new Font("Times new roman", Font.BOLD, 15);
	public JLabel T0 = new JLabel("User");
	
	
	public JLabel T1 = new JLabel("FILE");
	public JLabel T2 = new JLabel("Block2");
	public JLabel T3 = new JLabel("Block3");
	public JLabel T4 = new JLabel("Block4");
	
	
	public JLabel T5 = new JLabel("Select The Route");
	public JLabel T6 = new JLabel("FA    -Foriegn Agent");
	public JLabel T7 = new JLabel("GFA   -Gateway Foriegn Agent");
	public JLabel T11 = new JLabel(
			"          ");

	public JLabel T12 = new JLabel("                    ");

	public JTextField head = new JTextField();

	public JCheckBox chk1 = new JCheckBox("");
	public JComboBox TAreu = new JComboBox();
	public JButton btn = new JButton("Upload");
	public JButton tpabtn= new JButton("Send Meta Data To TPA");
	public JButton verify= new JButton("Verify");

	public JTextArea tf = new JTextArea();
	public JTextArea tf1 = new JTextArea();
	public JTextArea tf2 = new JTextArea();
	public JTextArea tf3 = new JTextArea();

	public JScrollPane pane = new JScrollPane();

	public JScrollPane pane1 = new JScrollPane();
	public JScrollPane pane2 = new JScrollPane();
	public JScrollPane pane3 = new JScrollPane();

	public JButton btn1 = new JButton("Browse");
	public JButton btn2 = new JButton("Browse");
	public JButton btn3 = new JButton("Browse");
	public JButton btn4 = new JButton("Browse");
	public JButton logout;
	JLabel imageLabel = new JLabel();
	JLabel image = new JLabel();
	JLabel imageLabel1 = new JLabel();
	JLabel image1 = new JLabel();

	JLabel imageLabel2 = new JLabel();
	JLabel image12 = new JLabel();

	JPanel jp = new JPanel();
	JPanel jp1 = new JPanel();

	public JFrame jf;
	public Container c;
	DataOutputStream out;
	
	
	Key secKey;
	final static String strPassword = "password12345678";
	 static SecretKeySpec key = new SecretKeySpec(strPassword.getBytes(), "AES");  

	Cipher encoder = null; 
	  Key prKey;
	public static Key pubKey;

	String priKey,fname,publKey,path1,path2,path3,path4,f1Sign,f2Sign,f3Sign;
	JLabel image11;
	ImageIcon im;
	
	JButton delete = new JButton("Delete");
	JButton update = new JButton("Update");
	
	

	DataOwner() {
		jf = new JFrame("Data Owner::Privacy Preserving Public Auditing for Secure Cloud Storage");
		c = jf.getContentPane();
		c.setLayout(null);
		jf.setSize(1050, 700);

		T11.setBounds(180, -3, 1200, 50);
		T12.setBounds(230, 29, 1000, 50);
		T12.setForeground(Color.MAGENTA);
		T11.setForeground(Color.MAGENTA);
		T11.setFont(f);
		T12.setFont(f);
		
		 im = new ImageIcon(this.getClass().getResource("Dataowner.jpg"));
			
		   	image11 = new JLabel();
		   		image11.setIcon(im);
		   		image11.setBounds(35, 10, 1400, 160);
		
		

		c.setBackground(Color.GRAY);
		T0.setBounds(440, 60, 350, 45);
		T0.setFont(f);

		T0.setForeground(Color.RED);
		
		T1.setBounds(250, 400, 250, 45);
		T1.setFont(f3);
		T1.setForeground(Color.WHITE);

		
		T2.setBounds(105, 280, 250, 45);
		T2.setFont(f3);
		T2.setForeground(Color.GREEN);

		T3.setBounds(105, 400, 250, 45);
		T3.setFont(f3);
		T3.setForeground(Color.GREEN);
		
		T4.setBounds(105, 520, 250, 45);
		T4.setFont(f3);
		T4.setForeground(Color.GREEN);
		

		head.setBounds(400, 220, 200, 25);
		head.setFont(f2);
		head.setForeground(Color.ORANGE);

		T5.setBounds(660, 145, 300, 45);
		T5.setFont(f3);
		T5.setForeground(Color.CYAN);

		T6.setBounds(760, 70, 400, 35);
		T6.setFont(f2);
		T6.setForeground(Color.RED);

		T7.setBounds(760, 110, 400, 35);
		T7.setFont(f2);
		T7.setForeground(Color.MAGENTA);

		btn1.setBounds(970, 293, 150, 40);
		btn1.setFont(f3);
		//btn1.setBackground(Color.WHITE);
		btn1.setForeground(new Color(0, 0, 0));
		
		logout=new JButton("Logout");			//Logout button
		logout.setBounds(1190,630,150,40);
		logout.setFont(f2);
		logout.setForeground(Color.red);

		btn2.setBounds(700,280, 180, 40);
		btn2.setFont(f3);
		btn2.setBackground(Color.WHITE);
		btn2.setForeground(new Color(120, 0, 0));

		btn3.setBounds(700, 400, 180, 40);
		btn3.setFont(f3);
		btn3.setBackground(Color.WHITE);
		btn3.setForeground(new Color(120, 0, 0));

		btn4.setBounds(700, 500, 180, 40);
		btn4.setFont(f3);
		btn4.setBackground(Color.WHITE);
		btn4.setForeground(new Color(120, 0, 0));

		jp.setBounds(210, 182, 920, 500);

		jp.setBackground(Color.BLACK);

		jp1.setBounds(205, 177, 930, 510);
		jp1.setBackground(Color.RED);

		
		TAreu.setBounds(650, 550, 200, 35);
		
		btn.setBounds(970, 450, 150, 40);
		btn.setFont(f3);
		//btn.setBackground(Color.WHITE);
		btn.setForeground(new Color(0, 0, 0));
		
		
		
		update.setBounds(340, 630, 150, 40); 
		update.setFont(f3);
		//update.setBackground(Color.WHITE);
		update.setForeground(new Color(0,0,0));
		
		verify.setBounds(560, 630, 150, 40);
		verify.setFont(f3);
		//verify.setBackground(Color.WHITE);
		verify.setForeground(new Color(0, 0, 0));
		
		delete.setBounds(790,630,150,40);
		delete.setFont(f3);
		//delete.setBackground(Color.WHITE);
		delete.setForeground(new Color(0,0,0));

		//update.setBounds(800,500,100,40);
		//update.setFont(f4);
		//update.setBackground(Color.WHITE);
		//update.setForeground(new Color(120,0,0));

		
		
		TAreu.addItem("Mesh Route");
		TAreu.addItem(" Node ");
		TAreu.setFont(f3);
		TAreu.setBackground(Color.WHITE);
		TAreu.setForeground(Color.BLUE);
		TAreu.setFont(f);
		
		pane.setBounds(340, 220, 600,400);
		
		pane1.setBounds(250, 250, 600, 300);
		pane2.setBounds(250, 370, 400, 100);
		pane3.setBounds(250, 490, 400, 100);

		tf.setColumns(100);
		tf.setForeground(Color.MAGENTA);
		tf.setFont(f1);
		tf.setRows(200);
		tf.setName("tf");
		pane.setName("pane");
		pane.setViewportView(tf);

		tf1.setColumns(20);
		tf1.setForeground(Color.MAGENTA);
		tf1.setFont(f1);
		tf1.setRows(10);
		tf1.setName("tf1");
		pane1.setName("pane1");
		pane1.setViewportView(tf1);

		tf2.setColumns(20);
		tf2.setForeground(Color.MAGENTA);
		tf2.setFont(f1);
		tf2.setRows(10);
		tf2.setName("tf1");
		pane2.setName("pane1");
		pane2.setViewportView(tf2);

		tf3.setColumns(20);
		tf3.setForeground(Color.MAGENTA);
		tf3.setFont(f1);
		tf3.setRows(10);
		tf3.setName("tf3");
		pane3.setName("pane3");
		pane3.setViewportView(tf3);

	
		
		btn.addActionListener(this);

		btn1.setMnemonic(KeyEvent.VK_B);
		btn.setMnemonic(KeyEvent.VK_S);
		jf.show();

		c.add(btn);
		c.add(delete);
		
		c.add(update);
		c.add(T1);
		//c.add(T2);
		//c.add(T3);
		//c.add(T4);
		//c.add(T11);
	//	c.add(T12);
		c.add(pane, BorderLayout.CENTER);
		c.add(btn1);
		c.add(logout);
		c.add(verify);
	//	c.add(btn2);
	//	c.add(btn3);
	//	c.add(btn4);
	//	c.add(pane1, BorderLayout.CENTER);

	//	c.add(pane2, BorderLayout.CENTER);
	//	c.add(pane3, BorderLayout.CENTER);

		//c.add(T0);

		c.add(imageLabel1);

		c.add(jp);
		c.add(jp1);
		c.add(image11);

		tpabtn.addActionListener(this);
		verify.addActionListener(this);
		btn1.addActionListener(this);
		delete.addActionListener(this);
		update.addActionListener(this);
		logout.addActionListener(this);
	//	btn2.addActionListener(this);
	//	btn3.addActionListener(this);
	//	btn4.addActionListener(this);
		
		
		// c.add(head);
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent win) {
				System.exit(0);
			}
		});
		
		
		int[] ports = new int[]
          		{ 102,3333};

          		for (int i = 0; i <2 ; i++)
          		{
          			Thread t = new Thread(new PortListener(ports[i]));
          			t.setName("Listener-" + ports[i]);
          			t.start();

          		}
		
		

	}
	
	
	
	
	class PortListener implements Runnable
	{

		int port;
		ServerSocket server1 =null;
		 Socket so1 = null;
		 DataInputStream ds1 =null;
		

		public PortListener(int port)
		{
			this.port = port;
		}

		public void run()
		{
			

			 if(this.port==500)
			
			{
				 try
				 {
					 System.out.println("here ssssssssss");
					server1 = new ServerSocket(500);
					so1 = server1.accept();
					 ds1 = new DataInputStream(so1.getInputStream());
					 String message = ds1.readUTF();
					 System.out.println(message);
					 JOptionPane.showMessageDialog(null, message);
				
			 
				 }
				 catch(Exception e)
				 {
					 e.printStackTrace();
				 }
			 
			}
			 
			 else if(this.port==501)
			 {
				 ServerSocket server2 =null;
				 Socket so2=null;
				 DataInputStream ds2=null;
				 
				 try
				 {
					 System.out.println("here ssssssssss");
					server2 = new ServerSocket(501);
					so2 = server2.accept();
					 ds2 = new DataInputStream(so2.getInputStream());
					 String message = ds2.readUTF();
					 System.out.println(message);
					 JOptionPane.showMessageDialog(null, message);
				
			 
				 }
				 catch(Exception e)
				 {
					 e.printStackTrace();
				 }
				 
			 }
			 
			 else if(this.port==201)
			 {
				 ServerSocket server2 =null;
				 Socket so2=null;
				 DataInputStream ds2=null;
				 
				 try
				 {
					 System.out.println("here ssssssssss");
					server2 = new ServerSocket(201);
					so2 = server2.accept();
					 ds2 = new DataInputStream(so2.getInputStream());
					 String message = ds2.readUTF();
					 System.out.println(message);
					 JOptionPane.showMessageDialog(null, message);
				
			 
				 }
				 catch(Exception e)
				 {
					 e.printStackTrace();
				 }
				 
			 }
			 
			 
			 else if(this.port==3333){
				 ServerSocket ss;
				 Socket s;
				 DataInputStream di;
				 try{
					 ss=new ServerSocket(3333);
					 while(true){
						s= ss.accept();
						di=new DataInputStream(s.getInputStream());
						String fname=di.readUTF();
						JOptionPane.showMessageDialog(null, fname+".txt"+" is modified please update");
						di.close();
					 }
					 
					 
				 }catch(Exception e){
					 System.out.println(e);
				 }
				 
				 
				 
			 }
			 
		}
}

	public void actionPerformed(ActionEvent e) {
		DataInputStream input;

		BufferedInputStream bis;
		BufferedOutputStream bos = null; 
		BufferedWriter writer = null;
		int in;
		String str = "192.168.50.2";
		byte[] byteArray = str.getBytes();

		String strLine = null;
		String newline = "\n";
		
		
		if(e.getSource()==verify)
		{
			String fname = JOptionPane.showInputDialog(jf, " Enter the File Name To Be Verified");
			
			String bn = JOptionPane.showInputDialog(jf, " Enter File Block Name B1,B2,B3,B4,B5 ");
			String ip = JOptionPane.showInputDialog(jf, " Enter the TPA IP Address");
			
			
			try {
				
			Socket	soc1 = new Socket(ip,102);
			DataOutputStream dos2 = new DataOutputStream(soc1.getOutputStream());
			dos2.writeUTF("VerifyFile");
			
			dos2.writeUTF(fname);
			
			dos2.writeUTF(bn);
				
				
			DataInputStream din = new DataInputStream(soc1.getInputStream());
			String message=din.readUTF();
			System.out.println(message);
			
			JOptionPane.showMessageDialog(null, message);
//			String publickey=din.readUTF();
			
			
			
//			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//	         Connection connect =DriverManager.getConnection("jdbc:odbc:stom");
//	         Statement stmt = connect.createStatement();
//	         ResultSet rs=stmt.executeQuery("select * from OwnerFiles where FName='"+fname+"' and PubK='"+publickey+"' ");
//			
//			if(rs.next()==true)
//			{
//				JOptionPane.showMessageDialog(tf,bn+ "File Block is Safe  ", "Message From TPA", JOptionPane.INFORMATION_MESSAGE);
//				
//			}
//			else if(rs.next()!=true)
//			{
//				JOptionPane.showMessageDialog(tf,bn+ "File's Block is Not Safe !!! It is modified ", "Message From TPA", JOptionPane.INFORMATION_MESSAGE);
//				
//			}
//			
			
				
			} catch (Exception e2) {
				
				e2.printStackTrace();
			} 
			
			
			
			
		}
		
		if(e.getSource()==tpabtn)
		{
			String fname = JOptionPane.showInputDialog(jf, " Enter the File Name");
			String csn = JOptionPane.showInputDialog(jf, " Enter Cloud Server Name  CS1 ,CS2,CS3 ");
			String bn = JOptionPane.showInputDialog(jf, " Enter File Block Name B1,B2,B3,B4,B5 ");
			String ip = JOptionPane.showInputDialog(jf, " Enter the TPA IP Address");
			try
			{
			
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection("jdbc:odbc:privacy"); 
			Statement stmt = con.createStatement();
			String query = "select * from OwnerFiles where FName='"+fname+"' and bname='"+bn+"'  ";
			ResultSet rs=stmt.executeQuery(query);
			
			if(rs.next()==true)
			{
				 String pk=rs.getString(3);
					 String privk=rs.getString(4);
				 String sk=rs.getString(5);
				
				 String bname=rs.getString(6);
				 String s1hash = rs.getString(7);
				 String s2hash = rs.getString(8);
				 String s3hash = rs.getString(9);
				 String s4hash = rs.getString(10);
				 String s5hash = rs.getString(11);
				 
				 Socket socket1 = new Socket(ip, 100);
				 DataOutputStream dos1 = new DataOutputStream(socket1.getOutputStream());
					dos1.writeUTF(fname);
					dos1.writeUTF(pk);
					dos1.writeUTF(privk);
					dos1.writeUTF(sk);
				
					
					dos1.writeUTF(s1hash);
					dos1.writeUTF(s2hash);
					dos1.writeUTF(s3hash);
					dos1.writeUTF(s4hash);
					dos1.writeUTF(s5hash);
			}
			
			
			JOptionPane.showMessageDialog(jf, "File Details Uploaded Successfully ", "Message From TPA", JOptionPane.INFORMATION_MESSAGE);
			
			}
			catch(Exception e1){System.out.println(e1);}
			
			
			
		}
		
		if (e.getSource() == btn1) {

			JFileChooser chooser = new JFileChooser();

			try {

				File f = new File(new File("filename.txt").getCanonicalPath());

				chooser.setSelectedFile(f);
			} catch (IOException e1) {
			}

			chooser.showOpenDialog(btn1);
			int retval = chooser.showOpenDialog(btn1);
			if (retval == JFileChooser.APPROVE_OPTION) {
				File field = chooser.getSelectedFile();
				 path1=field.getAbsolutePath();
			}

			File curFile = chooser.getSelectedFile();

			try {

				FileInputStream fstream = new FileInputStream(curFile);

				DataInputStream ins = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(
						ins));

				StringBuffer buffer = new StringBuffer();
				while ((strLine = br.readLine()) != null) {

					System.out.println(strLine);
					buffer.append(strLine + "\n");

				}
				tf.setText(buffer.toString());

			} catch (Exception e1) {
				System.err.println("Error: " + e1.getMessage());
			}
			//Socket client = null;

			//int Port = 1111;

		

		}
		
		
		
//		if (e.getSource() == btn2) {
//
//			JFileChooser chooser = new JFileChooser();
//
//			try {
//
//				File f = new File(new File("filename.txt").getCanonicalPath());
//
//				chooser.setSelectedFile(f);
//			} catch (IOException e1) {
//			}
//
//			chooser.showOpenDialog(btn2);
//			int retval = chooser.showOpenDialog(btn2);
//			if (retval == JFileChooser.APPROVE_OPTION) {
//				File field = chooser.getSelectedFile();
//				path2=field.getAbsolutePath();
//			}
//
//			File curFile = chooser.getSelectedFile();
//
//			try {
//
//				FileInputStream fstream = new FileInputStream(curFile);
//
//				DataInputStream ins = new DataInputStream(fstream);
//				BufferedReader br = new BufferedReader(new InputStreamReader(
//						ins));
//
//				StringBuffer buffer = new StringBuffer();
//				while ((strLine = br.readLine()) != null) {
//
//					System.out.println(strLine);
//					buffer.append(strLine + "\n");
//
//				}
//				tf1.setText(buffer.toString());
//
//			} catch (Exception e1) {
//				System.err.println("Error: " + e1.getMessage());
//			}
//			Socket client = null;
//
//			int Port = 1111;
//
//		
//
//		}
//		
//		
//		if (e.getSource() == btn3) {
//
//			JFileChooser chooser = new JFileChooser();
//
//			try {
//
//				File f = new File(new File("filename.txt").getCanonicalPath());
//
//				chooser.setSelectedFile(f);
//			} catch (IOException e1) {
//			}
//
//			chooser.showOpenDialog(btn3);
//			int retval = chooser.showOpenDialog(btn3);
//			if (retval == JFileChooser.APPROVE_OPTION) {
//				File field = chooser.getSelectedFile();
//				path3=field.getAbsolutePath();
//			}
//
//			File curFile = chooser.getSelectedFile();
//
//			try {
//
//				FileInputStream fstream = new FileInputStream(curFile);
//
//				DataInputStream ins = new DataInputStream(fstream);
//				BufferedReader br = new BufferedReader(new InputStreamReader(
//						ins));
//
//				StringBuffer buffer = new StringBuffer();
//				while ((strLine = br.readLine()) != null) {
//
//					System.out.println(strLine);
//					buffer.append(strLine + "\n");
//
//				}
//				tf2.setText(buffer.toString());
//
//			} catch (Exception e1) {
//				System.err.println("Error: " + e1.getMessage());
//			}
//			Socket client = null;
//
//			int Port = 1111;
//
//		
//
//		}
//		
//		
//		if (e.getSource() == btn4) {
//
//			JFileChooser chooser = new JFileChooser();
//
//			try {
//
//				File f = new File(new File("filename.txt").getCanonicalPath());
//
//				chooser.setSelectedFile(f);
//			} catch (IOException e1) {
//			}
//
//			chooser.showOpenDialog(btn4);
//			int retval = chooser.showOpenDialog(btn4);
//			if (retval == JFileChooser.APPROVE_OPTION) {
//				File field = chooser.getSelectedFile();
//				path4=field.getAbsolutePath();
//			}
//
//			File curFile = chooser.getSelectedFile();
//
//			try {
//
//				FileInputStream fstream = new FileInputStream(curFile);
//
//				DataInputStream ins = new DataInputStream(fstream);
//				BufferedReader br = new BufferedReader(new InputStreamReader(
//						ins));
//
//				StringBuffer buffer = new StringBuffer();
//				while ((strLine = br.readLine()) != null) {
//
//					System.out.println(strLine);
//					buffer.append(strLine + "\n");
//
//				}
//				tf3.setText(buffer.toString());
//
//			} catch (Exception e1) {
//				System.err.println("Error: " + e1.getMessage());
//			}
//			Socket client = null;
//
//			int Port = 1111;
//
//		
//
//		}
		
		if(e.getSource()==update)
		{
			
			
			String fname = JOptionPane.showInputDialog(null, " Enter the File Name To Be Updated");
			
			String bn = JOptionPane.showInputDialog(null, " Enter File Block Name B1,B2,B3,B4,B5 ");
			String ip = JOptionPane.showInputDialog(null, " Enter the IP Address Of Cloud Server");
		
			String fn = fname+".java";
			try{
			
			
		    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		    Connection con=DriverManager.getConnection("jdbc:odbc:privacy");
		    Statement stmt = con.createStatement();
		    
			
			Socket client=null ;
			DataOutputStream ds=null ;
			DataInputStream in1=null;
				
			System.out.println("#########################################");
				client = new Socket(ip,10015);
				String h1="";
				String h2="";
				String h3="";
				String h4="";
				String h5="";				
				System.out.println("******######");
				
				String sql = "select * from OwnerFiles where FName='"+fn+"' ";
				ResultSet rs = stmt.executeQuery(sql);
				if(rs.next()==true)
				{
					System.out.println("********************************************");
					 h1=rs.getString(6);
					 System.out.println(h1);
					 h2=rs.getString(7);
					 System.out.println(h2);
					 h3=rs.getString(8);
					 h4=rs.getString(9);
					 h5=rs.getString(10);
				}
				
				
				if(bn.equals("B1"))
				{
					
						FileInputStream fs1 = new FileInputStream("Owner\\cs1\\temp\\"+fname+"1"+".txt");
						byte[] bis1 = new byte[fs1.available()];
						fs1.read(bis1);
						String file = new String(bis1);
						
						System.out.println(file);
						System.out.println(h1);
						ds = new DataOutputStream(client.getOutputStream());
						//h2=rs.getString(7);
						ds.writeUTF(fname);
						ds.writeUTF(bn);
						ds.writeUTF(file);
						ds.writeUTF(h1);
						
						in1 = new DataInputStream(client.getInputStream());
						
						JOptionPane.showMessageDialog(null, in1.readUTF());
						
						
				}	
				
				else if(bn.equals("B2"))
				{
					
						FileInputStream fs2 = new FileInputStream("Owner\\cs1\\temp\\"+fname+"2"+".txt");
						byte[] bis1 = new byte[fs2.available()];
						fs2.read(bis1);
						String file = new String(bis1);
						System.out.println("HEEEEEEEEEEEEEEEEEEEEE");
						System.out.println(file);
					System.out.println("HEEEEEEEEEEEEEEEEEEEEEEEEEE");
					System.out.println(h2);
				DataOutputStream ds1 = new DataOutputStream(client.getOutputStream());
				
						ds1.writeUTF(fname);
						ds1.writeUTF(bn);
						ds1.writeUTF(file);
						ds1.writeUTF(h2);
						
						
					DataInputStream	in2 = new DataInputStream(client.getInputStream());
						
						JOptionPane.showMessageDialog(null, in2.readUTF());	
				}
				
				else if(bn.equals("B3"))
				{
					
						FileInputStream fs = new FileInputStream("Owner\\cs1\\temp\\"+fname+"3"+".txt");
						byte[] bis1 = new byte[fs.available()];
						fs.read(bis1);
						String file = new String(bis1);
					
						
						ds = new DataOutputStream(client.getOutputStream());
						ds.writeUTF(fname);
						ds.writeUTF(bn);
						ds.writeUTF(file);
						ds.writeUTF(h3);
						
						in1 = new DataInputStream(client.getInputStream());
						
						JOptionPane.showMessageDialog(null, in1.readUTF());
						
				}
				else	if(bn.equals("B4"))
				{
					
						FileInputStream fs = new FileInputStream("Owner\\cs1\\temp\\"+fname+"4"+".txt");
						byte[] bis1 = new byte[fs.available()];
						fs.read(bis1);
						String file = new String(bis1);
					
						
						ds = new DataOutputStream(client.getOutputStream());
						ds.writeUTF(fname);
						ds.writeUTF(bn);
						ds.writeUTF(file);
						ds.writeUTF(h4);
						
						in1 = new DataInputStream(client.getInputStream());
						String message = in1.readUTF();
						JOptionPane.showMessageDialog(null, message);
						
				}
				
				else 	if(bn.equals("B5"))
				{
					
						FileInputStream fs = new FileInputStream("Owner\\cs1\\temp\\"+fname+"5"+".txt");
						byte[] bis1 = new byte[fs.available()];
						fs.read(bis1);
						String file = new String(bis1);
					
						
						ds = new DataOutputStream(client.getOutputStream());
						ds.writeUTF(fname);
						ds.writeUTF(bn);
						ds.writeUTF(file);
						ds.writeUTF(h5);
						
						in1 = new DataInputStream(client.getInputStream());
						
						JOptionPane.showMessageDialog(null, in1.readUTF());
						
				}	
			
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		if(e.getSource()==logout)
		{
			
			jf.setVisible(false);
			new DataReg();
			
		}
		
		
		
		if(e.getSource() == delete)
		{
			Socket client ;
			DataInputStream ds ;

			String fname = JOptionPane.showInputDialog(null, " Enter the File Name To Be Deleted");
		
		//	String bn = JOptionPane.showInputDialog(null, " Enter File Block Name B1,B2,B3,B4,B5 ");
			String ip = JOptionPane.showInputDialog(null, " Enter the IP Address Of Cloud Server");
			
			//String request="delete";
			
				//Socket client1;
				DataOutputStream ds1;
			try
			{
				client = new Socket(ip,10014);
				ds1 = new DataOutputStream(client.getOutputStream());
				ds1.writeUTF(fname);
				System.out.println("********************");
				
				ds = new DataInputStream(client.getInputStream());
				JOptionPane.showMessageDialog(null, ds.readUTF());
				
				
			
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		
			

			
		
		}

		if (e.getSource() == btn) {

			JFrame frame = new JFrame();
			
			
			String fname = JOptionPane.showInputDialog(frame, " Enter the File Name To Be Uploaded");
			
		
			String ip = JOptionPane.showInputDialog(frame, " Enter the IP Address Of Cloud Server");
		
			Socket client1 = null;
		

			

				Socket socket1;
				DataOutputStream dos1;
				DataInputStream dis;
				
				
				
				try { 
					 KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA"); 
					 encoder = Cipher.getInstance("RSA"); 
					 KeyPair kp = kg.generateKeyPair(); 
					 prKey = kp.getPrivate(); 
					
					 pubKey = kp.getPublic(); 
						byte[] pub = pubKey.getEncoded();
					 byte[] priv = prKey.getEncoded();
					 System.out.println("PRIVATE KEY"+priv);
					 System.out.println("PUBLIC KEY"+pub);
					 System.out.println("File Name"+fname);
					 
					KeyGenerator kgenerate=new KeyGenerator();
					 
					String secretkey=String.valueOf(kgenerate.getKeys());
					 
							 
					             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					             Connection connect =DriverManager.getConnection("jdbc:odbc:privacy");
					       //      Statement stmt1 = connect.createStatement();
					         //    String query1 = "insert into OwnerFiles(FName,PubK,PrivK,SK,csname,bname) values('"+fname+"','"+pub+"','"+priv+"','"+secretkey+"','"+csn+"','"+bn+"') ";
					           //  stmt1.executeUpdate(query1);
					             
					             FileInputStream fis = new FileInputStream(path1);
									byte b[] = new byte[fis.available()];
									fis.read(b);
									String content = new String(b);
					
									
									
									//	String query = "insert into cs1 values('" + fname + "','" + pubk+ "','" + privk+ "','" + sk+ "')";
										
										
										PrintStream out = null;
										try {
										    out = new PrintStream(new FileOutputStream("Owner\\cs1\\"+"temp\\"+fname));
										    out.print(content);
										}
										finally {
										    if (out != null) out.close();
										}
										

//										FileOutputStream fos = new FileOutputStream("cs1/"
//												+ fname);
										
										SplitFile sp = new SplitFile();
										sp.splitFile(new File("Owner\\cs1\\"+"temp\\"+fname),5, 1024);
									int len = fname.length();
										String fil = fname.substring(0, len-5);
										System.out.println(fil);
										
										
										MessageDigest md = MessageDigest.getInstance("SHA1");
										System.out.println("Hellllllll");
										
										FileInputStream fis1 = new FileInputStream("Owner\\cs1\\"+"temp\\"+fil+"1"+".txt");
									
										
										byte	 bs1[] = new byte[fis1.available()];
										fis1.read(bs1);
										
										String split1 = new String(bs1);
										System.out.println("/*************");
										System.out.println("/*********************");
										System.out.println(split1);
										System.out.println("/*************************");
										System.out.println("/***************");
										fis1.close();
										FileInputStream fis11 = new FileInputStream("Owner\\cs1\\"+"temp\\"+fil+"1"+".txt");
										DigestInputStream dis1 = new DigestInputStream(fis11, md);
										BufferedInputStream bis1 = new BufferedInputStream(dis1);
							 
										//Read the bis so SHA1 is auto calculated at dis
										while (true) {
											int b1 = bis1.read();
											if (b1 == -1)
												break;
										}
							 
										BigInteger bi1 = new BigInteger(md.digest());
										String spl1 = bi1.toString();
									String	 h1 = bi1.toString(16);
										System.out.println(h1);
										
										FileInputStream fis2 = new FileInputStream("Owner\\cs1\\"+"temp\\"+fil+"2"+".txt");//C:\java\mtechproject\cloudcomputing\pra1.txt
										byte bs2[] = new byte[fis2.available()];
										fis2.read(bs2);
										String split2 = new String(bs2);
										FileInputStream fis22 = new FileInputStream("Owner\\cs1\\"+"temp\\"+fil+"2"+".txt");
										DigestInputStream dis2 = new DigestInputStream(fis22, md);
										BufferedInputStream bis2 = new BufferedInputStream(dis2);
							 
										//Read the bis so SHA1 is auto calculated at dis
										while (true) {
											int b2 = bis2.read();
											if (b2 == -1)
												break;
										}
							 
										BigInteger bi2 = new BigInteger(md.digest());
										String  h2 = bi2.toString(16);
										System.out.println(h2);
										
										
										FileInputStream fis3 = new FileInputStream("Owner\\cs1\\"+"temp\\"+fil+"3"+".txt");//C:\java\mtechproject\cloudcomputing\pra1.txt
										byte bs3[] = new byte[fis3.available()];
										fis3.read(bs3);
										String split3 = new String(bs3);
										FileInputStream fis33 = new FileInputStream("Owner\\cs1\\"+"temp\\"+fil+"3"+".txt");
										DigestInputStream dis3 = new DigestInputStream(fis33, md);
										BufferedInputStream bis3 = new BufferedInputStream(dis3);
							 
										//Read the bis so SHA1 is auto calculated at dis
										while (true) {
											int b3 = bis3.read();
											if (b3 == -1)
												break;
										}
							 
										BigInteger bi3 = new BigInteger(md.digest());
									String h3 = bi3.toString(16);
										System.out.println(h3);
										
										
										
										
										
										
										FileInputStream fis4 = new FileInputStream("Owner\\cs1\\"+"temp\\"+fil+"4"+".txt");//C:\java\mtechproject\cloudcomputing\pra1.txt
										byte bs4[] = new byte[fis4.available()];
										fis4.read(bs4);
										String split4 = new String(bs4);
										
										FileInputStream fis44 = new FileInputStream("Owner\\cs1\\"+"temp\\"+fil+"4"+".txt");
										DigestInputStream dis4 = new DigestInputStream(fis4, md);
										BufferedInputStream bis4 = new BufferedInputStream(dis4);
							 
										//Read the bis so SHA1 is auto calculated at dis
										while (true) {
											int b4 = bis4.read();
											if (b4 == -1)
												break;
										}
							 
										BigInteger bi4 = new BigInteger(md.digest());
									String	 h4 = bi4.toString(16);
										System.out.println(h4);
										
										
										
										FileInputStream fis5 = new FileInputStream("Owner\\cs1\\"+"temp\\"+fil+"5"+".txt");//C:\java\mtechproject\cloudcomputing\pra1.txt
										byte bs5[] = new byte[fis5.available()];
										fis5.read(bs5);
										String split5 = new String(bs5);
										
										FileInputStream fis55 = new FileInputStream("Owner\\cs1\\"+"temp\\"+fil+"5"+".txt");
										DigestInputStream dis5 = new DigestInputStream(fis5, md);
										BufferedInputStream bis5 = new BufferedInputStream(dis5);
							 
										//Read the bis so SHA1 is auto calculated at dis
										while (true) {
											int b5 = bis5.read();
											if (b5 == -1)
												break;
										}
							 
										BigInteger bi5 = new BigInteger(md.digest());
									String	h5 = bi5.toString(16);
										System.out.println(h5);
										
										Statement stmt = connect.createStatement();
										String query = "insert into OwnerFiles(Fname,PubK,PrivK,SK,s1hash,s2hash,s3hash,s4hash,s5hash) values('"+fname+"','"+pub+"','"+priv+"','"+secretkey+"','"+h1+"','"+h2+"','"+h3+"','"+h4+"','"+h5+"')";	
										stmt.executeUpdate(query);
										
										
										Statement stmt2 = connect.createStatement();
										String query2 = "select * from OwnerFiles where FName='"+fname+"'   ";
										ResultSet rs=stmt.executeQuery(query2);
										
										if(rs.next()==true)
										{
											 String pk=rs.getString(3);
												 String privk=rs.getString(4);
											 String sk=rs.getString(5);
											
											 String s1hash = rs.getString(6);
											 String s2hash = rs.getString(7);
											 String s3hash = rs.getString(8);
											 String s4hash = rs.getString(9);
											 String s5hash = rs.getString(10);
											 
											 
											 Socket socket2 = new Socket(ip, 100);
											 DataOutputStream dos2 = new DataOutputStream(socket2.getOutputStream());
												dos2.writeUTF(fil);
												dos2.writeUTF(pk);
												dos2.writeUTF(privk);
												dos2.writeUTF(sk);
												
												dos2.writeUTF(s1hash);
												dos2.writeUTF(s2hash);
												dos2.writeUTF(s3hash);
												dos2.writeUTF(s4hash);
												dos2.writeUTF(s5hash);
												
										}
										
										
										JOptionPane.showMessageDialog(jf, "File MetaData Uploaded Successfully ", "Message From TPA", JOptionPane.INFORMATION_MESSAGE);
										
										
									
					             
				    socket1 = new Socket(ip,1002);
					dos1 = new DataOutputStream(socket1.getOutputStream());
					
					
					dos1.writeUTF(fil);
					dos1.writeUTF(String.valueOf(pub));
					dos1.writeUTF(String.valueOf(priv));
					dos1.writeUTF(secretkey);
					dos1.writeUTF(content);
					dos1.writeUTF(h1);
					dos1.writeUTF(h2);
					dos1.writeUTF(h3);
					dos1.writeUTF(h4);
					dos1.writeUTF(h5);
					dos1.writeUTF(split1);
					dos1.writeUTF(split2);
					dos1.writeUTF(split3);
					dos1.writeUTF(split4);
					dos1.writeUTF(split5);
					//dis = new DataInputStream(socket1.getInputStream());
				//	String response = dis.readUTF();
		 
		JOptionPane.showMessageDialog(jf, "File Uploaded Successfully ", "Message From Cloud Server", JOptionPane.INFORMATION_MESSAGE);
					 } 
					 catch(Exception ex) {ex.printStackTrace();} 
					 
					 

			} 
		}

	

	public static void main(String args[]) {
		new DataOwner();
	}
}
