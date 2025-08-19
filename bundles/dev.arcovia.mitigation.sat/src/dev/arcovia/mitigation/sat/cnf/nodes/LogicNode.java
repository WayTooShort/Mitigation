package dev.arcovia.mitigation.sat.cnf.nodes;

import java.util.List;

import dev.arcovia.mitigation.sat.Constraint;
import dev.arcovia.mitigation.sat.cnf.LiteralCounter;
import org.eclipse.equinox.http.servlet.internal.util.Const;

public abstract class LogicNode {
	protected final LogicNodeDescriptor descriptor;
	
	public LogicNode(LogicNodeDescriptor descriptor) {
		this.descriptor = descriptor;
	}
	
	public abstract void collectCNFClauses(Constraint[] result, List<Constraint> activeClauses, LiteralCounter allocated);
}
