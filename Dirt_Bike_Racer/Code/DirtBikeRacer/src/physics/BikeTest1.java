package physics;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.sql.Array;
import java.util.ArrayList;

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
public class BikeTest1 extends TestbedTest {
	private static final float DegtoRad = 0.0174532935199432957f;
	
	@Override
	public String getTestName() {
		return "BikeTest1";
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
		floorfix.friction = 3f;
		floorfix.density = 0;
		floorfix.restitution = 0;
		
		Body floor = getWorld().createBody(floorbody);
		
/*		floorshape.setAsBox(7.00f, 0.125f,new Vec2(-40.0f,0.0f),0.00f);
        floor.createFixture(floorshape, 0);
		floorshape.setAsBox(6.48f, 0.125f,new Vec2(-29.0f,5.0f),1.00f);
        floor.createFixture(floorshape, 0);
        floorshape.setAsBox(6.48f, 0.125f,new Vec2(-23.5f,15.0f),1.00f);
        floor.createFixture(floorshape, 0);
        floorshape.setAsBox(4.00f, 0.125f,new Vec2(-16.0f,20.5f),0.00f);
        floor.createFixture(floorshape, 0);
  */      
        ArrayList<Point2D.Double> List = new ArrayList<Point2D.Double>();
		Point2D.Double currentPoint;
		Point2D.Double lastPoint = new Point2D.Double(-5.00,0);
		Point2D.Double lastlastPoint = new Point2D.Double(-5.00,0);
		floorshape.setAsBox(5.00f, 0.125f,new Vec2(-40.0f,0.0f),0.00f);
		
		List.add(new Point2D.Double(0,0));
		List.add(new Point2D.Double(2,2));
		List.add(new Point2D.Double(5,3));
	
		
//		for (int i = 0; i < List.size(); i++) {
//			currentPoint = List.get(i);
//			float platformLength = (float) Math.sqrt(Math.pow(currentPoint.x - lastPoint.x, 2) + Math.pow(currentPoint.y - lastPoint.y, 2));
//			float angle = (float) Math.tan((currentPoint.y - lastPoint.y)/(currentPoint.x - lastPoint.x));
//			Vec2 newPosition = new Vec2 ();
//			newPosition.x = (float) (floorshape.m_centroid.x + ((lastlastPoint.x - lastPoint.x)) + ((lastPoint.x - currentPoint.x)));
//			newPosition.y = (float) (floorshape.m_centroid.y + ((lastlastPoint.y - lastPoint.y)) + ((lastPoint.y - currentPoint.y)));
//			floorshape.setAsBox(platformLength, 0.125f,newPosition,angle);
//			floor.createFixture(floorshape, 0);
//		}
     
		 floorshape.setAsBox(5.00f, 0.125f,new Vec2(-38.5f,0.0f),0.00f);
	     floor.createFixture(floorfix);
	     floorshape.setAsBox(2.83f, 0.125f,new Vec2(-31.5f,2.0f),0.785f);
	     floor.createFixture(floorfix);
	     floorshape.setAsBox(3.16f, 0.125f,new Vec2(-26.67f,5.0f),(float) Math.tan(1.0/3.0));
	     floor.createFixture(floorfix);
	     floorshape.setAsBox(15.00f, 0.125f,new Vec2(-9.0f,6.0f),0.00f);
	     floor.createFixture(floorfix);
	     
	    
	// Wheels
	    FixtureDef wheelfix = new FixtureDef();
		CircleShape shape = new CircleShape();
		shape.m_radius = 1.5f;
		wheelfix.friction = 3f;
		wheelfix.density = 7f;
		wheelfix.restitution = 0.1f;
		wheelfix.shape = shape;
		
		
		BodyDef wheelbody1 = new BodyDef();
		wheelbody1.type = BodyType.DYNAMIC;
		wheelbody1.position.set(-20.0f, -18.0f);
		Body wheel1_attachment = getWorld().createBody(wheelbody1);
		wheel1_attachment.createFixture(wheelfix);
		
		BodyDef wheelbody2 = new BodyDef();
		wheelbody2.type = BodyType.DYNAMIC;
		wheelbody2.position.set(-16.0f, -18.0f);
		Body wheel2_attachment = getWorld().createBody(wheelbody2);
		wheel2_attachment.createFixture(wheelfix);
		
	// Frame
		
		FixtureDef framefix = new FixtureDef();
	    PolygonShape frameshape = new PolygonShape();
	    frameshape.setAsBox(2f, 0.125f);
	    framefix.density = 20.0f;
	    framefix.shape = frameshape;

	    BodyDef framebody = new BodyDef();
	    framebody.type = BodyType.DYNAMIC;
	    framebody.position = new Vec2(-18.0f,-18.0f);
	    Body frame_attachment = getWorld().createBody(framebody);
	    frame_attachment.createFixture(framefix);
	    
	    RevoluteJointDef revJoint1 = new RevoluteJointDef();
	    RevoluteJointDef revJoint2 = new RevoluteJointDef();
	    revJoint1.initialize(frame_attachment,wheel1_attachment, new Vec2(-20.0f, -18.0f));
	    revJoint2.initialize(frame_attachment,wheel2_attachment, new Vec2(-16.0f, -18.0f));
	    revJoint1.maxMotorTorque = 1750.0f;
	    revJoint1.enableMotor = true;
	    revJoint1.motorSpeed = -15.0f;
	    getWorld().createJoint(revJoint1);
	    getWorld().createJoint(revJoint2);
	      
	}

}
