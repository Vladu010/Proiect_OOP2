import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPacient {
    public JPanel panel1;
    private JTextField numePacient;
    private JTextField prenumePacient;
    private JTextField adresaPacient;
    private JTextField cnpPacient;
    private JButton inserarePacientButton;

    public FormPacient(int elemId){
        inserarePacientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    if (numePacient.getText().isEmpty() || prenumePacient.getText().isEmpty() ||
                            adresaPacient.getText().isEmpty() || cnpPacient.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(panel1,
                                "Date incomplete");
                    } else {
                        Spitale_Lista.spitalList.get(elemId).addPacient(new Pacient(numePacient.getText(),
                                prenumePacient.getText(), adresaPacient.getText(),
                                Double.parseDouble(cnpPacient.getText())));
                        numePacient.setText(null);
                        prenumePacient.setText(null);
                        adresaPacient.setText(null);
                        cnpPacient.setText(null);
                    }
                }
                catch(Exception e1){
                    JOptionPane.showMessageDialog(panel1, "CNP introdus gresit");}
                finally {
                    //JOptionPane.showMessageDialog(panel1,
                    //        "Date gresite");
                }
            }

        });
    }
}
