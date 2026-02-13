package com.oceanfleet.util;

import com.oceanfleet.model.Vessel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class VesselUtil {
    private List<Vessel> vesselList;

    // Constructor
    public VesselUtil() {
        this.vesselList = new ArrayList<>();
    }

    // Getter
    public List<Vessel> getVesselList() {
        return vesselList;
    }

    // Setter
    public void setVesselList(List<Vessel> vesselList) {
        this.vesselList = vesselList;
    }

    // UC2: Add Vessel performance details
    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }
    // UC3: Retrieve vessel by vesselId
    public Vessel getVesselById(String vesselId) {
        for (Vessel vessel : vesselList) {
            if (vessel.getVesselId().equals(vesselId)) {
                return vessel;
            }
        }
        return null;
    }
    // UC4: Retrieve high performance vessels
    public List<Vessel> getHighPerformanceVessels() {
        if (vesselList.isEmpty()) {
            return new ArrayList<>();
        }

        // Find maximum average speed
        double maxSpeed = vesselList.stream()
                .mapToDouble(Vessel::getAverageSpeed)
                .max()
                .orElse(0.0);

        // Return all vessels with maximum speed
        return vesselList.stream()
                .filter(vessel -> vessel.getAverageSpeed() == maxSpeed)
                .collect(Collectors.toList());
    }



}
