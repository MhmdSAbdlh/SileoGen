import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.formdev.flatlaf.ui.FlatRoundBorder;

import raven.toast.Notifications;

public class Frame extends JFrame {

	static Font myFont = new Font("Tahoma", Font.BOLD, 21);
	static Font myFontS = new Font("Tahoma", Font.BOLD, 17);
	static Font myFontXS = new Font("Tahoma", Font.ITALIC, 15);
	static Color blueD = new Color(48, 107, 161);
	static Color blueC = new Color(70, 156, 235);
	static Border border = new LineBorder(Color.white, 2);
	private URL header = getClass().getResource("header.png");
	private ImageIcon headerI = new ImageIcon(header);
	private String dayN = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
	private String monthN = new SimpleDateFormat("M").format(Calendar.getInstance().getTime());
	private JLabel photo = new JLabel();

	Frame() {
		// Dimension
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth() - 100;
		int height = (int) screenSize.getHeight() - 100;

		// Frame setting
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(false);
		this.setSize(width, height);
		this.setResizable(false);
		this.setTitle("Sileo 1.0");
		this.getContentPane().setBackground(blueC);
		this.setIconImage(new ImageIcon(header).getImage());

		Notifications.getInstance().setJFrame(this);// PREPARE NOTIFICATION

		JPanel panel = new JPanel(null);
		panel.setBackground(blueD);

		/* Title */
		photo.setBounds(50, 50, 256, 256);
		photo.setIcon(headerI);
		panel.add(photo);
		JLabel titleT = new JLabel("Welcome to SileoGen");
		titleT.setFont(myFont);
		titleT.setForeground(Color.white);
		titleT.setBounds(350, 50, titleT.getPreferredSize().width, 50);
		panel.add(titleT);
		JLabel titleST = new JLabel();
		titleST.setText(
				"<html>Here you can easily generate and export Native Sileo Depictions! This tool was created by <a style=\"color:#cc3f3f;\">MhmdSAblh</a>"
						+ "<br><br>The * means that this case is mandatory"
						+ "<br><br>You can a footer websites but press FOOTER button</html>");
		titleST.setFont(myFontS);
		titleST.setForeground(Color.white);
		titleST.setBounds(350, 120, titleST.getPreferredSize().width, 100);
		panel.add(titleST);

		/* part left */
		/* Header image */
		JLabel headerL = new JLabel("HEADER IMAGE URL");
		headerL.setFont(myFontS);
		headerL.setForeground(Color.white);
		headerL.setBounds(50, 370, headerL.getPreferredSize().width, 50);
		panel.add(headerL);
		JTextField headerTF = new RoundJTextField(500);
		FocusL(headerTF, "Link for header");
		headerTF.setText("Link for header");
		headerTF.setToolTipText("http://a.com/b.jpg");
		headerTF.setFont(myFontXS);
		headerTF.setHorizontalAlignment(0);
		headerTF.setBounds(300, 370, 400, 50);
		panel.add(headerTF);
		/* Screenshots image */
		JLabel screenshotL = new JLabel("SCREENSHOT LINKS");
		screenshotL.setFont(myFontS);
		screenshotL.setForeground(Color.white);
		screenshotL.setBounds(50, 450, screenshotL.getPreferredSize().width, 50);
		panel.add(screenshotL);
		JTextField screenshotTF = new RoundJTextField(500);
		screenshotTF.setText("Links for screenshots");
		FocusL(screenshotTF, "Links for screenshots");
		screenshotTF.setToolTipText("http://link.com/a.jpg, http://link.com.b.png");
		screenshotTF.setFont(myFontXS);
		screenshotTF.setHorizontalAlignment(0);
		screenshotTF.setBounds(300, 450, 400, 50);
		panel.add(screenshotTF);
		/* Description of the package */
		JLabel longDesc = new JLabel("LONG DESCRIPTION*");
		longDesc.setFont(myFontS);
		longDesc.setForeground(Color.white);
		longDesc.setBounds(50, 530, longDesc.getPreferredSize().width, 50);
		panel.add(longDesc);
		JTextArea longDescTF = new JTextArea();
		JScrollPane scrollV = new JScrollPane(longDescTF, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		longDescTF.setLineWrap(true);// Set line wrap and word wrap
		longDescTF.setWrapStyleWord(true);
		longDescTF.setBackground(blueC);
		longDescTF.setCaretColor(Color.white);
		longDescTF.setToolTipText("long description about the tweak, ## You can use Markdown here ##");
		longDescTF.setFont(myFontXS);
		longDescTF.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				if ((ke.getKeyCode() == KeyEvent.VK_W) && ((ke.getModifiers() & InputEvent.CTRL_MASK) != 0))
					System.exit(0);
			}
		});
		scrollV.setBounds(300, 530, 400, 200);
		panel.add(scrollV);

		/* Part center */
		/* Version number */
		JLabel versionN = new JLabel("VERSION*");
		versionN.setFont(myFontS);
		versionN.setForeground(Color.white);
		versionN.setBounds(800, 370, versionN.getPreferredSize().width, 50);
		panel.add(versionN);
		JTextField versionTF = new RoundJTextField(500);
		FocusL(versionTF, "Version number");
		versionTF.setText("Version number");
		versionTF.setToolTipText("1.0.0");
		versionTF.setFont(myFontXS);
		versionTF.setHorizontalAlignment(0);
		versionTF.setBounds(1000, 370, 200, 50);
		panel.add(versionTF);
		/* Price */
		JLabel priceL = new JLabel("PRICE*");
		priceL.setFont(myFontS);
		priceL.setForeground(Color.white);
		priceL.setBounds(800, 450, priceL.getPreferredSize().width, 50);
		panel.add(priceL);
		JTextField priceTF = new RoundJTextField(500);
		FocusL(priceTF, "Price");
		priceTF.setText("Price");
		priceTF.setToolTipText("U$5");
		priceTF.setFont(myFontXS);
		priceTF.setHorizontalAlignment(0);
		priceTF.setBounds(1000, 450, 200, 50);
		panel.add(priceTF);
		/* Author */
		JLabel packageAuthor = new JLabel("AUTHOR*");
		packageAuthor.setFont(myFontS);
		packageAuthor.setForeground(Color.white);
		packageAuthor.setBounds(800, 530, packageAuthor.getPreferredSize().width, 50);
		panel.add(packageAuthor);
		JTextField packageAuthorTF = new RoundJTextField(500);
		FocusL(packageAuthorTF, "Author name");
		packageAuthorTF.setText("Author name");
		packageAuthorTF.setToolTipText("Mhmd Abdlh");
		packageAuthorTF.setFont(myFontXS);
		packageAuthorTF.setHorizontalAlignment(0);
		packageAuthorTF.setBounds(1000, 530, 200, 50);
		panel.add(packageAuthorTF);
		/* Maintainer */
		JLabel maintenerL = new JLabel("MAINTAINER");
		maintenerL.setFont(myFontS);
		maintenerL.setForeground(Color.white);
		maintenerL.setBounds(800, 610, maintenerL.getPreferredSize().width, 50);
		panel.add(maintenerL);
		JTextField maintainerTF = new RoundJTextField(500);
		FocusL(maintainerTF, "Maintener name");
		maintainerTF.setText("Maintener name");
		maintainerTF.setToolTipText("MhmdSAbdlh");
		maintainerTF.setFont(myFontXS);
		maintainerTF.setHorizontalAlignment(0);
		maintainerTF.setBounds(1000, 610, 200, 50);
		panel.add(maintainerTF);

		/* Site */
		JLabel site1 = new JLabel("MY WEBSITE");
		site1.setFont(myFontS);
		site1.setForeground(Color.white);
		site1.setBounds(800, 720, site1.getPreferredSize().width, 50);
		panel.add(site1);
		JTextField site1TF = new RoundJTextField(500);
		FocusL(site1TF, "URL");
		site1TF.setText("URL");
		site1TF.setToolTipText("http://mhmdsabdlh.github.io");
		site1TF.setFont(myFontXS);
		site1TF.setHorizontalAlignment(0);
		site1TF.setBounds(1000, 720, 200, 50);
		panel.add(site1TF);
		/* Site2 */
		JLabel site2 = new JLabel("TWITTER(X)");
		site2.setFont(myFontS);
		site2.setForeground(Color.white);
		site2.setBounds(800, 775, site2.getPreferredSize().width, 50);
		panel.add(site2);
		JTextField site2TF = new RoundJTextField(500);
		FocusL(site2TF, "URL");
		site2TF.setText("URL");
		site2TF.setToolTipText("http://twitter.com/mhmdsabdlh");
		site2TF.setFont(myFontXS);
		site2TF.setHorizontalAlignment(0);
		site2TF.setBounds(1000, 775, 200, 50);
		panel.add(site2TF);
		/* Site3 */
		JLabel site3 = new JLabel("GITHUB");
		site3.setFont(myFontS);
		site3.setForeground(Color.white);
		site3.setBounds(800, 830, site3.getPreferredSize().width, 50);
		panel.add(site3);
		JTextField site3TF = new RoundJTextField(500);
		FocusL(site3TF, "URL");
		site3TF.setText("URL");
		site3TF.setToolTipText("http://facebook.com/mhmdsabdlh");
		site3TF.setFont(myFontXS);
		site3TF.setHorizontalAlignment(0);
		site3TF.setBounds(1000, 830, 200, 50);
		panel.add(site3TF);
		/* Hide by default */
		site1.hide();
		site2.hide();
		site3.hide();
		site1TF.hide();
		site2TF.hide();
		site3TF.hide();
		JToggleButton siteOnOff = new JToggleButton("FOOTER");
		siteOnOff.setBackground(blueC);
		siteOnOff.setForeground(Color.white);
		siteOnOff.setBorder(new FlatRoundBorder());
		siteOnOff.setFont(myFont);
		siteOnOff.setSelected(true);
		siteOnOff.setBounds(400, 780, siteOnOff.getPreferredSize().width + 80, 50);
		siteOnOff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				siteOnOff.setBackground(Color.white);
				siteOnOff.setForeground(Color.black);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				siteOnOff.setBackground(blueC);
				siteOnOff.setForeground(Color.white);
			}
		});
		siteOnOff.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (siteOnOff.isSelected()) {
					siteOnOff.setText("SHOW FOOTER");
					site1.hide();
					site2.hide();
					site3.hide();
					site1TF.hide();
					site2TF.hide();
					site3TF.hide();
					site1.setText("");
					site2.setText("");
					site3.setText("");
					site1TF.setText("");
					site2TF.setText("");
					site3TF.setText("");

				} else {
					siteOnOff.setText("HIDE FOOTER");
					site1.show();
					site2.show();
					site3.show();
					site1TF.show();
					site2TF.show();
					site3TF.show();
				}
			}

		});
		panel.add(siteOnOff);

		/* Part RIGHT */
		/* Changelog */
		JLabel changelogTB = new JLabel("CHANGELOG");
		changelogTB.setBackground(blueD);
		changelogTB.setForeground(Color.white);
		changelogTB.setOpaque(true);
		changelogTB.setHorizontalAlignment(0);
		changelogTB.setBorder(new LineBorder(blueC, 1, true));
		changelogTB.setFont(myFont);
		changelogTB.setBounds(1400, 100, changelogTB.getPreferredSize().width + 80, 50);
		panel.add(changelogTB);
		/* version 1 */
		JTextField versionFirst = new RoundJTextField(500);
		FocusL(versionFirst, "Version");
		versionFirst.setText("Version");
		versionFirst.setToolTipText("Version");
		versionFirst.setFont(myFontXS);
		versionFirst.setHorizontalAlignment(0);
		versionFirst.setBounds(1400 + changelogTB.getWidth() / 2 - 40, 180, 80, 40);
		panel.add(versionFirst);
		/* changelog for the version */
		JTextArea changelogFirst = new JTextArea();
		JScrollPane scrollV1 = new JScrollPane(changelogFirst, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollV1.setBounds(1400 + changelogTB.getWidth() / 2 - 150, 240, 300, 100);
		changelogFirst.setFont(myFontXS);
		changelogFirst.setBackground(blueC);
		changelogFirst.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				if ((ke.getKeyCode() == KeyEvent.VK_W) && ((ke.getModifiers() & InputEvent.CTRL_MASK) != 0))
					System.exit(0);
			}
		});
		panel.add(scrollV1);
		/* version 2 */
		JTextField versionSecond = new RoundJTextField(500);
		FocusL(versionSecond, "Version");
		versionSecond.setText("Version");
		versionSecond.setToolTipText("Version");
		versionSecond.setFont(myFontXS);
		versionSecond.setHorizontalAlignment(0);
		versionSecond.setBounds(1400 + changelogTB.getWidth() / 2 - 40, 370, 80, 40);
		panel.add(versionSecond);
		/* changelog for the version */
		JTextArea changelogSecond = new JTextArea();
		JScrollPane scrollV2 = new JScrollPane(changelogSecond, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollV2.setBounds(1400 + changelogTB.getWidth() / 2 - 150, 430, 300, 100);
		changelogSecond.setFont(myFontXS);
		changelogSecond.setBackground(blueC);
		changelogSecond.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				if ((ke.getKeyCode() == KeyEvent.VK_W) && ((ke.getModifiers() & InputEvent.CTRL_MASK) != 0))
					System.exit(0);
			}
		});
		panel.add(scrollV2);
		/* version 3 */
		JTextField versionThird = new RoundJTextField(500);
		FocusL(versionThird, "Version");
		versionThird.setText("Version");
		versionThird.setToolTipText("Version");
		versionThird.setFont(myFontXS);
		versionThird.setHorizontalAlignment(0);
		versionThird.setBounds(1400 + changelogTB.getWidth() / 2 - 40, 550, 80, 40);
		panel.add(versionThird);
		/* changelog for the version */
		JTextArea changelogThird = new JTextArea();
		JScrollPane scrollV3 = new JScrollPane(changelogThird, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollV3.setBounds(1400 + changelogTB.getWidth() / 2 - 150, 610, 300, 100);
		changelogThird.setFont(myFontXS);
		changelogThird.setBackground(blueC);
		changelogThird.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				if ((ke.getKeyCode() == KeyEvent.VK_W) && ((ke.getModifiers() & InputEvent.CTRL_MASK) != 0))
					System.exit(0);
			}
		});
		panel.add(scrollV3);

		// generate button
		JButton generate = new JButton("GENERATE");
		generate.setBackground(Color.white);
		generate.setForeground(blueC);
		generate.setFont(myFontS);
		generate.setBorder(new LineBorder(blueC, 2, true));
		generate.setBounds(1400 + changelogTB.getWidth() / 2 - generate.getPreferredSize().width / 2 - 25, 800,
				generate.getPreferredSize().width + 50, 50);
		generate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				json(headerTF, screenshotTF, longDescTF, versionTF, priceTF, maintainerTF, packageAuthorTF, siteOnOff,
						site1TF, site2TF, site3TF, versionFirst, versionSecond, versionThird, changelogFirst,
						changelogSecond, changelogThird);
			}
		});
		generate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				generate.setBackground(blueC);
				generate.setForeground(Color.black);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				generate.setBackground(Color.white);
				generate.setForeground(Color.black);
			}
		});
		panel.add(generate);

		JScrollPane scrPane = new JScrollPane(panel);
		scrPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		panel.setPreferredSize(new Dimension(250, generate.getY() + generate.getWidth() + 100));
		this.getContentPane().add(scrPane);

		this.getRootPane().setDefaultButton(generate);
		this.setVisible(true);

		headerTF.requestFocus();
	}

	public class RoundJTextField extends JTextField {
		private Shape shape;

		public RoundJTextField(int size) {
			super(size);
			setOpaque(false); // As suggested by @AVD in comment.
			setBackground(blueC);
			setCaretColor(Color.white);
			addKeyListener(new KeyAdapter() {// Escape to close
				@Override
				public void keyPressed(KeyEvent ke) {
					if ((ke.getKeyCode() == KeyEvent.VK_W) && ((ke.getModifiers() & InputEvent.CTRL_MASK) != 0))
						System.exit(0);
				}
			});
		}

		protected void paintComponent(Graphics g) {
			g.setColor(getBackground());
			g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
			super.paintComponent(g);
		}

		protected void paintBorder(Graphics g) {
			g.setColor(getForeground());
			g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		}

		public boolean contains(int x, int y) {
			if (shape == null || !shape.getBounds().equals(getBounds())) {
				shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
			}
			return shape.contains(x, y);
		}
	}

	public class RoundTextArea extends JTextArea {

		private int radius;

		public RoundTextArea() {
			super(10, 20);
			setOpaque(false);
			setBorder(null);
			setRadius(20);
			setBackground(blueC);
			setCaretColor(Color.white);
			addKeyListener(new KeyAdapter() {// Escape to close
				@Override
				public void keyPressed(KeyEvent ke) {
					if ((ke.getKeyCode() == KeyEvent.VK_W) && ((ke.getModifiers() & InputEvent.CTRL_MASK) != 0))
						System.exit(0);
				}
			});
		}

		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(getBackground());
			g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, getRadius(), getRadius());
			super.paintComponent(g);
		}

		@Override
		protected void paintBorder(Graphics g) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(getForeground());
			g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, getRadius(), getRadius());
		}

		public void setRadius(int radius) {
			this.radius = radius;
			repaint();
		}

		public int getRadius() {
			return radius;
		}

		@Override
		public Insets getInsets() {
			int value = getRadius() / 2;
			return new Insets(value, value, value, value);
		}

	}

	private void FocusL(JTextField tf, String msg) {
		tf.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (tf.getText().equals(msg)) {
					tf.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (tf.getText().isEmpty()) {
					tf.setText(msg);
				}
			}
		});
	}

	private void json(JTextField header, JTextField screenshot, JTextArea long_desc, JTextField version,
			JTextField priceTF, JTextField maintener, JTextField author, JToggleButton siteOnOff, JTextField site1,
			JTextField site2, JTextField site3, JTextField version1, JTextField version2, JTextField version3,
			JTextArea changelog1, JTextArea changelog2, JTextArea changelog3) {

		if (long_desc.getText().isBlank() || version.getText().isBlank() || priceTF.getText().isBlank()
				|| author.getText().isBlank()) {
			Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.CENTER, 2000,
					"YOU NEED TO TYPE IN THE MANDATORY CASES!");
		} else {
			JLabel json = new JLabel();
			/* Screenshots */
			java.util.List<String> screenshotosList = new ArrayList<String>();
			String screenString = "                {\r\n" + "                    \"screenshots\": [\r\n";
			if (!screenshot.getText().isBlank()) {
				screenshotosList = Arrays.asList(screenshot.getText().split(","));
				String temp[] = new String[screenshotosList.size()];
				for (int i = 0; i < screenshotosList.size(); i++) {
					temp[i] = screenshotosList.get(i).replaceAll("\\s", "");
					if (i != screenshotosList.size() - 1)
						screenString += "                        {\r\n"
								+ "                            \"accessibilityText\": \"Screenshot" + i + "\",\r\n"
								+ "                            \"url\": \"" + temp[i] + "\"\r\n"
								+ "                        },\r\n";
					else
						screenString += "                        {\r\n"
								+ "                            \"accessibilityText\": \"Screenshot" + i + "\",\r\n"
								+ "                            \"url\": \"" + temp[i] + "\"\r\n"
								+ "                        }\r\n";
				}
				screenString += "                    ],\r\n"
						+ "                    \"itemSize\": \"{160, 275.41333333333336}\",\r\n"
						+ "                    \"class\": \"DepictionScreenshotsView\",\r\n"
						+ "                    \"itemCornerRadius\": 6\r\n" + "                },\r\n";
			}

			/* version */
			String versionText = "                {\r\n" + "                    \"text\": \"" + version.getText()
					+ "\",\r\n" + "                    \"class\": \"DepictionTableTextView\",\r\n"
					+ "                    \"title\": \"Version\"\r\n" + "                },\r\n"
					+ "                {\r\n";

			/* Description */
			String fixSpaces = long_desc.getText().replaceAll("\n", "\\\\n\\\\n");
			String fixParten = fixSpaces.replaceAll("\"", "\\\\\"");
			String longText = "                    \"markdown\":\"" + fixParten + " \",\r\n"
					+ "                    \"class\": \"DepictionMarkdownView\",\r\n"
					+ "                    \"useBottomMargin\": false,\r\n"
					+ "                    \"title\": \"markdown-description\",\r\n"
					+ "                    \"useBoldText\": true\r\n" + "                },\r\n"
					+ "                {\r\n" + "                    \"class\": \"DepictionSeparatorView\"\r\n"
					+ "                },\r\n";

			/* Date */
			String dateText = "                    \"text\": \"" + dayN + "-" + monthN + "-2024" + "\",\r\n"
					+ "                    \"class\": \"DepictionTableTextView\",\r\n"
					+ "                    \"title\": \"Released\"\r\n" + "                },\r\n"
					+ "                {\r\n";

			/* Price */
			String priceText = "                    \"text\": \"" + priceTF.getText() + "\",\r\n"
					+ "                    \"class\": \"DepictionTableTextView\",\r\n"
					+ "                    \"title\": \"Price\"\r\n" + "                },\r\n";

			/* Author */
			String autherText = "                {\r\n" + "                    \"text\": \"" + author.getText()
					+ "\",\r\n" + "                    \"class\": \"DepictionTableTextView\",\r\n"
					+ "                    \"title\": \"Developer\"\r\n" + "                },\r\n";

			/* Maintainer */
			String maintainerText = maintener.getText().isBlank() ? ""
					: "                {\r\n" + "                    \"text\": \"" + maintener.getText() + "\",\r\n"
							+ "                    \"class\": \"DepictionTableTextView\",\r\n"
							+ "                    \"title\": \"Maintainer\"\r\n" + "                },\r\n";

			/* Footer */
			String footerText = siteOnOff.isSelected() ? ""
					: ",\r\n				{\r\n" + "					\"class\": \"DepictionStackView\",\r\n"
							+ "					\"views\": [\r\n" + "						{\r\n"
							+ "							\"class\": \"DepictionTableButtonView\",\r\n"
							+ "							\"title\": \"Website\",\r\n"
							+ "							\"action\": \"" + site1.getText() + "\",\r\n"
							+ "							\"openExternal\": false\r\n" + "						},\r\n"
							+ "						{\r\n"
							+ "							\"class\": \"DepictionTableButtonView\",\r\n"
							+ "							\"title\": \"Twitter(X)\",\r\n"
							+ "							\"action\": \"" + site2.getText() + "\",\r\n"
							+ "							\"openExternal\": false\r\n" + "						},\r\n"
							+ "						{\r\n"
							+ "							\"class\": \"DepictionTableButtonView\",\r\n"
							+ "							\"title\": \"Github Repos\",\r\n"
							+ "							\"action\": \"" + site3.getText() + "\",\r\n"
							+ "							\"openExternal\": false\r\n" + "						}\r\n"
							+ "					]\r\n" + "				},\r\n" + "				{\r\n"
							+ "					\"class\": \"DepictionSpacerView\",\r\n"
							+ "					\"spacing\": 16\r\n" + "				}";

			String fixPartenCL1 = changelog1.getText().replaceAll("\"", "\\\\\"");
			String fixPartenCL2 = changelog2.getText().replaceAll("\"", "\\\\\"");
			String fixPartenCL3 = changelog3.getText().replaceAll("\"", "\\\\\"");
			String changelogText = changelog1.getText().isBlank() ? "\r\n"
					: ",\r\n		{\r\n" + "			\"tabname\": \"Changelog\",\r\n"
							+ "			\"class\": \"DepictionStackView\",\r\n"
							+ "			\"tintColor\": \"#8600ff\",\r\n" + "			\"views\": [\r\n"
							+ "				{\r\n" + "					\"class\": \"DepictionSubheaderView\",\r\n"
							+ "					\"useBoldText\": true,\r\n"
							+ "					\"useBottomMargin\": false,\r\n" + "					\"title\": \""
							+ version1.getText() + "\"\r\n" + "				},\r\n" + "				{\r\n"
							+ "					\"class\": \"DepictionMarkdownView\",\r\n"
							+ "					\"markdown\": \"<ul>\\n<li>"
							+ fixPartenCL1.replaceAll("\n+", "</li>\\\\n<li>") + "</li></ul>\",\r\n"
							+ "					\"useRawFormat\": true\r\n" + "				}"
							+ (changelog2.getText().isBlank() ? ""
									: ",\r\n" + "				{\r\n"
											+ "					\"class\": \"DepictionSubheaderView\",\r\n"
											+ "					\"useBoldText\": true,\r\n"
											+ "					\"useBottomMargin\": false,\r\n"
											+ "					\"title\": \"" + version2.getText() + "\"\r\n"
											+ "				},\r\n" + "				{\r\n"
											+ "					\"class\": \"DepictionMarkdownView\",\r\n"
											+ "					\"markdown\": \"<ul>\\n<li>"
											+ fixPartenCL2.replaceAll("\n+", "</li>\\\\n<li>") + "</li></ul>\",\r\n"
											+ "					\"useRawFormat\": true\r\n" + "				}")
							+ (changelog3.getText().isBlank() ? ""
									: ",\r\n" + "				{\r\n"
											+ "					\"class\": \"DepictionSubheaderView\",\r\n"
											+ "					\"useBoldText\": true,\r\n"
											+ "					\"useBottomMargin\": false,\r\n"
											+ "					\"title\": \"" + version3.getText() + "\"\r\n"
											+ "				},\r\n" + "				{\r\n"
											+ "					\"class\": \"DepictionMarkdownView\",\r\n"
											+ "					\"markdown\": \"<ul>\\n<li>"
											+ fixPartenCL3.replaceAll("\n+", "</li>\\\\n<li>") + "</li></ul>\",\r\n"
											+ "					\"useRawFormat\": true\r\n" + "				}")
							+ "\r\n			]\r\n" + "		}\r\n";

			json.setText("{\r\n" + "    \"minVersion\": \"0.1\",\r\n" + "    \"headerImage\": \"" + header.getText()
					+ "\",\r\n" + "    \"class\": \"DepictionTabView\",\r\n" + "    \"tintColor\": \"#0657bb\",\r\n"
					+ "    \"tabs\": [\r\n" + "        {\r\n" + "            \"views\": [\r\n"
					+ (screenshotosList.isEmpty() ? "" : screenString) + "                {\r\n" + longText
					+ versionText + dateText + priceText + autherText + maintainerText + "                {\r\n"
					+ "                    \"spacing\": 8,\r\n"
					+ "                    \"class\": \"DepictionSpacerView\"\r\n" + "                }" + footerText
					+ "\r\n" + "            ],\r\n" + "            \"class\": \"DepictionStackView\",\r\n"
					+ "            \"tabname\": \"Details\"\r\n" + "        }" + changelogText + "    ]\r\n" + "}");

			JFileChooser fileChooser = new JFileChooser();
			String userHomeDesktop = System.getProperty("user.home") + File.separator + "Desktop";
			fileChooser.setCurrentDirectory(new File(userHomeDesktop));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON files", "json");
			fileChooser.setFileFilter(filter);

			int userSelection = fileChooser.showSaveDialog(this);

			if (userSelection == JFileChooser.APPROVE_OPTION) {
				// Get the selected file
				File fileToSave = fileChooser.getSelectedFile();
				if (!fileToSave.getAbsolutePath().endsWith(".json")) {
					fileToSave = new File(fileToSave.getAbsolutePath() + ".json");
				}

				try {
					FileWriter savedF = new FileWriter(fileToSave);
					savedF.write(json.getText() + System.lineSeparator());// icon
					savedF.close();
				} catch (Exception e2) {
					Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.CENTER, 2000,
							"ERROR: " + e2);
				}
				Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.CENTER, 2000,
						"Save as file: " + fileToSave.getAbsolutePath());
			} else if (userSelection == JFileChooser.CANCEL_OPTION) {
				Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.CENTER, 2000,
						"Save operation canceled by user.");
			}
		}
	}

	static void savedCorrectly(String message, int duration) {
		Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, duration,
				message);
	}

}