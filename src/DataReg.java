
//Java program to login and reset

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.lang.*;
import java.sql.Statement;
import java.util.Arrays;

import javax.swing.*;  //swing package

public class DataReg implements ActionListener 
{
	public Font f2 = new Font("Times new roman", Font.BOLD, 16);
	public Font f3 = new Font("Times new roman", Font.BOLD, 20);
	JFrame jf,ganf;								//declaration of components & containers 
	JPanel jp,ganp;
	JLabel j1,j2,j3,j4,j5,ganl,j0;
	JTextField name;
	JButton login,reset,register,logout;
	ImageIcon iicon,iicog;
	JMenu file,runn,help;
	JMenuBar jmb;
	JMenuItem resume,open,welcome;
	
	JLabel jreg,jreg1,jreg2,jreg3;
	JFrame regjf;
	JPanel panel;
	JTextField jtf;
	JPasswordField jpf,jpf1,pass;
	JButton jbu1,jbu2;
		DataReg()				//constructor
		{
			//Backgroung Image
			iicon=new ImageIcon(this.getClass().getResource("DataOwnerReg.jpg"));
			j3=new JLabel();
			j3.setIcon(iicon);
			j3.setBounds(30,0,1400,160);
			
			
			/*iicog=new ImageIcon(this.getClass().getResource("College_Picture.jpg"));
			j0=new JLabel();
			j0.setIcon(iicog);
			j0.setBounds(10,10,2500,1000);*/
			

			
			jf=new JFrame("Sign-In Page");
			jp=new JPanel();
			
			jp.setBackground(Color.DARK_GRAY);
			jf.setSize(500,500);
			jf.setVisible(true);
			
			jmb=new JMenuBar();		//Menu,Menubar & Menuitems declarations
			jf.setJMenuBar(jmb);	
			file=new JMenu("File");
			runn=new JMenu("Run");
			help=new JMenu("Help");
			
			open=new JMenuItem("Open");
			resume=new JMenuItem("Resume");
			welcome=new JMenuItem("Welcome");
			
			
			
			
			j5=new JLabel("To upload files, Authenticate yourself"); //login comment fields
			j5.setBounds(490,150,450,100);
			j5.setFont(f3);
			j5.setForeground(Color.BLACK);
			
			j1=new JLabel("UserName");     //Username fields
			j1.setBounds(520,200,100,100);
			j1.setFont(f2);
			j1.setForeground(Color.BLACK);
			name=new JTextField(10);
			name.setBounds(620,230,150,35);
			//name.setForeground(Color.green);
			
			j2=new JLabel("Password");		//Password fields
			j2.setBounds(520,250,100,100);
			j2.setFont(f2);
			j2.setForeground(Color.BLACK);
			pass=new JPasswordField(10);
			pass.setBounds(620,280,150,35);
			//pass.setForeground(Color.RED);
			
			login=new JButton("Log-In");		//sign in button
			login.setBounds(515,360,100,40);
			login.setFont(f2);
			login.setForeground(Color.BLACK);
			reset=new JButton("Reset");			//Reset button
			reset.setFont(f2);
			reset.setBounds(670,360,100,40);
			reset.setForeground(Color.BLACK);
			
			j4=new JLabel("Are you a New User then to Register,Click the below Button");		//Register fields
			j4.setBounds(490,390,350,100);
			j4.setForeground(Color.BLACK);
			register=new JButton("Register");			//Register button
			register.setBounds(590,490,100,40);
			register.setFont(f2);
			register.setForeground(Color.BLACK);
		
		
		
			//reset.setForeground(Color.WHITE);
			
			jp.setLayout(null);
			
			//jmb.add(file);
			//jmb.add(runn);
			//jmb.add(help);
			file.add(open);
			runn.add(resume);
			help.add(welcome);
				
			
			jp.add(j3);
			//jp.add(j0);
			jp.add(j5);
			jp.add(j1);						//adding items to panel
			jp.add(name);
			jp.add(j2);
			jp.add(pass);
			jp.add(login);
			jp.add(reset);
			jp.add(j4);
			jp.add(register);
			
			jf.add(jp);		//adding panel to frame
			
			
			
			
			
			
			
			login.addActionListener(this);
			register.addActionListener(this);
			reset.addActionListener(this);
				

		}
		public void gana()
		{
			
			/*ganf=new JFrame("gana");
			ganp=new JPanel();
			
			ganp.setBackground(Color.black);
			ganf.setSize(500,500);
			ganf.setVisible(true);
			
			ganl=new JLabel("Username"); //login comment fields
			ganl.setBounds(500,130,250,100);
			ganl.setForeground(Color.RED);
			
			
			ganp.setLayout(null);
			
			ganf.add(ganl);
			
			ganp.add(ganf);
			
			*/
			
			ImageIcon iigcon = new ImageIcon(this.getClass().getResource("UserReg.jpg"));
			jreg3=new JLabel();
			jreg3.setIcon(iigcon);
			jreg3.setBounds(30,0,1400,160);
			
			
			regjf=new JFrame("Register");
			
			panel=new JPanel();
			
			
			panel.setBackground(Color.LIGHT_GRAY);
			regjf.setSize(1366,768);
			regjf.setVisible(true);
			
	        //JTextField field1 = new JTextField("1234.56");
	        //JTextField field2 = new JTextField("9876.54");
	        
	        //panel.add(combo);
	        //panel.add();
	        //panel.add(field1);
	        //panel.add();
	        //panel.add(field2);
	       
	        
	        
	        
	        
			jreg=new JLabel("Username"); //login comment fields
			jreg.setBounds(500,160,250,100);
			jreg.setFont(f2);
			jreg.setForeground(Color.RED);
			
			jtf=new JTextField(10);
			jtf.setBounds(630,190,150,35);
			
			jreg1=new JLabel("Password");     //Username fields
			jreg1.setBounds(500,220,100,100);
			jreg1.setFont(f2);
			jreg1.setForeground(Color.RED);
			
			
			jpf=new JPasswordField(10);
			jpf.setBounds(630,250,150,35);
			
			jreg2=new JLabel("Confirm Password");     //Username fields
			jreg2.setBounds(500,280,200,100);
			jreg2.setFont(f2);
			jreg2.setForeground(Color.RED);
			
			jpf1=new JPasswordField(10);
			jpf1.setBounds(630,310,150,35);
			
			jbu1=new JButton("Submit");		//submit button
			jbu1.setBounds(520,420,100,40);
			jbu1.setFont(f2);
			jbu1.setForeground(Color.blue);
			
			jbu2=new JButton("Cancel");			//Cancel button
			jbu2.setBounds(700,420,100,40);
			jbu2.setFont(f2);
			jbu2.setForeground(Color.blue);
			
			
			panel.setLayout(null);
			
			panel.add(jreg3);
			panel.add(jreg);
			panel.add(jtf);
			panel.add(jreg1);
			panel.add(jpf);
			panel.add(jreg2);
			panel.add(jpf1);
			panel.add(jbu1);
			panel.add(jbu2);
			
			regjf.add(panel);
			
			
			
						
			
			
			jbu1.addActionListener(this);
			jbu2.addActionListener(this);
		}
		
public void actionPerformed(ActionEvent e) 
{
	if(e.getSource()==login)
	{
		String text=name.getText();
		//System.out.println(text);
		//char [] password=pass.getp
		char[] password=pass.getPassword();
		//System.out.println(password);
		/*if(text.equals("gana"))
		{
			JOptionPane.showMessageDialog(null,"Sucess");
		}
		*/
		try
		{	
		    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		    Connection con=DriverManager.getConnection("jdbc:odbc:privacy");
		    Statement stmt = con.createStatement();
		    ResultSet rec = stmt.executeQuery("SELECT u_name, passwd from register_login");
	        int count=0;
		    while (rec.next()) 
	        {  
	            String x = name.getText();  
	            char[] y = pass.getPassword();  
	            String yy=String.valueOf(y);
	            System.out.println(x);
	            System.out.println(yy);
        		String m=rec.getString("u_name");
        		String n=rec.getString("passwd");
	            System.out.println(m);
	            System.out.println(n);
	            if (x.equals(m))
	            {  
	                if (yy.equals(n))
	                {  
	                    System.out.println("Matched username, Logged in!");
	                    count=1;
	                    jf.setVisible(false);
	                    new DataOwner();
	                }
	                else
	                {  
	                    System.out.println("Password did not match username!"); 
	                    JOptionPane.showMessageDialog(null,"Password did not match username!");
	                    break;
	                }
	            	//System.out.println("Matched username!");
		            //System.out.println(rec.getString("u_name"));
	            }
	            /*else
	            {  
	            	System.out.println("Wrong username!");
	            }  
	            */
	        }//while  
	        if(rec.next())
	        {
	        	
	        }
	        else
	        {
	        	if(count!=1)
	        	{
	        		JOptionPane.showMessageDialog(null,"        LOGIN failed");
	        	}
	        }
	        /*int numrows=rec.getRow();
	        System.out.println(numrows);
	        //System.out.println(count);
	        if(count==numrows)
	        {
	        	
	        }*/
	        stmt.close();
		}//try
		catch (Exception e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
	}//login
	if(e.getSource()==register)
	{
		gana();
		//String[] items = {"One", "Two", "Three", "Four", "Five"};
	    //JComboBox combo = new JComboBox(items);
		//ImageIcon iicon;
			
	}
	if(e.getSource()==reset)
	{
		name.setText(null);
		pass.setText(null);
			
	}	
	if(e.getSource()==jbu1)//submit button
	{
		try
		{
			name.setText(null);
			pass.setText(null);
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:privacy");
			Statement stmt = con.createStatement();
			ResultSet rec = stmt.executeQuery("SELECT u_name from register_login");
			int there = 0;
			String reg=jtf.getText();
			System.out.println(reg);
			if(jtf.getText().equals(""))
			{
				there=2;
				JOptionPane.showMessageDialog(null,"       Registration failed...\n"+"           NULL username");
			}
			while(rec.next())
			{
			    String uname=rec.getString("u_name");
				System.out.println(uname);

				if(uname.equals(reg))
				{
					there++;
					
				}
			}
			//System.out.println(there);
			if(there==0)
			{

				char[] regpass=jpf.getPassword();
				char[] regcon=jpf1.getPassword();	
				
				String regcon2=Arrays.toString(jpf.getPassword());
				String regpass1=Arrays.toString(jpf1.getPassword());
				
				//System.out.println(regpass1);
				//System.out.println(regcon2);
				
				String regco2=String.valueOf(regpass);
				String regpas1=String.valueOf(regcon);
				
				//System.out.println(regpas1);
				//System.out.println(regco2);
				
				//System.out.println(regpas1);
				//System.out.println(regco2);
				
				if(regco2.equals("") && regpas1.equals(""))
				{
					JOptionPane.showMessageDialog(null,"       Registration failed...\n"+"           NULL Password Fields");
				}
				else if(regco2.equals(regpas1))
			    {
			    	//System.out.println("LAAAAAAAAAAm");
			    	//break;
			    	Statement stmt1 = con.createStatement();
			    	String gan=String.valueOf(regcon);
			    	String query="insert into register_login (u_name,passwd) values ('"+reg+"','"+gan+"')";
			    	stmt1.executeUpdate(query);
			    	//ResultSet rechy = stmtt.executeQuery("SELECT u_name from register_login");	
			    	stmt1.close();
			    	JOptionPane.showMessageDialog(null,"    Registration Successful");
			    	regjf.setVisible(false);
			    }
			    else
			    {
			    	JOptionPane.showMessageDialog(null,"    Password not MATCHED");
			    }
			    	
			}
			else
			{
				if(there!=2 )
				{
					JOptionPane.showMessageDialog(null,"       Registration failed..." +"\n"+"Please Change USERNAME\n"+"          '"+reg+"'");
				}	
			}
		    stmt.close();
		}//try
		catch (Exception e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	if(e.getSource()==jbu2)//cancel button
	{
		name.setText(null);
		pass.setText(null);
		regjf.setVisible(false);
				
	}
			
  }
		
  public static void main(String[] args)		//main method 
  {

		new DataReg();
  }
}
