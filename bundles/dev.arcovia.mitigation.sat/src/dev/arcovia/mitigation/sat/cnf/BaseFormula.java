package dev.arcovia.mitigation.sat.cnf;

import dev.arcovia.mitigation.sat.Constraint;
import dev.arcovia.mitigation.sat.cnf.nodes.BranchNode;

import java.util.ArrayList;
import java.util.List;

public class BaseFormula {
	private final BranchNode root;
    private final LiteralCounter counter = new LiteralCounter();
    private final LiteralCounter allocated = new LiteralCounter();

	public BaseFormula(BranchNode root) {
		this.root = root;
	}

    public LiteralCounter getCounter() {
        return counter;
    }

    public LiteralCounter getAllocated() {
        return allocated;
    }
	
	public Constraint[] toCNF() {
        var constraint = new Constraint(new ArrayList<>());
        var size = counter.count() / 2;
        var result = new Constraint[size*size+1];
        result[allocated.increment()] =  constraint;
        var activeClauses = new ArrayList<>(List.of(constraint));

		root.collectCNFClauses(result, activeClauses, allocated);

        if (allocated.count() == 1 && result[1].literals().isEmpty()) {
            return new Constraint[0];
        }
        return result;
	}

    @Override
    public String toString() {
        return root.toString();
    }
}
