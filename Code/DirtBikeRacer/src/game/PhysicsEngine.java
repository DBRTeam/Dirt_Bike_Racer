package game;

import java.awt.geom.Point2D.Double;
import java.util.ArrayList;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.joints.RevoluteJoint;
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
	public RevoluteJoint revJointRear;
	public RevoluteJoint revJointRider;
	private Fixture BikeFrame;
	private Fixture FrontWheelFrame;
	private Fixture RearWheelFrame;
	public boolean up;
	public boolean down;
	private Fixture RiderFrame;
	public boolean right;
	public boolean left;
	private static final float DegtoRad = 0.0174532935199432957f;
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
	public PhysicsEngine(int level) {
		this.world = new World(new Vec2(0.0f, -10.0f), true);
		this.level = buildLevel(level);
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @return 
	 */
	private Body buildLevel(int level){
		// Floor
				FixtureDef floorfix = new FixtureDef();
				PolygonShape floorshape = new PolygonShape();
				floorfix.shape = floorshape;
				
				BodyDef floorbody = new BodyDef();
				floorbody.position = new Vec2(20.0f, -20f);
				floorfix.friction = 12f;
				floorfix.density = 0;
				floorfix.restitution = 0;
				
				Body floor = this.world.createBody(floorbody);
				
				if (level == 1){
//				// Top
//				floorshape.setAsBox(50.00f, 0.125f,new Vec2(-20.0f,43.125f),0.00f);
//			    floor.createFixture(floorfix);
//			    // Right
//			    floorshape.setAsBox(0.125f, 28.125f,new Vec2(30.0f,15.0f),0.00f);
//			    floor.createFixture(floorfix);
			    //Bottom
			    floorshape.setAsBox(50.00f, 0.125f,new Vec2(-20.0f,-13.125f),0.00f);
			    floor.createFixture(floorfix);
			    //Left
			    floorshape.setAsBox(0.125f, 28.125f,new Vec2(-70.0f,15.0f),0.00f);
			    floor.createFixture(floorfix);
			    
			    floorshape.setAsBox(2.83f, 0.125f,new Vec2(-31.5f,-11.0f),0.785f);
			    floor.createFixture(floorfix);
			    floorshape.setAsBox(3.16f, 0.125f,new Vec2(-26.67f,-8.0f),(float) Math.tan(1.0/3.0));
			    floor.createFixture(floorfix);
			    floorshape.setAsBox(15.00f, 0.125f,new Vec2(-9.0f,-7.0f),0.00f);
			    floor.createFixture(floorfix);
			    floorshape.setAsBox(16.00f, 0.125f,new Vec2(17.0f,3.5f),45.00f * DegtoRad);
			    floor.createFixture(floorfix);
			    
				} else if (level == 2){
			    
//					// Top
//					floorshape.setAsBox(50.00f, 0.125f,new Vec2(-20.0f,43.125f),0.00f);
//				    floor.createFixture(floorfix);
//				    // Right
//				    floorshape.setAsBox(0.125f, 28.125f,new Vec2(30.0f,15.0f),0.00f);
//				    floor.createFixture(floorfix);
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
				    
				} else {
				    
//					// Top
//					floorshape.setAsBox(50.00f, 0.125f,new Vec2(-20.0f,43.125f),0.00f);
//				    floor.createFixture(floorfix);
//				    // Right
//				    floorshape.setAsBox(0.125f, 28.125f,new Vec2(30.0f,15.0f),0.00f);
//				    floor.createFixture(floorfix);
				    //Bottom
				    floorshape.setAsBox(50.00f, 0.125f,new Vec2(-20.0f,-13.125f),0.00f);
				    floor.createFixture(floorfix);
				    //Left
				    floorshape.setAsBox(0.125f, 28.125f,new Vec2(-70.0f,15.0f),0.00f);
				    floor.createFixture(floorfix);
				    
				    floorshape.setAsBox(5.0f, 0.125f,new Vec2(-50.5f,-10.0f),45.0f * DegtoRad);
				    floor.createFixture(floorfix);
				    floorshape.setAsBox(5.0f, 0.125f,new Vec2(-43.5f,-10.0f),135.0f * DegtoRad);
				    floor.createFixture(floorfix);
				    
				    floorshape.setAsBox(5.0f, 0.125f,new Vec2(-35.5f,-13.0f),45.0f * DegtoRad);
				    floor.createFixture(floorfix);
				    floorshape.setAsBox(5.0f, 0.125f,new Vec2(-28.5f,-13.0f),135.0f * DegtoRad);
				    floor.createFixture(floorfix);
				    
				    floorshape.setAsBox(5.0f, 0.125f,new Vec2(-26.5f,-11.0f),45.0f * DegtoRad);
				    floor.createFixture(floorfix);
				    floorshape.setAsBox(5.0f, 0.125f,new Vec2(-19.5f,-11.0f),135.0f * DegtoRad);
				    floor.createFixture(floorfix);
				    
				    floorshape.setAsBox(10.0f, 0.125f,new Vec2(10.5f,-8.5f),30.0f * DegtoRad);
				    floor.createFixture(floorfix);
			    }
				
			// Wheels
			     
			    FixtureDef wheelfix = new FixtureDef();
				CircleShape shape = new CircleShape();
				shape.m_radius = .75f;
				wheelfix.friction = 12f;
				wheelfix.density = 50f;
				wheelfix.restitution = 0.1f;
				wheelfix.shape = shape;
				
				
				BodyDef wheelbody1 = new BodyDef();
				wheelbody1.type = BodyType.DYNAMIC;
				wheelbody1.position.set(-48.0f, -32.0f);
				Body wheel1_attachment = this.world.createBody(wheelbody1);
				this.RearWheelFrame = wheel1_attachment.createFixture(wheelfix);
				
				BodyDef wheelbody2 = new BodyDef();
				wheelbody2.type = BodyType.DYNAMIC;
				wheelbody2.position.set(-46.0f, -32.0f);
				Body wheel2_attachment = this.world.createBody(wheelbody2);
				this.FrontWheelFrame = wheel2_attachment.createFixture(wheelfix);
				
			// Frame
				
				FixtureDef framefix = new FixtureDef();
			    PolygonShape frameshape = new PolygonShape();
			    frameshape.setAsBox(1f, 0.125f);
			    framefix.density = 50.0f;
			    framefix.shape = frameshape;
			    

			    BodyDef framebody = new BodyDef();
			    framebody.type = BodyType.DYNAMIC;
			    framebody.position = new Vec2(-47.0f,-32.0f);
			    Body frame_attachment = this.world.createBody(framebody);
			    this.BikeFrame = frame_attachment.createFixture(framefix);
			    
			    RevoluteJointDef revJoint1 = new RevoluteJointDef();
			    RevoluteJointDef revJoint2 = new RevoluteJointDef();
			    revJoint1.initialize(frame_attachment,wheel1_attachment, new Vec2(-48.0f, -32.0f));
			    revJoint2.initialize(frame_attachment,wheel2_attachment, new Vec2(-46.0f, -32.0f));
			    revJoint1.maxMotorTorque = 1000.0f;
			    revJoint1.enableMotor = true;
			    revJoint1.motorSpeed = -25.0f;
			    this.revJointRear = (RevoluteJoint) this.world.createJoint(revJoint1);
			    this.world.createJoint(revJoint2);
			    
			    
			    
				 // Rider
				    
				    FixtureDef riderfix = new FixtureDef();
				    PolygonShape ridershape = new PolygonShape();
				    ridershape.setAsBox(0.0625f, 2.0f);
				    riderfix.density = 20f;
				    riderfix.shape = ridershape;
				    riderfix.friction = 0f;

				    BodyDef riderbody = new BodyDef();
				    riderbody.type = BodyType.DYNAMIC;
				    riderbody.position = new Vec2(-47.0f,-30.0f);
				    Body rider_attachment = this.world.createBody(riderbody);
				    this.RiderFrame = rider_attachment.createFixture(riderfix);
				    
				    RevoluteJointDef revJoint3 = new RevoluteJointDef();
				    revJoint3.initialize(rider_attachment,frame_attachment, new Vec2(-47.0f, -32.0f));
				    revJoint3.maxMotorTorque = 2000.0f;
				    revJoint3.enableMotor = true;
				    revJoint3.motorSpeed = 15.0f;
				    this.revJointRider = (RevoluteJoint) this.world.createJoint(revJoint3); 
				    
				    return floor;
			}

	
	public double getBikeXPostion() {
		Vec2 position = this.BikeFrame.getBody().getPosition();
		return position.x;
	}
	
	public double getBikeYPostion() {
		Vec2 position = this.BikeFrame.getBody().getPosition();
		return position.y;
	}
	public void setUptoTrue(){
		this.up = true;
	}
	public void setUptoFalse(){
		this.up = false;
	}
		
	public void setDowntoTrue(){
		this.down = true;
	}
	public void setDowntoFalse(){
		this.down = false;
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	public void step() {
		this.world.step((1.0f/60.0f),8,3);
		if (this.up && this.down){
			this.revJointRear.setMotorSpeed(0);
		} else if (this.up){
			this.revJointRear.setMotorSpeed(-25);
		} else if (this.down){
			this.revJointRear.setMotorSpeed(25);
		} else {
			this.revJointRear.setMotorSpeed(0);
		}
		
		if (this.left && this.right){
			this.revJointRider.setMotorSpeed(0);
		} else if (this.right){
			this.revJointRider.setMotorSpeed(50);
		} else if (this.left){
			this.revJointRider.setMotorSpeed(-50);
		} else {
			this.revJointRider.setMotorSpeed(0);
		}
	}
	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @return
	 */
	public double getBikeFrontWheelx() {
		return this.FrontWheelFrame.getBody().getPosition().x;
	}
	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @return
	 */
	public double getBikeFrontWheely() {
		return this.FrontWheelFrame.getBody().getPosition().y;
	}
	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @return
	 */
	public double getBikeRearWheelx() {
		return this.RearWheelFrame.getBody().getPosition().x;
	}
	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @return
	 */
	public double getBikeRearWheely() {
		return this.RearWheelFrame.getBody().getPosition().y;
	}
	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	public void motorStart() {
		this.revJointRear.setMotorSpeed(-25);
	}
	public double getBikeRiderx() {
		return this.RiderFrame.getBody().getPosition().x;
	}
	public double getBikeRidery() {
		return this.RiderFrame.getBody().getPosition().y;
	}
	public void setLefttoTrue() {
		this.left = true;
	}
	public void setRighttoTrue() {
		this.right = true;
	}
	public void setLefttoFalse() {
		this.left = false;
	}
	public void setRighttoFalse() {
		this.right = false;
	}
	
	
}
