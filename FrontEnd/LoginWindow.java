import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.event.*;

public class LoginWindow extends Template implements ActionListener
{
    public JLabel UnameLabel,PassLabel;
    public JTextField UnameTxtField;
    public JPasswordField PassTextField;
    public JButton Submit_btn,Close_Btn;
  
    public LoginWindow()
    {
        _TopLabel.setText("Login Details"); 
        
        UnameLabel =new JLabel("Username:");
        UnameLabel.setBounds(50, 50, 75, 25);
        UnameLabel.setVisible(true);
        _UIPanel.add(UnameLabel);

        PassLabel =new JLabel("Password:");
        PassLabel.setBounds(50, 100, 75, 25);
        PassLabel.setVisible(true);
        _UIPanel.add(PassLabel);

        UnameTxtField =new JTextField();
        UnameTxtField.setBounds(150, 50, 150, 25);
        UnameTxtField.setToolTipText("Enter Username!");
        UnameTxtField.setVisible(true);
        _UIPanel.add(UnameTxtField);

        PassTextField =new JPasswordField();
        PassTextField.setBounds(150, 100, 150, 25);
        PassTextField.setToolTipText("Enter Password!");
        PassTextField.setVisible(true);
        _UIPanel.add(PassTextField);

        Submit_btn=new JButton("SUBMIT");
        Submit_btn.setBounds(150, 150, 95, 25);
        Submit_btn.addActionListener(this);
        Submit_btn.setVisible(true);
        Submit_btn.setEnabled(true);
        _UIPanel.add(Submit_btn);

        //Add Focus

    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
       
        if(ae.getSource()==Submit_btn)
        {
            String Uname = UnameTxtField.getText();
            char arr[]=PassTextField.getPassword();
            String Pass= new String(arr);    
            boolean bRet=this.Validation(Uname, Pass);
            if(bRet==true)
            {
                this.dispose();
                MainWindow mobj=new MainWindow(Uname);
            }
            else
            {
                this.dispose();
                System.exit(0);
            }
        }
    }

    final private boolean Validation(String Uname,String Password1)
    {
        if(Password1.equals(Password)==true)
		{
			return true;
		}
		else
		{
			return false;
		}
    }
    
}