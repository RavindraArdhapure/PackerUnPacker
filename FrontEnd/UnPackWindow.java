import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.event.*;
import javax.swing.ImageIcon;

public class UnPackWindow extends Template implements ActionListener
{
    public JLabel FileNameLabel;
    public JTextField FnameTxtField;
    public JButton _PrevBtn,UnPackBtn;
    public static String Fname;

    public UnPackWindow()
    {
        _TopLabel.setText("Packing Details"); 
        
         _PrevBtn=new JButton(new ImageIcon("2.png")); 
        _PrevBtn.setBounds(0, 0, 50, 50);
        _PrevBtn.setToolTipText("Go back");
        _PrevBtn.setEnabled(true);
        _PrevBtn.setVisible(true);
        _PrevBtn.addActionListener(this);
        _HeaderPanel.add(_PrevBtn);
      

        FileNameLabel =new JLabel("File Name:");
        FileNameLabel.setBounds(50, 50, 75, 25);
        FileNameLabel.setVisible(true);
        _UIPanel.add(FileNameLabel);

        FnameTxtField =new JTextField();
        FnameTxtField.setBounds(150, 50, 150, 25);
        FnameTxtField.setToolTipText("Enter File Name");
        FnameTxtField.setVisible(true);
        _UIPanel.add(FnameTxtField);

        UnPackBtn=new JButton("UnPack");
        UnPackBtn.setBounds(150, 150, 100, 25);
        UnPackBtn.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        UnPackBtn.setToolTipText("Press to Unpack!");
        UnPackBtn.setEnabled(true);
        UnPackBtn.setVisible(true);
        UnPackBtn.addActionListener(this);
        _UIPanel.add(UnPackBtn);

        
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
       
        if(ae.getSource()==UnPackBtn)
        {
            Fname=FnameTxtField.getText();
            
            this.dispose();
            try
            {
                UnPack uobj=new UnPack(Fname);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            MainWindow mobj1=new MainWindow(USR_NAME);
        }
        if(ae.getSource()==_PrevBtn)
        {
            this.dispose();
            MainWindow mobj2=new MainWindow(USR_NAME);
        }
    }
}
