package elements;

import java.awt.Color;

import primitives.Point3D;

public abstract class Light {
	
	protected Color _color;
	
	// ***************** Constructors ********************** // 


	public Light(Color _color) {
		super();
		this._color = _color;
		
	}
	public Light() {
	    this._color = new Color(0,0,0);
	}

	// ***************** Getters/Setters ********************** // 

	public Color getColor() {
	    return new Color(_color.getRed(),_color.getGreen(),_color.getBlue());
	}

	public void setColor(Color _color) {
	    this._color = new Color(_color.getRed(),_color.getGreen(),_color.getBlue());
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Light other = (Light) obj;
		if (_color == null) {
			if (other._color != null)
				return false;
		} else if (!_color.equals(other._color))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Light [_color=" + _color + "]";
	}
	//public Color getIntensity(Point3D p) {
		// TODO Auto-generated method stub
		//return null;
	//}
	
	// ***************** Operations ******************** // 

	
    public abstract Color getIntensity(Point3D p)throws Exception;


}
