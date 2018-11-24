package com.company;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
public class CarTable
{
    public CarTable()
    {
        ////////////////////////
        //headers for the carTable
        String[] columns = new String[] {
                "Id", "Name", "Hourly Rate", "Part Time"
        };

        //actual data for the carTable in a 2d array
        Object[][] data = new Object[][] {
                {1, "John", 40.0, false },
                {2, "Rambo", 70.0, false },
                {3, "Zorro", 60.0, true },
        };
        //create carTable with data
        final JTable table = new JTable(data, columns);


    }
}