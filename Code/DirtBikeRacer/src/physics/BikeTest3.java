package physics;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.joints.RevoluteJointDef;
import org.jbox2d.testbed.framework.TestbedTest;

/**
 * TODO Put here a description of what this class does.
 *
 * @author schuenjr.
 *         Created May 4, 2012.
 */
public class BikeTest3 extends TestbedTest {
	
	private static final float DegtoRad = 0.0174532935199432957f;
	
	@Override
	public String getTestName() {
		return "BikeTest3";
	}

	@Override
	public void initTest(boolean argDeserialized) {
		if(argDeserialized){
		      return;
	}
	// Floor
		FixtureDef floorfix = new FixtureDef();
		PolygonShape floorshape = new PolygonShape();
		floorfix.shape = floorshape;
		
		BodyDef floorbody = new BodyDef();
		floorbody.position = new Vec2(20.0f, -20f);
		floorfix.friction = 10f;
		floorfix.density = 0;
		floorfix.restitution = 0;
		
		Body floor = getWorld().createBody(floorbody);
		
		// Top
		floorshape.setAsBox(50.00f, 0.125f,new Vec2(-20.0f,43.125f),0.00f);
	    floor.createFixture(floorfix);
	    // Right
	    floorshape.setAsBox(0.125f, 28.125f,new Vec2(30.0f,15.0f),0.00f);
	    floor.createFixture(floorfix);
	    //Bottom
	    floorshape.setAsBox(50.00f, 0.125f,new Vec2(-20.0f,-13.125f),0.00f);
	    floor.createFixture(floorfix);
	    //Left
	    floorshape.setAsBox(0.125f, 28.125f,new Vec2(-70.0f,15.0f),0.00f);
	    floor.createFixture(floorfix);
	    
	    floorshape.setAsBox(20.0f, 0.125f,new Vec2(-45.0f,-1.5f),35.0f * DegtoRad);
	    floor.createFixture(floorfix);
	    floorshape.setAsBox(6.0f, 0.125f,new Vec2(-22.5f,10.0f),0.0f);
	    floor.createFixture(floorfix);
	    floorshape.setAsBox(4.0f, 0.125f,new Vec2(-16.0f,6.0f),100.0f * DegtoRad);
	    floor.createFixture(floorfix);
	    floorshape.setAsBox(4.0f, 0.125f,new Vec2(-4.0f,-2.0f),100.0f * DegtoRad);
	    floor.createFixture(floorfix);
	    floorshape.setAsBox(4.0f, 0.125f,new Vec2(7.5f,-10.0f),100.0f * DegtoRad);
	    floor.createFixture(floorfix);
	    floorshape.setAsBox(5.0f, 0.125f,new Vec2(-10.0f,2.0f),0.0f);
	    floor.createFixture(floorfix);
	    floorshape.setAsBox(5.0f, 0.125f,new Vec2(1.75f,-6.0f),0.0f);
	    floor.createFixture(floorfix);
	    
	    
	// Wheels
	     
	    FixtureDef wheelfix = new FixtureDef();
		CircleShape shape = new CircleShape();
		shape.m_radius = .75f;
		wheelfix.friction = 10f;
		wheelfix.density = 50f;
		wheelfix.restitution = 0.1f;
		wheelfix.shape = shape;
		
		
		BodyDef wheelbody1 = new BodyDef();
		wheelbody1.type = BodyType.DYNAMIC;
		wheelbody1.position.set(-48.0f, -32.0f);
		Body wheel1_attachment = getWorld().createBody(wheelbody1);
		wheel1_attachment.createFixture(wheelfix);
		
		BodyDef wheelbody2 = new BodyDef();
		wheelbody2.type = BodyType.DYNAMIC;
		wheelbody2.position.set(-46.0f, -32.0f);
		Body wheel2_attachment = getWorld().createBody(wheelbody2);
		wheel2_attachment.createFixture(wheelfix);
		
	// Frame
		
		FixtureDef framefix = new FixtureDef();
	    PolygonShape frameshape = new PolygonShape();
	    frameshape.setAsBox(1f, 0.125f);
	    framefix.density = 50.0f;
	    framefix.shape = frameshape;

	    BodyDef framebody = new BodyDef();
	    framebody.type = BodyType.DYNAMIC;
	    framebody.position = new Vec2(-47.0f,-32.0f);
	    Body frame_attachment = getWorld().createBody(framebody);
	    frame_attachment.createFixture(framefix);
	    
	    RevoluteJointDef revJoint1 = new RevoluteJointDef();
	    RevoluteJointDef revJoint2 = new RevoluteJointDef();
	    revJoint1.initialize(frame_attachment,wheel1_attachment, new Vec2(-48.0f, -32.0f));
	    revJoint2.initialize(frame_attachment,wheel2_attachment, new Vec2(-46.0f, -32.0f));
	    revJoint1.maxMotorTorque = 1000.0f;
	    revJoint1.enableMotor = true;
	    revJoint1.motorSpeed = -25.0f;
	    getWorld().createJoint(revJoint1);
	    getWorld().createJoint(revJoint2);
	    
	 // Rider
	    
	    FixtureDef riderfix = new FixtureDef();
	    PolygonShape ridershape = new PolygonShape();
	    ridershape.setAsBox(0.0625f, 1.0f);
	    riderfix.density = 100f;
	    riderfix.shape = ridershape;
	    riderfix.friction = 0f;

	    BodyDef riderbody = new BodyDef();
	    riderbody.type = BodyType.DYNAMIC;
	    riderbody.position = new Vec2(-47.0f,-31.0f);
	    Body rider_attachment = getWorld().createBody(riderbody);
	    rider_attachment.createFixture(riderfix);
	    
	    RevoluteJointDef revJoint3 = new RevoluteJointDef();
	    revJoint3.initialize(rider_attachment,frame_attachment, new Vec2(-47.0f, -32.0f));
	    revJoint3.maxMotorTorque = 2000.0f;
	    revJoint3.enableMotor = true;
	    revJoint3.motorSpeed = 15.0f;
	    getWorld().createJoint(revJoint3); 
	}
}
