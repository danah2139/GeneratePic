package elements;

import java.awt.Color;
import java.util.Objects;

import primitives.Point3D;

public class AmbientLight extends Light {
	
	protected double _ka;
	
	// ***************** Constructors ********************** // 

	public AmbientLight(){
		super(new Color(255,255,255));
		this._ka=0.1;
	
	//_ka = 1;
	}
	
	
	public AmbientLight(int red,int green,int blue){
		super( new Color(red*1,green*1,blue*1));
		
	
	}
	 public AmbientLight(Color _color, double Ka) {
	        super(_color);
	        this._ka = Ka;
	    }

 	// ***************** Getters/Setters ********************** // 

	


	public Color get_color() {
		return _color;
	}


	public void set_color(Color _color) {
		this._color = _color;
	}


	public double get_ka() {
		return _ka;
	}


	public void set_ka(double _ka) {
		this._ka = _ka;
	}
	
	// ***************** Operations ******************** // 

	
	
	@Override
	public Color getIntensity(Point3D p){
		
		int red=(int)(_color.getRed()* _ka);
		int green=(int)(_color.getGreen()* _ka);
		int blue=(int)(_color.getBlue()* _ka);
		Color color= new Color(red,green,blue);
		return color;
		
	}


	@Override
	public String toString() {
		return "AmbientLight [_ka=" + _ka + ", _color=" + _color + "]";
	}





    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
         if(super.equals(obj))
            return false;
        final AmbientLight other = (AmbientLight) obj;
        if (Double.doubleToLongBits(this._ka) != Double.doubleToLongBits(other._ka)) {
            return false;
        }
        if (!Objects.equals(this._color, other._color)) {
            return false;
        }
        return true;
    }
	
	

}
