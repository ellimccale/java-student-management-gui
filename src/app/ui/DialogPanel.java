package app.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.WindowConstants;

public class DialogPanel extends JPanel {

	private static final long serialVersionUID = 1367531419339580178L;
	private final JLayeredPane layeredPane;

	public DialogPanel(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;

		setOpaque(false);
		setVisible(false);
		setLayout(new GridBagLayout());

		layeredPane.add(this, JLayeredPane.POPUP_LAYER);
	}

	public void showDialog(String title, JPanel contentPanel) {
		JDialog dialog = new JDialog();

		dialog.setTitle(title);
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		dialog.setSize(300, 200);
		dialog.setLocationRelativeTo(layeredPane);
		dialog.setResizable(false);
		dialog.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);

		dialog.add(contentPanel);

		dialog.setVisible(true);
		showDialogPanel();

		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				hideDialogPanel();
			}
		});
	}

	public void showDialogPanel() {
		setBounds(0, 0, layeredPane.getWidth(), layeredPane.getHeight());
		setVisible(true);
		revalidate();
		repaint();
	}

	public void hideDialogPanel() {
		setVisible(false);
		revalidate();
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(0, 0, 0, 128));
		g2d.fillRect(0, 0, getWidth(), getHeight());
	}
}
