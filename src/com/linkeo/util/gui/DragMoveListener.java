package com.linkeo.util.gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

public class DragMoveListener implements MouseListener, MouseMotionListener{
	private Component comp;
	private Point mousePos;
	private DragMoveListener(Component comp) {
		this.comp = comp;
	}
	public static void bind(Component comp){
		DragMoveListener dml = new DragMoveListener(comp);
		bind(comp, dml);
	}
	public static void bind(Component comp, DragMoveListener l){
		comp.removeMouseListener(l);
		comp.removeMouseMotionListener(l);
		comp.addMouseListener(l);
		comp.addMouseMotionListener(l);
		if(comp instanceof Container)
			for(Component subComp: ((Container)comp).getComponents())
				bind(subComp, l);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e))
			mousePos = e.getLocationOnScreen();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)){
			Point newMousePos = e.getLocationOnScreen();
			Point compPos = comp.getLocation();
			comp.setLocation(
					compPos.x+(newMousePos.x-mousePos.x),
					compPos.y+(newMousePos.y-mousePos.y)
					);
			mousePos = newMousePos;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
