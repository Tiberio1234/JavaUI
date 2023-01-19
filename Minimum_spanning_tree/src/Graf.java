import javax.swing.*; //sa ma uit



public class Graf {

    private static void initializare()
    {
        JFrame j = new JFrame("Alg graf");

        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        j.add(new myPanel());

        j.setSize(700,800);

        j.setVisible(true);

    }

    public static  void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initializare();
            }
        });
    }
}
