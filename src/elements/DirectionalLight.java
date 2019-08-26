package elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public class DirectionalLight extends Light implements LightSource {
	
	
	protected Vector direction;

	public DirectionalLight(Color _color, Vector direction) {
		super(_color);
		this.direction =new Vector( direction);
	}
	public DirectionalLight(){
        super();
        this.direction=new Vector(0,0,0);//!
    }
	public Vector getDirection() {
		return new Vector (direction);
	}
	public void setDirection(Vector direction) {
		this.direction = new Vector(direction);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DirectionalLight other = (DirectionalLight) obj;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DirectionalLight [direction=" + direction + "]";
	}
	
	
	 @Override
	    public Vector getL(Point3D point) {
	         return this.getDirection();
	    }

	 @Override
	 public Color getIntensity(Point3D point) throws Exception {
		 return new Color(_color.getRed(),_color.getGreen(),_color.getBlue());    	 }
	    
	
	
	
	
	
	

}
