package physics;

import javax.swing.JFrame;

import org.jbox2d.testbed.framework.TestList;
import org.jbox2d.testbed.framework.TestbedFrame;
import org.jbox2d.testbed.framework.TestbedModel;
import org.jbox2d.testbed.framework.TestbedPanel;
import org.jbox2d.testbed.framework.TestbedSetting;
import org.jbox2d.testbed.framework.TestbedSetting.SettingType;
import org.jbox2d.testbed.framework.j2d.TestPanelJ2D;

/**
 * TODO Put here a description of what this class does.
 *
 * @author schuenjr.
 *         Created May 3, 2012.
 */
public class PhysicsTester {

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		TestbedModel model = new TestbedModel();         // create our model

		// add tests
//		TestList.populateModel(model);                   // populate the provided testbed tests
		model.addCategory("Samples");             // add a category
		model.addTest(new BikeTest1());                // add our test

		// add our custom setting "My Range Setting", with a default value of 10, between 0 and 20
		model.getSettings().addSetting(new TestbedSetting("My Range Setting", SettingType.ENGINE, 10, 0, 20));

		TestbedPanel panel = new TestPanelJ2D(model);    // create our testbed panel

		JFrame testbed = new TestbedFrame(model, panel); // put both into our testbed frame
		// etc
		testbed.setVisible(true);
		testbed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
