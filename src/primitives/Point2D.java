package primitives;

public class Point2D {
	
	protected Coordinate _x;
	protected Coordinate _y;
	// ***************** Getters/Setters ********************** // 
	public Coordinate get_x() {
		return _x;
	}
	public void set_x(Coordinate _x) {
		this._x = _x;
	}
	public Coordinate get_y() {
		return _y;
	}
	public void set_y(Coordinate _y) {
		this._y = _y;
	}
	// ***************** Constructors ********************** // 
	public Point2D() {
		super();
		this._x = new Coordinate() ;
        this._y = new Coordinate();
	}
	public Point2D(Coordinate _x, Coordinate _y) {
		super();
		this._x =new Coordinate( _x);
		this._y = new Coordinate(_y);
	}
    public Point2D(Point2D point2D){
        super();
        _x=point2D.get_x();
        _y=point2D.get_y();    
    
    }
	    
	// ***************** Administration  ******************** // 
	@Override
	public String toString() {
		return "Point2D [get_x()=" + get_x() + ", get_y()=" + get_y() + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point2D other = (Point2D) obj;
		if (_x == null) {
			if (other._x != null)
				return false;
		} else if (!_x.equals(other._x))
			return false;
		if (_y == null) {
			if (other._y != null)
				return false;
		} else if (!_y.equals(other._y))
			return false;
		return true;
	}
	

}
