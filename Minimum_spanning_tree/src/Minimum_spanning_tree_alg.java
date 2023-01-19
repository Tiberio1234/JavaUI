import java.util.*;

public class Minimum_spanning_tree_alg {

    static class CustomArcComparator implements Comparator<Arc> {

        @Override
        public int compare(Arc a1, Arc a2) {
            return a1.getCost() > a2.getCost() ? 1 : -1;
        }
    }

    static class CustomNodeComparator implements Comparator<Node> {

        @Override
        public int compare(Node n1, Node n2) {
            return n1.getCost() > n2.getCost() ? 1 : -1;
        }
    }

    static void read_costs(Vector<Arc> listaArce)
    {
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<listaArce.size();i++) {
            System.out.print("Enter the cost of the arc: " + listaArce.elementAt(i).getStart().getNumber() +
                    " -> " + listaArce.elementAt(i).getEnd().getNumber() + "  ");
            int cost=sc.nextInt();
            listaArce.elementAt(i).setCost(cost);
        }
    }

    static void kruskal(Vector<Node> listaNoduri, Vector<Arc> listaArce)
    {
        HashMap<Node,Integer> forest = new HashMap<>();
        Queue<Arc> arcs = new PriorityQueue<>(new CustomArcComparator());

        for(int i=0;i<listaNoduri.size();i++)
        {
            forest.put(listaNoduri.elementAt(i),listaNoduri.elementAt(i).getNumber());
        }

        for(int i=0;i<listaArce.size();i++)
        {
            arcs.add(listaArce.elementAt(i));
        }

        while(!arcs.isEmpty())
        {
            Arc arc=arcs.poll();
            if(forest.get(arc.getStart()) != forest.get(arc.getEnd()))
            {
                int value = forest.get(arc.getStart());
                Set s = forest.entrySet();
                Iterator i = s.iterator();
                while (i.hasNext()) {
                    Map.Entry m = (Map.Entry)i.next();
                    if((Integer)m.getValue() == value)
                    m.setValue(forest.get(arc.getEnd()));

                }
            }
            else listaArce.remove(arc);

        }


    }

    static Vector<Arc> Prim(Vector<Node> listaNoduri, Vector<Arc> listaArce)
    {
        Queue<Node> min_prioQ= new PriorityQueue<>(new CustomNodeComparator());
        Vector<Arc> arcs = new Vector<>();
        Vector<Arc> arcs1 = new Vector<>();


        for(int i=0;i<listaArce.size();i++)
        {
            arcs.add(listaArce.elementAt(i));
            arcs1.add(null);
        }

        for(int i=0;i<listaNoduri.size();i++)
        {
           listaNoduri.elementAt(i).setCost(Integer.MAX_VALUE);
        }

        listaNoduri.firstElement().setCost(0);
        min_prioQ.add(listaNoduri.firstElement());

        while(!min_prioQ.isEmpty())
        {
            Node prioQ_nod =min_prioQ.peek();
            min_prioQ.remove();

            for(int i=0;i<arcs.size();i++)
            {
                if(arcs.elementAt(i).getStart()==prioQ_nod || arcs.elementAt(i).getEnd()==prioQ_nod )
                {
                    Node lastN;
                    if(arcs.elementAt(i).getStart()==prioQ_nod)
                    {
                        lastN=arcs.elementAt(i).getEnd();
                    }
                    else {
                        lastN=arcs.elementAt(i).getStart();
                    }
                    if(lastN.getCost()>arcs.elementAt(i).getCost()) {
                        lastN.setCost(arcs.elementAt(i).getCost());
                        min_prioQ.add(lastN);
                        arcs1.set(lastN.getNumber(),arcs.elementAt(i));
                    }
                    arcs.remove(arcs.elementAt(i));
                    i--;
                }

            }

        }

        return arcs1;
    }
}
