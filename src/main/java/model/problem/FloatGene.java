package model.problem;

import java.util.Objects;

public class FloatGene extends Gene {

    private float value;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public FloatGene(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "("+value+")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FloatGene floatGene = (FloatGene) o;
        return Float.compare(floatGene.getValue(), getValue()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
