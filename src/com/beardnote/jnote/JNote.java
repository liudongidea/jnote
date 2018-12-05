package com.beardnote.jnote;

import java.awt.GraphicsEnvironment;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;

import com.beardnote.jnote.gui.JNMainPanel;

public class JNote {
	public static void main(String[] args) {
		try {
			NativeInterface.open();
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
//            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
			BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					JNMainPanel mainPanel = new JNMainPanel(GraphicsEnvironment.getLocalGraphicsEnvironment()
							.getDefaultScreenDevice().getDefaultConfiguration());
				}
			});
			NativeInterface.runEventPump();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
