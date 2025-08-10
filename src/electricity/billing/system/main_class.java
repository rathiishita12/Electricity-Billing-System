package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {
    String acctype,meter_pass;
    main_class(String acctype,String meter_pass) {
        this.acctype = acctype;
        this.meter_pass = meter_pass;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/ebs.png"));
        Image image=imageIcon.getImage().getScaledInstance(1530,830,Image.SCALE_DEFAULT);
        ImageIcon icon=new ImageIcon(image);
        JLabel label=new JLabel(icon);
        add(label);

        JMenuBar menuBar=new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu=new JMenu("Menu");
        menu.setFont(new Font("serif",Font.PLAIN,15));

        JMenuItem newcustomer=new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon customerImg=new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.png"));
        Image customerImage=customerImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(customerImage));
        newcustomer.addActionListener(this);
        menu.add(newcustomer);

        JMenuItem customerDetails=new JMenuItem("Customer Details");
        customerDetails.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon detailsImg=new ImageIcon(ClassLoader.getSystemResource("icon/customerDetails.png"));
        Image detailsImage=detailsImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        customerDetails.setIcon(new ImageIcon(detailsImage));
        customerDetails.addActionListener(this);
        menu.add(customerDetails);

        JMenuItem depositDetails=new JMenuItem("Deposit Details");
        depositDetails.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon depositImg=new ImageIcon(ClassLoader.getSystemResource("icon/depositDetails.png"));
        Image depositImage=depositImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        depositDetails.setIcon(new ImageIcon(depositImage));
        depositDetails.addActionListener(this);
        menu.add(depositDetails);

        JMenuItem calculateBill=new JMenuItem("Calculate Bill");
        calculateBill.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon calculateImg=new ImageIcon(ClassLoader.getSystemResource("icon/calculatorBills.png"));
        Image calculateImage=calculateImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculateBill.setIcon(new ImageIcon(calculateImage));
        calculateBill.addActionListener(this);
        menu.add(calculateBill);

        JMenu info=new JMenu("Information");
        info.setFont(new Font("serif",Font.PLAIN,15));

        JMenuItem upInfo=new JMenuItem("Update Information");
        upInfo.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon updateImg=new ImageIcon(ClassLoader.getSystemResource("icon/refresh.png"));
        Image updateImage=updateImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        upInfo.setIcon(new ImageIcon(updateImage));
        upInfo.addActionListener(this);
        info.add(upInfo);

        JMenuItem viewInfo=new JMenuItem("View Information");
        viewInfo.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon viewImg=new ImageIcon(ClassLoader.getSystemResource("icon/information.png"));
        Image viewImage=viewImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        viewInfo.setIcon(new ImageIcon(viewImage));
        viewInfo.addActionListener(this);
        info.add(viewInfo);

        JMenu user=new JMenu("User");
        user.setFont(new Font("serif",Font.PLAIN,15));

        JMenuItem payBill=new JMenuItem("Pay Bill");
        payBill.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon payBillImg=new ImageIcon(ClassLoader.getSystemResource("icon/pay.png"));
        Image payBillImage=payBillImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        payBill.setIcon(new ImageIcon(payBillImage));
        payBill.addActionListener(this);
        user.add(payBill);

        JMenuItem billDetails=new JMenuItem("Bill Details");
        billDetails.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon billDetailsImg=new ImageIcon(ClassLoader.getSystemResource("icon/detail.png"));
        Image billDetailsImage=billDetailsImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        billDetails.setIcon(new ImageIcon(billDetailsImage));
        billDetails.addActionListener(this);
        user.add(billDetails);

        JMenu bill=new JMenu("Bill");
        bill.setFont(new Font("serif",Font.PLAIN,15));

        JMenuItem generateBill=new JMenuItem("Generate Bill");
        generateBill.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon generateBillImg=new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image generateBillImage=generateBillImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        generateBill.setIcon(new ImageIcon(generateBillImage));
        generateBill.addActionListener(this);
        bill.add(generateBill);

        JMenu utility=new JMenu("Utility");
        utility.setFont(new Font("serif",Font.PLAIN,15));

        JMenuItem notepad=new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon notepadImg=new ImageIcon(ClassLoader.getSystemResource("icon/notepad.png"));
        Image notepadImage=notepadImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(notepadImage));
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calculator=new JMenuItem("Calculator");
        calculator.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon calculatorImg=new ImageIcon(ClassLoader.getSystemResource("icon/calculator.png"));
        Image calculatorImage=calculatorImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(calculatorImage));
        calculator.addActionListener(this);
        utility.add(calculator);

        JMenu exit=new JMenu("Exit");
        exit.setFont(new Font("serif",Font.PLAIN,15));

        JMenuItem eexit=new JMenuItem("Exit");
        eexit.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon exitImg=new ImageIcon(ClassLoader.getSystemResource("icon/exit.png"));
        Image exitImage=exitImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        eexit.setIcon(new ImageIcon(exitImage));
        eexit.addActionListener(this);
        exit.add(eexit);

        if(acctype.equals("Admin")){
            menuBar.add(menu);
        }else{
            menuBar.add(bill);
            menuBar.add(user);
            menuBar.add(info);
        }
        menuBar.add(utility);
        menuBar.add(exit);

        setLayout(new FlowLayout());
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg=e.getActionCommand();
        if(msg.equals("New Customer")){
            new newCustomer();
        }else if(msg.equals("Customer Details")){
            new customer_Details();
        }else if(msg.equals("Deposit Details")){
            new deposit_details();
        }else if(msg.equals("Calculate Bill")) {
            new calculate_bill();
        }else if(msg.equals("Update Information")){
            new update_info(meter_pass);
        }
        else if(msg.equals("View Information")){
            new view_info(meter_pass);
        }else if(msg.equals("Bill Details")){
            new bill_details(meter_pass);
        }else if(msg.equals("Calculator")){
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }else if(msg.equals("Exit")){
            setVisible(false);
            new Login();
        }else if(msg.equals("Pay Bill")){
            new pay_bill(meter_pass);
        }else if(msg.equals("Generate Bill")){
            new generate_bill(meter_pass);
        }
    }

    public static void main(String[] args) {
        new main_class("","");
    }
}
