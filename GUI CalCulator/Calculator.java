import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame  implements ActionListener{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    static JFrame f;
    static JTextField l;
    String s0,s1,s2,op1,op2,sh1,sh2;
    JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,ba,bs,bm,bd,bdot,beq,bcls;
    JPanel p ;
    

    Calculator(){
        super("Simple Calcultor");
        s0=s1=s2=op1=op2=sh1=sh2="";
        // creating JTextField
        l= new JTextField(16);
        l.setEditable(false);
        b0= new JButton("0");
        b1= new JButton("1");
        b2=new JButton("2");
        b3= new JButton("3");
        b4= new JButton("4");
        b5= new JButton("5");
        b6= new JButton("6");
        b7= new JButton("7");
        b8= new JButton("8");
        b9= new JButton("9");

        //action button
        ba= new JButton("+");
        bs= new JButton("-");
        bm= new JButton("*");
        bd= new JButton("/");
        beq= new JButton("=");
        bcls= new JButton("C");
        bdot= new JButton(".");

        //initialize panel object
        p= new JPanel();
        
        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        ba.addActionListener(this);
        bs.addActionListener(this);
        bm.addActionListener(this);
        bd.addActionListener(this);
        beq.addActionListener(this);
        bcls.addActionListener(this);
        bdot.addActionListener(this);

        // adding text filed
        p.add(l);

        // adding first row element
        p.add(ba);
        p.add(b1);
        p.add(b2);
        p.add(b3);

        // adding second row element
        p.add(bs);
        p.add(b4);
        p.add(b5);
        p.add(b6);

        // adding 3rd row element
        p.add(bm);
        p.add(b7);
        p.add(b8);
        p.add(b9);

        // adding 4th row elemnt
        p.add(bd);
        p.add(bdot);
        p.add(b0);
        p.add(bcls);

        // ADDING LAST row element
        p.add(beq);

        p.setBackground(Color.blue);

        // adding to frame

        f.add(p);
        f.setSize(200,200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public void actionPerformed(ActionEvent e){
        String s=e.getActionCommand();

        // if the value is a number

        if((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) =='.'){
           
            // if the operand is present then add Second no
            if(!s1.equals(""))
                s2=s2 + s;
            else 
                s0=s0 + s;
            
            //set the value of text
            l.setText(s0+s1+s2);  
            
        }

        else if(s.charAt(0)=='C'){
            //clear the one letter
            s0=s1=s2="";
            //set the value of text
            l.setText(s0+s1+s2);
        } 

        if(s.charAt(0)=='+'  || s.charAt(0)=='-' || s.charAt(0)=='*' || s.charAt(0)=='/'){
            s1=s;
        }
            
        else if(s.charAt(0) == '='){
            double te;

            //store the value in first

            if(s1.equals("+")){
                // s1=s;
                te=(Double.parseDouble(s0)+Double.parseDouble(s2));
            }
            else if(s1.equals("-")){
                te=(Double.parseDouble(s0)-Double.parseDouble(s2));
            }
            else if(s1.equals("/"))
                    te=(Double.parseDouble(s0)/Double.parseDouble(s2));
                    else 
                        te=(Double.parseDouble(s0) * Double.parseDouble(s2));
            l.setText(s0+s1+s2+"="+te);
            s0=Double.toString(te);
            s2="";

        }
        
    }
    

    public static void main( String[] args) {
        // f= new JFrame("Simple Calculator");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {System.out.println(e);}
    
    // create a object of class Calculator
    new Calculator();
    
}
}
