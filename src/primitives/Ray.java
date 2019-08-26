package primitives;

public class Ray {
	
	protected Point3D _P0;
	protected Vector _direction;
	
	// ***************** Getters/Setters ********************** // 	
	public Point3D get_P0() {
		return _P0;
	}
	public void set_P0(Point3D _P0) {
		this._P0 = _P0;
	}
	public Vector get_direction() {
		return _direction;
	}
	public void set_direction(Vector _direction) {
		this._direction = _direction;
	}
	// ***************** Constructors ********************** // 
	
	public Ray(Point3D _P0, Vector _direction) {
		super();
		this._P0 = _P0;
		this._direction = _direction;
		this._direction.normalize();
		
	}
	public Ray() {
		this._P0=new Point3D();
		this._direction=new Vector(_direction);
	}
	// ***************** Administration  ******************** // 
	@Override
	public String toString() {
		return "Ray [get_P0()=" + get_P0() + ", get_direction()=" + get_direction() + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ray other = (Ray) obj;
		if (_P0 == null) {
			if (other._P0 != null)
				return false;
		} else if (!_P0.equals(other._P0))
			return false;
		if (_direction == null) {
			if (other._direction != null)
				return false;
		} else if (!_direction.equals(other._direction))
			return false;
		return true;
	}
	
	
	
	
	

}
