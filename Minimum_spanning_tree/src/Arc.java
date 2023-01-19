import java.awt.*;

public class Arc {

    private Node start;
    private Node end;



    private int cost=0;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }




    public Node getEnd() {
        return end;
    }

    public Node getStart() {
        return start;
    }

    public Arc(Node start, Node end) {
        this.start=start;
        this.end=end;
    }

    public void drawArc(Graphics g)
    {
        if(start!=null)
        {
            g.setColor(Color.BLUE);
            g.drawLine(start.getCoordX()+myPanel.nodeDiam/2,start.getCoordY()+myPanel.nodeDiam/2,end.getCoordX()+myPanel.nodeDiam/2,end.getCoordY()+myPanel.nodeDiam/2);
        }
    }

    public void drawArcWithCost(Graphics g)
    {
        if(start!=null)
        {
            g.setColor(Color.BLUE);
            int x1,x2,y1,y2;
            x1=start.getCoordX()+myPanel.nodeDiam/2;
            y1=start.getCoordY()+myPanel.nodeDiam/2;
            x2=end.getCoordX()+myPanel.nodeDiam/2;
            y2=end.getCoordY()+myPanel.nodeDiam/2;
            g.drawLine(x1,y1,x2,y2);
            g.setFont(new Font("TimesRoman",Font.BOLD,17));
            g.setColor(Color.BLACK);
            g.drawString(((Integer)cost).toString(),(x1+x2)/2,(y1+y2)/2);
        }
    }

    public void drawArrow(Graphics g) {
        if (start != null) {
            int heightArrow = 20;
            int widthArrow = 20;
            int xDifference = end.getCoordX() - start.getCoordX();
            int yDifference = end.getCoordY() - start.getCoordY();
            double D = Math.sqrt(xDifference * xDifference + yDifference * yDifference);
            double xm = D - heightArrow,
                    xn = xm,
                    ym = widthArrow,
                    yn = -widthArrow,
                    x;
            double sin = yDifference / D,
                    cos = xDifference / D;

            x = xm * cos - ym * sin + start.getCoordX()+myPanel.nodeDiam/2;
            ym = xm * sin + ym * cos + start.getCoordY()+myPanel.nodeDiam/2;
            xm = x;

            x = xn * cos - yn * sin + start.getCoordX()+myPanel.nodeDiam/2;
            yn = xn * sin + yn * cos + start.getCoordY()+myPanel.nodeDiam/2;
            xn = x;

            int[] xpoints = {end.getCoordX()+myPanel.nodeDiam/2, (int) xm, (int) xn};
            int[] ypoints = {end.getCoordY()+myPanel.nodeDiam/2, (int) ym, (int) yn};

            g.setColor(Color.BLUE);
            g.drawLine(start.getCoordX()+myPanel.nodeDiam/2, start.getCoordY()+myPanel.nodeDiam/2, end.getCoordX()+myPanel.nodeDiam/2, end.getCoordY()+myPanel.nodeDiam/2);
            g.fillPolygon(xpoints, ypoints, 3);
        }
    }
}
