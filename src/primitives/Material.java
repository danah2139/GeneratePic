package primitives;

public class Material {
	
	protected double _Kd;
	protected double _Ks;
	protected double _Kr;
	protected double _Kt;
	protected int _nShininess;
	
	public Material(double _Kd, double _Ks,double _kr,double _kt, int _nShininess) {
		super();
		this._Kd = _Kd;
		this._Ks = _Ks;
		this._Kr = _kr;
        this._Kt = _kt;
		this._nShininess = _nShininess;
	}
    public Material(double _Kd, double _Ks, int nShininess) {
        this._Kd = _Kd;
        this._Ks = _Ks;
        this._nShininess=nShininess;
        this._Kr = 0;//0  //Perfect mirror has a KR of 1 and matt surface has a KR of 0
        this._Kt = 0;//0  //where KT = 1 when object is translucent, KT = 0 when the object is opaque.
    }
	 public Material() {
	        this._Kd = 1;//default
	        this._Ks = 1;//default
	        this._Kr = 0;//default
	        this._Kt = 0;//default	
	        this._nShininess=1;
	    }
	public Material(Material other) {
		super();
		this._Kd = other._Kd;
		this._Ks = other._Ks;
		this._Kr = other._Kr;
		this._Kt = other._Kt;
		this._nShininess = other._nShininess;
	}
	public double get_Kd() {
		return _Kd;
	}
	public void set_Kd(double _Kd) {
		this._Kd = _Kd;
	}
	public double get_Ks() {
		return _Ks;
	}
	public void set_Ks(double _Ks) {
		this._Ks = _Ks;
	}
	public int get_nShininess() {
		return _nShininess;
	}
	
	public void set_nShininess(int _nShininess) {
		this._nShininess = _nShininess;
	}

    public double getKs() {
        return _Ks;
    }

    public void setKs(double _Ks) {
        this._Ks = _Ks;
    }

    public double getKr() {
        return _Kr;
    }

    public void setKr(double _Kr) {
        this._Kr = _Kr;
    }

    public double getKt() {
        return _Kt;
    }

    public void setKt(double _Kt) {
        this._Kt = _Kt;
    }
    
	@Override
	public String toString() {
		return "Material [_Kd=" + _Kd + ", _Ks=" + _Ks + ", _Kr=" + _Kr + ", _Kt=" + _Kt + ", _nShininess="
				+ _nShininess + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		if (Double.doubleToLongBits(_Kd) != Double.doubleToLongBits(other._Kd))
			return false;
		if (Double.doubleToLongBits(_Kr) != Double.doubleToLongBits(other._Kr))
			return false;
		if (Double.doubleToLongBits(_Ks) != Double.doubleToLongBits(other._Ks))
			return false;
		if (Double.doubleToLongBits(_Kt) != Double.doubleToLongBits(other._Kt))
			return false;
		if (_nShininess != other._nShininess)
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	



}
