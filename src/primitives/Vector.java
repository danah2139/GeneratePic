package primitives;



public class Vector {
	
	protected Point3D _head;
	
	// ***************** Constructors ********************** // 

    public Vector() {
        this._head = new Point3D();
    }
    
    public Vector(Vector _v) {
        _head=_v.get_head();
    }     
    
    public Vector(Point3D _head) {
        this._head =new Point3D(_head);
    }
    public Vector(Point3D p1, Point3D p2)
    {
        double x=p2.get_x().get_coordinate()-p1.get_x().get_coordinate();
        double y=p2.get_y().get_coordinate()-p1.get_y().get_coordinate();
        double z=p2.get_z().get_coordinate()-p1.get_z().get_coordinate();
        Coordinate coorx=new Coordinate(x);
        Coordinate coory=new Coordinate(y);
        Coordinate coorz=new Coordinate(z);
        _head=new Point3D(coorx,coory,coorz);
    }
    
    public Vector(double _x, double _y, double _z) {
        this._head=new Point3D(new Coordinate(_x),new Coordinate(_y),new Coordinate(_z));
    }

	// ***************** Getters/Setters ********************** // 
	
	public Point3D get_head() {
		return new Point3D(_head);
	}

	public void set_head(Point3D _head) {
		this._head = new Point3D(_head);
	}

	// ***************** Administration  ******************** // 
	@Override
	public String toString() {
		return "Vector [get_head()=" + get_head() + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector other = (Vector) obj;
		if (_head == null) {
			if (other._head != null)
				return false;
		} else if (!_head.equals(other._head))
			return false;
		return true;
	}
	// ***************** Operations ******************** // 

	public void add(Vector v){
		this._head.add(v);    	
      	
    }
    public void substract(Vector v){
		this._head.substract(v);;    	

    }
    public void scale(double scalingFactor){
    	
    	this._head.set_x(new Coordinate(scalingFactor * _head.get_x().get_coordinate()));
    	this._head.set_y(new Coordinate(scalingFactor * _head.get_y().get_coordinate()));
    	this._head.set_z(new Coordinate(scalingFactor * _head.get_z().get_coordinate()));
    }
    public Vector crossProduct(Vector vector){
    	
    	double x1= this.get_head().get_x().get_coordinate();
    	double y1= this.get_head().get_y().get_coordinate();
    	double z1= this.get_head().get_z().get_coordinate();
    	
    	double x2= vector.get_head().get_x().get_coordinate();
    	double y2= vector.get_head().get_y().get_coordinate();
    	double z2= vector.get_head().get_z().get_coordinate();
    			
    	return new Vector(y1*z2 -z1*y2,z1*x2-x1*z2,x1*y2-y1*x2);    }
    
    public double length(){
    	
    	double x= this.get_head().get_x().get_coordinate();
    	double y= this.get_head().get_y().get_coordinate();
    	double z= this.get_head().get_z().get_coordinate();
    	return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));

    }
    public void normalize(){
    	double x= this.get_head().get_x().get_coordinate();
    	double y= this.get_head().get_y().get_coordinate();
    	double z= this.get_head().get_z().get_coordinate();
    	double length = this.length(); 
    	if (length==0)
    		throw new ArithmeticException();
    	
    	this.set_head(new Point3D(x/length,y/length,z/length)); 
    	
    }
    public double dotProduct(Vector vector){
    	
    	double x1= this.get_head().get_x().get_coordinate();
    	double y1= this.get_head().get_y().get_coordinate();
    	double z1= this.get_head().get_z().get_coordinate();
    	
    	double x2= vector.get_head().get_x().get_coordinate();
    	double y2= vector.get_head().get_y().get_coordinate();
    	double z2= vector.get_head().get_z().get_coordinate();
    	
    	return ((x1 * x2) + (y1 * y2) +(z1 * z2));
    }
    

}
