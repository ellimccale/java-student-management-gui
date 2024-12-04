package app.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Represents a custom overlay dialog for displaying modal content.
 * <p>
 * This class extends {@link JPanel} and serves as a semi-transparent overlay
 * that dims the background while a modal {@link JDialog} is displayed. The
 * dialog overlay is added to a specified {@link JLayeredPane} at the
 * {@code POPUP_LAYER} level.
 * 
 * @author Elli Steck
 */
public class Dialog extends JPanel {

	private static final long serialVersionUID = 1367531419339580178L;
	private final JLayeredPane layeredPane;

	/**
	 * Constructs a new {@code Dialog} overlay and adds it to the specified
	 * {@link JLayeredPane}.
	 * <p>
	 * The dialog is added to the {@link JLayeredPane} at the {@code POPUP_LAYER}
	 * level, allowing it to overlay other components.
	 * 
	 * @param layeredPane the {@link JLayeredPane} to which this dialog overlay is
	 *                    added
	 */
	public Dialog(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;

		this.setOpaque(false);
		this.setVisible(false);

		layeredPane.add(this, JLayeredPane.POPUP_LAYER);
	}

	/**
	 * Initializes and displays a modal {@link JDialog} with the specified content
	 * and dimensions.
	 * <p>
	 * This method creates a dialog window with a title and specified size, adds the
	 * provided {@link JPanel} as its content, and positions it relative to the
	 * {@link JLayeredPane}. When the dialog is closed, the overlay is hidden
	 * automatically.
	 * 
	 * @param title        the title of the dialog
	 * @param contentPanel the {@link JPanel} to display as the dialog's content
	 * @param width        the width of the dialog
	 * @param height       the height of the dialog
	 */
	public void init(String title, JPanel contentPanel, int width, int height) {
		JDialog dialog = new JDialog();

		dialog.setTitle(title);
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		dialog.setSize(width, height);
		dialog.setResizable(false);
		dialog.setLocationRelativeTo(layeredPane);
		dialog.setLayout(new BorderLayout());

		dialog.add(contentPanel, BorderLayout.CENTER);

		dialog.setVisible(true);
		showDialogOverlay();

		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				hideDialogOverlay();
			}
		});
	}

	/**
	 * Displays the semi-transparent overlay over the {@link JLayeredPane}.
	 */
	public void showDialogOverlay() {
		this.setBounds(0, 0, layeredPane.getWidth(), layeredPane.getHeight());
		this.setVisible(true);
		this.revalidate();
		this.repaint();
	}

	/**
	 * Hides the semi-transparent overlay.
	 */
	public void hideDialogOverlay() {
		this.setVisible(false);
		this.revalidate();
		this.repaint();
	}

	/**
	 * Paints a semi-transparent black background over the panel.
	 * <p>
	 * Overrides the default {@link JPanel#paintComponent(Graphics)} behavior to
	 * draw a semi-transparent black rectangle that covers the entire panel. This is
	 * used to create a dimming effect for the overlay.
	 *
	 * @param g the {@link Graphics} object used to render the component
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(0, 0, 0, 128));
		g2d.fillRect(0, 0, getWidth(), getHeight());
	}
}
