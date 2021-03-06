package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * represent the add course button
 * @author Nicho
 *
 */
public class AddCourse implements ActionListener {

	private GUI gui;
	private AddCourseGUI coursegui;
	
	public AddCourse (GUI thegui){
		gui = thegui;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		coursegui = new AddCourseGUI(gui);
	}


	public GUI getGui() {
		return gui;
	}
	public void setGui(GUI gui) {
		this.gui = gui;
	}
	public AddCourseGUI getCoursegui() {
		return coursegui;
	}
	public void setCoursegui(AddCourseGUI coursegui) {
		this.coursegui = coursegui;
	}
	


}
