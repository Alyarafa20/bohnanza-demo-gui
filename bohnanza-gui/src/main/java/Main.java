import io.bitbucket.plt.sdp.bohnanza.gui.MainWindow;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainWindow(2));
    }
}
