import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class EditPlant extends JDialog {

  private final JPanel contentPanel = new JPanel();
  private JTextField textField;
  private JTextField textField_1;
  private JTextField textField_2;

  EditPlant(){
      //empty constructor
  }
  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    try {
      EditPlant dialog = new EditPlant();
      dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      dialog.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Create the dialog.
   */
  public LinkedList<Plant> EditPlant(LinkedList<Plant> plant, int index) {
    LinkedList<Plant> copy = plant;
    setTitle("Edit Plant");
    setBounds(100, 100, 450, 300);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    GridBagLayout gbl_contentPanel = new GridBagLayout();
    gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
    gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
    gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
    gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
    contentPanel.setLayout(gbl_contentPanel);
    {
      JLabel lblPlantName = new JLabel("Plant name:");
      GridBagConstraints gbc_lblPlantName = new GridBagConstraints();
      gbc_lblPlantName.anchor = GridBagConstraints.EAST;
      gbc_lblPlantName.insets = new Insets(0, 0, 5, 5);
      gbc_lblPlantName.gridx = 0;
      gbc_lblPlantName.gridy = 0;
      contentPanel.add(lblPlantName, gbc_lblPlantName);
    }
    {
      textField = new JTextField();
      GridBagConstraints gbc_textField = new GridBagConstraints();
      gbc_textField.insets = new Insets(0, 0, 5, 0);
      gbc_textField.fill = GridBagConstraints.HORIZONTAL;
      gbc_textField.gridx = 1;
      gbc_textField.gridy = 0;
      contentPanel.add(textField, gbc_textField);
      textField.setColumns(10);
      textField.setText(plant.get(index).getName());
    }
    {
      JLabel lblNewLabel = new JLabel("Plant type:");
      GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
      gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
      gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
      gbc_lblNewLabel.gridx = 0;
      gbc_lblNewLabel.gridy = 1;
      contentPanel.add(lblNewLabel, gbc_lblNewLabel);
    }
    {
      textField_1 = new JTextField();
      GridBagConstraints gbc_textField_1 = new GridBagConstraints();
      gbc_textField_1.insets = new Insets(0, 0, 5, 0);
      gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
      gbc_textField_1.gridx = 1;
      gbc_textField_1.gridy = 1;
      contentPanel.add(textField_1, gbc_textField_1);
      textField_1.setColumns(10);
      textField_1.setText(plant.get(index).getPlantType());
    }
    {
      JLabel lblNewLabel_1 = new JLabel("Water schedule:");
      GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
      gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
      gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
      gbc_lblNewLabel_1.gridx = 0;
      gbc_lblNewLabel_1.gridy = 2;
      contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
    }
    {
      textField_2 = new JTextField();
      GridBagConstraints gbc_textField_2 = new GridBagConstraints();
      gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
      gbc_textField_2.gridx = 1;
      gbc_textField_2.gridy = 2;
      contentPanel.add(textField_2, gbc_textField_2);
      textField_2.setColumns(10);
      textField_2.setText(Integer.toString(plant.get(index).getWaterInterval()));
    }
    {
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      {
        JButton okButton = new JButton("Save");
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
                plant.get(index).setName(textField.getText());
                plant.get(index).setPlantType(textField_1.getText());
                plant.get(index).setWaterInterval(Integer.parseInt(textField_2.getText()));
            }
          });
      }
      {
        JButton btnDelete = new JButton("Delete");
        buttonPane.add(btnDelete);
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                plant.get(index).setNull();
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
            }
        });
      }
      {
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
                for(int i=0;i<copy.size();i++){
                    copy.get(i).setEqual(copy.get(i));
                }
            }
          });
      }
    }  
    return plant;
  }

}
