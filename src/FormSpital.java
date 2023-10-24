import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class FormSpital {
    public JPanel rootSpital;
    private JTextField numeSpital;
    private JTextField adresaSpital;
    private JTextField emailSpital;
    private JTextField telefonSpital;
    private JButton inserareSpitalButton;

    public FormSpital(){
        inserareSpitalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(numeSpital.getText().isEmpty() || adresaSpital.getText().isEmpty() ||
                        emailSpital.getText().isEmpty() || telefonSpital.getText().isEmpty()){
                    JOptionPane.showMessageDialog(rootSpital, "Date incomplete");
                }
                else {
                    Spitale_Lista.adaugareSpital(new Spital(numeSpital.getText(), adresaSpital.getText(),
                            emailSpital.getText(), telefonSpital.getText()));
                    numeSpital.setText(null);
                    adresaSpital.setText(null);
                    emailSpital.setText(null);
                    telefonSpital.setText(null);
                }


            }
        });
    }
}
