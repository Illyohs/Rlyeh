package us.illyohs.rlyeh.util;

import net.minecraft.world.World;
import us.illyohs.rlyeh.util.ExtendedPos;

import java.util.HashSet;

public class ShapeFuntions {

    //Move to elliptical fuction and make this a wrapper method
    public static HashSet<ExtendedPos> getSphere(ExtendedPos ePos, int radius) {
        float                r_squared             = (float)((radius + 0.5) * (radius + 0.5));
        World                world                 = ePos.getWorld();
        HashSet<ExtendedPos> returnSphericalvalues = new HashSet<ExtendedPos>();

        int bottem  = Math.max(- radius - 1, - 1 * (ePos.getY() - 1));
        int top     = Math.min(radius + 1, (world.getHeight() - 1 - ePos.getY()));
        for (int y = bottem; y < top; y++) {
            for (int z = -radius -1; z < radius + 1;  z++) {
                for (int x = -radius - 1; x < radius + 1; x++) {
                    if ((x * x) + (y * y) + (z * z) < r_squared) {
                       returnSphericalvalues.add(new ExtendedPos(world, ePos.getX() + x, ePos.getY() + y, ePos.getZ() + z));
                    }
                }
            }
        }

        return returnSphericalvalues;
    }

    public static HashSet<ExtendedPos> getSphericalShell(ExtendedPos ePos, int radius) {
        HashSet<ExtendedPos> outerSphere = getSphere(ePos, radius);
        HashSet<ExtendedPos> innerSphere = getSphere(ePos, radius);
        outerSphere.removeAll(innerSphere);
        return outerSphere;
    }

//    public static HashSet<ExtendedPos> getEllipse(ExtendedPos ePos, int hight, int width) {
//        World world = ePos.getWorld();
//        HashSet<ExtendedPos> returnEllipticalValues = new HashSet<ExtendedPos>();
//        return returnEllipticalValues;
//    }

//    public static void getSquare(ExtendedPos ePos, int i) {
//        getRectangularPrism(ePos, i, i, i);
//    }

//    public static HashSet<ExtendedPos> getRectangularPrism(ExtendedPos ePos, int Lenghth, int width, int hight) {
//        World world = ePos.getWorld();
//        HashSet<ExtendedPos> returnRectangularValues = new HashSet<ExtendedPos>();
//        return returnRectangularValues;
//    }

//    public static HashSet<ExtendedPos> getPyramid(ExtendedPos ePos, int base, int width, int hight) {
//        World world = ePos.getWorld();
//        HashSet<ExtendedPos> returnPyramidValuse = new HashSet<ExtendedPos>();
//        return returnPyramidValuse;
//    }
}
