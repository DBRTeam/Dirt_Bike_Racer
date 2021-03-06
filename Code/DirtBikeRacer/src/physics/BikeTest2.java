package physics;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.joints.RevoluteJointDef;
import org.jbox2d.testbed.framework.TestbedTest;

/**
 * TODO Put here a description of what this class does.
 *
 * @author schuenjr.
 *         Created May 11, 2012.
 */
public class BikeTest2 extends TestbedTest {

	private World world;
	private Fixture BikeFrame;

	@Override
	public String getTestName() {
		// TODO Auto-generated method stub.
		return null;
	}

	@Override
	public void initTest(boolean arg0) {
		// Floor
		FixtureDef floorfix = new FixtureDef();
		PolygonShape floorshape = new PolygonShape();
		floorfix.shape = floorshape;
		
		BodyDef floorbody = new BodyDef();
		floorbody.position = new Vec2(20.0f, -20f);
		floorfix.friction = 100f;
		Body floor = getWorld().createBody(floorbody);
		
		
		 floorshape.setAsBox(1000.0f, 0.25f,new Vec2(-20.0f,10.0f),0.00f);
         floor.createFixture(floorshape, 0);
        
       
         
		
	// Wheels
		CircleShape shape = new CircleShape();
		shape.m_radius = 1.0f;
		BodyDef wheelbody1 = new BodyDef();
		wheelbody1.type = BodyType.DYNAMIC;
		wheelbody1.position.set(-2.0f, -9.0f);
		Body wheel1_attachment = getWorld().createBody(wheelbody1);
		wheel1_attachment.createFixture(shape, 2.0f);
		
		
		BodyDef wheelbody2 = new BodyDef();
		wheelbody2.type = BodyType.DYNAMIC;
		wheelbody2.position.set(2.0f, -9.0f);
		Body wheel2_attachment = getWorld().createBody(wheelbody2);
		wheel2_attachment.createFixture(shape, 2.0f);
		
	// Frame
		
		FixtureDef framefix = new FixtureDef();
	    PolygonShape frameshape = new PolygonShape();
	    frameshape.setAsBox(2f, 0.125f);
	    framefix.shape = frameshape;
	    framefix.density = 25.0f;

	    BodyDef framebody = new BodyDef();
	    framebody.type = BodyType.DYNAMIC;
	    framebody.position = new Vec2(0.0f,-9.0f);
	    Body frame_attachment = getWorld().createBody(framebody);
	    this.BikeFrame = frame_attachment.createFixture(framefix);
	    
	    RevoluteJointDef revJoint1 = new RevoluteJointDef();
	    RevoluteJointDef revJoint2 = new RevoluteJointDef();
	    revJoint1.initialize(frame_attachment,wheel1_attachment, new Vec2(-2.0f, -9.0f));
	    revJoint2.initialize(frame_attachment,wheel2_attachment, new Vec2(2.0f, -9.0f));
	    revJoint1.maxMotorTorque = 100.f;
	    revJoint1.enableMotor = true;
	    revJoint1.motorSpeed = -200.0f;
	    getWorld().createJoint(revJoint1);
	    getWorld().createJoint(revJoint2);

	}

}
