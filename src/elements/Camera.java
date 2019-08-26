package elements;

import java.util.ArrayList;

import primitives.Coordinate;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Camera {
	
	protected Point3D _P0 ;
	protected Vector _vUp; 
	protected Vector _vTo;
	protected Vector _vRight;
	
	// ***************** Constructors ********************** // 
	
	  public Camera() {
	        this._P0 = new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(10));
	     //   Point3D _p3 = new Point3D(new Coordinate(1),new Coordinate(0),new Coordinate(0));
	        Point3D _p1 = new Point3D(new Coordinate(1),new Coordinate(0),new Coordinate(0));
	        Point3D _p2 = new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-1));
	        this._vTo = new Vector(_p2);
	       
	        
	        this._vUp =  new Vector(_p1);
	        this._vRight = _vUp.crossProduct(_vTo);
	    }
	     
	    public Camera(Point3D _p0, Vector _Vto, Vector _Vright, Vector _Vup) {
	        this._P0 = new Point3D(_p0);
	        this._vTo = new Vector(_Vto);
	        this._vRight =  new Vector(_Vright);
	        this._vUp =  new Vector(_Vup);
	    }

	    public Camera(Point3D _p0, Vector _Vto, Vector _Vright) {
	        this._P0 = new Point3D(_p0);
	        this._vTo = new Vector(_Vto);
	        this._vRight =  new Vector(_Vright);
	        this._vUp=_Vto.crossProduct(_Vright);
	    }
	    
    	// ***************** Getters/Setters ********************** // 


	public Point3D get_P0() {
		return new Point3D(_P0);
	}

	public void set_P0(Point3D _P0) {
		this._P0 = new Point3D(_P0);
	}

	public Vector get_vUp() {
		return new Vector(_vUp);
	}

	public void set_vUp(Vector _vUp) {
		this._vUp = new Vector(_vUp);
	}

	public Vector get_vTo() {
		return new Vector(_vTo);
	}

	public void set_vTo(Vector _vTo) {
		this._vTo = new Vector(_vTo);
	}

	public Vector get_vRight() {
		return new Vector(_vRight);
	}

	public void set_vRight(Vector _vRight) {
		this._vRight = new Vector(_vRight);
	}
	
	// ***************** Operations ******************** // 


	@Override
	public String toString() {
		return "Camera [_P0=" + _P0 + ", _vUp=" + _vUp + ", _vTo=" + _vTo + ", _vRight=" + _vRight + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Camera other = (Camera) obj;
		if (_P0 == null) {
			if (other._P0 != null)
				return false;
		} else if (!_P0.equals(other._P0))
			return false;
		if (_vRight == null) {
			if (other._vRight != null)
				return false;
		} else if (!_vRight.equals(other._vRight))
			return false;
		if (_vTo == null) {
			if (other._vTo != null)
				return false;
		} else if (!_vTo.equals(other._vTo))
			return false;
		if (_vUp == null) {
			if (other._vUp != null)
				return false;
		} else if (!_vUp.equals(other._vUp))
			return false;
		return true;
	}
	
	   public ArrayList<Ray> constructRayThroughPixel(int Nx, int Ny, int x, int y,double screenDist, double screenWidth, double screenHeight) throws Exception
	    {
		   ArrayList<Ray> nineRays=new ArrayList<Ray>();
		   
	        Ray r1=help_constructRayThroughPixel( Nx,  Ny,  x,  y, screenDist,  screenWidth,  screenHeight, 0.5,0.5 );
	       
	        Ray r2=help_constructRayThroughPixel( Nx,  Ny,  x,  y, screenDist,  screenWidth,  screenHeight, 1/4,3/4);        
	        
	        Ray r3=help_constructRayThroughPixel( Nx,  Ny,  x,  y, screenDist,  screenWidth,  screenHeight, 3/4,1/4);
	        
	        Ray r4=help_constructRayThroughPixel( Nx,  Ny,  x,  y, screenDist,  screenWidth,  screenHeight, 1/4,1/4);
	        
	        Ray r5=help_constructRayThroughPixel( Nx,  Ny,  x,  y, screenDist,  screenWidth,  screenHeight, 3/4,3/4);
	        
	        Ray r6=help_constructRayThroughPixel( Nx,  Ny,  x,  y, screenDist,  screenWidth,  screenHeight, 1/4,0.5);        
	        
	        Ray r7=help_constructRayThroughPixel( Nx,  Ny,  x,  y, screenDist,  screenWidth,  screenHeight, 0.5,1/4);
	        
	        Ray r8=help_constructRayThroughPixel( Nx,  Ny,  x,  y, screenDist,  screenWidth,  screenHeight, 0.5,3/4);
	        
	        Ray r9=help_constructRayThroughPixel( Nx,  Ny,  x,  y, screenDist,  screenWidth,  screenHeight, 3/4,0.5);
	        
	        
	        
	        nineRays.add(r1);
	        nineRays.add(r2);
	        nineRays.add(r3);
	        nineRays.add(r4);
	        nineRays.add(r5);
	        nineRays.add(r6);
	        nineRays.add(r7);
	        nineRays.add(r8);
	        nineRays.add(r9);
	        
	        
	        return nineRays; 
	    }
	public Ray help_constructRayThroughPixel (int Nx, int Ny, int x, int y,
            double screenDist, double screenWidth, double screenHeight,double temp_div_Rx, double temp_div_Ry)
	{ 
		Point3D Pc=  new Point3D(_P0);
		Vector v_to = new Vector(_vTo);
		v_to.scale(screenDist);
		Pc.add(v_to);
		
		double Rx=screenWidth/Nx;
		double A = (x-(Nx/2))* Rx + (Rx*temp_div_Rx);
		Vector vRight = new Vector(_vRight);
		vRight.scale(A);
		double Ry=screenWidth/Ny;
		double B = (y-(Ny/2))* Ry + (Ry*temp_div_Ry);
		Vector v_up= new Vector(_vUp);
		v_up.scale(B);
		vRight.substract(v_up);
		Point3D point = new Point3D(Pc);
		point.add(vRight);
		Vector diractionRay=new Vector(point);
		diractionRay.normalize();
		return new Ray(this._P0,diractionRay);
            
	}

	
	

	
	
	
	
	





}
