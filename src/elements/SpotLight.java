package elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;
import static java.lang.Math.abs;


public class SpotLight extends PointLight {
	
	
    protected Vector _direction;

	public SpotLight(Color _color, Point3D _position, double kc, double kj, double kq, Vector _direction) {
		super(_color, _position, kc, kj, kq);
		this._direction = new Vector(_direction);
	}

	public Vector get_direction() {
		return new Vector(_direction);
	}

	public void set_direction(Vector _direction) {
		this._direction = new Vector(_direction);
	}
	public Point3D getPosition() {
        return new Point3D(_position);
    }

    public void setPosition(Point3D position) {
        this._position = new Point3D(position);
    }

    public double getKc() {
        return Kc;
    }

    public void setKc(double Kc) {
        this.Kc = Kc;
    }

    public double getKj() {
        return Kj;
    }

    public void setKj(double Kj) {
        this.Kj = Kj;
    }

    public double getKq() {
        return Kq;
    }

    public void setKq(double Kq) {
        this.Kq = Kq;
    }
	//public Color getColor() {
      //  return new Color(_color.getRed(),_color.getGreen(),_color.getBlue());
    //}

    //public void setColor(Color _color) {
      //  this._color = new Color(_color.getRed(),_color.getGreen(),_color.getBlue());
    //}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpotLight other = (SpotLight) obj;
		if (_direction == null) {
			if (other._direction != null)
				return false;
		} else if (!_direction.equals(other._direction))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SpotLight [_direction=" + _direction + "]";
	}
	
	@Override
    public Color getIntensity(Point3D point) throws Exception{

		 Color c=super.getIntensity(point);
	        Vector L= super.getL(point);//new Vector(this._position,p);//? <=>
	        L.normalize();;
	        double A=abs(this._direction.dotProduct(L));
	        if(A>1)
	            A=1;
	        //c*=A;
	        int red=(int)(c.getRed()*A);
	        int blue=(int)(c.getBlue()*A);
	        int green=(int)(c.getGreen()*A);
	        if(red>255)
	            red=255;
	        if(blue>255)
	            blue=255;
	        if(green>255)
	            green=255;
	        Color n_c=new Color(red,green,blue);
	        
	        return n_c;
	
        
       }
	  // @Override
	    //public Vector getL(Point3D point) {
//	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	      //  return new Vector(this._position,point);
	    //}
	
	
    
    


}
