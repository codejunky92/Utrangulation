import java.awt.*;
import static java.lang.Math.*;
import static java.lang.StrictMath.toDegrees;

public class UIntersection extends Thread
{
    private int xUWB1 = 6, yUWB1 = 6;
    private int xUWB2 = 6, yUWB2 = 13;
    private int deltaX = (xUWB2-xUWB1);
    private int deltaY = (yUWB2-yUWB1);
    private double c;

    private double userLocationPointX1, userLocationPointY1;
    private double userLocationPointX2, userLocationPointY2;

    public UIntersection()
    {

    }

    @Override
    public void run()
    {
        //while(true)
        //{
            createIntersectionPoints(8, 5);
            try
            {
                sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        //}
    }

    public void createIntersectionPoints(double rUWB1, double rUWB2)
    {
        double alphaAngleDegree = toDegrees(acos((pow(rUWB1,2) + pow(getC(),2) - pow(rUWB2,2)) / (2*rUWB1*getC())));

        //get (x3,y3) coordinates
        double correctionAngle = toDegrees(atan(((double)deltaY)/((double)deltaX)));
        double calculationAngle = alphaAngleDegree+correctionAngle;
        userLocationPointX1 = rUWB1 * cos(toRadians(calculationAngle)) + xUWB1;
        userLocationPointY1 = rUWB1 * sin(toRadians(calculationAngle)) + yUWB1;

        //get (x4,x4) coordinates
        double calculationAngle2 = 90 - calculationAngle + 2*alphaAngleDegree;
        userLocationPointX2 = rUWB1 * sin(toRadians(calculationAngle2)) + xUWB1;
        userLocationPointY2 = rUWB1 * cos(toRadians(calculationAngle2)) + yUWB1;

        System.out.println("P3("+(float)userLocationPointX1+", "+(float)userLocationPointY1+")");
        System.out.println("P4("+(float)userLocationPointX2+", "+(float)userLocationPointY2+")");
    }

    public double getC()
    {
        if((yUWB2-yUWB1)==0)
        {
            c = deltaX;
        }
        else
        {
            c = sqrt(pow((deltaX),2) + pow((deltaY),2));
        }

        return c;
    }

    public double getUserLocationPointX1()
    {
        return userLocationPointX1;
    }

    public double getUserLocationPointY1()
    {
        return userLocationPointY1;
    }

    public double getUserLocationPointX2()
    {
        return userLocationPointX2;
    }

    public double getUserLocationPointY2()
    {
        return userLocationPointY2;
    }

}