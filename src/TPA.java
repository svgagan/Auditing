
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextField;
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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileFilter;


import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table. JTableHeader;
import javax.swing.*;



public class TPA extends JFrame {
	int col;
	public Font f3 = new Font("Times new roman", Font.BOLD, 18);
	/**
	 * 
	 */
	JScrollPane pane;
	
	JTable table;
	int v,h;
	String s,d,call,dt;
	
	public JButton cloud;
	public Vector heading;
	
	Container c;
	MenuBar mbr;
	Menu file;
	MenuItem bu, exit;
	public ImageIcon im;
	public JLabel  image;
	
	public TPA()
	{
		
		mbr = new MenuBar();
		setMenuBar(mbr);

		file = new Menu("File");

		bu = new MenuItem("Un Block");

		exit = new MenuItem("Exit");

		//file.add(bu);

		file.add(exit);
		mbr.add(file);

		
		setTitle("TPA::Privacy-Preserving Public Auditing for Secure Cloud Storage");
		
		cloud= new JButton("View All Owner Files");
		
		 c = getContentPane();
		c.setLayout(null);
		
		im = new ImageIcon(this.getClass().getResource("Tpa1.jpg"));
		
		image = new JLabel();
		image.setIcon(im);
		image.setBounds(35,-10,1350,190);
	
	   
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
		
		
		cloud.setBounds(580,550,240,45);
		
		cloud.setFont(f3);
		//cloud.setBackground(Color.WHITE);
		cloud.setForeground(new Color(0, 0, 0));
		
		cloud.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnViewActionPerformed(evt);
			}
		});
		c.add(cloud);
		c.setBackground(Color.YELLOW);

		c.add(image);
		
		int[] ports = new int[]
		              		{ 100,101,102,103};

		              		for (int i = 0; i < 4; i++)
		              		{
		              			Thread t = new Thread(new PortListener11(ports[i]));
		              			t.setName("Listener-" + ports[i]);
		              			t.start();

		              		}
		
	}
	
	private void btnUnBlockActionPerformed(ActionEvent evt)
	{
		//UnBlockUser buser=new UnBlockUser();
		
		//buser.setSize(400,100);
	//	buser.setVisible(true);
		
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
			 
			// heading.addElement("Secret Key");
			 
		
			 heading.addElement("B1-MAC");
			 heading.addElement("B2-MAC");
			 heading.addElement("B3-MAC");
			 heading.addElement("B4-MAC");
			 heading.addElement("B5-MAC");
			 
			 
					  Vector data=new Vector();
			             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			             Connection connect =DriverManager.getConnection("jdbc:odbc:privacy");
			             Statement stmt = connect.createStatement();
			             
			             
			             String query = "SELECT FName,s1hash,s2hash,s3hash,s4hash,s5hash FROM TPAFiles";
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
					 
					  pane.setBounds(180,220,1000,300);
		c.add(pane);
		
			 } 
			 catch(Exception ex) {ex.printStackTrace();} 	
	}
	public static void main(String[] args) {
		
		
		try
		{
			

			TPA tpa = new TPA();

				UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");

				SwingUtilities.updateComponentTreeUI(tpa);

				tpa.setSize(1020,600);
				tpa.setVisible(true);
				

		}
		catch(Exception ex)
		{

System.out.println(ex);

		}
		
		
		
		
		
	
	
	}
	
}
class PortListener11 implements Runnable
{

	BufferedOutputStream bos = null;
	ServerSocket ss1, ss2;
	Socket s1, s2;
	ServerSocket server, server1,server2,server3;
	Socket connection, so;
	BufferedReader br = null;
	int port;

	public PortListener11(int port)
	{
		this.port = port;
	}

	public void run()
	{
		Connection connect;


		
		 if(this.port==100)
		
		{
			
			
			
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				connect = DriverManager.getConnection("jdbc:odbc:privacy"); 
				ServerSocket server1 = new ServerSocket(100);
                Socket con;
				while (true) 
				{
					con = server1.accept();
					DataInputStream dis = new DataInputStream(con.getInputStream());
					
					String fname= dis.readUTF();
					
					String pubk= dis.readUTF();
				
					String privk= dis.readUTF();

					String sk= dis.readUTF();
					
	
					String s1hash = dis.readUTF();
					String s2hash = dis.readUTF();
					String s3hash = dis.readUTF();
					String s4hash = dis.readUTF();
					String s5hash = dis.readUTF();
					
						Statement stmt = connect.createStatement();
						String query = "insert into TPAFiles values('" + fname + "','" + pubk+ "','" + privk+ "','" + sk+ "','"+s1hash+"','"+s2hash+"','"+s3hash+"','"+s4hash+"','"+s5hash+"')";
						stmt.executeUpdate(query);
						
						

						

					}

			
				}
				catch(Exception e){System.out.println(e);}
			
			
			
			
			
		}
		 
		 else if(this.port==101)
		 {
			 /*try
				{String fname1=null;
				String sk1=null;
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					connect = DriverManager.getConnection("jdbc:odbc:stom"); 
					ServerSocket server2 = new ServerSocket(101);
	                Socket con1;
					while (true) 
					{
						con1 = server2.accept();
						DataInputStream dis1 = new DataInputStream(con1.getInputStream());
						
					
						
						String fname= dis1.readUTF();
						String pubk= dis1.readUTF();
						String csname= dis1.readUTF();
						String fbname= dis1.readUTF();
							
						
					    	Statement stmt = connect.createStatement();
							String query = "select * from TPAFiles where FName='"+fname+"' and fbname='"+fbname+"' and cloudname='"+csname+"' ";
							ResultSet rs=stmt.executeQuery(query);
							
							if(rs.next()==true)
							{
								Statement stmt2 = connect.createStatement();
								String query2 = "update TPAFiles set PubK='"+pubk+"' where FName='"+fname+"' and fbname='"+fbname+"' and cloudname='"+csname+"' ";
								stmt2.executeUpdate(query2);
								
		
											
							}
							
							
						
					}
					
					
					}
					catch(Exception e){System.out.println(e);}*/
				
			 
		 }
		 
		 else if(this.port==102)
		 {
			 try
				{
				
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					connect = DriverManager.getConnection("jdbc:odbc:privacy"); 
					 server3 = new ServerSocket(102);
	                Socket con2;
					while (true) 
					{
						con2 = server3.accept();
						DataInputStream dis11 = new DataInputStream(con2.getInputStream());
						
						String request= dis11.readUTF();
						
						String fname= dis11.readUTF();
						
						String fbname= dis11.readUTF();
						
						
						
					
					
						
						System.out.println(fname);
					
						System.out.println(request);
						
						
						
						

						if(request.equals("VerifyFile"))
						{						
//							Statement stmt = connect.createStatement();
//							String query = "select * from TPAFiles where FName='"+fname+"' and fbname='"+fbname+"' and cloudname='"+csn+"' ";
//							ResultSet rs=stmt.executeQuery(query);
//							
//							if(rs.next()==true)
//							{
//							    String sh1hash = rs.getString(7);
//							    String sh2hash = rs.getString(8);
//							    String sh3hash = rs.getString(9);
//							    String sh4hash = rs.getString(10);
//							    String sh5hash = rs.getString(11);
								
							    
								
								
									Socket client = new Socket("localhost",10012);

									DataOutputStream dos1 = new DataOutputStream(client.getOutputStream());
									dos1.writeUTF(fname);
									dos1.writeUTF(fbname);
									
									DataInputStream in = new DataInputStream(client.getInputStream());
									
									String hash= in.readUTF();
									 fname= in.readUTF();
									 fbname= in.readUTF();
									 
									 
									 Statement stmt = connect.createStatement();
									 String sql = "select * from TPAFiles where FName='"+fname+"'";
										
										if(fbname.equals("B1"))
										{
											String sp1="";
											ResultSet rs = stmt.executeQuery(sql);
											if(rs.next()==true)
											{
											 sp1 = rs.getString(5);
											}
											if(hash.equals(sp1))
											{
												String message = "BLOCK1 SAFE";
												 
												DataOutputStream os = new DataOutputStream(con2.getOutputStream());
												os.writeUTF(message);
											}
											else 
											{
												String message = "BLOCK1 Modified";
												
												DataOutputStream os = new DataOutputStream(con2.getOutputStream());
												os.writeUTF(message);
											}
										}
										
										if(fbname.equals("B2"))
										{
											String sp1="";
											Socket client2=null;
											DataOutputStream os2=null;
											ResultSet rs1 = stmt.executeQuery(sql);
											if(rs1.next()==true)
											{
											 sp1 = rs1.getString(6);
											 System.out.println(sp1);
											}
											if(hash.equals(sp1))
											{
												String message = "BLOCK2 SAFE";
												System.out.println(message);
												 
												 System.out.println(client2);
												 os2 = new DataOutputStream(con2.getOutputStream());
												os2.writeUTF(message);
											}
											else 
											{
												String message = "BLOCK2 Modified";
												
												 os2 = new DataOutputStream(con2.getOutputStream());
												os2.writeUTF(message);
											}
										}
										
										if(fbname.equals("B3"))
										{
											String sp3="";
											DataOutputStream os=null;
											 client=null;
											ResultSet rs2 = stmt.executeQuery(sql);
											while(rs2.next()==true)
											{
											 sp3 = rs2.getString(7);
											}
											if(hash.equals(sp3))
											{
												String message = "BLOCK3 SAFE";
												 
												 os = new DataOutputStream(con2.getOutputStream());
												os.writeUTF(message);
											}
											else 
											{
												String message = "BLOCK3 Modified";
												
												 os = new DataOutputStream(con2.getOutputStream());
												os.writeUTF(message);
											}
										}
										
										if(fbname.equals("B4"))
										{
											String sp4="";
											 client=null;
											DataOutputStream os =null;
											ResultSet rs3 = stmt.executeQuery(sql);
											while(rs3.next()==true)
											{
											 sp4 = rs3.getString(8);
											}
											if(hash.equals(sp4))
											{
												String message = "BLOCK4 SAFE";
												 
												 os = new DataOutputStream(con2.getOutputStream());
												os.writeUTF(message);
											}
											else 
											{
												String message = "BLOCK4 Modified";
												 
												os = new DataOutputStream(con2.getOutputStream());
												os.writeUTF(message);
											}
										}
										if(fbname.equals("B5"))
										{
											String sp5="";
											 client=null;
											DataOutputStream os =null;
											ResultSet rs4 = stmt.executeQuery(sql);
											while(rs4.next()==true)
											{
											 sp5 = rs4.getString(9);
											}
											if(hash.equals(sp5))
											{
												String message = "BLOCK5 SAFE";
												
												 os = new DataOutputStream(con2.getOutputStream());
												os.writeUTF(message);
											}
											else 
											{
												String message = "BLOCK5 Modified";
											 
												 os = new DataOutputStream(con2.getOutputStream());
												os.writeUTF(message);
											}
										}
				
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