package com.oceanfleet.util;

import com.oceanfleet.model.Vessel;
import java.util.ArrayList;
import java.util.List;

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

}
