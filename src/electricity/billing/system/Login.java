package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField text,passText;
    Choice loginChoice;
    JButton loginButton,cancelButton,signUpButton;
    Login() {
        super("Login");
        //getContentPane().setBackground(Color.GRAY);
        JLabel username=new JLabel("Username:");
        username.setBounds(300,60,100,20);
        add(username);

        text=new JTextField();
        text.setBounds(400,60,150,20);
        add(text);
        JLabel password=new JLabel("Password:");
        password.setBounds(300,100,100,20);
        add(password);
        passText=new JTextField();
        passText.setBounds(400,100,150,20);
        add(passText);
        JLabel login=new JLabel("Login In As:");
        login.setBounds(300,140,100,20);
        add(login);
        loginChoice=new Choice();
        loginChoice.add("Admin");
        loginChoice.add("Customer");
        loginChoice.setBounds(400,140,150,20);
        add(loginChoice);
        loginButton=new JButton("Login");
        loginButton.setBounds(330,180,100,20);
        loginButton.addActionListener(this);
        add(loginButton);
        cancelButton=new JButton("Cancel");
        cancelButton.setBounds(460,180,100,20);
        cancelButton.addActionListener(this);
        add(cancelButton);
        signUpButton=new JButton("Sign Up");
        signUpButton.setBounds(400,215,100,20);
        signUpButton.addActionListener(this);
        add(signUpButton);
        ImageIcon profileOne=new ImageIcon(ClassLoader.getSystemResource("icon/profile.png"));
        Image profileTwo=profileOne.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon profileThree=new ImageIcon(profileTwo);
        JLabel profile=new JLabel(profileThree);
        profile.setBounds(5,5,250,250);
        add(profile);
        setSize(640,300);
        setLocation(400,200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==loginButton){
            String username=text.getText();
            String spassword=passText.getText();
            String user=loginChoice.getSelectedItem();

            try{
                database c=new database();
                String query="select * from signup where username='"+username+"' and password='"+spassword+"' and usertype='"+user+"'";
                ResultSet resultSet=c.statement.executeQuery(query);
                if(resultSet.next()){
                    String meter=resultSet.getString("meter_no");
                    setVisible(false);
                    new main_class(user,meter);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Login");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if(e.getSource()==cancelButton){
            setVisible(false);
        }
        else if(e.getSource()==signUpButton){
            setVisible(false);
            new Signup();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
