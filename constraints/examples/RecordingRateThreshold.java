package constraints.procedures;

import gov.nasa.ammos.plandev.procedural.constraints.Constraint;
import gov.nasa.ammos.plandev.procedural.constraints.annotations.ConstraintProcedure;
import gov.nasa.ammos.plandev.procedural.constraints.Violations;
import gov.nasa.ammos.plandev.procedural.timeline.collections.profiles.Real;
import gov.nasa.ammos.plandev.procedural.timeline.plan.Plan;
import gov.nasa.ammos.plandev.procedural.timeline.plan.SimulationResults;

@ConstraintProcedure
public record RecordingRateThreshold(int threshold) implements Constraint {
  @Override
  public Violations run(Plan plan, SimulationResults simResults) {
    final var rate = simResults.resource("RecordingRate", Real.deserializer());

    return Violations.on(
      rate.greaterThan(threshold),
      true
    );
  }
}
