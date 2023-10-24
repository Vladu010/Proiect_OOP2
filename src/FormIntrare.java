import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormIntrare {
    public JPanel root;
    private JButton button1;
    private JButton afisareSpitalButton;
    private JButton creareSpitaleButton;
    private JPanel listPanel;
    private JTextField textSearch;

    public FormIntrare(){
        String[] listElems = new String[100];
        final JList list = new JList(listElems);
        final JScrollPane pane = new JScrollPane(list);



        //final JList list = new JList(listElems);
         creareSpitaleButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 JFrame formSpital = new JFrame("Creare Spital");
                 formSpital.setContentPane(new FormSpital().rootSpital);
                 formSpital.setSize(400,300);
                 formSpital.setVisible(true);
                 formSpital.setLocationRelativeTo(null);
            }
         });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < Spitale_Lista.spitalList.size(); i++) {
                    listElems[i] = Spitale_Lista.spitalList.get(i).toString() ;
                }

                listPanel.removeAll(); // Clear any existing components in the listPanel
                listPanel.setLayout(new BorderLayout());
                listPanel.add(pane, BorderLayout.CENTER);
                listPanel.revalidate();

            }
        });

        afisareSpitalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedElem = "";
                boolean found = false;
                int selectedIndices[] = list.getSelectedIndices();
                int elemId=-1;

                for (int j = 0; j < selectedIndices.length; j++) {
                    String elem =
                            (String) list.getModel().getElementAt(selectedIndices[j]);
                    elemId = selectedIndices[j];
                    selectedElem += "\n" + elem ;
                    if(elemId==-1){
                        String cmp = textSearch.getText();
                        if (cmp.equalsIgnoreCase(Spitale_Lista.spitalList.get(j).getNumeSpital())) {
                                        elemId = Spitale_Lista.spitalList.get(j).getId();
                                        found = true;
                                        break;
                                    }
                    }

                }
                //if(!found){JOptionPane.showMessageDialog(listPanel,
                //                   "Spitalul nu exista");};
                //if(elemId<=0){
                //    String searchCmp=textSearch.getText();
                //    for (int j = 0; j < selectedIndices.length; j++) {
                //        if (searchCmp.equalsIgnoreCase(Spitale_Lista.spitalList.get(j).getNumeSpital())) {
                //            elemId = Spitale_Lista.spitalList.get(j).getId();
                //            found = true;
                //            break;
                //        }
                //
                //    }
                //    if(!found){JOptionPane.showMessageDialog(listPanel,
                //            "Spitalul nu exista");};
                //}
                try {
                    JFrame afisareSpital = new JFrame("Vizualizare Spital " +
                            Spitale_Lista.spitalList.get(elemId).getNumeSpital());
                afisareSpital.setContentPane(new AfisareSpital(elemId).panel1);
                afisareSpital.setSize(800,300);
                afisareSpital.setVisible(true);
                afisareSpital.setLocationRelativeTo(null);}
                catch(Exception f) {JOptionPane.showMessageDialog(listPanel,
                                "Something went wrong" );}
               //JOptionPane.showMessageDialog(listPanel,
               //        "You've selected:" + elemId);
            }
        });
    }
}