package model.problem;

import java.util.List;

public class AntChromosome extends Chromosome {
    public AntChromosome(List<AntGene> genes){
        super(genes);
    }
    public AntChromosome(){super();}

    @Override
    public String toString() {
        int movesToRightMade = 0;
        StringBuilder builder = new StringBuilder();
        List<AntGene> genes = getGenes();
        builder.append("Chromosome! - result: " + this.getChromosomeFitnessValue()).append("\n");
        for(int i = 0; i < genes.size() - 1; i ++){//last move does not need to be shown
            if(genes.get(i).getAntMove() == AntMove.DOWN) {
                builder.append("|").append("\n");
                for (int j = 0; j < movesToRightMade; j++)
                    builder.append(" ").append(" ");
            }
            else {
                builder.append("->");
                movesToRightMade++;
            }
        }
        builder.append("\n");
        return builder.toString();
    }

}