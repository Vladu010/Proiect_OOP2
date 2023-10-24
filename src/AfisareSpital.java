import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AfisareSpital {
    public JPanel panel1;
    private JButton afisarePacientiButton;
    private JTextPane textPane1;
    private JTextPane textPane2;
    private JTextPane textPane3;
    private JTextPane textPane4;
    private JButton stergerePacientButton;
    private JButton inserarePacientButton;
    private JButton modificarePacientButton;
    private JPanel listPanel;

    public AfisareSpital(int elemId){

        textPane1.setText(Spitale_Lista.spitalList.get(elemId).getNumeSpital());
        textPane2.setText(Spitale_Lista.spitalList.get(elemId).getAdresaSpital());
        textPane3.setText(Spitale_Lista.spitalList.get(elemId).getEmailSpital());
        textPane4.setText(Spitale_Lista.spitalList.get(elemId).getTelefonSpital());

        String[] listElems = new String[100];
        final JList list = new JList(listElems);
        final JScrollPane pane = new JScrollPane(list);

     afisarePacientiButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             DefaultListModel<String> listModel = new DefaultListModel<>();
             for (int i = 0; i < Spitale_Lista.spitalList.get(elemId).getNumPacients(); i++) {
                 listModel.addElement(Spitale_Lista.spitalList.get(elemId).pacientList.get(i).toString());
             }
             list.setModel(listModel);
             listPanel.removeAll(); // Clear any existing components in the listPanel
             listPanel.setLayout(new BorderLayout());
             listPanel.add(pane, BorderLayout.CENTER);
             listPanel.revalidate();
         }
     });

        inserarePacientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame formPacient = new JFrame("Inserare Pacient");
                formPacient.setContentPane(new FormPacient(elemId).panel1);
                formPacient.setSize(400,150);
                formPacient.setVisible(true);
                formPacient.setLocationRelativeTo(null);
            }
        });

        stergerePacientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedElem = "";
                int selectedIndices[] = list.getSelectedIndices();
                int elemID=0;
                for (int j = 0; j < selectedIndices.length; j++) {
                    String elem =
                            (String) list.getModel().getElementAt(selectedIndices[j]);
                    elemID = selectedIndices[j];
                    selectedElem += "\n" + elem ;

                }
                Spitale_Lista.spitalList.get(elemId).removePacientByIndex(elemID);
            }
        });

        modificarePacientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                String selectedElem = "";
                int selectedIndices[] = list.getSelectedIndices();
                int elemID=0;
                for (int j = 0; j < selectedIndices.length; j++) {
                    String elem =
                            (String) list.getModel().getElementAt(selectedIndices[j]);
                    elemID = selectedIndices[j];
                    selectedElem += "\n" + elem ;
                }
                JFrame afisarePacient = new JFrame("Vizualizare Pacient");
                afisarePacient.setContentPane(new AfisarePacient(elemId,elemID).panel1);
                afisarePacient.setSize(850,250);
                afisarePacient.setVisible(true);
                afisarePacient.setLocationRelativeTo(null);}
                catch(Exception e1){JOptionPane.showMessageDialog(listPanel,
                        "Nu este selectat nici un pacient");}
            }
        });

    }
}
