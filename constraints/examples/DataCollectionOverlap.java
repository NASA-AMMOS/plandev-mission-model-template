package constraints.procedures;

import gov.nasa.ammos.plandev.procedural.constraints.Constraint;
import gov.nasa.ammos.plandev.procedural.constraints.Violations;
import gov.nasa.ammos.plandev.procedural.constraints.annotations.ConstraintProcedure;
import gov.nasa.ammos.plandev.procedural.timeline.plan.Plan;
import gov.nasa.ammos.plandev.procedural.timeline.plan.SimulationResults;

@ConstraintProcedure
public record DataCollectionOverlap() implements Constraint {
  @Override
  public Violations run(Plan plan, SimulationResults simResults) {
    return Violations.on(
      simResults.instances("CollectData").countActive().greaterThan(1),
      true);
  }
}
