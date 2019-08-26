package elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public interface LightSource {

    public Color getIntensity(Point3D point) throws Exception;
    public Vector getL(Point3D point);

}
