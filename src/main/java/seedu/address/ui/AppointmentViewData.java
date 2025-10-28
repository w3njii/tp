package seedu.address.ui;

import seedu.address.model.appointment.Appointment;

/**
 * A simple data holder class combining an Appointment with the patient's name
 * for display purposes in the UI.
 * This class facilitates passing both the appointment details and the associated patient's name
 * together to UI components like list cells.
 */
public class AppointmentViewData {
    private final Appointment appointment;
    private final String patientName;

    /**
     * Constructs an {@code AppointmentViewData} object.
     *
     * @param appointment The {@code Appointment} object containing appointment details. Must not be null.
     * @param patientName The full name of the patient for this appointment. Must not be null.
     */
    public AppointmentViewData(Appointment appointment, String patientName) {
        // Basic null checks could be added here if desired, e.g., using requireNonNull
        this.appointment = appointment;
        this.patientName = patientName;
    }

    /**
     * Returns the {@code Appointment} object associated with this view data.
     *
     * @return The {@code Appointment} object.
     */
    public Appointment getAppointment() {
        return appointment;
    }

    /**
     * Returns the full name of the patient associated with this appointment view data.
     *
     * @return The patient's full name as a String.
     */
    public String getPatientName() {
        return patientName;
    }
}
