package app.ui;

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

public class Dialog extends JPanel {

	private static final long serialVersionUID = 1367531419339580178L;
	private final JLayeredPane layeredPane;

	public Dialog(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;

		this.setOpaque(false);
		this.setVisible(false);

		layeredPane.add(this, JLayeredPane.POPUP_LAYER);
	}

	public void initDialog(String title, JPanel contentPanel, int width, int height) {
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

	public void showDialogOverlay() {
		this.setBounds(0, 0, layeredPane.getWidth(), layeredPane.getHeight());
		this.setVisible(true);
		this.revalidate();
		this.repaint();
	}

	public void hideDialogOverlay() {
		this.setVisible(false);
		this.revalidate();
		this.repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(0, 0, 0, 128));
		g2d.fillRect(0, 0, getWidth(), getHeight());
	}
}
