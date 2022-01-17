import gr.dit.hua.it22023.it22003.GUI.MainGUI;
import gr.dit.hua.it22023.it22003.Utils.Utils;

import java.io.IOException;

/**
 * Main Class with the main function
 */
public class Controller
{
    public static void main(String[] args) throws IOException {

        Utils.program_initialization();
        MainGUI.CreateGUI();
    }
}
