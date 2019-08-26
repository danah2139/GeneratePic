package scene;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import elements.AmbientLight;
import elements.Camera;
import elements.LightSource;
import geometries.Geometry;
import elements.Light;



public class Scene {
	
	protected String _sceneName;
	protected Color _background;
	protected AmbientLight _ambientLight;
	protected List<Geometry> _geometries;
	protected List<LightSource> _lights;
	protected Camera _camera;
	protected double _screenDistance;
	
	// ***************** Constructors ********************** // 

	
	
	public Scene(String _sceneName, Color _background, AmbientLight _ambientLight, List<Geometry> _geometries,
			Camera _camera, double _screenDistance) {
		super();
		this._sceneName = _sceneName;
		this._background = _background;
        this._ambientLight =new AmbientLight(_ambientLight.getColor(),_ambientLight.get_ka());
        if(!_geometries.isEmpty())
            this._geometries=_geometries;
        else 
            this._geometries=new ArrayList<Geometry>();		
        this._camera = new Camera(_camera.get_P0(),_camera.get_vTo(),_camera.get_vRight(),_camera.get_vUp());
		this._screenDistance = _screenDistance;
	}


	public Scene() {
		super();
		this._sceneName = "My Scene";
		this._background = new Color(0,0,0);
		this._ambientLight = new AmbientLight();
		this._geometries = new ArrayList<Geometry>();;
		this._camera = new Camera();
		this._screenDistance = 100;
        this._lights=new ArrayList<LightSource>();

	}
	
    
 public Scene(Scene scene) {
	 this._sceneName =scene.get_sceneName();
     this._background = scene.get_background();
     this._ambientLight =new AmbientLight(scene.get_ambientLight().getColor(),scene.get_ambientLight().get_ka());
     if(!scene.get_geometries().isEmpty())
         this._geometries=scene.get_geometries();
     else 
         this._geometries=scene.get_geometries();
     this._camera = new Camera(scene.get_camera().get_P0(),scene.get_camera().get_vTo(),scene.get_camera().get_vRight(),scene.get_camera().get_vUp());
     this._screenDistance = scene.get_screenDistance();
     this._lights=scene._lights;//?????
 
	}
	
	// ***************** Getters/Setters ********************** // 



	public String get_sceneName() {
		return _sceneName;
	}


	public void set_sceneName(String _sceneName) {
		this._sceneName = _sceneName;
	}


	public Color get_background() {
		return _background;
	}


	public void set_background(Color _background) {
		this._background = _background;
	}


	public AmbientLight get_ambientLight() {
		return _ambientLight;
	}


	public void set_ambientLight(AmbientLight _ambientLight) {
		this._ambientLight = _ambientLight;
	}


	public List<Geometry> get_geometries() {
		return _geometries;
	}


	public void set_geometries(List<Geometry> _geometries) {
		this._geometries = _geometries;
	}


	public Camera get_camera() {
		return _camera;	}


	public void set_camera(Camera _camera) {
		this._camera = _camera;
	}


	public double get_screenDistance() {
		return _screenDistance;
	}


	public void set_screenDistance(double _screenDistance) {
		this._screenDistance = _screenDistance;
	}

	
	public List<LightSource> get_lights() {
		return new ArrayList<LightSource>(_lights);	}


	public void set_lights(List<LightSource> _lights) {
        this._lights = new ArrayList<LightSource>(_lights);//?????
	}


	public Iterator<Geometry>getGeometriesIterator(){
		return _geometries.iterator();
	}
	
	public Iterator<LightSource>getLightIterator()
    {
      return this._lights.iterator();
    }
	// ***************** Operations ******************** // 

	
	public void addGeometry(Geometry geometry){
		_geometries.add(geometry);
	}
	public void addLight(LightSource light)
    {
        this._lights.add(light);
        
    }


	@Override
	public String toString() {
		return "Scene [_sceneName=" + _sceneName + ", _background=" + _background + ", _ambientLight=" + _ambientLight
				+ ", _geometries=" + _geometries + ", _lights=" + _lights + ", _camera=" + _camera
				+ ", _screenDistance=" + _screenDistance + "]";
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Scene other = (Scene) obj;
		if (_ambientLight == null) {
			if (other._ambientLight != null)
				return false;
		} else if (!_ambientLight.equals(other._ambientLight))
			return false;
		if (_background == null) {
			if (other._background != null)
				return false;
		} else if (!_background.equals(other._background))
			return false;
		if (_camera == null) {
			if (other._camera != null)
				return false;
		} else if (!_camera.equals(other._camera))
			return false;
		if (_geometries == null) {
			if (other._geometries != null)
				return false;
		} else if (!_geometries.equals(other._geometries))
			return false;
		if (_lights == null) {
			if (other._lights != null)
				return false;
		} else if (!_lights.equals(other._lights))
			return false;
		if (_sceneName == null) {
			if (other._sceneName != null)
				return false;
		} else if (!_sceneName.equals(other._sceneName))
			return false;
		if (Double.doubleToLongBits(_screenDistance) != Double.doubleToLongBits(other._screenDistance))
			return false;
		return true;
	}
	

}
