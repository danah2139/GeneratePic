package geometries;
import primitives.Material;
import primitives.Point3D;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import primitives.Ray;
import primitives.Vector;


public class Plane extends Geometry implements FlatGeometry {
	
	
	protected Vector N;
	protected Point3D _Q;
	
	// ***************** Constructors ********************** // 

	
    public Plane(Point3D _p1, Vector v1) {
        super(Color.BLACK);
        this._Q = new Point3D(_p1);//
        this.N= new Vector(v1);//
	    
	    }

    public Plane(Point3D _p1, Vector v1,Color _c,Material _material) {
        super(_material,_c);
        this._Q = new Point3D(_p1);//
        this.N = new Vector(v1);
    }
    
	// ***************** Getters/Setters ********************** // 

    
   // public Color getColor() {
     //   return _emmission;
    //}

    //public void setColor(Color _color) {
      //  this._emmission = _color;
    //}

	public Vector getN() {
		return new Vector(N);
	}

	public void setN(Vector n) {
		N = new Vector(n);
	}

	public Point3D get_Q() {
		return new Point3D(_Q);//
	}

	public void set_Q(Point3D _Q) {
		this._Q =new Point3D(_Q);
	}
	
	
	// ***************** Operations ******************** // 


	@Override
	public String toString() {
		return "Plane [N=" + N + ", _Q=" + _Q + "]";
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plane other = (Plane) obj;
		if (N == null) {
			if (other.N != null)
				return false;
		} else if (!N.equals(other.N))
			return false;
		if (_Q == null) {
			if (other._Q != null)
				return false;
		} else if (!_Q.equals(other._Q))
			return false;
		return true;
	} 
    @Override
    public Vector getNormal(Point3D p)
    {
        try{
        this.N.normalize();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());            
        }
        return new Vector(N);
    }
	
	
	
	
	/*
	 
	 * @see geometries.Geometry#findIntersections(primitives.Ray)
	 * first check if there is indeed an point on the plane that it intersects with
	 */
	@Override 
	public List<Point3D>findIntersections(Ray ray){
        List<Point3D> list=new ArrayList<Point3D>();
       
        //p0-Q0:
        Vector ray_direc=new Vector (ray.get_direction());//ray direction
        Point3D ray_P0=new Point3D(ray.get_P0());//ray's point
        Vector plain_N=new Vector (this.getN());//plain normal
        Point3D plain_Q= new Point3D(this.get_Q());//plain p
        Vector tempVector= new Vector(plain_Q,ray_P0);
        double t=(plain_N.dotProduct(tempVector)*-1)/plain_N.dotProduct(ray_direc);
		if(t>=0){
                    ray_direc.scale(t);//
			Vector v1=new Vector(ray_direc);
                        ray_P0.add(v1);
		    Point3D p1=new Point3D(ray_P0);
			list.add(p1);
		}
		return list;
    }
	
	
	
	
	
	
	
	
	
	
	



}
