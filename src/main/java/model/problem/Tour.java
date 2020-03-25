package model.problem;

import java.util.ArrayList;
import java.util.List;

public class Tour extends Chromosome<City> {
    public Tour(List<City> genes) {
        super(genes);
    }

    public Tour() {
        super();
    }

    public int tourSize() {
        return this.getGenes().size();
    }

    public City getCity(int i) {
        return this.getGenes().get(i);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Gene gene : genes){
            sb.append(gene.toString());
            sb.append(", ");
        }
        sb.setCharAt(sb.length()-2,']');
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();

    }
}
