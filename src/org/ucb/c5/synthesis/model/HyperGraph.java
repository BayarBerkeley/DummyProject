package src.org.ucb.c5.synthesis.model;

import java.util.*;

public class HyperGraph {

    private final HashMap<Reaction, Integer> reactionToShell;
    private final HashMap<Chemical, Integer> chemicalToShell;
    private final HashMap<Chemical, Cascade> chemicalToCascade;

    public HyperGraph(HashMap<Reaction, Integer> reactionToShell, 
                      HashMap<Chemical, Integer> chemicalToShell) {

        this.reactionToShell = reactionToShell;
        this.chemicalToShell = chemicalToShell;


        chemicalToCascade = new HashMap<Chemical, Cascade>();
        for (Chemical c : chemicalToShell.keySet()) {
            Set<Reaction> cascSet = new HashSet<Reaction>();
            for (Reaction r : reactionToShell.keySet()) {
                if (r.getProducts().contains(c)) {
                    cascSet.add(r);
                }
            }
            Cascade casc = new Cascade(c, cascSet);
            chemicalToCascade.put(c, casc);
        }

    }


    public HashMap<Reaction, Integer> getReactionToShell() {
        return reactionToShell;
    }

    public HashMap<Chemical, Integer> getChemicalToShell() {
        return chemicalToShell;
    }

    public HashMap<Chemical, Cascade> getChemicalToCascade() {
        return chemicalToCascade;
    }
}
