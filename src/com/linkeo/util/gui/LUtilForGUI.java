package com.linkeo.util.gui;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LUtilForGUI {

	public static void setLookandFeel() {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
