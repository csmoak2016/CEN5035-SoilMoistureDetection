import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Window;
import java.util.Properties;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public class HomeScreen extends JFrame {

  private JPanel contentPane;
  private JTextField txtNumber1;
  private JTextField txtNumber2;
  private JDatePickerImpl dtPicker;
  private JButton btnNewButton;
  private JButton btnNewButton_1;
  private LinkedList<Plant> plants = new LinkedList<Plant>();
  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          HomeScreen frame = new HomeScreen();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public HomeScreen() {
    setTitle("Soil Moisture Detection");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    GridBagLayout gbl_contentPane = new GridBagLayout();
    gbl_contentPane.columnWidths = new int[]{0, 0, 0};
    gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
    gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
    gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    contentPane.setLayout(gbl_contentPane);
    
    JLabel lblCalendar = new JLabel("Calendar");
    GridBagConstraints gbc_lblCalendar = new GridBagConstraints();
    gbc_lblCalendar.insets = new Insets(0, 0, 5, 5);
    gbc_lblCalendar.anchor = GridBagConstraints.EAST;
    gbc_lblCalendar.gridx = 0;
    gbc_lblCalendar.gridy = 0;
    contentPane.add(lblCalendar, gbc_lblCalendar);
    
    Properties p = new Properties();
    p.put("text.today", "Today");
    p.put("text.month", "Month");
    p.put("text.year", "Year");
    UtilDateModel model = new UtilDateModel();
    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
    dtPicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
    GridBagConstraints gbc_dtPicker = new GridBagConstraints();
    gbc_dtPicker.insets = new Insets(0, 0, 5, 0);
    gbc_dtPicker.fill = GridBagConstraints.HORIZONTAL;
    gbc_dtPicker.gridx = 1;
    gbc_dtPicker.gridy = 0;
    contentPane.add(dtPicker, gbc_dtPicker);
    
    JLabel lblNewLabel = new JLabel("Moisture level ");
    GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
    gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
    gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
    gbc_lblNewLabel.gridx = 0;
    gbc_lblNewLabel.gridy = 1;
    contentPane.add(lblNewLabel, gbc_lblNewLabel);
    
    txtNumber1 = new JTextField();
    txtNumber2 = new JTextField();
    GridBagConstraints gbc_txtNumber1 = new GridBagConstraints();
    gbc_txtNumber1.insets = new Insets(0, 0, 5, 0);
    gbc_txtNumber1.fill = GridBagConstraints.HORIZONTAL;
    gbc_txtNumber1.gridx = 1;
    gbc_txtNumber1.gridy = 1;
    if(plants.size()==1){
        Plant plant = plants.get(0);
        txtNumber1.setText(plant.getName());
    }
    else if(plants.size()==2){
        Plant plant = plants.get(0);
        txtNumber1.setText(plant.getName());
        plant = plants.get(1);
        txtNumber2.setText(plant.getName());
    }
    contentPane.add(txtNumber1, gbc_txtNumber1);
    txtNumber1.setColumns(10);
    
    
    GridBagConstraints gbc_txtNumber2 = new GridBagConstraints();
    gbc_txtNumber2.insets = new Insets(0, 0, 5, 0);
    gbc_txtNumber2.fill = GridBagConstraints.HORIZONTAL;
    gbc_txtNumber2.gridx = 1;
    gbc_txtNumber2.gridy = 2;
    contentPane.add(txtNumber2, gbc_txtNumber2);
    txtNumber2.setColumns(10);
    
    btnNewButton = new JButton("Add Plant");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        AddPlant addPlant = new AddPlant();
        plants = addPlant.AddPlant(plants);
        addPlant.setVisible(true);
        contentPane.repaint();
      }
    });
    GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
    gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
    gbc_btnNewButton.gridwidth = 2;
    gbc_btnNewButton.gridx = 0;
    gbc_btnNewButton.gridy = 3;
    contentPane.add(btnNewButton, gbc_btnNewButton);
    
    btnNewButton_1 = new JButton("Edit Plant ");
    btnNewButton_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        PlantScreen plantList = new PlantScreen();
        plants = plantList.displayPlantScreen(plants);
        plantList.setVisible(true);
        contentPane.repaint();
      }
    });
    GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
    gbc_btnNewButton_1.gridwidth = 2;
    gbc_btnNewButton_1.gridx = 0;
    gbc_btnNewButton_1.gridy = 4;
    contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
   
  }
}
