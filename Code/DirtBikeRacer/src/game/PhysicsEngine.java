package game;

import java.awt.geom.Point2D.Double;
import java.util.ArrayList;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.joints.RevoluteJointDef;

/**
 * The physics engine for a single session
 *
 * @author schuenjr.
 *         Created May 4, 2012.
 */
public class PhysicsEngine {
	public World world;
	public Body level;
	public RevoluteJointDef revJointRear;
	
	/**
	 * Creates a simulation with no level
	 *
	 */
	public PhysicsEngine() {
		this.level = null;
	}
	/**
	 * Constructs a simulation from the given level
	 *
	 * @param parsedLevel
	 */
	public PhysicsEngine(ArrayList<Double> parsedLevel) {
		this.world = new World(new Vec2(0.0f, -10.0f), true);
		this.level = buildLevel(parsedLevel);
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param parsedLevel
	 * @return 
	 */
	private Body buildLevel(ArrayList<Double> parsedLevel) {
		// Floor
				FixtureDef floorfix = new FixtureDef();
				PolygonShape floorshape = new PolygonShape();
				floorfix.shape = floorshape;
				
				BodyDef floorbody = new BodyDef();
				floorbody.position = new Vec2(20.0f, -20f);
				floorfix.friction = 100f;
				Body floor = this.world.createBody(floorbody);
				
				 floorshape.setAsBox(0.25f, 5.0f,new Vec2(-30.0f,4.0f),1.00f);
		         floor.createFixture(floorshape, 0);
		         floorshape.setAsBox(0.25f, 5.0f,new Vec2(-20.0f,4.0f),1.5f);
		         floor.createFixture(floorshape, 0);
		         floorshape.setAsBox(0.25f, 5.0f,new Vec2(-10.0f,4.0f),1.55f);
		         floor.createFixture(floorshape, 0);
		       
		         
				
			// Wheels
				CircleShape shape = new CircleShape();
				shape.m_radius = 1.0f;
				BodyDef wheelbody1 = new BodyDef();
				wheelbody1.type = BodyType.DYNAMIC;
				wheelbody1.position.set(-2.0f, -9.0f);
				Body wheel1_attachment = this.world.createBody(wheelbody1);
				wheel1_attachment.createFixture(shape, 2.0f);
				
				
				BodyDef wheelbody2 = new BodyDef();
				wheelbody2.type = BodyType.DYNAMIC;
				wheelbody2.position.set(2.0f, -9.0f);
				Body wheel2_attachment = this.world.createBody(wheelbody2);
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
			    Body frame_attachment = this.world.createBody(framebody);
			    frame_attachment.createFixture(framefix);
			    
			    RevoluteJointDef revJoint1 = new RevoluteJointDef();
			    RevoluteJointDef revJoint2 = new RevoluteJointDef();
			    revJoint1.initialize(frame_attachment,wheel1_attachment, new Vec2(-2.0f, -9.0f));
			    revJoint2.initialize(frame_attachment,wheel2_attachment, new Vec2(2.0f, -9.0f));
			    revJoint1.maxMotorTorque = 100.f;
			    revJoint1.enableMotor = true;
			    revJoint1.motorSpeed = -200.0f;
			    this.world.createJoint(revJoint1);
			    this.world.createJoint(revJoint2);
				return floor;
			      
			}


	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	public void motorStart() {
		// TODO Auto-generated method stub.
		
	}

}
