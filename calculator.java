/*********************************************************************************************
Program Name : Write a java program to create a simple arithmetic calculator using GridLayout.
**********************************************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class calculator extends Frame implements ActionListener
{
    Button b[]=new Button[20];
    JTextField t;
    Panel p;
    double num1,num2,ans;
    int check;
    calculator(String title)
    {
        super(title);
        setSize(450,600);
        setLocation(600,250);
        setFont(new Font("Times New roman",Font.BOLD | Font.ITALIC,30));
        setLayout(null);
        setBackground(Color.darkGray);

        for(int i=0;i<=9;i++)
        {
            b[i]=new Button(""+i);
        }
        b[10]=new Button("+");
        b[11]=new Button("-");
        b[12]=new Button("*");
        b[13]=new Button("/");
        b[14]=new Button("%");
        b[15]=new Button(".");
        b[16]=new Button("=");
        b[17]=new Button("Clear");
        b[18]=new Button("^");
        b[19]=new Button("Back");
        t=new JTextField(50);
        
        t.setHorizontalAlignment(JTextField.RIGHT);
        p=new Panel();
        p.setLayout(new GridLayout(5,4,10,10));//row

        //Adding all Button's to the Panel
        for(int i=0;i<=19;i++)
        {
            p.add(b[i]);
        }

        t.setBackground(Color.lightGray);
        t.setForeground(Color.darkGray);
        t.setFont(new Font("Times New roman",Font.BOLD | Font.ITALIC,35));
        t.setBounds(25,50,400,100);
        p.setBounds(25,170,400,400);
        
        //Adding to a Frame window
        add(t);
        add(p);

        for(int i=0;i<20;i++)
        {
            b[i].addActionListener(this);
        }
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
    public void actionPerformed(ActionEvent e)
    {
        String r,res;
        if(e.getSource()==b[0])
        {
            r=t.getText();
            res=r+"0";
            t.setText(res);
        }
        if(e.getSource()==b[1])
        {
            r=t.getText();
            res=r+"1";
            t.setText(res);
        }
        if(e.getSource()==b[2])
        {
            r=t.getText();
            res=r+"2";
            t.setText(res);
        }
        if(e.getSource()==b[3])
        {
            r=t.getText();
            res=r+"3";
            t.setText(res);
        }
        if(e.getSource()==b[4])
        {
            r=t.getText();
            res=r+"4";
            t.setText(res);
        }
        if(e.getSource()==b[5])
        {
            r=t.getText();
            res=r+"5";
            t.setText(res);
        }
        if(e.getSource()==b[6])
        {
            r=t.getText();
            res=r+"6";
            t.setText(res);
        }
        if(e.getSource()==b[7])
        {
            r=t.getText();
            res=r+"7";
            t.setText(res);
        }
        if(e.getSource()==b[8])
        {
            r=t.getText();
            res=r+"8";
            t.setText(res);
        }
        if(e.getSource()==b[9])
        {
            r=t.getText();
            res=r+"9";
            t.setText(res);
        }

        //for decimal points
        if(e.getSource()==b[15])
        {
            r=t.getText();
            res=r+".";
            t.setText(res);
        }

        //negative
        if(e.getSource()==b[11])
        {
            r=t.getText();
            res="-"+r;
            t.setText(res);
        }

        //for backspace
        if(e.getSource()==b[19])
        {
            r=t.getText();
            try{
                res=r.substring(0,r.length()-1);
            }
            catch(StringIndexOutOfBoundsException s){
                return;
            }
            t.setText(res);
        }

        //for Arithmetic Operations
        if(e.getSource()==b[10])
        {
            try{
                num1=Double.parseDouble(t.getText());
            }
            catch(NumberFormatException n){
                t.setText("Invalid Format");
                return;
            }
            res=" ";
            t.setText(res);
            check=1;
        }
        if(e.getSource()==b[11])
        {
            try{
                num1=Double.parseDouble(t.getText());
            }
            catch(NumberFormatException n){
                t.setText("Invalid Format");
                return;
            }
            res=" ";
            t.setText(res);
            check=2;
        }
        if(e.getSource()==b[12])
        {
            try{
                num1=Double.parseDouble(t.getText());
            }
            catch(NumberFormatException n){
                t.setText("Invalid Format");
                return;
            }
            res=" ";
            t.setText(res);
            check=3;
        }
        if(e.getSource()==b[13])
        {
            try{
                num1=Double.parseDouble(t.getText());
            }
            catch(NumberFormatException n){
                t.setText("Invalid Format");
                return;
            }
            res=" ";
            t.setText(res);
            check=4;
        }
        if(e.getSource()==b[14])
        {
            try{
                num1=Double.parseDouble(t.getText());
            }
            catch(NumberFormatException n){
                t.setText("Invalid Format");
                return;
            }
            res=" ";
            t.setText(res);
            check=5;
        }
        if(e.getSource()==b[18])
        {
            try{
                num1=Double.parseDouble(t.getText());
            }
            catch(NumberFormatException n){
                t.setText("Invalid Format");
                return;
            }
            res=" ";
            t.setText(res);
            check=6;
        }

        //for result(=)
        if(e.getSource()==b[16])
        {
            try{
                num2=Double.parseDouble(t.getText());
            }
            catch(Exception e1){
                t.setText("ENTER NUMBER FIRST.");
                return;
            }
            if(check==1)
                ans=num1+num2;
            if(check==2)
                ans=num1-num2;
            if(check==3)
                ans=num1*num2;
            if(check==4)
                ans=num1/num2;
            if(check==5)
                ans=num1%num2;
            if(check==6)
                ans=Math.pow(num1,num2);

            t.setText(String.valueOf(ans));
        }

        //for clear
        if(e.getSource()==b[17])
        {
            num1=0;
            num2=0;
            check=0;
            ans=0;
            res=" ";
            t.setText(res);
        }
    }
    public static void main(String []args)
    {
        calculator c=new calculator("Calculator");
        c.setVisible(true);
    }
}
