package com.oceanfleet.ui;

import com.oceanfleet.model.Vessel;
import com.oceanfleet.util.VesselUtil;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VesselUtil vesselUtil = new VesselUtil();

        // Input number of vessels
        System.out.println("Enter the number of vessels to be added");
        int numberOfVessels = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Input vessel details
        System.out.println("Enter vessel details");
        for (int i = 0; i < numberOfVessels; i++) {
            String input = scanner.nextLine();
            String[] details = input.split(":");

            String vesselId = details[0];
            String vesselName = details[1];
            double averageSpeed = Double.parseDouble(details[2]);
            String vesselType = details[3];

            Vessel vessel = new Vessel(vesselId, vesselName, averageSpeed, vesselType);
            vesselUtil.addVesselPerformance(vessel);
        }

        // Input vessel ID to check speed
        System.out.println("Enter the Vessel Id to check speed");
        String searchVesselId = scanner.nextLine();

        Vessel foundVessel = vesselUtil.getVesselById(searchVesselId);
        if (foundVessel != null) {
            System.out.println(foundVessel.getVesselId() + " | " +
                    foundVessel.getVesselName() + " | " +
                    foundVessel.getVesselType() + " | " +
                    foundVessel.getAverageSpeed() + " knots");
        } else {
            System.out.println("Vessel Id " + searchVesselId + " not found");
        }

        // Display high performance vessels
        System.out.println("High performance vessels are");
        List<Vessel> highPerformanceVessels = vesselUtil.getHighPerformanceVessels();
        for (Vessel vessel : highPerformanceVessels) {
            System.out.println(vessel.getVesselId() + " | " +
                    vessel.getVesselName() + " | " +
                    vessel.getVesselType() + " | " +
                    vessel.getAverageSpeed() + " knots");
        }

        scanner.close();
    }
}
