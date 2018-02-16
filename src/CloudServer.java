import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import javax.crypto.Cipher;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.*;

public class CloudServer extends JFrame {
	public Font f2 = new Font("Times new roman", Font.BOLD, 16);
	int col;
	JScrollPane pane;
	
	JTable table;
	int v,h;
	String s,d,call,dt;
	
	public  JTextArea tf = new JTextArea();
	public  JTextField fname = new JTextField();
	public JScrollPane pane1 = new JScrollPane();
	Cipher encoder = null; 
	Key prKey;
	public static Key pubKey;
	public JButton cloud,modify,modify1,modify2;
	public Vector heading;
	Container c;
	MenuBar mbr;
	Menu file;
	MenuItem bu, exit;
	public ImageIcon im;
	public JLabel image;
	String org="null";
	String filename="null";
	String fil="null";
	
	public CloudServer()
	{
		tf.setColumns(200);
		tf.setRows(100);
		tf.setName("tf");
		pane1.setName("pane");
		pane1.setViewportView(tf);
		pane1.setBounds(450,380,400,300);
		
		mbr = new MenuBar();
		setMenuBar(mbr);

		file = new Menu("File");

		bu = new MenuItem("View Attackers");

		exit = new MenuItem("Exit");

		file.add(bu);
		file.add(exit);
		mbr.add(file);
		setTitle("CLOUD SERVER::Privacy-Preserving Public Auditing for Secure Cloud Storage");
		
		cloud= new JButton("View All Owner Files");
		cloud.setFont(f2);
		im = new ImageIcon(this.getClass().getResource("68.jpg"));
		
		image = new JLabel();
	    image.setIcon(im);
		image.setBounds(30,-110,1350,400);
		modify= new JButton("View Owner File Contents");
		modify.setFont(f2);
		modify1= new JButton("Modify Owner File Contents");
		modify2 = new JButton("Modify");
		modify2.setFont(f2);
		c = getContentPane();
		c.setLayout(null);
	 
		bu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnUnBlockActionPerformed(evt);
			}
		});
		
		exit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnExitActionPerformed(evt);
			}
		});
		
		
		cloud.setBounds(100,400,230,45);
			cloud.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnViewActionPerformed(evt);
			}
		});
		c.add(cloud);
		c.setBackground(Color.BLUE);
		
		
		fname.setBounds(450,345,300,30);
		modify.setBounds(100,550,230,45);
		modify.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			btnmodifyActionPerformed(evt);
		}
	});
	c.add(modify);
	
	
	
	modify1.setBounds(50,450,200,45);
	modify1.addActionListener(new java.awt.event.ActionListener() {
	public void actionPerformed(java.awt.event.ActionEvent evt) {
		btnmodify1ActionPerformed(evt);
	}
});
	
	modify2.setBounds(950,550,200,45);
	modify2.addActionListener(new java.awt.event.ActionListener() {
	public void actionPerformed(java.awt.event.ActionEvent evt) {
		btnmodify2ActionPerformed(evt);
	}
});
	
		//c.add(modify1);
		
	
      c.add(modify2);
	
		c.add(pane1);
		c.add(fname);
		
		
		c.add(image);
		int[] ports = new int[]
		              		{ 1002,10001,10003,10012,10013,10014,10015,104};

		              		for (int i = 0; i < 8; i++)
		              		{
		              			Thread t = new Thread(new PortListener(ports[i]));
		              			t.setName("Listener-" + ports[i]);
		              			t.start();

		              		}
		
	}
	
	private void btnUnBlockActionPerformed(ActionEvent evt)
	{
	ViewAttackers buser=new ViewAttackers();
	
		buser.setSize(600,600);
		buser.setVisible(true);
		buser.setBackground(Color.cyan);
		
	}
	
	private void btnmodifyActionPerformed(ActionEvent evt)
	{
		 filename = JOptionPane.showInputDialog(null,"Enter the Block Name To Be Modified");
		try
		{
			Dbcon db = new Dbcon();
			Connection con = db.getConnection();
			System.out.println(filename);
//		KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA"); 
//		 encoder = Cipher.getInstance("RSA"); 
//		 KeyPair kp = kg.generateKeyPair(); 
//		 prKey = kp.getPrivate(); 
//		
//		 pubKey = kp.getPublic(); 
//			byte[] pub = pubKey.getEncoded();
		 
		 File f=new File("cs1/temp/"+filename);
		 
		 int len = filename.length();
		  org = filename.substring(0, len-5);
		  fil = filename.substring(0, len-4);
		 
			boolean success= f.isFile();
			
			if (success)
			{
				if(fil.endsWith("1"))
				{
				fname.setText(filename);
				
				int choice=JOptionPane.showConfirmDialog(this, "File Available!!! Do u want to modify it");
				
				if(choice==0){
					
					System.out.println("Yes");
					
					FileInputStream fstream = new FileInputStream(f);
					  // Get the object of DataInputStream
					  DataInputStream in = new DataInputStream(fstream);
					  BufferedReader br = new BufferedReader(new InputStreamReader(in));
					  String strLine;
						StringBuffer buffer = new StringBuffer();
					  
					  //Read File Line By Line
					  while ((strLine = br.readLine()) != null)   {
					  // Print the content on the console
					  System.out.println (strLine);
					  
					  buffer.append(strLine + "\n");
					  
					  }
						tf.setText(buffer.toString());
					
					  //Close the input stream
					  in.close();
					  
					  
					 
					
					
				}
				if(choice==1){
					
					
					System.out.println("No");
					
					fname.setText(" ");
				}
				
			
				}
				
		 else if(fil.endsWith("2"))
				{
				fname.setText(filename);
				
				int choice=JOptionPane.showConfirmDialog(this, "File Available!!! Do u want to modify it");
				
				if(choice==0){
					
					System.out.println("Yes");
					
					FileInputStream fstream = new FileInputStream(f);
					  // Get the object of DataInputStream
					  DataInputStream in = new DataInputStream(fstream);
					  BufferedReader br = new BufferedReader(new InputStreamReader(in));
					  String strLine;
						StringBuffer buffer = new StringBuffer();
					  
					  //Read File Line By Line
					  while ((strLine = br.readLine()) != null)   {
					  // Print the content on the console
					  System.out.println (strLine);
					  
					  buffer.append(strLine + "\n");
					  
					  }
						tf.setText(buffer.toString());
					
					  //Close the input stream
					  in.close();
					  
					  
					 
					
					
				}
				if(choice==1){
					
					
					System.out.println("No");
					
					fname.setText(" ");
				}
				
			
				}
				
				
			else if(fil.endsWith("3"))
				{
				fname.setText(filename);
				
				int choice=JOptionPane.showConfirmDialog(this, "File Available!!! Do u want to modify it");
				
				if(choice==0){
					
					System.out.println("Yes");
					
					FileInputStream fstream = new FileInputStream(f);
					  // Get the object of DataInputStream
					  DataInputStream in = new DataInputStream(fstream);
					  BufferedReader br = new BufferedReader(new InputStreamReader(in));
					  String strLine;
						StringBuffer buffer = new StringBuffer();
					  
					  //Read File Line By Line
					  while ((strLine = br.readLine()) != null)   {
					  // Print the content on the console
					  System.out.println (strLine);
					  
					  buffer.append(strLine + "\n");
					  
					  }
						tf.setText(buffer.toString());
					
					  //Close the input stream
					  in.close();
					  
					  
					 
					
					
				}
				if(choice==1){
					
					
					System.out.println("No");
					
					fname.setText(" ");
				}
				
			
				}
				
		else if(fil.endsWith("4"))
				{
				fname.setText(filename);
				
				int choice=JOptionPane.showConfirmDialog(this, "File Available!!! Do u want to modify it");
				
				if(choice==0){
					
					System.out.println("Yes");
					
					FileInputStream fstream = new FileInputStream(f);
					  // Get the object of DataInputStream
					  DataInputStream in = new DataInputStream(fstream);
					  BufferedReader br = new BufferedReader(new InputStreamReader(in));
					  String strLine;
						StringBuffer buffer = new StringBuffer();
					  
					  //Read File Line By Line
					  while ((strLine = br.readLine()) != null)   {
					  // Print the content on the console
					  System.out.println (strLine);
					  
					  buffer.append(strLine + "\n");
					  
					  }
						tf.setText(buffer.toString());
					
					  //Close the input stream
					  in.close();
					  
					  
					 
					
					
				}
				if(choice==1){
					
					
					System.out.println("No");
					
					fname.setText(" ");
				}
				
			
				}
				
		  else if(fil.endsWith("5"))
				{
				fname.setText(filename);
				
				int choice=JOptionPane.showConfirmDialog(this, "File Available!!! Do u want to modify it");
				
				if(choice==0){
					
					System.out.println("Yes");
					
					FileInputStream fstream = new FileInputStream(f);
					  // Get the object of DataInputStream
					  DataInputStream in = new DataInputStream(fstream);
					  BufferedReader br = new BufferedReader(new InputStreamReader(in));
					  String strLine;
						StringBuffer buffer = new StringBuffer();
					  
					  //Read File Line By Line
					  while ((strLine = br.readLine()) != null)   {
					  // Print the content on the console
					  System.out.println (strLine);
					  
					  buffer.append(strLine + "\n");
					  
					  }
						tf.setText(buffer.toString());
					
					  //Close the input stream
					  in.close();
					  
					  
					 
					
					
				}
				if(choice==1){
					
					
					System.out.println("No");
					
					fname.setText(" ");
				}
				
			
				}
				
			
			
			
			}
			else if (!success){JOptionPane.showMessageDialog(this, "File Not Available"); }
			
		 
		}
		catch(Exception e){System.out.println(e);}
		
	}
	
	
	private void btnmodify1ActionPerformed(ActionEvent evt)
	{
		
		/*try
		{
		KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA"); 
		 encoder = Cipher.getInstance("RSA"); 
		 KeyPair kp = kg.generateKeyPair(); 
		 prKey = kp.getPrivate(); 
		
		 pubKey = kp.getPublic(); 
			byte[] pub = pubKey.getEncoded();
		 byte[] priv = prKey.getEncoded();
		 
		
		 Socket socket1 = new Socket("localhost", 101);
		 DataOutputStream dos1 = new DataOutputStream(socket1.getOutputStream());
			dos1.writeUTF(fname.getText());
			dos1.writeUTF(String.valueOf(pub));
			dos1.writeUTF("CS1");
			dos1.writeUTF("B1");
			
		 
			JOptionPane.showMessageDialog(this, fname.getText()+"is Modified  ", "Message From TPA", JOptionPane.INFORMATION_MESSAGE);
		 
			
		}
		catch(Exception e){System.out.println(e);}*/
		
	}
	
	
	private void btnmodify2ActionPerformed(ActionEvent evt)
	{
		Dbcon db = new Dbcon();
		Connection con = db.getConnection();
		Socket s;
		DataOutputStream ds;
		try
		{
			
			
			

			  String modified = tf.getText();
			  System.out.println(";;;;;;;;;;;;;;;;;;;;;;");
			  System.out.println(";;;;;;;;;;;;;;;;;;;;;;");
			  System.out.println(";;;;;;;;;;;;;;;;;;;;;;;;;;");
			  System.out.println(modified);
			  
			  if(fil.endsWith("1"))
			  {
			  
			  PrintStream out10 = null;
				try {
					System.out.println("hhhhhhhhhhhhhhhhhhhhhhhh");
				    out10 = new PrintStream(new FileOutputStream("cs1/temp/"+filename));
				    out10.print(modified);
				    System.out.println("ggggggggggggggggggggggggg");
				}
				finally {
				    if (out10 != null) out10.close();
				}
			  
			  
			  MessageDigest md = MessageDigest.getInstance("SHA1");
				System.out.println("Hellllllll");
				FileInputStream fis1 = new FileInputStream("cs1\\"+"temp\\"+filename);//C:\java\mtechproject\cloudcomputing\pra1.txt
				DigestInputStream dis1 = new DigestInputStream(fis1, md);
				BufferedInputStream bis1 = new BufferedInputStream(dis1);
	 
				//Read the bis so SHA1 is auto calculated at dis
				while (true) {
					int b1 = bis1.read();
					if (b1 == -1)
						break;
				}
	 
				BigInteger bi1 = new BigInteger(md.digest());
			String	 h1 = bi1.toString(16);
				System.out.println(h1);
				
				Statement stmt = con.createStatement();
				String sql = "update  cs1 set sp1hash='"+h1+"'where FName='"+org+"'";
			   stmt.executeUpdate(sql);
			   s=new Socket("localhost",3333);
			   ds=new DataOutputStream(s.getOutputStream());
			   ds.writeUTF(fil);
			   
			   
			  }
			  
			  else if(fil.endsWith("2"))
			  {
				  PrintStream out10 = null;
					try {
						System.out.println("hhhhhhhhhhhhhhhhhhhhhhhh");
					    out10 = new PrintStream(new FileOutputStream("cs1/temp/"+filename));
					    out10.print(modified);
					    System.out.println("ggggggggggggggggggggggggg");
					}
					finally {
					    if (out10 != null) out10.close();
					}
				  
				  
				  MessageDigest md = MessageDigest.getInstance("SHA1");
					System.out.println("Hellllllll");
					FileInputStream fis1 = new FileInputStream("cs1\\"+"temp\\"+filename);//C:\java\mtechproject\cloudcomputing\pra1.txt
					DigestInputStream dis1 = new DigestInputStream(fis1, md);
					BufferedInputStream bis1 = new BufferedInputStream(dis1);
		 
					//Read the bis so SHA1 is auto calculated at dis
					while (true) {
						int b1 = bis1.read();
						if (b1 == -1)
							break;
					}
		 
					BigInteger bi1 = new BigInteger(md.digest());
				String	 h2 = bi1.toString(16);
					System.out.println(h2);
					
					Statement stmt = con.createStatement();
					String sql = "update  cs1 set sp2hash='"+h2+"'where FName='"+org+"'";
				   stmt.executeUpdate(sql);
				  
				   s=new Socket("localhost",3333);
				   ds=new DataOutputStream(s.getOutputStream());
				   ds.writeUTF(fil);
				  
				  
			  }
			  
			  else if(fil.endsWith("3"))
			  {
				 
				  PrintStream out10 = null;
					try {
						System.out.println("hhhhhhhhhhhhhhhhhhhhhhhh");
					    out10 = new PrintStream(new FileOutputStream("cs1/temp/"+filename));
					    out10.print(modified);
					    System.out.println("ggggggggggggggggggggggggg");
					}
					finally {
					    if (out10 != null) out10.close();
					}
				  
				  
				  MessageDigest md = MessageDigest.getInstance("SHA1");
					System.out.println("Hellllllll");
					FileInputStream fis1 = new FileInputStream("cs1\\"+"temp\\"+filename);//C:\java\mtechproject\cloudcomputing\pra1.txt
					DigestInputStream dis1 = new DigestInputStream(fis1, md);
					BufferedInputStream bis1 = new BufferedInputStream(dis1);
		 
					//Read the bis so SHA1 is auto calculated at dis
					while (true) {
						int b1 = bis1.read();
						if (b1 == -1)
							break;
					}
		 
					BigInteger bi1 = new BigInteger(md.digest());
				String	 h3 = bi1.toString(16);
					System.out.println(h3);
					
					Statement stmt = con.createStatement();
					String sql = "update  cs1 set sp3hash='"+h3+"'where FName='"+org+"'";
				   stmt.executeUpdate(sql);
				  
				   s=new Socket("localhost",3333);
				   ds=new DataOutputStream(s.getOutputStream());
				   ds.writeUTF(fil);
				  
			  }
			  
			  else if(fil.endsWith("4"))
			  {
				 
				  PrintStream out10 = null;
					try {
						System.out.println("hhhhhhhhhhhhhhhhhhhhhhhh");
					    out10 = new PrintStream(new FileOutputStream("cs1/temp/"+filename));
					    out10.print(modified);
					    System.out.println("ggggggggggggggggggggggggg");
					}
					finally {
					    if (out10 != null) out10.close();
					}
				  
				  
				  MessageDigest md = MessageDigest.getInstance("SHA1");
					System.out.println("Hellllllll");
					FileInputStream fis1 = new FileInputStream("cs1\\"+"temp\\"+filename);//C:\java\mtechproject\cloudcomputing\pra1.txt
					DigestInputStream dis1 = new DigestInputStream(fis1, md);
					BufferedInputStream bis1 = new BufferedInputStream(dis1);
		 
					//Read the bis so SHA1 is auto calculated at dis
					while (true) {
						int b1 = bis1.read();
						if (b1 == -1)
							break;
					}
		 
					BigInteger bi1 = new BigInteger(md.digest());
				String	 h4 = bi1.toString(16);
					System.out.println(h4);
					
					Statement stmt = con.createStatement();
					String sql = "update  cs1 set sp4hash='"+h4+"'where FName='"+org+"'";
				   stmt.executeUpdate(sql);
				  
				   s=new Socket("localhost",3333);
				   ds=new DataOutputStream(s.getOutputStream());
				   ds.writeUTF(fil);
				  
			  }
			  
			  else if(fil.endsWith("5"))
			  {
				  PrintStream out10 = null;
					try {
						System.out.println("hhhhhhhhhhhhhhhhhhhhhhhh");
					    out10 = new PrintStream(new FileOutputStream("cs1/temp/"+filename));
					    out10.print(modified);
					    System.out.println("ggggggggggggggggggggggggg");
					}
					finally {
					    if (out10 != null) out10.close();
					}
				  
				  
				  MessageDigest md = MessageDigest.getInstance("SHA1");
					System.out.println("Hellllllll");
					FileInputStream fis1 = new FileInputStream("cs1\\"+"temp\\"+filename);//C:\java\mtechproject\cloudcomputing\pra1.txt
					DigestInputStream dis1 = new DigestInputStream(fis1, md);
					BufferedInputStream bis1 = new BufferedInputStream(dis1);
		 
					//Read the bis so SHA1 is auto calculated at dis
					while (true) {
						int b1 = bis1.read();
						if (b1 == -1)
							break;
					}
		 
					BigInteger bi1 = new BigInteger(md.digest());
				String	 h5 = bi1.toString(16);
					System.out.println(h5);
					
					Statement stmt = con.createStatement();
					String sql = "update  cs1 set sp5hash='"+h5+"'where FName='"+org+"'";
				   stmt.executeUpdate(sql);
				  
				   s=new Socket("localhost",3333);
				   ds=new DataOutputStream(s.getOutputStream());
				   ds.writeUTF(fil);
				  
			  }
		 
			JOptionPane.showMessageDialog(this, fname.getText()+"is Modified  ", "Message From TPA", JOptionPane.INFORMATION_MESSAGE);
		 
			
		}
		catch(Exception e){System.out.println(e);}
		
	}
	
	
	private void btnExitActionPerformed(ActionEvent evt)
	{
		
		System.exit(0);
		
	}
	private void btnViewActionPerformed(ActionEvent evt)
	{
		
		
		try { 
			
				 
			 Vector heading = new Vector();
			 
			 heading.addElement("File Name");
			 heading.addElement("Public Key");
			 heading.addElement("Private Key");
			 heading.addElement("Secret Key");
			 heading.addElement("B1-MAC");
			 heading.addElement("B2-MAC");
			 heading.addElement("B3-MAC");
			 heading.addElement("B4-MAC");
			 heading.addElement("B5-MAC");
			 
					  Vector data=new Vector();
			             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			             Connection connect =DriverManager.getConnection("jdbc:odbc:privacy");
			             Statement stmt = connect.createStatement();
			             
			             
			             String query = "SELECT * FROM cs1";
			             ResultSet rs = stmt.executeQuery(query);



			    


			ResultSetMetaData rsm=rs.getMetaData();
			int col=rsm.getColumnCount();



			            while(rs.next())
			             {
			Vector row = new Vector();
			  for(int i = 1; i <=col; i++){
			                   row.addElement(rs.getObject(i));

			             }

			data.addElement(row);
			             }
					  
					JTable table = new JTable(data,heading);
					  
					  pane = new JScrollPane(table);
					 
					  pane.setBounds(150,190,1100,150);
					  c.add(pane);
					 
			 } 
			 catch(Exception ex) {ex.printStackTrace();} 	
	}
	public static void main(String[] args) {
		
		try
		{
			

			   CloudServer cs = new CloudServer();
				cs.setSize(1120,750);
				cs.setVisible(true);

		}
		catch(Exception ex)
		{

System.out.println(ex);

		}
		
	}
	
}
class PortListener implements Runnable
{

	BufferedOutputStream bos = null;
	ServerSocket ss1, ss2;
	Socket s1, s2;
	ServerSocket server, server1,server2,server3;
	Socket connection, so;
	BufferedReader br = null;
	int port;

	public PortListener(int port)
	{
		this.port = port;
	}

	public void run()
	{
		Connection connect;


		
		 if(this.port==1002)
		
		{
			
			
			
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				connect = DriverManager.getConnection("jdbc:odbc:privacy"); 
				ServerSocket server1 = new ServerSocket(1002);
                Socket con;
				while (true) 
				{
					con = server1.accept();
					System.out.println("connect with cs");
					DataInputStream dis = new DataInputStream(con.getInputStream());
					
					String fname= dis.readUTF();
					System.out.println(fname);
					
					String pubk= dis.readUTF();
				
					String privk= dis.readUTF();

					String sk= dis.readUTF();
					
					String ct=dis.readUTF();
					
					String h1 = dis.readUTF();
					String h2 = dis.readUTF();
					String h3 = dis.readUTF();
					String h4 = dis.readUTF();
					String h5 = dis.readUTF();
					String sp1 = dis.readUTF();
					String sp2 = dis.readUTF();
					String sp3 = dis.readUTF();
					String sp4 = dis.readUTF();
					String sp5 = dis.readUTF();
					
					Statement stmt = connect.createStatement();
						
						
						String query = "insert into cs1 values('" + fname + "','" + pubk+ "','" + privk+ "','" + sk+ "','"+h1+"','"+h2+"','"+h3+"','"+h4+"','"+h5+"')";	
						stmt.executeUpdate(query);
						
						PrintStream out0 = null;
						try {
						    out0 = new PrintStream(new FileOutputStream("cs1\\"+"temp\\"+fname+".txt"));
						    out0.print(ct);
						    
						}
						finally {
						    if (out0 != null) out0.close();
						}
						
						
						PrintStream out = null;
						try {
						    out = new PrintStream(new FileOutputStream("cs1\\"+"temp\\"+fname+"1"+".txt"));
						    out.print(sp1);
						    
						}
						finally {
						    if (out != null) out.close();
						}
						
						PrintStream out1 = null;
						try {
						    out1 = new PrintStream(new FileOutputStream("cs1\\"+"temp\\"+fname+"2"+".txt"));
						    out1.print(sp2);
						    
						}
						finally {
						    if (out1 != null) out1.close();
						}
						
						PrintStream out2 = null;
						try {
						    out2 = new PrintStream(new FileOutputStream("cs1\\"+"temp\\"+fname+"3"+".txt"));
						    out2.print(sp3);
						    
						}
						finally {
						    if (out2 != null) out2.close();
						}
						
						
						PrintStream out3 = null;
						try {
						    out3 = new PrintStream(new FileOutputStream("cs1\\"+"temp\\"+fname+"4"+".txt"));
						    out3.print(sp4);
						    
						}
						finally {
						    if (out3 != null) out3.close();
						}
						
						PrintStream out4 = null;
						try {
						    out4 = new PrintStream(new FileOutputStream("cs1\\"+"temp\\"+fname+"5"+".txt"));
						    out4.print(sp5);
						    
						}
						finally {
						    if (out4 != null) out4.close();
						}
						
						
						
						
						
					//	fos.write(ct.getBytes());
						//fos.close();
						
						//	DataOutputStream dos=new DataOutputStream(con.getOutputStream());

							//dos.writeUTF("cloudsuccess");	
						

					}

			
				}
				catch(Exception e){System.out.println(e);}
			
			
			
			
			
		}
		 
		 else if(this.port==104){
			 try {
					String fname1 = null;
					String sk1 = null;
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					connect = DriverManager.getConnection("jdbc:odbc:privacy");
					ServerSocket server22 = new ServerSocket(104);
					Socket con1;
					while (true) {
						con1 = server22.accept();
						DataInputStream dis1 = new DataInputStream(con1
								.getInputStream());

						String request = dis1.readUTF();

						String fname = dis1.readUTF();

						if (request.equals("skrequest")) {
							Statement stmt = connect.createStatement();
							String query = "select * from TPAFiles where FName='"
									+ fname + "'  ";
							ResultSet rs = stmt.executeQuery(query);

							if (rs.next() == true) {

								String skey = rs.getString("Sk");

								DataOutputStream dos1 = new DataOutputStream(con1
										.getOutputStream());
								dos1.writeUTF("success");
								dos1.writeUTF(skey);

							}
		 
						else if (rs.next() != true) {

							DataOutputStream dos1 = new DataOutputStream(con1
									.getOutputStream());

							dos1.writeUTF("failure");
							dos1.writeUTF("sk");

						}

					}

				}

			} catch (Exception e) {
				System.out.println(e);
			}

		}
		 
		 else if(this.port==10001)
		 {
			 try
				{String fname1=null;
				String sk1=null;
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					connect = DriverManager.getConnection("jdbc:odbc:privacy"); 
					ServerSocket server2 = new ServerSocket(10001);
	                Socket con1;
					while (true) 
					{
						con1 = server2.accept();
						DataInputStream dis1 = new DataInputStream(con1.getInputStream());
						
						String request= dis1.readUTF();
						
						String uname= dis1.readUTF();
						
						String fname= dis1.readUTF();
					
						String sk= dis1.readUTF();
						
						
						
						
						
						System.out.println(fname);
					
						System.out.println(sk);
						
						
						
						

						if(request.equals("UserRequest"))
						{						
							Statement stmt = connect.createStatement();
							String query = "select * from cs1 where FName='"+fname+"' and SK='"+sk+"'  ";
							ResultSet rs=stmt.executeQuery(query);
							
							if(rs.next()==true)
							{
								
								
								
								
								 fname1=rs.getString("FName");
								 sk1=rs.getString("SK");
							

							 FileInputStream fis = new FileInputStream("cs1/"
										+ fname1);
								byte b[] = new byte[fis.available()];
								fis.read(b);
								String content = new String(b);
								
								
							
								DataOutputStream dos1 = new DataOutputStream(con1.getOutputStream());

								dos1.writeUTF("success");
								dos1.writeUTF(fname1);
								dos1.writeUTF(sk1);
									dos1.writeUTF(content);
									
									dos1.close();
									
									
									
									
									
								
											
							}
							
							else if(rs.next()!=true)
							{
								
								
								DataOutputStream dos1 = new DataOutputStream(con1.getOutputStream());
									
								dos1.writeUTF("failure");
								

								Statement stmt1 = connect.createStatement();
								String query1 = "insert into BlockedUser values('"+uname+"','"+fname+"','"+sk+"')";
								stmt.executeUpdate(query1);
								
							}
							
							

						}
						
						
					}
					
					
					}
					catch(Exception e){System.out.println(e);}
				
			 
		 }
		 
		 else if(this.port==10003)
		 {
			 try
				{
				
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					connect = DriverManager.getConnection("jdbc:odbc:privacy"); 
					 server3 = new ServerSocket(10003);
	                Socket con2;
					while (true) 
					{
						con2 = server3.accept();
						DataInputStream dis11 = new DataInputStream(con2.getInputStream());
						
						String request= dis11.readUTF();
						
						String fname= dis11.readUTF();
						
						
					
					
						
						System.out.println(fname);
					
						System.out.println(request);
						
						
						
						

						if(request.equals("FileDelete"))
						{						
							Statement stmt = connect.createStatement();
							String query = "delete  from cs1 where FName='"+fname+"'   ";
							stmt.executeUpdate(query);
							
							//if(rs.next()==true)
							//{
								
							 File f=new File("cs1/"+fname);
							 
							boolean success= f.delete();
							
							if (!success){
								DataOutputStream dos112 = new DataOutputStream(con2.getOutputStream());
								
								dos112.writeUTF("failure");
								
							}else{
								DataOutputStream dos111 = new DataOutputStream(con2.getOutputStream());
								
								dos111.writeUTF("success");
							}
						
								//}
								
							
							
							//else if(rs.next()!=true)
							//{
								
								
								

								
								
						//	}
							
							

						}
						
						
					}
					
					
					}
					catch(Exception e){System.out.println(e);}
				
			 
		 }
		 else if(this.port==10012)
		 {
			 try
				{
				
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					connect = DriverManager.getConnection("jdbc:odbc:privacy"); 
					 server3 = new ServerSocket(10012);
	                Socket con2;
					while (true) 
					{
						con2 = server3.accept();
						DataInputStream dis11 = new DataInputStream(con2.getInputStream());
						
						
						
						String fname= dis11.readUTF();
						String bnname= dis11.readUTF();
						
					
					
						String sql = "select * from cs1 where FName='"+fname+"'";
						Statement stmt = connect.createStatement();
						String servername="CS1";
						
						System.out.println(fname);
					
						System.out.println(bnname);
						
						if(bnname.equals("B1"))
						{
							
							ResultSet rs = stmt.executeQuery(sql);
							while(rs.next()==true)
							{
								DataOutputStream out;
							
								try
								{
								String h1 = rs.getString(5);
								System.out.println(h1);
								
								
								 out = new DataOutputStream(con2.getOutputStream());
								out.writeUTF(h1);
								out.writeUTF(fname);
								out.writeUTF(bnname);
								
								}
							catch(Exception e)
								{
									e.printStackTrace();
								
								}
							}
						}
						else if(bnname.equals("B2"))
						{
							
							DataOutputStream out2=null;
							ResultSet rs1 = stmt.executeQuery(sql);
							if(rs1.next()==true)
							{
								String h2 = rs1.getString(6);
							
								System.out.println(h2);
							
								
								 out2 = new DataOutputStream(con2.getOutputStream());
								out2.writeUTF(h2);
								out2.writeUTF(fname);
								out2.writeUTF(bnname);
								
							}
							
							
							
							
						}
						
						else if(bnname.equals("B3"))
						{
							
							DataOutputStream out3=null;
							ResultSet rs3 = stmt.executeQuery(sql);
							if(rs3.next()==true)
							{
								String h3 = rs3.getString(7);
								
								
								 out3 = new DataOutputStream(con2.getOutputStream());
								out3.writeUTF(h3);
								out3.writeUTF(fname);
								out3.writeUTF(bnname);
								
							}
						
						}
						else if(bnname.equals("B4"))
						{
							
							DataOutputStream out4=null;
							ResultSet rs4 = stmt.executeQuery(sql);
							if(rs4.next()==true)
							{
								String h4 = rs4.getString(8);
								
							
								 out4 = new DataOutputStream(con2.getOutputStream());
								out4.writeUTF(h4);
								out4.writeUTF(fname);
								out4.writeUTF(bnname);
								
							}
							
							
						}
						else if(bnname.equals("B5"))
						{
							
							DataOutputStream out5=null;
							ResultSet rs5 = stmt.executeQuery(sql);
							if(rs5.next()==true)
							{
								String h5 = rs5.getString(9);
								
								out5 = new DataOutputStream(con2.getOutputStream());
								out5.writeUTF(h5);
								out5.writeUTF(fname);
								out5.writeUTF(bnname);
								
							}
							
							
						}
						
						
						
							
						}
							
						}
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
						
			 
		 }
		 
		 else if(this.port==10013)
		 {
			 ServerSocket ss ;
			 Socket client ;
			 DataInputStream din ;
			 DataOutputStream ds;
			 try
			 {
				 ss = new ServerSocket(10013);
			 while(true)
			 {
				 
				
				 client = ss.accept();
				 
				 din = new DataInputStream(client.getInputStream());
				 
		     String uname= din.readUTF();
			 String fname = din.readUTF();
			 String sk = din.readUTF();
				 
			 
				 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				 Connection con = DriverManager.getConnection("jdbc:odbc:privacy");
				 
				

				 
				 
			 Date now = new Date();
			 SimpleDateFormat sdfDate = new SimpleDateFormat(
				"dd/MM/yyyy");
		SimpleDateFormat sdfTime = new SimpleDateFormat(
				"HH:mm:ss");
				String strDate = sdfDate.format(now);
				String strTime = sdfTime.format(now);

				String dt = strDate + " " + strTime;
				 
			 
			 String cname="cs1";
			 Statement stmt = con.createStatement();
			 String sql = "select * from cs1 where FName='"+fname+"' and Sk='"+sk+"'";
			 ResultSet rs = stmt.executeQuery(sql);
			 
			 if(rs.next()==true)
			 {
				
				
				 MergeFile mf = new MergeFile();
				  mf.mergeFiles(fname,cname);
				 
				  FileInputStream fs = new FileInputStream("cs1\\temp\\"+fname+"o"+".txt");
				  byte bs1[] = new byte[fs.available()];
				  fs.read(bs1);
				  String file = new String(bs1);
			 
					  ds = new DataOutputStream(client.getOutputStream());
					 
					  ds.writeUTF(file);
					  ds.writeUTF("success");
				
			 }
			 else 
			 {
				 
				 DataOutputStream  ds1 = new DataOutputStream(client.getOutputStream());
				  ds1.writeUTF("");
				  ds1.writeUTF("failure");
				  
				  Statement st1=con.createStatement();
				  st1.executeUpdate("insert into Attacker values('"+uname+"','"+fname+"','"+sk+"','"+dt+"')");
				   
				  
			 }
			 
			 }
			 }
			 
			 
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			
				 
			 }
			 
		 
		 
		 else if(this.port==10014)
		 {
			 ServerSocket sc =null;
			 Socket s = null;
			 DataInputStream in =null;
			 
			 try
			 {
				 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				 Connection con = DriverManager.getConnection("jdbc:odbc:privacy");
				 Statement stmt = con.createStatement();
				 sc = new ServerSocket(10014);
				while(true){
				 s = sc.accept();
				 in = new DataInputStream(s.getInputStream());
				 System.out.println("cs");
				 
				 String file = in.readUTF();
				 String sql = "Delete * from cs1 where FName='"+file+"'";
				 stmt.executeUpdate(sql);
				 new File("cs1\\temp\\"+file+".txt").delete();
				 new File("cs1\\temp\\"+file+"1"+".txt").delete();
				 new File("cs1\\temp\\"+file+"2"+".txt").delete();
				 new File("cs1\\temp\\"+file+"3"+".txt").delete();
				 new File("cs1\\temp\\"+file+"4"+".txt").delete();
				 new File("cs1\\temp\\"+file+"5"+".txt").delete();
				
				 
				 DataOutputStream ds = new DataOutputStream(s.getOutputStream());
				 ds.writeUTF("Files Deleted");
				}
			 }
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			 
			 
			 
		 }
		 
		 else if(this.port==10015)
		 {
			 ServerSocket sc ;
			 Socket s ;
			 DataInputStream in ;
			 DataOutputStream ds ;
			
			 
			 try
			 {
				 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				    Connection con=DriverManager.getConnection("jdbc:odbc:privacy");
				    Statement stmt = con.createStatement();
				 sc = new ServerSocket(10015);
				while(true){ 
				 s = sc.accept();
				in = new DataInputStream(s.getInputStream());
				
				String fname = in.readUTF();
				String bn = in.readUTF();
				String file = in.readUTF();
				String hash = in.readUTF();
				System.out.println(file);
				
				
			    
			    if(bn.equals("B1"))
			    {
			    	
					
			    	PrintStream ps = new PrintStream(new FileOutputStream("cs1\\temp\\"+fname+"1"+".txt"));
			    	ps.print(file);
			    	ps.close();
			    	
			    	
			    	String sql = "update cs1 set sp1hash='"+hash+"' where FName='"+fname+"'";
			    	stmt.executeUpdate(sql);
			    	
			    	ds = new DataOutputStream(s.getOutputStream());
			    	ds.writeUTF("Updated Successfully");
			    }
			    
			    
			    else  if(bn.equals("B2"))
			    {
			    	PrintStream ps = new PrintStream(new FileOutputStream("cs1\\temp\\"+fname+"2"+".txt"));
			    	ps.print(file);
			    	ps.close();
			    	
			    	String sql = "update cs1 set sp2hash='"+hash+"' where FName='"+fname+"'";
			    	stmt.executeUpdate(sql);
			    	
			    	System.out.println("B2B2B2B2B2B2B2B2B2B2B2B2");
			    	ds = new DataOutputStream(s.getOutputStream());
			    	ds.writeUTF("Updated Successfully");
			    	System.out.println("B2B2B2B2B2B2B2B2B2B2B2B2");
			    }
			    
			    else   if(bn.equals("B3"))
			    {
			    	PrintStream ps = new PrintStream(new FileOutputStream("cs1\\temp\\"+fname+"3"+".txt"));
			    	ps.print(file);
			    	
			    	String sql = "update cs1 set sp3hash='"+hash+"' where FName='"+fname+"'";
			    	stmt.executeUpdate(sql);
			    	
			    	ds = new DataOutputStream(s.getOutputStream());
			    	ds.writeUTF("Updated Successfully");
			    }
			    
			    else   if(bn.equals("B4"))
			    {
			    	PrintStream ps = new PrintStream(new FileOutputStream("cs1\\temp\\"+fname+"4"+".txt"));
			    	ps.print(file);
			    	
			    	String sql = "update cs1 set sp4hash='"+hash+"' where FName='"+fname+"'";
			    	stmt.executeUpdate(sql);
			    	
			    	ds = new DataOutputStream(s.getOutputStream());
			    	ds.writeUTF("Updated Successfully");
			    }
			    
			    else   if(bn.equals("B5"))
			    {
			    	PrintStream ps = new PrintStream(new FileOutputStream("cs1\\temp\\"+fname+"5"+".txt"));
			    	ps.print(file);
			    	
			    	String sql = "update cs1 set sp5hash='"+hash+"' where FName='"+fname+"'";
			    	stmt.executeUpdate(sql);
			    	
			    	ds = new DataOutputStream(s.getOutputStream());
			    	ds.writeUTF("Updated Successfully");
			    }
			    
			    
				
				}	
			 }
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			 
			 
			 
		 }
			 
		 
				
}
}	