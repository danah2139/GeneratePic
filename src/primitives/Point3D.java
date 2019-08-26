package primitives;

public class Point3D extends Point2D {
	
	protected Coordinate _z;
	
	// ***************** Getters/Setters ********************** // 


	public Coordinate get_z() {
		return new Coordinate (_z);
	}

	public void set_z(Coordinate _z) {
		this._z = new Coordinate (_z);
	}
	// ***************** Constructors ********************** // 
	public Point3D(Coordinate _x, Coordinate _y, Coordinate _z) {
		super(_x, _y);
		this._z = new Coordinate(_z);
	}
	public Point3D (double x , double y , double z){
		super(new Coordinate(x),new Coordinate(y));
		_z=new Coordinate (z);

	}

	public Point3D() {
		super();
        this._z = new Coordinate();
	}
	public Point3D(Point3D P) {
		super(P._x,P._y);
        this._z =P.get_z();	}

	// ***************** Administration  ******************** // 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point3D other = (Point3D) obj;
		if (_z == null) {
			if (other._z != null)
				return false;
		} else if (!_z.equals(other._z))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Point3D [_z=" + _z + ", get_z()=" + get_z() + "]";
	}
   public void add(Vector v){
	   this._x.add(v.get_head().get_x());
	   this._y.add(v.get_head().get_y());
	   this._z.add(v.get_head().get_z());
	 
	   }
   
	public void substract(Vector v)
	{
		   this._x.substract(v.get_head().get_x());
		   this._y.substract(v.get_head().get_y());
		   this._z.substract(v.get_head().get_z());
	   }
	public double direction(Point3D p){ 
		double a,b,c,d;
		b= this._x.get_coordinate()-p.get_x().get_coordinate();
		c= this._y.get_coordinate()-p.get_y().get_coordinate();
		d= this._z.get_coordinate()-p.get_z().get_coordinate();
		a= Math.sqrt((Math.pow(b, 2)) + Math.pow(c, 2) + Math.pow(d, 2));
		return a;
	}
   
  
	
	
	

}
