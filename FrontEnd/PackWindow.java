import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.event.*;
import javax.swing.ImageIcon;

public class PackWindow extends Template implements ActionListener
{
    public JLabel DirectoryLabel,FileNameLabel;
    public JTextField DnameTxtField,FnameTxtField;
    public JButton _PrevBtn,PackBtn;
    public static  String Dname,Fname;

    public PackWindow()
    {
        _TopLabel.setText("Packing Details"); 
        
         _PrevBtn=new JButton(new ImageIcon("2.png")); 
        _PrevBtn.setBounds(0, 0, 50, 50);
        _PrevBtn.setToolTipText("Go back");
        _PrevBtn.setEnabled(true);
        _PrevBtn.setVisible(true);
        _PrevBtn.addActionListener(this);
        _HeaderPanel.add(_PrevBtn);
      
        DirectoryLabel =new JLabel("Directory Name:");
        DirectoryLabel.setBounds(50, 50, 75, 25);
        DirectoryLabel.setVisible(true);
        _UIPanel.add(DirectoryLabel);

        FileNameLabel =new JLabel("File Name:");
        FileNameLabel.setBounds(50, 100, 75, 25);
        FileNameLabel.setVisible(true);
        _UIPanel.add(FileNameLabel);

        DnameTxtField =new JTextField();
        DnameTxtField.setBounds(150, 50, 150, 25);
        DnameTxtField.setToolTipText("Enter Directory Name");
        DnameTxtField.setVisible(true);
        _UIPanel.add(DnameTxtField);

        FnameTxtField =new JTextField();
        FnameTxtField.setBounds(150, 100, 150, 25);
        FnameTxtField.setToolTipText("Enter File Name");
        FnameTxtField.setVisible(true);
        _UIPanel.add(FnameTxtField);

        PackBtn=new JButton("Pack");
        PackBtn.setBounds(150, 150, 100, 25);
        PackBtn.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        PackBtn.setToolTipText("Press to pack!");
        PackBtn.setEnabled(true);
        PackBtn.setVisible(true);
        PackBtn.addActionListener(this);
        _UIPanel.add(PackBtn);

        
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
       
        if(ae.getSource()==PackBtn)
        {
            Dname=DnameTxtField.getText();
            Fname=FnameTxtField.getText();
            try
            {
                Pack pobj=new Pack(Dname, Fname);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            this.dispose();
            MainWindow mobj1=new MainWindow(USR_NAME);

        }
        if(ae.getSource()==_PrevBtn)
        {
            this.dispose();
            MainWindow mobj1=new MainWindow(USR_NAME);
        }
        //Add DropDownList
    }
}
