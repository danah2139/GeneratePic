package elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public class PointLight extends Light implements LightSource{
	
	 protected Point3D _position;
	 protected double Kc, Kj, Kq;
	 
		// ***************** Constructors ********************** // 
	
	 
	 public PointLight(Color _color, Point3D _position, double kc, double kj, double kq) {
		super(_color);
		this._position =new Point3D(_position);
		this.Kc = kc;
		this.Kj = kj;
		this.Kq = kq;
	}
	 
		// ***************** Getters/Setters ********************** // 


	public Point3D get_position() {
		return  new Point3D(_position);
	}

	public void set_position(Point3D _position) {
		this._position = new Point3D(_position);
	}

	public double getKc() {
		return Kc;
	}

	public void setKc(double kc) {
		Kc = kc;
	}

	public double getKj() {
		return Kj;
	}

	//public void setKj(double kj) {
		//Kj = kj;
	//}

	//public double getKq() {
		//return Kq;
	//}

	//public void setKq(double kq) {
		//Kq = kq;
	//}
   // public Color getColor() {
     //   return new Color(_color.getRed(),_color.getGreen(),_color.getBlue());
    //}

    //public void setColor(Color _color) {
      //  this._color = new Color(_color.getRed(),_color.getGreen(),_color.getBlue());
    //}
	
	// ***************** Operations ******************** // 


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PointLight other = (PointLight) obj;
		if (Double.doubleToLongBits(Kc) != Double.doubleToLongBits(other.Kc))
			return false;
		if (Double.doubleToLongBits(Kj) != Double.doubleToLongBits(other.Kj))
			return false;
		if (Double.doubleToLongBits(Kq) != Double.doubleToLongBits(other.Kq))
			return false;
		if (_position == null) {
			if (other._position != null)
				return false;
		} else if (!_position.equals(other._position))
			return false;
		return true;
	}

	
	
    @Override
    public Color getIntensity(Point3D p) throws Exception {        
        Color c;
        int red=this._color.getRed();
        int Blue=this._color.getBlue();
        int Green=this._color.getGreen();
        double d=this._position.direction(p);
        double mechane=this.Kc + this.Kj*d +this.Kq*(d*d); 
        if(mechane<1)
            mechane=1;
        c=new Color(red*=1/mechane,Green*=1/mechane,Blue*=1/mechane);//definition: Color(int r,int g,int b);
        return c;
    }
    @Override
    public Vector getL(Point3D point) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return new Vector(this._position,point);
    }
	

	
	 
	 

}
