import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AfisarePacient {
    public JPanel panel1;
    private JButton modificareButton;
    private JTextPane prenumePane;
    private JTextPane adresaPane;
    private JTextPane parametriPane;
    private JButton diagnosticareButton;
    private JTextPane numePane;
    private JTextPane cnpPane;
    private JTextPane diagnosticPane;

    public AfisarePacient(int elemId, int elemID){
        numePane.setText(Spitale_Lista.spitalList.get(elemId).pacientList.get(elemID).getNume());
        prenumePane.setText(Spitale_Lista.spitalList.get(elemId).pacientList.get(elemID).getPrenume());
        adresaPane.setText(Spitale_Lista.spitalList.get(elemId).pacientList.get(elemID).getAdresa());
        cnpPane.setText(String.valueOf(Spitale_Lista.spitalList.get(elemId).pacientList.get(elemID).getCNP()));
        diagnosticPane.setText(Spitale_Lista.spitalList.get(elemId).pacientList.get(elemID).getDiagnostic());
        parametriPane.setText(String.valueOf(Spitale_Lista.spitalList.get(elemId).pacientList.get(elemID).getParametri()));
        modificareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                Spitale_Lista.spitalList.get(elemId).pacientList.get(elemID).setParametri(Integer.parseInt(parametriPane.getText()));}
                catch (Exception e1){
                    JOptionPane.showMessageDialog(panel1, "Invalid parameters");
                }
            }
        });

        diagnosticareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int k=Spitale_Lista.spitalList.get(elemId).pacientList.get(elemID).getParametri();
                int p=Spitale_Lista.spitalList.get(elemId).pacientList.get(elemID).getMIN();
                if (k >= p ) {
                    Spitale_Lista.spitalList.get(elemId).pacientList.get(elemID).setDiagnostic("In treatment");
                    diagnosticPane.setText(Spitale_Lista.spitalList.get(elemId).pacientList.get(elemID).getDiagnostic());
                }
                else{
                    Spitale_Lista.spitalList.get(elemId).pacientList.get(elemID).setDiagnostic("Indisposed");
                    diagnosticPane.setText(Spitale_Lista.spitalList.get(elemId).pacientList.get(elemID).getDiagnostic());
                }
            }
        });
    }
}
