package model.problem;

import model.AntLogic.AntBoardField;

public class AntGene extends Gene {
    AntBoardField antBoardField;
    AntMove antMove;

    public AntGene(AntBoardField antBoardField, AntMove antMove) {
        this.antBoardField = antBoardField;
        this.antMove = antMove;
    }

    public AntBoardField getAntBoardField() {
        return antBoardField;
    }

    public void setAntBoardField(AntBoardField antBoardField) {
        this.antBoardField = antBoardField;
    }

    public AntMove getAntMove() {
        return antMove;
    }

    public void setAntMove(AntMove antMove) {
        this.antMove = antMove;
    }
}
