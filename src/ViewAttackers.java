import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewAttackers extends JFrame {

	private static final long serialVersionUID = 1L;

	JPanel panel;

	JScrollPane pane;

	Container c;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	ViewAttackers() {
		setTitle("View Cloud Attackers");
		c = getContentPane();
		c.setLayout(new FlowLayout());

		c.setBackground(Color.ORANGE);

		try {

			Vector heading = new Vector();

			heading.addElement("Username");
			heading.addElement("Fname");
			heading.addElement("SecretKey");
			heading.addElement("Data & Time");

			Vector data = new Vector();

			String query = "SELECT * FROM Attacker";

			
			Dbcon con=new Dbcon();
			
			ResultSet rs =con.getConnection().createStatement().executeQuery(query);
			

			ResultSetMetaData rsm = rs.getMetaData();
			int col = rsm.getColumnCount();

			while (rs.next()) {
				Vector row = new Vector();
				for (int i = 1; i <= col; i++) {
					row.addElement(rs.getObject(i));

				}

				data.addElement(row);
			}

			JTable table = new JTable(data, heading);

			pane = new JScrollPane(table);

			pane.setBounds(50, 50, 350, 100);
			c.add(pane);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}