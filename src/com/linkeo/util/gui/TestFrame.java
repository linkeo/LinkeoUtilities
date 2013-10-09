package com.linkeo.util.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.linkeo.util.color.ColorFormat;

public class TestFrame extends JFrame implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int PADDING = 100;
	public TestFrame(Component comp) {
		setTitle("Testing "+comp.getClass().getName());
		Dimension dim = comp.getSize();
		setSize(	dim.width+2*PADDING,
					dim.height+2*PADDING);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		JPanel p = new JPanel();
		setContentPane(p);
		p.addMouseListener(this);
		p.setLayout(null);
		p.add(comp);
		comp.setLocation(PADDING, PADDING);
		setUndecorated(true);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		LUtilForGUI.setLookandFeel();
		JPanel p = new JPanel();
		p.setSize(240, 320);
		new TestFrame(p);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(SwingUtilities.isRightMouseButton(e))
			setBackgroundColor();
	}
	private void setBackgroundColor() {
		String input = 
				JOptionPane.showInputDialog(this,
						"Color Value in RGB",
						getColor());
		if(input==null||input.isEmpty()) return;
		Color color = ColorFormat.decode(input);
		setColor(color);
	}
	private void setColor(Color color) {
		if(color!=null)
			getContentPane().setBackground(color);
	}
	private Object getColor() {
		Color color = getContentPane().getBackground();
		int rgb = color.getRGB();
		return String.format("#%08X", rgb);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
