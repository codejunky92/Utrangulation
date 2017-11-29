import java.awt.*;

import static java.lang.Math.*;
import static java.lang.StrictMath.toDegrees;

public class UIntersection
{
    private Point firstCircleCenterPoint;
    private Point secondCircleCenterPoint;
    public Point intersectionPoint;

    private int x1 = 0;
    private int x2 = 6;
    private int y1 = 0;
    private int y2 = 6;


    private double r1b = 4;
    private double r2a = 5;
    private double c;

    public UIntersection()
    {
        firstCircleCenterPoint = new Point(x1,y1);
        secondCircleCenterPoint = new Point(x2,y2);
    }

    public void createIntersectionPoint()
    {
        double cosAlpha = (pow(r2a,2)-pow(r1b,2)-pow(getC(),2))/(-2*r1b*getC());
        double alpha = toDegrees(acos(cosAlpha));
        //System.out.println(alpha);
        double corigeren = toDegrees(atan(y2/x2));
        double x = sin(alpha+corigeren)*r1b;
        double y = sin(alpha)*r1b;
        System.out.println(x);
        intersectionPoint = new Point((int)x,(int)y);
    }

    public double getC()
    {
        if((y2-y1)==0)
        {
            c = x2-x1;
        }
        else
        {
            c = sqrt(pow((x2-x1),2)+pow((y2-y1),2));
            //System.out.println(c);
        }

        return c;
    }

}