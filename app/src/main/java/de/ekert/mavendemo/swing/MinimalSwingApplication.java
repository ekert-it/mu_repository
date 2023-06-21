package de.ekert.mavendemo.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import de.ekert.mavendemo.app.BuildInfo;

/**
 * Simple harness for testing GUI code.
 * 
 * <P>
 * To use this class, edit the code to suit your needs.
 * <p>
 * Taken from http://www.javapractices.com/topic/TopicAction.do?Id=231
 */
public final class MinimalSwingApplication {

	private static final Dimension minimumSize = new Dimension(300, 200);
	private Point initialWindowPosition = new Point( 300, 200);

	/**
	 * Build and display minimal GUI.
	 * 
	 * <P>
	 * The GUI has a label and an OK button. The OK button launches a simple message
	 * dialog. No menu is included.
	 */
	public static void main(String... aArgs) {
		MinimalSwingApplication app = new MinimalSwingApplication();
		app.buildAndDisplayGui();
	}

	private void buildAndDisplayGui() {
		JFrame frame = new JFrame("Tools für Java Programmierung - Mobile University");
		frame.setMinimumSize(minimumSize);
		frame.setLocation(initialWindowPosition);
		buildContent(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	private void buildContent(JFrame aFrame) {
		JPanel contentPanel = new JPanel();
		contentPanel.setMinimumSize(minimumSize);
		try (InputStream input = getClass().getResourceAsStream("/logo.png")) {
			BufferedImage img;
			img = ImageIO.read(input);
			Image newimg = img.getScaledInstance(100, 30, Image.SCALE_SMOOTH);
			JLabel pic = new JLabel(new ImageIcon(newimg));
			contentPanel.add(pic);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contentPanel.setBackground(new Color (0xff5d18)); //#ff5d18
		contentPanel.add(new JLabel("Hello"));
		JButton ok = new JButton("OK");
		ok.addActionListener(new ShowDialog(aFrame));
		contentPanel.add(ok);
		JPanel wrapperPanel = new JPanel(new GridBagLayout());
		wrapperPanel.setPreferredSize(new Dimension(350, 300));
		wrapperPanel.add(contentPanel);
		aFrame.getContentPane().add(wrapperPanel);
	}

	private static final class ShowDialog implements ActionListener {
		/** Defining the dialog's owner JFrame is highly recommended. */
		ShowDialog(JFrame aFrame) {
			fFrame = aFrame;
		}

		@Override
		public void actionPerformed(ActionEvent aEvent) {
			JOptionPane.showMessageDialog(fFrame, "Erstellt für einen Java Tools Workshop der Mobile University.\n\nLetzter Build\n   am: " + BuildInfo.getVersion() + "\n   von: " + BuildInfo.getBuilder());
		}

		private JFrame fFrame;
	}
}
