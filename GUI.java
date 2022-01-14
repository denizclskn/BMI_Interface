
package package1;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener {    
    
    private static JPanel panel;
    private static JFrame frame;
    private static JLabel hLabel;
    private static JTextField hText;
    private static JLabel wLabel;
    private static JTextField wText;
    private static JLabel BMILabel;
    private static JTextField BMIText;
    private static JLabel label;
    private static JButton button;
    private static JLabel hInfo;
    private static JLabel wInfo;
    
    private static double height;
    private static double weight;
    private static double BMI;
    
    
    public static void main(String[] args) {
        panel = new JPanel();
        panel.setLayout(null);
        frame = new JFrame();
        frame.setSize(600, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Body Mass Index Calculator");
        frame.add(panel);
                       
        hLabel =new JLabel("Height: ");
        hLabel.setBounds(50, 30, 120, 30);
        panel.add(hLabel);
        
        hText =new JTextField();
        hText.setBounds(180, 30, 200, 30);
        panel.add(hText);
        
        wLabel = new JLabel("Weight: ");
        wLabel.setBounds(50, 70, 120, 30); 
        panel.add(wLabel);
        
        wText =new JTextField();
        wText.setBounds(180, 70, 200, 30);
        panel.add(wText);
        
        BMILabel = new JLabel ("Body Mass Index: ");
        BMILabel.setBounds(50, 110, 120, 30);
        panel.add(BMILabel);
        
        BMIText = new JTextField();
        BMIText.setBounds(180, 110, 200, 30);
        panel.add(BMIText);
        BMIText.setEditable(false);
        
        hInfo = new JLabel();
        hInfo.setBounds(400, 30, 100, 30);
        panel.add(hInfo);
        hInfo.setText("*Enter as cm");
        
        wInfo = new JLabel();
        wInfo.setBounds(400, 70, 100, 30);
        panel.add(wInfo);
        wInfo.setText("*Enter as kg");
     
        button = new JButton("Calculate");
        button.setBounds(200, 180, 100, 30);
        button.addActionListener(new GUI());
        panel.add(button);
        
        label = new JLabel();
        label.setBounds(50, 250, 350, 30);
        panel.add(label);
        label.setText("");
        
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(hText.getText().length() > 0 && wText.getText().length() > 0){
            height = Double.parseDouble(hText.getText())/100;
            weight = Double.parseDouble(wText.getText());
            if(height > 0 && weight >0){
                calculate();
            }else{
                label.setText("Height and weight values should be higher than 0.");
            }
        }else{
            label.setText("You did not enter either your height or weight.");
        }       
    }
    
    public void calculate(){
        BMI = weight / (height * height);
        BMIText.setText(String.format("%.2f", BMI));
        if (BMI < 20){
            label.setText("You are underweight.");
	} else {
            if (BMI < 25){
		label.setText("Your BMI is normal");
            } else {
                if (BMI < 30){
                    label.setText("You are overweight");
                } else {
                    if (BMI < 35){
                        label.setText("You are obese");
                    } else {
			if (BMI < 45){
                            label.setText("You are moderetely obese");
			} else {
                            if (BMI < 50){
				label.setText("You are severely obese");
                            } else {
				label.setText("Yo are deadly obese");
                            }
			}
                    }
		}
            }
	}
    }    
}
