package gr.dit.hua.it22023.it22003.GUI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import gr.dit.hua.it22023.it22003.Models.City;
import gr.dit.hua.it22023.it22003.Utils.Utils;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Comparator;
import java.util.Locale;
import java.util.Optional;
import java.util.logging.Level;

public class PersonalizedSelector extends JFrame
{
    private       JLabel     cafe;
    private       JSpinner   cafe_spinner;
    private       JLabel     sea;
    private       JSpinner   sea_spinner;
    private       JLabel     museum;
    private       JSpinner   museum_spinner;
    private       JLabel     restaurant;
    private       JSpinner   restaurant_spinner;
    private       JLabel     stadium;
    private       JSpinner   stadium_spinner;
    private       JLabel     landmarks;
    private       JSpinner   landmarks_spinner;
    private       JLabel     hotels;
    private       JSpinner   hotels_spinner;
    private final MainGUI    main;
    private       JPanel     Main_Panel;
    private       JButton    confirmButton;
    private final JSpinner[] spinnerArray;
    
    public PersonalizedSelector(String title , MainGUI mainGUI)
    {
        super(title);
        $$$setupUI$$$();
        this.main         = mainGUI;
        this.spinnerArray = new JSpinner[]{ cafe_spinner ,
                                            sea_spinner ,
                                            museum_spinner ,
                                            restaurant_spinner ,
                                            stadium_spinner ,
                                            landmarks_spinner ,
                                            hotels_spinner };
        initComponents();
        this.setContentPane(Main_Panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    private void initComponents()
    {
        this.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                terminateMain();
            }
        });
        this.setLayout(null);
        this.setResizable(false);
        this.setPreferredSize(new Dimension(180 , 300));
        //
        // confirmButton
        //
        confirmButton.addActionListener(e -> {
            double[] preferences = { (double) cafe_spinner.getValue() ,
                                     (double) sea_spinner.getValue() ,
                                     (double) museum_spinner.getValue() ,
                                     (double) restaurant_spinner.getValue() ,
                                     (double) stadium_spinner.getValue() ,
                                     (double) landmarks_spinner.getValue() ,
                                     (double) hotels_spinner.getValue() };

            Utils.logger.log(Level.INFO, "Entered personalized preferences successfully.");
            Utils.logger.log(Level.CONFIG, "Preferences for:    \n\tCafes: " + preferences[0] +
                                                                                                                "\n\tSeas: " + preferences[1] +
                                                                                                                "\n\tMuseums: " + preferences[2] +
                                                                                                                "\n\tRestaurants: " + preferences[3] +
                                                                                                                "\n\tStadiums: " + preferences[4] +
                                                                                                                "\n\tLandmarks: " + preferences[5] +
                                                                                                                "\n\tHotels: " + preferences[6]);
            
            // @formatter:off
            
            Optional<City> val = Utils.cities.stream()
                                             .peek(city -> {
                                                    double sum = 0;
                                                    for (int i = 0; i < preferences.length; i++)
                                                    {
                                                        sum += preferences[i] * city.getFeatures()[i];
                                                    }
                                                    city.setPrefrences(sum);
                                                    })
                                             .max(Comparator.comparingDouble(City::getPrefrences));
            // @formatter:on
            //noinspection OptionalGetWithoutIsPresent
            main.recommendCitiesTextPane.setText(val.get().getCityName());
            main.setVisible(true);
            this.dispose();
        });
        //
        // spinnerArray
        //
        for (JSpinner spinner : spinnerArray)
        {
            spinner.setModel(new SpinnerNumberModel(0.0 , - 1.0 , 1.0 , 0.1));
        }
    }
    
    
    private void terminateMain()
    {
        main.close();
    }
    
    //region Generated Code
    
    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$()
    {
        Main_Panel = new JPanel();
        Main_Panel.setLayout(new GridLayoutManager(18 , 5 , new Insets(0 , 0 , 0 , 0) , - 1 , - 1));
        final Spacer spacer1 = new Spacer();
        Main_Panel.add(spacer1 ,
                       new GridConstraints(2 ,
                                           0 ,
                                           2 ,
                                           1 ,
                                           GridConstraints.ANCHOR_CENTER ,
                                           GridConstraints.FILL_HORIZONTAL ,
                                           GridConstraints.SIZEPOLICY_WANT_GROW ,
                                           1 ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        final Spacer spacer2 = new Spacer();
        Main_Panel.add(spacer2 ,
                       new GridConstraints(2 ,
                                           2 ,
                                           2 ,
                                           1 ,
                                           GridConstraints.ANCHOR_CENTER ,
                                           GridConstraints.FILL_HORIZONTAL ,
                                           GridConstraints.SIZEPOLICY_WANT_GROW ,
                                           1 ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        cafe = new JLabel();
        Font cafeFont = this.$$$getFont$$$(null , - 1 , 14 , cafe.getFont());
        if (cafeFont != null) cafe.setFont(cafeFont);
        cafe.setText("Label");
        Main_Panel.add(cafe ,
                       new GridConstraints(2 ,
                                           1 ,
                                           1 ,
                                           1 ,
                                           GridConstraints.ANCHOR_WEST ,
                                           GridConstraints.FILL_NONE ,
                                           GridConstraints.SIZEPOLICY_FIXED ,
                                           GridConstraints.SIZEPOLICY_FIXED ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        final Spacer spacer3 = new Spacer();
        Main_Panel.add(spacer3 ,
                       new GridConstraints(3 ,
                                           1 ,
                                           1 ,
                                           1 ,
                                           GridConstraints.ANCHOR_CENTER ,
                                           GridConstraints.FILL_VERTICAL ,
                                           1 ,
                                           GridConstraints.SIZEPOLICY_WANT_GROW ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        final Spacer spacer4 = new Spacer();
        Main_Panel.add(spacer4 ,
                       new GridConstraints(3 ,
                                           4 ,
                                           1 ,
                                           1 ,
                                           GridConstraints.ANCHOR_CENTER ,
                                           GridConstraints.FILL_HORIZONTAL ,
                                           GridConstraints.SIZEPOLICY_WANT_GROW ,
                                           1 ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        sea = new JLabel();
        Font seaFont = this.$$$getFont$$$(null , - 1 , 14 , sea.getFont());
        if (seaFont != null) sea.setFont(seaFont);
        sea.setText("Label");
        Main_Panel.add(sea ,
                       new GridConstraints(4 ,
                                           1 ,
                                           1 ,
                                           1 ,
                                           GridConstraints.ANCHOR_WEST ,
                                           GridConstraints.FILL_NONE ,
                                           GridConstraints.SIZEPOLICY_FIXED ,
                                           GridConstraints.SIZEPOLICY_FIXED ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        final Spacer spacer5 = new Spacer();
        Main_Panel.add(spacer5 ,
                       new GridConstraints(5 ,
                                           1 ,
                                           1 ,
                                           1 ,
                                           GridConstraints.ANCHOR_CENTER ,
                                           GridConstraints.FILL_VERTICAL ,
                                           1 ,
                                           GridConstraints.SIZEPOLICY_WANT_GROW ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        museum = new JLabel();
        Font museumFont = this.$$$getFont$$$(null , - 1 , 14 , museum.getFont());
        if (museumFont != null) museum.setFont(museumFont);
        museum.setText("Label");
        Main_Panel.add(museum ,
                       new GridConstraints(6 ,
                                           1 ,
                                           1 ,
                                           1 ,
                                           GridConstraints.ANCHOR_WEST ,
                                           GridConstraints.FILL_NONE ,
                                           GridConstraints.SIZEPOLICY_FIXED ,
                                           GridConstraints.SIZEPOLICY_FIXED ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        restaurant = new JLabel();
        Font restaurantFont = this.$$$getFont$$$(null , - 1 , 14 , restaurant.getFont());
        if (restaurantFont != null) restaurant.setFont(restaurantFont);
        restaurant.setText("Label");
        Main_Panel.add(restaurant ,
                       new GridConstraints(8 ,
                                           1 ,
                                           1 ,
                                           1 ,
                                           GridConstraints.ANCHOR_WEST ,
                                           GridConstraints.FILL_NONE ,
                                           GridConstraints.SIZEPOLICY_FIXED ,
                                           GridConstraints.SIZEPOLICY_FIXED ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        stadium = new JLabel();
        Font stadiumFont = this.$$$getFont$$$(null , - 1 , 14 , stadium.getFont());
        if (stadiumFont != null) stadium.setFont(stadiumFont);
        stadium.setText("Label");
        Main_Panel.add(stadium ,
                       new GridConstraints(10 ,
                                           1 ,
                                           1 ,
                                           1 ,
                                           GridConstraints.ANCHOR_WEST ,
                                           GridConstraints.FILL_NONE ,
                                           GridConstraints.SIZEPOLICY_FIXED ,
                                           GridConstraints.SIZEPOLICY_FIXED ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        landmarks = new JLabel();
        Font landmarksFont = this.$$$getFont$$$(null , - 1 , 14 , landmarks.getFont());
        if (landmarksFont != null) landmarks.setFont(landmarksFont);
        landmarks.setText("Label");
        Main_Panel.add(landmarks ,
                       new GridConstraints(12 ,
                                           1 ,
                                           1 ,
                                           1 ,
                                           GridConstraints.ANCHOR_WEST ,
                                           GridConstraints.FILL_NONE ,
                                           GridConstraints.SIZEPOLICY_FIXED ,
                                           GridConstraints.SIZEPOLICY_FIXED ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        hotels = new JLabel();
        Font hotelsFont = this.$$$getFont$$$(null , - 1 , 14 , hotels.getFont());
        if (hotelsFont != null) hotels.setFont(hotelsFont);
        hotels.setText("Label");
        Main_Panel.add(hotels ,
                       new GridConstraints(14 ,
                                           1 ,
                                           1 ,
                                           1 ,
                                           GridConstraints.ANCHOR_WEST ,
                                           GridConstraints.FILL_NONE ,
                                           GridConstraints.SIZEPOLICY_FIXED ,
                                           GridConstraints.SIZEPOLICY_FIXED ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        final Spacer spacer6 = new Spacer();
        Main_Panel.add(spacer6 ,
                       new GridConstraints(7 ,
                                           1 ,
                                           1 ,
                                           1 ,
                                           GridConstraints.ANCHOR_CENTER ,
                                           GridConstraints.FILL_VERTICAL ,
                                           1 ,
                                           GridConstraints.SIZEPOLICY_WANT_GROW ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        final Spacer spacer7 = new Spacer();
        Main_Panel.add(spacer7 ,
                       new GridConstraints(9 ,
                                           1 ,
                                           1 ,
                                           1 ,
                                           GridConstraints.ANCHOR_CENTER ,
                                           GridConstraints.FILL_VERTICAL ,
                                           1 ,
                                           GridConstraints.SIZEPOLICY_WANT_GROW ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        final Spacer spacer8 = new Spacer();
        Main_Panel.add(spacer8 ,
                       new GridConstraints(11 ,
                                           1 ,
                                           1 ,
                                           1 ,
                                           GridConstraints.ANCHOR_CENTER ,
                                           GridConstraints.FILL_VERTICAL ,
                                           1 ,
                                           GridConstraints.SIZEPOLICY_WANT_GROW ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        final Spacer spacer9 = new Spacer();
        Main_Panel.add(spacer9 ,
                       new GridConstraints(13 ,
                                           1 ,
                                           1 ,
                                           1 ,
                                           GridConstraints.ANCHOR_CENTER ,
                                           GridConstraints.FILL_VERTICAL ,
                                           1 ,
                                           GridConstraints.SIZEPOLICY_WANT_GROW ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        final Spacer spacer10 = new Spacer();
        Main_Panel.add(spacer10 ,
                       new GridConstraints(1 ,
                                           1 ,
                                           1 ,
                                           1 ,
                                           GridConstraints.ANCHOR_CENTER ,
                                           GridConstraints.FILL_VERTICAL ,
                                           1 ,
                                           GridConstraints.SIZEPOLICY_WANT_GROW ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        final Spacer spacer11 = new Spacer();
        Main_Panel.add(spacer11 ,
                       new GridConstraints(15 ,
                                           1 ,
                                           1 ,
                                           1 ,
                                           GridConstraints.ANCHOR_CENTER ,
                                           GridConstraints.FILL_VERTICAL ,
                                           1 ,
                                           GridConstraints.SIZEPOLICY_WANT_GROW ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        final Spacer spacer12 = new Spacer();
        Main_Panel.add(spacer12 ,
                       new GridConstraints(0 ,
                                           1 ,
                                           1 ,
                                           1 ,
                                           GridConstraints.ANCHOR_CENTER ,
                                           GridConstraints.FILL_VERTICAL ,
                                           1 ,
                                           GridConstraints.SIZEPOLICY_WANT_GROW ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        final Spacer spacer13 = new Spacer();
        Main_Panel.add(spacer13 ,
                       new GridConstraints(16 ,
                                           1 ,
                                           1 ,
                                           1 ,
                                           GridConstraints.ANCHOR_CENTER ,
                                           GridConstraints.FILL_VERTICAL ,
                                           1 ,
                                           GridConstraints.SIZEPOLICY_WANT_GROW ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        cafe_spinner = new JSpinner();
        Font cafe_spinnerFont = this.$$$getFont$$$(null , - 1 , 14 , cafe_spinner.getFont());
        if (cafe_spinnerFont != null) cafe_spinner.setFont(cafe_spinnerFont);
        Main_Panel.add(cafe_spinner ,
                       new GridConstraints(2 ,
                                           3 ,
                                           1 ,
                                           1 ,
                                           GridConstraints.ANCHOR_WEST ,
                                           GridConstraints.FILL_HORIZONTAL ,
                                           GridConstraints.SIZEPOLICY_WANT_GROW ,
                                           GridConstraints.SIZEPOLICY_FIXED ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        sea_spinner = new JSpinner();
        Main_Panel.add(sea_spinner ,
                       new GridConstraints(4 ,
                                           3 ,
                                           1 ,
                                           1 ,
                                           GridConstraints.ANCHOR_WEST ,
                                           GridConstraints.FILL_HORIZONTAL ,
                                           GridConstraints.SIZEPOLICY_WANT_GROW ,
                                           GridConstraints.SIZEPOLICY_FIXED ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        museum_spinner = new JSpinner();
        Main_Panel.add(museum_spinner ,
                       new GridConstraints(6 ,
                                           3 ,
                                           1 ,
                                           1 ,
                                           GridConstraints.ANCHOR_WEST ,
                                           GridConstraints.FILL_HORIZONTAL ,
                                           GridConstraints.SIZEPOLICY_WANT_GROW ,
                                           GridConstraints.SIZEPOLICY_FIXED ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        restaurant_spinner = new JSpinner();
        Main_Panel.add(restaurant_spinner ,
                       new GridConstraints(8 ,
                                           3 ,
                                           1 ,
                                           1 ,
                                           GridConstraints.ANCHOR_WEST ,
                                           GridConstraints.FILL_HORIZONTAL ,
                                           GridConstraints.SIZEPOLICY_WANT_GROW ,
                                           GridConstraints.SIZEPOLICY_FIXED ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        stadium_spinner = new JSpinner();
        Main_Panel.add(stadium_spinner ,
                       new GridConstraints(10 ,
                                           3 ,
                                           1 ,
                                           1 ,
                                           GridConstraints.ANCHOR_WEST ,
                                           GridConstraints.FILL_HORIZONTAL ,
                                           GridConstraints.SIZEPOLICY_WANT_GROW ,
                                           GridConstraints.SIZEPOLICY_FIXED ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        landmarks_spinner = new JSpinner();
        Main_Panel.add(landmarks_spinner ,
                       new GridConstraints(12 ,
                                           3 ,
                                           1 ,
                                           1 ,
                                           GridConstraints.ANCHOR_WEST ,
                                           GridConstraints.FILL_HORIZONTAL ,
                                           GridConstraints.SIZEPOLICY_WANT_GROW ,
                                           GridConstraints.SIZEPOLICY_FIXED ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        hotels_spinner = new JSpinner();
        Main_Panel.add(hotels_spinner ,
                       new GridConstraints(14 ,
                                           3 ,
                                           1 ,
                                           1 ,
                                           GridConstraints.ANCHOR_WEST ,
                                           GridConstraints.FILL_HORIZONTAL ,
                                           GridConstraints.SIZEPOLICY_WANT_GROW ,
                                           GridConstraints.SIZEPOLICY_FIXED ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
        confirmButton = new JButton();
        confirmButton.setText("Confirm");
        Main_Panel.add(confirmButton ,
                       new GridConstraints(17 ,
                                           0 ,
                                           1 ,
                                           5 ,
                                           GridConstraints.ANCHOR_CENTER ,
                                           GridConstraints.FILL_HORIZONTAL ,
                                           GridConstraints.SIZEPOLICY_CAN_SHRINK |
                                           GridConstraints.SIZEPOLICY_CAN_GROW ,
                                           GridConstraints.SIZEPOLICY_FIXED ,
                                           null ,
                                           null ,
                                           null ,
                                           0 ,
                                           false));
    }
    
    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName , int style , int size , Font currentFont)
    {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null)
        {
            resultName = currentFont.getName();
        } else
        {
            Font testFont = new Font(fontName , Font.PLAIN , 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1'))
            {
                resultName = fontName;
            } else
            {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName ,
                             style >= 0 ? style : currentFont.getStyle() ,
                             size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name" , "").toLowerCase(Locale.ENGLISH).startsWith(
                "mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily() ,
                                                 font.getStyle() ,
                                                 font.getSize()) : new StyleContext().getFont(font.getFamily() ,
                                                                                              font.getStyle() ,
                                                                                              font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(
                fontWithFallback);
    }
    
    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return Main_Panel;
    }
    
    //endregion
    
}
