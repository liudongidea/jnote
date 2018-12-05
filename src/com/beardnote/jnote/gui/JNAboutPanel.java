package com.beardnote.jnote.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import com.beardnote.jnote.dao.OptionDao;
import com.beardnote.jnote.gui.common.JNConstans;
import com.beardnote.jnote.gui.util.GUIUtil;

public class JNAboutPanel extends JPanel {
	private JFrame frame = null;
	private JRadioButton simpleEditorRadioButton = new JRadioButton("简单html编辑器");
	private JRadioButton advancedEditorRadioButton = new JRadioButton("高级html编辑器");
	private JRadioButton markdownEditorRadioButton = new JRadioButton("markdown编辑器");

	// 默认窗体大小
	private static final int DEFAULT_PANEL_WIDTH = 1000;
	private static final int DEFAULT_PANE_HEIGHT = 700;

	public JNAboutPanel(GraphicsConfiguration gc) {
		_initFrame(gc);

	}

	private void _initFrame(GraphicsConfiguration gc) {
		frame = new JFrame(gc);
		setLayout(new BorderLayout());
		
		frame.setTitle("jnote-关于");

		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(new JLabel("  "), BorderLayout.WEST);
		JLabel aboutLable = new JLabel();
		aboutLable.setBounds(130,120,100,30);
		aboutLable.setText("<html>jnote<br />作者:码农赵鹏<br />微博:<a href=\"http://weibo.com/523419490\">@大鹏ME</a><br />博客:<a href=\"http://zhaopeng.me\">http://zhaopeng.me</a></html>");
		mainPanel.add(aboutLable, BorderLayout.CENTER);

		JPanel btnPanel = new JPanel();

		JButton cancelBtn = new JButton("关闭");

		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});


		btnPanel.add(cancelBtn);

		mainPanel.add(btnPanel, BorderLayout.SOUTH);

		frame.getContentPane().add(mainPanel);
		frame.setPreferredSize(new Dimension(180, 160));
		frame.pack();
		GUIUtil.setFrameCenter(frame);
		frame.setVisible(true);

	}

	private Component getAboutPanel() {
		JLabel label = new JLabel("<html><center><font color=red size=3>RED</font></center></html>");
		return label;
	}


}
