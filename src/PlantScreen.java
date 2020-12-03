
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author csmoak2016
 */
public class PlantScreen extends JDialog{

    private final JPanel contentPanel = new JPanel();
    private JList list = new JList();
    private Plant plant;
    
    PlantScreen(){
        //constructor does nothing
    }

    public JList updateList(LinkedList<Plant> plants){
        String[] names = new String[plants.size()];
        for(int i=0;i<plants.size();i++){
            plant = plants.get(i);
            names[i] = plant.getName();
        }
        JList list = new JList(names);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);
        
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250,80));
        return list;
    }
    
    public LinkedList<Plant> displayPlantScreen(LinkedList<Plant> plants){
        setTitle("Plant List");
        setBounds(100, 100, 300, 150);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
        gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
        gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPanel.setLayout(gbl_contentPanel);        
        
        list = updateList(plants);
        contentPanel.add(list);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
      
        if(plants.size() >= 1){
            JButton okButton = new JButton("Edit Plant");
            okButton.setActionCommand("OK");
            buttonPane.add(okButton);
            getRootPane().setDefaultButton(okButton);
            okButton.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                String plantName = (String) list.getSelectedValue();
                int index = 0;
                for(int i=0;i<plants.size();i++){
                    plant = plants.get(i);
                    String name = plant.getName();
                    if(plantName.equals(name)){
                        index = i;
                        break;
                    }
                }
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose(); 
                EditPlant editScreen = new EditPlant();
                editScreen.setVisible(true);
                LinkedList<Plant> tempPlants = editScreen.EditPlant(plants, index);  
                for(int i=0;i<tempPlants.size();i++){
                    plants.get(i).setEqual(tempPlants.get(i));
                }
              }
            });            
        }
        
        JButton cancelButton = new JButton("Back");
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
          }
        });    
        return plants;
    }
}

