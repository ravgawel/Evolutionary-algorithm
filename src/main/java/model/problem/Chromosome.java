package model.problem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public abstract class Chromosome <T extends Gene> implements Comparable<Chromosome>{


    private float chromosomeFitnessValue;

     List<T> genes;

    public int compareTo(Chromosome chr) {
        return (int)this.chromosomeFitnessValue - (int)chr.chromosomeFitnessValue;
    }

    public Chromosome(List<T> genes){
        this.genes=genes;
    }

    public Chromosome() {
        this.genes = new ArrayList<T>();
    }

    @Override
    public String toString(){
        StringBuilder sb =new StringBuilder();
        sb.append("[");
        for(Gene gene : genes){
            sb.append(gene.toString());
            sb.append("|");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public List<T> getGenes() {
        return genes;
    }

    public void setGenes(List<T> genes) {
        this.genes = genes;
    }

    public float getChromosomeFitnessValue() {
        return chromosomeFitnessValue;
    }

    public void setChromosomeFitnessValue(float chromosomeFitnessValue) {
        this.chromosomeFitnessValue = chromosomeFitnessValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chromosome<?> that = (Chromosome<?>) o;
        return Objects.equals(getGenes(), that.getGenes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGenes());
    }
}
