public class Prices {
    public double Labor;
    public double Posts;
    public double Rails;
    public double ConcreteBags;
    public double Panels;
    public double NailBoxes;
    public double TotalMaterialCost;
    public double Total;

    Prices (int length, int posts, int rails, int concreteBags, int panels, int nailBoxes) {
        Labor = (length / 10) * 25;
        Posts = posts * 9.27;
        Rails = rails * 2.49;
        ConcreteBags = concreteBags * 4.15;
        Panels = panels * 1.21;
        NailBoxes = nailBoxes * 5.25;

        TotalMaterialCost =  Posts + Rails + ConcreteBags + Panels + NailBoxes;
        Total = TotalMaterialCost + Labor;
    }
}
